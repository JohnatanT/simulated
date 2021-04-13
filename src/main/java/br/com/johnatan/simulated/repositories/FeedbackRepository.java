package br.com.johnatan.simulated.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.johnatan.simulated.entities.Feedback;
import br.com.johnatan.simulated.entities.Proof;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	Optional<Feedback> findByProof(Proof proof);
}
