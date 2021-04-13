package br.com.johnatan.simulated.errors;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PreconditionHandlerException {

	@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(PreconditionException.class)
	public ApiErrorDTO handle(PreconditionException exception) {
		ApiErrorDTO error = new ApiErrorDTO();

		if (exception.getHttpStatus() != null)
			error.setHttpStatus(exception.getHttpStatus());

		error.setErrors(new ArrayList<ErrorDTO>());
		error.getErrors().add(exception.getErrorDTO());

		return error;
	}
}
