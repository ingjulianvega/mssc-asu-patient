package ingjulianvega.ximic.msscasupatient.web.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private LocalDateTime timestamp;
    private String api;
    private String apiCode;
    private String error;
    private String message;
    private String solution;
}
