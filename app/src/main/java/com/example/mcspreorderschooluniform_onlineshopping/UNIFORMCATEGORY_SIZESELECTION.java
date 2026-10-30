package com.example.mcspreorderschooluniform_onlineshopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UNIFORMCATEGORY_SIZESELECTION extends AppCompatActivity {

    ImageView imageView2, imageView3, imageView4, imageView5, imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_uniformcategory_sizeselection);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left, insets.getInsets(WindowInsetsCompat.Type.systemBars()).top, insets.getInsets(WindowInsetsCompat.Type.systemBars()).right, insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        // Only uniforms - no buttons
        imageView2 = findViewById(R.id.imageView2); // Male Longsleeve
        imageView3 = findViewById(R.id.imageView3); // Female Vest
        imageView4 = findViewById(R.id.imageView4); // Male Necktie
        imageView5 = findViewById(R.id.imageView5); // Female Blouse
        imageView6 = findViewById(R.id.imageView6); // Female Skirt

        // Each one bouncy and independent - dont connect each otherA
        imageView2.setOnClickListener(v -> bounceAndGo(v, "Male Longsleeve"));
        imageView3.setOnClickListener(v -> bounceAndGo(v, "Female Vest"));
        imageView4.setOnClickListener(v -> bounceAndGo(v, "Male Necktie"));
        imageView5.setOnClickListener(v -> bounceAndGo(v, "Female Blouse"));
        imageView6.setOnClickListener(v -> bounceAndGo(v, "Female Skirt"));
    }

    private void bounceAndGo(View view, String uniformName) {
        view.animate()
                .scaleX(0.8f).scaleY(0.8f).setDuration(150)
                .withEndAction(() -> {
                    view.animate().scaleX(1f).scaleY(1f).setDuration(350)
                            .setInterpolator(new OvershootInterpolator(3f)).start();
                }).start();

        new Handler().postDelayed(() -> {
            Toast.makeText(this, uniformName + " - Medium Selected!", Toast.LENGTH_SHORT).show();
            // Intent is disabled until you create the next page
            // Intent intent = new Intent(UNIFORMCATEGORY_SIZESELECTION.this, SizeSelectionActivity.class);
            // intent.putExtra("UNIFORM_NAME", uniformName);
            // startActivity(intent);
        }, 500);
    } }