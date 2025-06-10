package dao;

import model.Reservas;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean atualizarReserva() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateReserva = conndb.prepareStatement("UPDATE clientes SET pedido_id = ?, quarto_id = ?, fim = ?, inicio = ? WHERE id = ?;");

            updateReserva.setInt(1, 1);
            updateReserva.setInt(2, 1);
            //updateReserva.setDate(3, );
            //updateReserva.setDate(4, );
            updateReserva.setInt(5, 1);

            int rowAffected = updateReserva.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarReservas() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delReserva = conndb.prepareStatement("DELETE FROM reservas WHERE id = ?;");

            delReserva.setInt(1, 1);

            int rowAffected = delReserva.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar uma reserva: " + erro);
            return false;
        }
    }
}
