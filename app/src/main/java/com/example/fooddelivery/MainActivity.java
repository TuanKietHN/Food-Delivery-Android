package com.example.fooddelivery;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private TextView loginTab, signupTab, forgotPassword;
    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private View loginIndicator, signupIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        loginTab = findViewById(R.id.login_tab);
        signupTab = findViewById(R.id.signup_tab);
        loginIndicator = findViewById(R.id.login_indicator);
        signupIndicator = findViewById(R.id.signup_indicator);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        forgotPassword = findViewById(R.id.forgot_password);
        loginButton = findViewById(R.id.login_button);

        // Set password transformation method to hide password
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());

        // Set click listeners
        loginTab.setOnClickListener(v -> {
            setActiveTab(true);
        });

        signupTab.setOnClickListener(v -> {
            setActiveTab(false);
        });

        forgotPassword.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
        });

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login attempt with: " + email, Toast.LENGTH_SHORT).show();
                // Implement your login logic here
            }
        });

        // Set login tab as active by default
        setActiveTab(true);
    }

    private void setActiveTab(boolean isLoginActive) {
        if (isLoginActive) {
            loginTab.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            signupTab.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
            loginIndicator.setVisibility(View.VISIBLE);
            signupIndicator.setVisibility(View.INVISIBLE);
        } else {
            loginTab.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            signupTab.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
            loginIndicator.setVisibility(View.INVISIBLE);
            signupIndicator.setVisibility(View.VISIBLE);
            // Here you would typically switch to the signup form
            // For this example, we'll just show a toast
            Toast.makeText(this, "Sign-up tab clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
