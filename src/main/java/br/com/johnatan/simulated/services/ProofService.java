package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.entities.Proof;
import br.com.johnatan.simulated.errors.BusinessRulesEnum;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.repositories.ProofRepository;

@Service
public class ProofService {

	@Autowired
	private ProofRepository proofRepository;
	
	public Optional<Proof> findById(Long id) {
		return proofRepository.findById(id);
	}
	
	public Proof findByIdWithValidate(Long id) throws PreconditionException {
		Optional<Proof> proof = proofRepository.findById(id);
		
		if (proof.isEmpty())
			 throw new PreconditionException(BusinessRulesEnum.PROOF_NOT_FOUND, getClass());
		
		return proof.get();
	}
}
