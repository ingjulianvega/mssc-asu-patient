package ingjulianvega.ximic.msscasupatient.web.controller;

import ingjulianvega.ximic.msscasupatient.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasupatient.exception.PatientException;
import ingjulianvega.ximic.msscasupatient.web.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class MvcExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PatientException.class)
    public ResponseEntity<ApiError> validationErrorHandler(PatientException pe) {
        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .api("mssc-asu-patient")
                .apiCode(pe.getApiCode())
                .error(pe.getError())
                .message(pe.getMessage())
                .solution(pe.getSolution())
                .build();
         return new ResponseEntity<>(apiError, pe.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .api("mssc-asu-patient")
                .apiCode(ErrorCodeMessages.ARGUMENT_NOT_VALID_API_CODE)
                .error(ErrorCodeMessages.ARGUMENT_NOT_VALID_ERROR)
                .message(errors.toString())
                .solution(ErrorCodeMessages.ARGUMENT_NOT_VALID_SOLUTION)
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}