# StoreManager

## Descripción

StoreManager es una aplicación para ayudar a pequeñas tiendas a gestionar sus productos, stock y ventas.

## ¿Qué problema busca solucionar?

Muchas pequeñas tiendas pueden llevar el control de sus productos, clientes, stock y ventas de forma manual, que puede dificultar la organización y aumentar el riesgo de errores.

Store Manager nace como un prototipo de solución para digitalizar estos procesos y centralizar la información de la tienda en una única aplicación.

El objetivo es facilitar tareas como:

- Registrar y gestionar productos.
- Controlar el stock disponible.
- Gestionar clientes.
- Registrar ventas.
- Consultar información de los productos.
- Obtener estadísticas de la tienda.

## Objetivo

Crear una aplicación que permita centralizar esta información y facilitar la gestión diaria de la tienda.

## Funcionalidades

### Productos
- Añadir productos
- Eliminar productos
- Modificar productos
- Buscar productos
- Listar productos

### Stock
- Consultar stock
- Aumentar stock
- Reducir stock
- Detectar productos con poco stock

### Ventas
- Registrar una venta
- Consultar ventas
- Calcular total de una venta

### Informes
- Ver ingresos
- Ver productos más vendidos
- Ver productos con poco stock

## Entidades

### Producto

Representa un producto que vende la tienda.

Datos que necesitamos:
- ID
- Nombre
- Precio
- Stock

### Cliente

Representa un cliente de la tienda.

Datos que necesitamos:
- ID
- Nombre
- Email
- Teléfono

### Venta

Representa una venta realizada por un cliente.

Datos que necesitamos:
- ID
- Fecha
- Cliente
- Total

### DetalleVenta

Representa un producto incluido dentro de una venta.

Datos que necesitamos:
- ID
- Producto
- Cantidad
- Precio
- Subtotal

## Relaciones

Cliente → puede realizar varias ventas.

Venta → pertenece a un cliente y puede contener varios detalles de venta.

DetalleVenta → pertenece a una venta y corresponde a un producto.

Producto → puede aparecer en muchos detalles de venta.