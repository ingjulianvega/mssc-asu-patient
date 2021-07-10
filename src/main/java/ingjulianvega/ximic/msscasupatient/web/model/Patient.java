package ingjulianvega.ximic.msscasupatient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "documentTypeId is mandatory")
    private UUID documentTypeId;
    @NotBlank(message = "documentNumber is mandatory")
    private String documentNumber;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = " is mandatory")
    private String firstLastName;
    private String secondLastName;
    private String homePhone;
    private String mobilePhone;
    private String email;
    @NotNull(message = "birthDate is mandatory")
    private OffsetDateTime birthDate;
    @NotBlank(message = "hand is mandatory")
    private String hand;
    @Pattern(regexp = "O\\+|O-|A\\+|A-|B\\+|AB\\+|AB-", flags = Pattern.Flag.CASE_INSENSITIVE, message = "bloodType is mandatory")
    private String bloodType;
    private String address;
    @NotNull(message = "maritalStatusId is mandatory")
    private UUID maritalStatusId;
    @NotNull(message = "genderId is mandatory")
    private UUID genderId;
    @NotNull(message = "occupationId is mandatory")
    private UUID occupationId;
    @NotNull(message = "epsId is mandatory")
    private UUID epsId;
    @NotNull(message = "arlId is mandatory")
    private UUID arlId;

}
