package pl.sebcel.pomocnicy.elements;

import java.awt.Color;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class ColorRestorer extends StaticBoardElement {

	public ColorRestorer(int x, int y) {
		super(x, y);
	}

	@Override
	public void paint(ScalableGraphics g) {
		Color col = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		g.setColor(col);
		g.drawRect(x + 0.1, y + 0.1, 0.6, 0.6);
	}

	@Override
	public boolean helpsEnterFrom(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean blocksEnterFrom(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean helpsExitTo(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean blocksExitTo(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean canStandHere() {
		return true;
	}

}
