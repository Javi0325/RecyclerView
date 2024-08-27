package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Estudiante>ListaEstudiante=new ArrayList<>();
    EditText nombre,apellido;
    RadioButton hombre,mujer;
    Spinner carreras;
    Button registrar;
    String sexo;
    RecyclerView lista;
    EstudianteAdapter estudianteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        hombre=findViewById(R.id.rbHombre);
        mujer=findViewById(R.id.rbMujer);
        carreras=findViewById(R.id.spCarrera);
        registrar=findViewById(R.id.btnRegistrar);
        lista=findViewById(R.id.rvLista);

        estudianteAdapter = new EstudianteAdapter(ListaEstudiante);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(estudianteAdapter);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hombre.isChecked())
                {
                    sexo=hombre.getText().toString();
                }
                else
                {
                    sexo=mujer.getText().toString();
                }
                Estudiante est=new Estudiante(nombre.getText().toString(),apellido.getText().toString(),carreras.getSelectedItem().toString(),sexo);
                ListaEstudiante.add(est);
                estudianteAdapter.notifyItemInserted(ListaEstudiante.size()-1);
                nombre.setText("");
                apellido.setText("");
                hombre.setChecked(false);
                mujer.setChecked(false);
                carreras.setSelection(0);
            }
        });
    }
}