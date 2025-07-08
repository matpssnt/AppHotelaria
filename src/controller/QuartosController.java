package controller;

import dao.RoomsDAO;
import model.Rooms;
import model.Usuario;

public class QuartosController {
    private final RoomsDAO quartosDAO;

    public QuartosController() {
        this.quartosDAO = new RoomsDAO();
    }

    public boolean infoQuartos(String nome, String numero, Double preco, int qtd_cama_s, int qtd_cama_c, boolean disponivel) {
        Rooms room = new Rooms(nome, numero, preco, qtd_cama_s, qtd_cama_c, disponivel);
        quartosDAO.inserirQuarto(room);
        return true;
    }
}

