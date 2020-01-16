package com.waheki.aplikasipetugassampah;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PetaInformasi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta_informasi);
    }

    public void lokasi1(View view) {
        String uri = "http://maps.google.com/maps?daddr=TPA Sampah Putri Cempo";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(PetaInformasi.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void lokasi2(View view) {
        String uri = "http://maps.google.com/maps?daddr=Soko, Sukosari, Jumantono, Kabupaten Karanganyar, Jawa Tengah 57782";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(PetaInformasi.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void lokasi3(View view) {
        String uri = "http://maps.google.com/maps?daddr=Sambilutung, Mojorejo, Kec. Bendosari, Kabupaten Sukoharjo, Jawa Tengah 57528";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(PetaInformasi.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void lokasi4(View view) {
        String uri = "http://maps.google.com/maps?daddr=Dusun Tere, Kerjo Lor, Kec. Ngadirojo, Kabupaten Wonogiri, Jawa Tengah 57681";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(PetaInformasi.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void lokasi5(View view) {
        String uri = "http://maps.google.com/maps?daddr=eks tpa jomboran";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(PetaInformasi.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void lokasi6(View view) {
        String uri = "http://maps.google.com/maps?daddr=TPA SAMPAH MOJOREJO KAB. SUKOHARJO";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(PetaInformasi.this, "Silahkan install aplikasi Google Maps terlebih dahulu", Toast.LENGTH_LONG).show();
            }
        }
    }
}
