package tablero;

public class Coordenadas {

	private int numero;
	private char letrasT;

	public Coordenadas(char letras,int numero) {
//		if (numero <0 || numero>8)
//			this.numero=0;
//		else
			this.numero = numero;
//		
//		String let= String.valueOf(letras);
//		char letrasAchar = let.toUpperCase().charAt(0);
//		if ( letrasAchar < 'A' || letrasAchar > 'H')
//			this.letrasT='A';
//		else
		this.letrasT= letras;
//		
	}
	
	public Coordenadas arribaC() {
		return new Coordenadas(letrasT,numero+1);
		
	}
	public Coordenadas abajoC() {
		return new Coordenadas(letrasT,numero-1);
	}
	public Coordenadas derechaC() {
		return new Coordenadas((char)(letrasT+1),numero);
	}
	public Coordenadas izquierdaC() {
		return new Coordenadas((char)(letrasT-1),numero);
	}
	public Coordenadas diagonalArIz() {
		return arribaC().izquierdaC();
	}
	public Coordenadas diagonalArDr() {
		return arribaC().derechaC();
	}
	public Coordenadas diagonalAbIz() {
		return abajoC().izquierdaC();
	}
	public Coordenadas diagonalAbDr() {
		return abajoC().derechaC();
	}
	
	public int getNumero() {
		return numero;
	}


	public char getLetra() {
		return letrasT;
	}
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Coordenadas) {
			Coordenadas c = (Coordenadas) o;
			return c.numero== numero && c.letrasT==letrasT;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(letrasT) + numero;
	}

}
