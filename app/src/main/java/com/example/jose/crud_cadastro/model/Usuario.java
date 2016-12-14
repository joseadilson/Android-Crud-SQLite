package com.example.jose.crud_cadastro.model;

/**
 * Created by Jose on 12/12/2016.
 */

public class Usuario {

    private Integer _id;
    private String nome;
    private String login;
    private String senha;

    public Usuario(int id, String nome, String login, String senha){
        this._id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
