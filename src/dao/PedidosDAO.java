package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {

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
            PreparedStatement updatePedido = conndb.prepareStatement("UPDATE pedidos SET funcionario_id = ?, cliente_id = ?, pagamento = ? WHERE id = ?;");

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

    public boolean deletarPedido() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delPedido = conndb.prepareStatement("DELETE FROM pedidos WHERE id = ?;");

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

    public void pesquisarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaPedidos = conndb.prepareStatement("SELECT funcionario_id, cliente_id, pagamento FROM pedidos WHERE id = ?");

            buscaPedidos.setInt(1, 1);
            ResultSet resultado = buscaPedidos.executeQuery();

            while (resultado.next()) {
                int funcionarioId = resultado.getInt("funcionario_id");
                int clienteId = resultado.getInt("cliente_id");
                String pagamento = resultado.getString("pagamento");
                System.out.println("Id do funcionário: " + funcionarioId + "Id do cliente: " + clienteId + "Pagamento: " + pagamento);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
}
