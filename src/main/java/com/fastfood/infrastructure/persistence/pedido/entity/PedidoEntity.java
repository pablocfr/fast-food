package com.fastfood.infrastructure.persistence.pedido.entity;

import com.fastfood.infrastructure.persistence.cliente.entity.ClienteEntity;
import com.fastfood.infrastructure.persistence.seguridad.entity.UsuarioEntity;
import com.fastfood.infrastructure.persistence.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private LocalDateTime fechaHora;
    private String estado;
    private String numeroTicket;
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedidoEntity> detalles;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "usuario_actualizacion")
    private String usuarioActualizacion;

}
