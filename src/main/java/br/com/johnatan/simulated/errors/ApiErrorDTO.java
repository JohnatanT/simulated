package br.com.johnatan.simulated.errors;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ApiErrorDTO {

	private List<ErrorDTO> errors;
	
	@JsonIgnore
	private HttpStatus httpStatus;
}
