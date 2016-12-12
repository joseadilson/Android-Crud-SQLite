package com.example.jose.crud_cadastro.model;

/**
 * Created by Jose on 12/12/2016.
 */

public class Tarefa {
    private Integer _id;
    private String tarefa;
    private String dt_criacao;


    public  Tarefa(Integer id, String tarefa, String dt_criacao){
        this._id = id;
        this.tarefa = tarefa;
        this.dt_criacao = dt_criacao;
    }




    public Integer get_id() {
        return _id;
    }
    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTarefa() {
        return tarefa;
    }
    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }
    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }
}
