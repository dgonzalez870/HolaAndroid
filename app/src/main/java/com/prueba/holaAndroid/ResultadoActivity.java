package com.prueba.holaAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultadoActivity extends Activity {

    private EditText etResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.layout_resultado);
        etResultado= (EditText) findViewById(R.id.et_resultado);
        //recupera el dato String con clave "mensaje" y lo presenta en el EditText
        etResultado.setText(getIntent().getStringExtra("mensaje"));
        //Cambia el resultado por defecto a "Cancelado"
        setResult(RESULT_CANCELED);
    }

    //Genera el resultado satisfactorio al hacer click sobre el botón
    public void generarResultado(View v){
        //Genera un Intent vacío
        Intent intent=new Intent();
        //Guarda el dato del resultado en el Intent con un identificador
        intent.putExtra("resultado",etResultado.getText().toString());
        //cambiar el código de resultado a satisfactorio
        setResult(RESULT_OK,intent);
        //finaliza este Activity
        finish();
    }
}
