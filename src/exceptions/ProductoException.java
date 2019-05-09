package exceptions;

public class ProductoException extends Exception {

	private static final long serialVersionUID = 7294563459313946178L;

	public ProductoException(String mensaje){
		super(mensaje);
	}
}
