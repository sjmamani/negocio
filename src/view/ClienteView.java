package view;

public class ClienteView {
	
	private int numero;
	private String nombre;
	private String cuil;
	private boolean activo;
	
	public ClienteView(int numero, String nombre, String cuil, boolean activo) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.cuil = cuil;
		this.activo = activo;
	}

	public ClienteView() { }

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCuil() {
		return cuil;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString(){
		return numero + " - " + nombre;
	}
}
