package pl.sebcel.pomocnicy.elements;

import java.awt.Color;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class Platform extends StaticBoardElement{

	public Platform(int x, int y) {
		super(x, y);
	}

	public void paint(ScalableGraphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x, y - 1, x + 1, y - 1);
		g.drawLine(x, y - 1.1, x + 1, y - 1.1);
	}

	public boolean helpsEnterFrom(Direction direction) {
		return direction == Direction.LEFT || direction == Direction.RIGHT;
	}

	public boolean blocksEnterFrom(Direction direction) {
		return direction == Direction.UP;
	}

	public boolean helpsExitTo(Direction direction) {
		return direction == Direction.LEFT || direction == Direction.RIGHT;
	}

	public boolean blocksExitTo(Direction direction) {
		return direction == Direction.DOWN;
	}


	@Override
	public boolean canStandHere() {
		return true;
	}

}