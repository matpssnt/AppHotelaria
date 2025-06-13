package dao;

import model.Reservas;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean atualizarReserva() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateReservas = conndb.prepareStatement("UPDATE reservas SET pedido_id = ?, quarto_id = ?, fim = ?, inicio = ? WHERE id = ?;");

            updateReservas.setInt(1, 1);
            updateReservas.setInt(2, 1);
            //updateReserva.setDate(3, );
            //updateReserva.setDate(4, );
            updateReservas.setInt(5, 1);

            int rowAffected = updateReservas.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarReserva() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delReservas = conndb.prepareStatement("DELETE FROM reservas WHERE id = ?;");

            delReservas.setInt(1, 1);

            int rowAffected = delReservas.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar uma reserva: " + erro);
            return false;
        }
    }

    public void pesquisarReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaReservas = conndb.prepareStatement("SELECT pedido_id, quarto_id, fim , inicio FROM reservas WHERE id = ?");

            buscaReservas.setInt(1, 1);
            ResultSet resultado = buscaReservas.executeQuery();

            while (resultado.next()) {
                int pedidoId = resultado.getInt("pedido_id");
                int quartoId = resultado.getInt("quarto_id");
                //int fim = resultado.getInt("fim");
                //int inicio = resultado.getInt("inicio");
                System.out.println("Id do pedido: " + pedidoId + " Id do quarto: " + quartoId);// + "Fim: " + fim + "Inicio: " + inicio);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
}
