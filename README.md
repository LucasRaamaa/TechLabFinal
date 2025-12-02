Proyecto Final – TechLab Backend (Spring Boot)
Este proyecto es el backend del sistema de gestión de productos y pedidos desarrollado como proyecto final del programa Talento Tech.
La aplicación está construida con Java + Spring Boot + MySQL y expone una API REST para administrar productos y generar pedidos con cálculo automático de totales y control de stock.

Funcionalidades principales

Gestión de Productos
Listar productos (GET /api/productos)
Crear producto (POST /api/productos)
Obtener producto por ID (GET /api/productos/{id})
Eliminar producto (DELETE /api/productos/{id})

Gestión de Pedidos
Crear pedidos (POST /api/pedidos)
Listar pedidos (GET /api/pedidos)
Cálculo de subtotal y total automáticamente
Validación de stock con excepción personalizada
