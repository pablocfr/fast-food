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
   
2. Crea la base de datos en MySQL:
   ```bash
   CREATE DATABASE fastfood;
   
3. Configura application.yml:
   ```bash
   datasource:
    url: jdbc:mysql://localhost:3306/fastfood?serverTimezone=America/Lima&allowPublicKeyRetrieval=true&useSSL=false
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: ${CONTRASEÑA}
    hikari:
      maximum-pool-size: 10         # Numero maximo de conexiones en el pool
      minimum-idle: 5               # Minimo de conexiones inactivas
      idle-timeout: 600000          # Tiempo (ms) antes de cerrar una conexion inactiva
      max-lifetime: 1800000         # Tiempo maximo de vida (ms) de una conexion
      connection-timeout: 30000     # Tiempo de espera para obtener una conexion
   jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    show-sql: true
    properties:
      hibernate:
        jdbc:
          batch_size: 20                 # Agrupa hasta 20 operaciones en lote (inserciones/actualizaciones)
        order_inserts: true              # Ordena las inserciones para optimizar el rendimiento del batch
        order_updates: true              # Ordena las actualizaciones para mejorar el uso del batch
   logging:
   level:
    root: INFO
    org.hibernate.orm.jdbc.bind: TRACE         # Muestra los valores que se envian a los parametros ?
    org.hibernate.orm.jdbc.extract: TRACE    # Muestra los valores que se extraen desde la BD
    org.hibernate.type.descriptor.sql: TRACE   # Para ver mas detalles de tipos
   
### Frontend
1. Clona el repositorio: (Falta Crear)
   ```bash
   git clone https://github.com/tu_usuario/fast-food.git
   cd fast-food-frontend
2. Instala Dependencias:
   ```bash
   npm install
3. Ejectua Angular:
   ```bash
   ng serve
4. Abre en el navegador:
   ```bash
   http://localhost:4200
   
## 📌 Funcionalidades Clave
Registro e inicio de sesión de usuarios

Creación y visualización de pedidos

Gestión de combos y productos

Vista de roles para cajero, cocina y administrador

Pantalla de cocina para visualizar pedidos activos

## 📂 Estructura del Repositorio
   ```bash
fast-food/
│
├── application/
├── domain/
├── infrastructure/
├── presentation/
├── src/
│   └── main/
│       ├── java/
│       └── resources/
├── pom.xml
└── README.md

