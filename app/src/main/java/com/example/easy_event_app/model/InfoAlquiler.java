package com.example.easy_event_app.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class InfoAlquiler {

    private String nombre;
    private String apellido;
    private BigInteger telefono;
    private String lugar_entrega;
    private String foto;
    private String metodo_pago;
    private String fecha_alquiler;
    private BigInteger precio_total;
    private List<Producto> productos;

    public List<Producto> getProducto_alquiler() {
        return productos;
    }

    public void setProducto_alquiler(List<Producto> producto) {
        productos = producto;
    }

    public InfoAlquiler(String nombre, String apellido, BigInteger telefono, String lugar_entrega, String foto, String metodo_pago, String fecha_alquiler, BigInteger precio_total) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.lugar_entrega = lugar_entrega;
        this.foto = foto;
        this.metodo_pago = metodo_pago;
        this.fecha_alquiler = fecha_alquiler;
        this.precio_total = precio_total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getLugar_entrega() {
        return lugar_entrega;
    }

    public void setLugar_entrega(String lugar_entrega) {
        this.lugar_entrega = lugar_entrega;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public BigInteger getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(BigInteger precio_total) {
        this.precio_total = precio_total;
    }

    @Override
    public String toString() {
        return "InfoAlquiler{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", lugar_entrega='" + lugar_entrega + '\'' +
                ", foto='" + foto + '\'' +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", fecha_alquiler=" + fecha_alquiler +
                ", precio_total=" + precio_total +
                '}';
    }
}
