package com.example.odercoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeAdminActivity extends AppCompatActivity {

    ImageButton out;
    Button thongKe, LS, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        out = findViewById(R.id.out);
        thongKe = findViewById(R.id.thongke);
        LS = findViewById(R.id.LS);
        add = findViewById(R.id.add);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAdminActivity.this, DangNhapActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        thongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAdminActivity.this, ThongKeActivity.class);
                startActivity(intent);
            }
        });

        LS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAdminActivity.this, LichSuActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAdminActivity.this, AddSPActivity.class);
                startActivity(intent);
            }
        });
    }
}