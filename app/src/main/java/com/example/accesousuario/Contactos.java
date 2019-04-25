package com.example.accesousuario;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Contactos extends AppCompatActivity {

    private ListView lsvContactos;
    private String [] arrayNumeros;
    private Activity activity;
    private Toolbar toolbar;
    private  String usuarioSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        lsvContactos= findViewById(R.id.lstv_ListaContactos);
        activity=this;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        arrayNumeros=getResources().getStringArray(R.array.numeros);
        ArrayAdapter<String> adaptadorLista = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayNumeros);
        lsvContactos.setAdapter(adaptadorLista);
        lsvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                usuarioSeleccionado= arrayNumeros[position];

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+arrayNumeros[position])));

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mAcerca:

                Intent mensaje= new Intent(this,Mensaje.class);
                mensaje.putExtra("usuario","Mensaje enviado a "+usuarioSeleccionado);

                startActivity(mensaje);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
