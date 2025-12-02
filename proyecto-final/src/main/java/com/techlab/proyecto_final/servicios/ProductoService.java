package com.techlab.proyecto_final.servicios;

import com.techlab.proyecto_final.productos.Producto;
import com.techlab.proyecto_final.productos.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

  @Autowired
  private ProductoRepository productoRepository;

  public List<Producto> listarProductos() {
    return productoRepository.findAll();
  }

  public Producto guardarProducto(Producto p) {
    return productoRepository.save(p);
  }

  public void eliminarProducto(Long id) {
    productoRepository.deleteById(id);
  }

  public Producto buscarPorId(Long id) {
    return productoRepository.findById(id).orElse(null);
  }
}
