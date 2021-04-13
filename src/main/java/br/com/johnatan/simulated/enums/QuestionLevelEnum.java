package br.com.johnatan.simulated.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuestionLevelEnum {
	EASY(15), MEDIUM(12), HARD(8);
	
	private Integer points;
}
