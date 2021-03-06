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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final DateMapper dateMapper;


    @Cacheable(cacheNames = "patientListCache", condition = "#usingCache == false")
    @Override
    public PatientList get(Boolean usingCache) {
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
                        .orElseThrow(() -> PatientException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.PATIENT_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.PATIENT_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.PATIENT_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.PATIENT_NOT_FOUND_SOLUTION)
                                .build()));
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
                                        .bloodType(patient.getBloodType())
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
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> PatientException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.PATIENT_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.PATIENT_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.PATIENT_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.PATIENT_NOT_FOUND_SOLUTION)
                        .build()
                        );

        patientEntity.setDocumentTypeId(patient.getDocumentTypeId());
        patientEntity.setDocumentNumber(patient.getDocumentNumber());
        patientEntity.setName(patient.getName());
        patientEntity.setFirstLastName(patient.getFirstLastName());
        patientEntity.setSecondLastName(patient.getSecondLastName());
        patientEntity.setBirthDate(dateMapper.asTimestamp(patient.getBirthDate()));
        patientEntity.setHand(patient.getHand());
        patientEntity.setBloodType(patient.getBloodType().toString());
        patientEntity.setAddress(patient.getAddress());
        patientEntity.setMaritalStatusId(patient.getMaritalStatusId());
        patientEntity.setGenderId(patient.getGenderId());
        patientEntity.setOccupationId(patient.getOccupationId());
        patientEntity.setHomePhone(patient.getHomePhone());
        patientEntity.setMobilePhone(patient.getMobilePhone());
        patientEntity.setEpsId(patient.getEpsId());
        patientEntity.setArlId(patient.getArlId());
        patientEntity.setEmail(patient.getEmail());

        patientRepository.save(patientEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        patientRepository.deleteById(id);
    }
}
