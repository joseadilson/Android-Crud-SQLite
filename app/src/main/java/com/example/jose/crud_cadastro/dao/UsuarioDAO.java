package com.example.jose.crud_cadastro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jose.crud_cadastro.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose on 12/12/2016.
 */

public class UsuarioDAO {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    //Context, que vai passar a minha Activity na hora de utilizar essa classe.
    public UsuarioDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    //Preparo o banco de bados pra escrita.
    private SQLiteDatabase getDatabase(){
        if (database == null) {
            database = databaseHelper.getWritableDatabase();
        }

        return database;
    }

    private Usuario criarUsuario(Cursor cursor){
        Usuario model = new Usuario(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Usuarios._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.NOME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.LOGIN)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Usuarios.SENHA))
                );
        return model;
    }


    public List<Usuario> listarUsuarios(){
        Cursor cursor = getDatabase().query(DatabaseHelper.Usuarios.TABELA,
                DatabaseHelper.Usuarios.COLUNAS, null, null, null, null, null);

        List<Usuario> usuarios =  new ArrayList<Usuario>();
        while (cursor.moveToNext()){
            Usuario model = criarUsuario(cursor);
            usuarios.add(model);
        }
        cursor.close();
        return usuarios;
    }

    public long salvarUsuario(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put(DatabaseHelper.Usuarios.NOME, usuario.getNome());
        valores.put(DatabaseHelper.Usuarios.LOGIN, usuario.getLogin());
        valores.put(DatabaseHelper.Usuarios.SENHA, usuario.getSenha());

        if (usuario.get_id() != null) {
            return getDatabase().update(DatabaseHelper.Usuarios.TABELA,
                    valores, "_id = ?", new String[]{usuario.get_id().toString()});
        }

        return  getDatabase().insert(DatabaseHelper.Usuarios.TABELA, null, valores);
    }

    public boolean removerUsuario(int id){
        return getDatabase().delete(DatabaseHelper.Usuarios.TABELA,
                "_id= ?", new String[]{Integer.toString(id)}) > 0;
    }

    public Usuario buscarUsuarioPorID(int id){
        Cursor cursor= getDatabase().query(DatabaseHelper.Usuarios.TABELA, DatabaseHelper.Usuarios.COLUNAS,
                "_id = ?", new String[] {Integer.toString(id)}, null, null, null);

        if (cursor.moveToNext()) {
            Usuario model = criarUsuario(cursor);
            cursor.close();
            return model;
        }

        return null;
    }

    public boolean logar(String login, String senha){
        Cursor cursor  = getDatabase().query(DatabaseHelper.Usuarios.TABELA,
                null, "LOGIN = ? AND SENHA = ?", new String[]{login, senha}, null, null, null, null);

        if (cursor.moveToFirst()) {
            return  true;
        }

        return false;
    }


    //fechar a conexão
    public void fechar(){
        databaseHelper.close();
        database = null;
    }


}
