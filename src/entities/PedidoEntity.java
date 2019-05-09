package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import daos.ItemPedidoDAO;

@Entity
@Table(name="pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numeroPedido;
	@ManyToOne
	@JoinColumn(name="numeroCliente")
	private ClienteEntity cliente;
	@Column(name="fechaPedido")
	private Date fechaPedido;
	@Column(name="estadoPedido")
	private String estado;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="numeroPedido")
	List<ItemPedidoEntity> items;
	
	public PedidoEntity() {}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemPedidoEntity> getItems() {
		
		return ItemPedidoDAO.getInstancia().getAll(this);
	}

	public void setItems(List<ItemPedidoEntity> items) {
		this.items = items;
	}
	
}
