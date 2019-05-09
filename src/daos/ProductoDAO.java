package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ProductoEntity;
import entities.RubroEntity;
import entities.SubRubroEntity;
import exceptions.ProductoException;
import hibernate.HibernateUtil;
import negocio.Producto;
import negocio.Rubro;
import negocio.SubRubro;

public class ProductoDAO {

	private static ProductoDAO instancia;
	
	private ProductoDAO() {}
	
	public static ProductoDAO getInstancia(){
		if(instancia == null)
			instancia = new ProductoDAO();
		return instancia;
	}
	
	public Producto findProductoByCodigo(String codigoBarras) throws ProductoException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		ProductoEntity recuperado = (ProductoEntity) s.createQuery("from ProductoEntity where codigoBarras = ?").setString(0, codigoBarras).uniqueResult();	
		if(recuperado != null)
			return this.toNegocio(recuperado);
		else
			throw new ProductoException("No existe el producto cuyo codigo de barras es " + codigoBarras);
	}
	
	public Producto findProductoByIdentificador(int identificador) throws ProductoException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		ProductoEntity recuperado = (ProductoEntity) s.createQuery("from ProductoEntity where identificador = ?").setInteger(0, identificador).uniqueResult();	
		if(recuperado != null)
			return this.toNegocio(recuperado);
		else
			throw new ProductoException("No existe el producto cuyo identificador es "  + identificador);
	}
	
	public List<Producto> findAll() {
		List<Producto> resultado = new ArrayList<Producto>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<ProductoEntity> recuperados = s.createQuery("from ProductoEntity").list();	
		for(ProductoEntity pe : recuperados)
			resultado.add(this.toNegocio(pe));
		return resultado;
	}
	
	public List<Producto> findProductoByRubro(int identificadorRubro){
		List<Producto> resultado = new ArrayList<Producto>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<ProductoEntity> recuperados = s.createQuery("from ProductoEntity where rubro.codigo = ?").setInteger(0, identificadorRubro).list();	
		for(ProductoEntity pe : recuperados)
			resultado.add(this.toNegocio(pe));
		return resultado;
	}

	public List<Producto> findProductoBySubRubro(int identificadorSubRubro){
		List<Producto> resultado = new ArrayList<Producto>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<ProductoEntity> recuperados = s.createQuery("from ProductoEntity where subRubro.codigo = ?").setInteger(0, identificadorSubRubro).list();	
		for(ProductoEntity pe : recuperados)
			resultado.add(this.toNegocio(pe));
		return resultado;
	}
	
	public List<Producto> findProductoByMarca(String marca){
		List<Producto> resultado = new ArrayList<Producto>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<ProductoEntity> recuperados = s.createQuery("from ProductoEntity where marca = ?").setString(0, marca).list();	
		for(ProductoEntity pe : recuperados)
			resultado.add(this.toNegocio(pe));
		return resultado;
	}
	
	public void save(Producto producto){ 
		ProductoEntity pe = this.toEntity(producto);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(pe);
		s.getTransaction().commit();
		producto.setIdentificador(pe.getIdentificador());
	}


	public void update(Producto producto) {
		ProductoEntity pe = this.toEntity(producto);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(pe);
		s.getTransaction().commit();
	}

	public void delete(Producto producto) {
		ProductoEntity pe = this.toEntity(producto);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.delete(pe);
		s.getTransaction().commit();
	}
	
	Producto toNegocio(ProductoEntity recuperado){
		Rubro auxR = RubroDao.getInstancia().toNegocio(recuperado.getRubro());
		SubRubro auxSR = SubRubroDao.getInstancia().toNegocio(recuperado.getSubRubro());
		Producto aux = new Producto(auxSR, auxR, recuperado.getNombre(), recuperado.getMarca(), recuperado.getCodigoBarras(), recuperado.getPrecio());
		aux.setIdentificador(recuperado.getIdentificador());
		return aux;	
	}
	
	ProductoEntity toEntity(Producto producto) {
		RubroEntity auxR = RubroDao.getInstancia().toEntity(producto.getRubro());
		SubRubroEntity auxSR = SubRubroDao.getInstancia().toEntity(producto.getSubRubro());
		ProductoEntity aux = new ProductoEntity(producto.getIdentificador(),auxSR, auxR,producto.getNombre(), producto.getMarca(), producto.getCodigoBarras(), producto.getPrecio());
		return aux;
	}
}
