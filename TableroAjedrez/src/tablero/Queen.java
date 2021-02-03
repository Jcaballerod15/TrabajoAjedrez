package tablero;

public class Queen extends Pieza{
	
	public Queen(Color color, Coordenadas pisicion, Tablero tablero) {
		super(pisicion, tablero);
		if(color == Color.WHITE)
			tipo = Tipo.WHITE_QUEEN;
		else
			tipo = Tipo.BLACK_QUEEN;
	}

	@Override
	public Lista<Coordenadas> getNextMovements() {
		
		return Rook.getNextMovements(tablero, this).addAll(Bishop.getNextMovements(tablero, this));
		
		
	}
}
