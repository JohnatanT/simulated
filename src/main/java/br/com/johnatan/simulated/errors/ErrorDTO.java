package br.com.johnatan.simulated.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ErrorDTO {

	private Integer errorCode;
	private String errorSource;
	private String errorReason;
	private String errorDetail;
	
	public ErrorDTO(Integer errorCode, String errorSource, String errorReason) {
		this.errorCode = errorCode;
		this.errorSource = errorSource;
		this.errorReason = errorReason;
	}
}
