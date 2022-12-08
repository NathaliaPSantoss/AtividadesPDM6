package com.example.componentes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvFeedback;
    Spinner spnValores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFeedback = findViewById(R.id.tv_feedback);
        spnValores = findViewById(R.id.spn_valores);
    }

    public void confirmar(View v){
        String spinnerItem = spnValores.getSelectedItem().toString();
        if (spinnerItem.equals("Selecione...")){
            tvFeedback.setText("Escolha um destino de viagem!");
        } else if (spinnerItem.equals("Curitiba")){
            tvFeedback.setText("Ótima escolha, não deixe de visitar o jardim botânico!");
        } else if (spinnerItem.equals("Rio de Janeiro")){
            tvFeedback.setText("Ótima escolha, aproveite as praias!");
        } else if (spinnerItem.equals("Natal")){
            tvFeedback.setText("Ótima escolha, não deixe de visitar as dunas de areia!");
        } else if (spinnerItem.equals("Gramado")){
            tvFeedback.setText("Ótima escolha, aproveite as viagem!");
        }

    }
    public void limpar(View v){
    
    }


}