package com.example.mcspreorderschooluniform_onlineshopping;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UNIFORMCATEGORY_SIZESELECTION extends AppCompatActivity {

    ImageView imageView2, imageView3, imageView4,
            imageView5, imageView6, imageView7, imageView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uniformcategory_sizeselection);

        // Connect ImageViews
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView10 = findViewById(R.id.imageView10);

        // System screen insets
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });

        // MALE LONG SLEEVE
        imageView2.setOnClickListener(v ->
                openSizeSelection("Male Long Sleeve"));

        // FEMALE VEST
        imageView3.setOnClickListener(v ->
                openSizeSelection("Female Vest"));

        // MALE NECKTIE
        imageView4.setOnClickListener(v ->
                openSizeSelection("Male Necktie"));

        // FEMALE BLOUSE
        imageView5.setOnClickListener(v ->
                openSizeSelection("Female Blouse"));

        // FEMALE SKIRT
        imageView6.setOnClickListener(v ->
                openSizeSelection("Female Skirt"));
    }

    // CONNECT TO SIZE AND QUANTITY ACTIVITY
    private void openSizeSelection(String uniformName) {

        Intent intent = new Intent(
                UNIFORMCATEGORY_SIZESELECTION.this,
                UNIFORM_SizeandQuantity.class
        );

        intent.putExtra("UNIFORM_NAME", uniformName);

        startActivity(intent);
    }
}
