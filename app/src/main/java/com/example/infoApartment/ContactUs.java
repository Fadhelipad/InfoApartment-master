package com.example.infoApartment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        FloatingActionButton fab = findViewById(R.id.btncall);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:Fadhelipad33@gmail.com"));
                startActivity(intent);
            }
        });


        ImageButton call = findViewById(R.id.btn_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTocall();
            }

            private void goTocall() {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:082218329362"));

                startActivity(browserIntent);

            }
        });
        ImageButton ig = findViewById(R.id.btn_instagram);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToig();
            }

            private void goToig() {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/Fadhel.ipad"));

                startActivity(browserIntent);

            }
        });
        ImageButton tw = findViewById(R.id.btn_twitter);
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToig();
            }

            private void goToig() {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/Fadhel_ipad"));

                startActivity(browserIntent);

            }
        });


    }

}
