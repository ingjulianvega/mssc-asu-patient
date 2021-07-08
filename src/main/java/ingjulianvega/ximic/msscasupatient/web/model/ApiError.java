package ingjulianvega.ximic.msscasupatient.web.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private String status;
    private String api;
    private String code;
    private String message;
    private String solution;
}
