package com.fastfood.presentation.producto.controller;

import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.domain.producto.service.ProveedorService;
import com.fastfood.presentation.producto.dto.ProveedorCreateRequestDTO;
import com.fastfood.presentation.producto.dto.ProveedorResponseDTO;
import com.fastfood.presentation.producto.mapper.ProveedorDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;
    private final ProveedorDTOMapper proveedorDTOMapper;

    @GetMapping
    public List<ProveedorResponseDTO> listarProveedores(){
        return proveedorService.listarProveedores()
                .stream()
                .map(proveedorDTOMapper::map)
                .toList();
    }

    @PostMapping
    public String guardar(@Valid @RequestBody ProveedorCreateRequestDTO dto){
        try {
            ProveedorModel proveedor = proveedorDTOMapper.map(dto);
            proveedorService.guardarProveedor(proveedor);
            return "Proveedor registrado correctamente";
        } catch (RuntimeException e) {
            return "No se puede registrar el proveedor: " + e.getMessage();
        }
    }

}
