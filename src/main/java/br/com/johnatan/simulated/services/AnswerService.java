package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.dtos.inputs.AnswerQuestionInputDTO;
import br.com.johnatan.simulated.dtos.outputs.ProofAnswerOutputDTO;
import br.com.johnatan.simulated.entities.Proof;
import br.com.johnatan.simulated.entities.ProofAnswer;
import br.com.johnatan.simulated.entities.Question;
import br.com.johnatan.simulated.entities.QuestionItem;
import br.com.johnatan.simulated.entities.Student;
import br.com.johnatan.simulated.entities.StudentProof;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.mappers.ProofAnswerMapper;

@Service
public class AnswerService {
	
	@Autowired
	private StudentProofService studentProofService;
	
	@Autowired
	private ProofService proofService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionItemService questionItemService;
	
	@Autowired
	private ProofAnswerService proofAnswerService;

	public ProofAnswerOutputDTO answerQuestion(AnswerQuestionInputDTO answerQuestion) throws PreconditionException {
		Proof proof = proofService.findByIdWithValidate(answerQuestion.getProofId());
		Student student = studentService.findByIdWithValidate(answerQuestion.getStudentId());
		Question question = questionService.findByIdWithValidate(answerQuestion.getQuestionId());
		QuestionItem questionItem = questionItemService.findByIdWithValidate(answerQuestion.getItemId());

		StudentProof studentProof = new StudentProof();
		Optional<StudentProof> currentStudentProof = studentProofService.findByStudentAndProof(student, proof);
		if (currentStudentProof.isEmpty())
			studentProof = studentProofService.save(new StudentProof(student, proof));
		else
			studentProof = currentStudentProof.get();
		
		ProofAnswer proofAnswer = new ProofAnswer();
		Optional<ProofAnswer> currentProofAnswer =  proofAnswerService.findByStudentProofAndQuestion(studentProof, question);
		if (currentProofAnswer.isEmpty())
			proofAnswer = proofAnswerService.create(studentProof, questionItem, question);
		else
			proofAnswer = proofAnswerService.updateAnswer(currentProofAnswer.get(), studentProof, questionItem, question);
		
		return ProofAnswerMapper.toDto(proofAnswer);
	}
	
	
}
