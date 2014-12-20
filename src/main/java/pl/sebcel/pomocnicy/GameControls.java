package pl.sebcel.pomocnicy;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class GameControls {

	@Inject
	private Provider<PlayerControls> playerControlsProvider;

	private List<PlayerControls> controls;

	public void intialize(int numberOfPlayers) {
		controls = new ArrayList<PlayerControls>();
		for (int i = 0; i < numberOfPlayers; i++) {
			PlayerControls playerControls = playerControlsProvider.get();
			controls.add(playerControls);
		}
	}

	public PlayerControls getControls(int playerId) {
		return controls.get(playerId);
	}
}