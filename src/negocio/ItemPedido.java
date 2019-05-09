package negocio;


import daos.ItemPedidoDAO;
import view.ItemPedidoView;

public class ItemPedido {

	private int numero;
	private Producto producto;
	private int cantidad;
	private float precio;
	
	public ItemPedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = producto.getPrecio();
	}

	public ItemPedido(int numero, Producto producto, int cantidad, float precio) {
		this.numero = numero;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public void save(Pedido pedido) {
		ItemPedidoDAO.getInstancia().save(producto, cantidad, pedido);
	}
	
	public int getNumero() {
		return numero;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}
	
	public ItemPedidoView toView(){
		return new ItemPedidoView(producto.toView(), cantidad, precio);
	}	
}
