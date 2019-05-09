package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import daos.PedidoDAO;
import view.PedidoView;

public class Pedido {

	private int numeroPedido;
	private Cliente cliente;
	private Date fechaPedido;
	private String estado;
	List<ItemPedido> items;
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.fechaPedido = Calendar.getInstance().getTime();
		this.estado = "pendiente";
		this.items = new ArrayList<ItemPedido>();
	}

	public Pedido(int numeroPedido, Cliente cliente, Date fechaPedido, String estado) {
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
		this.items = new ArrayList<ItemPedido>();
	}

	public void addProductoEnPedido(Producto producto, int cantidad){
		ItemPedido itemPedido = new ItemPedido(producto, cantidad);
		itemPedido.save(this);
		items.add(itemPedido);
		
	}
	
	public void addProductoEnPedido(int numero, Producto producto, int cantidad, float precio){
		items.add(new ItemPedido(numero, producto, cantidad, precio));
	}
	
	public int getNumeroPedido() {
		return numeroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public String getEstado() {
		return estado;
	}
	
	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public PedidoView toView(){
		PedidoView aux = new PedidoView(numeroPedido, cliente.toView(), fechaPedido, estado);
		for(ItemPedido ip : items)
			aux.addItemEnPedido(ip.toView());
		return aux;
	}

	public void facturar() {
		this.estado = "facturado";
		PedidoDAO.getInstancia().updateEstado(this);
	}

	public int save() {
		PedidoDAO.getInstancia().save(this);
		return this.numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
}
