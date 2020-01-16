package com.waheki.aplikasipetugassampah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.waheki.aplikasipetugassampah.R;
import com.waheki.aplikasipetugassampah.loginwarga;

public class JemputSampah extends AppCompatActivity {

    EditText nama, alamat, no_telp, email;
    Button btn;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jemput_sampah);

        nama = (EditText) findViewById(R.id.nama_pemesan);
        alamat = (EditText) findViewById(R.id.alamat_pemesan);
        no_telp = (EditText) findViewById(R.id.no_telp_pemesan);
        email = (EditText) findViewById(R.id.email_pemesan);
        btn = (Button) findViewById(R.id.btn_permintaan);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vnama = nama.getText().toString();
                String valamat = alamat.getText().toString();
                String vno_telp = no_telp.getText().toString();
                String vemail = email.getText().toString();

                DateFormat df = new SimpleDateFormat("d MMM yyyy, HH:mm");
                String date = df.format(Calendar.getInstance().getTime());

                if (vnama.equals("") || valamat.equals("") || vno_telp.equals("") || vemail.equals("")) {
                    Toast.makeText(getApplicationContext(), "Data belum lengkap", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("Orderan").push();

                    DatabaseReference keyNama = mRef.child("Nama");
                    DatabaseReference keyAlamat = mRef.child("Alamat");
                    DatabaseReference keyTelp = mRef.child("No_Telp");
                    DatabaseReference keyEmail = mRef.child("Email");
                    DatabaseReference keyWaktu = mRef.child("Waktu_Order");

                    keyNama.setValue(vnama);
                    keyAlamat.setValue(valamat);
                    keyTelp.setValue(vno_telp);
                    keyEmail.setValue(vemail);
                    keyWaktu.setValue(date);


                    Intent intent = new Intent(JemputSampah.this, JemputOrderan.class);
                    startActivity(intent);
                    finish();
//
//                    final int min = 199;
//                    final int max = 1000000;
//                    final int random = new Random().nextInt((max - min) + 1) + min;

                }
            }
        });
    }

    public void bukaMaps(View view) {
//        String uri = "http://maps.google.com/maps";
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//        intent.setPackage("com.google.android.apps.maps");
//
//        try {
//            startActivity(intent);
//        } catch (ActivityNotFoundException ex) {
//            try {
//                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                startActivity(unrestrictedIntent);
//            } catch (ActivityNotFoundException innerEx) {
//                Toast.makeText(JemputSampah.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
//            }
//        }
    }
}
