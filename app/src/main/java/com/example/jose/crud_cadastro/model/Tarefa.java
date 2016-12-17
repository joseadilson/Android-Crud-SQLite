package com.example.jose.crud_cadastro.model;

/**
 * Created by Jose on 12/12/2016.
 */

public class Tarefa {
    private Integer _id;
    private String tarefa;

    public  Tarefa(Integer id, String tarefa){
        this._id = id;
        this.tarefa = tarefa;
    }

    public Tarefa(){

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

}
