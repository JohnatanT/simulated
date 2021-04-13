package br.com.johnatan.simulated.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.johnatan.simulated.entities.ProofAnswer;
import br.com.johnatan.simulated.entities.Question;
import br.com.johnatan.simulated.entities.StudentProof;

@Repository
public interface ProofAnswerRepository extends JpaRepository<ProofAnswer, Long> {
	Optional<ProofAnswer> findByStudentProofAndQuestion(StudentProof studentProof, Question question);
}
