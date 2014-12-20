package pl.sebcel.pomocnicy.elements;

import pl.sebcel.pomocnicy.Direction;
import pl.sebcel.pomocnicy.domain.categories.Paintable;

public interface BoardElement extends Paintable {

	public int getX();

	public int getY();

	public boolean enterable();

	public boolean helpsEnterFrom(Direction direction);

	public boolean blocksEnterFrom(Direction direction);

	public boolean helpsExitTo(Direction direction);

	public boolean blocksExitTo(Direction direction);

	public boolean canStandHere();
}