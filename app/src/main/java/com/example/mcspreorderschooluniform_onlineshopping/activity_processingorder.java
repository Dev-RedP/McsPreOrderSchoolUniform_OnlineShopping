
package com.example.mcspreorderschooluniform_onlineshopping;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_processingorder extends AppCompatActivity {

    private EditText editOrderId;
    private EditText editOrderQuantity;
    private EditText editOrderStatus;
    private Button btnProcessOrder;

    private String selectedSize;
    private int selectedQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processingorder);

        editOrderId = findViewById(R.id.etStudentId);
        editOrderQuantity = findViewById(R.id.editOrderNumber);
        editOrderStatus = findViewById(R.id.editOrderDate);
        btnProcessOrder = findViewById(R.id.btnSubmitOrder);

        // RECEIVE DATA FROM SIZE AND QUANTITY SCREEN
        selectedSize = getIntent().getStringExtra("SELECTED_SIZE");

        selectedQuantity = getIntent().getIntExtra(
                "SELECTED_QUANTITY", 1
        );

        // Automatically display selected quantity
        editOrderQuantity.setText(String.valueOf(selectedQuantity));

        // Display selected uniform size
        if (selectedSize != null) {
            Toast.makeText(
                    this,
                    "Selected Size: " + selectedSize +
                            "\nQuantity: " + selectedQuantity,
                    Toast.LENGTH_LONG
            ).show();
        }

        btnProcessOrder.setOnClickListener(v -> {
            processOrder();
        });
    }

    private void processOrder() {

        String orderId = editOrderId.getText().toString().trim();
        String quantity = editOrderQuantity.getText().toString().trim();
        String status = editOrderStatus.getText().toString().trim();

        if (orderId.isEmpty()) {
            editOrderId.setError("Order ID is required");
            editOrderId.requestFocus();
            return;
        }

        if (quantity.isEmpty()) {
            editOrderQuantity.setError("Order Quantity is required");
            editOrderQuantity.requestFocus();
            return;
        }

        if (status.isEmpty()) {
            editOrderStatus.setError("Order Status is required");
            editOrderStatus.requestFocus();
            return;
        }

        int orderQuantity;

        try {
            orderQuantity = Integer.parseInt(quantity);

            if (orderQuantity <= 0) {
                editOrderQuantity.setError(
                        "Quantity must be greater than zero"
                );
                editOrderQuantity.requestFocus();
                return;
            }

        } catch (NumberFormatException e) {
            editOrderQuantity.setError("Invalid quantity");
            editOrderQuantity.requestFocus();
            return;
        }

        if (!status.equalsIgnoreCase("Processing")
                && !status.equalsIgnoreCase("Completed")) {

            editOrderStatus.setError(
                    "Enter Processing or Completed"
            );
            editOrderStatus.requestFocus();
            return;
        }

        Toast.makeText(
                activity_processingorder.this,
                "Order Updated Successfully!" +
                        "\nSize: " + selectedSize +
                        "\nQuantity: " + orderQuantity,
                Toast.LENGTH_LONG
        ).show();

        editOrderId.setText("");
        editOrderQuantity.setText("");
        editOrderStatus.setText("");
    }
}
