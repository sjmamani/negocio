package negocio;

import view.RubroView;

public class Rubro {

	private int codigo;
	private String descripcion;
	private boolean habilitado;
	
	public Rubro(String descripcion) {
		this.descripcion = descripcion;
		this.habilitado = true;
	}

	public Rubro(int codigo, String descripcion, boolean habilitado) {
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
	
	public RubroView toView(){
		return new RubroView(codigo, descripcion, habilitado);
	}
}
