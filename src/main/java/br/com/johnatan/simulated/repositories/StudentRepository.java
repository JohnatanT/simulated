package br.com.johnatan.simulated.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.johnatan.simulated.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "SELECT st.* FROM student st\n"
			+ "JOIN student_proof  sp ON sp.student_id = st.id\n"
			+ "JOIN proof_answer pa ON pa.student_proof_id = sp.id\n"
			+ "JOIN proof p ON p.id = sp.proof_id\n"
			+ "JOIN simulated s ON s.id = p.simulated_id WHERE s.id = :simulatedId AND pa.correct = true GROUP BY st.id", nativeQuery = true)
	List<Student> findRankBySimulatedId(@Param("simulatedId") Long simulatedId);
}
