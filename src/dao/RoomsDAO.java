package dao;

import model.Rooms;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            PreparedStatement updateRoom = conndb.prepareStatement("UPDATE quartos SET nome = ?, num = ?, preco = ?, quantidadeCama = ?, tiposCama = ?, disponivel = ? WHERE id = ?;");

            updateRoom.setString(1, "Quarto Solteiro");
            updateRoom.setInt(2, 321);
            updateRoom.setDouble(3, 150.00);
            updateRoom.setInt(4, 1);
            updateRoom.setString(5, "Sim");
            updateRoom.setBoolean(6, false);
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
            PreparedStatement delRooms = conndb.prepareStatement("DELETE FROM quartos WHERE id = ?;");

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

    public void autenticarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement autenticarRooms = conndb.prepareStatement("SELECT nome, num, preco, quantidadeCama, tiposCama, disponivel FROM quartos WHERE id = ?");

            autenticarRooms.setInt(1, 1);
            ResultSet resultado = autenticarRooms.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                int num = resultado.getInt("num");
                double preco = resultado.getDouble("preco");
                int quantidadeCama = resultado.getInt("quantidadeCama");
                String tiposCama = resultado.getString("tiposCama");
                boolean disponivel = resultado.getBoolean("disponivel");
                System.out.println("\n-------- Autenticação dos Quartos --------\n");
                System.out.println("Nome: " + nome + "\nNúmero: " + num + "\nPreço: " + preco + "\nQuantidade de Cama: " + quantidadeCama + "\nTipos de cama: " + tiposCama + "\nDisponivel: " + disponivel);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao autenticar o quarto: " + erro);
        }
    }
}
