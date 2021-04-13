package br.com.johnatan.simulated.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.dtos.outputs.RankOutputDTO;
import br.com.johnatan.simulated.dtos.outputs.RankPositionOutputDTO;
import br.com.johnatan.simulated.dtos.outputs.SimulatedOutputDTO;
import br.com.johnatan.simulated.entities.Simulated;
import br.com.johnatan.simulated.entities.Student;
import br.com.johnatan.simulated.errors.BusinessRulesEnum;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.mappers.SimulatedMapper;
import br.com.johnatan.simulated.repositories.SimulatedRepository;

@Service
public class SimulatedService {

	@Autowired
	private SimulatedRepository simulatedRepository;

	@Autowired
	private StudentService studentService;

	public Page<SimulatedOutputDTO> findAll(Pageable paging) {
		Page<Simulated> pageSimulated = simulatedRepository.findAll(paging);
		Page<SimulatedOutputDTO> pageSimulatedDTO = pageSimulated.map(SimulatedMapper::toDto);

		return pageSimulatedDTO;
	}

	public Simulated findByIdWithValidate(Long id) throws PreconditionException {
		Optional<Simulated> simulated = simulatedRepository.findById(id);
		if (simulated.isEmpty())
			throw new PreconditionException(BusinessRulesEnum.SIMULATED_NOT_FOUND, getClass());

		return simulated.get();
	}

	public RankOutputDTO getRank(Long id) {
		List<Student> students = studentService.findRankBySimulatedId(id);
		students.sort((h1, h2) -> h2.getSimulatedNote().compareTo(h1.getSimulatedNote()));

		return fillTheRank(students);
	}

	private RankOutputDTO fillTheRank(List<Student> students) {
		List<RankPositionOutputDTO> positions = new ArrayList<>();
		RankOutputDTO rank = new RankOutputDTO();

		Integer rankPosition = 1;
		for (int i = 0; i < students.size(); i++) {
			RankPositionOutputDTO position = new RankPositionOutputDTO();
			Integer note = students.get(i).getSimulatedNote();
			Integer oldNote = 0;

			if (i != 0) {
				oldNote = students.get(i - 1).getSimulatedNote();
				if (!note.equals(oldNote))
					rankPosition++;
			}

			position.setName(students.get(i).getName());
			position.setRank(rankPosition);
			position.setNote(note);
			positions.add(position);
		}

		rank.setRankPosition(positions);

		return rank;
	}

}
