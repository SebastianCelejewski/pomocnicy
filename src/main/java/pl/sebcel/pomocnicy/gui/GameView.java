package pl.sebcel.pomocnicy.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.JPanel;

import pl.sebcel.pomocnicy.Board;
import pl.sebcel.pomocnicy.Player;
import pl.sebcel.pomocnicy.domain.categories.Controllable;
import pl.sebcel.pomocnicy.events.InitializeGame;
import pl.sebcel.pomocnicy.events.RepaintBoard;

@Singleton
public class GameView extends JPanel {

	private static final long serialVersionUID = 1L;

	@Inject
	private Provider<PlayerView> playerViewGenerator;

	private List<PlayerView> playerViews;

	private JPanel playersViewsContainer;

	@PostConstruct
	public void initializeComponent() {
		playersViewsContainer = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(playersViewsContainer, BorderLayout.CENTER);
		playersViewsContainer.setLayout(new GridBagLayout());
	}

	public void initializeGame(@Observes InitializeGame initializeGame) {
		int numberOfPlayers = initializeGame.getNumberOfPlayers();
		if (playerViews != null) {
			for (PlayerView pv : playerViews) {
				playersViewsContainer.remove(pv);
			}
		}

		playerViews = new ArrayList<PlayerView>();

		for (int i = 0; i < numberOfPlayers; i++) {
			PlayerView playerView = playerViewGenerator.get();
			playerViews.add(playerView);
			playersViewsContainer.add(playerView, new GridBagConstraints(i, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 1, 1));
		}
	}

	public void update(@Observes RepaintBoard repaintBoard) {
		Board board = repaintBoard.getBoard();
		List<Controllable> players = board.getControllables();

		for (int i = 0; i < playerViews.size(); i++) {
			Controllable player = players.get(i);
			playerViews.get(i).paint(repaintBoard.getBoard().getPaintables(), player.getX(), player.getY());
		}
	}
}