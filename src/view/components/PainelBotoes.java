package view.components;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PainelBotoes extends HBox {

    public Button btnCad = new Button("Cadastro");
    public Button btnExc = new Button("Excluir");
    public Button btnAtua = new Button("Atualizar");

    Image iconBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/add.png"));
    Image iconBtnExc = new Image(getClass().getResourceAsStream("/view/resources/img/remove.png"));
    Image iconBtnAtua = new Image(getClass().getResourceAsStream("/view/resources/img/update.png"));

    public PainelBotoes() {
        ImageView viewIconCad = new ImageView(iconBtnCad);
        viewIconCad.setFitWidth(20);
        viewIconCad.setFitHeight(20);
        viewIconCad.setStyle("-fx-border-color: #08bf08");

        ImageView viewIconExc = new ImageView(iconBtnExc);
        viewIconExc.setFitWidth(20);
        viewIconExc.setFitHeight(20);
        viewIconExc.setStyle("-fx-border-color: #cf0303");

        ImageView viewIconAtua = new ImageView(iconBtnAtua);
        viewIconAtua.setFitWidth(20);
        viewIconAtua.setFitHeight(20);
        viewIconAtua.setStyle("-fx-border-color: #bfb008");

        btnCad.setGraphic(viewIconCad);
        btnExc.setGraphic(viewIconExc);
        btnAtua.setGraphic(viewIconAtua);

        setSpacing(10);
        setPadding(new Insets(0, 0, 20, 0));

        String styleButton = "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;" +
                             "-fx-cursor: hand;";

        btnCad.setStyle(styleButton);
        btnExc.setStyle(styleButton);
        btnAtua.setStyle(styleButton);

        getChildren().addAll(btnCad, btnExc, btnAtua);


    }
}
