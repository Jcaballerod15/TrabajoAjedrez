package tablero;

public class King extends Pieza{
	
	public King(Color color, Coordenadas pisicion, Tablero tablero) {
		super(pisicion, tablero);
		if(color == Color.WHITE)
			tipo = Tipo.WHITE_KING;
		else
			tipo = Tipo.BLACK_KING;
	}

	@Override
	public Lista<Coordenadas> getNextMovements() {
		Lista<Coordenadas> lista = new Lista<Coordenadas>();
		
		addCoordenada(posicion.arribaC(),lista);
		addCoordenada(posicion.abajoC(),lista);
		addCoordenada(posicion.derechaC(),lista);
		addCoordenada(posicion.izquierdaC(),lista);
		addCoordenada(posicion.diagonalArDr(),lista);
		addCoordenada(posicion.diagonalArIz(),lista);
		addCoordenada(posicion.diagonalAbIz(),lista);
		addCoordenada(posicion.diagonalAbDr(),lista);
	
	
		return lista;
	}
	private void addCoordenada(Coordenadas c, Lista<Coordenadas> lista) {
		if(tablero.coordenadaEnTablero(c)) {
			if(tablero.getCeldaAt(c).contienePieza()) {
				if(tablero.getCeldaAt(c).getPieza().getColor()!=getColor()) {
					lista.addHead(c);
				}
			}else {	
				lista.addHead(c);
			}
		}
	
	}
}
