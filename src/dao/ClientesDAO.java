package dao;

import model.Cliente;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes (login_id, nome, cpf, telefone) VALUES (?, ?, ?, ?);");
            novoCliente.setInt(1, 1);
            novoCliente.setString(2, "Mateus");
            novoCliente.setString(3, "12345678900");
            novoCliente.setString(4, "(10)98765-4321");

            int rowAffected = novoCliente.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }

    public boolean atualizarCliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateCliente = conndb.prepareStatement("UPDATE clientes SET login_id = ?, nome = ?, cpf = ?, telefone = ? WHERE id = ?;");

            updateCliente.setInt(1, 1);
            updateCliente.setString(2, "Ma");
            updateCliente.setString(3, "12345678911");
            updateCliente.setString(4, "(10)12345-6789");
            updateCliente.setInt(5, 1);

            int rowAffected = updateCliente.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delCliente = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            delCliente.setInt(1, 1);


            int rowAffected = delCliente.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar cliente: " + erro);
            return false;
        }
    }

    public void autenticarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement autenticarCliente = conndb.prepareStatement("SELECT nome, cpf, telefone FROM clientes WHERE login_id = ?");

            autenticarCliente.setInt(1, 1);
            ResultSet resultado = autenticarCliente.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("cpf");
                String telefone = resultado.getString("telefone");
                System.out.println("\n-------- Autenticação de Clientes --------\n");
                System.out.println("Nome: " + nome + "\nCPF: " + email + "\nTelefone: " + telefone);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao autenticar cliente: " + erro);
        }
    }
}
