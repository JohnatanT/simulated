package br.com.johnatan.simulated.entities;

import javax.persistence.Column;
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
public class ProofAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "proof_answer_seq")
	@SequenceGenerator(name = "proof_answer_seq", sequenceName = "proof_answer_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_proof_id")
	private StudentProof studentProof;
	
	@ManyToOne
	@JoinColumn(name = "question_item_id")
	private QuestionItem questionItem;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@Column(name = "correct")
	private boolean correct;
	
	public boolean answerIsCorrect(Question question, QuestionItem questionItem, StudentProof studentProof) {
		return studentProof.getProof().getFeedback().getFeedbackQuestion().stream().anyMatch(obj -> obj.getQuestion().equals(question) && obj.getCorrectQuestionItem().equals(questionItem));
	}
}
