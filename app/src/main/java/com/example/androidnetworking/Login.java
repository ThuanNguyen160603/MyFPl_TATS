package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidnetworking.Services.APIServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    public void goToHomePage(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // Kết nối api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIServices.baseLink)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIServices apiServices = retrofit.create(APIServices.class);

        Call<Void> call = apiServices.loginUser(username, password);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                // Check the HTTP response code to determine if the login was successful
                if (response.isSuccessful()) {
                    // Login successful, navigate to the home page
                    Intent intent = new Intent(Login.this, HomePage.class);
                    startActivity(intent);
                    finish(); // Finish the current activity so the user can't go back to the login screen using the back button
                } else {
                    // Login failed
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Login.this, "Failed to connect to API", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
