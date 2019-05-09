package view;

public class SubRubroView {

	private int codigo;
	private String descripcion;
	private RubroView rubro;
	
	public SubRubroView(int codigo, String descripcion, RubroView rubro) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.rubro = rubro;
	}

	public SubRubroView() { }

	public int getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public RubroView getRubro() {
		return rubro;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setRubro(RubroView rubro) {
		this.rubro = rubro;
	}
	
	public String toString(){
		return codigo + " - " + descripcion;
	}
}
