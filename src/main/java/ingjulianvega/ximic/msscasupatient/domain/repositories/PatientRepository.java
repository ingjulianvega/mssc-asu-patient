package ingjulianvega.ximic.msscasupatient.domain.repositories;

import ingjulianvega.ximic.msscasupatient.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<PatientEntity, UUID>, JpaSpecificationExecutor<PatientEntity> {
    List<PatientEntity> findByDocumentNumberContaining(String documentNumber);
    List<PatientEntity> findByFirstLastNameContainingIgnoreCase(String firstLastName);
}
