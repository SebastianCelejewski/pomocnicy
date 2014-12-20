package pl.sebcel.pomocnicy.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import pl.sebcel.pomocnicy.Square;
import pl.sebcel.pomocnicy.elements.BoardElement;
import pl.sebcel.pomocnicy.elements.ColorChanger;
import pl.sebcel.pomocnicy.elements.ColorRestorer;
import pl.sebcel.pomocnicy.elements.Conveyor;
import pl.sebcel.pomocnicy.elements.Conveyor.ConveyorDirection;
import pl.sebcel.pomocnicy.elements.Ladder;
import pl.sebcel.pomocnicy.elements.Platform;
import pl.sebcel.pomocnicy.elements.Wall;

@Singleton
public class BoardLoader {

	private final static DecimalFormat df = new DecimalFormat("00");

	public BoardData load(int boardId) {
		BoardData result = new BoardData();

		try {
			String boardFileName = "/levels/level_" + df.format(boardId) + ".txt";
			System.out.println("Loading board from file " + boardFileName);

			InputStream is = this.getClass().getResourceAsStream(boardFileName);
			BufferedReader bis = new BufferedReader(new InputStreamReader(is));

			List<String> lines = new ArrayList<String>();

			while (bis.ready()) {
				String line = bis.readLine();
				lines.add(line);
			}
			is.close();

			int height = lines.size();
			int width = lines.get(0).length();

			System.out.println("Board " + width + "x" + height);

			for (int j = 0; j < height; j++) {
				String line = lines.get(j);

				for (int i = 0; i < width; i++) {
					int x = i;
					int y = height - j - 1;
					char ch = line.charAt(i);

					if (ch == '*') {
						result.getBoardElements().add(new Wall(x, y));
					}

					if (ch == '_') {
						result.getBoardElements().add(new Platform(x, y));
					}

					if (ch == 'K') {
						result.getBoardElements().add(new ColorChanger(x, y));
					}

					if (ch == 'R') {
						result.getBoardElements().add(new ColorRestorer(x, y));
					}

					if (ch == '>') {
						result.getBoardElements().add(new Conveyor(x, y, ConveyorDirection.RIGHT));
					}

					if (ch == '<') {
						result.getBoardElements().add(new Conveyor(x, y, ConveyorDirection.LEFT));
					}

					if (ch == 'H') {
						result.getBoardElements().add(new Ladder(x, y));
					}
				}
			}

		} catch (Exception ex) {
			throw new RuntimeException("Failed to load board " + boardId + ": " + ex.getMessage(), ex);
		}

		return result;
	}
}
