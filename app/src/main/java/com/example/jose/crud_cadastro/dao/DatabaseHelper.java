package com.example.jose.crud_cadastro.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jose on 12/12/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "tarefas2";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context, BANCO_DADOS, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TABELA DE USUARIO
        db.execSQL("create table usuarios (_id integer primary key autoincrement, "
        +"nome text not null, login text not null, senha text not null)");

        //TABELA DE TAREFAS
        db.execSQL("CREATE TABLE TAREFAS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TAREFA TEXT NOT NULL, " +
                "DT_CRIACAO DATETIME DEFAULT CURRENT_TIMESTAMP "+
                ")");

        db.execSQL("INSERT INTO USUARIOS(NOME, LOGIN, SENHA) VALUES('admin', 'admin', '123')");
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static class Usuarios{
        public static final String TABELA = "usuarios";
        public static final String _ID    = "_id";
        public static final String NOME   = "nome";
        public static final String LOGIN  = "login";
        public static final String SENHA  = "senha";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, LOGIN, SENHA
        };
    }

    public static class Tarefas{
        public static final String TABELA = "tarefas";
        public static final String _ID = "_id";
        public static final String TAREFA = "tarefa";
        public static final String DT_CRIACAO = "dt_criacao";

        public static final String[] COLUNAS = new String[]{
            _ID, TAREFA, DT_CRIACAO
        };
    }
}
