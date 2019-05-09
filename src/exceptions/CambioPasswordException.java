package exceptions;

public class CambioPasswordException extends Exception {

	private static final long serialVersionUID = 476065450444918501L;

	public CambioPasswordException(String mensaje){
		super(mensaje);
	}
}
