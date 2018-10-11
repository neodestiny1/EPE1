package com.example.neodestiny.epe1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class inicioSesion extends AppCompatActivity {

    SharedPreferences sp;
    private EditText correo, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        correo = findViewById(R.id.et_usuario);
        pass = findViewById(R.id.et_clave);
    }

    public void iniciarSesion (View view)
    {
        String email = correo.getText().toString();
        String archivo = email+".xml";
        File f = new File("/data/data/com.example.neodestiny.epe1/shared_prefs/"+archivo);
        if (f.exists()){

            sp = getSharedPreferences(email, Context.MODE_PRIVATE);//Sobreescribe el archivo cada vez que se necesita
            String clave = pass.getText().toString();
            String compClave = sp.getString("Contraseña", "Error no encontrado");

            //Toast.makeText(getApplicationContext(),"Clave: "+clave+"\n clave sistema: "+compClave, Toast.LENGTH_LONG).show();
            if(clave.equals(compClave)) {
                Intent i = new Intent (inicioSesion.this, sesionUsuario.class);
                i.putExtra("validaEmail",email);
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Error: Contraseña inválida", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Dirección de correo electrónico no existe", Toast.LENGTH_SHORT).show();
        }
    }

    public void paginaNuevoUsuario(View view)
    {
        startActivity(new Intent(inicioSesion.this, MainActivity.class));
    }
}
