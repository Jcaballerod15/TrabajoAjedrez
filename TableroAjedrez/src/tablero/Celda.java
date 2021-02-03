package tablero;

public class Celda {

	private Pieza pieza;

	public Celda() {
		super();
		this.pieza = null;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public boolean contienePieza() {
		return pieza != null;
	}

	@Override
	public String toString() {
		if (pieza == null)
			return " ";
		else
			return pieza.toString();
	}

}
