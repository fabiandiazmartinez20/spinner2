package com.example.spinner2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class inicioActivity extends AppCompatActivity {

    private Spinner nombrespinner;
    private ImageView lblmostrar;
    private Map<String, String> imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        inicializarComponentes();
        configurarSpinner();
    }

    private void inicializarComponentes() {
        nombrespinner = findViewById(R.id.nombrespinner);
        lblmostrar = findViewById(R.id.lblmostrar);

        // Inicializar el mapa de imágenes
        imagenes = new HashMap<>();
        cargarImagenes();
    }

    private void cargarImagenes() {
        imagenes.put("fabian", "https://drive.google.com/uc?id=1Wx6FU8RKlDQNz1OY8RpYfP5O19-PYWza");
        imagenes.put("misael", "https://drive.google.com/uc?id=1KFxwd21gvBFodny6Q5zM_vEab0JIfzxG");
        imagenes.put("juan", "https://drive.google.com/uc?id=1e4f2JrcRa4Hk6g0Yn9nJkn3dSSK77Gnb");
        imagenes.put("moises","https://drive.google.com/uc?id=1SD6MsF5K1rfghl7g0CIfAsAs01a9OExR");
        imagenes.put("brayan","https://drive.google.com/uc?id=1RDf4ryEkzJi3lewT-SNVTV_tYl-fE5OP");
        imagenes.put("carlos","https://drive.google.com/uc?id=19IDVCF282Stu9ETpMHzy6byZVoXWHPfZ");
        imagenes.put("adair", "https://drive.google.com/uc?id=1EMzViEG6Sc5tP_Qp3HQqIOBnZWVUoHVS");
        imagenes.put("emiliano","https://drive.google.com/uc?id=1t-LyHgmYcQiectBUycCNPNc-7iiKKw_H");
        imagenes.put("aaron","https://drive.google.com/uc?id=1fDY74jdw2q_nJ_PpmzO61ZxIHeXpX0yv");
        imagenes.put("aldair","https://drive.google.com/uc?id=1cC285QGGG7lVFuRH32aI3xEtayUFQvrl");
        imagenes.put("alfredo","https://drive.google.com/uc?id=1JqSX5G2_YFXqefG2jnD-h5sFSykxGLon");
        imagenes.put("anahi","https://drive.google.com/uc?id=1p8g1NXQdRanzGsIU9llE2tiladLhZ1B5");
        imagenes.put("angel","https://drive.google.com/uc?id=12EbSOvcCYGIDIDQ-5Ra9g29PhCjs0_Df");
        imagenes.put("cesar","https://drive.google.com/uc?id=1BvpcWOGvQB9TxbiM2bokFbSpgHWlxRki");
        imagenes.put("victor","https://drive.google.com/uc?id=1MWlzsWAK1ntvjA-oWX09zhKE3c9o06hk");
        imagenes.put("lesli","https://drive.google.com/uc?id=13AtCZ6cRN5FhuT_XuyAw98LfkXJ9XwfN");
        imagenes.put("mariana","https://drive.google.com/uc?id=1smcm8_CRB-VBUqBSnVh64QHzxj0Vsa-6");
        imagenes.put("mauricio","https://drive.google.com/uc?id=1riOiCECN6TpID1EU7tMCXHzYV8DD4-xR");
        imagenes.put("rafael","https://drive.google.com/uc?id=13mzG2HNKKzMaGlKLfU6q2JDMEQmvAm9S");
        imagenes.put("wendy", "https://drive.google.com/uc?id=1i6-uObnR9m3Cs_HbEJ2DlpnzwfxhLXt4");


    }

    private void configurarSpinner() {
        List<String> nombres = imagenes.keySet().stream().collect(Collectors.toList());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, nombres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nombrespinner.setAdapter(adapter);

        nombrespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombreSeleccionado = (String) parent.getItemAtPosition(position);
                String urlImagen = imagenes.get(nombreSeleccionado);
                mostrarImagen(urlImagen);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblmostrar.setImageDrawable(null); // Limpiar imagen
            }
        });
    }

    private void mostrarImagen(String url) {
        if (url != null) {
            Glide.with(this).load(url).into(lblmostrar);
        } else {
            Toast.makeText(this, "Imagen no encontrada", Toast.LENGTH_SHORT).show();
        }
    }
}