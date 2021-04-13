package br.com.johnatan.simulated.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnatan.simulated.dtos.inputs.AnswerQuestionInputDTO;
import br.com.johnatan.simulated.dtos.outputs.ProofAnswerOutputDTO;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.services.AnswerService;

@RestController
@RequestMapping(value = "answers")
public class AnswerResource {
	
	@Autowired
	private AnswerService answerService;

	@PostMapping
	public ResponseEntity<ProofAnswerOutputDTO> answerQuestion(@RequestBody AnswerQuestionInputDTO AnswerQuestion) throws PreconditionException {
		ProofAnswerOutputDTO proofAnswer = answerService.answerQuestion(AnswerQuestion);
		
		return new ResponseEntity<ProofAnswerOutputDTO>(proofAnswer, HttpStatus.CREATED);
	}
}
