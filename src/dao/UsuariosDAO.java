package dao;

import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    private Conexao conexao = new Conexao();


    public boolean inserirUsuario(/*Usuario usuario*/) {

        try {
            Connection conudb = conexao.conectar();
            PreparedStatement novoUsuario = conudb.prepareStatement("INSERT INTO usuarios (nome, email, senha, cargo_id) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1, "Mateus");
            novoUsuario.setString(2, "mateus@gmail.com");
            novoUsuario.setString(3, "1406");
            novoUsuario.setInt(4, 2);

            int rowAffected = novoUsuario.executeUpdate();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}
