package daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ClienteEntity;
import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import exceptions.PedidoException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Producto;

public class PedidoDAO {
	
	private static PedidoDAO instancia;
	
	private PedidoDAO() {}
	
	public static PedidoDAO getInstancia(){
		if(instancia == null)
			instancia = new PedidoDAO();
		return instancia;
	}
	
	public Pedido findPedidoByNumero(int numero) throws PedidoException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		PedidoEntity recuperado = (PedidoEntity) s.createQuery("from PedidoEntity where numeroPedido = ?").setInteger(0, numero).uniqueResult();	
		s.getTransaction().commit();
		if(recuperado == null)
			throw new PedidoException("No Existe el pedido " + numero);
		else
			return this.toNegocio(recuperado);
	}
	
	public List<Pedido> findPedidoByCliente(Cliente cliente){
		List<Pedido> resultado = new ArrayList<Pedido>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<PedidoEntity> recuperados = (List<PedidoEntity>) s.createQuery("from PedidoEntity where cliente.numero = ?").setInteger(0, cliente.getNumero()).uniqueResult();
		for(PedidoEntity pe : recuperados)
			resultado.add(this.toNegocio(pe));
		s.getTransaction().commit();
		
		return resultado;
	}
	
	public List<Pedido> findPedidoByEstado(String estado){
		List<Pedido> resultado = new ArrayList<Pedido>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<PedidoEntity> recuperados = (List<PedidoEntity>) s.createQuery("from PedidoEntity where estado = ?").setString(0, estado).uniqueResult();
		for(PedidoEntity pe : recuperados)
			resultado.add(this.toNegocio(pe));
		s.getTransaction().commit();	
		return resultado;
	}
	/*OK*/
	public void save(Pedido pedido){ 
		PedidoEntity aux = toEntity(pedido);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(aux);	
		s.getTransaction().commit();
		pedido.setNumeroPedido(aux.getNumeroPedido());
	}
	
	public void delete(int numero) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		PedidoEntity recuperado = (PedidoEntity) s.createQuery("from PedidoEntity where numeroPedido = ?").setInteger(0, numero).uniqueResult();	
		System.out.println(recuperado.getItems().size());
		s.delete(recuperado);
		s.getTransaction().commit();
	}
	/*OK*/
	public void updateEstado(Pedido pedido) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
        String hqlUpdate = "update PedidoEntity set estado  = 'facturado' where numeroPedido = :numero";
        s.createQuery(hqlUpdate)
	        .setParameter("numero", pedido.getNumeroPedido())
	        .executeUpdate();	
		s.getTransaction().commit();
	}
	
	Pedido toNegocio(PedidoEntity pe){
		Cliente cliente = ClienteDAO.getInstancia().toNegocio(pe.getCliente());
		Pedido pedido = new Pedido(pe.getNumeroPedido(), cliente, pe.getFechaPedido(), pe.getEstado());
		List<ItemPedidoEntity> auxItems = null;
		if(pe.getItems() != null)
			auxItems = pe.getItems();
		else
			auxItems = new ArrayList<ItemPedidoEntity>(); 
		for(ItemPedidoEntity ipe : auxItems){
			Producto producto = ProductoDAO.getInstancia().toNegocio(ipe.getProducto());
			System.out.println("En PEdido DAO que paso con el precio " + ipe.getPrecio());
			pedido.addProductoEnPedido(ipe.getNumero(), producto, ipe.getCantidad(), ipe.getPrecio());
		}
		return pedido;
	}
	
	PedidoEntity toEntity(Pedido p){
		PedidoEntity pedido = new PedidoEntity();
		ClienteEntity cliente = ClienteDAO.getInstancia().toEntity(p.getCliente());
		pedido.setCliente(cliente);
		pedido.setEstado(p.getEstado());
		pedido.setFechaPedido(new java.sql.Date(p.getFechaPedido().getTime()));
		pedido.setNumeroPedido(pedido.getNumeroPedido());
		pedido.setItems(new ArrayList<ItemPedidoEntity>());
		return pedido;
	}


}
