package com.fastfood.domain.cliente.model;
import com.fastfood.domain.pedido.model.PedidoModel;
import lombok.Data;
import java.util.List;

@Data
public class ClienteModel {

    private Integer idCliente;

    private String nombre;
    private String nroDocumento;
    private Boolean activo;
    private List<PedidoModel> pedidos;
}
