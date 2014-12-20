package pl.sebcel.pomocnicy.io;

import java.util.ArrayList;
import java.util.List;

import pl.sebcel.pomocnicy.elements.BoardElement;

public class BoardData {

	private List<BoardElement> boardElements = new ArrayList<BoardElement>();

	public List<BoardElement> getBoardElements() {
		return boardElements;
	}

	public void setBoardElements(List<BoardElement> boardElements) {
		this.boardElements = boardElements;
	}
}