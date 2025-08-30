package com.fastfood.domain.producto.service;

import com.fastfood.domain.producto.model.ProveedorModel;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    Optional<ProveedorModel> buscarProveedorPorId(Integer id);
    List<ProveedorModel> listarProveedores();
    ProveedorModel guardarProveedor(ProveedorModel proveedor);
}
