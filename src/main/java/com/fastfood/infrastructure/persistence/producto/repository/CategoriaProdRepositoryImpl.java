package com.fastfood.infrastructure.persistence.producto.repository;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.repository.CategoriaProdRepository;
import com.fastfood.infrastructure.persistence.producto.jpa.CategoriaProRepositoryJPA;
import com.fastfood.infrastructure.persistence.producto.mapper.CategoriaProdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoriaProdRepositoryImpl implements CategoriaProdRepository {

    private final CategoriaProRepositoryJPA categoriaProRepositoryJPA;
    private final CategoriaProdMapper categoriaProdMapper;

    @Override
    public Optional<CategoriaProdModel> buscarCategoriaPorId(Integer id) {
        return categoriaProRepositoryJPA.findById(id)
                .stream()
                .map(categoriaProdMapper::map)
                .findFirst();
    }

    @Override
    public List<CategoriaProdModel> listarCategorias() {
        return categoriaProRepositoryJPA.findAll()
                .stream()
                .map(categoriaProdMapper::map)
                .toList();
    }

    @Override
    public CategoriaProdModel guardarCategoria(CategoriaProdModel categoria) {

        categoria.setActivo(true);

        return categoriaProdMapper.map(
                categoriaProRepositoryJPA.save(
                        categoriaProdMapper.mapEntity(categoria)));
    }
}
