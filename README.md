# 🍔 Fast-Food - Sistema de Pedidos para Restaurantes

Fast-Food es una aplicación web diseñada para gestionar pedidos en un restaurante de comida rápida. La plataforma permite a los usuarios realizar pedidos, visualizar combos/productos, y a los administradores gestionar roles, menús, usuarios y más.

---

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java 17+** (compatible con Java 21)
- **Spring Boot 3.5.4**
- **Spring Web (REST)**
- **Spring Data JPA**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **MapStruct**
- **Lombok**
- **Maven**
- **MySQL**

### Arquitectura
- **Arquitectura Limpia (Clean Architecture)**
- **Separación por capas**
- **Inyección de dependencias**

---

## 🧱 Arquitectura

El proyecto sigue los principios de **Arquitectura Limpia (Clean Architecture)**:

- **`domain`**: Entidades de negocio, interfaces y lógica de dominio pura
- **`application`**: Casos de uso y servicios de aplicación
- **`infrastructure`**: Acceso a datos, repositorios y dependencias externas
- **`presentation`**: Controladores REST y DTOs

### Estructura de Módulos

```
src/main/java/com/fastfood/
├── FastFoodApplication.java
├── application/
│   ├── cliente/
│   ├── combo/
│   ├── pedido/
│   ├── producto/
│   └── seguridad/
├── domain/
│   └── seguridad/
├── infrastructure/
└── presentation/
```

---

## 🧩 Modelo de Base de Datos (MySQL)

El sistema contempla las siguientes entidades principales:

### 🔐 Autenticación y Usuarios
- **`Usuario`**: Datos del usuario del sistema (empleados)
- **`Roles`**: Tipos de usuario (Admin, Cocinero, Vendedor, Despacho)
- **`Usuario_roles`**: Tabla intermedia para asignación de roles

### 👥 Clientes
- **`Cliente`**: Datos de los clientes que realizan pedidos

### 🍽️ Pedidos
- **`Pedido`**: Encabezado del pedido con estado, fecha, usuario y cliente
- **`Detalle_Pedido`**: Ítems del pedido, conectados a productos individuales o combos

### 🧃 Productos y Combos
- **`Producto`**: Ítems individuales (bebidas, hamburguesas, papas, postres, etc.)
- **`Categoria_Prod`**: Categorías de productos
- **`Proveedor`**: Proveedores de productos
- **`Combo`**: Conjuntos de productos con precio promocional
- **`Combo_Producto`**: Tabla intermedia que asocia combos con productos

### Estados de Pedidos
Los pedidos manejan diferentes estados durante su ciclo de vida para permitir el seguimiento desde la creación hasta la entrega.

---

## 🚀 Cómo ejecutar el proyecto

### Prerrequisitos
- **Java 17+** (recomendado Java 21)
- **Maven 3.6+**
- **MySQL 8.0+**
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

### Backend

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/pablocfr/fast-food.git
   cd fast-food
   ```

2. **Crea la base de datos en MySQL:**
   ```sql
   CREATE DATABASE FastFood;
   ```

3. **Ejecuta el script de base de datos:**
   ```bash
   mysql -u root -p FastFood < fastfood.sql
   ```

4. **Configura `application.yml`** (crear en `src/main/resources/`):
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/FastFood?serverTimezone=America/Lima&allowPublicKeyRetrieval=true&useSSL=false
       driver-class-name: com.mysql.cj.jdbc.Driver
       username: root
       password: ${TU_CONTRASEÑA}
       hikari:
         maximum-pool-size: 10         # Número máximo de conexiones en el pool
         minimum-idle: 5               # Mínimo de conexiones inactivas
         idle-timeout: 600000          # Tiempo (ms) antes de cerrar una conexión inactiva
         max-lifetime: 1800000         # Tiempo máximo de vida (ms) de una conexión
         connection-timeout: 30000     # Tiempo de espera para obtener una conexión
     jpa:
       database-platform: org.hibernate.dialect.MySQL8Dialect
       show-sql: true
       properties:
         hibernate:
           jdbc:
             batch_size: 20                 # Agrupa hasta 20 operaciones en lote
           order_inserts: true              # Ordena las inserciones para optimizar
           order_updates: true              # Ordena las actualizaciones para mejorar
   logging:
     level:
       root: INFO
       org.hibernate.orm.jdbc.bind: TRACE         # Muestra los valores de los parámetros
       org.hibernate.orm.jdbc.extract: TRACE     # Muestra los valores extraídos de la BD
   ```

5. **Ejecuta la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

6. **La aplicación estará disponible en:**
   ```
   http://localhost:8080
   ```

---

## 📌 Funcionalidades Clave

### 🔐 Autenticación y Autorización
- Registro e inicio de sesión de usuarios
- Autenticación basada en JWT
- Control de acceso por roles

### 📱 Gestión de Pedidos
- Creación y visualización de pedidos
- Seguimiento de estados de pedidos
- Sistema de tickets numerados

### 🍔 Gestión de Productos y Combos
- Administración de productos individuales
- Creación y gestión de combos promocionales
- Categorización de productos
- Gestión de proveedores

### 👥 Roles de Usuario
- **Admin**: Acceso total al sistema
- **Vendedor/Cajero**: Gestión de ventas y caja
- **Cocinero**: Visualización y actualización de pedidos de cocina
- **Despacho**: Gestión de entrega de pedidos

### 🏪 Pantallas Especializadas
- Pantalla de cocina para visualizar pedidos activos
- Interface de caja para procesamiento de ventas
- Panel administrativo para gestión completa

---

## 📂 Estructura del Repositorio

```
fast-food/
│
├── .mvn/                          # Configuración de Maven Wrapper
├── src/
│   └── main/
│       ├── java/com/fastfood/
│       │   ├── FastFoodApplication.java
│       │   ├── application/       # Casos de uso y servicios
│       │   │   ├── cliente/
│       │   │   ├── combo/
│       │   │   ├── pedido/
│       │   │   ├── producto/
│       │   │   └── seguridad/
│       │   ├── domain/            # Entidades y lógica de negocio
│       │   │   └── seguridad/
│       │   ├── infrastructure/    # Acceso a datos y dependencias externas
│       │   └── presentation/      # Controladores REST
│       └── resources/
│           └── application.yml    # Configuración de la aplicación
├── fastfood.sql                   # Script de base de datos
├── pom.xml                        # Configuración de Maven
├── mvnw                           # Maven Wrapper (Unix)
├── mvnw.cmd                       # Maven Wrapper (Windows)
└── README.md                      # Este archivo
```

---

## 🔧 Configuración Adicional

### Variables de Entorno
Puedes configurar las siguientes variables de entorno:
- `DB_PASSWORD`: Contraseña de la base de datos
- `JWT_SECRET`: Secreto para firma de tokens JWT
- `SERVER_PORT`: Puerto del servidor (por defecto: 8080)

### Perfiles de Spring
- `dev`: Desarrollo local
- `prod`: Producción

---

## 📝 Notas de Desarrollo

### Datos de Prueba
El script `fastfood.sql` incluye datos de prueba:
- Usuarios con diferentes roles
- Productos de ejemplo
- Categorías y proveedores
- Clientes de muestra

### Credenciales por Defecto
```
Admin: admin01 / password (hash: $2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em)
Cocinero: cocinero01 / password
Vendedor: caja01 / password
```

---

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

---

## 👨‍💻 Autor

**Pablo CFR** - [pablocfr](https://github.com/pablocfr)

---

*Sistema de gestión de pedidos para restaurantes de comida rápida con arquitectura moderna y tecnologías actuales.*