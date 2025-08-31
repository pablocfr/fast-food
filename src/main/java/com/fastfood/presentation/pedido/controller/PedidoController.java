package com.fastfood.presentation.pedido.controller;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.service.PedidoService;
import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.valueobject.PaginaResult;
import com.fastfood.domain.producto.valueobject.PaginacionRequest;
import com.fastfood.presentation.pedido.dto.DetallePedidoCreateDTO;
import com.fastfood.presentation.pedido.dto.PedidoCreateRequestDTO;
import com.fastfood.presentation.pedido.dto.PedidoResponseDTO;
import com.fastfood.presentation.pedido.mapper.PedidoDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoDTOMapper pedidoDTOMapper;

    // --------------------------
    // Crear Pedido con múltiples productos
    // --------------------------
    @PostMapping
    public String crearPedido(@Valid @RequestBody PedidoCreateRequestDTO dto) {
        try {

            List<DetallePedidoCreateDTO> detalles = dto.detalles();

            PedidoModel pedido = pedidoDTOMapper.map(dto);
            pedidoService.guardar(pedido);
            return "Pedido registrado correctamente";
        } catch (RuntimeException e) {
            return "No se puede registrar el pedido: " + e.getMessage();
        }
    }

    // --------------------------
    // Otros endpoints: listar, obtener, eliminar
    // --------------------------
    @GetMapping
    public List<PedidoResponseDTO> listarPedidos() {
        return pedidoService.listarPedidos()
                .stream()
                .map(pedidoDTOMapper::map)
                .toList();
    }

    @GetMapping("/pendientes")
    public List<PedidoResponseDTO> listarPedidosPendientes(){
        return pedidoService.listarPorEstado("Pendiente")
                .stream()
                .map(pedidoDTOMapper::map)
                .toList();
    }

    @GetMapping("/preparacion")
    public List<PedidoResponseDTO> listarPedidosPreparacion(){
        return pedidoService.listarPorEstado("Preparando")
                .stream()
                .map(pedidoDTOMapper::map)
                .toList();
    }

    @GetMapping("/completados")
    public List<PedidoResponseDTO> listarPedidosCompletados(){
        return pedidoService.listarPorEstado("Completado")
                .stream()
                .map(pedidoDTOMapper::map)
                .toList();
    }

    @GetMapping("/estado/{estado}")
    public List<PedidoResponseDTO> listarPedidosPorEstado(@PathVariable String estado){
        return pedidoService.listarPorEstado(estado)
                .stream()
                .map(pedidoDTOMapper::map)
                .toList();
    }

//    @GetMapping("/completados")
//    public List<PedidoModel> listarPedidosCompletados(){
//        return pedidoService.listarPorEstado("Completado");
//    }

    @GetMapping("/entregados")
    public List<PedidoResponseDTO> listarPedidosEntregados(){
        return pedidoService.listarPorEstado("Entregado")
                .stream()
                .map(pedidoDTOMapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO obtenerPedido(@PathVariable Integer id) {
        PedidoModel pedido = pedidoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));
        return pedidoDTOMapper.map(pedido);
    }

    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable Integer id) {
        try {
            pedidoService.cancelarPedido(id);
            return "Pedido eliminado correctamente";
        } catch (RuntimeException e) {
            return "No se puede eliminar el pedido: " + e.getMessage();
        }
    }

    @PatchMapping("/{id}")
    public String cambiarEstadoPedido(@PathVariable Integer id) {
        try {
            pedidoService.cambiarEstadoPedido(id);
            return "Estado del pedido cambiado correctamente" + id;
        } catch (RuntimeException e) {
            return "No se puede cambiar el estado del pedido: " + e.getMessage();
        }
    }

    @GetMapping("/paginado")
    public ResponseEntity<PaginaResult<PedidoResponseDTO>> listarPedidos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio,
            @RequestParam(defaultValue = "id") String ordenarPor,
            @RequestParam(defaultValue = "asc") String direccion) {

        PaginacionRequest paginacion = PaginacionRequest.builder()
                .pagina(pagina)
                .tamanio(tamanio)
                .ordenarPor(ordenarPor)
                .direccion(direccion)
                .build();

        // Aquí el map transforma cada PedidoModel en PedidoResponseDTO
        PaginaResult<PedidoResponseDTO> resultado =
                pedidoService.listarPedidosPaginado(paginacion)
                        .map(pedidoDTOMapper::map);

        return ResponseEntity.ok(resultado);
    }

}
