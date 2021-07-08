package ingjulianvega.ximic.msscasupatient.exception;

import ingjulianvega.ximic.msscasupatient.configuration.PatientParameters;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PatientException extends RuntimeException {

    private HttpStatus status;
    private String code;
    private String message;
    private String solution;

    public PatientException(final HttpStatus status,
                            final String code,
                            final String message,
                            final String solution
                            ) {
        this.message = message;
        this.status = status;
        this.code = code;
        this.solution = solution;
    }
}

