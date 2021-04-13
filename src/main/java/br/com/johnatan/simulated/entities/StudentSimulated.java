package br.com.johnatan.simulated.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class StudentSimulated {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "student_simulated_seq")
	@SequenceGenerator(name = "student_simulated_seq", sequenceName = "student_simulated_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "simulated_id")
	private Simulated simulated;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
}
