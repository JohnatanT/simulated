package br.com.johnatan.simulated.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnatan.simulated.dtos.outputs.FeedbackOutputDTO;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.services.FeedbackService;

@RestController
@RequestMapping("feedbacks")
public class FeedbackResource {
	
	@Autowired
	private FeedbackService feedbackService;

	@GetMapping(value = "proof/{id}")
	@ResponseBody
	public ResponseEntity<FeedbackOutputDTO> findFeedbackByProof(@PathVariable(value = "id") Long id) throws PreconditionException {
		Optional<FeedbackOutputDTO> feedback = feedbackService.findFeedbackByProof(id);
	
		if (feedback.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<FeedbackOutputDTO>(feedback.get(), HttpStatus.OK);
	}
}
