package com.fastfood.presentation.producto.controller;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.service.CategoriaProdService;
import com.fastfood.presentation.producto.dto.CategoriaCreateRequestDTO;
import com.fastfood.presentation.producto.dto.CategoriaProdDTO;
import com.fastfood.presentation.producto.mapper.CategoriaDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public String guardarCategoria(@RequestBody CategoriaCreateRequestDTO dto) {
        try {
            CategoriaProdModel categoria = categoriaDTOMapper.map(dto);
            categoriaProdService.guardarCategoria(categoria);
            return "Categoría registrada correctamente";
        } catch (RuntimeException e) {
            return "No se puede registrar la categoría: " + e.getMessage();
        }
    }

}
