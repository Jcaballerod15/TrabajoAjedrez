package tablero;

public class Bishop extends Pieza{
	
	public Bishop(Color color, Coordenadas pisicion, Tablero tablero) {
		super(pisicion, tablero);
		if(color == Color.WHITE)
			tipo = Tipo.WHITE_BISHOP;
		else
			tipo = Tipo.BLACK_BISHOP;
	}

	@Override
	public Lista<Coordenadas> getNextMovements(){
		return getNextMovements(tablero,this);
	}
	public static Lista<Coordenadas> getNextMovements(Tablero t,Pieza p) {
		Lista<Coordenadas> lista = new Lista<Coordenadas>();

		addCoordenadaUpLeft(t, p ,lista);
		addCoordenadaDawnLeft(t,p ,lista);
		addCoordenadaUpRight(t,p,lista);
		addCoordenadaDawnRight(t,p,lista);
		
		return lista;
	}

	private static void addCoordenadaDawnRight(Tablero t, Pieza p, Lista<Coordenadas> lista) {
		
		Coordenadas i = p.posicion.derechaC().abajoC();
		
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.derechaC().abajoC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}

	private static void addCoordenadaUpRight(Tablero t, Pieza p, Lista<Coordenadas> lista) {
		
		Coordenadas i = p.posicion.derechaC().arribaC();
		
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.derechaC().arribaC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}

	private static void addCoordenadaUpLeft(Tablero t, Pieza p,Lista<Coordenadas> lista) {

		Coordenadas i = p.posicion.arribaC().izquierdaC();
		
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.arribaC().izquierdaC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}
	
	private static void addCoordenadaDawnLeft(Tablero t, Pieza p, Lista<Coordenadas> lista) {

		Coordenadas i = p.posicion.abajoC().izquierdaC();
		while (t.coordenadaEnTablero(i) && !t.getCeldaAt(i).contienePieza()) {
			lista.addHead(i);
			i = i.abajoC().izquierdaC();
		}
		if(t.coordenadaEnTablero(i)) {
			if (t.getCeldaAt(i).getPieza().getColor() != p.getColor()) 
				lista.addHead(i);
		}
	}
}
