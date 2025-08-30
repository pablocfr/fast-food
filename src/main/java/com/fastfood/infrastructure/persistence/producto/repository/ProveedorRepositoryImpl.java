package com.fastfood.infrastructure.persistence.producto.repository;

import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.domain.producto.repository.ProveedorRepository;
import com.fastfood.infrastructure.persistence.producto.jpa.ProveedorRepositoryJPA;
import com.fastfood.infrastructure.persistence.producto.mapper.ProveedorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProveedorRepositoryImpl implements ProveedorRepository {

    private final ProveedorRepositoryJPA proveedorRepositoryJPA;
    private final ProveedorMapper proveedorMapper;

    @Override
    public Optional<ProveedorModel> buscarProveedorPorId(Integer id) {
        return proveedorRepositoryJPA.findById(id)
                .stream()
                .map(proveedorMapper::map)
                .findFirst();
    }

    @Override
    public List<ProveedorModel> listarProveedores() {
        return proveedorRepositoryJPA.findAll()
                .stream()
                .map(proveedorMapper::map)
                .toList();
    }

    @Override
    public ProveedorModel guardarProveedor(ProveedorModel proveedor) {

        proveedor.setActivo(true);

        return proveedorMapper.map(
                proveedorRepositoryJPA.save(
                        proveedorMapper.mapEntity(proveedor)));
    }
}
