package br.com.johnatan.simulated.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.johnatan.simulated.entities.Simulated;

@Repository
public interface SimulatedRepository extends JpaRepository<Simulated, Long> {
	Page<Simulated> findAll(Pageable pageable);
}
