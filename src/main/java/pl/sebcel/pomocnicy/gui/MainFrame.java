package pl.sebcel.pomocnicy.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JFrame;

import pl.sebcel.pomocnicy.GameControls;

@Singleton
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	@Inject
	private GameView gameView;

	@Inject
	private GameControls gameControls;

	@PostConstruct
	public void initialize() {

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setLayout(new BorderLayout());
		this.add(gameView, BorderLayout.CENTER);

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					gameControls.getControls(0).moveLeft();
				}
				if (e.getKeyCode() == 39) {
					gameControls.getControls(0).moveRight();
				}
				if (e.getKeyCode() == 38) {
					gameControls.getControls(0).moveUp();
				}
				if (e.getKeyCode() == 40) {
					gameControls.getControls(0).moveDown();
				}

				if (e.getKeyCode() == KeyEvent.VK_A) {
					gameControls.getControls(1).moveLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					gameControls.getControls(1).moveRight();
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					gameControls.getControls(1).moveUp();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					gameControls.getControls(1).moveDown();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					gameControls.getControls(0).reset();
				}
				if (e.getKeyCode() == 39) {
					gameControls.getControls(0).reset();
				}
				if (e.getKeyCode() == 38) {
					gameControls.getControls(0).reset();
				}
				if (e.getKeyCode() == 40) {
					gameControls.getControls(0).reset();
				}

				if (e.getKeyCode() == KeyEvent.VK_A) {
					gameControls.getControls(1).reset();
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					gameControls.getControls(1).reset();
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					gameControls.getControls(1).reset();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					gameControls.getControls(1).reset();
				}
			}
		});
	}
}