package com.fastfood.infrastructure.persistence.despacho.service;

import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import com.fastfood.infrastructure.persistence.pedido.jpa.PedidoRepositoryJpa;
import com.fastfood.presentation.despacho.dto.PedidoDespachoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DespachoService {

    private final PedidoRepositoryJpa pedidoRepository;

    @Transactional(readOnly = true)
    public List<PedidoDespachoDto> listarPedidosListosHoy() {
        return pedidoRepository.findListosParaEntregarHoy().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PedidoDespachoDto> listarPedidosEntregadosHoy() {
        return pedidoRepository.findEntregadosHoy().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void marcarComoEntregado(Integer idPedido) {
        PedidoEntity pedido = pedidoRepository.findByIdWithDetails(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if (!List.of("Listo", "Completado").contains(pedido.getEstado())) {
            throw new RuntimeException("El pedido no está listo para entregar");
        }

        pedido.setEstado("Entregado");
        pedido.setFechaActualizacion(LocalDateTime.now());
        pedidoRepository.save(pedido);
    }

    private PedidoDespachoDto toDto(PedidoEntity p) {
        BigDecimal total = calcularTotalPedido(p);
        return new PedidoDespachoDto(
                p.getIdPedido(),
                p.getNumeroTicket(),
                p.getCliente() != null ? p.getCliente().getNombre() : "Cliente",
                p.getFechaHora(),
                total.doubleValue()
        );
    }

    private BigDecimal calcularTotalPedido(PedidoEntity pedido) {
        return pedido.getDetalles().stream()
                .map(detalle -> {
                    if (detalle.getComboProducto() != null) {
                        return BigDecimal.valueOf(detalle.getComboProducto().getCombo().getPrecio())
                                .multiply(BigDecimal.valueOf(detalle.getCantidad()));
                    } else if (detalle.getProducto() != null) {
                        return BigDecimal.valueOf(detalle.getProducto().getPrecio())
                                .multiply(BigDecimal.valueOf(detalle.getCantidad()));
                    }
                    return BigDecimal.ZERO;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}