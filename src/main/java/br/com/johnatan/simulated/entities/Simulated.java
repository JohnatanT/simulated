package br.com.johnatan.simulated.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Simulated {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "simulated_seq")
	@SequenceGenerator(name = "simulated_seq", sequenceName = "simulated_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@Column(unique = true)
	private String code;
	
	private LocalDateTime createdAt;
	
	@OneToMany
	@JoinColumn(name = "simulated_id")
	private List<StudentSimulated> studentSimulated;
	
	@OneToMany
	@JoinColumn(name = "simulated_id")
	private List<Proof> proof;
}
