package util;

import controller.UsuariosController;
import dao.*;
import model.Usuario;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();

        //Usuario usuario = new Usuario("Mateus", "mateus@gmail.com", "1234", 1);
        UsuariosController usuariosController = new UsuariosController();

        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");

            try {
                //Testando a autenticação de um usuário
                usuariosController.verificarCredenciais("anarocha@gmail.com", "123");

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
