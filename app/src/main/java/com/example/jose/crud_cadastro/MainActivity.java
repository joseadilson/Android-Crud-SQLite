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

import com.example.jose.crud_cadastro.util.Mensagem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
