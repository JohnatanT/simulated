package br.com.johnatan.simulated.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.johnatan.simulated.enums.QuestionLevelEnum;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "question_seq")
	@SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@Column(unique = true)
	private String code;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private String imageUrl;
	
	@Enumerated(EnumType.STRING)
	private QuestionLevelEnum level;
	
	@OneToMany
	@JoinColumn(name = "question_id")
	private List<ProofQuestion> proofQuestion;
	
	@OneToMany
	@JoinColumn(name = "question_id")
	private List<QuestionItem> questionItem;

}
