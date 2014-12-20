package pl.sebcel.pomocnicy;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import pl.sebcel.pomocnicy.gui.MainFrame;

public class Main {

	@Inject
	MainFrame mainFrame;

	@Inject
	Controller controller;

	public void run() {

		controller.createGame();

		mainFrame.setVisible(true);
		mainFrame.pack();

		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		int sizeX = mainFrame.getSize().width;
		int sizeY = mainFrame.getSize().height;
		mainFrame.setBounds((screenWidth - sizeX) / 2, (screenHeight - sizeY) / 2, sizeX, sizeY);

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				controller.tick();
			}
		};
		timer.schedule(task, 100, 100);
	}
}