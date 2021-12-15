package pe.edu.tecsup.tienda.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;

	
	@GetMapping("/")
	public String index(Model model) throws Exception {
		
		logger.info("call index()");
		
		List<Producto> productos = productoService.findAll();
		
		//logger.info(">>>>>" + productos.toString());
		
		productos.stream().forEach(prod -> logger.info(prod.toString()));
		
		model.addAttribute("productos", productos);
		
		return "productos/index";
	}

	@GetMapping("/create")
	public String create(Model model) throws Exception {
		
		logger.info("call create()");
		
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "productos/create";
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("producto") Producto producto, Errors errors, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttrs) throws Exception{

		logger.info("call store(producto: " + producto + ")");
		
		//producto.setCreado(new Date());
		
		producto.setEstado(1);  // Activo 
		
		productoService.save(producto); // Save
		
		redirectAttrs.addFlashAttribute("message", "Registro guardado correctamente");
		
		return "redirect:/productos/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) throws Exception {
		
		logger.info("Delete(id: " + id + ")");
		
		productoService.deleteById(id);
		
		redirectAttrs.addFlashAttribute("message", "Registro eliminado correctamente");
		
		return "redirect:/productos/";
	}


}
