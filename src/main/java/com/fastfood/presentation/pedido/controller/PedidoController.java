package com.fastfood.presentation.pedido.controller;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.service.PedidoService;
import com.fastfood.presentation.pedido.dto.DetallePedidoCreateDTO;
import com.fastfood.presentation.pedido.dto.PedidoCreateRequestDTO;
import com.fastfood.presentation.pedido.dto.PedidoResponseDTO;
import com.fastfood.presentation.pedido.mapper.PedidoDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
}
