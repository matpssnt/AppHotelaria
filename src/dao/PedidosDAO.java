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
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos (usuario_id, cliente_id, pagamento) VALUES (?, ?, ?);");

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
            PreparedStatement updatePedido = conndb.prepareStatement("UPDATE pedidos SET usuario_id = ?, cliente_id = ?, pagamento = ? WHERE id = ?;");

            updatePedido.setInt(1, 1);
            updatePedido.setInt(2, 1);
            updatePedido.setString(3, "Cartão de Débito");
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

    public void autenticarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaPedidos = conndb.prepareStatement("SELECT usuario_id, cliente_id, pagamento FROM pedidos WHERE id = ?");

            buscaPedidos.setInt(1, 1);
            ResultSet resultado = buscaPedidos.executeQuery();

            while (resultado.next()) {
                int usuarioId = resultado.getInt("usuario_id");
                int clienteId = resultado.getInt("cliente_id");
                String pagamento = resultado.getString("pagamento");
                System.out.println("\n-------- Autenticação dos Pedidos --------\n");
                System.out.println("Id do usuario: " + usuarioId + "\nId do cliente: " + clienteId + "\nPagamento: " + pagamento);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao autenticar usuario: " + erro);
        }
    }
}
