package tablero;

public class Rook extends Pieza {

	public Rook(Color color, Coordenadas pisicion, Tablero tablero) {
		super(pisicion, tablero);
		if (color == Color.WHITE)
			tipo = Tipo.WHITE_ROOK;
		else
			tipo = Tipo.BLACK_ROOK;
	}

	@Override
	public Lista<Coordenadas> getNextMovements(){
		return getNextMovements(tablero,this);
	}
	public static Lista<Coordenadas> getNextMovements(Tablero t,Pieza p) {
		Lista<Coordenadas> lista = new Lista<Coordenadas>();

		addCoordenadaUp(t, p ,lista);
		addCoordenadaDawn(t,p ,lista);
		addCoordenadaLeft(t,p,lista);
		addCoordenadaRight(t,p,lista);
		
		return lista;
	}

	private static void addCoordenadaRight(Tablero t, Pieza p, Lista<Coordenadas> lista) {
		
		Coordenadas i = p.posicion.derechaC();
		
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.derechaC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}

	private static void addCoordenadaLeft(Tablero t, Pieza p, Lista<Coordenadas> lista) {
		
		Coordenadas i = p.posicion.izquierdaC();
		
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.izquierdaC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}

	private static void addCoordenadaUp(Tablero t, Pieza p,Lista<Coordenadas> lista) {

		Coordenadas i = p.posicion.arribaC();
		
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.arribaC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}
	
	private static void addCoordenadaDawn(Tablero t, Pieza p, Lista<Coordenadas> lista) {

		Coordenadas i = p.posicion.abajoC();
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.abajoC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}
	
}
