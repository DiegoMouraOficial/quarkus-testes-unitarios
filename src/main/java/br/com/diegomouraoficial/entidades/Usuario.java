package br.com.diegomouraoficial.entidades;

public class Usuario {

    private String nome;


    // Construtores com e sem parametros
    public Usuario() {

    }

    public Usuario(String nome) {
        this.nome = nome;
    }


    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


