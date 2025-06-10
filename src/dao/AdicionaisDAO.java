package dao;

import model.Adicionais;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdici() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdici = conndb.prepareStatement("INSERT INTO adicionais (nome, preco) VALUES (?, ?);");
            novoAdici.setString(1, "Cama extra");
            novoAdici.setDouble(2, 65.00);

            int rowAffected = novoAdici.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir os adicionais: " + erro);
            return false;
        }
    }

    public boolean atualizarAdici() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateAdici = conndb.prepareStatement("UPDATE clientes SET nome = ?, preco = ? WHERE id = ?;");

            updateAdici.setString(1, "");
            updateAdici.setDouble(2, 65.00);
            updateAdici.setInt(3, 1);

            int rowAffected = updateAdici.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarAdici() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delAdici = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            delAdici.setInt(1, 1);


            int rowAffected = delAdici.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar o(s) adicional(is): " + erro);
            return false;
        }
    }
}
