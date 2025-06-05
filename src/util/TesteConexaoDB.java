package util;

import dao.*;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");

            try {
                UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.inserirUsuario();
                System.out.println("Usuario inserido com sucesso!");

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirClientes();
                System.out.println("Cliente inserido com sucesso!");

                RoomsDAO roomsDAO = new RoomsDAO();
                roomsDAO.inserirQuartos();
                System.out.println("Quarto inserido com sucesso!");

                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdici();
                System.out.println("Adicional inserido com sucesso!");

                RolesDAO rolesDAO = new RolesDAO();
                rolesDAO.inserirCargos();
                System.out.println("Cargo inserido com sucesso!");


                condb.close();
                System.out.println("Conexão encerrada!");

            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }

        } else {
            System.out.println("Falha ao conectar com o banco de dados!");
        }
    }
}
