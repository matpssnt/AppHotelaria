package dao;

import model.Roles;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RolesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargos() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novaRole = conndb.prepareStatement("INSERT INTO roles (nome) VALUES (?);");
            novaRole.setString(1, "T.I");

            int rowAffected = novaRole.executeUpdate();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir a(s) role(s): " + erro);
            return false;
        }
    }
}
