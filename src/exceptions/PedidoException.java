package exceptions;

public class PedidoException extends Exception {

	private static final long serialVersionUID = 6455190196558860727L;

	public PedidoException(String mensaje){
		super(mensaje);
	}
}
