package br.com.johnatan.simulated.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.johnatan.simulated.entities.StudentSimulated;

@Repository
public interface StudentSimulatedRepository extends JpaRepository<StudentSimulated, Long> {

}
