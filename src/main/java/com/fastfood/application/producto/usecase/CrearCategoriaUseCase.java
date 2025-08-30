package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.repository.CategoriaProdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearCategoriaUseCase {

    private final CategoriaProdRepository categoriaProdRepository;

    public CategoriaProdModel crearCategoria(CategoriaProdModel categoriaProdModel){
        return categoriaProdRepository.guardarCategoria(categoriaProdModel);
    }

}
