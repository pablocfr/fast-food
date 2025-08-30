package com.fastfood.application.producto;

import com.fastfood.application.producto.usecase.CrearProveedorUseCase;
import com.fastfood.application.producto.usecase.ListarProveedoresUseCase;
import com.fastfood.application.producto.usecase.ObtenerProveedorUseCase;
import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.domain.producto.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final CrearProveedorUseCase crearProveedorUseCase;
    private final ListarProveedoresUseCase listarProveedoresUseCase;
    private final ObtenerProveedorUseCase obtenerProveedorUseCase;

    @Override
    public Optional<ProveedorModel> buscarProveedorPorId(Integer id) {
        return obtenerProveedorUseCase.obtenerProveedorPorId(id);
    }

    @Override
    public List<ProveedorModel> listarProveedores() {
        return listarProveedoresUseCase.listarProveedores();
    }

    @Override
    public ProveedorModel guardarProveedor(ProveedorModel proveedor) {
        return crearProveedorUseCase.crearProveedor(proveedor);
    }
}
