
package com.example.mcspreorderschooluniform_onlineshopping;

import android.annotation.SuppressLint;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processingorder);

        // Initialize UI components
        editOrderId = findViewById(R.id.etStudentId);
        editOrderQuantity = findViewById(R.id.editOrderNumber);
        editOrderStatus = findViewById(R.id.editOrderDate);
        btnProcessOrder = findViewById(R.id.btnSubmitOrder);

        // Button click listener
        btnProcessOrder.setOnClickListener(v -> {
            processOrder();
        });
    }

    private void processOrder() {

        String orderId = editOrderId.getText().toString().trim();
        String quantity = editOrderQuantity.getText().toString().trim();
        String status = editOrderStatus.getText().toString().trim();

        // Check Order ID
        if (orderId.isEmpty()) {
            editOrderId.setError("Order ID is required");
            editOrderId.requestFocus();
            return;
        }

        // Check Quantity
        if (quantity.isEmpty()) {
            editOrderQuantity.setError("Order Quantity is required");
            editOrderQuantity.requestFocus();
            return;
        }

        // Check Status
        if (status.isEmpty()) {
            editOrderStatus.setError("Order Status is required");
            editOrderStatus.requestFocus();
            return;
        }

        // Validate quantity
        int orderQuantity;

        try {
            orderQuantity = Integer.parseInt(quantity);

            if (orderQuantity <= 0) {
                editOrderQuantity.setError("Quantity must be greater than zero");
                editOrderQuantity.requestFocus();
                return;
            }

        } catch (NumberFormatException e) {
            editOrderQuantity.setError("Invalid quantity");
            editOrderQuantity.requestFocus();
            return;
        }

        // Validate status
        if (!status.equalsIgnoreCase("Processing")
                && !status.equalsIgnoreCase("Completed")) {

            editOrderStatus.setError(
                    "Enter Processing or Completed"
            );
            editOrderStatus.requestFocus();
            return;
        }

        // Successful update message
        Toast.makeText(
                activity_processingorder.this,
                "Order Updated Successfully!",
                Toast.LENGTH_LONG
        ).show();

        // Clear fields
        editOrderId.setText("");
        editOrderQuantity.setText("");
        editOrderStatus.setText("");
    }
}
