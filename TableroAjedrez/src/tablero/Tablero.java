package tablero;

public class Tablero {

	private Celda[][] tablero;
	private Lista<Pieza> blancas;
	private Lista<Pieza> negras;
	private Lista<Pieza> blancasEliminadas;
	private Lista<Pieza> negrasEliminadas;
	private Pieza reyNegro;
	private Pieza reyBlanco;

	public Tablero() {
		tablero = new Celda[8][8];
		blancas = new Lista<Pieza>();
		negras = new Lista<Pieza>();
		blancasEliminadas = new Lista<Pieza>();
		negrasEliminadas = new Lista<Pieza>();
		
		inicializar();
	}

	private void inicializar() {
		char letras='A';
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int col = 0; col < tablero[0].length; col++) {
				tablero[fila][col] = new Celda();
			}
		}
		negras.addHead(new Rook(Color.BLACK, new Coordenadas('A', 8), this));
		negras.addHead(new Knight(Color.BLACK, new Coordenadas('B', 8), this));
		negras.addHead(new Bishop(Color.BLACK, new Coordenadas('C', 8), this));
		negras.addHead(new Queen(Color.BLACK, new Coordenadas('D', 8), this));
		negras.addHead(reyNegro = new King(Color.BLACK, new Coordenadas('E', 8), this));
		negras.addHead(new Bishop(Color.BLACK, new Coordenadas('F', 8), this));
		negras.addHead(new Knight(Color.BLACK, new Coordenadas('G', 8), this));
		negras.addHead(new Rook(Color.BLACK, new Coordenadas('H', 8), this));
		
		negras.addHead(new Pawn(Color.BLACK, new Coordenadas('B', 4), this));
		
		for(int i =0;i<tablero.length; i++) {
			negras.addHead(new Pawn(Color.BLACK, new Coordenadas(letras, 7), this));
			letras++;
		}
		letras='A';
		for(int i =0;i<tablero.length; i++) {
			blancas.addHead(new Pawn(Color.WHITE, new Coordenadas(letras, 2), this));
			letras++;
		}
		
		blancas.addHead(new Pawn(Color.WHITE, new Coordenadas('C', 3), this));
		
		blancas.addHead(new Rook(Color.WHITE, new Coordenadas('A', 1), this));
		blancas.addHead(new Knight(Color.WHITE, new Coordenadas('B', 1), this));
		blancas.addHead(new Bishop(Color.WHITE, new Coordenadas('C', 1), this));
		blancas.addHead(new Queen(Color.WHITE, new Coordenadas('D', 1), this));
		blancas.addHead(reyBlanco = new King(Color.WHITE, new Coordenadas('E', 1), this));
		blancas.addHead(new Bishop(Color.WHITE, new Coordenadas('F', 1), this));
		blancas.addHead(new Knight(Color.WHITE, new Coordenadas('G', 1), this));
		blancas.addHead(new Rook(Color.WHITE, new Coordenadas('H', 1), this));
	}

	public boolean coordenadaEnTablero(Coordenadas coordenada) {
		if(coordenada.getLetra()>='A' && coordenada.getLetra()<='H') {
			if(coordenada.getNumero()>=1 && coordenada.getNumero()<=8)
				return true;
		}
		return false;
	}

	public boolean ChekBlancas() {
		boolean elemento=false;
		Lista<Coordenadas> todos = new Lista<Coordenadas>();
		Nodo<Pieza> aux = blancas.getCabeza();
		for(int i = 0 ;i<blancas.getSize();i++) {
			todos.addAll(aux.getInfo().getNextMovements());
			aux = aux.getSiguiente();
		}
		if(todos.contiene(reyNegro.posicion))
			elemento=true;
		
		return elemento;
	}
	public boolean ChekNegras() {
		boolean elemento=false;
		Lista<Coordenadas> todos = new Lista<Coordenadas>();
		Nodo<Pieza> aux = negras.getCabeza();
		for(int i = 0 ;i<negras.getSize();i++) {
			todos.addAll(aux.getInfo().getNextMovements());
			aux = aux.getSiguiente();
		}
		if(todos.contiene(reyBlanco.posicion))
			elemento=true;
		
		return elemento;
	}
	public Celda getCeldaAt(Coordenadas coordenada) {
		if(coordenadaEnTablero(coordenada)==true) {
			return tablero[8-coordenada.getNumero()][coordenada.getLetra()-'A'];
		}else
			return null;
	}
	public void removePieza(Pieza p) {
		if(p.getColor()==Color.WHITE) {
			blancas.getAndRemove(p);
			blancasEliminadas.addHead(p);
		}else {
			negras.getAndRemove(p);
			negrasEliminadas.addHead(p);
		}
		
	}
	

	public Pieza getReyNegro() {
		return reyNegro;
	}

	public Pieza getReyBlanco() {
		return reyBlanco;
	}

	public Lista<Pieza> getBlancasEliminadas() {
		return blancasEliminadas;
	}

	public Lista<Pieza> getNegrasEliminadas() {
		return negrasEliminadas;
	}

	public Lista<Pieza> getBlancas() {
		return blancas;
	}

	public void setBlancas(Lista<Pieza> blancas) {
		this.blancas = blancas;
	}

	public Lista<Pieza> getNegras() {
		return negras;
	}

	public void setNegras(Lista<Pieza> negras) {
		this.negras = negras;
	}

	public String print(Color color) {

		switch (color) {
		case WHITE:
			return printAsWhite();

		case BLACK:
			return printAsBlack();
		default:
			return "";
		}
	}

	private String printAsWhite() {
		int numero =9;
		String salida="";
		salida += "   A   B   C   D   E   F   G   H\n";
		salida += " ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗ \n";
		for (int fila = 0; fila < tablero.length; fila++) {
			salida += numero-=1;
			salida +="║";
			for (int col = 0; col < tablero[0].length; col++) {
				if (col == 7)
					salida +=" "+tablero[fila][col];
				else
					salida +=" "+ tablero[fila][col] + " |";
			}
			salida+=" ║ \n";
			if (fila == 7)
				salida+="";
			else
				salida+=" ╟───┼───┼───┼───┼───┼───┼───┼───╢\n";
		}
				salida+=" ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝ \n";
				
				salida+="Blancas: " + blancas.toString() + "\n";
				salida+="Negras: " + negras.toString() + "\n";
				salida+="Blancas Eliminadas: " + blancasEliminadas.toString() +" \n";
				salida+="Negras Eliminadas: " + negrasEliminadas.toString() +" \n";
				
		return salida;
	}

	private String printAsBlack() {
		int numero =9;
		String salida="";
		salida += "   A   B   C   D   E   F   G   H\n";
		salida += " ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗ \n";
		for (int fila = tablero.length-1; fila >=0; fila--) {
			salida += numero-=1;
			salida +="║";
			for (int col =tablero[0].length-1 ; col >= 0; col--) {
				if (col == 0)
					salida +=" "+tablero[fila][col];
				else
					salida +=" "+tablero[fila][col] + " |";
			}
			salida+=" ║ \n";
			if (fila == 0)
				salida+="";
			else
				salida+=" ╟───┼───┼───┼───┼───┼───┼───┼───╢\n";
		}
				salida+=" ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝ \n";
		return salida;
	}

}
