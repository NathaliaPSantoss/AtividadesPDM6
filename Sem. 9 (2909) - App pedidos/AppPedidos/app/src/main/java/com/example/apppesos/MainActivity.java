package com.example.apppesos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbCafe, cbCoca, cbBurguer, cbPastel ;
    TextView tvQtdeCafe, tvQtdeCoca, tvQtdeBurguer, tvQtdePastel, precoCafe, precoCoca, precoBurguer, precoPastel;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCafe = findViewById(R.id.cb_cafe);
        cbCoca = findViewById(R.id.cb_coca);
        cbBurguer = findViewById(R.id.cb_burguer);
        cbPastel = findViewById(R.id.cb_pastel);

        tvQtdeCafe = findViewById(R.id.tv_qtdecafe);
        tvQtdeCoca = findViewById(R.id.tv_qtdecoca);
        tvQtdeBurguer = findViewById(R.id.tv_qtdeburguer);
        tvQtdePastel = findViewById(R.id.tv_qtdepastel);

        precoCafe = findViewById(R.id.tv_precocafe);
        precoCoca = findViewById(R.id.tv_precococa);
        precoBurguer = findViewById(R.id.tv_precoburguer);
        precoPastel = findViewById(R.id.tv_precopastel);

        spn = findViewById(R.id.spn_valores);

    }

    public void setarQtde(View view){
        int qtdeCafe=0, qtdeCoca=0, qtdeBurguer=0, qtdePastel=0;
        String qtde;

        switch (view.getId()){

            case R.id.btnDecreaseCafe:
                qtde = tvQtdeCafe.getText().toString();
                if (Integer.parseInt(qtde) > 0){
                    qtdeCafe = Integer.parseInt(qtde) -1;
                } else {
                    tvQtdeCafe.setText(" " + qtdeCafe);
                }
            break;

            case R.id.btnDecreaseCoca:
                qtde = tvQtdeCoca.getText().toString();
                if (Integer.parseInt(qtde) > 0){
                    qtdeCoca = Integer.parseInt(qtde) -1;
                } else {
                    tvQtdeCoca.setText(" " + qtdeCoca);
                }
            break;

            case R.id.btnDecreaseBurguer:
                qtde = tvQtdeBurguer.getText().toString();
                if (Integer.parseInt(qtde) > 0){
                    qtdeBurguer = Integer.parseInt(qtde) -1;
                } else {
                    tvQtdeBurguer.setText(" " + qtdeBurguer);
                }
                break;

            case R.id.btnDecreasePastel:
                qtde = tvQtdePastel.getText().toString();
                if (Integer.parseInt(qtde) > 0){
                    qtdePastel = Integer.parseInt(qtde) -1;
                } else {
                    tvQtdePastel.setText("" + qtdePastel);
                }
                break;

            case R.id.btnIncreaseCafe:
                qtde = tvQtdeCafe.getText().toString();
                    qtdeCafe = Integer.parseInt(qtde) +1;
                    tvQtdeCafe.setText("" + qtdeCafe);
                break;

            case R.id.btnIncreaseCoca:
                qtde = tvQtdeCoca.getText().toString();
                qtdeCoca = Integer.parseInt(qtde) +1;
                tvQtdeCoca.setText("" + qtdeCoca);
                break;

            case R.id.btnIncreaseBurguer:
                qtde = tvQtdeBurguer.getText().toString();
                qtdeBurguer = Integer.parseInt(qtde) +1;
                tvQtdeBurguer.setText(" " + qtdeBurguer);
                break;

            case R.id.btnIncreasePastel:
                qtde = tvQtdePastel.getText().toString();
                qtdePastel = Integer.parseInt(qtde) +1;
                tvQtdePastel.setText(" " + qtdePastel);
                break;
        }

    }

    public void fazerPedido(View view) {
        if (!validaCampos().equals("")){
            Toast.makeText(MainActivity.this,
                    validaCampos(), Toast.LENGTH_LONG).show();
        }
        else if (!verificarPgto().equals("")){
            Toast.makeText(MainActivity.this,
                    verificarPgto(), Toast.LENGTH_LONG).show();
        }
        else{
            atualizarPedido();
        }
    }

    private String validaCampos(){
        if (cbCafe.isChecked()){
            if (tvQtdeCafe.getText().toString().equals("0")){
                return "Informe a(s) unidade(s) do café";
            }
        } else{
            if (!tvQtdeCafe.getText().toString().equals("0")){
                return "Marque a(s) unidade(s) do café";
            }
        }

        if (cbCoca.isChecked()){
            if (tvQtdeCoca.getText().toString().equals("0")){
                return "Informe a(s) unidade(s) da Coca";
            }
        } else{
            if (!tvQtdeCafe.getText().toString().equals("0")){
                return "Marque a(s) unidade(s) do café";
            }
        }

        if (cbBurguer.isChecked()){
            if (tvQtdeBurguer.getText().toString().equals("0")){
                return "Informe a(s) unidade(s) do hamburguer";
            }
        } else{
            if (!tvQtdeBurguer.getText().toString().equals("0")){
                return "Marque a(s) unidade(s) do hamburguer";
            }
        }

        if (cbPastel.isChecked()){
            if (tvQtdePastel.getText().toString().equals("0")){
                return "Informe a(s) unidade(s) do pastel";
            }
        } else{
            if (!tvQtdePastel.getText().toString().equals("0")){
                return "Marque a(s) unidade(s) do pastel";
            }
        }
        if (!cbCafe.isChecked() && !cbCoca.isChecked() && !cbBurguer.isChecked() && cbPastel.isChecked()){
            return "Selecione um item para continuar";
        }
        return null;
    }

    private String verificarPgto() {
        if (spn.getSelectedItem().toString().equals("Selecione...")){
            return "Informe o pagamento!";
        }
        return "";
    }

    private void atualizarPedido() {
        float juros = 0, jurosCalculado = 0, valorTotal = 0, valorTotalJuros;

        float valorTotalCafe = Float.parseFloat(tvQtdeCafe.getText().toString()) * Float.parseFloat(
                precoCafe.getText().toString());
        float valorTotalCoca = Float.parseFloat(tvQtdeCoca.getText().toString()) * Float.parseFloat(
                precoCoca.getText().toString());
        float valorTotalBurger = Float.parseFloat(tvQtdeBurguer.getText().toString()) * Float.parseFloat(
                precoBurguer.getText().toString());
        float valorTotalPastel = Float.parseFloat(tvQtdePastel.getText().toString()) * Float.parseFloat(
                precoPastel.getText().toString());
        String pedido = "";

        if(valorTotalCafe > 0){
            pedido += tvQtdeCafe.getText().toString() + " Café(s) R$ " + precoCafe.getText().toString() +
                    ": " + valorTotalCafe + "\n";
            valorTotal += valorTotalCafe;
        }

        if(valorTotalCoca > 0){
            pedido += tvQtdeCoca.getText().toString() + " Coca(s) R$ " + precoCoca.getText().toString() +
                    ": " + valorTotalCoca + "\n";
            valorTotal += valorTotalCoca;
        }

        if(valorTotalBurger > 0){
            pedido += tvQtdeCoca.getText().toString() + " Burger(s) R$ " + precoBurguer.getText().toString() +
                    ": " + valorTotalBurger + "\n";
            valorTotal += valorTotalBurger;
        }
        if(valorTotalPastel > 0){
            pedido += tvQtdePastel.getText().toString() + " Pastel(s) R$ " + precoPastel.getText().toString() +
                    ": " + valorTotalPastel + "\n";
            valorTotal += valorTotalPastel;
        }

        if(spn.getSelectedItem().toString().equals("Débito")){
            juros = 8;
            jurosCalculado = (float) (valorTotal * 0.08);
        }
        else if(spn.getSelectedItem().toString().equals("Crédito")){
            juros = 15;
            jurosCalculado = (float) (valorTotal * 0.15);
        }

        valorTotalJuros = valorTotal + jurosCalculado;

        pedido += "Total: R$ " + valorTotal + " + " + jurosCalculado + " ("+juros+"%) = R$ " + valorTotalJuros;

        enviarPedido(pedido);
    }

    private void enviarPedido(String pedido){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("informacao",pedido);
        this.startActivity(intent);
    }
}