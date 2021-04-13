package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.entities.Question;
import br.com.johnatan.simulated.errors.BusinessRulesEnum;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public Optional<Question> findById(Long id) {
		return questionRepository.findById(id);
	}
	
	public Question findByIdWithValidate(Long id) throws PreconditionException {
		Optional<Question> question = questionRepository.findById(id);
		if (question.isEmpty())
			throw new PreconditionException(BusinessRulesEnum.QUESTION_NOT_FOUND, getClass());
		
		return question.get();
	}
}
