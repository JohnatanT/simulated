package br.com.johnatan.simulated.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.johnatan.simulated.entities.Proof;
import br.com.johnatan.simulated.entities.Student;
import br.com.johnatan.simulated.entities.StudentProof;

@Repository
public interface StudentProofRepository extends JpaRepository<StudentProof, Long> {

	Optional<StudentProof> findByStudentAndProof(Student student, Proof proof);
}
