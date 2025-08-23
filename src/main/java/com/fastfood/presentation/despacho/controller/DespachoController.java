package com.fastfood.presentation.despacho.controller;

import com.fastfood.infrastructure.persistence.despacho.service.DespachoService;
import com.fastfood.presentation.despacho.dto.PedidoDespachoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/despacho")
@PreAuthorize("hasRole('Despacho')")
public class DespachoController {

    private final DespachoService despachoService;

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoDespachoDto>> listarPedidosListos() {
        return ResponseEntity.ok(despachoService.listarPedidosListosHoy());
    }

    @GetMapping("/pedidosEntregados")
    public ResponseEntity<List<PedidoDespachoDto>> listarPedidosEntregados() {
        return ResponseEntity.ok(despachoService.listarPedidosEntregadosHoy());
    }

    @PutMapping("/pedidos/{id}/entregar")
    public ResponseEntity<Void> entregarPedido(@PathVariable("id") Integer idPedido) {
        despachoService.marcarComoEntregado(idPedido);
        return ResponseEntity.ok().build();
    }
}