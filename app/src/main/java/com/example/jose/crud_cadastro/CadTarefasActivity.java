package com.example.jose.crud_cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

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
        boolean validacao = true;

        String nomeTarefa = edNomeTarefa.getText().toString();

        if (nomeTarefa == null || nomeTarefa.equals("")) {
            validacao = false;
            Toast.makeText(this, "Preencha o campo TAREFA para salvar!", Toast.LENGTH_SHORT).show();
        } if (validacao) {
            tarefa = new Tarefa();
            tarefa.setTarefa(nomeTarefa);

            //Para att a tarefa
            if (idtarefa > 0) {
                tarefa.set_id(idtarefa);
            }


            long resultado = tarefaDAO.salvarTarefa(tarefa);

            if (resultado != 1) {
                if (resultado > 0) {
                    Toast.makeText(this, "Tarefa atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Tarefa cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                Toast.makeText(this, "Erro ao registrar|", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }



    public void chamaMainActivity(){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
