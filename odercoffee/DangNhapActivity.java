package com.example.odercoffee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.odercoffee.Class.DuyTriDangNhap;
import com.example.odercoffee.Database.DataHelper;

public class DangNhapActivity extends AppCompatActivity {

    Button btnSign, btnLogin;
    EditText edtEmail, edtPass;
    DataHelper dataHelper;
    CheckBox chkRe;
    DuyTriDangNhap sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        btnSign = findViewById(R.id.btnSign);
        btnLogin = findViewById(R.id.btnLogin);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        chkRe = findViewById(R.id.chkRe);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });

        // Khởi tạo sessionManager
        sessionManager = new DuyTriDangNhap(this);
        dataHelper = new DataHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String pass = edtPass.getText().toString();

                boolean result = dataHelper.checkLogin(email, pass);

                if (email.equals("Admin123@gmail.com") && pass.equals("123")) {
                    // Lưu trạng thái đăng nhập và tên người dùng vào SharedPreferences
                    if (chkRe.isChecked()) {
                        sessionManager.setLoggedIn(true);
                        sessionManager.setEmail(email);
                        // Chuyển đến màn hình HomeActivity
                        DNTCAdmin();
                    } else {
                        // Chuyển đến màn hình HomeActivity
                        DNTCAdmin();
                    }
                } else if (email.equals("User123@gmail.com") && pass.equals("123")) {
                    // Lưu trạng thái đăng nhập và tên người dùng vào SharedPreferences
                    if (chkRe.isChecked()) {
                        sessionManager.setLoggedIn(true);
                        sessionManager.setEmail(email);
                        DNTCUser();
                    } else {
                        // Chuyển đến màn hình HomeActivity
                        DNTCUser();
                    }
                } else {
                    DNTB();
                }
            }
        });
    }

    // THÔNG BÁO ĐĂNG NHẬP THÀNH CÔNG
    public void DNTCUser () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.drawable.tichxanh);
        builder.setMessage("Đăng nhập tài khoản User thành công");
        builder.setCancelable(true);

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DangNhapActivity.this, HomeUserActivity.class);
                startActivity(intent);
                DangNhapActivity.this.finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // THÔNG BÁO ĐĂNG NHẬP THÀNH CÔNG
    public void DNTCAdmin () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.drawable.tichxanh);
        builder.setMessage("Đăng nhập tài khoản Admin thành công");
        builder.setCancelable(true);

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DangNhapActivity.this, HomeAdminActivity.class);
                startActivity(intent);
                DangNhapActivity.this.finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // THÔNG BÁO ĐĂNG NHẬP THẤT BẠI
    public void DNTB () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.drawable.dangerest);
        builder.setMessage("Tài khoản hoặc mật khẩu không đúng!");
        builder.setCancelable(true);

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}