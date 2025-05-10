package com.example.pomodoraapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

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
        // XML'deki gifView ImageView'ine ulaşıp Glide ile gif gösteriyoruz
        ImageView gifView = findViewById(R.id.gifView); // ID ile erişim
        Glide.with(this)                                // Glide kütüphanesini başlat
                .asGif()                                   // GIF olarak işlem yap
                .load(R.drawable.intro_gif)                // drawable klasöründeki intro_gif.gif dosyası
                .into(gifView);
    }
}