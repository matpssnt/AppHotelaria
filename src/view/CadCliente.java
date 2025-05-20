package view; //Package view (classes que, quando executadas, interagem com o usuário)

import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe VBox: é um dos tipos de layouts
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PainelBotoes bottons = new PainelBotoes();

        //Carregar Imagem
        Image logoHotel = new Image(getClass().getResourceAsStream("/view/resources/img/logoHotel.jpg"));
        Image userMan = new Image(getClass().getResourceAsStream("/view/resources/img/userMan.png"));


        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);



        ImageView iconUserMan = new ImageView(userMan);
        iconUserMan.setFitWidth(20);
        iconUserMan.setFitHeight(20);



        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");


        HBox tituloBox = new HBox(iconUserMan, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);


        Label pergunteNome = new Label("Nome: ");
        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome");

        Label perguntarCPF = new Label("CPF: ");
        TextField campoCPF = criarMascaraCampo("###.###.###-##");
        campoCPF.setPromptText("Ex: 000.000.000-00");

        Label pergunteEmail = new Label("Email: ");
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Ex: andrereynerperetto@gmail.com");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione: ");

        Label pergunteTelefone = new Label("Telefone: ");
        TextField campoTelefone = criarMascaraCampo("(##) #####-####");
        campoTelefone.setPromptText("Ex: (00) 12345-6789");



        GridPane formGrid = new GridPane();
        formGrid.add(bottons, 1, 8);

        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(2);
        formGrid.setVgap(10);

        formGrid.add(pergunteNome, 0, 0);
        formGrid.add(campoNome, 1, 0);

        formGrid.add(perguntarCPF, 0, 1);
        formGrid.add(campoCPF, 1, 1);

        formGrid.add(pergunteEmail, 0, 2);
        formGrid.add(campoEmail, 1, 2);
        formGrid.add(boxEmail, 2, 2);

        formGrid.add(pergunteTelefone, 0, 3);
        formGrid.add(campoTelefone, 1, 3);




        VBox layout = new VBox(10, tituloBox, formGrid);
        mainPane.setCenter(layout);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 900, 550);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(logoHotel);
        janela.setScene(scene);
        janela.show();
    }

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;

            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }

                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }

            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }


    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
    public void mostrarClientes(String nome,String email, String cpf){
        System.out.println("Nome: " + nome + "CPF: " + cpf + "\n" + "Email: " + email);
    }
}
