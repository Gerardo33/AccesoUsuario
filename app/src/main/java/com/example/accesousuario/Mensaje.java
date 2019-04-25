package com.example.accesousuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Mensaje extends AppCompatActivity {


    private TextView txtvMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        txtvMensaje=findViewById(R.id.txtvMensaje);
        Bundle extras = getIntent().getExtras();
        String Mensaje = extras.getString("usuario");
        txtvMensaje.setText(Mensaje);

        Log.d("Usuario",Mensaje);


    }
}
