package ingjulianvega.ximic.msscasupatient.exception;

import ingjulianvega.ximic.msscasupatient.configuration.PatientParameters;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientException extends RuntimeException {

    PatientParameters patientParameters;

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
        super(message);
        this.api = patientParameters.getApi();
        this.status = status;
        this.code = code;
        this.solution = solution;
    }
}

