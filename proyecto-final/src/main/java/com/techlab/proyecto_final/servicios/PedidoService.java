package com.techlab.proyecto_final.servicios;

import com.techlab.proyecto_final.excepciones.StockInsuficienteException;
import com.techlab.proyecto_final.pedidos.LineaPedido;
import com.techlab.proyecto_final.pedidos.Pedido;
import com.techlab.proyecto_final.pedidos.PedidoRepository;
import com.techlab.proyecto_final.productos.Producto;
import com.techlab.proyecto_final.productos.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private ProductoRepository productoRepository;

  public List<Pedido> listarPedidos() {
    return pedidoRepository.findAll();
  }

  public Pedido crearPedido(Pedido pedido) {
    double total = 0;

    for (LineaPedido linea : pedido.getLineas()) {
      Producto producto = productoRepository.findById(linea.getProducto().getId())
          .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

      if (linea.getCantidad() > producto.getStock()) {
        throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
      }

      producto.reducirStock(linea.getCantidad());
      productoRepository.save(producto);

      linea.setSubtotal(linea.getCantidad() * producto.getPrecio());
      total += linea.getSubtotal();
    }

    pedido.setFecha(LocalDate.now());
    pedido.setEstado("PENDIENTE");
    pedido.setTotal(total);

    return pedidoRepository.save(pedido);
  }
}