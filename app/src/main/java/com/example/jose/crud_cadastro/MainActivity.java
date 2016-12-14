package com.example.jose.crud_cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onClickEntar(View view) {
        Intent it = new Intent(MainActivity.this, CadUsuarioActivity.class);
        startActivity(it);
    }

    public void onClickMostrarLista(View view) {
        Intent it = new Intent(MainActivity.this, ListaUsuariosActivity.class);
        startActivity(it);
    }
}
