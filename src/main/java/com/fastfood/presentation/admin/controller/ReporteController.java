package com.fastfood.presentation.admin.controller;

import com.fastfood.infrastructure.persistence.admin.service.ReporteService;
import com.fastfood.presentation.admin.dto.IngresosDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fastfood.presentation.admin.dto.ProductoTopDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/reportes")
@PreAuthorize("hasRole('Admin')")
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/ingresos")
    public ResponseEntity<IngresosDto> obtenerIngresos() {
        return ResponseEntity.ok(reporteService.obtenerIngresos());
    }

    @GetMapping("/productos-top")
    public ResponseEntity<List<ProductoTopDto>> obtenerProductosTop(
            @RequestParam(defaultValue = "3") int limite) {

        List<ProductoTopDto> productos = reporteService.obtenerProductosTop(limite);
        return ResponseEntity.ok(productos);
    }
}