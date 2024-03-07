package com.example.odercoffee.Model;

public class NguoiDung {
    String user;
    String email;
    String sdt;
    String pass;

    public NguoiDung(String user, String email, String sdt, String pass) {
        this.user = user;
        this.email = email;
        this.sdt = sdt;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
