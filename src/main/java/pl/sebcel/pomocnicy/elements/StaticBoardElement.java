package pl.sebcel.pomocnicy.elements;

public abstract class StaticBoardElement implements BoardElement {

	protected int x;
	protected int y;

	public StaticBoardElement(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public boolean enterable() {
		return true;
	}
}
