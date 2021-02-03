package es.ieslavereda.tablerofichas;

import tablero.Coordenadas;
import tablero.Pieza;
import tablero.Tablero;
import es.ieslavereda.Chess.controlador.Entrada;
import tablero.*;

public class Test {

	public static void main(String[] args) {
		Tablero t = new Tablero();
		Coordenadas d = new Coordenadas('B',4);
		Coordenadas o = new Coordenadas('C',3);
		
		
		t.getCeldaAt(o).getPieza().moveTo(d);
		

		System.out.println(t.getCeldaAt(d).getPieza().getNextMovements());
		System.out.print(t.print(Color.WHITE));
		System.out.println(t.ChekBlancas());
//		System.out.println(Entrada.obtenerCoordenada());
		System.out.println(t.getCeldaAt(d).contienePieza());
	}
	
}
