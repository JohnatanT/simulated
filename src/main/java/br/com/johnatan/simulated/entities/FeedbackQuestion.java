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
public class FeedbackQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "feedback_question_seq")
	@SequenceGenerator(name = "feedback_question_seq", sequenceName = "feedback_question_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "feedback_id")
	private Feedback feedback;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name = "correct_question_item_id")
	private QuestionItem correctQuestionItem;
}
