package dao;

import model.Roles;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RolesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargo() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novaRole = conndb.prepareStatement("INSERT INTO roles (nome) VALUES (?);");
            novaRole.setString(1, "T.I");

            int rowAffected = novaRole.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir a(s) role(s): " + erro);
            return false;
        }
    }

    public boolean atualizarCargo() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement updateRole = conndb.prepareStatement("UPDATE clientes SET nome = ? WHERE id = ?;");

            updateRole.setString(1, "");
            updateRole.setInt(2, 1);


            int rowAffected = updateRole.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar o cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCargo() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement delRoles = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            delRoles.setInt(1, 1);


            int rowAffected = delRoles.executeUpdate();
            conndb.close();
            return rowAffected > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar o cargo: " + erro);
            return false;
        }
    }
}
