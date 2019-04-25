package com.example.accesousuario;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Usuario usuario;
    EditText nombreUsuario;
    EditText password;
    Button btnIngresar;
    String stringUsuario="Gerardo";
    String stringPassword="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreUsuario=findViewById(R.id.edtUsuario);
        password=findViewById(R.id.edtPassword);
        btnIngresar=findViewById(R.id.button);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nombreUsuario.getText().length()!=0 && password.getText().toString().length()!=0)
                {

                    if(nombreUsuario.getText().toString().equals(stringUsuario)&& password.getText().toString().equals(stringPassword))
                    {

                        usuario= new Usuario(nombreUsuario.getText().toString(),password.getText().toString());
                        Intent datosUsuario = new Intent(MainActivity.this,Contactos.class);

                        datosUsuario.putExtra("usuario",usuario.getNombreUsuario());
                        datosUsuario.putExtra("password",usuario.getPassword());
                        Toast.makeText(getApplicationContext(),"Bienvenido "+usuario.getNombreUsuario(),Toast.LENGTH_LONG).show();

                        startActivity(datosUsuario);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_LONG).show();
                        nombreUsuario.setText("");
                        password.setText("");
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Por favor llena los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }




}
