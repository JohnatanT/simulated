package br.com.johnatan.simulated.dtos.outputs;

import lombok.Data;

@Data
public class ProofOutputDTO {
	
	private String code;
	
	private FeedbackOutputDTO feedback;
}
