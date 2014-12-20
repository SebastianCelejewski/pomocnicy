package pl.sebcel.pomocnicy;

import java.awt.Color;

import pl.sebcel.pomocnicy.domain.MoveResult;
import pl.sebcel.pomocnicy.domain.categories.Controllable;
import pl.sebcel.pomocnicy.elements.MovableElement;
import pl.sebcel.pomocnicy.gui.ScalableGraphics;

public class Player implements MovableElement, Controllable {

	private PlayerControls controls;
	private int id;
	private String name;
	private Color colour;
	private int x;
	private int y;

	public String getName() {
		return name;
	}

	public Player(int id, String name, Color colour) {
		this.id = id;
		this.name = name;
		this.colour = colour;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color color) {
		this.colour = color;
	}

	public Color getColor() {
		return colour;
	}

	public int getId() {
		return id;
	}

	public MoveResult whereWantsToBeMoved() {
		Direction direction = controls.getDirection();

		int newX = x;
		int newY = y;

		if (direction == Direction.LEFT) {
			newX = x - 1;
		}
		if (direction == Direction.RIGHT) {
			newX = x + 1;
		}
		if (direction == Direction.UP) {
			newY = y + 1;
		}
		if (direction == Direction.DOWN) {
			newY = y - 1;
		}

		return new MoveResult(direction, newX, newY);
	}

	public void setControls(PlayerControls controls) {
		this.controls = controls;
	}

	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}

	@Override
	public void paint(ScalableGraphics g) {
		g.setColor(colour);
		g.fillOval(x, y, 1);
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

	public boolean helpsJump() {
		return true;
	}

	@Override
	public boolean enterable() {
		return false;
	}

	@Override
	public boolean canStandHere() {
		return true;
	}
}