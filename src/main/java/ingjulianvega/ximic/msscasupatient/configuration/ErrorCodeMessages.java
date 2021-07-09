package ingjulianvega.ximic.msscasupatient.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorCodeMessages {

    public static final String GENERAL_ERROR = "general-error";

    public static final String VALIDATION_NAME_NULL = "validation-name-null";

    public static final String PATIENT_NOT_FOUND_API_CODE = "401";
    public static final String PATIENT_NOT_FOUND_ERROR = "PATIENT_NOT_FOUND";
    public static final String PATIENT_NOT_FOUND_MESSAGE = "No se encontró el paciente";
    public static final String PATIENT_NOT_FOUND_SOLUTION = "Verifique los datos";
}
