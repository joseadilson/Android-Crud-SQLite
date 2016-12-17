package com.example.jose.crud_cadastro;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jose.crud_cadastro.adapter.TarefasAdapter;
import com.example.jose.crud_cadastro.dao.TarefaDAO;
import com.example.jose.crud_cadastro.model.Tarefa;
import com.example.jose.crud_cadastro.util.Mensagem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private ListView lista;
    private List<Tarefa> tarefaList;
    private TarefasAdapter tarefasAdapter;
    private TarefaDAO tarefaDAO;

    private int idposicao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tarefaDAO = new TarefaDAO(MainActivity.this);
        tarefaList = tarefaDAO.listarTarefas();
        tarefasAdapter = new TarefasAdapter(MainActivity.this, tarefaList);

        lista = (ListView) findViewById(R.id.lstTarefas);
        lista.setAdapter(tarefasAdapter);
        lista.setOnItemClickListener(this);

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opcoes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itListaUsuario:
                Intent itLista = new Intent(this, ListaUsuariosActivity.class);
                startActivity(itLista);
                break;

            case R.id.itCadUsuario:
                Intent itCadUsua = new Intent(this, CadUsuarioActivity.class);
                startActivity(itCadUsua);
                break;

            case R.id.itSair:
                Mensagem.MsgConfirm(this, "Sair", "Deseja realmente sair ?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                break;

            case R.id.itLogout:
                SharedPreferences preferences = getSharedPreferences("LoginActivityPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear().commit();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickCadastrarTarefa(View view) {

        Intent it = new Intent(this, CadTarefasActivity.class);
        startActivity(it);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
