package pl.sebcel.pomocnicy;

import java.util.ArrayList;
import java.util.List;

import pl.sebcel.pomocnicy.domain.categories.Controllable;
import pl.sebcel.pomocnicy.elements.BoardElement;
import pl.sebcel.pomocnicy.elements.MovableElement;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class Square {

	private List<BoardElement> elements = new ArrayList<BoardElement>();

	public List<BoardElement> getElements() {
		return elements;
	}

	public boolean helpsEnterFrom(Direction direction) {
		if (elements.size() == 0) {
			return false;
		}

		for (BoardElement element : elements) {
			if (element.helpsEnterFrom(direction)) {
				return true;
			}
		}
		return false;
	}

	public boolean blocksEnterFrom(Direction direction) {
		if (elements.size() == 0) {
			return false;
		}

		for (BoardElement element : elements) {
			if (element.blocksEnterFrom(direction)) {
				return true;
			}
		}
		return false;
	}

	public boolean helpsExitTo(Direction direction) {
		if (elements.size() == 0) {
			return false;
		}

		for (BoardElement element : elements) {
			if (element.helpsExitTo(direction)) {
				return true;
			}
		}
		return false;
	}

	public boolean blocksExitTo(Direction direction, BoardElement thisElement) {
		if (elements.size() == 0) {
			return false;
		}

		for (BoardElement element : elements) {
			if (element != thisElement && element.blocksExitTo(direction)) {
				return true;
			}
		}
		return false;
	}

	public boolean allowsFall() {
		if (elements.size() == 0) {
			return true;
		} else if (elements.get(0) instanceof Controllable) {
			return true;
		} else {
			return false;
		}

	}

	public void paint(ScalableGraphics sg) {

		List<BoardElement> elements = getElements();
		for (BoardElement element : elements) {
			element.paint(sg);
		}
	}

	public boolean isEnterable() {
		if (elements.size() == 0) {
			return true;
		}

		for (BoardElement element : elements) {
			if (!element.enterable()) {
				return false;
			}
		}
		return true;
	}

	public boolean canStandHere(MovableElement thisElement) {
		if (elements.size() == 0) {
			return false;
		}

		for (BoardElement element : elements) {
			if (element != thisElement && element.canStandHere()) {
				return true;
			}
		}
		return false;
	}
}