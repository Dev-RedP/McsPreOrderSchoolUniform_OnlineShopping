package com.example.mcspreorderschooluniform_onlineshopping;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Customerorderinfo extends AppCompatActivity {

    EditText editOrderDate, editPlace, editCustomerName, editOrderNumber;
    Button btnSubmitOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerorderinfo);

        // Connect XML components
        editOrderDate = findViewById(R.id.editOrderDate);
        editPlace = findViewById(R.id.editPlace);
        editCustomerName = findViewById(R.id.editCustomerName);
        editOrderNumber = findViewById(R.id.editOrderNumber);
        btnSubmitOrder = findViewById(R.id.btnSubmitOrder);

        // Submit Order Button
        btnSubmitOrder.setOnClickListener(v -> {

            String orderDate = editOrderDate.getText().toString().trim();
            String place = editPlace.getText().toString().trim();
            String customerName = editCustomerName.getText().toString().trim();
            String orderNumber = editOrderNumber.getText().toString().trim();

            // Check empty fields
            if (orderDate.isEmpty()) {
                editOrderDate.setError("Please enter order date");
                editOrderDate.requestFocus();
                return;
            }

            if (place.isEmpty()) {
                editPlace.setError("Please enter place");
                editPlace.requestFocus();
                return;
            }

            if (customerName.isEmpty()) {
                editCustomerName.setError("Please enter customer name");
                editCustomerName.requestFocus();
                return;
            }

            if (orderNumber.isEmpty()) {
                editOrderNumber.setError("Please enter order number");
                editOrderNumber.requestFocus();
                return;
            }

            // Display order information
            String message = "ORDER SUBMITTED SUCCESSFULLY!\n\n"
                    + "Order Date: " + orderDate + "\n"
                    + "Place: " + place + "\n"
                    + "Customer Name: " + customerName + "\n"
                    + "Order Number: " + orderNumber;

            Toast.makeText(
                    Customerorderinfo.this,
                    "Order submitted successfully!",
                    Toast.LENGTH_LONG
            ).show();

            new android.app.AlertDialog.Builder(Customerorderinfo.this)
                    .setTitle("Customer Order Information")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}