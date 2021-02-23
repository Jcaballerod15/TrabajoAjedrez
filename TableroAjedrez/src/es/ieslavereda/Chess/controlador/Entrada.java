package es.ieslavereda.Chess.controlador;

import java.util.Scanner;

import tablero.Coordenadas;

public class Entrada {
	// Muestra un mensaje pasado el parametro msg y
		// devuelve un String de longitud = 2
		private static String obtenerCadena(String msg) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println(msg);
			String texto = sc.nextLine();
			
			if(texto.length()!=2) 			
				return obtenerCadena("Solo debes introducir dos caracteres. Prueba otra vez");
						
			return texto;
			
		}
		public static String texto() {
			Scanner sc = new Scanner(System.in);
			String textos = sc.nextLine();
			return textos.toUpperCase();
		}
		
		public static Coordenadas obtenerCoordenada(String frase) {
			
			String texto = obtenerCadena(frase);
			while(!esCoordenada(texto)) {
				texto = obtenerCadena("La cadena no tiene el formato correcto [A0] o esta fuera del tablero.");
			}
			
			return new Coordenadas(texto.charAt(0),Integer.parseInt(texto.substring(1)));
		}
		private static boolean esCoordenada(String coordenada) {
			coordenada=coordenada.toUpperCase();
			if(coordenada.length()!=2)
				return false;
			if(!(coordenada.charAt(0)>='A' && coordenada.charAt(0)<='H'))
				return false;
			if(!(coordenada.charAt(1)>='1' && coordenada.charAt(1)<='8'))
				return false;
			return true;
		}
		
//		private static char[] stringToInt(String c) {
//			
//			char[] coordenada = new char[2];
//			
//			coordenada[0]= c.charAt(0);
//			coordenada[1]= c.charAt(1);
//			
//			return coordenada;
//			
//		}
}
