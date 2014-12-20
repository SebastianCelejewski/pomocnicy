package pl.sebcel.pomocnicy;

import java.awt.Color;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Singleton;

import pl.sebcel.pomocnicy.domain.ActionableElement;
import pl.sebcel.pomocnicy.domain.MoveResult;
import pl.sebcel.pomocnicy.domain.categories.Controllable;
import pl.sebcel.pomocnicy.elements.BoardElement;
import pl.sebcel.pomocnicy.elements.ColorChanger;
import pl.sebcel.pomocnicy.elements.ColorRestorer;
import pl.sebcel.pomocnicy.elements.MovableElement;
import pl.sebcel.pomocnicy.events.InitializeGame;
import pl.sebcel.pomocnicy.events.RepaintBoard;

@Singleton
public class Controller {

	@Inject
	private Board board;

	@Inject
	private Event<RepaintBoard> repaintBoard;

	@Inject
	private GameControls gameControls;

	@Inject
	private Event<InitializeGame> initializeGame;

	public void createGame() {
		int numberOfPlayers = 2;

		board.loadBoard(0);
		board.createPlayers(numberOfPlayers);
		gameControls.intialize(numberOfPlayers);
		initializeGame.fire(new InitializeGame(numberOfPlayers));

		List<Controllable> players = board.getControllables();

		for (int i = 0; i < numberOfPlayers; i++) {
			players.get(i).setControls(gameControls.getControls(i));
		}
	}

	public void tick() {
		updateControls();
		repaintBoard.fire(new RepaintBoard(board));
	}

	private void updateControls() {
		for (MovableElement movableElement : board.getMovables()) {
			MoveResult actionResult = movableElement.whereWantsToBeMoved();

			int x = movableElement.getX();
			int y = movableElement.getY();
			int newX = actionResult.getProposedX();
			int newY = actionResult.getProposedY();
			Direction direction = actionResult.getDirection();

			Square thisSquare = board.getSquare(x, y);
			Square thatSquare = board.getSquare(newX, newY);
			Square belowSquare = board.getSquare(x, y - 1);
			boolean canStand = thisSquare.canStandHere(movableElement) || !belowSquare.isEnterable();

			if (!canStand && direction == Direction.UP) {
//				direction = Direction.NONE;
//				newY = y - 1;
			}

			boolean thisHelpsExit = thisSquare.helpsExitTo(direction);
			boolean thisBlocksExit = thisSquare.blocksExitTo(direction, movableElement);
			boolean thatHelpsEnter = thatSquare.helpsEnterFrom(direction);
			boolean thatBlocksEnter = board.getSquare(newX, newY).blocksEnterFrom(direction);
			boolean thisAllowsFall = board.getSquare(x, y).allowsFall();

			boolean existsPassage = thisHelpsExit || thatHelpsEnter;
			boolean canJump = direction == Direction.UP && !thatBlocksEnter && canStand;
			boolean blockIsHere = thisBlocksExit && !thatHelpsEnter;
			boolean blockIsThere = !thisHelpsExit && thatBlocksEnter;
			boolean existsBlock = blockIsHere || blockIsThere;
			boolean enterable = board.getSquare(newX, newY).isEnterable();

			boolean canMove = true;
			
			if (existsBlock || (!existsPassage && !canJump) || !enterable) {
				canMove = false;
			}
			
			if (direction == Direction.UP && !thatBlocksEnter)
			{
				canMove = true; // latanie
			}

			if (direction != Direction.NONE && canMove) {
				movableElement.move(newX, newY);
			} else {
				newX = x;
				newY = y - 1;

				boolean canFall = thisAllowsFall;
				thatBlocksEnter = board.getSquare(newX, newY).blocksEnterFrom(Direction.DOWN);
				boolean hardBlock = !board.getSquare(newX, newY).isEnterable();

				if (canFall && !thatBlocksEnter && !hardBlock) {
					movableElement.move(newX, newY);
				}
			}
		}

		for (ActionableElement actionableElement : board.getActionables()) {
			actionableElement.performAction();
		}
	}

	private final static Color[] colors = new Color[] { Color.RED, Color.GREEN, Color.BLUE };

	private void checkReaction(Player player) {
		int x = player.getX();
		int y = player.getY();

		List<BoardElement> elements = board.getSquare(x, y).getElements();

		for (BoardElement element : elements) {
			if (element.getClass().equals(ColorChanger.class)) {
				Color newColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
				player.setColor(newColor);
			}

			if (element.getClass().equals(ColorRestorer.class)) {
				Color newColor = colors[player.getId()];
				player.setColor(newColor);
			}
		}
	}
}