package pe.edu.tecsup.tienda.services;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Producto;

public interface ProductoService {

	List<Producto> findAll();

	Producto findById(Long id);

	Producto save(Producto producto);

	void deleteById(Long id);

}
