package com.prueba.holaAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    public void saludar(View v){
        Toast toast=Toast.makeText(this, R.string.string_saludo, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void iniciarSaludo(View v){
        Intent intent=new Intent(this,SaludoActivity.class);
        startActivity(intent);
    }
 }
