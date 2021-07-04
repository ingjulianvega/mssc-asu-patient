package ingjulianvega.ximic.msscasupatient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient implements Serializable {

    static final long serialVersionUID = 1450690712037268848L;

    private UUID documentTypeId;
    private String documentNumber;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private OffsetDateTime birthDate;
    private String hand;
    @Pattern(regexp = "O\\+|O-|A\\+|A-|B\\+|AB\\+|AB-", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String bloodType;
    private String address;
    private UUID maritalStatusId;
    private UUID genderId;
    private UUID occupationId;
    private UUID epsId;
    private UUID arlId;

}
