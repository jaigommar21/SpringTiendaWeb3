package pe.edu.tecsup.tienda.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.tecsup.tienda.entities.Producto;

public interface ProductoRepository 
		extends CrudRepository<Producto, Long> {

	// CRUD : Create, Read , Update and Delete 
	
	@Override
	List<Producto> findAll();
	
}
