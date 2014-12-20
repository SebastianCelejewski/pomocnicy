package pl.sebcel.pomocnicy.domain;

import pl.sebcel.pomocnicy.elements.BoardElement;

public interface ActionableElement extends BoardElement {
	
	public void performAction();

}
