package com.nautilus.sikamdisapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    //mengdeklarasikan teleni dahulu yang dibutuhkan
    private TextInputEditText EmailEdittext;
    private TextInputEditText PasswordEdittext;
    private Button BtnLogin;
    private TextView vr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //memanggil idsesuaiyang di xml ditampung di variabel
        TextView txvLogin = findViewById(R.id.txvlogin);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

// Untuk animasi muncul
        txvLogin.startAnimation(fadeIn);

        EmailEdittext = findViewById(R.id.email_login);
        PasswordEdittext = findViewById(R.id.password_login);
        BtnLogin = findViewById(R.id.btn_login);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menangkap data inputan dari luar
                String email = EmailEdittext.getText().toString();
                String password = PasswordEdittext.getText().toString();
                //validasi
                if(!email.isEmpty() && !password.isEmpty()){
                    Intent intent = new Intent(LoginActivity.this ,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    if (email.isEmpty()){
                        EmailEdittext.setError("email harus diisi");
                    }
                    if (password.isEmpty()){
                        PasswordEdittext.setError("passwor wajib diisi");
                    }
                }
            }
        });
    }
}