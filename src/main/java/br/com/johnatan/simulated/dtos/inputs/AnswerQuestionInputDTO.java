package br.com.johnatan.simulated.dtos.inputs;

import lombok.Data;

@Data
public class AnswerQuestionInputDTO {

	private Long studentId;
	
	private Long questionId;
	
	private Long proofId;
	
	private Long itemId;
}
