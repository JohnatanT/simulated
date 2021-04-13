package br.com.johnatan.simulated.dtos.outputs;

import br.com.johnatan.simulated.enums.QuestionLevelEnum;
import lombok.Data;

@Data
public class QuestionOutputDTO {

	private Long id;
	
	private String code;
	
	private String description;
	
	private String imageUrl;
	
	private QuestionLevelEnum level;
}
