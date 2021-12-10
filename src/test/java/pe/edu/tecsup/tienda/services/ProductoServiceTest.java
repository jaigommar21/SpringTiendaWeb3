package pe.edu.tecsup.tienda.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;

@SpringBootTest
class ProductoServiceTest {

	private static Logger log 
		= LoggerFactory.getLogger(ProductoServiceTest.class);

	@Autowired
	private ProductoService productoService;
	
	@Test
	void testListar() throws Exception {
		
		List<Producto> cats = productoService.findAll();
		
		log.info(">>>>" + cats.toString());
		
		assertThat(cats.isEmpty(), is(false));
		//assertThat(cats.size(), is(3));

	}
	
	@Test
	void testDummy() throws Exception {
		
		List<Producto> cats = productoService.findAll();

		log.info("Print by foreach");
		for(Producto cat : cats) log.info(cat.toString());
				
		log.info("Print by stream");
		cats.stream().forEach(item -> log.info(item.toString()));
		
		
	}
	
	@Test
	void testfindById() throws Exception {
		
		// buscanod productos
		Long id = 35L;
		Producto prod = productoService.findById(id);
		log.info(prod.toString());
		
		assertThat(prod.getNombre(), is("Kingstone"));
	}
	
	
	

	
	@Test
	public void testRegistar() throws Exception {
		
		List<Producto> productos = productoService.findAll();
		int totalAntes = productos.size();
		
		Producto productoNuevo = new Producto();
		
		// Forma de asignar una categoria
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		productoNuevo.setCategoria(categoria);

		productoNuevo.setNombre("AMD");
		productoNuevo.setDescripcion("AMD X21");
		productoNuevo.setPrecio(280.0);
		productoNuevo.setStock(6);
		productoNuevo.setEstado(1);

		// Graba	
		productoService.save(productoNuevo);	
		
		// Vuelve a leer todos los registros
		productos = productoService.findAll();
		int totalDespues = productos.size();
		
		assertThat(totalDespues - totalAntes, is(1));
	}
	
	@Test
	public void testEliminar() throws Exception {
		
		List<Producto> productos = productoService.findAll();

		int totalAntes = productos.size();
		
		if (productos.isEmpty()) {
			return; // test pass
		}

		// Obtiene el último producto
		Producto ultimoProducto = productos.get(productos.size() - 1);
		productoService.deleteById(ultimoProducto.getId());

		// Elimina el producto
		productos = productoService.findAll();

		// Vuelve a leer los datos
		int totalDespues = productos.size();
		
		assertThat(totalAntes - totalDespues, is(1));
	
	}

}
