package ingjulianvega.ximic.msscasupatient.web.controller;

import ingjulianvega.ximic.msscasupatient.web.model.ApiError;
import ingjulianvega.ximic.msscasupatient.web.model.Patient;
import ingjulianvega.ximic.msscasupatient.web.model.PatientDto;
import ingjulianvega.ximic.msscasupatient.web.model.PatientList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface PatientI {

    @Operation(summary = "Endpoint to get the list of patients", description = "Returns a list of patient", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = PatientList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<PatientList> get();

    @Operation(summary = "Endpoint to get the information of a patient given the id", description = "Returns a patient", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = PatientDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<PatientDto> getById(@Parameter(in = ParameterIn.PATH, description = "The patient id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);


    @Operation(summary = "Endpoint to get the information of a patient given the document number", description = "Returns a list of patients", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = PatientList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "document-id/{document-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<PatientList> getByDocumentNumber(@Parameter(in = ParameterIn.PATH, description = "The patient document id", required = true, schema = @Schema()) @NotNull @PathVariable("document-id") String documentId);

    @Operation(summary = "Endpoint to get the information of a patient given the first last name", description = "Returns a list of patients", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = PatientList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "first-last-name/{first-last-name}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<PatientList> getByFirstLastName(@Parameter(in = ParameterIn.PATH, description = "The patient first last name", required = true, schema = @Schema()) @NotNull @PathVariable("first-last-name") String firstLastName);


    @Operation(summary = "Endpoint to create a patient", description = "Creates a new patient", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "patient's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Patient patient);

    @Operation(summary = "Endpoint to update the information of a patient given the id", description = "Updates a patient", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The patient id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "patient's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Patient patient);


    @Operation(summary = "Endpoint to delete a patient", description = "Deletes a patient", tags = {"patient"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The patient id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}
