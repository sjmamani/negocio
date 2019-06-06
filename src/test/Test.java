package test;

import controlador.Controlador;
import daos.ClienteDAO;
import daos.UsuarioDAO;
import exceptions.CambioPasswordException;
import exceptions.ClienteException;
import negocio.Cliente;
import negocio.Usuario;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * SubRubro r1 = SubRubroDao.getInstancia().findByCodigo(2);
		 * System.out.println(r1.getDescripcion() + " " +
		 * r1.getRubro().getDescripcion()); List<SubRubro> rubros =
		 * SubRubroDao.getInstancia().findAll(); for(SubRubro r : rubros)
		 * System.out.println(r.getDescripcion() + " " + r.getRubro().getDescripcion());
		 */

		/*
		 * Producto p =
		 * ProductoDAO.getInstancia().findProductoByCodigo("7790040930209");
		 * 
		 * System.out.println(p.getNombre()); List<Producto> ps =
		 * ProductoDAO.getInstancia().findProductoByMarca("Coca-Cola"); for(Producto pp
		 * : ps) System.out.println(pp.getCodigoBarras() + ":" + pp.getNombre() + " - "
		 * + pp.getRubro().getDescripcion());
		 */

		//System.out.println(Controlador.getInstancia().getRubros().size());
		// Controlador.getInstancia().getSubRubros();
		/*
		 * System.out.println(Controlador.getInstancia().getProductos().size());
		 * SubRubroView aux = new SubRubroView(); aux.setCodigo(18);
		 * System.out.println(Controlador.getInstancia().getProductosBySubRubro(aux).
		 * size());
		 */

		/*
		 * Producto p = ProductoDAO.getInstancia().findProductoByIdentificador(2450);
		 * System.out.println(p.getPrecio()); p.setPrecio(1500.50f); p.update(); p =
		 * ProductoDAO.getInstancia().findProductoByIdentificador(2450);
		 * System.out.println(p.getPrecio());
		 */
		/*
		 * RubroView r1 = Controlador.getInstancia().getRubros().get(2); SubRubroView
		 * sr1 = Controlador.getInstancia().getSubRubros().get(2); ProductoView alta =
		 * new ProductoView(sr1, r1, "Chotext", "Chottoy", "34567891212", 2345.67f); try
		 * { Controlador.getInstancia().altaProducto(alta); } catch (RubroException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		// Producto p = ProductoDAO.getInstancia().findProductoByIdentificador(2463);
		// p.delete();*/
		// Usuario aux = UsuarioDAO.getInstancia().getUsuarioByNombre("Admin");
		// System.out.println(aux.getNombre() + " " + aux.getPassword());
		// try {
		// aux.deshabilitarUsario();

		// } catch (CambioPasswordException e) {
		// e.printStackTrace();
		// }
		// String[] lista = aux.getUltimasPasswords();
		// for(int i=0; i<aux.getCantidadPasswords(); i++)
		// System.out.println(lista[i]);

		/*
		 * try { //Controlador.getInstancia().login("User_01", "CacaMann2");
		 * Controlador.getInstancia().cambioPassword("User_01", "CambioNro01");
		 * System.out.println("Cambiado???"); } catch (CambioPasswordException e) { //
		 * TODO Auto-generated catch block System.out.println(e.getMessage()); }
		 */

		// System.out.println(Controlador.getInstancia().getClientes().size());
		/*
		 * try { System.out.println(ClienteDAO.getInstancia().findClienteByCuit(
		 * "30-31374667-1").getNombre()); } catch (ClienteException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * try { Pedido p = PedidoDAO.getInstancia().findPedidoByNumero(1); } catch
		 * (PedidoException e) { // TODO Auto-generated catch block e.printStackTrace();
		 * }
		 */
		// PedidoView aux = new PedidoView();
		// ClienteView auxC = new ClienteView();
		// auxC.setCuil("30-30702760-1");
		// aux.setCliente(auxC);
		// PedidoDAO.getInstancia().save(aux);
		// Producto pr = ProductoDAO.getInstancia().findProductoByIdentificador(9);
//		p.addProductoEnPedido(pr, 333);
		// System.out.println(p.getCliente().getNombre() + " " + p.getItems().size());
		/*
		 * for(ItemPedido ip : p.getItems()) System.out.println("\t" +
		 * ip.getProducto().getNombre()); PedidoDAO.getInstancia().save(p);
		 */

		// PedidoDAO.getInstancia().delete(1002);

		/*
		 * try { int numero = Controlador.getInstancia().crearPedido("30-31374667-1");
		 * Controlador.getInstancia().agregarProductoEnPedido(numero, 23, 220);
		 * Controlador.getInstancia().agregarProductoEnPedido(numero, 33, 320);
		 * Controlador.getInstancia().agregarProductoEnPedido(numero, 43, 420);
		 * PedidoView pedido = Controlador.getInstancia().getPedidoById(numero);
		 * System.out.println(pedido.toString()); for(ItemPedidoView ipv :
		 * pedido.getItems()) System.out.println(ipv.getCantidad() + " " +
		 * ipv.getProducto().getNombre() + " " + ipv.getPrecio());
		 * System.out.println(pedido.getItems().size());
		 * Controlador.getInstancia().eliminarPedido(3);
		 * 
		 * } catch (PedidoException | ProductoException | ClienteException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		try {
			//Usuario u = new Usuario("admin12345");
			System.out.println(Controlador.getInstancia().login("admin12345", "admin12345"));

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
