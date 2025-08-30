package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.repository.CategoriaProdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarCategoriasUseCase {

    private final CategoriaProdRepository categoriaProdRepository;

    public List<CategoriaProdModel> listarCategorias(){
        return categoriaProdRepository.listarCategorias();
    }

}
