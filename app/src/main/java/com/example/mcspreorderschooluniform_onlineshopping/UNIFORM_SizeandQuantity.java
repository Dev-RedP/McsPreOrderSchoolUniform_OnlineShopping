
package com.example.mcspreorderschooluniform_onlineshopping;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UNIFORM_SizeandQuantity extends AppCompatActivity {

    private RadioGroup radioGroupSize;
    private TextView txtQuantity;
    private Button btnMinus, btnPlus, btnDone;

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uniform_sizeand_quantity);

        radioGroupSize = findViewById(R.id.radioGroupSize);
        txtQuantity = findViewById(R.id.txtQuantity);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDone = findViewById(R.id.btnDone);

        btnMinus.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                txtQuantity.setText(String.valueOf(quantity));
            }
        });

        btnPlus.setOnClickListener(v -> {
            quantity++;
            txtQuantity.setText(String.valueOf(quantity));
        });

        btnDone.setOnClickListener(v -> {

            int selectedId = radioGroupSize.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(
                        UNIFORM_SizeandQuantity.this,
                        "Please select your size.",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            RadioButton selectedRadioButton =
                    findViewById(selectedId);

            String selectedSize =
                    selectedRadioButton.getText().toString();

            // CONNECT TO PROCESSING ORDER
            Intent intent = new Intent(
                    UNIFORM_SizeandQuantity.this,
                    activity_processingorder.class
            );

            // Send selected size and quantity
            intent.putExtra("SELECTED_SIZE", selectedSize);
            intent.putExtra("SELECTED_QUANTITY", quantity);

            startActivity(intent);

        });
    }
}
