package ingjulianvega.ximic.msscasupatient.web.controller;

import ingjulianvega.ximic.msscasupatient.exception.PatientException;
import ingjulianvega.ximic.msscasupatient.web.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PatientException.class)
    public ResponseEntity<ApiError> validationErrorHandler(PatientException ex) {
        ApiError apiError = ApiError
                .builder()
                .api("mssc-asu-patient")
                .status(ex.getStatus())
                .code(ex.getCode())
                .message(ex.getMessage())
                .solution(ex.getSolution())
                .build();
        ResponseEntity<ApiError> responseEntity = new ResponseEntity<>(apiError, ex.getStatus());
        return responseEntity;
    }
}