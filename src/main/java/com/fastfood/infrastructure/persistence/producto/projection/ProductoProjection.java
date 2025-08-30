package com.fastfood.infrastructure.persistence.producto.projection;

public interface ProductoProjection
{
    Integer getIdProducto();
    String getNombre();
    Boolean getRequiereCocina();
    Boolean getActivo();
    Double getPrecio();
    Integer getCategoria();
    Integer getProveedor();

}

//private Integer idProducto;
//
//private String nombre;
//private Double precio;
//private Boolean requiereCocina;
//private Boolean activo = true;
//
//@ManyToOne
//@JoinColumn(name = "categoria_id")
//private CategoriaProdEntity categoria;
//
//@ManyToOne
//@JoinColumn(name = "proveedor_id")
//private ProveedorEntity proveedor;
//
//@OneToMany(mappedBy = "producto")
//private List<ComboProductoEntity> comboProductos;