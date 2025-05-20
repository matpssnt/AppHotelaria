package model;

public class Usuario extends Pessoa{
    private int id;
    private String senha;

    public Usuario(String senha, String nome, String cpf, String email) {
        super(nome, email, cpf);
        this.senha = senha;
    }

    public int getid() {return id;}
    public String getSenha() {return senha;}

    public void setid(int id) {this.id = id;}
    public void setSenha(String senha) {this.senha = senha;}
}
