package com.techlab.proyecto_final.productos;

import com.techlab.proyecto_final.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @GetMapping
  public List<Producto> listar() {
    return productoService.listarProductos();
  }

  @PostMapping
  public Producto crear(@RequestBody Producto p) {
    return productoService.guardarProducto(p);
  }

  @GetMapping("/{id}")
  public Producto obtener(@PathVariable Long id) {
    return productoService.buscarPorId(id);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    productoService.eliminarProducto(id);
  }
}
