package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/hotel";
    private static final String user = "dbaHotel";
    private static final String password = "dbaHotel123";


    public Connection conectar() {

        Connection condb = null;

        try {
            //Especifíca a rota do driver a ser carregado (JDBC para SGBD MySql)
            Class.forName(driver);

            //Inicializar o driver já carregado por meio do metodo getConnection(IP, porta, nome do banco, usuario, senha)

            condb = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            return condb;







        } catch (SQLException erro) {
            System.err.println("Erro ao conectar com o Banco de Dados!");
            erro.printStackTrace();
            return null;
    }

}