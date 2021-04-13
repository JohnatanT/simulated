package br.com.johnatan.simulated.dtos.outputs;

import br.com.johnatan.simulated.enums.QuestionItemEnum;
import lombok.Data;

@Data
public class QuestionItemOutpuDTO {

	private Long id;
	
	private QuestionItemEnum option;
	
	private String description;
}
