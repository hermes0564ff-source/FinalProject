package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // ۱. پیدا کردن متن بالای صفحه
        TextView txtWelcome = findViewById(R.id.txtWelcome);

        // ۲. گرفتن نام کاربری که از صفحه اول فرستادیم
        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");

        // ۳. گذاشتن نام کاربری روی متن (اگه خالی بود، بنویس کاربر مهمان)
        if (username != null && !username.isEmpty()) {
            txtWelcome.setText(username);
        } else {
            txtWelcome.setText("کاربر مهمان");
        }
    }
}