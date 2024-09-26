package com.nautilus.sikamdisapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.nautilus.sikamdisapp.R;

public class LoginActivity extends AppCompatActivity {
    // Deklarasi variabel
    private TextInputEditText EmailEdittext;
    private TextInputEditText PasswordEdittext;
    private Button BtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Memastikan layout diatur di sini

        // Inisialisasi UI dari layout
        EmailEdittext = findViewById(R.id.txt_email);
        PasswordEdittext = findViewById(R.id.txt_password);
        BtnLogin = findViewById(R.id.btn_login);

        // Set listener untuk tombol login
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengambil input email dan password
                String email = EmailEdittext.getText().toString();
                String password = PasswordEdittext.getText().toString();

                // Validasi input
                if (!email.isEmpty() && !password.isEmpty()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Menampilkan error jika input kosong
                    if (email.isEmpty()) {
                        EmailEdittext.setError("Email harus diisi");
                    }
                    if (password.isEmpty()) {
                        PasswordEdittext.setError("Password wajib diisi");
                    }
                }
            }
        });
    }
}
