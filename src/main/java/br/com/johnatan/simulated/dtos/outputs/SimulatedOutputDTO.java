package br.com.johnatan.simulated.dtos.outputs;

import java.util.List;

import lombok.Data;

@Data
public class SimulatedOutputDTO {

	private String code;
	
	private List<ProofOutputDTO> proofs;
}
