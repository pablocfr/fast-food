package com.fastfood.domain.pedido.repository;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.producto.model.ProductoModel;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    Optional<PedidoModel> buscarPorId(Integer id);
    PedidoModel guardar(PedidoModel pedidoModel);
    PedidoModel actualizar(Integer id, PedidoModel pedidoModel);
    void borrarItem(Integer id);
    void cancelarPedido(Integer id);
    List<PedidoModel> listarPedidos();
    List<ComboModel> listarCombos();
    List<ProductoModel> listarProductos();
    List<ProductoModel> listarProductosPorNombre(String nombre);
    List<ProductoModel> listarPorTipoProducto(String tipoProducto);

}
