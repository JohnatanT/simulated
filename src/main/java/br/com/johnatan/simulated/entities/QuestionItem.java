package br.com.johnatan.simulated.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.johnatan.simulated.enums.QuestionItemEnum;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class QuestionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "question_item_seq")
	@SequenceGenerator(name = "question_item_seq", sequenceName = "question_item_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@Enumerated(EnumType.STRING)
	private QuestionItemEnum option;
	
	@Column(columnDefinition="TEXT")
	private String description;
}
