package model;

import java.util.Date;

public class Pedidos {
    int id, cliente_id, usuario_id;
    Date data;
    String pagamento;

    public Pedidos(int cliente_id, int usuario_id, Date data, String pagamento) {
        this.data = data;
        this.pagamento = pagamento;
        this.cliente_id = cliente_id;
        this.usuario_id = usuario_id;
    }

    public int getid() {return id;}
    public int getCliente_id() {return cliente_id;}
    public int getUsuario_id() {return usuario_id;}
    public Date getData() {return data;}
    public String getPagamento() {return pagamento;}

    public void setid(int id) {this.id = id;}
    public void setCliente_id(int cliente_id) {this.cliente_id = cliente_id;}
    public void setUsuario_id(int usuario_id) {this.usuario_id = usuario_id;}
    public void setData(Date data) {this.data = data;}
    public void setPagamento(String pagamento) {this.pagamento = pagamento;}

}
