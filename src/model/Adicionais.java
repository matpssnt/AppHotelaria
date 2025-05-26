package model;

public class Adicionais {
    private int id;
    private String nome;
    private double preco;

    public Adicionais(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getid() {return id;}
    public String getNome() {return nome;}
    public double getPreco() {return preco;}

    public void setid(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(double preco) {this.preco = preco;}
}
