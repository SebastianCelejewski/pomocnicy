package pl.sebcel.pomocnicy.elements;

import pl.sebcel.pomocnicy.domain.MoveResult;

public interface MovableElement extends BoardElement {

	public MoveResult whereWantsToBeMoved();
	public void move(int newX, int newY);
	public int getX();
	public int getY();
	
}
