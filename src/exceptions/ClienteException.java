package exceptions;

public class ClienteException extends Exception {

	private static final long serialVersionUID = -6870726006778848177L;

	public ClienteException(String mensaje){
		super(mensaje);
	}
}
