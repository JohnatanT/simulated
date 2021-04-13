package br.com.johnatan.simulated.dtos.outputs;

import lombok.Data;

@Data
public class FeedbackQuestionOutputDTO {

	private QuestionOutputDTO question;
	
	private QuestionItemOutpuDTO correctQuestionItem;
}
