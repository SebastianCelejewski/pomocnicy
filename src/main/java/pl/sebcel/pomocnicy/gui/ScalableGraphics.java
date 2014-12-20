package pl.sebcel.pomocnicy.gui;

import java.awt.Color;
import java.awt.Graphics;

public class ScalableGraphics {

	private Graphics g;
	private int absoluteSizeX;
	private int absoluteSizeY;
	private int viewportX;
	private int viewportY;
	private double viewportScale;

	public ScalableGraphics(Graphics g, int absoluteSizeX, int absoluteSizeY, int viewportX, int viewportY, double viewportScale) {
		this.g = g;
		this.absoluteSizeX = absoluteSizeX;
		this.absoluteSizeY = absoluteSizeY;
		this.viewportX = viewportX;
		this.viewportY = viewportY;
		this.viewportScale = viewportScale;
	}

	private int getX(double x) {
		return absoluteSizeX / 2 + (int) (viewportScale * (x - viewportX));
	}

	private int getY(double y) {
		return absoluteSizeY / 2 + (int) (viewportScale * (-y + viewportY));
	}

	private int getWidth(double x) {
		return (int) (viewportScale * x);
	}

	private int getHeight(double y) {
		return (int) (viewportScale * y);
	}

	public void setColor(Color color) {
		g.setColor(color);
	}

	public void drawRect(double x, double y, double i, double j) {
		int a = getX(x);
		int b = getY(y);
		int c = getWidth(i);
		int d = getHeight(j);

		g.drawRect(a, b, c, d);
	}

	public void fillOval(double x, double y, double r) {
		g.fillOval(getX(x), getY(y), getWidth(r), getHeight(r));
	}

	public void fillRect(int x, int y, int width, int height) {
		g.fillRect(getX(x), getY(y), getWidth(width), getHeight(height));
	}

	public void drawLine(double x1, double y1, double x2, double y2) {
		int a = getX(x1);
		int b = getY(y1);
		int c = getX(x2);
		int d = getY(y2);
		if (d < b) {
			int k = b;
			b = d;
			d = k;
		}
		g.drawLine(a, b, c, d);
	}

}