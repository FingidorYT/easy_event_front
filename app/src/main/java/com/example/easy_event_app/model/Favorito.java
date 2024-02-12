package com.example.easy_event_app.model;

public class Favorito {

    private long id;
    private Long producto_id;
    private Long user_id;

    public Favorito(long id, Long producto_id, Long user_id) {
        this.id = id;
        this.producto_id = producto_id;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "id=" + id +
                ", producto_id=" + producto_id +
                ", user_id=" + user_id +
                '}';
    }
}
