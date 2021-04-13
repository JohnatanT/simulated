package br.com.johnatan.simulated.dtos.outputs;

import java.util.List;

import lombok.Data;

@Data
public class FeedbackOutputDTO {	
	private List<FeedbackQuestionOutputDTO> feedbackQuestions;
}
