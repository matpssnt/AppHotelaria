package dao;

import model.Rooms;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomsDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto(Rooms room) {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos (nome, num, preco, qtd_cama_s, qtd_cama_c, disponivel) VALUES (?, ?, ?, ?, ?, ?);");
            novoQuarto.setString(1, room.getNome());
            novoQuarto.setString(2, room.getNumero());
            novoQuarto.setDouble(3, room.getPreco());
            novoQuarto.setInt(4, room.getQtd_cama_s());
            novoQuarto.setInt(5, room.getQtd_cama_c());
            novoQuarto.setBoolean(6, room.isDisponivel());

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
            PreparedStatement updateRoom = conndb.prepareStatement("UPDATE quartos SET nome = ?, num = ?, preco = ?, qtd_cama_c = ?, qtd_cama_s = ?, disponivel = ? WHERE id = ?;");

            updateRoom.setString(1, "Quarto Solteiro");
            updateRoom.setString(2, "");
            updateRoom.setDouble(3, 150.00);
            updateRoom.setInt(4, 1);
            updateRoom.setInt(5, 0);
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
            PreparedStatement autenticarRooms = conndb.prepareStatement("SELECT nome, num, preco, qtd_cama_c, qtd_cama_s, disponivel FROM quartos WHERE id = ?");

            autenticarRooms.setInt(1, 1);
            ResultSet resultado = autenticarRooms.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                int num = resultado.getInt("num");
                double preco = resultado.getDouble("preco");
                int qtd_cama_c = resultado.getInt("qtdCamaCasal:");
                int qtd_cama_s = resultado.getInt("qtdCamaSolteiro");
                boolean disponivel = resultado.getBoolean("disponivel");
                System.out.println("\n-------- Autenticação dos Quartos --------\n");
                System.out.println("Nome: " + nome + "\nNúmero: " + num + "\nPreço: " + preco + "\nCama de Casal: " + qtd_cama_c + "\nCama de Solteiro: " + qtd_cama_s + "\nDisponivel: " + disponivel);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao autenticar o quarto: " + erro);
        }
    }
}
