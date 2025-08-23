package com.fastfood.infrastructure.persistence.admin.service;

import com.fastfood.infrastructure.persistence.producto.jpa.ProductoRepositoryJpa;
import com.fastfood.presentation.admin.dto.IngresosDto;
import com.fastfood.presentation.admin.dto.ProductoTopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReporteService {

    @PersistenceContext
    private EntityManager em;

    private final ProductoRepositoryJpa productoRepository;

    /**
     * Obtiene los ingresos por período
     */
    public IngresosDto obtenerIngresos() {
        Double dia = calcularIngresosDelDia();
        Double semana = calcularIngresosSemana();
        Double mes = calcularIngresosMes();
        Double promedio = mes != null ? mes / 30.0 : 0.0;

        return new IngresosDto(
                dia != null ? dia : 0.0,
                semana != null ? semana : 0.0,
                mes != null ? mes : 0.0,
                promedio
        );
    }

    private Double calcularIngresosDelDia() {
        Object result = em.createNativeQuery("""
        SELECT COALESCE(SUM(
            CASE 
                WHEN dp.id_combo_producto IS NOT NULL THEN c.precio * dp.cantidad
                ELSE p.precio * dp.cantidad
            END
        ), 0)
        FROM detalle_pedido dp
        JOIN pedido pe ON dp.id_pedido = pe.id_pedido
        LEFT JOIN combo c ON dp.id_combo_producto IS NOT NULL AND c.id_combo = (
            SELECT cp.id_combo FROM combo_producto cp WHERE cp.id_combo_producto = dp.id_combo_producto
        )
        LEFT JOIN producto p ON dp.id_producto = p.id_producto
        WHERE pe.estado = 'Entregado'
          AND pe.activo = 1
          AND DATE(pe.fecha_hora) = CURRENT_DATE
        """).getSingleResult();
        return ((Number) result).doubleValue();
    }

    private Double calcularIngresosSemana() {
        Object result = em.createNativeQuery("""
        SELECT COALESCE(SUM(
            CASE 
                WHEN dp.id_combo_producto IS NOT NULL THEN c.precio * dp.cantidad
                ELSE p.precio * dp.cantidad
            END
        ), 0)
        FROM detalle_pedido dp
        JOIN pedido pe ON dp.id_pedido = pe.id_pedido
        LEFT JOIN combo c ON dp.id_combo_producto IS NOT NULL AND c.id_combo = (
            SELECT cp.id_combo FROM combo_producto cp WHERE cp.id_combo_producto = dp.id_combo_producto
        )
        LEFT JOIN producto p ON dp.id_producto = p.id_producto
        WHERE pe.estado = 'Entregado'
          AND pe.activo = 1
          AND pe.fecha_hora >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
        """).getSingleResult();
        return ((Number) result).doubleValue();
    }

    private Double calcularIngresosMes() {
        Object result = em.createNativeQuery("""
        SELECT COALESCE(SUM(
            CASE 
                WHEN dp.id_combo_producto IS NOT NULL THEN c.precio * dp.cantidad
                ELSE p.precio * dp.cantidad
            END
        ), 0)
        FROM detalle_pedido dp
        JOIN pedido pe ON dp.id_pedido = pe.id_pedido
        LEFT JOIN combo c ON dp.id_combo_producto IS NOT NULL AND c.id_combo = (
            SELECT cp.id_combo FROM combo_producto cp WHERE cp.id_combo_producto = dp.id_combo_producto
        )
        LEFT JOIN producto p ON dp.id_producto = p.id_producto
        WHERE pe.estado = 'Entregado'
          AND pe.activo = 1
          AND YEAR(pe.fecha_hora) = YEAR(CURDATE())
          AND MONTH(pe.fecha_hora) = MONTH(CURDATE())
        """).getSingleResult();
        return ((Number) result).doubleValue();
    }

    /**
     * Obtiene los N productos más vendidos del día
     */
    public List<ProductoTopDto> obtenerProductosTop(int limite) {
        List<Object[]> resultados = productoRepository.findTopProductosVendidosHoy(limite);

        return resultados.stream()
                .map(r -> new ProductoTopDto(
                        ((com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity) r[0]).getNombre(),
                        ((Number) r[1]).intValue()
                ))
                .limit(limite)
                .collect(Collectors.toList());
    }
}