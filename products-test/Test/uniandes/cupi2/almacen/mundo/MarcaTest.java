package uniandes.cupi2.almacen.mundo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarcaTest
{
	private Marca marca;
	private Producto producto;
	private Producto producto2;

	@BeforeEach
	void setUpMarca() throws Exception
	{
		marca = new Marca("5245354", "Samsung");
		producto = new Producto("523525", "Lavadora", "Gran capacidad", 1200.5);
		producto2 = new Producto("251521", "Computador", "Procesador i5", 700);
		marca.agregarProducto("523525", "Lavadora", "Gran capacidad", 1200.5);
		marca.agregarProducto("251521", "Computador", "Procesador i5", 700);
	}

	@Test
	void testAgregarProducto() throws AlmacenException
	{
		assertEquals(producto.darCodigo(), marca.buscarProducto("523525").darCodigo(), "El producto encontrado no es el mismo");
	}
	
	@Test
	void testVenderProducto()
	{
		marca.venderProducto("251521", 2);
		assertEquals(1400, marca.darValorVentas(), "El valor de las ventas esta mal");
	}
	
	@Test
	void testDarProductos()
	{
		List<Producto> productos = marca.darProductos();
		assertEquals(producto2.darCodigo(), productos.get(0).darCodigo(), "Los productos dados estan mal");
		assertEquals(producto.darCodigo(), productos.get(1).darCodigo(), "Los productos dados estan mal");
	}
	
	@Test
	void testBuscarMarca()
	{
		assertEquals(marca, marca.buscarNodo("5245354"), "La marca encontrada esta mal");
	}
	
	@Test
	void testEliminarProducto()
	{
		marca.eliminarProducto("251521");
		assertEquals(1, marca.darProductos().size(), "No se elimino el producto correctamente");
	}
}
