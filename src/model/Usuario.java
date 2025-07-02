package model;

public class Usuario extends Pessoa{

    private int id, roleId;
    private String senha;

    public Usuario(String nome, String email, String senha, int roleId) {
        super(nome, email);
        this.senha = senha;
        this.roleId = roleId;
    }

    public int getid() {return id;}
    public String getSenha() {return senha;}
    public int getRoleID() {return roleId;}

    public void setid(int id) {this.id = id;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setRoleID(int roleID) {this.roleId = roleID;}
}
