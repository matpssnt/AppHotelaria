package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedidos() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos (funcionario_id, cliente_id, pagamento) VALUES (?, ?, ?);");

            novoPedido.setInt(1, 1);
            novoPedido.setInt(2, 1);
            novoPedido.setString(3, "Cartão de Crédito");


            int rowAffected = novoPedido.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir um pedido: " + erro);
            return false;
        }
    }

    public boolean atualizarPedido() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updatePedido = conndb.prepareStatement("UPDATE clientes SET funcionario_id = ?, cliente_id = ?, pagamento = ? WHERE id = ?;");

            updatePedido.setInt(1, 1);
            updatePedido.setInt(2, 1);
            updatePedido.setString(3, "");
            updatePedido.setInt(4, 1);

            int rowAffected = updatePedido.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarPedidos() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delPedido = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            delPedido.setInt(1, 1);


            int rowAffected = delPedido.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar um pedido: " + erro);
            return false;
        }
    }
}
