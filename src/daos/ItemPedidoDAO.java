package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import exceptions.ProductoException;
import hibernate.HibernateUtil;
import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Producto;

public class ItemPedidoDAO {

	private static ItemPedidoDAO instancia;
	
	private ItemPedidoDAO() {}
	
	public static ItemPedidoDAO getInstancia(){
		if(instancia == null)
			instancia = new ItemPedidoDAO();
		return instancia;
	}
	
	public List<ItemPedidoEntity> getAll(PedidoEntity pedido) {
		List<ItemPedidoEntity> resultado = new ArrayList<ItemPedidoEntity>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<ItemPedidoEntity> recuperados = s.createQuery("from ItemPedidoEntity where pedido.numeroPedido = ?").setInteger(0, pedido.getNumeroPedido()).list();	
		for(ItemPedidoEntity pe : recuperados)
			resultado.add(pe);
		return resultado;
	}
	public void save(Producto producto, int cantidad, Pedido pedido){
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		String insert = String.format("insert into itemsPedido (numeroPedido, identificador, cantidad, precio) values (?,?,?,?)");
		s.createSQLQuery(insert)
			.setParameter(0, pedido.getNumeroPedido())
			.setParameter(1, producto.getIdentificador())
			.setParameter(2, cantidad)
			.setParameter(3, producto.getPrecio())
			.executeUpdate();
		s.getTransaction().commit();
	}
	
	ItemPedido toNegocio(ItemPedidoEntity recuperado) throws ProductoException{
		Producto producto = ProductoDAO.getInstancia().findProductoByIdentificador(recuperado.getProducto().getIdentificador());
		ItemPedido aux = new ItemPedido(recuperado.getNumero(), producto, recuperado.getCantidad(), recuperado.getPrecio());
		return aux;	
	}
}
