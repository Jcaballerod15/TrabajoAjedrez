package es.ieslavereda.Chess.controlador;

import tablero.Color;
import tablero.Coordenadas;
import tablero.Tablero;
import tablero.*;

public class ControladorJuego {

	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	private Color turno = Color.WHITE;

	public ControladorJuego(Jugador jugadorBlancas, Jugador jugadorNegras) {
		super();
		this.jugadorBlancas = jugadorBlancas;
		this.jugadorNegras = jugadorNegras;
		this.tablero = new Tablero();

	}

	public void go() {
		do {
		Coordenadas c;
		Coordenadas c1;
		int fin = 0;
		switch (turno) {
		case WHITE:
			do {
				System.out.println( tablero.print(turno));
				if (tablero.ChekNegras()) {
					System.out.println("Su rey esta en JAQUE");
				}
				
				c = Entrada.obtenerCoordenada("Introduce una coordenada con la pieza deseada");
				if (tablero.getCeldaAt(c).contienePieza()) {
					if (tablero.getCeldaAt(c).getPieza().getColor() == turno) {
						System.out.println();
						c1 = Entrada.obtenerCoordenada("Introduce una coordenada con la posicion deseada");
						tablero.getCeldaAt(c).getPieza().moveTo(c1);
						fin = 1;
					} else
						System.out.println("Seleccione una pieza de su color");
				} else 
					System.out.println("Seleccione un pieza");
			} while (fin == 0);
			fin = 0;
			cambiarTurno();
			break;
		case BLACK:
			do {
				System.out.println( tablero.print(turno));
				if (tablero.ChekBlancas()) {
					System.out.println("Su rey esta en JAQUE");
				}
				c = Entrada.obtenerCoordenada("Introduce una coordenada con la pieza deseada");
				if (tablero.getCeldaAt(c).contienePieza()) {
					if (tablero.getCeldaAt(c).getPieza().getColor() == turno) {
						System.out.println();
						c1 = Entrada.obtenerCoordenada("Introduce una coordenada con la posicion deseada");
						tablero.getCeldaAt(c).getPieza().moveTo(c1);
						fin =1;
					} else
						System.out.println("Seleccione una pieza de su color");
				} else
					System.out.println("Seleccione un pieza");
			} while (fin == 0);
			cambiarTurno();
			break;
		}
	}while(!tablero.getBlancasEliminadas().contiene(tablero.getReyBlanco()) && !tablero.getNegrasEliminadas().contiene(tablero.getReyNegro()));
		if(tablero.getBlancasEliminadas().contiene(tablero.getReyBlanco())) {
			System.out.println("El ganador es el jugador: " + jugadorNegras.getNombre());
		}else if(tablero.getNegrasEliminadas().contiene(tablero.getReyNegro())) {
			System.out.println("El ganador es el jugador: " + jugadorBlancas.getNombre());
		}
	}

	private void cambiarTurno() {
		turno = Color.values()[(turno.ordinal() + 1) % Color.values().length];
	}
}
