package pl.sebcel.pomocnicy.events;

import pl.sebcel.pomocnicy.Board;

public class RepaintBoard {

	private Board board;

	public RepaintBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

}
