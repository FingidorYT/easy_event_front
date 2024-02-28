package com.example.easy_event_app.model;

public class Producto {

    private long id;
    private Integer codigo;
    private Long precio;
    private String nombre_producto;
    private Integer cantidad_disponible;
    private Integer cantidad_inventario;
    private Long empresa_id;
    private Long categoria_id;
    private String foto;

    public Producto(long id, Integer codigo, Long precio, String nombre_producto, Integer cantidad_disponible, Integer cantidad_inventario, Long empresa_id, Long categoria_id, String foto) {
        this.id = id;
        this.codigo = codigo;
        this.precio = precio;
        this.nombre_producto = nombre_producto;
        this.cantidad_disponible = cantidad_disponible;
        this.cantidad_inventario = cantidad_inventario;
        this.empresa_id = empresa_id;
        this.categoria_id = categoria_id;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public Integer getCantidad_inventario() {
        return cantidad_inventario;
    }

    public void setCantidad_inventario(Integer cantidad_inventario) {
        this.cantidad_inventario = cantidad_inventario;
    }

    public Long getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", precio=" + precio +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", cantidad_disponible=" + cantidad_disponible +
                ", cantidad_inventario=" + cantidad_inventario +
                ", empresa_id=" + empresa_id +
                ", categoria_id=" + categoria_id +
                ", foto='" + foto + '\'' +
                '}';
    }
}
