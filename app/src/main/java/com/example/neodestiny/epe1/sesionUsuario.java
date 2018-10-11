package com.example.neodestiny.epe1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sesionUsuario extends AppCompatActivity {

    private TextView contenido;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_usuario);
        contenido = findViewById(R.id.tv_contenido);
        recibirDatos();
    }

    public void recibirDatos()
    {
        Bundle extras = getIntent().getExtras();
        String correo = extras.getString("validaEmail");
        sp= getSharedPreferences(correo, Context.MODE_PRIVATE);
        
        String v_nombre = sp.getString("Nombre", "Error, no encontrado");
        String v_apellido = sp.getString("Apellido", "Error no encontrado");
        String v_correo = sp.getString("Correo", "Error no encontrado");
        String v_edad = sp.getString("Edad","Error no encontrado");
        String v_contraseña = sp.getString("Contraseña", "Error no encontrado");
        String v_sexo=sp.getString("Sexo","Error no encontrado");
        String v_est_civil=sp.getString("Estado civil", "Error no encontrado");
        String v_hobbies=sp.getString("Hobbies", "Error no encontrado");

        String valores = "Nombre: "+v_nombre+"\n Apellido: "+v_apellido+"\n Correo: "+v_correo+"\n Edad: "+v_edad+"\n Contraseña: "+v_contraseña+
                "\n Sexo: "+v_sexo+"\n Estado Civil: "+v_est_civil+"\n Hobbies: "+v_hobbies;
        contenido.setText(valores);
    }
}
