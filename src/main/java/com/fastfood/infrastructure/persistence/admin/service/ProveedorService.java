package com.fastfood.infrastructure.persistence.admin.service;

import com.fastfood.infrastructure.persistence.proveedor.entity.ProveedorEntity;
import com.fastfood.infrastructure.persistence.proveedor.jpa.ProveedorRepositoryJpa;
import com.fastfood.presentation.admin.dto.CrearProveedorDto;
import com.fastfood.presentation.admin.dto.ProveedorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepositoryJpa proveedorRepository;

    @Transactional(readOnly = true)
    public List<ProveedorDto> listarProveedores() {
        return proveedorRepository.findAllActivos().stream()
                .map(p -> new ProveedorDto(p.getIdProveedor(), p.getNombre(), p.getContacto()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProveedorDto obtenerProveedorPorId(Integer id) {
        ProveedorEntity p = proveedorRepository.findByIdActivo(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        return new ProveedorDto(p.getIdProveedor(), p.getNombre(), p.getContacto());
    }

    @Transactional
    public ProveedorDto crearProveedor(CrearProveedorDto dto) {
        if (proveedorRepository.existsByNombreAndActivoTrue(dto.nombre())) {
            throw new RuntimeException("Ya existe un proveedor con ese nombre");
        }

        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setNombre(dto.nombre());
        proveedor.setContacto(dto.contacto());
        proveedor.setActivo(true);

        ProveedorEntity guardado = proveedorRepository.save(proveedor);
        return new ProveedorDto(guardado.getIdProveedor(), guardado.getNombre(), guardado.getContacto());
    }

    @Transactional
    public void editarProveedor(Integer id, CrearProveedorDto dto) {
        ProveedorEntity proveedor = proveedorRepository.findByIdActivo(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        if (!proveedor.getNombre().equals(dto.nombre()) &&
                proveedorRepository.existsByNombreAndActivoTrue(dto.nombre())) {
            throw new RuntimeException("Ya existe un proveedor con ese nombre");
        }

        proveedor.setNombre(dto.nombre());
        proveedor.setContacto(dto.contacto());
        proveedorRepository.save(proveedor);
    }

    @Transactional
    public void eliminarProveedor(Integer id) {
        ProveedorEntity proveedor = proveedorRepository.findByIdActivo(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setActivo(false);
        proveedorRepository.save(proveedor);
    }
}