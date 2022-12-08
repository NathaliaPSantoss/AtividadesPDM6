package com.example.apppesos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4  extends AppCompatActivity {
    Intent intent;
    TextView tvPedido;
    Button btnVoltar, btnConfirmar;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        intent=getIntent();
        tvPedido=findViewById(R.id.tv_pedido);
        btnConfirmar=findViewById(R.id.btn_confirmar);
        btnVoltar = findViewById(R.id.btn_voltar);

    }

    public void telaResumo(View view){
        Intent aux = new Intent(MainActivity4.this, MainActivity2.class);
        aux.putExtra("resumo", intent.getStringExtra("informacao"));
        startActivity(aux);
    }
}
