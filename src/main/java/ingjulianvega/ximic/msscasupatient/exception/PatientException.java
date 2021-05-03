package ingjulianvega.ximic.msscasupatient.exception;

import lombok.Getter;

@Getter
public class PatientException extends RuntimeException {

    private final String code;

    public PatientException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

