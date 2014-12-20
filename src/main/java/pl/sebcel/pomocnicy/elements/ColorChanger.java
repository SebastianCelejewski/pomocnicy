package pl.sebcel.pomocnicy.elements;

import java.awt.Color;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class ColorChanger extends StaticBoardElement {

	public ColorChanger(int x, int y) {
		super(x, y);
	}

	@Override
	public void paint(ScalableGraphics g) {
		Color col = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		g.setColor(col);
		g.drawRect(x, y, 1, 1);
	}

	@Override
	public boolean helpsEnterFrom(Direction direction) {
		return false;
	}

	@Override
	public boolean blocksEnterFrom(Direction direction) {
		return false;
	}

	@Override
	public boolean helpsExitTo(Direction direction) {
		return false;
	}

	@Override
	public boolean blocksExitTo(Direction direction) {
		return false;
	}

	@Override
	public boolean canStandHere() {
		return true;
	}

}