package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoView {

	private int numeroPedido;
	private ClienteView cliente;
	private Date fechaPedido;
	private String estado;
	List<ItemPedidoView> items;
	
	public PedidoView(int numeroPedido, ClienteView cliente, Date fechaPedido, String estado) {
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
		this.items = new ArrayList<ItemPedidoView>();
	}

	public PedidoView() {
		// TODO Auto-generated constructor stub
	}

	public void addItemEnPedido(ItemPedidoView item){
		items.add(item);
	}
	
	public int getNumeroPedido() {
		return numeroPedido;
	}

	public ClienteView getCliente() {
		return cliente;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public String getEstado() {
		return estado;
	}

	public List<ItemPedidoView> getItems() {
		return items;
	}
	
	public String toString(){
		return numeroPedido + " " + cliente.getNombre();
	}

	public void setCliente(ClienteView auxC) {
		this.cliente = auxC;
		
	}
	
}
