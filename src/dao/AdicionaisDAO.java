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
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir os adicionais: " + erro);
            return false;
        }
    }
}
