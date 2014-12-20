package pl.sebcel.pomocnicy.elements;

import java.awt.Color;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class Ladder extends StaticBoardElement {

	public Ladder(int x, int y) {
		super(x, y);
	}

	public void paint(ScalableGraphics g) {
		g.setColor(Color.RED);
		g.drawLine(x + 0.2, y - 1, x + 0.2, y);
		g.drawLine(x + 0.8, y - 1, x + 0.8, y);

		g.drawLine(x + 0.2, y - 0.8, x + 0.8, y - 0.8);
		g.drawLine(x + 0.2, y - 0.6, x + 0.8, y - 0.6);
		g.drawLine(x + 0.2, y - 0.4, x + 0.8, y - 0.4);
		g.drawLine(x + 0.2, y - 0.2, x + 0.8, y - 0.2);
		g.drawLine(x + 0.2, y - 0.0, x + 0.8, y - 0.0);
	}

	public boolean helpsEnterFrom(Direction direction) {
		return true;
	}

	public boolean blocksEnterFrom(Direction direction) {
		return false;
	}

	public boolean helpsExitTo(Direction direction) {
		return true;
	}

	public boolean blocksExitTo(Direction direction) {
		return false;
	}


	@Override
	public boolean canStandHere() {
		return true;
	}

}