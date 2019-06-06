package view;

public class ProductoView {

	private int identificador;
	private SubRubroView subRubro;
	private RubroView rubro;
	private String nombre;
	private String marca;
	private String codigoBarras;
	private float precio;
	
	public ProductoView(int identificador,SubRubroView subRubro, RubroView rubro, String nombre, String marca, String codigoBarras, float precio) {
		this.identificador = identificador;
		this.subRubro = subRubro;
		this.rubro = rubro;
		this.nombre = nombre;
		this.marca = marca;
		this.codigoBarras = codigoBarras;
		this.precio = precio;
	}

	public ProductoView() {
		// TODO Auto-generated constructor stub
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public void setSubRubro(SubRubroView subRubro) {
		this.subRubro = subRubro;
	}

	public void setRubro(RubroView rubro) {
		this.rubro = rubro;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public SubRubroView getSubRubro() {
		return subRubro;
	}

	public RubroView getRubro() {
		return rubro;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public float getPrecio() {
		return precio;
	}
	
	public String toString(){
		return nombre + " " + codigoBarras;
	}
	
}
