package pl.sebcel.pomocnicy.events;

public class InitializeGame {

	private int numberOfPlayers;

	public InitializeGame(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
}
