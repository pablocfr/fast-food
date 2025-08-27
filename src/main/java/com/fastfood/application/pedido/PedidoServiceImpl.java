package com.fastfood.application.pedido;

import com.fastfood.application.pedido.usecase.*;
import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.service.PedidoService;
import com.fastfood.domain.producto.model.ProductoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final ActualizarPedidoUseCase actualizarPedidoUseCase;
    private final BuscarPedidoPorId buscarPedidoPorId;
    private final CancelarPedidoUseCase cancelarPedidoUseCase;
    private final CrearPedidoUseCase crearPedidoUseCase;
    private final EliminarItemUseCase eliminarItemUseCase;
    private final ListarComboUseCase listarComboUseCase;
    private final ListarPedidosUseCase listarPedidosUseCase;
    private final ListarProductosUseCase listarProductosUseCase;
    private final ListarProductosPorNombre listarProductosPorNombre;
    private final ListarTipoProductoUseCase listarTipoProductoUseCase;

    @Override
    public Optional<PedidoModel> buscarPorId(Integer id) {
        return buscarPedidoPorId.buscarPedidoPorId(id);
    }

    @Override
    public PedidoModel guardar(PedidoModel pedidoModel) {
        return crearPedidoUseCase.crearPedido(pedidoModel);
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
        cancelarPedidoUseCase.cancelarPedido(id);
    }

    @Override
    public List<PedidoModel> listarPedidos() {
        return listarPedidosUseCase.listarPedidos();
    }

    @Override
    public List<ComboModel> listarCombos() {
        return listarComboUseCase.listarCombos();
    }

    @Override
    public List<ProductoModel> listarProductos() {
        return listarProductosUseCase.listarProductos();
    }

    @Override
    public List<ProductoModel> listarProductosPorNombre(String nombre) {
        return listarProductosPorNombre.listarProductosPorNombre(nombre);
    }

    @Override
    public List<ProductoModel> listarPorTipoProducto(String tipoProducto) {
        return listarTipoProductoUseCase.listarProductosPorNombre(tipoProducto);
    }
}
