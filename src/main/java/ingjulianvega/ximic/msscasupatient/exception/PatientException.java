package ingjulianvega.ximic.msscasupatient.exception;

import ingjulianvega.ximic.msscasupatient.configuration.PatientParameters;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientException {

    @Autowired
    private PatientParameters patientParameters;

    private String status;
    private String api;
    private String code;
    private String message;
    private String solution;

    public PatientException(final String status,
                            final String code,
                            final String message,
                            final String solution
                            ) {
        this.message = message;
        this.api = "mssc-asu-patient";
        this.status = status;
        this.code = code;
        this.solution = solution;
    }
}

