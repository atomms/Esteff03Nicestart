package com.example.nicestart;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Establecer el layout

        // Encontrar el ImageView
        ImageView mGirl = findViewById(R.id.girl);

            // Cargar la imagen desde Internet con transición y crop circular
            Glide.with(this)
                    .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
                    .transition(DrawableTransitionOptions.withCrossFade(2000))
                    .circleCrop()
                    .into(mGirl);


        // Habilitar el diseño edge-to-edge con WindowCompat
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // Ajustar el padding para las barras del sistema (barra de estado y barra de navegación)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}