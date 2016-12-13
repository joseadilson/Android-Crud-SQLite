package com.example.jose.crud_cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

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

        if (idusuario > 0) {
            menu .findItem(R.menu.menu_cad_usuario).setVisible(true);
        }

        return true;
    }

    public void onClickSalvar(MenuItem item) {
        cadastrar();
    }

    private void cadastrar(){
        boolean validacao =  true;

        String nome = edNome.getText().toString();
        String login = edLogin.getText().toString();
        String senha = edSenha.getText().toString();

        if (nome == null || nome.equals("")){
            validacao = false;
            Toast.makeText(this, "Campo NOME é obrigatorio", Toast.LENGTH_SHORT).show();
        } if (login == null  || login.equals("")) {
            validacao = false;
            Toast.makeText(this, "Campo LOGIN é obrigatorio", Toast.LENGTH_SHORT).show();
        } if (senha == null || senha.equals("")) {
            validacao = false;
            Toast.makeText(this, "Campo SENHA é obrigatorio", Toast.LENGTH_SHORT).show();
        } if (validacao) {
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);

            //Atualizar
            if (idusuario > 0 ) {
                usuario.set_id(idusuario);
            }

            long resultado = usuarioDAO.salvarUsuario(usuario);

            if (resultado != -1){
                if (resultado > 0) {
                    Toast.makeText(this, "Registro Atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                    chamaMainActivity();
                } else{
                    Toast.makeText(this, "Registro Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                    chamaMainActivity();
                }
            } else {
                Toast.makeText(this, "Erro ao registrar|", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickExcluir(MenuItem item) {
        Excluir();
    }

    public void Excluir(){

    }



    public void chamaMainActivity(){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    @Override
    protected void onDestroy() {
        usuarioDAO.fechar();
        super.onDestroy();
    }


}
