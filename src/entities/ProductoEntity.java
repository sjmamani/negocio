package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identificador")
	private int identificador;
	
	@ManyToOne
	@JoinColumn(name="identificadorSubRubro")
	private SubRubroEntity subRubro;
	
	@ManyToOne
	@JoinColumn(name="identificadorRubro")
	private RubroEntity rubro;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="codigoBarras")
	private String codigoBarras;
	
	@Column(name="precio")
	private float precio;
	
	public ProductoEntity() { }

	public ProductoEntity(int identificador, SubRubroEntity subRubro, RubroEntity rubro, String nombre, String marca, String codigoBarras, float precio) {
		this.identificador = identificador;
		this.subRubro = subRubro;
		this.rubro = rubro;
		this.nombre = nombre;
		this.marca = marca;
		this.codigoBarras = codigoBarras;
		this.precio = precio;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
 
	public SubRubroEntity getSubRubro() {
		return subRubro;
	}

	public void setSubRubro(SubRubroEntity subRubro) {
		this.subRubro = subRubro;
	}

	public RubroEntity getRubro() {
		return rubro;
	}

	public void setRubro(RubroEntity rubro) {
		this.rubro = rubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
