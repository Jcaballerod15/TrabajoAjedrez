package tablero;

public class Knight extends Pieza{
	
	public Knight(Color color, Coordenadas pisicion, Tablero tablero) {
		super(pisicion, tablero);
		if(color == Color.WHITE)
			tipo = Tipo.WHITE_KNIGHT;
		else
			tipo = Tipo.BLACK_KNIGHT;
	}

	@Override
	public Lista<Coordenadas> getNextMovements() {
		Lista<Coordenadas> lista = new Lista<Coordenadas>();
		
		addCoordenada(posicion.arribaC().arribaC().derechaC(),lista);
		addCoordenada(posicion.arribaC().arribaC().izquierdaC(),lista);
		addCoordenada(posicion.abajoC().abajoC().derechaC(),lista);
		addCoordenada(posicion.abajoC().abajoC().izquierdaC(),lista);
		addCoordenada(posicion.derechaC().derechaC().abajoC(),lista);
		addCoordenada(posicion.derechaC().derechaC().arribaC(),lista);
		addCoordenada(posicion.izquierdaC().izquierdaC().arribaC(),lista);
		addCoordenada(posicion.izquierdaC().izquierdaC().abajoC(),lista);

		
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
