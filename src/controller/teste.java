package controller;

import model.Cliente;

public class teste {
    private model.Cliente model;
    private view.CadCliente view;

    public teste(model.Cliente model, view.CadCliente view) {
        this.model = model;
        this.view = view;
    }
    public void vizualizar() {
        view.mostrarClientes(model.getNome(), model.getEmail(), model.getCpf());
    }






}
