package tablero;

public abstract class Pieza {

	protected Tipo tipo;
	protected Tablero tablero;
	protected Coordenadas posicion;

	public Pieza(Coordenadas pisicion, Tablero tablero) {
		super();
		this.posicion = pisicion;
		this.tablero = tablero;
		colocate();
	}

	public boolean canMoveTo(Coordenadas c) {

		return getNextMovements().contiene(c);
	}

	public void moveTo(Coordenadas c) {

		if (tablero.getCeldaAt(c).contienePieza()) 
			tablero.removePieza(tablero.getCeldaAt(c).getPieza());

			tablero.getCeldaAt(posicion).setPieza(null);
			posicion = c;
			colocate();

	}

	private void colocate() {
		tablero.getCeldaAt(posicion).setPieza(this);
	}

	public Color getColor() {
		return tipo.getColor();
	}

	@Override
	public String toString() {
		return tipo.getForma();
	}

	public abstract Lista<Coordenadas> getNextMovements();
}
