package controller;

import dao.UsuariosDAO;
import model.Usuario;

public class UsuariosController {

    private final UsuariosDAO usuariosDao;

    /*Construtor para inicializar objeto UsuarriosController();
    Ao inicializá-lo, o construtor de UsuariosDAO() será executado, o que significa
    que a camada de Controle estará verificando se os parâmetros necessários foram
    informados para que sejam enviados ás requisicões (packege DAO)*/
    public UsuariosController() {
        this.usuariosDao = new UsuariosDAO();
    }

    /*Método para verificar se os parâmetros necessários para autenticação estão
    presentes, não podem ser vazios ou nulos; se estiverem presentes, um novo
    objeto de Usuarios é inicializado*/
    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        Usuario usuario = new Usuario("", email, senha, 0);
        return usuariosDao.autenticarUsuario(usuario);
    }
}
