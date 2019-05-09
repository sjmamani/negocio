package view;

import java.io.Serializable;

public class RubroView implements Serializable{

	private static final long serialVersionUID = 9208466595959719081L;
	private int codigo;
	private String descripcion;
	private boolean habilitado;

	public RubroView(int codigo, String descripcion, boolean habilitado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.habilitado = habilitado;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public String toString(){
		return codigo + " - " + descripcion;
	}
}
