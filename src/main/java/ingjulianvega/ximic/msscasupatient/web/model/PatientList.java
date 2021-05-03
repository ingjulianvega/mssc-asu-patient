package ingjulianvega.ximic.msscasupatient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientList implements Serializable {

    static final long serialVersionUID = -6556668646011706157L;

    public ArrayList<PatientDto> patientDtoList;
}
