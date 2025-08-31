package com.fastfood.presentation.producto.controller;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.service.CategoriaProdService;
import com.fastfood.presentation.producto.dto.CategoriaCreateRequestDTO;
import com.fastfood.presentation.producto.dto.CategoriaProdDTO;
import com.fastfood.presentation.producto.mapper.CategoriaDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaProdService categoriaProdService;
    private final CategoriaDTOMapper categoriaDTOMapper;

    @GetMapping
    public List<CategoriaProdDTO> listarCategorias() {
       return categoriaProdService.listarCategorias()
               .stream()
               .map(categoriaDTOMapper::map)
               .toList();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crearCategoria(@Valid @RequestBody CategoriaCreateRequestDTO dto) {
        Map<String, Object> response = new HashMap<>();
        try {

            CategoriaProdModel categoria = categoriaDTOMapper.map(dto);
            categoriaProdService.guardarCategoria(categoria);

            response.put("success", true);
            response.put("message", "Categoría registrada correctamente");

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", "No se puede registrar la categoría: " + e.getMessage());

            return ResponseEntity.badRequest().body(response);
        }
    }

}


