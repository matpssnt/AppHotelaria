package model;

import java.util.Date;

public class Reservas {
    private int id, quarto_id, pedido_id, adicionais_id;
    private Date inicio, fim;

    public Reservas(int adicionais_id, int pedido_id, int quarto_id, Date fim, Date inicio) {
        this.fim = fim;
        this.inicio = inicio;
        this.adicionais_id = adicionais_id;
        this.pedido_id = pedido_id;
        this.quarto_id = quarto_id;
    }

    public int getid() {return id;}
    public int getquarto_id() {return quarto_id;}
    public int getpedido_id() {return pedido_id;}
    public int getAdicionais_id() {return adicionais_id;}
    public Date getInicio() {return inicio;}
    public Date getFim() {return fim;}

    public void setid(int id) {this.id = id;}
    public void setQuarto_id(int quarto_id) {this.quarto_id = quarto_id;}
    public void setPedido_id(int pedido_id) {this.pedido_id = pedido_id;}
    public void setAdicionais_id(int adicionais_id) {this.adicionais_id = adicionais_id;}
    public void setInicio(Date inicio) {this.inicio = inicio;}
    public void setFim(Date fim) {this.fim = fim;}

}
