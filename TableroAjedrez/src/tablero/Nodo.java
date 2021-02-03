package tablero;

public class Nodo<T> {

	private T info;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;
	
	public Nodo(T info) {
		super();
		this.info = info;
		siguiente = null;
		anterior=null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}
	@Override
	public String toString() {
		return String.valueOf(info);
	}
}
