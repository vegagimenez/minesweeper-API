package ar.com.jmvg.challenges.minesweeper.api.model;

import lombok.Getter;

@Getter
public enum Difficulty {

	DOPE("Easy",10,10,10),
	NO_DOPE("Medium",10,10,40),
	I_EAT_MINES("Hard",16,30,99);
	
	private Difficulty(String name, int rows, int columns, int mines) {
		this.name = name;
		this.rows = rows;
		this.columns = columns;
		this.mines = mines;
	}
	
	private final String name;
	private final int rows;
	private final int columns;
	private final int mines;
}
