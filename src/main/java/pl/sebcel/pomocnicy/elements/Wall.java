package pl.sebcel.pomocnicy.elements;

import java.awt.Color;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class Wall extends StaticBoardElement {

	public Wall(int x, int y) {
		super(x, y);
	}

	@Override
	public void paint(ScalableGraphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 1, 1);
	}

	@Override
	public boolean helpsEnterFrom(Direction direction) {
		return false;
	}

	@Override
	public boolean blocksEnterFrom(Direction direction) {
		return true;
	}

	@Override
	public boolean helpsExitTo(Direction direction) {
		return false;
	}

	@Override
	public boolean blocksExitTo(Direction direction) {
		return true;
	}

	@Override
	public boolean canStandHere() {
		return true;
	}

	@Override
	public boolean enterable() {
		return false;
	}
}