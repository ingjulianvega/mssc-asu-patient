package ingjulianvega.ximic.msscasupatient.web.Mappers;


import ingjulianvega.ximic.msscasupatient.domain.PatientEntity;
import ingjulianvega.ximic.msscasupatient.web.model.PatientDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = {DateMapper.class})
public interface PatientMapper {
    PatientDto patientEntityToPatientDto(PatientEntity patientEntity);

    PatientEntity patientDtoToPatientEntity(PatientDto patientDto);

    ArrayList<PatientDto> patientEntityListToPatientDtoList(List<PatientEntity> patientEntityList);
}
