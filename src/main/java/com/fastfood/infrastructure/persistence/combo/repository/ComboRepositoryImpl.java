package com.fastfood.infrastructure.persistence.combo.repository;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.repository.ComboRepository;
import com.fastfood.infrastructure.persistence.combo.jpa.ComboRepositoryJPA;
import com.fastfood.infrastructure.persistence.combo.mapper.ComboMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ComboRepositoryImpl implements ComboRepository {

    private final ComboMapper comboMapper;
    private final ComboRepositoryJPA comboRepositoryJPA;

    @Override
    public Optional<ComboModel> buscarPorId(Integer id) {
        return comboRepositoryJPA.findById(id)
                .stream()
                .map(comboMapper::map)
                .findFirst();
    }

    @Override
    public List<ComboModel> buscarTodos() {
        return comboRepositoryJPA.findAll()
                .stream()
                .map(comboMapper::map)
                .toList();
    }

    @Override
    public ComboModel guardar(ComboModel combo) {
        return comboMapper.map(
                comboRepositoryJPA.save(
                        comboMapper.mapEntity(combo)));
    }

    @Override
    public ComboModel actualizar(Integer id, ComboModel combo) {

        // validar existencia
        buscarPorId(id).orElseThrow(() ->
                new RuntimeException("Combo no encontrado con id: " + id));

        // setear id explícitamente
        combo.setIdCombo(id);

        return comboMapper.map(
                comboRepositoryJPA.save(comboMapper.mapEntity(combo))
        );
    }

    @Override
    public void eliminar(Integer id) {
        ComboModel eliminarCombo = buscarPorId(id).orElseThrow(() ->
                new RuntimeException("Combo no encontrado con id: " + id));

        eliminarCombo.setActivo(false);
        comboMapper.map(
                comboRepositoryJPA.save(
                        comboMapper.mapEntity(eliminarCombo)));
    }

    @Override
    public List<ComboModel> listarCombos() {
        return comboRepositoryJPA.findAllWithProductos()
                .stream()
                .map(comboMapper::map)
                .toList();
    }
}
