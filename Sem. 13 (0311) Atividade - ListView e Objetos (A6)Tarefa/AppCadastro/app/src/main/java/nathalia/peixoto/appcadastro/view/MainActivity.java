package nathalia.peixoto.appcadastro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import nathalia.peixoto.appcadastro.R;
import nathalia.peixoto.appcadastro.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private Spinner estados;

    EditText nome, sobrenome, nickname, email, telefone, cidade, genero, senha;

    Pessoa pessoa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        sobrenome = findViewById(R.id.sobrenome);
        nickname = findViewById(R.id.nickname);
        email = findViewById(R.id.email);
        telefone = findViewById(R.id.telefone);
        cidade = findViewById(R.id.cidade);
        senha = findViewById(R.id.senha);

        estados = (Spinner) findViewById(R.id.estados);
        estados.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estados.setAdapter(adapter);

        pessoa1 = new Pessoa(nome.getText(),
                sobrenome.getText(),
                nickname.getText(),
                email.getText(),
                telefone.getText(),
                cidade.getText(),
                estados.toString(),
                senha.getText());
    }

    public void validaSenha(){

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.moba:
                if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
                break;

            case R.id.rpg:
                if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
                break;
            case R.id.esporte:
                if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
                break;
            case R.id.plataforma:
                if (checked)
                // Cheese me
            else
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }
    }
}