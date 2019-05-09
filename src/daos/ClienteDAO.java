package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ClienteEntity;
import exceptions.ClienteException;
import hibernate.HibernateUtil;
import negocio.Cliente;

public class ClienteDAO {
	
	private static ClienteDAO instancia;
	
	private ClienteDAO() {}
	
	public static ClienteDAO getInstancia(){
		if(instancia == null)
			instancia = new ClienteDAO();
		return instancia;
	}
	
	public Cliente findClienteByCuit(String cuit) throws ClienteException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		ClienteEntity recuperado = (ClienteEntity) s.createQuery("from ClienteEntity where cuit = ?").setString(0, cuit).uniqueResult();
		if(recuperado != null)
			return this.toNegocio(recuperado);
		else
			throw new ClienteException("El Cliente con cuit " + cuit + " no existe");
	}

	public List<Cliente> findAll(){
		List<Cliente> resultado = new ArrayList<Cliente>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<ClienteEntity> recuperados = (List<ClienteEntity>) s.createQuery("from ClienteEntity").list();
		for(ClienteEntity ce : recuperados)
			resultado.add(toNegocio(ce));
		return resultado;
	}
	
	Cliente toNegocio(ClienteEntity recuperado) {
		return new Cliente(recuperado.getNumero(), recuperado.getNombre(), recuperado.getCuit(), recuperado.getActivo());
	}

	public ClienteEntity toEntity(Cliente cliente) {
		return new ClienteEntity(cliente.getNumero(), cliente.getNombre(), cliente.getCuil(), cliente.isActivo());
	}
}
