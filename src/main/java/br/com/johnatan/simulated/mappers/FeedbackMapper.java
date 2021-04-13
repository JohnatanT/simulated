package br.com.johnatan.simulated.mappers;

import java.util.stream.Collectors;

import br.com.johnatan.simulated.dtos.outputs.FeedbackOutputDTO;
import br.com.johnatan.simulated.entities.Feedback;

public class FeedbackMapper {

	public static FeedbackOutputDTO toDto(Feedback feedback) {
		FeedbackOutputDTO output = new FeedbackOutputDTO();
		output.setFeedbackQuestions(feedback.getFeedbackQuestion().stream()
				.map(obj -> FeedbackQuestionMapper.toDto(obj)).collect(Collectors.toList()));

		return output;
	}
}
