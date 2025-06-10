package dao;

import model.Rooms;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomsDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos (nome, num, preco, quantidadeCama, tiposCama, disponivel) VALUES (?, ?, ?, ?, ?, ?);");
            novoQuarto.setString(1, "Quarto Casal");
            novoQuarto.setInt(2, 123);
            novoQuarto.setDouble(3, 250.00);
            novoQuarto.setInt(4, 2);
            novoQuarto.setString(5, "");
            novoQuarto.setBoolean(6, true);

            int rowAffected = novoQuarto.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir o quarto: " + erro);
            return false;
        }
    }

    public boolean atualizarQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateRoom = conndb.prepareStatement("UPDATE clientes SET nome = ?, num = ?, preco = ?, quantidadeCama = ?, tiposCama - ?, disponivel = ? WHERE id = ?;");

            updateRoom.setString(1, "");
            updateRoom.setInt(2, 123);
            updateRoom.setDouble(3, 250.00);
            updateRoom.setInt(4, 2);
            updateRoom.setString(5, "");
            updateRoom.setBoolean(6, true);
            updateRoom.setInt(7, 1);

            int rowAffected = updateRoom.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delRooms = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            delRooms.setInt(1, 1);

            int rowAffected = delRooms.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar o quarto: " + erro);
            return false;
        }
    }
}
