package dao;

import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    private Conexao conexao = new Conexao();


    public boolean inserirUsuario(/*Usuario usuario*/) {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios (nome, email, senha, cargo_id) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1, "Mateus");
            novoUsuario.setString(2, "mateus@gmail.com");
            novoUsuario.setString(3, "1406");
            novoUsuario.setInt(4, 2);

            int rowAffected = novoUsuario.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean atualizarUsuario() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateUsuario = conndb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?), cargo_id = ? WHERE id = ?;");

            updateUsuario.setString(1, "");
            updateUsuario.setString(2, "");
            updateUsuario.setString(3, "");
            updateUsuario.setInt(4, 2);
            updateUsuario.setInt(5, 1);

            int rowAffected = updateUsuario.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o usuario: " + erro);
            return false;
        }
    }

    public boolean deletarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delUsuario = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");

            delUsuario.setInt(1, 1);

            int rowAffected = delUsuario.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }
}
