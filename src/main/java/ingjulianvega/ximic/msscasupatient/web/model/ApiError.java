package ingjulianvega.ximic.msscasupatient.web.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private HttpStatus status;
    //TODO Agregar timestamp
    //TODO agregar codigo personalizado
    private String api;
    private String code;
    private String message;
    private String solution;
}
