package com.techlab.proyecto_final.pedidos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate fecha;
  private String estado;
  private double total;

  @OneToMany(cascade = CascadeType.ALL)
  private List<LineaPedido> lineas;

}
