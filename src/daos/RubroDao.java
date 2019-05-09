package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.RubroEntity;
import exceptions.RubroException;
import hibernate.HibernateUtil;
import negocio.Rubro;

public class RubroDao {

	private static RubroDao instancia;
	
	private RubroDao() {}
	
	public static RubroDao getInstancia(){
		if(instancia == null)
			instancia = new RubroDao();
		return instancia;
	}
	
	public Rubro findByCodigo(int codigo) throws RubroException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		RubroEntity recuperado = (RubroEntity) s.createQuery("from RubroEntity where codigo = ?").setInteger(0, codigo).uniqueResult();
		if(recuperado != null)
			return this.toNegocio(recuperado);
		else
			throw new RubroException("El rubro buscado no existe");
	}
	
	public List<Rubro> findAll(){
		List<Rubro> resultado = new ArrayList<Rubro>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<RubroEntity> recuperados = s.createQuery("from RubroEntity").list();		
		for(RubroEntity aux : recuperados)
			resultado.add(this.toNegocio(aux));
		return resultado;
	}
	
	Rubro toNegocio(RubroEntity recuperado){
		return new Rubro(recuperado.getCodigo(),recuperado.getDescripcion(), recuperado.isHabilitado());
	}

	public RubroEntity toEntity(Rubro rubro) {
		RubroEntity resultado = new RubroEntity(rubro.getCodigo(), rubro.getDescripcion(), rubro.isHabilitado());
		return resultado;
	}
}
