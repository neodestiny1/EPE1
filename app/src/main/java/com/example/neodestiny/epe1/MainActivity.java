package com.example.neodestiny.epe1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido, edad, correo, pass, rpass;
    private RadioButton soltero, casado, hombre, mujer;
    private CheckBox leer, jugar, musica, deportes;
    private ImageView imgview;


    SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.et_nombre);
        apellido = findViewById(R.id.et_apellido);
        edad = findViewById(R.id.et_edad);
        correo = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        rpass= findViewById(R.id.et_repPass);
        soltero = findViewById(R.id.rb_soltero);
        casado = findViewById(R.id.rb_casado);
        hombre = findViewById(R.id.rb_hombre);
        mujer = findViewById(R.id.rb_mujer);
        leer = findViewById(R.id.cb_leer);
        jugar = findViewById(R.id.cb_videojuegos);
        musica = findViewById(R.id.cb_musica);
        deportes = findViewById(R.id.cb_deportes);
        imgview=findViewById(R.id.iv_1);

    }

    public void tomaFoto(View view)
    {

    }

    public void nuevoXml(View view)
    {
        String nom = nombre.getText().toString();
        String clave = pass.getText().toString();
        String rclave = rpass.getText().toString();
        String est_civil = "";
        String sexo = "";
        String hobbies="";

        if(clave.equals(rclave))
        {
            String mail = correo.getText().toString();
            preferencias = getSharedPreferences(mail, Context.MODE_PRIVATE);
            SharedPreferences.Editor edicion = preferencias.edit();

            if(casado.isChecked())
                est_civil = "Casado";
            else
                est_civil = "Soltero";
            if(hombre.isChecked())
                sexo = "Hombre";
            else
                sexo = "Mujer";

            //checkbox

            if(leer.isChecked())
            {
                hobbies = hobbies +"leer"+ ", ";
            }

            if (jugar.isChecked())
            {
                hobbies = hobbies +"jugar"+ ", ";
            }
            if(deportes.isChecked())
            {
                hobbies = hobbies +"deportes"+ ", ";
            }
            if(musica.isChecked())
            {
                hobbies = hobbies +"musica"+ ", ";
            }

            String apell = apellido.getText().toString();
            String años = edad.getText().toString();
            edicion.putString("Nombre", nom);
            edicion.putString("Apellido", apell);
            edicion.putString("Edad", años);
            edicion.putString("Correo", mail);
            edicion.putString("Contraseña", clave);
            edicion.putString("Sexo", sexo);
            edicion.putString("Estado civil", est_civil);
            edicion.putString("Hobbies", hobbies);

            edicion.commit();

            Toast.makeText(getApplicationContext(),"Datos guardados con éxito", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, inicioSesion.class));
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Las claves ingresadas no son iguales", Toast.LENGTH_SHORT).show();
        }


    }
}
