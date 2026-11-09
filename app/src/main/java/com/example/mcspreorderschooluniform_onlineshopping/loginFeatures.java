package com.example.mcspreorderschooluniform_onlineshopping;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class loginFeatures extends AppCompatActivity {

    EditText editStudentId, editPassword;
    Button btnLogin;
    TextView txtForgotPassword, txtRegister;

    // Sample login credentials
    String correctStudentId = "12345";
    String correctPassword = "student123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_features2);

        // Connect XML components
        editStudentId = findViewById(R.id.editStudentId);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtRegister = findViewById(R.id.txtRegister);

        // LOGIN BUTTON
        btnLogin.setOnClickListener(v -> {

            String studentId = editStudentId.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (studentId.isEmpty()) {
                editStudentId.setError("Please enter your Student ID");
                editStudentId.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                editPassword.setError("Please enter your Password");
                editPassword.requestFocus();
                return;
            }

            if (studentId.equals(correctStudentId)
                    && password.equals(correctPassword)) {

                Toast.makeText(loginFeatures.this,
                        "Login Successful!",
                        Toast.LENGTH_SHORT).show();

                // Add your next Activity here if needed

            } else {
                Toast.makeText(loginFeatures.this,
                        "Invalid Student ID or Password",
                        Toast.LENGTH_LONG).show();
            }
        });

        // FORGOT PASSWORD
        txtForgotPassword.setOnClickListener(v -> {

            new AlertDialog.Builder(loginFeatures.this)
                    .setTitle("Forgot Password?")
                    .setMessage("Please contact the school administrator to reset your password.")
                    .setPositiveButton("OK", null)
                    .show();
        });

        // CREATE ACCOUNT
        txtRegister.setOnClickListener(v -> {

            Toast.makeText(loginFeatures.this,
                    "Create Account Clicked",
                    Toast.LENGTH_SHORT).show();

        });
    }
}