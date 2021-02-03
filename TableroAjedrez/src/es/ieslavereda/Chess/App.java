package es.ieslavereda.Chess;

import java.util.Scanner;

import es.ieslavereda.Chess.controlador.Jugador;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		String nombre;
		
		Jugador j1,j2;
		
		System.out.println("Introduzaca el nombre de j1");
		
		nombre = sc.nextLine();
		j1 = new Jugador(nombre);

	}

}
