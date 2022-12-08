package com.example.apppesos;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import  androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity{
    Intent aux;
    TextView tvRecebido, tvPedido;
    Button btnVoltar, btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main2);

        tvRecebido = findViewById(R.id.tv_recebido);
        tvPedido = findViewById(R.id.tv_pedido);

        aux = getIntent();
        if(aux.hasExtra("resumo")){
            btnConfirmar.setVisibility(View.GONE);
            tvPedido.setText("Resumo do Pedido: ");
            btnVoltar.setText("Novo Pedido: ");
            tvRecebido.setText(aux.getStringExtra("resumo"));
        } else {
            tvRecebido.setText(aux.getStringExtra("informação"));
        }
    }

    public void primeiraTela(View view){
        Intent aux = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(aux);
    }

}
