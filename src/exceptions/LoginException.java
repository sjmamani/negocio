package exceptions;

public class LoginException extends Exception {

	private static final long serialVersionUID = 6051571522547168108L;

	public LoginException(String mensaje){
		super(mensaje);
	}
}
