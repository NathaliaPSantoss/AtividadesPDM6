package pdm.projetos.exemplocrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_nome, et_email, et_tel, et_id;
    ListView lv_jogadores;
    ArrayList<Jogador> arrayJogadores;
    ArrayAdapter<Jogador> adapterJogadores;
    String url;
    private String HOST = "http://192.168.0.6/projeto_jogos";
    private int iClicado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsBy();
        listaJogadores();
    }

    private void findViewsBy() {
        et_nome = findViewById(R.id.et_nome);
        et_email = findViewById(R.id.et_email);
        et_tel = findViewById(R.id.et_tel);
        et_id = findViewById(R.id.et_id);
        lv_jogadores = findViewById(R.id.lv_jogadores);

        arrayJogadores = new ArrayList<>();
        adapterJogadores = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayJogadores);
        lv_jogadores.setAdapter(adapterJogadores);
        lv_jogadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                et_id.setText(String.valueOf(arrayJogadores.get(i).getId()));
                et_nome.setText(arrayJogadores.get(i).getNome());
                et_tel.setText(arrayJogadores.get(i).getTel());
                et_email.setText(arrayJogadores.get(i).getEmail());
                iClicado = i;
            }
        });
    }

    private void listaJogadores() {
        String url = HOST + "/read.php";
        Ion.with(MainActivity.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int index = 0; index < result.size(); index++) {
                            JsonObject resposta = result.get(index).getAsJsonObject();
                            Jogador jogador = new Jogador();
                            jogador.setId(resposta.get("id").getAsInt());
                            jogador.setNome(resposta.get("nome").getAsString());
                            jogador.setTel(resposta.get("cel").getAsString());
                            jogador.setEmail(resposta.get("email").getAsString());
                            arrayJogadores.add(jogador);
                        }
                        adapterJogadores.notifyDataSetChanged();
                    }
                });
    }

    public void botoes(View view) {
        String nome = et_nome.getText().toString();
        String tel = et_tel.getText().toString();
        String email = et_email.getText().toString();
        String id = et_id.getText().toString();

        switch (view.getId()) {
            case R.id.btn_novo:
                limpaCampos();
                break;
            case R.id.btn_salvar:
                if (nome.isEmpty()) {
                    Toast.makeText(this, "Nome Obrigat??rio!!", Toast.LENGTH_SHORT).show();
                    et_nome.setError("Nome Obrigat??rio!");
                } else {
                    if (id.isEmpty()) {
                        String url = HOST + "/create.php";
                        Ion.with(MainActivity.this)
                                .load(url)
                                .setBodyParameter("nome", nome)
                                .setBodyParameter("cel", tel)
                                .setBodyParameter("email", email)
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {
                                        if (result.get("CREATE").getAsString().equals("OK")) {
                                            int idRet = Integer.parseInt(result.get("ID").getAsString());
                                            Jogador jogador = new Jogador();
                                            jogador.setId(idRet);
                                            jogador.setNome(nome);
                                            jogador.setTel(tel);
                                            jogador.setEmail(email);
                                            arrayJogadores.add(jogador);
                                            adapterJogadores.notifyDataSetChanged();

                                            Toast.makeText(MainActivity.this,
                                                    "Salvo Com Sucesso!! ID: " + idRet,
                                                    Toast.LENGTH_LONG).show();
                                            System.out.println("Sucesso!");
                                        } else {
                                            Toast.makeText(MainActivity.this,
                                                    "Erro ao salvar!!",
                                                    Toast.LENGTH_LONG).show();
                                            System.out.println("Erro!");
                                        }
                                    }
                                });
                        limpaCampos();
                    } else {
                        String url = HOST + "/update.php";
                        Ion.with(MainActivity.this)
                                .load(url)
                                .setBodyParameter("id", id)
                                .setBodyParameter("nome", nome)
                                .setBodyParameter("cel", tel)
                                .setBodyParameter("email", email)
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {
                                        if (result.get("UPDATE").getAsString().equals("OK")) {
                                            Jogador jogador = new Jogador();
                                            jogador.setId(Integer.parseInt(id));
                                            jogador.setNome(nome);
                                            jogador.setTel(tel);
                                            jogador.setEmail(email);
                                            arrayJogadores.set(iClicado, jogador);
                                            adapterJogadores.notifyDataSetChanged();

                                            Toast.makeText(MainActivity.this,
                                                    "Atualizado Com Sucesso!!",
                                                    Toast.LENGTH_LONG).show();
                                            System.out.println("Sucesso!");
                                        } else {
                                            Toast.makeText(MainActivity.this,
                                                    "Erro ao salvar!!",
                                                    Toast.LENGTH_LONG).show();
                                            System.out.println("Erro!");
                                        }
                                    }
                                });
                    }
                }
                break;
            case R.id.btn_excluir:

                if (id.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Nenhum contato est?? selecionado!",
                            Toast.LENGTH_LONG).show();
                    System.out.println("Erro!");
                } else {
                    String url = HOST + "/delete.php";
                    Ion.with(MainActivity.this)
                            .load(url)
                            .setBodyParameter("id", id)
                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {
                                    if (result.get("DELETE").getAsString().equals("OK")) {
                                        arrayJogadores.remove(iClicado);
                                        adapterJogadores.notifyDataSetChanged();

                                        limpaCampos();

                                        Toast.makeText(MainActivity.this,
                                                "Excluido Com Sucesso!!",
                                                Toast.LENGTH_LONG).show();
                                        System.out.println("Sucesso!");
                                    } else {
                                        Toast.makeText(MainActivity.this,
                                                "Erro ao excluir!!",
                                                Toast.LENGTH_LONG).show();
                                        System.out.println("Erro!");
                                    }
                                }
                            });
                }
                break;
        }


    }

    public void limpaCampos() {
        et_nome.setText("");
        et_tel.setText("");
        et_email.setText("");
        et_nome.requestFocus();
    }

}