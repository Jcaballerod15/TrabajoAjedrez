package tablero;

public class Pawn extends Pieza{
	public Pawn(Color color, Coordenadas pisicion, Tablero tablero) {
		super(pisicion, tablero);
		if(color == Color.WHITE)
			tipo = Tipo.WHITE_PAWN;
		else
			tipo = Tipo.BLACK_PAWN;
	}
	@Override
	public void moveTo(Coordenadas c) {
		super.moveTo(c);
		
		if(getColor()==Color.WHITE && posicion.getNumero()==8) {
			tablero.removePieza(this);
			tablero.getBlancas().addHead(new Queen(Color.WHITE, posicion, tablero));
		}else if(getColor()==Color.BLACK && posicion.getNumero()==1) {
			tablero.removePieza(this);
			tablero.getNegras().addHead(new Queen(Color.BLACK, posicion, tablero));
		}
	}
	@Override
	public Lista<Coordenadas> getNextMovements() {
		Lista<Coordenadas> lista = new Lista<Coordenadas>();
		
		if(this.getColor() == Color.WHITE) {
				if(tablero.coordenadaEnTablero(posicion.arribaC().izquierdaC())) {
					
					if(tablero.getCeldaAt(posicion.arribaC().izquierdaC()).contienePieza()){    
						if(tablero.getCeldaAt(posicion.arribaC().izquierdaC()).getPieza().getColor()!=getColor()) {
							lista.addHead(posicion.arribaC().izquierdaC());
						}
					}
				}
				if(tablero.coordenadaEnTablero(posicion.arribaC().derechaC())) {
					if(tablero.getCeldaAt(posicion.arribaC().derechaC()).contienePieza()){    
						if(tablero.getCeldaAt(posicion.arribaC().derechaC()).getPieza().getColor()!=getColor()) {
							lista.addHead(posicion.arribaC().derechaC());
						}
					}
				}
			if (posicion.getNumero()== 2) {
				if(tablero.coordenadaEnTablero(posicion.arribaC().arribaC())) {
					if(!tablero.getCeldaAt(posicion.arribaC().arribaC()).contienePieza() && !tablero.getCeldaAt(posicion.arribaC()).contienePieza()){	
						lista.addHead(posicion.arribaC().arribaC());
					}
				}
			}else {
				if(tablero.coordenadaEnTablero(posicion.arribaC())) {
					if(!tablero.getCeldaAt(posicion.arribaC()).contienePieza()){	
						lista.addHead(posicion.arribaC());
					}
				}
			}
		}else if(this.getColor() == Color.BLACK){
			
				if(tablero.coordenadaEnTablero(posicion.abajoC().izquierdaC())) {
					
					if(tablero.getCeldaAt(posicion.abajoC().izquierdaC()).contienePieza()){    
						if(tablero.getCeldaAt(posicion.abajoC().izquierdaC()).getPieza().getColor()!=getColor()) {
							lista.addHead(posicion.abajoC().izquierdaC());
						}
					}
				}
				if(tablero.coordenadaEnTablero(posicion.abajoC().derechaC())) {
					if(tablero.getCeldaAt(posicion.abajoC().derechaC()).contienePieza()){    
						if(tablero.getCeldaAt(posicion.abajoC().derechaC()).getPieza().getColor()!=getColor()) {
							lista.addHead(posicion.abajoC().derechaC());
						}
					}
				}
			if (posicion.getNumero()== 7) {
				if(tablero.coordenadaEnTablero(posicion.abajoC().abajoC())) {
					if(!tablero.getCeldaAt(posicion.abajoC().abajoC()).contienePieza() && !tablero.getCeldaAt(posicion.abajoC()).contienePieza()){	
						lista.addHead(posicion.abajoC().abajoC());
					}
				}
			}else {
				if(tablero.coordenadaEnTablero(posicion.abajoC())) {
					if(!tablero.getCeldaAt(posicion.abajoC()).contienePieza()){	
						lista.addHead(posicion.abajoC());
					}
				}
			}
		}else
			lista = null;
		
		return lista;
	}
}
