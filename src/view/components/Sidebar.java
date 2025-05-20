package view.components;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Sidebar extends VBox {
    Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
    Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
    Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
    Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));
    Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));


    Font fonteRegural = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/Kanit-Regural.ttf"), 14);
    Font fonteBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/Kanit-Bold.ttf"), 16);


    public Button btnCliente = new Button("Cliente");
    public Button btnFuncionario = new Button("Funcionario");
    public Button btnQuarto = new Button("Quarto");
    public Button btnReserva = new Button("Reserva");
    public Button btnRelatorio = new Button("Relatórios");

    public Sidebar() {

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(20);
        viewIconCliente.setFitWidth(20);

        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(20);
        viewIconFuncionario.setFitWidth(20);

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(20);
        viewIconQuarto.setFitWidth(20);

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitHeight(20);
        viewIconRelatorio.setFitWidth(20);

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(20);
        viewIconReserva.setFitWidth(20);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconRelatorio);
        btnRelatorio.setGraphic(viewIconReserva);


        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #dab10e;");    //Cor

        lblMenu.setFont(Font.font(fonteBold.getFamily(), 30));

        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;" +
                             "-fx-cursor: hand;";


        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#dab10e;")));

        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));
        setMargin(lblMenu, new Insets(0, 0, 20, 0));



        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#dab10e;")));

        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));
        setMargin(lblMenu, new Insets(0, 0, 20, 0));



        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#dab10e;")));

        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));
        setMargin(lblMenu, new Insets(0, 0, 20, 0));



        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#dab10e;")));

        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));
        setMargin(lblMenu, new Insets(0, 0, 20, 0));




        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#dab10e;")));

        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));
        setMargin(lblMenu, new Insets(0, 0, 20, 0));


        setStyle("-fx-background-color: #ffffff; -fx-padding: 40px;");

        getChildren().addAll(lblMenu, btnCliente, btnFuncionario,
                btnQuarto, btnRelatorio, btnReserva);

    }
}
