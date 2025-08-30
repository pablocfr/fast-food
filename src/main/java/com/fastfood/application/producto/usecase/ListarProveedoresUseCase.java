package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.domain.producto.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarProveedoresUseCase {

    private final ProveedorRepository proveedorRepository;

    public List<ProveedorModel> listarProveedores(){
        return proveedorRepository.listarProveedores();
    }

}
