package br.com.johnatan.simulated.mappers;

import br.com.johnatan.simulated.dtos.outputs.ProofAnswerOutputDTO;
import br.com.johnatan.simulated.entities.ProofAnswer;

public class ProofAnswerMapper {

	public static ProofAnswerOutputDTO toDto(ProofAnswer proofAnswer) {
		ProofAnswerOutputDTO dto = new ProofAnswerOutputDTO();
		dto.setId(proofAnswer.getId());
		dto.setAnswerIsCorrect(proofAnswer.isCorrect());
		
		return dto;
	}
}
