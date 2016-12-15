package com.example.jose.crud_cadastro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jose.crud_cadastro.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose on 12/12/2016.
 */

public class TarefaDAO {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public TarefaDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    //Preparo o banco de bados pra escrita.
    private SQLiteDatabase getDatabase(){
        if (database == null) {
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    private Tarefa criarTarefa(Cursor cursor){
        Tarefa model = new Tarefa(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Tarefas._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Tarefas.TAREFA)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Tarefas.DT_CRIACAO))
        );
        return model;
    }

    public List<Tarefa> listarTarefas(){
        Cursor cursor = getDatabase().query(DatabaseHelper.Tarefas.TABELA,
                DatabaseHelper.Tarefas.COLUNAS, null, null, null, null, null);

        List<Tarefa> tarefas =  new ArrayList<Tarefa>();
        while (cursor.moveToNext()){
            Tarefa model = criarTarefa(cursor);
            tarefas.add(model);
        }
        cursor.close();
        return tarefas;
    }

    public long salvarTarefa(Tarefa tarefa){
        ContentValues valores = new ContentValues();
        valores.put(DatabaseHelper.Tarefas.TAREFA, tarefa.getTarefa());

        if (tarefa.get_id().toString() != null) {
            return getDatabase().update(DatabaseHelper.Tarefas.TABELA,
                    valores, "_id = ?", new String[]{tarefa.get_id().toString()});
        }

        return  getDatabase().insert(DatabaseHelper.Tarefas.TABELA, null, valores);
    }

    public boolean removerTarefa(int id){
        return getDatabase().delete(DatabaseHelper.Tarefas.TABELA,
                "_id= ?", new String[]{Integer.toString(id)}) > 0;
    }

    public Tarefa buscarTarefaPorID(int id){
        Cursor cursor= getDatabase().query(DatabaseHelper.Tarefas.TABELA, DatabaseHelper.Tarefas.COLUNAS,
                "_id = ?", new String[] {Integer.toString(id)}, null, null, null, null);

        if (cursor.moveToNext()) {
            Tarefa model = criarTarefa(cursor);
            cursor.close();;
            return model;
        }

        return null;
    }


    //fechar a conexão
    public void fechar(){
        databaseHelper.close();
        database = null;
    }

}
