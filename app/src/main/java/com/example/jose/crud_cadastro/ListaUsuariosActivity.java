package com.example.jose.crud_cadastro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jose.crud_cadastro.adapter.UsuarioAdapter;
import com.example.jose.crud_cadastro.dao.UsuarioDAO;
import com.example.jose.crud_cadastro.model.Usuario;
import com.example.jose.crud_cadastro.util.Mensagem;

import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener {

    private ListView lista;
    private List<Usuario> usuarioList;
    private UsuarioAdapter usuarioAdapter;
    private UsuarioDAO usuarioDAO;

    private int idposicao;
    private AlertDialog alertDialog, alertCondirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        usuarioDAO = new UsuarioDAO(ListaUsuariosActivity.this);
        usuarioList = usuarioDAO.listarUsuarios();
        usuarioAdapter = new UsuarioAdapter(ListaUsuariosActivity.this, usuarioList);

        lista = (ListView) findViewById(R.id.lstUsuarios);
        lista.setAdapter(usuarioAdapter);
        lista.setOnItemClickListener(this);


        alertDialog = Mensagem.criarDialogConfirmacao(this);
        alertCondirmacao = Mensagem.criarDialogConfirmacao(this);
    }

    public void onClickCadastrar(View view) {
        Intent it = new Intent(this, CadUsuarioActivity.class);
        startActivity(it);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idposicao = position;
        alertDialog.show();
    }
}
