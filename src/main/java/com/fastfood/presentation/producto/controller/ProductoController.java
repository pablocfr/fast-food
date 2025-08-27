package com.fastfood.presentation.producto.controller;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.service.ProductoService;
import com.fastfood.presentation.producto.dto.ProductoCreateRequestDTO;
import com.fastfood.presentation.producto.dto.ProductoResponseDTO;
import com.fastfood.presentation.producto.dto.ProductoUpdateRequestDTO;
import com.fastfood.presentation.producto.mapper.ProductoDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final ProductoDTOMapper productoDTOMapper;

    // --------------------------
    // Crear Producto
    // --------------------------
    @PostMapping
    public String crearProducto(@Valid @RequestBody ProductoCreateRequestDTO dto) {
        try {
            ProductoModel producto = productoDTOMapper.map(dto);
            productoService.guardar(producto);
            return "Producto registrado correctamente";
        } catch (RuntimeException e) {
            return "No se puede registrar el producto: " + e.getMessage();
        }
    }

    // --------------------------
    // Actualizar Producto
    // --------------------------
    @PutMapping("/{id}")
    public String actualizarProducto(@PathVariable Integer id, @Valid @RequestBody ProductoUpdateRequestDTO dto) {
        try {
            ProductoModel producto = productoDTOMapper.mapUpdate(dto);
            productoService.actualizar(id, producto);
            return "Producto actualizado correctamente";
        } catch (RuntimeException e) {
            return "No se puede actualizar el producto: " + e.getMessage();
        }
    }

    // --------------------------
    // Eliminar Producto
    // --------------------------
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        try {
            productoService.eliminar(id);
            return "Producto eliminado correctamente";
        } catch (RuntimeException e) {
            return "No se puede eliminar el producto: " + e.getMessage();
        }
    }

    // --------------------------
    // Listar todos los productos
    // --------------------------
    @GetMapping
    public List<ProductoResponseDTO> listarProductos() {
        return productoService.listarTodos()
                .stream()
                .map(productoDTOMapper::map)
                .toList();
    }

    // --------------------------
    // Buscar producto por ID
    // --------------------------
    @GetMapping("/{id}")
    public ProductoResponseDTO obtenerProducto(@PathVariable Integer id) {
        ProductoModel producto = productoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        return productoDTOMapper.map(producto);
    }

}
