package model;

public class Rooms {
    private int id, qtd_cama_c, qtd_cama_s;
    private String nome, numero;
    private Double  preco;
    private boolean disponivel;

    public Rooms(String nome, String numero, Double preco, int qtd_cama_s, int qtd_cama_c, boolean disponivel) {
        this.nome = nome;
        this.numero = numero;
        this.preco = preco;
        this.qtd_cama_s = qtd_cama_s;
        this.qtd_cama_c = qtd_cama_c;
        this.disponivel = disponivel;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public String getNumero() {return numero;}
    public int getQtd_cama_c() {return qtd_cama_c;}
    public int getQtd_cama_s() {return qtd_cama_s;}
    public Double getPreco() {return preco;}
    public boolean isDisponivel() {return disponivel;}

    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setQtd_cama_c(int qtd_cama_c) {this.qtd_cama_c = qtd_cama_c;}
    public void setQtd_cama_s(int qtd_cama_s) {this.qtd_cama_s = qtd_cama_s;}
    public void setPreco(Double preco) {this.preco = preco;}
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}
}
