package ingjulianvega.ximic.msscasupatient.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "patient")
public class PatientParameters {

    private String success;
    private String api;
    private Error error;

    @Getter
    @Setter
    public static class Error {
        private String general;
    }
}
