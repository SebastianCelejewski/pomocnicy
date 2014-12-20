package pl.sebcel.pomocnicy;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Bootstrap {

	public static void main(String[] args) throws Exception {
		WeldContainer container = new Weld().initialize();
		Main main = container.instance().select(Main.class).get();
		main.run();
	}
}
