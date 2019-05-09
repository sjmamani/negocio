package daos;

import java.sql.Date;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.UsuarioEntity;
import exceptions.UsuarioException;
import hibernate.HibernateUtil;
import negocio.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instancia;
	
	private UsuarioDAO() {}
	
	public static UsuarioDAO getInstancia(){
		if(instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
	}

	public void updatePassword(Usuario usuario) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		UsuarioEntity recuperado = (UsuarioEntity) s.createQuery("from UsuarioEntity where nombre = ?").setString(0, usuario.getNombre()).uniqueResult();	
		if(recuperado != null){
		recuperado.setPassword(usuario.getPassword());
		recuperado.setUltimaFechaCambio(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		recuperado.setPasswordsAnteriores(usuario.getUltimasPasswords());
		recuperado.setCantidad(usuario.getCantidadPasswords());
		s.update(recuperado);
		s.getTransaction().commit();
		}
		else
			throw new UsuarioException("No existe el usuario " + usuario.getNombre());
	}
	
	public void update(Usuario usuario) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		UsuarioEntity recuperado = (UsuarioEntity) s.createQuery("from UsuarioEntity where nombre = ?").setString(0, usuario.getNombre()).uniqueResult();	
		if(recuperado != null){
		recuperado.setPassword(usuario.getPassword());
		recuperado.setUltimaFechaCambio((Date) usuario.getUltimaFechaCambio());
		recuperado.setPasswordsAnteriores(usuario.getUltimasPasswords());
		recuperado.setCantidad(usuario.getCantidadPasswords());
		if(usuario.isHabilitado())
			recuperado.setHabilitado("Si");
		else
			recuperado.setHabilitado("No");
		s.update(recuperado);
		s.getTransaction().commit();
		}
		else
			throw new UsuarioException("No existe el usuario " + usuario.getNombre());
		
	}
	
	public Usuario getUsuarioByNombre(String nombre) throws UsuarioException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		UsuarioEntity recuperado = (UsuarioEntity) s.createQuery("from UsuarioEntity where nombre = ?").setString(0, nombre).uniqueResult();	
		s.getTransaction().commit();
		if(recuperado != null)
			return toNegocio(recuperado);
		else
			throw new UsuarioException("No existe el usuaio " + nombre); 
	}
	
	public void save(Usuario usuario){
		UsuarioEntity aux = toEntity(usuario);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(aux);
		s.getTransaction().commit();
	}
	
	
	UsuarioEntity toEntity(Usuario usuario){
		return null;
	}
	
	Usuario toNegocio(UsuarioEntity usuario){
		boolean habilitado = false;
		if(usuario.getHabilitado().equals("Si"))
			habilitado = true;
		Usuario resultado = new Usuario(usuario.getNombre(), usuario.getPassword(), habilitado, usuario.getUltimaFechaCambio(), usuario.getPasswordsAnteriores(), usuario.getCantidad());
		return resultado;
	}
}
