package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lvItens;
    EditText tvAdicionarContato, tvRemoverContato;
    Button btnAdicionar, btnRemover;
    ArrayList<Integer> arrayNumeros;
    ArrayList<String> arrayContatos;
    ArrayAdapter<Integer> adapterNumeros;
    ArrayAdapter<String> adapterContatos;
    ArrayAdapter<Pessoa> arraypessoas;
    ArrayAdapter<Pessoa> adapterpessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItens = findViewById(R.id.lv_itens);
        arrayContatos = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Naur");
        pessoa1.setIdade(22);
        pessoa1.setSaldo(1000000);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Daiane");
        pessoa2.setIdade(22);
        pessoa2.setSaldo(4000000);

        arraypessoas = new ArrayList<>();
        arraypessoas.add(pessoa1);
        arraypessoas.add(pessoa2);

        //Adaptação do Arraylist p/ ArrayAdapter
        adapterpessoa = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arraypessoas
        );

        //Escreve o adapter no ListView (layout)
        lvItens.setAdapter(adapterpessoa);

        lvItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Pessoa(" + i +")" + " = " + arraypessoas.get(i).getNome() ,
                        Toast.LENGTH_SHORT).show();
            }
        });

        /*
        lvItens = findViewById(R.id.lv_itens);
        arrayNumeros = new ArrayList<>();
        arrayNumeros.add(5);
        arrayNumeros.add(6);
        arrayNumeros.add(15);
        arrayNumeros.add(1);
        arrayNumeros.add(-6);

        //Adaptação do Arraylist p/ ArrayAdapter
        adapterNumeros = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayNumeros
        );

        //Escreve o adapter no ListView (layout)
        lvItens.setAdapter(adapterNumeros);

        lvItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Elem(" + i +")" + " = " + arrayNumeros.get(i) ,
                        Toast.LENGTH_SHORT).show();
            }
        });

         */

    }

    public void adicionar(View view){

        tvAdicionarContato = findViewById(R.id.tv_contato);

        if (tvAdicionarContato == null){
            Toast.makeText(this, "Insira um contato válido!", Toast.LENGTH_SHORT).show();

        }else{
        arrayContatos.add(tvAdicionarContato.getText().toString());

        tvAdicionarContato.setText("");

        }

        //Adaptação do Arraylist p/ ArrayAdapter
        adapterContatos = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayContatos
        );

        //Escreve o adapter no ListView (layout)
        lvItens.setAdapter(adapterContatos);

        lvItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Elem(" + i +")" + " = " + arrayContatos.get(i) ,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void remover(View view){

        tvRemoverContato = findViewById(R.id.tv_contato);

        arrayContatos.remove(tvRemoverContato.getText().toString());

        tvAdicionarContato.setText("");

        //Adaptação do Arraylist p/ ArrayAdapter
        adapterContatos = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayContatos
        );

        //Escreve o adapter no ListView (layout)
        lvItens.setAdapter(adapterContatos);

        lvItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Elem(" + i +")" + " = " + arrayContatos.get(i) ,
                        Toast.LENGTH_SHORT).show();
            }
        });



    }


}