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

import com.example.odercoffee.Database.DataHelper;
import com.example.odercoffee.Model.NguoiDung;

public class DangKyActivity extends AppCompatActivity {

    Button btnLogin, btnSign;
    EditText edtUser, edtEmail, edtSdt, edtPass;
    DataHelper dataHelper;
    CheckBox chekAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        btnLogin = findViewById(R.id.btnLogin);
        btnSign = findViewById(R.id.btnSign);
        edtUser = findViewById(R.id.edtUser);
        edtEmail = findViewById(R.id.edtEmail);
        edtSdt = findViewById(R.id.edtSdt);
        edtPass = findViewById(R.id.edtPass);
        chekAdmin = findViewById(R.id.chekAdmin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dataHelper = new DataHelper(this);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String email = edtEmail.getText().toString();
                String sdt = edtSdt.getText().toString();
                String pass = edtPass.getText().toString();

                NguoiDung nd = new NguoiDung(user, email, sdt, pass);

                // KTRA ĐĂNG KÝ
                boolean result = dataHelper.insertData(nd.getUser(), nd.getEmail(), nd.getSdt(), nd.getPass());
                if (result) {
                    if(chekAdmin.isChecked()){
                        DKTCAdmin();
                    } else{
                        DKTCUser();
                    }
                } else {
                    DKTB();
                }
            }
        });
    }

    // THÔNG BÁO ĐĂNG KÝ THÀNH CÔNG
    public void DKTCUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.drawable.tichxanh);
        builder.setMessage("Đăng ký tài khoản User thành công");
        builder.setCancelable(true);

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(intent);
                DangKyActivity.this.finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void DKTCAdmin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.drawable.tichxanh);
        builder.setMessage("Đăng ký tài khoản Admin thành công");
        builder.setCancelable(true);

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(intent);
                DangKyActivity.this.finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // THÔNG BÁO ĐĂNG KÝ THẤT BẠI
    public void DKTB() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.drawable.dangerest);
        builder.setMessage("Tài khoản đã tồn tại!");
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