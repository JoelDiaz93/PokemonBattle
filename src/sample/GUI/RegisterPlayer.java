package sample.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.playerRegister.InputView;
import sample.playerRegister.PlayerRegister;

public class RegisterPlayer extends Application {
    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";

    static PlayerRegister playerRegister = new PlayerRegister();

    @Override
    public void start(Stage window){
        Stage stage = new Stage();
        InputView inputView = new InputView(playerRegister);

        BorderPane layout = new BorderPane();
        layout.setCenter(inputView.getView());
        layout.setPadding(new Insets(5, 5, 5, 5));

        Scene view = new Scene(layout, 470, 500);
        window.setScene(view);
    }
}
