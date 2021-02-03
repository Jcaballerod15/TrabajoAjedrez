package es.ieslavereda.Chess;

import java.util.Scanner;

import es.ieslavereda.Chess.controlador.Entrada;
import es.ieslavereda.Chess.controlador.Jugador;
import es.ieslavereda.Chess.controlador.ControladorJuego;

public class App {

	public static void main(String[] args) {
		
		
		String nombre;
		
		Jugador j1,j2;
		
		System.out.println("Introduzaca el nombre de j1");
		nombre = Entrada.texto();
		j1 = new Jugador(nombre); 
		System.out.println("Introduzaca el nombre de j2");
		nombre = Entrada.texto();
		j2 = new Jugador(nombre); 
		
		ControladorJuego p1 = new ControladorJuego(j1,j2);
		p1.go();
	}

}
