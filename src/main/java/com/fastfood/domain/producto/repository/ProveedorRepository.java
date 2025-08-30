package com.fastfood.domain.producto.repository;

import com.fastfood.domain.producto.model.ProveedorModel;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository {

    Optional<ProveedorModel> buscarProveedorPorId(Integer id);
    List<ProveedorModel> listarProveedores();
    ProveedorModel guardarProveedor(ProveedorModel proveedor);

}
