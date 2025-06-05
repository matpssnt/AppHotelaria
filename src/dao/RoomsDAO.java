package dao;

import model.Rooms;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomsDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {

        try {
            Connection concdb = conexao.conectar();
            PreparedStatement novoQuarto = concdb.prepareStatement("INSERT INTO quartos (nome, num, preco, quantidadeCama, tiposCama, disponivel) VALUES (?, ?, ?, ?, ?, ?);");
            novoQuarto.setString(1, "Quarto Casal");
            novoQuarto.setInt(2, 123);
            novoQuarto.setDouble(3, 250.00);
            novoQuarto.setInt(4, 2);
            novoQuarto.setString(5, "");
            novoQuarto.setBoolean(6, true);

            int rowAffected = novoQuarto.executeUpdate();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir o quarto: " + erro);
            return false;
        }
    }
}
