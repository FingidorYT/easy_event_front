package com.example.easy_event_app.model;

public class Producto {

    private long id;
    private Integer codigo;
    private Long precio;
    private String nombre_producto;
    private String descripcion;
    private Integer cantidad_disponible;
    private Integer cantidad_inventario;
    private Long empresa_id;
    private Long categoria_id;
    private String foto;

    private long cantidad_recibida;
    private long precio_producto_total;

    public Producto(long id, Integer codigo, Long precio, String nombre_producto, String descripcion, Integer cantidad_disponible, Integer cantidad_inventario, Long empresa_id, Long categoria_id, String foto, long cantidad_recibida, long precio_producto_total) {
        this.id = id;
        this.codigo = codigo;
        this.precio = precio;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.cantidad_disponible = cantidad_disponible;
        this.cantidad_inventario = cantidad_inventario;
        this.empresa_id = empresa_id;
        this.categoria_id = categoria_id;
        this.foto = foto;
        this.cantidad_recibida = cantidad_recibida;
        this.precio_producto_total = precio_producto_total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getCantidad_recibida() {
        return cantidad_recibida;
    }

    public void setCantidad_recibida(long cantidad_recibida) {
        this.cantidad_recibida = cantidad_recibida;
    }

    public long getPrecio_producto_total() {
        return precio_producto_total;
    }

    public void setPrecio_producto_total(long precio_producto_total) {
        this.precio_producto_total = precio_producto_total;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion_producto) {
        this.descripcion = descripcion_producto;
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
                ", descripcion='" + descripcion + '\'' +
                ", cantidad_disponible=" + cantidad_disponible +
                ", cantidad_inventario=" + cantidad_inventario +
                ", empresa_id=" + empresa_id +
                ", categoria_id=" + categoria_id +
                ", foto='" + foto + '\'' +
                ", cantidad_recibida=" + cantidad_recibida +
                ", precio_producto_total=" + precio_producto_total +
                '}';
    }
}
