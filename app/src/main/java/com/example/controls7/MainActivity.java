package com.example.controls7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    private Button btnRegistrar;
    private EditText inputCodigo, inputNombre;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        inputCodigo = (EditText) findViewById(R.id.inputCodigo);
        inputNombre = (EditText) findViewById(R.id.inputNombre);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnRegistrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new Task().execute(inputCodigo.getText().toString(), inputNombre.getText().toString());
            }
        });

    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            btnRegistrar.setEnabled(false);
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            btnRegistrar.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
            intent.putExtra("inputCodigo", inputCodigo.getText().toString());
            intent.putExtra("inputNombre", inputNombre.getText().toString());
            startActivity(intent);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }
    }


}