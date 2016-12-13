package com.example.jose.crud_cadastro;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jose.crud_cadastro.dao.UsuarioDAO;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private EditText edLogin;
    private EditText edSenha;
    Button btEntrar;
    private CheckBox ckbConectado;

    private UsuarioDAO helper;

    private static final String MANTER_CONECTADO = "manter_conectado";
    private static final String PREF_NAME        = "LoginActivityPreferences";

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        edLogin = (EditText)findViewById(R.id.edLogin);
        edSenha = (EditText)findViewById(R.id.edSenha);
        ckbConectado = (CheckBox)findViewById(R.id.cbConectado);

        helper= new UsuarioDAO(this);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean conectado = preferences.getBoolean(MANTER_CONECTADO, false);
        if (conectado) {
            chamarMainActivity();
        }
    }

    public void onClickEntar(View view) {
        String login = edLogin.getText().toString();
        String senha = edSenha.getText().toString();
        Boolean validacao = true;

        if (login == null  || login.equals("")) {
            validacao = false;
            edLogin.setError(getString(R.string.login_valLogim));
        }if (senha == null  || senha.equals("")) {
            validacao = false;
            edSenha.setError(getString(R.string.senha_valSenha));
        }if (validacao) {
            if (helper.logar(login, senha)) {

                if (ckbConectado.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(MANTER_CONECTADO, true);
                    editor.commit();
                }
                chamarMainActivity();

            } else {
                Toast.makeText(this, "Login / Senha incorretos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void chamarMainActivity() {
        Intent it =  new Intent(LoginActivity.this, MainActivity.class);
        startActivity(it);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @OnClick({R.id.btEntrar})
//    public void onClick(View view){
////        Explode explode = new Explode();
////        explode.setDuration(500);
////
////        getWindow().setExitTransition(explode);
////        getWindow().setEnterTransition(explode);
////        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
//
//
//        String login = edLogin.getText().toString();
//        String senha = edSenha.getText().toString();
//        Boolean validacao = true;
//
//        if (login == null  || login.equals("")) {
//            validacao = false;
//            edLogin.setError(getString(R.string.login_valLogim));
//        }if (senha == null  || senha.equals("")) {
//            validacao = false;
//            edSenha.setError(getString(R.string.senha_valSenha));
//        }if (validacao) {
//            Intent it =  new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(it);
//        }
//
//    }
}
