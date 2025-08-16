package com.fastfood.infrastructure.persistence.cliente.entity;


import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import com.fastfood.infrastructure.persistence.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nombre;
    private String nroDocumento;
    private Boolean activo = true;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidos;

}
