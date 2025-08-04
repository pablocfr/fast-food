CREATE DATABASE IF NOT EXISTS FastFood;
USE FastFood;

-- Tabla: Roles
CREATE TABLE Roles (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       nombre VARCHAR(100) NOT NULL,
                       descripcion TEXT,
                       activo TINYINT NOT NULL,
                       fecha_creacion DATE,
                       usuario_creacion VARCHAR(50),
                       fecha_actualizacion DATE,
                       usuario_actualizacion VARCHAR(50)
);

-- Tabla: Usuario
CREATE TABLE Usuario (
                         id_usuario INT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(50) NOT NULL,
                         password_hash VARCHAR(255) NOT NULL,
                         nombre VARCHAR(100),
                         apellido VARCHAR(100),
                         correo VARCHAR(100),
                         activo TINYINT NOT NULL,
                         fecha_creacion DATE,
                         usuario_creacion VARCHAR(50),
                         fecha_actualizacion DATE,
                         usuario_actualizacion VARCHAR(50)
);

-- Tabla: Usuario_roles
CREATE TABLE Usuario_roles (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               id_usuario INT,
                               id_rol INT,
                               activo TINYINT,
                               fecha_creacion DATE,
                               usuario_creacion VARCHAR(50),
                               fecha_actualizacion DATE,
                               usuario_actualizacion VARCHAR(50),
                               FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
                               FOREIGN KEY (id_rol) REFERENCES Roles(id)
);

-- Tabla: Cliente
CREATE TABLE Cliente (
                         id_cliente INT PRIMARY KEY AUTO_INCREMENT,
                         nombre VARCHAR(100),
                         nro_documento VARCHAR(10),
                         fecha_creacion DATE,
                         usuario_creacion VARCHAR(50),
                         fecha_actualizacion DATE,
                         usuario_actualizacion VARCHAR(50)
);

-- Tabla: Pedido
CREATE TABLE Pedido (
                        id_pedido INT PRIMARY KEY AUTO_INCREMENT,
                        id_cliente INT,
                        id_usuario INT,
                        fecha_hora DATETIME,
                        estado VARCHAR(30),
                        numero_ticket VARCHAR(6),
                        fecha_creacion DATE,
                        usuario_creacion VARCHAR(50),
                        fecha_actualizacion DATE,
                        usuario_actualizacion VARCHAR(50),
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
                        FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- Tabla: Categoria_Prod
CREATE TABLE Categoria_Prod (
                                id_categoria INT PRIMARY KEY AUTO_INCREMENT,
                                nombre VARCHAR(30),
                                fecha_creacion DATE,
                                usuario_creacion VARCHAR(50),
                                fecha_actualizacion DATE,
                                usuario_actualizacion VARCHAR(50)
);

-- Tabla: Proveedor
CREATE TABLE Proveedor (
                           id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
                           nombre VARCHAR(50),
                           contacto VARCHAR(10),
                           fecha_creacion DATE,
                           usuario_creacion VARCHAR(50),
                           fecha_actualizacion DATE,
                           usuario_actualizacion VARCHAR(50)
);

-- Tabla: Producto
CREATE TABLE Producto (
                          id_producto INT PRIMARY KEY AUTO_INCREMENT,
                          nombre VARCHAR(100),
                          precio DECIMAL(8,2),
                          requiere_cocina TINYINT,
                          categoria_id INT,
                          proveedor_id INT,
                          fecha_creacion DATE,
                          usuario_creacion VARCHAR(50),
                          fecha_actualizacion DATE,
                          usuario_actualizacion VARCHAR(50),
                          FOREIGN KEY (categoria_id) REFERENCES Categoria_Prod(id_categoria),
                          FOREIGN KEY (proveedor_id) REFERENCES Proveedor(id_proveedor)
);

-- Tabla: Combo
CREATE TABLE Combo (
                       id_combo INT PRIMARY KEY AUTO_INCREMENT,
                       nombre VARCHAR(100),
                       precio DECIMAL(10,2),
                       fecha_creacion DATE,
                       usuario_creacion VARCHAR(50),
                       fecha_actualizacion DATE,
                       usuario_actualizacion VARCHAR(50)
);

-- Tabla: Combo_Producto
CREATE TABLE Combo_Producto (
                                id_combo_producto INT PRIMARY KEY AUTO_INCREMENT,
                                id_combo INT,
                                id_producto INT,
                                cantidad INT,
                                fecha_creacion DATE,
                                usuario_creacion VARCHAR(50),
                                fecha_actualizacion DATE,
                                usuario_actualizacion VARCHAR(50),
                                FOREIGN KEY (id_combo) REFERENCES Combo(id_combo),
                                FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-- Tabla: Detalle_Pedido
CREATE TABLE Detalle_Pedido (
                                id_detalle_pedido INT PRIMARY KEY AUTO_INCREMENT,
                                id_pedido INT,
                                id_producto INT,
                                id_combo_producto INT,
                                cantidad INT,
                                estado VARCHAR(30),
                                fecha_creacion DATE,
                                usuario_creacion VARCHAR(50),
                                fecha_actualizacion DATE,
                                usuario_actualizacion VARCHAR(50),
                                FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
                                FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
                                FOREIGN KEY (id_combo_producto) REFERENCES Combo_Producto(id_combo_producto)
);

