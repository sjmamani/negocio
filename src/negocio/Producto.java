package negocio;

import daos.ProductoDAO;
import view.ProductoView;

public class Producto {

	private int identificador;
	private SubRubro subRubro;
	private Rubro rubro;
	private String nombre;
	private String marca;
	private String codigoBarras;
	private float precio;
	
	public Producto(SubRubro subRubro, Rubro rubro, String nombre, String marca, String codigoBarras, float precio) {
		this.subRubro = subRubro;
		this.rubro = rubro;
		this.nombre = nombre;
		this.marca = marca;
		this.codigoBarras = codigoBarras;
		this.precio = precio;
	}

	public void save(){
		ProductoDAO.getInstancia().save(this);
	}
	
	public void update(){
		ProductoDAO.getInstancia().update(this);
	}
	
	public void delete(){
		ProductoDAO.getInstancia().delete(this);
	}
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}

	public SubRubro getSubRubro() {
		return subRubro;
	}

	public Rubro getRubro() {
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
	
	public ProductoView toView(){
		return new ProductoView(identificador, subRubro.toView(), rubro.toView(), nombre, marca, codigoBarras, precio);
	}

	public void setPrecio(float precio) {
		if(precio > 0)
			this.precio = precio;
	}
	
}
