package model;

public class Cliente extends Pessoa {

//Declaração de uma variável própria da classe Cliente
private int id;
private String telefone;

    public Cliente(String nome, String email, String cpf, String telefone) {
        super(nome, email, cpf);
        this.telefone = telefone;
    }

    //Getters and Setters
    public int id () {return id;}
    public String telefone () {return telefone;}

    public void setId(int id) {this.id = id;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
