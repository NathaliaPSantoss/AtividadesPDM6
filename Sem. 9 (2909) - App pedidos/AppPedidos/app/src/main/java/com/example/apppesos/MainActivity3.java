package com.example.apppesos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run () {
                intent = getIntent();
                Intent aux = new Intent(MainActivity3.this, MainActivity4.class);
                aux.putExtra("informação", intent.getStringExtra("informacao"));
                startActivity(aux);
            }
        }, 400);
        }
    }

