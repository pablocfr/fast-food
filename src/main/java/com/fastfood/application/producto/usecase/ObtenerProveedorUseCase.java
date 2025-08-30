package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.domain.producto.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ObtenerProveedorUseCase {

    private final ProveedorRepository proveedorRepository;

    public Optional<ProveedorModel> obtenerProveedorPorId(Integer id){
        return proveedorRepository.buscarProveedorPorId(id);
    }

}
