package br.com.johnatan.simulated.mappers;

import br.com.johnatan.simulated.dtos.outputs.QuestionOutputDTO;
import br.com.johnatan.simulated.entities.Question;

public class QuestionMapper {

	public static QuestionOutputDTO toDto(Question question) {
		QuestionOutputDTO dto = new QuestionOutputDTO();
		dto.setCode(question.getCode());
		dto.setDescription(question.getDescription());
		dto.setImageUrl(question.getImageUrl());
		dto.setLevel(question.getLevel());
		dto.setId(question.getId());
		
		return dto;
	}
}
