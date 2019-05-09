package negocio;

import view.SubRubroView;

public class SubRubro {

	private int codigo;
	private String descripcion;
	private Rubro rubro;
	
	public SubRubro(int codigo, String descripcion, Rubro rubro) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.rubro = rubro;
	}
	public SubRubro(String descripcion, Rubro rubro) {
		super();
		this.descripcion = descripcion;
		this.rubro = rubro;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Rubro getRubro() {
		return rubro;
	}
	public SubRubroView toView() {
		return new SubRubroView(codigo, descripcion, rubro.toView());
	}
}
