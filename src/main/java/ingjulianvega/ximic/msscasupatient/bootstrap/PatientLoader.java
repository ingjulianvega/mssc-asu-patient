package ingjulianvega.ximic.msscasupatient.bootstrap;

import ingjulianvega.ximic.msscasupatient.domain.PatientEntity;
import ingjulianvega.ximic.msscasupatient.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PatientLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        if (patientRepository.count() == 0) {
            loadPatientObjects();
        }
    }

    private void loadPatientObjects() {
        patientRepository.saveAll(Arrays.asList(
                PatientEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .documentNumber("1018234567")
                        .name("Pedro")
                        .firstLastName("Pérez")
                        .secondLastName("López")
                        .birthDate(new Timestamp(System.currentTimeMillis()))
                        .hand("Diestro(a)")
                        .address("Calle falsa 123")
                        .maritalStatusId(UUID.randomUUID())
                        .genderId(UUID.randomUUID())
                        .occupationId(UUID.randomUUID())
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .epsId(UUID.randomUUID())
                        .arlId(UUID.randomUUID())
                        .email("patient2@gmail.com")
                        .build(),
                PatientEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .documentNumber("1018584567")
                        .name("María")
                        .firstLastName("Peralta")
                        .secondLastName("Chavarro")
                        .birthDate(new Timestamp(System.currentTimeMillis()))
                        .hand("Surdo(a)")
                        .address("Calle falsa 123")
                        .maritalStatusId(UUID.randomUUID())
                        .genderId(UUID.randomUUID())
                        .occupationId(UUID.randomUUID())
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .epsId(UUID.randomUUID())
                        .arlId(UUID.randomUUID())
                        .email("patient2@gmail.com")
                        .build(),
                PatientEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .documentNumber("1083584567")
                        .name("Juan")
                        .firstLastName("Perdomo")
                        .secondLastName("Zambrano")
                        .birthDate(new Timestamp(System.currentTimeMillis()))
                        .hand("Surdo(a)")
                        .address("Calle falsa 123")
                        .maritalStatusId(UUID.randomUUID())
                        .genderId(UUID.randomUUID())
                        .occupationId(UUID.randomUUID())
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .epsId(UUID.randomUUID())
                        .arlId(UUID.randomUUID())
                        .email("patient3@gmail.com")
                        .build()
        ));
    }
}