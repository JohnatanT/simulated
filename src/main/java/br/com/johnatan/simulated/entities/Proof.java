package br.com.johnatan.simulated.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Proof {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "proof_seq")
	@SequenceGenerator(name = "proof_seq", sequenceName = "proof_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@Column(unique = true)
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "simulated_id")
	private Simulated simulated;
	
	@OneToOne(mappedBy = "proof")
	private Feedback feedback;
	
	@OneToMany
	@JoinColumn(name = "proof_id")
	private List<ProofQuestion> proofQuestion;
}
