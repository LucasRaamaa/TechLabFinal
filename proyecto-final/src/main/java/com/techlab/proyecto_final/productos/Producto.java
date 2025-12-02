package com.techlab.proyecto_final.productos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String descripcion;
  private double precio;
  private int stock;

  public void reducirStock(int cantidad){
    if(cantidad > stock){
      throw new RuntimeException("Stock insuficiente para el producto: "+ nombre);
    }
    this.stock -= cantidad;
  }
}
