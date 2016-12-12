package com.example.jose.crud_cadastro;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.view.View;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    EditText edLogin;
    EditText edSenha;
    EditText btEntrar;
    CardView cv;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        cv = (CardView)findViewById(R.id.cv);
//        cv.getBackground().setAlpha(200);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.btEntrar})
    public void onClick(View view){
        Explode explode = new Explode();
        explode.setDuration(500);

        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent i2 = new Intent(this,MainActivity.class);
        startActivity(i2, oc2.toBundle());
    }
}
