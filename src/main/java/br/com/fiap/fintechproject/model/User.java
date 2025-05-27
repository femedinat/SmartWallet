package br.com.fiap.fintechproject.model;

public class User {
    private String nome;
    private String cpf;
    private String password;
    private String email;
    private int cd;

    public User(String nome, String cpf, String password, String email, int cd) {
        this.nome = nome;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        this.cd = cd;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
