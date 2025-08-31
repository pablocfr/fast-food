package com.fastfood.presentation.combo.controller;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.service.ComboService;
import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import com.fastfood.infrastructure.persistence.combo.jpa.ComboRepositoryJPA;
import com.fastfood.presentation.combo.dto.request.ComboCreateRequestDTO;
import com.fastfood.presentation.combo.dto.request.ComboDTO;
import com.fastfood.presentation.combo.dto.request.ComboUpdateRequestDTO;
import com.fastfood.presentation.combo.mapper.ComboDTOMapper;
import com.fastfood.presentation.combo.mapper.PresentationComboMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/combos")
@RequiredArgsConstructor
public class ComboController {

    private final ComboService comboService;
    private final ComboDTOMapper comboDTOMapper;

    private final PresentationComboMapper comboMapper;
    private final ComboRepositoryJPA comboRepositoryJPA;

    // 1. Crear Combo
    @PostMapping
    public String crearCombo(@Valid @RequestBody ComboCreateRequestDTO dto) {
        try {
            // Mapear DTO plano a Model
            ComboModel combo = comboDTOMapper.map(dto);
            comboService.guardar(combo);
            return "Combo registrado correctamente";
        } catch (RuntimeException e) {
            return "No se puede registrar el combo: " + e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String actualizarCombo(@PathVariable Integer id, @Valid @RequestBody ComboUpdateRequestDTO request) {
        try {
            ComboModel combo = comboDTOMapper.mapUpdate(request);
            comboService.actualizar(id, combo);
            return "Combo actualizado correctamente";
        } catch (RuntimeException e) {
            return "No se puede actualizar el combo: " + e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarCombo(@PathVariable Integer id) {
        try {
            comboService.eliminar(id);
            return "Combo eliminado correctamente";
        } catch (RuntimeException e) {
            return "No se puede eliminar el combo: " + e.getMessage();
        }
    }

//    @GetMapping
//    public List<ComboModel> listarCombos() {
//        return comboService.buscarTodos();
//    }

    @GetMapping
    public List<ComboDTO> listarCombos() {
        List<ComboEntity> combos = comboRepositoryJPA.findAll();
        return comboMapper.toDTOList(combos);
    }

}
