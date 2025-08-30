CREATE DATABASE IF NOT EXISTS FastFood;
USE FastFood;
drop database FastFood;
-- =============================
-- Tabla: Roles
-- =============================
CREATE TABLE roles (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       nombre VARCHAR(100) NOT NULL,
                       descripcion TEXT,
                       activo TINYINT NOT NULL DEFAULT 1,
                       fecha_creacion DATE,
                       usuario_creacion VARCHAR(50),
                       fecha_actualizacion DATE,
                       usuario_actualizacion VARCHAR(50)
);

-- =============================
-- Tabla: Usuario
-- =============================
CREATE TABLE usuario (
                         id_usuario INT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(50) NOT NULL,
                         password_hash VARCHAR(255) NOT NULL,
                         nombre VARCHAR(100),
                         apellido VARCHAR(100),
                         correo VARCHAR(100),
                         activo TINYINT NOT NULL DEFAULT 1,
                         fecha_creacion DATE,
                         usuario_creacion VARCHAR(50),
                         fecha_actualizacion DATE,
                         usuario_actualizacion VARCHAR(50)
);

-- =============================
-- Tabla: Usuario_roles
-- =============================
CREATE TABLE usuario_roles (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               id_usuario INT,
                               id_rol INT,
                               activo TINYINT NOT NULL DEFAULT 1,
                               fecha_creacion DATE,
                               usuario_creacion VARCHAR(50),
                               fecha_actualizacion DATE,
                               usuario_actualizacion VARCHAR(50),
                               FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
                               FOREIGN KEY (id_rol) REFERENCES roles(id)
);

-- =============================
-- Tabla: Cliente
-- =============================
CREATE TABLE cliente (
                         id_cliente INT PRIMARY KEY AUTO_INCREMENT,
                         nombre VARCHAR(100),
                         nro_documento VARCHAR(10),
                         activo TINYINT NOT NULL DEFAULT 1,
                         fecha_creacion DATE,
                         usuario_creacion VARCHAR(50),
                         fecha_actualizacion DATE,
                         usuario_actualizacion VARCHAR(50)
);

-- =============================
-- Tabla: Categoria_Prod
-- =============================
CREATE TABLE categoria_prod (
                                id_categoria INT PRIMARY KEY AUTO_INCREMENT,
                                nombre VARCHAR(30),
                                activo TINYINT NOT NULL DEFAULT 1,
                                fecha_creacion DATE,
                                usuario_creacion VARCHAR(50),
                                fecha_actualizacion DATE,
                                usuario_actualizacion VARCHAR(50)
);

-- =============================
-- Tabla: Proveedor
-- =============================
CREATE TABLE proveedor (
                           id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
                           nombre VARCHAR(50),
                           contacto VARCHAR(10),
                           activo TINYINT NOT NULL DEFAULT 1,
                           fecha_creacion DATE,
                           usuario_creacion VARCHAR(50),
                           fecha_actualizacion DATE,
                           usuario_actualizacion VARCHAR(50)
);

-- =============================
-- Tabla: Producto
-- =============================
CREATE TABLE producto (
                          id_producto INT PRIMARY KEY AUTO_INCREMENT,
                          nombre VARCHAR(100),
                          precio DECIMAL(8,2),
                          requiere_cocina TINYINT,
                          categoria_id INT,
                          proveedor_id INT,
                          activo TINYINT NOT NULL DEFAULT 1,
                          fecha_creacion DATE,
                          usuario_creacion VARCHAR(50),
                          fecha_actualizacion DATE,
                          usuario_actualizacion VARCHAR(50),
                          FOREIGN KEY (categoria_id) REFERENCES categoria_prod(id_categoria),
                          FOREIGN KEY (proveedor_id) REFERENCES proveedor(id_proveedor)
);

-- =============================
-- Tabla: Combo
-- =============================
CREATE TABLE combo (
                       id_combo INT PRIMARY KEY AUTO_INCREMENT,
                       nombre VARCHAR(100),
                       precio DECIMAL(10,2),
                       activo TINYINT NOT NULL DEFAULT 1,
                       fecha_creacion DATE,
                       usuario_creacion VARCHAR(50),
                       fecha_actualizacion DATE,
                       usuario_actualizacion VARCHAR(50)
);

-- =============================
-- Tabla: Combo_Producto
-- =============================
CREATE TABLE combo_producto (
                                id_combo_producto INT PRIMARY KEY AUTO_INCREMENT,
                                id_combo INT,
                                id_producto INT,
                                cantidad INT,
                                activo TINYINT NOT NULL DEFAULT 1,
                                fecha_creacion DATE,
                                usuario_creacion VARCHAR(50),
                                fecha_actualizacion DATE,
                                usuario_actualizacion VARCHAR(50),
                                FOREIGN KEY (id_combo) REFERENCES combo(id_combo),
                                FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- =============================
-- Tabla: Pedido
-- =============================
CREATE TABLE pedido (
                        id_pedido INT PRIMARY KEY AUTO_INCREMENT,
                        id_cliente INT,
                        id_usuario INT,
                        fecha_hora DATETIME,
                        estado VARCHAR(30),
                        numero_ticket VARCHAR(6),
                        activo TINYINT NOT NULL DEFAULT 1,
                        fecha_creacion DATE,
                        usuario_creacion VARCHAR(50),
                        fecha_actualizacion DATE,
                        usuario_actualizacion VARCHAR(50),
                        FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
                        FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- =============================
-- Tabla: Detalle_Pedido
-- =============================
CREATE TABLE detalle_pedido (
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
                                FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
                                FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
                                FOREIGN KEY (id_combo_producto) REFERENCES combo_producto(id_combo_producto)
);

-- =============================
-- INSERTS: Roles
-- =============================
INSERT INTO roles (nombre, descripcion, activo)
VALUES
    ('Admin', 'Acceso total al sistema', 1),
    ('Cocinero', 'Encargado de preparar pedidos', 1),
    ('Vendedor', 'Encargado de caja y ventas', 1),
    ('Despacho', 'Encargado de entregar pedidos', 1);

-- =============================
-- INSERTS: Usuario
-- =============================
INSERT INTO usuarios (username, password_hash, nombre, apellido, email, activo)
VALUES
    ('admin', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Carlos', 'Ramirez', 'admin@fastfood.com', 1),
    ('cocinero01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Luis', 'Torres', 'coc1@fastfood.com', 1),
    ('cocinero02', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Ana', 'Gomez', 'coc2@fastfood.com', 1),
    ('caja01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'María', 'Lopez', 'caja1@fastfood.com', 1),
    ('caja02', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Pedro', 'Diaz', 'caja2@fastfood.com', 1),
    ('despacho01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Sofia', 'Castro', 'desp1@fastfood.com', 1)

-- =============================
-- INSERTS: Usuario_roles
-- =============================
INSERT INTO usuario_roles (id, usuario_id ,rol_id, activo)
VALUES
    (1, 1, 1, 1), -- admin
    (2, 1, 2, 1), -- cocinero
    (3, 1, 2, 1), -- cocinero
    (4, 1, 3, 1), -- caja
    (5, 1, 3, 1), -- caja
    (6, 1, 4, 1); -- despacho


-- =============================
-- INSERTS: Cliente (10)
-- =============================
INSERT INTO cliente (nombre, nro_documento, activo)
VALUES
    ('Juan Perez', '12345678', 1),
    ('Maria Lopez', '87654321', 1),
    ('Carlos Diaz', '11112222', 1),
    ('Ana Torres', '33334444', 1),
    ('Luis Fernandez', '55556666', 1),
    ('Rosa Gomez', '77778888', 1),
    ('Pedro Sanchez', '99990000', 1),
    ('Jose Castro', '11223344', 1),
    ('Lucia Ramirez', '55667788', 1),
    ('Miguel Vargas', '44332211', 1);

-- =============================
-- INSERTS: Categoria_Prod (5)
-- =============================
INSERT INTO categoria_prod (nombre, activo)
VALUES
    ('Hamburguesas', 1),
    ('Papas Fritas', 1),
    ('Bebidas', 1),
    ('Postres', 1),
    ('Otros', 1);

-- =============================
-- INSERTS: Proveedor (5)
-- =============================
INSERT INTO proveedor (nombre, contacto, activo)
VALUES
    ('Distribuidora Carnes SAC', '987654321', 1),
    ('Bebidas y Refrescos SA', '912345678', 1),
    ('Snacks Perú', '934567890', 1),
    ('Postres Express', '956789012', 1),
    ('Alimentos Generales', '923456789', 1);

-- =============================
-- INSERTS: Producto (10)
-- =============================
INSERT INTO producto (nombre, precio, requiere_cocina, categoria_id, proveedor_id, activo)
VALUES
    ('Hamburguesa Clásica', 12.50, 1, 1, 1, 1),
    ('Hamburguesa Doble', 18.00, 1, 1, 1, 1),
    ('Papas Fritas Chicas', 6.00, 0, 2, 3, 1),
    ('Papas Fritas Grandes', 9.00, 0, 2, 3, 1),
    ('Coca Cola 500ml', 5.00, 0, 3, 2, 1),
    ('Inca Kola 500ml', 5.00, 0, 3, 2, 1),
    ('Agua Mineral 500ml', 4.00, 0, 3, 2, 1),
    ('Helado Vainilla', 7.00, 0, 4, 4, 1),
    ('Sundae Chocolate', 8.00, 0, 4, 4, 1),
    ('Hot Dog Clásico', 10.00, 1, 5, 5, 1);

-- =============================
-- INSERTS: Combo (5)
-- =============================
INSERT INTO combo (nombre, precio, activo)
VALUES
    ('Combo 1: Hamburguesa Clásica + Papas + Gaseosa', 20.00, 1),
    ('Combo 2: Hamburguesa Doble + Papas + Gaseosa', 26.00, 1),
    ('Combo 3: Hot Dog + Papas + Inca Kola', 18.00, 1),
    ('Combo 4: Hamburguesa Clásica + Sundae', 19.00, 1),
    ('Combo 5: Hamburguesa Doble + Papas Grandes + Agua', 25.00, 1);

-- =============================
-- INSERTS: Combo_Producto
-- =============================
INSERT INTO combo_producto (id_combo, id_producto, cantidad, activo)
VALUES
    (1, 1, 1, 1),
    (1, 3, 1, 1),
    (1, 5, 1, 1),
    (2, 2, 1, 1),
    (2, 4, 1, 1),
    (2, 6, 1, 1),
    (3, 10, 1, 1),
    (3, 3, 1, 1),
    (3, 6, 1, 1),
    (4, 1, 1, 1),
    (4, 9, 1, 1),
    (5, 2, 1, 1),
    (5, 4, 1, 1),
    (5, 7, 1, 1);

-- =============================
-- INSERTS: Pedido (10)
-- =============================
INSERT INTO pedido (id_cliente, id_usuario, fecha_hora, estado, numero_ticket, activo)
VALUES
    (1, 4, NOW(), 'Pendiente', 'T0001', 1),
    (2, 5, NOW(), 'Pendiente', 'T0002', 1),
    (3, 4, NOW(), 'Completado', 'T0003', 1),
    (4, 5, NOW(), 'Completado', 'T0004', 1),
    (5, 4, NOW(), 'Pendiente', 'T0005', 1),
    (6, 5, NOW(), 'Pendiente', 'T0006', 1),
    (7, 4, NOW(), 'Completado', 'T0007', 1),
    (8, 5, NOW(), 'Pendiente', 'T0008', 1),
    (9, 4, NOW(), 'Pendiente', 'T0009', 1),
    (10, 5, NOW(), 'Completado', 'T0010', 1);

-- =============================
-- INSERTS: Detalle_Pedido
-- =============================
INSERT INTO detalle_pedido (id_pedido, id_producto, id_combo_producto, cantidad, estado)
VALUES
    (1, 1, NULL, 1, 'Preparando'),
    (1, 5, NULL, 1, 'Entregado'),
    (2, NULL, 1, 1, 'Preparando'),
    (2, NULL, 2, 1, 'Preparando'),
    (3, 2, NULL, 1, 'Completado'),
    (3, 4, NULL, 1, 'Completado'),
    (4, NULL, 4, 1, 'Completado'),
    (5, 10, NULL, 2, 'Pendiente'),
    (6, NULL, 3, 1, 'Pendiente'),
    (7, 8, NULL, 1, 'Completado'),
    (8, 9, NULL, 1, 'Preparando'),
    (9, 3, NULL, 2, 'Pendiente'),
    (10, NULL, 5, 1, 'Completado');

-- =============================
-- =============================
-- INSERTS: Pedido (clientes 1 al 10)
-- =============================
INSERT INTO pedido (id_cliente, id_usuario, fecha_hora, estado, numero_ticket, activo)
VALUES
    (1, 4, NOW(), 'Preparando', 'T0011', 1),
    (2, 5, NOW(), 'Entregado', 'T0012', 1),
    (3, 4, NOW(), 'Pendiente', 'T0013', 1),
    (4, 5, NOW(), 'Preparando', 'T0014', 1),
    (5, 4, NOW(), 'Entregado', 'T0015', 1),
    (6, 5, NOW(), 'Pendiente', 'T0016', 1),
    (7, 4, NOW(), 'Completado', 'T0017', 1),
    (8, 5, NOW(), 'Preparando', 'T0018', 1),
    (9, 4, NOW(), 'Entregado', 'T0019', 1),
    (10, 5, NOW(), 'Pendiente', 'T0020', 1);

-- =============================
-- INSERTS: Detalle_Pedido (clientes 1 al 10)
-- =============================
INSERT INTO detalle_pedido (id_pedido, id_producto, id_combo_producto, cantidad, estado)
VALUES
    (11, 6, NULL, 1, 'Preparando'),
    (11, 7, NULL, 2, 'Completado'),
    (12, NULL, 4, 1, 'Entregado'),
    (12, 4, NULL, 1, 'Preparando'),
    (13, 2, NULL, 3, 'Pendiente'),
    (13, 9, NULL, 1, 'Completado'),
    (14, NULL, 5, 2, 'Preparando'),
    (14, 8, NULL, 1, 'Completado'),
    (15, 1, NULL, 1, 'Entregado'),
    (15, 3, NULL, 1, 'Preparando'),
    (16, 5, NULL, 2, 'Pendiente'),
    (16, 10, NULL, 1, 'Completado'),
    (17, 7, NULL, 1, 'Completado'),
    (17, NULL, 2, 1, 'Preparando'),
    (18, 9, NULL, 1, 'Preparando'),
    (18, 6, NULL, 1, 'Completado'),
    (19, 8, NULL, 2, 'Entregado'),
    (19, NULL, 3, 1, 'Preparando'),
    (20, 4, NULL, 1, 'Pendiente'),
    (20, 2, NULL, 1, 'Completado');