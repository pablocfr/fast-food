# 🍔 Fast-Food - Sistema de Pedidos para Restaurantes

Fast-Food es una aplicación web diseñada para gestionar pedidos en un restaurante de comida rápida. La plataforma permite a los usuarios realizar pedidos, visualizar combos/productos, y a los administradores gestionar roles, menús, usuarios y más.

---

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java 21**
- **Spring Boot 3**
- **Spring Web (REST)**
- **Spring Data JPA**
- **Arquitectura Limpia**
- **MySQL**

### Frontend
- **Angular 17**
- **Bootstrap 5**
- **TypeScript**

---

## 🧱 Arquitectura

El proyecto sigue los principios de **Arquitectura Limpia (Clean Architecture)**:
- `domain`: entidades, interfaces y lógica de negocio pura
- `application`: casos de uso
- `infrastructure`: acceso a datos y dependencias externas
- `web`: controladores REST

---

## 🧩 Modelo de Base de Datos (MySQL)

El sistema contempla las siguientes entidades principales:

### 🔐 Autenticación y usuarios
- `usuario`: datos del usuario que realiza pedidos
- `rol`: tipo de usuario (admin, cajero, cocinero, cliente)
- `usuario_rol`: tabla intermedia para los roles asignados

### 🍽️ Pedidos
- `pedido`: encabezado del pedido, con estado, hora y usuario
- `detalle_pedido`: ítems del pedido, conectados a combos o productos

### 🧃 Productos y combos
- `producto`: ítems individuales (bebida, hamburguesa, etc.)
- `combo`: conjuntos de productos con precio promocional
- `combo_producto`: tabla intermedia que asocia combos con productos

---

## 🚀 Cómo ejecutar el proyecto

### Backend

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/fast-food.git
   cd fast-food

