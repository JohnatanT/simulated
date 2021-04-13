package br.com.johnatan.simulated.mappers;

import java.util.stream.Collectors;

import br.com.johnatan.simulated.dtos.outputs.SimulatedOutputDTO;
import br.com.johnatan.simulated.entities.Simulated;

public class SimulatedMapper {

	public static SimulatedOutputDTO toDto(Simulated simulated) {
		SimulatedOutputDTO dto = new SimulatedOutputDTO();
		dto.setCode(simulated.getCode());
		dto.setProofs(simulated.getProof().stream().map(obj -> ProofMapper.toDto(obj)).collect(Collectors.toList()));
		
		return dto;
	}
}
