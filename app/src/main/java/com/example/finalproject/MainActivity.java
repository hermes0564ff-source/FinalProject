package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ۱. تعریف متغیرها (کادرها و دکمه)
    EditText editUsername, editPassword;
    Button btnLogin;

    // ۲. تعریف رمز ثابت برنامه (همون رمز عرفان ۰۵۶۴)
    final String CORRECT_PASSWORD = "erfan0564";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ۳. وصل کردن کدهای جاوا به ظاهر برنامه (XML)
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // ۴. تعریف کاری که وقتی دکمه ورود زده میشه انجام بشه
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ۵. گرفتن متن تایپ شده از کادرها
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                // ۶. شرط اول: چک کردن اینکه کادرها خالی نباشن
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "لطفا نام کاربری و رمز عبور را وارد کنید", Toast.LENGTH_SHORT).show();
                }
                // ۷. شرط دوم: چک کردن درست یا نبودن رمز
                else if (password.equals(CORRECT_PASSWORD)) {

                    // ۸. اگر رمز درست بود: رفتن به صفحه دوم
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("USER_NAME", username); // فرستادن نام کاربری به صفحه دوم
                    startActivity(intent);
                    finish(); // بستن صفحه اول تا با دکمه بک برنگردیم

                }
                // ۹. اگر رمز اشتباه بود: نشون دادن پیام خطا
                else {
                    Toast.makeText(MainActivity.this, "رمز عبور اشتباه است، دوباره تلاش کنید", Toast.LENGTH_SHORT).show();
                    editPassword.setText(""); // پاک کردن کادر رمز برای تلاش دوباره
                }
            }
        });
    }
}