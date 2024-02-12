package com.example.easy_event_app.model;

public class RespuestaLogin {

    private User user;
    private Empresa empresa;
    private Favorito favorito;
    private String access_token;
    private String token_type;

    public RespuestaLogin() {
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Favorito getFavorito() {
        return favorito;
    }

    public void setFavorito(Favorito favorito) {
        this.favorito = favorito;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

}
