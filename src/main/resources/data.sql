-- Eliminar datos previos
DELETE FROM usuario_rol;
DELETE FROM usuario;
DELETE FROM rol;

-- Roles
INSERT INTO rol (nombre, descripcion, activo) VALUES
                                                  ('Admin', 'Acceso total al sistema', 1),
                                                  ('Cocinero', 'Encargado de preparar pedidos', 1),
                                                  ('Vendedor', 'Encargado de caja y ventas', 1),
                                                  ('Despacho', 'Encargado de entregar pedidos', 1);

-- Usuarios
INSERT INTO usuario (username, password_hash, nombre, apellido, email, activo) VALUES
                                                                                    ('admin01', '$2a$10$HSS3JfzBcbQ7RKm6e32B.ODv9EW054/SdbHDk4xyzVLDQwlbNapo.', 'Carlos', 'Ramirez', 'admin@fastfood.com', 1),
                                                                                    ('cocinero01', '$2a$10$HSS3JfzBcbQ7RKm6e32B.ODv9EW054/SdbHDk4xyzVLDQwlbNapo.', 'Luis', 'Torres', 'coc1@fastfood.com', 1),
                                                                                    ('caja01', '$2a$10$HSS3JfzBcbQ7RKm6e32B.ODv9EW054/SdbHDk4xyzVLDQwlbNapo.', 'María', 'Lopez', 'caja1@fastfood.com', 1),
                                                                                    ('despacho01', '$2a$10$HSS3JfzBcbQ7RKm6e32B.ODv9EW054/SdbHDk4xyzVLDQwlbNapo.', 'Sofia', 'Castro', 'desp1@fastfood.com', 1);

-- Asignar roles
INSERT INTO usuario_rol (usuario_id, rol_id, activo) VALUES
                                                         (1, 1, 1),  -- admin01 → Admin
                                                         (4, 4, 1);  -- despacho01 → Despacho