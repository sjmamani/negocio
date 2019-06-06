package negocio;

import view.ClienteView;

public class Cliente {

	private int numero;
	private String nombre;
	private String cuit;
	private boolean activo;
	
	public Cliente(String nombre, String cuil) {
		this.nombre = nombre;
		this.cuit = cuil;
		activo = true;
	}

	public Cliente(int numero, String nombre, String cuit, String activo) {
		this.numero = numero;
		this.nombre = nombre;
		this.cuit = cuit;
		if(activo.equals("true"))
			this.activo = true;
		else
			this.activo = false;
	}
	
	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCuil() {
		return cuit;
	}

	public boolean isActivo() {
		return activo;
	}
	
	public ClienteView toView(){
		return new ClienteView(numero, nombre, cuit, activo);
	}
}
