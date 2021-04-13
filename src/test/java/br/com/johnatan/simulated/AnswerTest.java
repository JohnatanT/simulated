package br.com.johnatan.simulated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import br.com.johnatan.simulated.dtos.inputs.AnswerQuestionInputDTO;
import br.com.johnatan.simulated.dtos.outputs.ProofAnswerOutputDTO;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.services.AnswerService;

@SpringBootTest
@ContextConfiguration
@TestExecutionListeners({ TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup(value = { "/dbunit/rank_position_test.xml" }, type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { "/dbunit/rank_position_test.xml" })
public class AnswerTest {

	@Autowired
	private AnswerService answerService;
	
	@Test
	@Transactional
	@DisplayName("check that you have answered the question correctly")
	public void answerIsCorrect() throws PreconditionException {
		AnswerQuestionInputDTO answerQuestion = new AnswerQuestionInputDTO();
		answerQuestion.setItemId(100000002l);
		answerQuestion.setProofId(100000000l);
		answerQuestion.setQuestionId(100000000l);
		answerQuestion.setStudentId(100000000l);
		
		ProofAnswerOutputDTO output = answerService.answerQuestion(answerQuestion);
		assertEquals(true, output.isAnswerIsCorrect());
	}
	
	@Test
	@Transactional
	@DisplayName("check that you not have answered the question correctly")
	public void answerIsNotCorrect() throws PreconditionException {
		AnswerQuestionInputDTO answerQuestion = new AnswerQuestionInputDTO();
		answerQuestion.setItemId(100000003l);
		answerQuestion.setProofId(100000000l);
		answerQuestion.setQuestionId(100000000l);
		answerQuestion.setStudentId(100000000l);
		
		ProofAnswerOutputDTO output = answerService.answerQuestion(answerQuestion);
		assertEquals(false, output.isAnswerIsCorrect());
	}
	
	@Test
	@Transactional
	@DisplayName("check proof not found exception")
	public void answerIsCorrectException_ProofNotFound() {
		AnswerQuestionInputDTO answerQuestion = new AnswerQuestionInputDTO();
		answerQuestion.setItemId(100000003l);
		answerQuestion.setProofId(100000004l);
		answerQuestion.setQuestionId(100000000l);
		answerQuestion.setStudentId(100000000l);
		
		assertThrows(PreconditionException.class, () -> answerService.answerQuestion(answerQuestion));
	}
	
	@Test
	@Transactional
	@DisplayName("check student not found exception")
	public void answerIsCorrectException_StudentNotFound() {
		AnswerQuestionInputDTO answerQuestion = new AnswerQuestionInputDTO();
		answerQuestion.setItemId(100000003l);
		answerQuestion.setProofId(100000000l);
		answerQuestion.setQuestionId(100000000l);
		answerQuestion.setStudentId(100000004l);
	
		assertThrows(PreconditionException.class, () -> answerService.answerQuestion(answerQuestion));
	}
	
	@Test
	@Transactional
	@DisplayName("check question not found exception")
	public void answerIsCorrectException_QuestionNotFound() {
		AnswerQuestionInputDTO answerQuestion = new AnswerQuestionInputDTO();
		answerQuestion.setItemId(100000003l);
		answerQuestion.setProofId(100000000l);
		answerQuestion.setQuestionId(100000070l);
		answerQuestion.setStudentId(100000000l);

		assertThrows(PreconditionException.class, () -> answerService.answerQuestion(answerQuestion));
	}
}
