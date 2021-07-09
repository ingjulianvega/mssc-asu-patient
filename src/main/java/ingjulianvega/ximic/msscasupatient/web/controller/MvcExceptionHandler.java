package ingjulianvega.ximic.msscasupatient.web.controller;

import ingjulianvega.ximic.msscasupatient.exception.PatientException;
import ingjulianvega.ximic.msscasupatient.web.model.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

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
}