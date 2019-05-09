package controlador;

import java.util.ArrayList;
import java.util.List;

import daos.ClienteDAO;
import daos.PedidoDAO;
import daos.ProductoDAO;
import daos.RubroDao;
import daos.SubRubroDao;
import daos.UsuarioDAO;
import exceptions.CambioPasswordException;
import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.PedidoException;
import exceptions.ProductoException;
import exceptions.RubroException;
import exceptions.SubRubroException;
import exceptions.UsuarioException;
import negocio.Cliente;
import negocio.Pedido;
import negocio.Producto;
import negocio.Rubro;
import negocio.SubRubro;
import negocio.Usuario;
import view.ClienteView;
import view.PedidoView;
import view.ProductoView;
import view.RubroView;
import view.SubRubroView;

public class Controlador {
	
	private static Controlador instancia;
	
	private Controlador(){ }
	
	public static Controlador getInstancia(){
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}

	/**
	 * Verifica el login y el password ingresado, si son incorrecto lanza un LoginException
	 * 
	 * Si el password tiene mas de x días lanza un CambioPasswordException indicando que la password está vencida
	 * @throws UsuarioException 
	 * 
	 * */
	public boolean login(String nombre, String password) throws LoginException, CambioPasswordException, UsuarioException{
		Usuario usuario = UsuarioDAO.getInstancia().getUsuarioByNombre(nombre);
		if(usuario.getPassword().equals(password)){
			if(usuario.debeCambiar()) {
				throw new CambioPasswordException("La password esta vencida, debe cambiarla");
			}
			return true;
		}
		else{
			throw new LoginException("Los datos ingresado no son corrector, reingrese");
		}
	}
	/**
	 * Permite cambiar el password de un usuario existente.
	 * 
	 * El password debe serguir las reglas de formacion y frecuencia.
	 * 
	 * 
	 * */
	/*Probado*/
	public void cambioPassword(String nombre, String password) throws CambioPasswordException, UsuarioException{
		Usuario usuario = UsuarioDAO.getInstancia().getUsuarioByNombre(nombre);
		usuario.actualizoPassword(password);
	}
	/*Probado*/
	public void altaProducto(ProductoView recibido) throws RubroException, SubRubroException{
		Rubro auxR = RubroDao.getInstancia().findByCodigo(recibido.getRubro().getCodigo());
		SubRubro auxSR = SubRubroDao.getInstancia().findByCodigo(recibido.getSubRubro().getCodigo());
		Producto producto = new Producto(auxSR,auxR,recibido.getNombre(), recibido.getMarca(), recibido.getCodigoBarras(), recibido.getPrecio());
		producto.save();
	}
	/*Probado*/
	public void bajaProducto(ProductoView recibido) throws ProductoException{
		Producto producto = ProductoDAO.getInstancia().findProductoByIdentificador(recibido.getIdentificador());
		producto.delete();
		producto = null;
	}
	/*Probado*/
	public void modificaProducto(ProductoView recibido) throws ProductoException{
		Producto producto = ProductoDAO.getInstancia().findProductoByIdentificador(recibido.getIdentificador());
		producto.update();
	}
	/*Probado*/
	public int crearPedido(PedidoView pedido) throws ClienteException{
		Cliente cliente = ClienteDAO.getInstancia().findClienteByCuit(pedido.getCliente().getCuil());
		Pedido nuevoPedido = new Pedido(cliente);
		nuevoPedido.save();
		return nuevoPedido.getNumeroPedido();
	}
	/*Probado*/
	public int crearPedido(String cuit) throws ClienteException {
		Cliente cliente = ClienteDAO.getInstancia().findClienteByCuit(cuit);
		Pedido nuevoPedido = new Pedido(cliente);
		nuevoPedido.save();
		return nuevoPedido.getNumeroPedido();		
	}
	/*Probado*/
	public void agregarProductoEnPedido(int numeroPedido, int identificadorProducto, int cantidad) throws PedidoException, ProductoException{
		Pedido pedido = PedidoDAO.getInstancia().findPedidoByNumero(numeroPedido);
		Producto producto = ProductoDAO.getInstancia().findProductoByIdentificador(identificadorProducto);
		pedido.addProductoEnPedido(producto, cantidad);
	}
	/*Probado*/
	public void eliminarPedido(int numeroPedido){
		PedidoDAO.getInstancia().delete(numeroPedido);
	}
	/*Probado*/
	public void facturarPedido(int numero) throws PedidoException{
		PedidoDAO.getInstancia().findPedidoByNumero(numero).facturar();
	}
	/*Probado*/
	public PedidoView getPedidoById(int numero) throws PedidoException{
		return PedidoDAO.getInstancia().findPedidoByNumero(numero).toView();
	}
	/*Probado*/	
	public List<RubroView> getRubros(){
		List<RubroView> resultado = new ArrayList<RubroView>();
		for(Rubro r : RubroDao.getInstancia().findAll())
			resultado.add(r.toView());
		return resultado;
	}
	/*Probado*/
	public List<SubRubroView> getSubRubros(){
		List<SubRubroView> resultado = new ArrayList<SubRubroView>();
		for(SubRubro r : SubRubroDao.getInstancia().findAll())
			resultado.add(r.toView());
		return resultado;
	}
	/*Probado*/
	public List<ProductoView> getProductos(){
		List<ProductoView> resultado = new ArrayList<ProductoView>();
		List<Producto> productos = ProductoDAO.getInstancia().findAll();
		for(Producto producto : productos)
			resultado.add(producto.toView());
		return resultado;
	}
	/*Probado*/
	public List<ProductoView> getProductosByRubro(RubroView rubro){
		List<ProductoView> resultado = new ArrayList<ProductoView>();
		List<Producto> productos = ProductoDAO.getInstancia().findProductoByRubro(rubro.getCodigo());
		for(Producto producto : productos)
			resultado.add(producto.toView());
		return resultado;
	}
	/*Probado*/
	public List<ProductoView> getProductosBySubRubro(SubRubroView subRubro){
		List<ProductoView> resultado = new ArrayList<ProductoView>();
		List<Producto> productos = ProductoDAO.getInstancia().findProductoBySubRubro(subRubro.getCodigo());
		for(Producto producto : productos)
			resultado.add(producto.toView());
		return resultado;
	}
	/*Probado*/
	public List<ClienteView> getClientes(){
		List<ClienteView> resultado = new ArrayList<ClienteView>();
		List<Cliente> clientes = ClienteDAO.getInstancia().findAll();
		for(Cliente cliente : clientes)
			resultado.add(cliente.toView());
		return resultado;
	}

}
