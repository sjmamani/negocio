package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClienteEntity;
import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import entities.ProductoEntity;
import entities.RubroEntity;
import entities.SubRubroEntity;
import entities.UsuarioEntity;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(ClienteEntity.class);
        	 config.addAnnotatedClass(RubroEntity.class);
        	 config.addAnnotatedClass(SubRubroEntity.class);
        	 config.addAnnotatedClass(ProductoEntity.class);
        	 config.addAnnotatedClass(PedidoEntity.class);
        	 config.addAnnotatedClass(ItemPedidoEntity.class);
        	 config.addAnnotatedClass(UsuarioEntity.class);
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed. -->" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
