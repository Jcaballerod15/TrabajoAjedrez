package tablero;

public class Lista<T> {

	private int size;
	private Nodo<T> cabeza;
	private Nodo<T> cola;

	public Lista() {
		super();

		size = 0;
		cabeza = null;
		cola = null;

	}

	public boolean contiene(T c) {
		boolean encontrado = false;
		Nodo<T> aux = cabeza;

		while (aux != null && !encontrado) {
			if (aux.getInfo().equals(c))
				encontrado = true;

			aux = aux.getSiguiente();
		}

		return encontrado;
	}

	public void addHead(T numero) {

		Nodo<T> nodo = new Nodo<T>(numero);

		if (cabeza == null) {
			cabeza = nodo;
			cola = nodo;
		} else {
			nodo.setSiguiente(cabeza);
			cabeza.setAnterior(nodo);
			cabeza = nodo;
		}
		size++;
	}

	public Lista<T> addAll(Lista<T> lista) {

		Nodo<T> n = cabeza;

		n = lista.cabeza;
		while (n != null) {
			addHead(n.getInfo());
			n = n.getSiguiente();
		}
		return this;
	}

	public void addTail(T numero) {

		Nodo<T> aux = new Nodo<T>(numero);

		if (cola == null) {
			cabeza = aux;
			cola = aux;
		} else {
			aux.setAnterior(cola);
			cola.setSiguiente(aux);
			cola = aux;
		}
		size++;
	}

	// Preguntar sobre getHead
	public T getHead() {
		T valor = null;

		if (cabeza == null) {
			return null;
		} else if (cabeza == cola) {
			valor = cabeza.getInfo();
			cabeza = null;
			cola = null;
			size--;
		} else {
			valor = cabeza.getInfo();
			cabeza.getSiguiente().setAnterior(null);
			cabeza = cabeza.getSiguiente();
			size--;
		}
		return valor;
	}
	public Nodo<T> getCabeza() {
		return cabeza;
	}
	public T getAndRemove(T elemento) {
		if (cabeza == null) {
			return null;
		} else if (elemento.equals(cabeza.getInfo())) {
			return getHead();
		} else if (elemento.equals(cola.getInfo())) {
			return getTail();
		} else {
			Nodo<T> aux = cabeza.getSiguiente();
			T valor = null;

			while (aux != null && valor == null) {
				if (aux.getInfo().equals(elemento))
					valor = elemento;
				else
					aux = aux.getSiguiente();
			}
			if (valor != null) {
				aux.getAnterior().setSiguiente(aux.getSiguiente());
				aux.getSiguiente().setAnterior(aux.getAnterior());
				size--;
			}
			return valor;
		}
	}

	public T getTail() {
		T valor = null;

		if (cabeza == null) {
			return null;
		} else if (cabeza == cola) {
			valor = cabeza.getInfo();
			cabeza = null;
			cola = null;
			size--;
		} else {
			valor = cola.getInfo();
			cola.getAnterior().setSiguiente(null);
			cola = cola.getAnterior();
			size--;
		}

		return valor;
	}

	public int search(T info) {
		int posicion = -1;
		Nodo<T> aux = cabeza;
		int i = 0;

		while (aux != null && posicion == -1) {
			if (info.equals(aux.getInfo())) {
				posicion = i;
			}
			i++;
			aux = aux.getSiguiente();
		}

		return posicion;
	}

	public T get(int numero) {
		if (numero == 0) {
			return getHead();
		} else if (numero == size - 1) {
			return getTail();
		} else if (numero < 0 && numero < size) {
			Nodo<T> aux = cabeza;
			int i = 0;
			while (i < numero) {
				aux = aux.getSiguiente();
				i++;
			}
			aux.getAnterior().setSiguiente(aux.getSiguiente());
			aux.getSiguiente().setAnterior(aux.getAnterior());
			size--;

			return aux.getInfo();
		} else
			return null;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {

		String salida = "size " + size + "\n";
		Nodo<T> aux = cabeza;

		while (aux != null) {
			salida += aux.toString() + " ";
			aux = aux.getSiguiente();
		}

		return salida;
	}
}
