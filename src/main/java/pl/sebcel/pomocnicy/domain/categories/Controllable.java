package pl.sebcel.pomocnicy.domain.categories;

import pl.sebcel.pomocnicy.PlayerControls;

public interface Controllable {

	public void setControls(PlayerControls controls);
	public int getX();
	public int getY();

}
