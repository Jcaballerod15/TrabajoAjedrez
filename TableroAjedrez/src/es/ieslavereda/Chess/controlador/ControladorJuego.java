package es.ieslavereda.Chess.controlador;

import tablero.Tablero;

public class ControladorJuego {

	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	
	
	public ControladorJuego(Jugador jugadorBlancas, Jugador jugadorNegras) {
		super();
		this.jugadorBlancas = jugadorBlancas;
		this.jugadorNegras = jugadorNegras;
		this.tablero = new Tablero();
	}
	
	public void go() {
		
	}
}
