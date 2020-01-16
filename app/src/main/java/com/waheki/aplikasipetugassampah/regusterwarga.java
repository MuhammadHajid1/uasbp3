package com.waheki.aplikasipetugassampah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Date;


public class regusterwarga extends Activity {

    EditText namaDepan, namaBelakang, username, email, password, passwordUlang;
    Button mRegisterbtn;
    FirebaseAuth mAuth;
    DatabaseReference mdatabase;
    String NamaDepan, NamaBelakang, UserName, Email, Password, PasswordUlang;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regusterwarga);

        namaDepan = (EditText) findViewById(R.id.nama_depan);
        namaBelakang = (EditText) findViewById(R.id.nama_belakang);
        username = (EditText) findViewById(R.id.usernameDftr);
        email = (EditText) findViewById(R.id.emailDftr);
        password = (EditText) findViewById(R.id.passwordDftr);
        passwordUlang = (EditText) findViewById(R.id.passwordUlang);

        // for authentication using FirebaseAuth.
        mAuth = FirebaseAuth.getInstance();
        //mRegisterbtn.setOnClickListener((View.OnClickListener) this);
        mDialog = new ProgressDialog(this);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("User");
    }

    public void Daftar(View view) {

        UserRegister();

    }

    private void UserRegister() {
        NamaDepan = namaDepan.getText().toString().trim();
        NamaBelakang = namaBelakang.getText().toString().trim();
        UserName = username.getText().toString().trim();
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();
        PasswordUlang = passwordUlang.getText().toString().trim();

        if (TextUtils.isEmpty(NamaDepan)) {
            Toast.makeText(regusterwarga.this, "Masukkan Nama Depan", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(NamaBelakang)) {
            Toast.makeText(regusterwarga.this, "Masukkan Nama Belakang", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(UserName)) {
            Toast.makeText(regusterwarga.this, "Masukkan Username", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(Email)) {
            Toast.makeText(regusterwarga.this, "Masukkan Email", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(Password)) {
            Toast.makeText(regusterwarga.this, "Masukkan Password", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(PasswordUlang)) {
            Toast.makeText(regusterwarga.this, "Ulangi Password", Toast.LENGTH_SHORT).show();
            return;
        } else if (!password.getText().toString().trim().equals(passwordUlang.getText().toString().trim())) {
            Toast.makeText(regusterwarga.this, "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
            return;
        } else if (Password.length() < 6) {
            Toast.makeText(regusterwarga.this, "Masukkan Password Minimal 6 Karakter", Toast.LENGTH_SHORT).show();
            return;
        }
        mDialog.setMessage("Membuat Akun, Mohon Tunggu...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //sendEmailVerification();
                    mDialog.dismiss();
                    OnAuth(task.getResult().getUser());
                    mAuth.signOut();
                    Intent intent = new Intent(regusterwarga.this, loginwarga.class);
                    startActivity(intent);
                    finish();
                } else if (!task.isSuccessful()) {
                    Toast.makeText(regusterwarga.this, "Format Email Salah atau Email Sudah Terdaftar", Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                } else {
                    Toast.makeText(regusterwarga.this, "Email Atau Password Sudah Ada", Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                }
            }
        });
    }

    private void OnAuth(FirebaseUser user) {
        createAnewUser(user.getUid());
    }

    private void createAnewUser(String uid) {
        User user = BuildNewuser();
        mdatabase.child(uid).setValue(user);
    }


    private User BuildNewuser() {
        return new User(
                getFirstName(),
                getLastName(),
                getUsername(),
                getUserEmail(),
                getPassword()
        );
    }

    public String getFirstName() {

        return NamaDepan;
    }

    public String getLastName() {

        return NamaBelakang;
    }

    public String getUsername() {

        return UserName;
    }

    public String getUserEmail() {

        return Email;
    }

    public String getPassword() {

        return Password;
    }


}
