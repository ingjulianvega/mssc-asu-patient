package ingjulianvega.ximic.msscasupatient.services;

import ingjulianvega.ximic.msscasupatient.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasupatient.domain.PatientEntity;
import ingjulianvega.ximic.msscasupatient.domain.repositories.PatientRepository;
import ingjulianvega.ximic.msscasupatient.exception.PatientException;
import ingjulianvega.ximic.msscasupatient.web.Mappers.DateMapper;
import ingjulianvega.ximic.msscasupatient.web.Mappers.PatientMapper;
import ingjulianvega.ximic.msscasupatient.web.model.Patient;
import ingjulianvega.ximic.msscasupatient.web.model.PatientDto;
import ingjulianvega.ximic.msscasupatient.web.model.PatientList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final DateMapper dateMapper;


    @Cacheable(cacheNames = "patientListCache")
    @Override
    public PatientList get() {
        log.debug("get()...");
        return PatientList
                .builder()
                .patientDtoList(patientMapper.patientEntityListToPatientDtoList(patientRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "patientCache")
    @Override
    public PatientDto getById(UUID id) {
        log.debug("getById()...");
        return patientMapper.patientEntityToPatientDto(
                patientRepository.findById(id)
                        .orElseThrow(() -> new PatientException(ErrorCodeMessages.PATIENT_NOT_FOUND, "")));
    }

    @Override
    public PatientList getByDocumentNumber(String documentId) {
        log.debug("getByDocumentNumber()...");
        return PatientList
                .builder()
                .patientDtoList(patientMapper.patientEntityListToPatientDtoList(patientRepository.findByDocumentNumberContaining(documentId)))
                .build();
    }

    @Override
    public PatientList getByFirstLastName(String firstLastName) {
        log.debug("getByFirstLastName()...");
        return PatientList
                .builder()
                .patientDtoList(patientMapper.patientEntityListToPatientDtoList(patientRepository.findByFirstLastNameContainingIgnoreCase(firstLastName)))
                .build();
    }

    @Override
    public void create(Patient patient) {
        log.debug("create()...");
        patientMapper.patientEntityToPatientDto(
                patientRepository.save(
                        patientMapper.patientDtoToPatientEntity(
                                PatientDto
                                        .builder()
                                        .documentTypeId(patient.getDocumentTypeId())
                                        .documentNumber(patient.getDocumentNumber())
                                        .name(patient.getName())
                                        .firstLastName(patient.getFirstLastName())
                                        .secondLastName(patient.getSecondLastName())
                                        .birthDate(patient.getBirthDate())
                                        .hand(patient.getHand())
                                        .address(patient.getAddress())
                                        .maritalStatusId(patient.getMaritalStatusId())
                                        .genderId(patient.getGenderId())
                                        .occupationId(patient.getOccupationId())
                                        .homePhone(patient.getHomePhone())
                                        .mobilePhone(patient.getMobilePhone())
                                        .epsId(patient.getEpsId())
                                        .arlId(patient.getArlId())
                                        .email(patient.getEmail())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Patient patient) {
        log.debug("updateById...");
        PatientEntity companionEntity = patientRepository.findById(id)
                .orElseThrow(() -> new PatientException(ErrorCodeMessages.PATIENT_NOT_FOUND, ""));

        companionEntity.setDocumentTypeId(patient.getDocumentTypeId());
        companionEntity.setDocumentNumber(patient.getDocumentNumber());
        companionEntity.setName(patient.getName());
        companionEntity.setFirstLastName(patient.getFirstLastName());
        companionEntity.setSecondLastName(patient.getSecondLastName());
        companionEntity.setBirthDate(dateMapper.asTimestamp(patient.getBirthDate()));
        companionEntity.setHand(patient.getHand());
        companionEntity.setAddress(patient.getAddress());
        companionEntity.setMaritalStatusId(patient.getMaritalStatusId());
        companionEntity.setGenderId(patient.getGenderId());
        companionEntity.setOccupationId(patient.getOccupationId());
        companionEntity.setHomePhone(patient.getHomePhone());
        companionEntity.setMobilePhone(patient.getMobilePhone());
        companionEntity.setEpsId(patient.getEpsId());
        companionEntity.setArlId(patient.getArlId());
        companionEntity.setEmail(patient.getEmail());

        patientRepository.save(companionEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        patientRepository.deleteById(id);
    }
}
