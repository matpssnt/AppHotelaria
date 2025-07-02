package dao;

import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

            updateUsuario.setString(1, "a");
            updateUsuario.setString(2, "a");
            updateUsuario.setString(3, "a");
            updateUsuario.setInt(4, 2);
            updateUsuario.setInt(5, 2);

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

    public boolean autenticarUsuario(Usuario usuario) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement autenUsuario = conndb.prepareStatement("SELECT nome FROM usuarios WHERE email = ? and senha = md5(?);");

            autenUsuario.setString(1, usuario.getEmail());
            autenUsuario.setString(2, usuario.getSenha());
            ResultSet resultado = autenUsuario.executeQuery();

            boolean acessoAutorizado = resultado.next();
            String nome = resultado.getString("nome");
            System.out.println("Olá! Seja bem-vindo," + nome);

            conndb.close();
            return acessoAutorizado;
        }
        catch (Exception erro) {
            System.out.println("Erro ao autenticar usuario: " + erro);
            return false;
        }
    }
}
