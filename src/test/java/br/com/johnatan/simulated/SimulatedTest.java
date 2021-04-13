package br.com.johnatan.simulated;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import br.com.johnatan.simulated.dtos.outputs.RankOutputDTO;
import br.com.johnatan.simulated.services.SimulatedService;

@SpringBootTest
@ContextConfiguration
@TestExecutionListeners({ TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DisplayName("check that you have answered the question correctly")
@DatabaseSetup(value = { "/dbunit/rank_position_test.xml" }, type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { "/dbunit/rank_position_test.xml" })
public class SimulatedTest {

	@Autowired
	private SimulatedService simulatedService;
	
	@Test
	@Transactional
	@DisplayName("tests whether the names are coming correctly in the order")
	public void testsWhetherTheNamesAreComingCorrectlyInTheOrder() {
		RankOutputDTO rank = simulatedService.getRank(100000000l);
		
		assertEquals("JOAO", rank.getRankPosition().get(0).getName());
		assertEquals("MARIA", rank.getRankPosition().get(1).getName());
		assertEquals("DOUGLAS", rank.getRankPosition().get(2).getName());
	}
	
	@Test
	@Transactional
	@DisplayName("tests whether the notes are coming correctly in the order")
	public void testsWhetherTheNotesAreComingCorrectlyInTheOrder() {
		RankOutputDTO rank = simulatedService.getRank(100000000l);
		
		assertEquals(717, rank.getRankPosition().get(0).getNote());
		assertEquals(679, rank.getRankPosition().get(1).getNote());
		assertEquals(679, rank.getRankPosition().get(2).getNote());
	}
	
	@Test
	@Transactional
	@DisplayName("tests whether the positions are coming correctly in the order")
	public void testsWhetherThePositionsAreComingCorrectlyInTheOrder() {
		RankOutputDTO rank = simulatedService.getRank(100000000l);
		
		assertEquals(1, rank.getRankPosition().get(0).getRank());
		assertEquals(2, rank.getRankPosition().get(1).getRank());
		assertEquals(2, rank.getRankPosition().get(2).getRank());
	}
}
