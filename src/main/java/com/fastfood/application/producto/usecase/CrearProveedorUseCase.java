package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.domain.producto.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearProveedorUseCase {

    private final ProveedorRepository proveedorRepository;

    public ProveedorModel crearProveedor(ProveedorModel proveedor) {
        return proveedorRepository.guardarProveedor(proveedor);
    }

}
