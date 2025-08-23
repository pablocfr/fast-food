package com.fastfood.presentation.admin.controller;

import com.fastfood.infrastructure.persistence.admin.service.ProveedorService;
import com.fastfood.presentation.admin.dto.CrearProveedorDto;
import com.fastfood.presentation.admin.dto.ProveedorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/proveedores")
//@PreAuthorize("hasRole('Admin')")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> listar() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDto> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(proveedorService.obtenerProveedorPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorDto> crear(@RequestBody CrearProveedorDto dto) {
        return ResponseEntity.ok(proveedorService.crearProveedor(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDto> editar(@PathVariable Integer id, @RequestBody CrearProveedorDto dto) {
        proveedorService.editarProveedor(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.ok().build();
    }
}