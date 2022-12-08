package nathalia.peixoto.appcadastro.model;

public class Pessoa {

    private String nome, sobrenome, nickname, email, telefone, cidade, UF, genero, senha;
    private int idade;

    public Pessoa(String nome, String sobrenome, String nickname, String email, String telefone,
                  String cidade, String UF, String genero, String senha, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nickname = nickname;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.UF = UF;
        this.genero = genero;
        this.senha = senha;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", UF='" + UF + '\'' +
                ", genero='" + genero + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade +
                '}';
    }
}
