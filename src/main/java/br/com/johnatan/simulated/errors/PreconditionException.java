package br.com.johnatan.simulated.errors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Getter;

@Data
public class PreconditionException extends Exception {

	private static final long serialVersionUID = 4755926209257830438L;

	@Getter
    private ErrorDTO errorDTO;

    private HttpStatus httpStatus;

    public PreconditionException(BusinessRulesEnum businessRules, Class<?> originClass) {
        this(businessRules, originClass, null, null);
    }

    public PreconditionException(BusinessRulesEnum businessRules, Class<?> originClass, HttpStatus httpStatus) {
        this(businessRules, originClass, null, httpStatus);
    }

    public PreconditionException(BusinessRulesEnum businessRules, Class<?> originClass, String detail) {
        this(businessRules, originClass, detail, null);
    }

    public PreconditionException(BusinessRulesEnum businessRules, Class<?> originClass, String detail, HttpStatus httpStatus) {
        errorDTO = new ErrorDTO(businessRules.ordinal(), originClass.getCanonicalName(), businessRules.name(), detail);
        setHttpStatus(httpStatus);
    }

    public PreconditionException(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }
    
    @Override
    public String getMessage() {
        List<String> fields = new ArrayList<>();

        if(getErrorDTO() != null) {
            if(getErrorDTO().getErrorCode() != null)
                fields.add(getErrorDTO().getErrorCode().toString());

            if(getErrorDTO().getErrorReason() != null)
                fields.add(getErrorDTO().getErrorReason());

            if(getErrorDTO().getErrorDetail() != null)
                fields.add(getErrorDTO().getErrorDetail());

            if(getErrorDTO().getErrorSource() != null)
                fields.add(getErrorDTO().getErrorSource());
        }

        return !fields.isEmpty() ?
                fields.stream().collect(Collectors.joining(" - ")) :
                "Unknown Error";
    }
}
