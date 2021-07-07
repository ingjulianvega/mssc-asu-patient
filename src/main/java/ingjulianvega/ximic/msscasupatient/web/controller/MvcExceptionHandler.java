package ingjulianvega.ximic.msscasupatient.web.controller;

import ingjulianvega.ximic.msscasupatient.exception.PatientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class MvcExceptionHandler {

    @ExceptionHandler(PatientException.class)
    public PatientException validationErrorHandler(PatientException ex){
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }
}
