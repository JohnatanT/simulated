package br.com.johnatan.simulated.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnatan.simulated.entities.Proof;
import br.com.johnatan.simulated.entities.Student;
import br.com.johnatan.simulated.entities.StudentProof;
import br.com.johnatan.simulated.repositories.StudentProofRepository;

@Service
public class StudentProofService {

	@Autowired
	private StudentProofRepository studentProofRepository;
	
	public Optional<StudentProof> findByStudentAndProof(Student student, Proof proof) {
		return studentProofRepository.findByStudentAndProof(student, proof);
	}
	
	public StudentProof save(StudentProof entity) {
		return studentProofRepository.save(entity);
	}
}
