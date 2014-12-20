package pl.sebcel.pomocnicy;

public class PlayerControls {

	private Direction direction = Direction.NONE;
	
	public void moveUp() {
		direction = Direction.UP;
	}

	public void moveDown() {
		direction = Direction.DOWN;
	}

	public void moveLeft() {
		direction = Direction.LEFT;
	}

	public void moveRight() {
		direction = Direction.RIGHT;
	}
	
	public void reset() {
		direction = Direction.NONE;
	}

	public Direction getDirection() {
		return direction;
	}
}
