package pl.sebcel.pomocnicy.domain;

import pl.sebcel.pomocnicy.Direction;

public class MoveResult {

	private Direction direction;
	private int proposedX;
	private int proposedY;

	public MoveResult(Direction direction, int proposedX, int proposedY) {
		this.direction = direction;
		this.proposedX = proposedX;
		this.proposedY = proposedY;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getProposedX() {
		return proposedX;
	}

	public int getProposedY() {
		return proposedY;
	}
}