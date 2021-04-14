package br.com.johnatan.simulated.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.entities.Student;
import br.com.johnatan.simulated.errors.BusinessRulesEnum;
import br.com.johnatan.simulated.errors.PreconditionException;
import br.com.johnatan.simulated.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}
	
	public Student findByIdWithValidate(Long id) throws PreconditionException {
		Optional<Student> student = studentRepository.findById(id);
		return student.orElseThrow(()
				-> new PreconditionException(BusinessRulesEnum.STUDENT_NOT_FOUND, getClass()));
	}
	
	public List<Student> findRankBySimulatedId(Long simulatedId) {
		return studentRepository.findRankBySimulatedId(simulatedId);
	}
}
