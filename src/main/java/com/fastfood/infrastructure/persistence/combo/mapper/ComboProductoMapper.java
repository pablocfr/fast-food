package com.fastfood.infrastructure.persistence.combo.mapper;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.model.ComboProductoModel;
import com.fastfood.domain.pedido.model.DetallePedidoModel;
import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.seguridad.model.RolModel;
import com.fastfood.domain.seguridad.model.UsuarioModel;
import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import com.fastfood.infrastructure.persistence.combo.entity.ComboProductoEntity;
import com.fastfood.infrastructure.persistence.pedido.entity.DetallePedidoEntity;
import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.producto.mapper.ProductoMapper;
import com.fastfood.infrastructure.persistence.seguridad.entity.RolEntity;
import com.fastfood.infrastructure.persistence.seguridad.entity.UsuarioEntity;
import com.fastfood.infrastructure.persistence.seguridad.entity.UsuarioRolEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface ComboProductoMapper {

    @Mapping(target = "producto.comboProductos", ignore = true)
    ComboProductoModel map(ComboProductoEntity entity);

    List<ComboProductoModel> mapList(List<ComboProductoEntity> entities);

    // Usuario ↔ Rol
    @Mapping(target = "roles", ignore = true) // rompe recursión
    UsuarioModel usuarioEntityToUsuarioModel(UsuarioEntity entity);

    // RolModel no tiene usuario, así que no poner ignore
    RolModel usuarioRolEntityToRolModel(RolEntity entity);

    @Mapping(target = "detalles", ignore = true)
    @Mapping(target = "usuario.roles", ignore = true)
    PedidoModel pedidoEntityToPedidoModel(PedidoEntity entity);

    @Mapping(target = "pedido", ignore = true)
    DetallePedidoModel detallePedidoEntityToDetallePedidoModel(DetallePedidoEntity entity);
}
