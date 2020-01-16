package com.waheki.aplikasipetugassampah;

public class User {
    String  nama_belakang, nama_depan, username, email, password;

    public User(String nama_belakang, String nama_depan, String username, String email, String password) {
        this.nama_depan = nama_depan;
        this.nama_belakang = nama_belakang;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
