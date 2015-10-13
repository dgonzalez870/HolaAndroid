package com.prueba.holaAndroid;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends Activity {
    private TextView tvSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_saludo);
        tvSaludo= (TextView) findViewById(R.id.textView2);
        tvSaludo.append("\n"+ getIntent().getStringExtra("mensaje"));
    }
}
