package com.fastfood.application.producto;

import com.fastfood.application.producto.usecase.CrearCategoriaUseCase;
import com.fastfood.application.producto.usecase.ListarCategoriasUseCase;
import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.service.CategoriaProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaProdService {

    private final CrearCategoriaUseCase crearCategoriaUseCase;
    private final ListarCategoriasUseCase listarCategoriasUseCase;

    @Override
    public Optional<CategoriaProdModel> buscarCategoriaPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<CategoriaProdModel> listarCategorias() {
        return listarCategoriasUseCase.listarCategorias();
    }

    @Override
    public CategoriaProdModel guardarCategoria(CategoriaProdModel categoria) {
        return crearCategoriaUseCase.crearCategoria(categoria);
    }
}
