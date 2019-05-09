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
@Table(name="itemspedido")
public class ItemPedidoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numeroItem")
	private int numero;
	@ManyToOne
	@JoinColumn(name="numeroPedido")	
	private PedidoEntity pedido;
	@ManyToOne
	@JoinColumn(name="identificador")
	private ProductoEntity producto;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="precio")
	private float precio;
	
	public ItemPedidoEntity() {}
	
	public ItemPedidoEntity(int numero, PedidoEntity pedido, ProductoEntity producto, int cantidad, float precio) {
		this.numero = numero;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio =  precio;
	}

	public ItemPedidoEntity(PedidoEntity pedido, ProductoEntity producto, int cantidad, float precio) {
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
