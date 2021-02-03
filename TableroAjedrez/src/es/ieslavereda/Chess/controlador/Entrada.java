package es.ieslavereda.Chess.controlador;

import java.util.Scanner;

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
			String texto = sc.nextLine();
			return texto;
		}
		
		public static int[] obtenerCoordenada() {
			
			String texto = obtenerCadena("Introduce una coordenada");
			while(!esCoordenada(texto)) {
				texto = obtenerCadena("La cadena no tiene el formato correcto [A0]. Pruebe otra vez.");
			}
			
			return stringToInt(texto.toUpperCase());
		}
		private static boolean esCoordenada(String coordenada) {
			coordenada=coordenada.toUpperCase();
			if(coordenada.length()!=2)
				return false;
			if(!(coordenada.charAt(0)>='A' && coordenada.charAt(0)<='J'))
				return false;
			if(!(coordenada.charAt(1)>='0' && coordenada.charAt(1)<='9'))
				return false;
			return true;
		}
		
		private static int[] stringToInt(String c) {
			
			int[] coordenada = new int[2];
			
			coordenada[0]= Integer.parseInt(String.valueOf(c.charAt(0)-'A'));
			coordenada[1]= Integer.parseInt(String.valueOf(c.charAt(1)));
			
			return coordenada;
			
		}
}
