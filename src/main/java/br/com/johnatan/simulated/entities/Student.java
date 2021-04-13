package br.com.johnatan.simulated.entities;

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
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
	@Getter
	private Long id;

	@Column(unique = true)
	private String code;

	private String name;

	@OneToMany
	@JoinColumn(name = "student_id")
	private List<StudentSimulated> studentSimulated;

	@OneToMany
	@JoinColumn(name = "student_id")
	private List<StudentProof> studentProof;

	public Integer getSimulatedNote() {
		return this.studentProof.stream().mapToInt(obj -> obj.getProofNote()).sum() / this.studentProof.size();
	}
}
