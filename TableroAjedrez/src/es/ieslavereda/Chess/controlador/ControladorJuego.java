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
		char[] aux ;
		Coordenadas c = null;
		Coordenadas c1 = null;
		switch (turno) {
		case WHITE:
			do {
				System.out.println( tablero.print(turno));
				if (tablero.ChekNegras()) {
					System.out.println("Su rey esta en JAQUE");
				}
				aux=Entrada.obtenerCoordenada();
				c = new Coordenadas(aux[0], aux[1]);
				if (tablero.getCeldaAt(c).contienePieza()) {
					if (tablero.getCeldaAt(c).getPieza().getColor() == turno) {
						System.out.println();
						c1 = new Coordenadas(Entrada.obtenerCoordenada()[0], Entrada.obtenerCoordenada()[1]);
						tablero.getCeldaAt(c).getPieza().moveTo(c1);
					} else
						System.out.println("Seleccione una pieza de su color");
				} else
					System.out.println("Seleccione un pieza");
			} while (c1 == null);
			cambiarTurno();
			break;
		case BLACK:
			do {
				System.out.println( tablero.print(turno));
				if (tablero.ChekBlancas()) {
					System.out.println("Su rey esta en JAQUE");
				}
				aux=Entrada.obtenerCoordenada();
				c = new Coordenadas(aux[0], aux[1]);
				if (tablero.getCeldaAt(c).contienePieza()) {
					if (tablero.getCeldaAt(c).getPieza().getColor() == turno) {
						System.out.println();
						c1 = new Coordenadas(Entrada.obtenerCoordenada()[0], Entrada.obtenerCoordenada()[1]);
						tablero.getCeldaAt(c).getPieza().moveTo(c1);
					} else
						System.out.println("Seleccione una pieza de su color");
				} else
					System.out.println("Seleccione un pieza");
			} while (c1 == null);
			cambiarTurno();
			break;
		}
	}while(!tablero.getBlancasEliminadas().contiene(tablero.getReyBlanco()) && !tablero.getNegrasEliminadas().contiene(tablero.getReyNegro()));
		if(tablero.getBlancasEliminadas().contiene(tablero.getReyBlanco())) {
			System.out.println("El ganador es el jugador: " + jugadorNegras);
		}else if(tablero.getNegrasEliminadas().contiene(tablero.getReyNegro())) {
			System.out.println("El ganador es el jugador: " + jugadorBlancas);
		}
	}

	private void cambiarTurno() {
		turno = Color.values()[(turno.ordinal() + 1) % Color.values().length];
	}
}
