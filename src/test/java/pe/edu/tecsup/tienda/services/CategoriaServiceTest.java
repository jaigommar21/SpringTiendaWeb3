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
class CategoriaServiceTest {

	private static Logger log 
		= LoggerFactory.getLogger(CategoriaServiceTest.class);

	@Autowired
	CategoriaService categoriaService;
	
	@Test
	void testListar() throws Exception {
		
		List<Categoria> cats = categoriaService.findAll();
		
		log.info(">>>>" + cats.toString());
		
		assertThat(cats.isEmpty(), is(false));
		//assertThat(cats.size(), is(3));

	}
	
	@Test
	void testDummy() throws Exception {
		
		List<Categoria> categorias = categoriaService.findAll();

		log.info("Print by foreach");
		for(Categoria cat : categorias) log.info(cat.toString());
				
		log.info("Print by stream");
		categorias.stream().forEach(item -> log.info(item.toString()));
		
		log.info(" - Lista de categorias -------------- ");
		for (Categoria categoria : categorias) {
			log.info("---> " + categoria);
			log.info(" - Lista de producto por categoria -------------- ");
			for (Producto producto : categoria.getProductos()) {
				log.info("-------> " + producto);
			}
		}
		log.info(" ----------------------------------- ");


	}

	
}
