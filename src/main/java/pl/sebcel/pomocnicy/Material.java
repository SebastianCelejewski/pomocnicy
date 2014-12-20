package pl.sebcel.pomocnicy;

public class Material {

	public static final Material BORDER = new Material(false);
	public static final Material VOID = new Material(true);

	private boolean accessible;

	public Material(boolean accessible) {
		this.accessible = accessible;
	}

	public boolean isAccessible() {
		return accessible;
	}

}