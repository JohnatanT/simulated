package br.com.johnatan.simulated.mappers;

import br.com.johnatan.simulated.dtos.outputs.ProofOutputDTO;
import br.com.johnatan.simulated.entities.Proof;

public class ProofMapper {

	public static ProofOutputDTO toDto(Proof proof) {
		ProofOutputDTO output = new ProofOutputDTO();
		output.setCode(proof.getCode());
		output.setFeedback(FeedbackMapper.toDto(proof.getFeedback()));
		
		return output;
	}
}
