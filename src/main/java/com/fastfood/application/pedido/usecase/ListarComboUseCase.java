package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarComboUseCase {

    private final PedidoRepository pedidoRepository;

    public List<ComboModel> listarCombos() {
        return pedidoRepository.listarCombos();
    }
}
