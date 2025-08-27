package com.fastfood.infrastructure.persistence.producto.repository;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.producto.jpa.ProductoRepositoryJPA;
import com.fastfood.infrastructure.persistence.producto.mapper.CategoriaProdMapper;
import com.fastfood.infrastructure.persistence.producto.mapper.ProductoMapper;
import com.fastfood.infrastructure.persistence.producto.mapper.ProveedorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository {

    private final ProductoMapper productoMapper;
    private final ProductoRepositoryJPA productoRepositoryJPA;
    private final CategoriaProdMapper categoriaProdMapper;
    private final ProveedorMapper proveedorMapper;

    @Override
    public Optional<ProductoModel> buscarPorId(int id) {
        return productoRepositoryJPA.findById(id)
                .stream()
                .map(productoMapper::map)
                .findFirst();
    }

    @Override
    public List<ProductoModel> listarTodos() {
        return productoRepositoryJPA.findAll()
                .stream()
                .map(productoMapper::map)
                .toList();
    }

    @Override
    public ProductoModel guardar(ProductoModel producto) {
        return productoMapper.map(
                productoRepositoryJPA.save(
                        productoMapper.mapEntity(producto)));
    }

    @Override
    public ProductoModel actualizar(int id, ProductoModel producto) {

        ProductoEntity productoExistente = productoRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        //Actualizar los campos
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setRequiereCocina(producto.getRequiereCocina());
        productoExistente.setCategoria(
                producto.getCategoria() != null ?
                        categoriaProdMapper.mapEntity(producto.getCategoria()) :
                        productoExistente.getCategoria()
        );

        productoExistente.setProveedor(
                producto.getProveedor() != null ?
                        proveedorMapper.mapEntity(producto.getProveedor()) :
                        productoExistente.getProveedor()
        );

        ProductoEntity guardado = productoRepositoryJPA.save(productoExistente);
        return productoMapper.map(guardado);
    }

    @Override
    public void eliminar(int id) {
        productoRepositoryJPA.deleteById(id);
    }
}
