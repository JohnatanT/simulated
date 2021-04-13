package br.com.johnatan.simulated.mappers;

import br.com.johnatan.simulated.dtos.outputs.FeedbackQuestionOutputDTO;
import br.com.johnatan.simulated.entities.FeedbackQuestion;

public class FeedbackQuestionMapper {

	public static FeedbackQuestionOutputDTO toDto(FeedbackQuestion feedbackQuestion) {
		FeedbackQuestionOutputDTO output = new FeedbackQuestionOutputDTO();
		output.setCorrectQuestionItem(QuestionItemMapper.toDto(feedbackQuestion.getCorrectQuestionItem()));
		output.setQuestion(QuestionMapper.toDto(feedbackQuestion.getQuestion()));
		
		return output;
	}
}
