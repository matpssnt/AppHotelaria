package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import view.components.PainelBotoes;
import view.components.Sidebar;


public class CadQuartos extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu3 = new Sidebar();
        PainelBotoes botoes = new PainelBotoes();

        Image logoHotel = new Image(getClass().getResourceAsStream("/view/resources/img/logoHotel.jpg"));
        Image bed = new Image(getClass().getResourceAsStream("/view/resources/img/bed.png"));

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu3);

        ImageView iconBed = new ImageView(bed);
        iconBed.setFitWidth(20);
        iconBed.setFitHeight(20);


        Label lblTitulo = new Label("Cadastro de Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");

        HBox tituloBox = new HBox(iconBed, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);


        Label lblNome = new Label("Nome: ");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome");

        Label preco = new Label("Preço: ");
        TextField campoPreco = mascCampo("R$ " + "###.###.##");
        campoPreco.setPromptText("Ex: R$ 000,00");


        Label lblNumero = new Label("Numero: ");
        TextField campoNumero = mascCampo("###");
        campoNumero.setPromptText("Ex: 001");

        Label qtndCamaCasal = new Label("Cama de Casal: ");
        Spinner<Integer> camaCasal = new Spinner<>(1, 2, 1);

        Label qntdCamaSolteiro = new Label("Cama de Solteiro: ");
        Spinner<Integer> camaSolteiro = new Spinner<>(1, 2, 1);

        Label lblDisponivel = new Label("Disponivel: ");
        ComboBox<String> boxDisp = new ComboBox<>();
        boxDisp.getItems().addAll("Sim", "Não");
        boxDisp.setPromptText("Selecione");

        GridPane formGrid = new GridPane();

        formGrid.add(botoes, 1 ,6);


        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(2);
        formGrid.setVgap(10);


        formGrid.add(lblNome, 0 ,0);
        formGrid.add(campoNome, 1 ,0);

        formGrid.add(preco, 0 ,1);
        formGrid.add(campoPreco, 1 ,1);

        formGrid.add(lblNumero, 0 ,2);
        formGrid.add(campoNumero, 1 ,2);

        formGrid.add(qtndCamaCasal, 0 ,3);
        formGrid.add(camaCasal, 1 ,3);

        formGrid.add(qntdCamaSolteiro, 0 ,4);
        formGrid.add(camaSolteiro, 1 ,4);

        formGrid.add(lblDisponivel, 0 ,5);
        formGrid.add(boxDisp, 1 ,5);


        VBox layout = new VBox(10, tituloBox, formGrid);
        mainPane.setCenter(layout);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 900, 550);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(logoHotel);
        janela.setScene(scene);
        janela.show();
    }

    private TextField mascCampo(String masc){
        TextField txtMasc = new TextField();
        txtMasc.textProperty().addListener((observable, oldValue, newValue) -> {
            String valor = newValue.replaceAll("[^0-9]", "");
            StringBuilder formtCampo = new StringBuilder();
            int i = 0;

            for (char caracter : masc.toCharArray()) {
                if (caracter == '#') {
                    if (i < valor.length()) {
                        formtCampo.append(valor.charAt(i));
                        i++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formtCampo.append(caracter);
                }
            }

            txtMasc.setText(formtCampo.toString());
        });

        return txtMasc;
    };


    public static void main(String[] args) {
        launch(args);
    }
}

