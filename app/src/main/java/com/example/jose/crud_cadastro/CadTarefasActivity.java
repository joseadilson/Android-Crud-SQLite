package com.example.jose.crud_cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.jose.crud_cadastro.dao.TarefaDAO;
import com.example.jose.crud_cadastro.model.Tarefa;

public class CadTarefasActivity extends AppCompatActivity {

    private EditText edNomeTarefa;
    private TarefaDAO tarefaDAO;
    private Tarefa tarefa;
    private int idtarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_tarefas);

        tarefaDAO = new TarefaDAO(this);

        edNomeTarefa =(EditText)findViewById(R.id.edNomeTarefa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cad_tarefa, menu);

        return true;
    }

    public void onClickSalvar(MenuItem item) {
        Salvar();
    }

    public void Salvar(){
        //SALVAR
    }

    public void chamaMainActivity(){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
