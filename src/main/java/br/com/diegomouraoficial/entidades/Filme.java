package br.com.diegomouraoficial.entidades;

public class Filme {

    private String nome;
    private Integer estoque;
    private  Double prelocacao;



    // Construtores com e sem parametros
    public Filme() {

    }

    public Filme(String nome, Integer estoque, Double prelocacao) {
        this.nome = nome;
        this.estoque = estoque;
        this.prelocacao = prelocacao;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPrelocacao() {
        return prelocacao;
    }

    public void setPrelocacao(Double prelocacao) {
        this.prelocacao = prelocacao;
    }
}
