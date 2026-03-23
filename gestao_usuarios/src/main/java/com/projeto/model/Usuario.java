package com.projeto.model;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String tel;
    private int idade;

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "nome: " + nome + "\n" +
                "email: " + email + "\n" +
                "tel: " + tel + "\n" +
                "idade: " + idade + "\n";
    }
}