package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.SubRubroEntity;
import exceptions.SubRubroException;
import hibernate.HibernateUtil;
import negocio.Rubro;
import negocio.SubRubro;

public class SubRubroDao {

	private static SubRubroDao instancia;
	
	private SubRubroDao() {}
	
	public static SubRubroDao getInstancia(){
		if(instancia == null)
			instancia = new SubRubroDao();
		return instancia;
	}
	
	public SubRubro findByCodigo(int codigo) throws SubRubroException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		SubRubroEntity recuperado = (SubRubroEntity) s.createQuery("from SubRubroEntity where codigo = ?").setInteger(0, codigo).uniqueResult();
		if(recuperado != null)
			return this.toNegocio(recuperado);
		else
			throw new SubRubroException("No existe un subrubro con codigo " + codigo);
	}
	
	public List<SubRubro> findAll(){
		List<SubRubro> resultado = new ArrayList<SubRubro>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<SubRubroEntity> recuperados = s.createQuery("from SubRubroEntity").list();		
		for(SubRubroEntity aux : recuperados)
			resultado.add(this.toNegocio(aux));
		return resultado;
	}
	
	SubRubro toNegocio(SubRubroEntity recuperado){
		Rubro auxR = RubroDao.getInstancia().toNegocio(recuperado.getRubro());
		return new SubRubro(recuperado.getCodigo(), recuperado.getDescripcion(),auxR);
	}

	public SubRubroEntity toEntity(SubRubro recibido) {
		SubRubroEntity resultado = new SubRubroEntity(recibido.getCodigo(), recibido.getDescripcion(), RubroDao.getInstancia().toEntity(recibido.getRubro()));
		return resultado;
	}
}
