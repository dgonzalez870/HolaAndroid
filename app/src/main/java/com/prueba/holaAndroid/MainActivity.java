package com.prueba.holaAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

    private EditText etMensaje;
    private TextView tvResultado;
    //Identificador para el código de solicitud
    public static final int INICIAR_POR_RESULTADO=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        etMensaje=(EditText)findViewById(R.id.et_mensaje);
        tvResultado= (TextView) findViewById(R.id.tv_resultado);
    }

    public void saludar(View v){
        Toast toast=Toast.makeText(this, R.string.string_saludo, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void iniciarSaludo(View v){
        Intent intent=new Intent(this,SaludoActivity.class);
        intent.putExtra("mensaje",etMensaje.getText().toString());
        startActivity(intent);
    }

    public void iniciarPorResultado(View v){
        //Crea un Intent para iniciar ResultadoActivity
        Intent intent =new Intent(this,ResultadoActivity.class);
        //Carga el contenido del EditText en el Intent
        intent.putExtra("mensaje",etMensaje.getText().toString());
        //Inicia un activity por resultado con un código de solicitud
        //el código de solicitud (requestCode) sirve para identificar desde qué Activity se ha
        //generado el resultado recibido en el método onActivityResult
        startActivityForResult(intent,INICIAR_POR_RESULTADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_CANCELED){
            Toast.makeText(this,"Cancelado",Toast.LENGTH_LONG).show();
            return;
        }
        if(requestCode==INICIAR_POR_RESULTADO){
            //recupera el dato del resultado y lo carga en el TextView
            tvResultado.setText(data.getStringExtra("resultado"));
            //Hace el TextView visible
            tvResultado.setVisibility(View.VISIBLE);
        }
    }

    public void iniciarVistaPersonal(View v){
        startActivity(new Intent(this,PersonalActivity.class));
    }

}
