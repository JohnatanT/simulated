package br.com.johnatan.simulated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

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

import br.com.johnatan.simulated.dtos.outputs.FeedbackOutputDTO;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.services.FeedbackService;

@SpringBootTest
@ContextConfiguration
@TestExecutionListeners({ TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DisplayName("check that you have answered the question correctly")
@DatabaseSetup(value = { "/dbunit/rank_position_test.xml" }, type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { "/dbunit/rank_position_test.xml" })
public class FeedbackTest {

	@Autowired
	private FeedbackService feedbackService;
	
	@Test
	@Transactional
	@DisplayName("check template search correctly")
	public void checkTemplateSearchCorrectly() throws PreconditionException {
		 Optional<FeedbackOutputDTO> feedback = feedbackService.findFeedbackByProof(100000000l);
		 
		 assertEquals(true, !feedback.isEmpty());
	}
	
	@Test
	@Transactional
	@DisplayName("check proof not found exception")
	public void checkProofNotFoundException() {		 
		 assertThrows(PreconditionException.class, () -> feedbackService.findFeedbackByProof(100000001l));
	}
}
