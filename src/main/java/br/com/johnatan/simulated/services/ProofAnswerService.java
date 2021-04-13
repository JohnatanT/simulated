package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.entities.ProofAnswer;
import br.com.johnatan.simulated.entities.Question;
import br.com.johnatan.simulated.entities.QuestionItem;
import br.com.johnatan.simulated.entities.StudentProof;
import br.com.johnatan.simulated.repositories.ProofAnswerRepository;

@Service
public class ProofAnswerService {
	
	@Autowired
	private ProofAnswerRepository proofAnswerRepository;

	public ProofAnswer create(StudentProof studentProof, QuestionItem questionItem, Question question) {
		ProofAnswer entity = new ProofAnswer();
		entity.setQuestion(question);
		entity.setQuestionItem(questionItem);
		entity.setStudentProof(studentProof);
		entity.setCorrect(entity.answerIsCorrect(question, questionItem, studentProof));
	
		return proofAnswerRepository.save(entity);
	}
	
	public ProofAnswer updateAnswer(ProofAnswer proofAnswer, StudentProof studentProof, QuestionItem questionItem, Question question) {
		proofAnswer.setCorrect(proofAnswer.answerIsCorrect(question, questionItem, studentProof));
	
		return proofAnswerRepository.save(proofAnswer);
	}
	
	public Optional<ProofAnswer> findByStudentProofAndQuestion(StudentProof studentProof, Question question) {
		return proofAnswerRepository.findByStudentProofAndQuestion(studentProof, question);
	}
}
