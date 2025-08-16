CREATE DATABASE IF NOT EXISTS FastFood;
USE FastFood;
drop database FastFood;
-- =============================
-- Tabla: Roles
-- =============================
CREATE TABLE Roles (
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
CREATE TABLE Usuario (
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
CREATE TABLE Usuario_roles (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               id_usuario INT,
                               id_rol INT,
                               activo TINYINT NOT NULL DEFAULT 1,
                               fecha_creacion DATE,
                               usuario_creacion VARCHAR(50),
                               fecha_actualizacion DATE,
                               usuario_actualizacion VARCHAR(50),
                               FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
                               FOREIGN KEY (id_rol) REFERENCES Roles(id)
);

-- =============================
-- Tabla: Cliente
-- =============================
CREATE TABLE Cliente (
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
CREATE TABLE Categoria_Prod (
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
CREATE TABLE Proveedor (
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
CREATE TABLE Producto (
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
                          FOREIGN KEY (categoria_id) REFERENCES Categoria_Prod(id_categoria),
                          FOREIGN KEY (proveedor_id) REFERENCES Proveedor(id_proveedor)
);

-- =============================
-- Tabla: Combo
-- =============================
CREATE TABLE Combo (
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
CREATE TABLE Combo_Producto (
                                id_combo_producto INT PRIMARY KEY AUTO_INCREMENT,
                                id_combo INT,
                                id_producto INT,
                                cantidad INT,
                                activo TINYINT NOT NULL DEFAULT 1,
                                fecha_creacion DATE,
                                usuario_creacion VARCHAR(50),
                                fecha_actualizacion DATE,
                                usuario_actualizacion VARCHAR(50),
                                FOREIGN KEY (id_combo) REFERENCES Combo(id_combo),
                                FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-- =============================
-- Tabla: Pedido
-- =============================
CREATE TABLE Pedido (
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
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
                        FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- =============================
-- Tabla: Detalle_Pedido
-- =============================
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

-- =============================
-- INSERTS: Roles
-- =============================
INSERT INTO Roles (nombre, descripcion, activo, fecha_creacion, usuario_creacion)
VALUES
    ('Admin', 'Acceso total al sistema', 1, CURDATE(), 'system'),
    ('Cocinero', 'Encargado de preparar pedidos', 1, CURDATE(), 'system'),
    ('Vendedor', 'Encargado de caja y ventas', 1, CURDATE(), 'system'),
    ('Despacho', 'Encargado de entregar pedidos', 1, CURDATE(), 'system');

-- =============================
-- INSERTS: Usuario
-- =============================
INSERT INTO Usuario (username, password_hash, nombre, apellido, correo, activo, fecha_creacion, usuario_creacion)
VALUES
    ('admin01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Carlos', 'Ramirez', 'admin@fastfood.com', 1, CURDATE(), 'system'),
    ('cocinero01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Luis', 'Torres', 'coc1@fastfood.com', 1, CURDATE(), 'system'),
    ('cocinero02', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Ana', 'Gomez', 'coc2@fastfood.com', 1, CURDATE(), 'system'),
    ('caja01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'María', 'Lopez', 'caja1@fastfood.com', 1, CURDATE(), 'system'),
    ('caja02', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Pedro', 'Diaz', 'caja2@fastfood.com', 1, CURDATE(), 'system'),
    ('despacho01', '$2b$12$aUMUgcvOEG5cFpPP2dcYKO9k19/9fUbPG3X3DUvZwauYBh5hOh2em', 'Sofia', 'Castro', 'desp1@fastfood.com', 1, CURDATE(), 'system');

-- =============================
-- INSERTS: Usuario_roles
-- =============================
INSERT INTO Usuario_roles (id_usuario, id_rol, activo, fecha_creacion, usuario_creacion)
VALUES
    (1, 1, 1, CURDATE(), 'system'), -- admin
    (2, 2, 1, CURDATE(), 'system'), -- cocinero
    (3, 2, 1, CURDATE(), 'system'), -- cocinero
    (4, 3, 1, CURDATE(), 'system'), -- caja
    (5, 3, 1, CURDATE(), 'system'), -- caja
    (6, 4, 1, CURDATE(), 'system'); -- despacho

-- =============================
-- INSERTS: Cliente (10)
-- =============================
INSERT INTO Cliente (nombre, nro_documento, activo, fecha_creacion, usuario_creacion)
VALUES
    ('Juan Perez', '12345678', 1, CURDATE(), 'admin01'),
    ('Maria Lopez', '87654321', 1, CURDATE(), 'admin01'),
    ('Carlos Diaz', '11112222', 1, CURDATE(), 'admin01'),
    ('Ana Torres', '33334444', 1, CURDATE(), 'admin01'),
    ('Luis Fernandez', '55556666', 1, CURDATE(), 'admin01'),
    ('Rosa Gomez', '77778888', 1, CURDATE(), 'admin01'),
    ('Pedro Sanchez', '99990000', 1, CURDATE(), 'admin01'),
    ('Jose Castro', '11223344', 1, CURDATE(), 'admin01'),
    ('Lucia Ramirez', '55667788', 1, CURDATE(), 'admin01'),
    ('Miguel Vargas', '44332211', 1, CURDATE(), 'admin01');

-- =============================
-- INSERTS: Categoria_Prod (5)
-- =============================
INSERT INTO Categoria_Prod (nombre, activo, fecha_creacion, usuario_creacion)
VALUES
    ('Hamburguesas', 1, CURDATE(), 'admin01'),
    ('Papas Fritas', 1, CURDATE(), 'admin01'),
    ('Bebidas', 1, CURDATE(), 'admin01'),
    ('Postres', 1, CURDATE(), 'admin01'),
    ('Otros', 1, CURDATE(), 'admin01');

-- =============================
-- INSERTS: Proveedor (5)
-- =============================
INSERT INTO Proveedor (nombre, contacto, activo, fecha_creacion, usuario_creacion)
VALUES
    ('Distribuidora Carnes SAC', '987654321', 1, CURDATE(), 'admin01'),
    ('Bebidas y Refrescos SA', '912345678', 1, CURDATE(), 'admin01'),
    ('Snacks Perú', '934567890', 1, CURDATE(), 'admin01'),
    ('Postres Express', '956789012', 1, CURDATE(), 'admin01'),
    ('Alimentos Generales', '923456789', 1, CURDATE(), 'admin01');

-- =============================
-- INSERTS: Producto (10)
-- =============================
INSERT INTO Producto (nombre, precio, requiere_cocina, categoria_id, proveedor_id, activo, fecha_creacion, usuario_creacion)
VALUES
    ('Hamburguesa Clásica', 12.50, 1, 1, 1, 1, CURDATE(), 'admin01'),
    ('Hamburguesa Doble', 18.00, 1, 1, 1, 1, CURDATE(), 'admin01'),
    ('Papas Fritas Chicas', 6.00, 0, 2, 3, 1, CURDATE(), 'admin01'),
    ('Papas Fritas Grandes', 9.00, 0, 2, 3, 1, CURDATE(), 'admin01'),
    ('Coca Cola 500ml', 5.00, 0, 3, 2, 1, CURDATE(), 'admin01'),
    ('Inca Kola 500ml', 5.00, 0, 3, 2, 1, CURDATE(), 'admin01'),
    ('Agua Mineral 500ml', 4.00, 0, 3, 2, 1, CURDATE(), 'admin01'),
    ('Helado Vainilla', 7.00, 0, 4, 4, 1, CURDATE(), 'admin01'),
    ('Sundae Chocolate', 8.00, 0, 4, 4, 1, CURDATE(), 'admin01'),
    ('Hot Dog Clásico', 10.00, 1, 5, 5, 1, CURDATE(), 'admin01');

-- =============================
-- INSERTS: Combo (5)
-- =============================
INSERT INTO Combo (nombre, precio, activo, fecha_creacion, usuario_creacion)
VALUES
    ('Combo 1: Hamburguesa Clásica + Papas + Gaseosa', 20.00, 1, CURDATE(), 'admin01'),
    ('Combo 2: Hamburguesa Doble + Papas + Gaseosa', 26.00, 1, CURDATE(), 'admin01'),
    ('Combo 3: Hot Dog + Papas + Inca Kola', 18.00, 1, CURDATE(), 'admin01'),
    ('Combo 4: Hamburguesa Clásica + Sundae', 19.00, 1, CURDATE(), 'admin01'),
    ('Combo 5: Hamburguesa Doble + Papas Grandes + Agua', 25.00, 1, CURDATE(), 'admin01');

-- =============================
-- INSERTS: Combo_Producto
-- =============================
INSERT INTO Combo_Producto (id_combo, id_producto, cantidad, activo, fecha_creacion, usuario_creacion)
VALUES
    (1, 1, 1, 1, CURDATE(), 'admin01'),
    (1, 3, 1, 1, CURDATE(), 'admin01'),
    (1, 5, 1, 1, CURDATE(), 'admin01'),
    (2, 2, 1, 1, CURDATE(), 'admin01'),
    (2, 4, 1, 1, CURDATE(), 'admin01'),
    (2, 6, 1, 1, CURDATE(), 'admin01'),
    (3, 10, 1, 1, CURDATE(), 'admin01'),
    (3, 3, 1, 1, CURDATE(), 'admin01'),
    (3, 6, 1, 1, CURDATE(), 'admin01'),
    (4, 1, 1, 1, CURDATE(), 'admin01'),
    (4, 9, 1, 1, CURDATE(), 'admin01'),
    (5, 2, 1, 1, CURDATE(), 'admin01'),
    (5, 4, 1, 1, CURDATE(), 'admin01'),
    (5, 7, 1, 1, CURDATE(), 'admin01');

-- =============================
-- INSERTS: Pedido (10)
-- =============================
INSERT INTO Pedido (id_cliente, id_usuario, fecha_hora, estado, numero_ticket, activo, fecha_creacion, usuario_creacion)
VALUES
    (1, 4, NOW(), 'Pendiente', 'T0001', 1, CURDATE(), 'caja01'),
    (2, 5, NOW(), 'Pendiente', 'T0002', 1, CURDATE(), 'caja02'),
    (3, 4, NOW(), 'Completado', 'T0003', 1, CURDATE(), 'caja01'),
    (4, 5, NOW(), 'Completado', 'T0004', 1, CURDATE(), 'caja02'),
    (5, 4, NOW(), 'Pendiente', 'T0005', 1, CURDATE(), 'caja01'),
    (6, 5, NOW(), 'Pendiente', 'T0006', 1, CURDATE(), 'caja02'),
    (7, 4, NOW(), 'Completado', 'T0007', 1, CURDATE(), 'caja01'),
    (8, 5, NOW(), 'Pendiente', 'T0008', 1, CURDATE(), 'caja02'),
    (9, 4, NOW(), 'Pendiente', 'T0009', 1, CURDATE(), 'caja01'),
    (10, 5, NOW(), 'Completado', 'T0010', 1, CURDATE(), 'caja02');

-- =============================
-- INSERTS: Detalle_Pedido
-- =============================
INSERT INTO Detalle_Pedido (id_pedido, id_producto, id_combo_producto, cantidad, estado, fecha_creacion, usuario_creacion)
VALUES
    (1, 1, NULL, 1, 'Preparando', CURDATE(), 'caja01'),
    (1, 5, NULL, 1, 'Entregado', CURDATE(), 'caja01'),
    (2, NULL, 1, 1, 'Preparando', CURDATE(), 'caja02'),
    (2, NULL, 2, 1, 'Preparando', CURDATE(), 'caja02'),
    (3, 2, NULL, 1, 'Completado', CURDATE(), 'caja01'),
    (3, 4, NULL, 1, 'Completado', CURDATE(), 'caja01'),
    (4, NULL, 4, 1, 'Completado', CURDATE(), 'caja02'),
    (5, 10, NULL, 2, 'Pendiente', CURDATE(), 'caja01'),
    (6, NULL, 7, 1, 'Pendiente', CURDATE(), 'caja02'),
    (7, 8, NULL, 1, 'Completado', CURDATE(), 'caja01'),
    (8, 9, NULL, 1, 'Preparando', CURDATE(), 'caja02'),
    (9, 3, NULL, 2, 'Pendiente', CURDATE(), 'caja01'),
    (10, NULL, 13, 1, 'Completado', CURDATE(), 'caja02');
