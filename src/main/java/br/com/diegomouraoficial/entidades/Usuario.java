package br.com.diegomouraoficial.entidades;

import java.util.Objects;

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

    // metodo equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}


