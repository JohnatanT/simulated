package br.com.johnatan.simulated.mappers;

import br.com.johnatan.simulated.dtos.outputs.QuestionItemOutpuDTO;
import br.com.johnatan.simulated.entities.QuestionItem;

public class QuestionItemMapper {

	public static QuestionItemOutpuDTO toDto(QuestionItem questionItem) {
		QuestionItemOutpuDTO dto = new QuestionItemOutpuDTO();
		dto.setDescription(questionItem.getDescription());
		dto.setOption(questionItem.getOption());
		dto.setId(questionItem.getId());
		
		return dto;
	}
}
