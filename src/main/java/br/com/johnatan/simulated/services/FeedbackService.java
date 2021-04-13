package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.dtos.outputs.FeedbackOutputDTO;
import br.com.johnatan.simulated.entities.Feedback;
import br.com.johnatan.simulated.entities.Proof;
import br.com.johnatan.simulated.errors.BusinessRulesEnum;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.mappers.FeedbackMapper;
import br.com.johnatan.simulated.repositories.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private ProofService proofService;
	
	public Optional<FeedbackOutputDTO> findFeedbackByProof(Long proofId) throws PreconditionException {
		Optional<Proof> proof = proofService.findById(proofId);
		if (proof.isEmpty())
			 throw new PreconditionException(BusinessRulesEnum.PROOF_NOT_FOUND, getClass());
		
		Optional<Feedback> feedback = feedbackRepository.findByProof(proof.get());
		if (feedback.isEmpty())
			return Optional.empty();
		
		return Optional.of(FeedbackMapper.toDto(feedback.get()));
	}
}
