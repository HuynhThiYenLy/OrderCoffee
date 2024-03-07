package com.example.odercoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeUserActivity extends AppCompatActivity {
    Button sanPham, gioHang, thanhToan;
    ImageButton out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        sanPham = findViewById(R.id.sanPham);
        gioHang = findViewById(R.id.gioHang);
        thanhToan = findViewById(R.id.thanhToan);
        out = findViewById(R.id.out);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeUserActivity.this, DangNhapActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        sanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeUserActivity.this, SanPhamActivity.class);
                startActivity(intent);
            }
        });

        gioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeUserActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

        thanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeUserActivity.this, ThanhToanActivity.class);
                startActivity(intent);
            }
        });

    }
}