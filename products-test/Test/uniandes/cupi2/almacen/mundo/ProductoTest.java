package uniandes.cupi2.almacen.mundo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest
{
	private static final int pVentas = 4;
	private static final double precision = 0.05;
	private static final String pCodigo = "24881271";
	private static final String pNombre = "Full HD Smart TV";
	private static final String pDescripcion = "Un imponente televisor";
	private static final double pPrecio = 100.5;
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private Producto producto4;
	private Producto producto5;

	@BeforeEach
	void setUpProducto() throws Exception
	{
		producto1 = new Producto(pCodigo, pNombre, pDescripcion, pPrecio );
		producto2 = new Producto("251521", "Computador", "Procesador i5", 700);
		producto3 = new Producto("523525", "Lavadora", "Gran capacidad", 1200.5);
		producto4 = new Producto("635647", "Portatil", "Poco peso", 950.5);
		producto5 = new Producto("66647", "Portatil Gamer", "Grafica NVIDIA", 635.5);
		producto1.vender(pVentas);
	}
	
	void setUp2() throws Exception
	{
		
        /*BufferedReader in = new BufferedReader( new FileReader( pArchivo ) );
		String datos[] = pLector.readLine( ).split( ";;;" );
		producto2 = new Producto(pCodigo, pNombre, pDescripcion, pPrecio );
		*/
	}

	@Test
	public void testGetters()
	{
		assertEquals(pCodigo, producto1.darCodigo(), "El código está mal");
		assertEquals(pNombre, producto1.darNombre(), "El nombre está mal");
		assertEquals(pDescripcion, producto1.darDescripcion(), "La descripción está mal");
		assertTrue(Math.abs(pPrecio - producto1.darPrecio()) < precision, "El precio esta mal");	
		assertEquals(pVentas, producto1.darCantidadUnidadesVendidas(), "Las unidades vendidas no coinciden");
		assertTrue(Math.abs(402 - producto1.darValorVentas()) < precision, "El precio esta mal");

	}
	
	@Test
	void testComparar()
	{
		String pCodigo2 = producto2.darCodigo();
		String codeEqual = "24881271";
		String codeMenor = "1";
		assertEquals(-1, producto1.comparar(pCodigo2), "La comparacion de los codigos esta mal");
		assertEquals(0, producto1.comparar(codeEqual), "La comparacion de los codigos esta mal");
		assertEquals(1, producto1.comparar(codeMenor), "La comparacion de los codigos esta mal");
		
	}

	@Test
	void testArbol() throws AlmacenException
	{
		producto1.cambiarHijoIzquierda(producto2);
		producto1.cambiarHijoDerecha(producto3);
		assertEquals(3, producto1.darPeso(), "El peso esta mal");
		assertSame(producto2, producto1.darHijoIzquierda(), "El producto hijo izquierda no coincide");
		assertSame(producto3, producto1.darHijoDerecha(), "El producto hijo derecha no coincide");
		producto1.agregarProducto(producto4);
		assertEquals(producto4, producto1.buscarProducto("635647"), "La busqueda del producto esta mal");
		producto1.eliminarProducto("635647", producto2);
		assertEquals(3, producto1.darPeso(), "El peso esta mal");
		List<Producto> productos = new ArrayList<>();
		productos.add(producto5);
		producto1.darInorden(productos);
		assertEquals(producto5.darCodigo(), productos.get(0).darCodigo(), "El inorden esta mal");
		assertEquals(producto2.darCodigo(), productos.get(1).darCodigo(), "El inorden esta mal");
		assertEquals(producto1.darCodigo(), productos.get(2).darCodigo(), "El inorden esta mal");
		assertEquals(producto3.darCodigo(), productos.get(3).darCodigo(), "El inorden esta mal");
	}	
}