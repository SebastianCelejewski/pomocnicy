package pl.sebcel.pomocnicy.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import pl.sebcel.pomocnicy.Board;
import pl.sebcel.pomocnicy.Player;
import pl.sebcel.pomocnicy.Square;
import pl.sebcel.pomocnicy.domain.categories.Paintable;

public class PlayerView extends JPanel {

	private final static int ABSOLUTE_SIZE_X = 800;
	private final static int ABSOLUTE_SIZE_Y = 800;

	private static final long serialVersionUID = 1L;
	private List<Paintable> paintables;
	private int playerX;
	private int playerY;
	private int viewportX = 0;
	private int viewportY = 0;

	private double viewportScale;
	private double relativeSizeX;
	private double relativeSizeY;

	public PlayerView() {
		this.viewportScale = 20;
		this.setSize(ABSOLUTE_SIZE_X, ABSOLUTE_SIZE_Y);
		this.setPreferredSize(new Dimension(ABSOLUTE_SIZE_X, ABSOLUTE_SIZE_Y));
		relativeSizeX = ABSOLUTE_SIZE_X / viewportScale;
		relativeSizeY = ABSOLUTE_SIZE_Y / viewportScale;
	}

	public void paint(Graphics g) {
		int width = this.getWidth();
		int height = this.getHeight();

		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);

		if (paintables == null || paintables.size() == 0) {
			return;
		}

		ScalableGraphics sg = new ScalableGraphics(g, ABSOLUTE_SIZE_X, ABSOLUTE_SIZE_Y, viewportX, viewportY, viewportScale);

		for (Paintable paintable : paintables) {
			paintable.paint(sg);
		}
	}

	public void paint(List<Paintable> paintables, int playerX, int playerY) {
		this.paintables = paintables;
		this.playerX = playerX;
		this.playerY = playerY;
		updateViewportPosition();
		this.repaint();
	}

	private void updateViewportPosition() {
		while (playerX > viewportX + relativeSizeX / 4) {
			viewportX++;
		}
		while (playerX < viewportX - relativeSizeX / 4) {
			viewportX--;
		}
		while (playerY > viewportY + relativeSizeY / 4) {
			viewportY++;
		}
		while (playerY < viewportY - relativeSizeY / 4) {
			viewportY--;
		}
	}
}