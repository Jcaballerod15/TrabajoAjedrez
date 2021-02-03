package es.ieslavereda.tablerofichas;

import tablero.Coordenadas;
import tablero.Pieza;
import tablero.Tablero;
import tablero.*;

public class Test {

	public static void main(String[] args) {
		Tablero t = new Tablero();
		Coordenadas d = new Coordenadas('B',4);
		Coordenadas o = new Coordenadas('C',3);
		
		
		t.getCeldaAt(o).getPieza().moveTo(d);
		

		System.out.println(t.getCeldaAt(d).getPieza().getNextMovements());
		System.out.print(t.print(Color.WHITE));
		System.out.print(t.ChekBlancas());
	}
	
}
