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
public class ProofQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "proof_question_seq")
	@SequenceGenerator(name = "proof_question_seq", sequenceName = "proof_question_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "proof_id")
	private Proof proof;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
}
