package com.example.controls7;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends Activity {

    private TextView Mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Mensaje = (TextView) findViewById(R.id.mensaje);
        String nombre = getIntent().getStringExtra("inputNombre");
        String codigo = getIntent().getStringExtra("inputCodigo");

        Mensaje.setText("- Se ha registrado el producto: "+nombre +" \n\r - Con el código : "+codigo);


    }
}