package model;

public class Cliente extends Pessoa {

//Declaração de uma variável própria da classe Cliente
private int id;
private String telefone, cpf;

    public Cliente(String nome, String email, String cpf, String telefone) {
        super(nome, email);
        this.telefone = telefone;
        this.cpf = cpf;
    }

    //Getters and Setters
    public int id () {return id;}
    public String telefone () {return telefone;}
    public String cpf () {return cpf;}

    public void setId(int id) {this.id = id;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setCpf(String cpf) {this.cpf = cpf;}
}
