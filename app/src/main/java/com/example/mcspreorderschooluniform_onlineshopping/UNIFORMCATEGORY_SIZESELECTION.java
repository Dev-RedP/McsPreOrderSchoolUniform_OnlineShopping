
package com.example.mcspreorderschooluniform_onlineshopping;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
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

        // Connect ImageViews from XML
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView10 = findViewById(R.id.imageView10);

        // Handle system screen insets
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

        // Male Long Sleeve
        imageView2.setOnClickListener(v ->
                showSelection("Male Long Sleeve"));

        // Female Vest
        imageView3.setOnClickListener(v ->
                showSelection("Female Vest"));

        // Male Necktie
        imageView4.setOnClickListener(v ->
                showSelection("Male Necktie"));

        // Female Blouse
        imageView5.setOnClickListener(v ->
                showSelection("Female Blouse"));

        // Female Skirt
        imageView6.setOnClickListener(v ->
                showSelection("Female Skirt"));
    }

    private void showSelection(String uniformName) {

        Toast.makeText(
                this,
                "Selected: " + uniformName,
                Toast.LENGTH_SHORT
        ).show();

    }
}
