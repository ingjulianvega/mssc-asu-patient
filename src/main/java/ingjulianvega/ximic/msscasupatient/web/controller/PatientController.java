package ingjulianvega.ximic.msscasupatient.web.controller;


import ingjulianvega.ximic.msscasupatient.services.PatientService;
import ingjulianvega.ximic.msscasupatient.web.model.Patient;
import ingjulianvega.ximic.msscasupatient.web.model.PatientDto;
import ingjulianvega.ximic.msscasupatient.web.model.PatientList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PatientController implements PatientI {

    private final PatientService patientService;

    @Override
    public ResponseEntity<PatientList> get() {
        return new ResponseEntity<>(patientService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientList> getByDocumentNumber(String documentId) {
        return new ResponseEntity<>(patientService.getByDocumentNumber(documentId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientList> getByFirstLastName(String firstLastName) {
        return new ResponseEntity<>(patientService.getByFirstLastName(firstLastName), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Patient patient) {
        patientService.create(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Patient patient) {
        patientService.updateById(id, patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        patientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
