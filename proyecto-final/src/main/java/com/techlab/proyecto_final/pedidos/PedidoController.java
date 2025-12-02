package com.techlab.proyecto_final.pedidos;

import com.techlab.proyecto_final.servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {

  @Autowired
  private PedidoService pedidoService;

  @GetMapping
  public List<Pedido> listar() {
    return pedidoService.listarPedidos();
  }

  @PostMapping
  public Pedido crear(@RequestBody Pedido pedido) {
    return pedidoService.crearPedido(pedido);
  }
}
