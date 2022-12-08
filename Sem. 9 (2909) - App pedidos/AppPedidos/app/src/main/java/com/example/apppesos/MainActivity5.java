package com.example.apppesos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent aux = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(aux);
            }
        }, 2000);
    }
}
