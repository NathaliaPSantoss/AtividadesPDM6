package nathalia.peixoto.appcadastro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import nathalia.peixoto.appcadastro.R;
import nathalia.peixoto.appcadastro.model.Pessoa;

public class TelaInicial extends AppCompatActivity {

    String TAG = "APP_MINHA_IDEIA";

    int tempoDeEspera = 1000 * 10;

    Pessoa pessoa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Log.d(TAG, "onCreate; Tela Splash carregada...");

        trocarTela();

    }

    private void trocarTela() {

        Log.d(TAG,"Mudando de tela...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                Log.d(TAG, "Esperando um tempo...");
                Intent trocarDeTela = new Intent(TelaInicial.this, MainActivity.class);

                Bundle bundle =  new Bundle();
                bundle.putString("nome", pessoa1.getNome());
                bundle.putString("email", pessoa1.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();

            }
        }, tempoDeEspera);

    }
}