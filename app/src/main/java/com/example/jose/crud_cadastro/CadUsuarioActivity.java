package com.example.jose.crud_cadastro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.jose.crud_cadastro.dao.UsuarioDAO;
import com.example.jose.crud_cadastro.model.Usuario;

public class CadUsuarioActivity extends AppCompatActivity {
    private EditText edNome, edLogin, edSenha;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private int idusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);

        usuarioDAO = new UsuarioDAO(this);

        edNome =(EditText)findViewById(R.id.edNome);
        edLogin =(EditText)findViewById(R.id.edLogin);
        edSenha =(EditText)findViewById(R.id.edSenha);

    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cad_usuario, menu);
        return true;
    }
    public void onClickSalvar(MenuItem item) {


    }
}
