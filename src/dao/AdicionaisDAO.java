package dao;

import model.Adicionais;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            PreparedStatement updateAdici = conndb.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?;");

            updateAdici.setString(1, "Sem adicionais");
            updateAdici.setDouble(2, 0.0);
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
            PreparedStatement delAdici = conndb.prepareStatement("DELETE FROM adicionais WHERE id = ?;");

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

    public void autenticarAdici() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement autenticarAdici = conndb.prepareStatement("SELECT nome, preco FROM adicionais WHERE id = ?");

            autenticarAdici.setInt(1, 1);
            ResultSet resultado = autenticarAdici.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                System.out.println("\n-------- Autenticação de Adicionais --------\n");
                System.out.println("Nome: " + nome + "\nPreço: " + preco);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao autenticar o adicional: " + erro);
        }
    }
}
