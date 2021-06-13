package ingjulianvega.ximic.msscasupatient.services;


import ingjulianvega.ximic.msscasupatient.web.model.Patient;
import ingjulianvega.ximic.msscasupatient.web.model.PatientDto;
import ingjulianvega.ximic.msscasupatient.web.model.PatientList;

import java.util.UUID;

public interface PatientService {
    PatientList get(Boolean usingCache);

    PatientDto getById(UUID id);

    PatientList getByDocumentNumber(String documentId);

    PatientList getByFirstLastName(String firstLastName);

    void create(Patient patient);

    void updateById(UUID id, Patient patient);

    void deleteById(UUID id);

}
