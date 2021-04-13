package br.com.johnatan.simulated.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.johnatan.simulated.enums.QuestionLevelEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class StudentProof {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "student_proof_seq")
	@SequenceGenerator(name = "student_proof_seq", sequenceName = "student_proof_seq", allocationSize = 1)
	@Getter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "proof_id")
	private Proof proof;
	
	@OneToMany
	@JoinColumn(name = "student_proof_id")
	private List<ProofAnswer> proofAnswer;
	
	public StudentProof (Student student, Proof proof) {
		this.student = student;
		this.proof = proof;
	}
	
	public Integer getProofNote() {
		return getProofNoteEasy() + getProofNoteMedium() + getProofNoteHard() + 600;
	}
	
	public Integer getProofNoteEasy() {
		List<ProofAnswer> easyList = this.proofAnswer.stream().filter(obj -> obj.getQuestion().getLevel().equals(QuestionLevelEnum.EASY) && obj.isCorrect()).collect(Collectors.toList());
		Integer easyNote = easyList.size() * QuestionLevelEnum.EASY.getPoints();

		return easyNote;
	}
	
	public Integer getProofNoteMedium() {
		List<ProofAnswer> mediumList = this.proofAnswer.stream().filter(obj -> obj.getQuestion().getLevel().equals(QuestionLevelEnum.MEDIUM) && obj.isCorrect()).collect(Collectors.toList());
		Integer mediumNote = mediumList.size() * QuestionLevelEnum.MEDIUM.getPoints();

		return mediumNote;
	}
	
	public Integer getProofNoteHard() {
		List<ProofAnswer> hardList = this.proofAnswer.stream().filter(obj -> obj.getQuestion().getLevel().equals(QuestionLevelEnum.HARD) && obj.isCorrect()).collect(Collectors.toList());
		Integer hardNote = hardList.size() * QuestionLevelEnum.HARD.getPoints();

		return hardNote;
	}
}
