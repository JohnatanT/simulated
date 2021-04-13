package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.entities.QuestionItem;
import br.com.johnatan.simulated.errors.BusinessRulesEnum;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.repositories.QuestionItemRepository;

@Service
public class QuestionItemService {

	@Autowired
	private QuestionItemRepository questionItemRepository;
	
	public Optional<QuestionItem> findById(Long id) {
		return questionItemRepository.findById(id);
	}
	
	public QuestionItem findByIdWithValidate(Long id) throws PreconditionException {
		Optional<QuestionItem> questionItem = questionItemRepository.findById(id);
		if (questionItem.isEmpty())
			throw new PreconditionException(BusinessRulesEnum.QUESTION_ITEM_NOT_FOUND, getClass());
		
		return questionItem.get();
	}
}
