package com.fastfood.infrastructure.persistence.pedido.repository;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.repository.ComboRepository;
import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.repository.PedidoRepository;
import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import com.fastfood.infrastructure.persistence.pedido.jpa.PedidoRepositoryJPA;
import com.fastfood.infrastructure.persistence.pedido.mapper.PedidoMapper;
import com.fastfood.infrastructure.persistence.producto.jpa.ProductoRepositoryJPA;
import com.fastfood.infrastructure.persistence.producto.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoRepositoryJPA pedidoRepositoryJPA;
    private final ProductoRepositoryJPA productoRepositoryJPA;
    private final ComboRepository comboRepository;
    private final ProductoRepository productoRepository;
    private final PedidoMapper pedidoMapper;
    private final ProductoMapper productoMapper;

    @Override
    public Optional<PedidoModel> buscarPorId(Integer id) {
        return pedidoRepositoryJPA.findById(id)
                .stream()
                .map(pedidoMapper::map)
                .findFirst();
    }

    @Override
    public PedidoModel guardar(PedidoModel pedidoModel) {
        return pedidoMapper.map(
                pedidoRepositoryJPA.save(
                        pedidoMapper.mapEntity(pedidoModel)));
    }

    @Override
    public PedidoModel actualizar(Integer id, PedidoModel pedidoModel) {
        return null;
    }

    @Override
    public void borrarItem(Integer id) {

    }

    @Override
    public void cancelarPedido(Integer id) {
        PedidoModel pedido = buscarPorId(id).orElseThrow(() ->
                new RuntimeException("Pedido no encontrado con id: " + id));

        pedido.setEstado("Cancelado");
        guardar(pedido);
    }

    @Override
    public List<PedidoModel> listarPedidos() {
        return pedidoRepositoryJPA.findAll()
                .stream()
                .map(pedidoMapper::map)
                .toList();
    }

    @Override
    public List<ComboModel> listarCombos() {
        return comboRepository.buscarTodos();
    }

    @Override
    public List<ProductoModel> listarProductos() {
        return productoRepository.listarTodos();
    }

    @Override
    public List<ProductoModel> listarProductosPorNombre(String nombre) {
        return productoRepositoryJPA.findByNombre(nombre)
                .stream()
                .map(productoMapper::map)
                .toList();
    }

    @Override
    public List<ProductoModel> listarPorTipoProducto(String tipoProducto) {
        return productoRepositoryJPA.listarPorNombreCategoria(tipoProducto)
                .stream()
                .map(productoMapper::map)
                .toList();
    }
}
