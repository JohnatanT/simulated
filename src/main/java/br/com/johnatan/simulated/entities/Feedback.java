package br.com.johnatan.simulated.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "feedback_seq")
	@SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "feedback_id")
	List<FeedbackQuestion> feedbackQuestion;
	
	@OneToOne
	@JoinColumn(name = "proof_id")
	private Proof proof;
}
