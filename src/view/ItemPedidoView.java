package view;



public class ItemPedidoView {

	private ProductoView producto;
	private int cantidad;
	private float precio;
	
	public ItemPedidoView(ProductoView producto, int cantidad, float precio) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public ProductoView getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public float getPrecio() {
		return precio;
	}
}
