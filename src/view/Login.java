package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.components.Sidebar;


public class Login extends Application {
    Button btnLogin = new Button("Logar");
    public boolean senhaVisivel = false;

    @Override
    public void start(Stage janela) throws Exception {



        BorderPane mainPane = new BorderPane();

        Image imgFundo = new Image(getClass().getResourceAsStream("/view/resources/img/fundoHotel.jpg"));

        ImageView imgFundoView = new ImageView(imgFundo);
        imgFundoView.setPreserveRatio(false);
        imgFundoView.setFitWidth(500);
        imgFundoView.setFitHeight(600);

        StackPane lateralPane = new StackPane(imgFundoView);
        lateralPane.setAlignment(Pos.CENTER);
        lateralPane.setStyle("-fx-background-color: #2c3e50;");
        mainPane.setLeft(lateralPane);
        BorderPane.setAlignment(lateralPane, Pos.CENTER_LEFT);

        lateralPane.prefWidthProperty().bind(mainPane.widthProperty().divide(2));


        VBox imageFundo = new VBox(imgFundoView);
        imageFundo.setAlignment(Pos.CENTER);
        imageFundo.setStyle("-fx-background-color: #2c3e50;");
        mainPane.setLeft(imageFundo);

        Image logoHotel = new Image(getClass().getResourceAsStream("/view/resources/img/logoHotel.jpg"));
        Image email = new Image(getClass().getResourceAsStream("/view/resources/img/email-25.png"));
        Image eye_open = new Image(getClass().getResourceAsStream("/view/resources/img/senha.png"));
        Image eye_closed = new Image(getClass().getResourceAsStream("/view/resources/img/senha2.png"));


        btnLogin.setMaxWidth(125);
        String styleNormal = "-fx-background-color: #006eff; -fx-text-fill: white; -fx-font-weight: bold;";
        String styleHover = "-fx-background-color: #0055cc; -fx-text-fill: white; -fx-font-weight: bold;";

        btnLogin.setStyle(styleNormal);
        btnLogin.setOnMouseEntered(evento -> btnLogin.setStyle(styleHover));
        btnLogin.setOnMouseExited(evento -> btnLogin.setStyle(styleHover));


        ImageView iconEmail = new ImageView(email);
        iconEmail.setFitHeight(15);
        iconEmail.setFitWidth(15);

        ImageView iconEyeOpen = new ImageView(eye_open);
        iconEyeOpen.setFitHeight(15);
        iconEyeOpen.setFitWidth(15);

        ImageView iconEyeClosed = new ImageView(eye_closed);
        iconEyeClosed.setFitHeight(15);
        iconEyeClosed.setFitWidth(15);



        Label lblTitulo = new Label("Faça seu login: ");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        HBox tituloBox = new HBox(lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(20);



        Label pergunteEmail = new Label();
        pergunteEmail.setGraphic(iconEmail);
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Email");
        campoEmail.setStyle("-fx-background-color: white; -fx-background-radius: 5;");

        Label pergunteSenha = new Label();
        pergunteSenha.setGraphic(iconEyeOpen);

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");
        campoSenha.setStyle("-fx-background-color: white; -fx-background-radius: 5;");

        TextField campoSenhaTexto = new TextField();
        campoSenhaTexto.setPromptText("Digite sua senha");
        campoSenhaTexto.setVisible(false);
        campoSenhaTexto.setManaged(false);


        Button btnOlho = new Button();
        btnOlho.setGraphic(iconEyeClosed);
        btnOlho.setStyle("-fx-background-color: transparent; -fx-padding: 0; -fx-cursor: hand;");


        btnOlho.setOnAction(evento -> {

            if (senhaVisivel) {
                campoSenha.setText(campoSenhaTexto.getText());
                campoSenha.setVisible(true);
                campoSenha.setManaged(true);
                campoSenhaTexto.setVisible(false);
                campoSenhaTexto.setManaged(false);
                btnOlho.setGraphic(iconEyeOpen);
                senhaVisivel = false;

            } else {
                campoSenhaTexto.setText(campoSenha.getText());
                campoSenhaTexto.setVisible(true);
                campoSenhaTexto.setManaged(true);
                campoSenha.setVisible(false);
                campoSenha.setManaged(false);
                btnOlho.setGraphic(iconEyeClosed);
                senhaVisivel = true;
            }
        });



        String campoStyle = "-fx-background-color: white; -fx-background-radius: 5; -fx-padding: 5 30 5 5;";
        campoSenha.setStyle(campoStyle);
        campoSenhaTexto.setStyle(campoStyle);


        GridPane formGrid = new GridPane();

        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(20));
        formGrid.setStyle("-fx-background-color: #ecf0f1; -fx-background-radius: 10;");

        formGrid.add(pergunteEmail, 0, 0);
        formGrid.add(campoEmail, 1, 0);

        formGrid.add(pergunteSenha, 0, 1);
        formGrid.add(campoSenha, 1, 1);
        formGrid.add(campoSenhaTexto, 1, 1);

        formGrid.add(btnLogin, 1, 2);


        VBox layout = new VBox(10, tituloBox, formGrid);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));

        StackPane centerPane = new StackPane(layout);
        mainPane.setCenter(centerPane);

        Scene scene = new Scene(mainPane, 900, 600);
        janela.setTitle("Login");
        janela.getIcons().add(logoHotel);
        janela.setScene(scene);
        janela.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
