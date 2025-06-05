package dao;

import model.Cliente;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirClientes() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes (login_id, nome, cpf, telefone) VALUES (?, ?, ?, ?);");
            novoCliente.setInt(1, 1);
            novoCliente.setString(2, "Mateus");
            novoCliente.setString(3, "12345678900");
            novoCliente.setString(4, "(10)98765-4321");

            int rowAffected = novoCliente.executeUpdate();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
}
