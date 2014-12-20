package pl.sebcel.pomocnicy;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.sebcel.pomocnicy.domain.ActionableElement;
import pl.sebcel.pomocnicy.domain.categories.Controllable;
import pl.sebcel.pomocnicy.domain.categories.Paintable;
import pl.sebcel.pomocnicy.elements.BoardElement;
import pl.sebcel.pomocnicy.elements.MovableElement;
import pl.sebcel.pomocnicy.io.BoardData;
import pl.sebcel.pomocnicy.io.BoardLoader;

@Singleton
public class Board {

	public static final Color[] STANDARD_COLOUR_LIST = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };

	private BoardData boardData;

	@Inject
	private BoardLoader boardLoader;

	public void loadBoard(int boardID) {
		boardData = boardLoader.load(boardID);
	}

	public void createPlayers(int numerOfPlayers) {
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < numerOfPlayers; i++) {
			Player p = new Player(i, "Player " + (i + 1), STANDARD_COLOUR_LIST[i]);
			p.setX(1 + i * 10);
			p.setY(1);
			players.add(p);
		}

		boardData.getBoardElements().addAll(players);
	}

	public List<Paintable> getPaintables() {
		List<Paintable> result = new ArrayList<Paintable>();

		for (BoardElement boardElement : boardData.getBoardElements()) {
			if (boardElement instanceof Paintable) {
				result.add((Paintable) boardElement);
			}
		}

		return result;
	}

	public List<MovableElement> getMovables() {
		List<MovableElement> result = new ArrayList<MovableElement>();

		for (BoardElement boardElement : boardData.getBoardElements()) {
			if (boardElement instanceof MovableElement) {
				result.add((MovableElement) boardElement);
			}
		}

		return result;
	}

	public List<ActionableElement> getActionables() {
		List<ActionableElement> result = new ArrayList<ActionableElement>();

		for (BoardElement boardElement : boardData.getBoardElements()) {
			if (boardElement instanceof ActionableElement) {
				result.add((ActionableElement) boardElement);
			}
		}

		return result;
	}

	public List<Controllable> getControllables() {
		List<Controllable> result = new ArrayList<Controllable>();

		for (BoardElement boardElement : boardData.getBoardElements()) {
			if (boardElement instanceof Controllable) {
				result.add((Controllable) boardElement);
			}
		}

		return result;
	}
	
	public Square getSquare(int x, int y)
	{
		Square s = new Square();
		for (BoardElement boardElement : boardData.getBoardElements()) {
			if (boardElement.getX() == x && boardElement.getY() == y) {
				s.getElements().add(boardElement);
			}
		}
		
		return s;
	}
}