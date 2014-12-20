package pl.sebcel.pomocnicy.elements;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class Conveyor extends StaticBoardElement {

	public static enum ConveyorDirection {
		LEFT, RIGHT
	};

	private int state = 0;
	private ConveyorDirection conveyorDirection;

	public Conveyor(int x, int y, ConveyorDirection direction) {
		super(x, y);
		this.conveyorDirection = direction;
	}

	@Override
	public void paint(ScalableGraphics g) {
		if (conveyorDirection == ConveyorDirection.RIGHT) {
			state++;
			if (state > 3) {
				state = 0;
			}
		} else {
			state--;
			if (state < 0) {
				state = 3;
			}
		}

		g.drawLine(x, y + 0.1 - 1, x + 1, y + 0.1 - 1);
		g.drawLine(x + (double) state / 3, y + 0.1 - 1, x + (double) state / 3, y + 0.2 - 1);
		g.drawLine(x + 0.1 + (double) state / 3, y + 0.1 - 1, x + 0.1 + (double) state / 3, y + 0.2 - 1);
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
