package view;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadUsuario extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu2 = new Sidebar();
        PainelBotoes buttons = new PainelBotoes();


        Image logoHotel = new Image(getClass().getResourceAsStream("/view/resources/img/logoHotel.jpg"));
        Image userMan = new Image(getClass().getResourceAsStream("/view/resources/img/cracha.png"));
        Image password = new Image(getClass().getResourceAsStream("/view/resources/img/senha.png"));



        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu2);



        ImageView iconUserMan = new ImageView(userMan);
        iconUserMan.setFitWidth(20);
        iconUserMan.setFitHeight(20);

        ImageView iconPassword = new ImageView(password);
        iconPassword.setFitWidth(20);
        iconPassword.setFitHeight(20);


        Label lblTitulo = new Label("Cadastro de Funcionários");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");


        HBox tituloBox = new HBox(iconUserMan, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);


        Label pergunteNome = new Label("Nome: ");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome");

        Label perguntarSenha = new Label("Senha: ");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        Label pergunteEmail = new Label("Email: ");
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Ex: andrereynerperetto@gmail.com");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione: ");

        Label pergunteSetor = new Label("Setor: ");
        ComboBox<String> boxSetor = new ComboBox<>();
        boxSetor.getItems().addAll("Gerência","Hospedagem", "Limpeza", "Recepcionista", "Camareira", "Segurança", "T.I", "Alimentos e Bebidas");
        boxSetor.setPromptText("Selecione: ");


        GridPane formGrid = new GridPane();

        formGrid.add(buttons, 1 ,4);


        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(2);
        formGrid.setVgap(10);


        formGrid.add(pergunteNome, 0 ,0);
        formGrid.add(campoNome, 1 ,0);

        formGrid.add(perguntarSenha, 0 ,1);
        formGrid.add(campoSenha, 1 ,1);
        formGrid.add(iconPassword, 2, 1);


        formGrid.add(pergunteEmail, 0 ,2);
        formGrid.add(campoEmail, 1 ,2);
        formGrid.add(boxEmail, 2 ,2);

        formGrid.add(pergunteSetor, 0 ,3);
        formGrid.add(boxSetor, 1 ,3);




        VBox layout = new VBox(10, tituloBox, formGrid);
        mainPane.setCenter(layout);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 900, 550);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(logoHotel);
        janela.setScene(scene);
        janela.show();

    }

    private TextField mascCampo() {
        TextField passwordField = new TextField();
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                // Mantém o valor real em uma propriedade separada
                passwordField.setUserData((passwordField.getUserData() == null ? "" : passwordField.getUserData()) +
                        newValue.substring(oldValue.length()));

                // Exibe asteriscos
                passwordField.setText("*".repeat(newValue.length()));
            }
        });
        return passwordField;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

