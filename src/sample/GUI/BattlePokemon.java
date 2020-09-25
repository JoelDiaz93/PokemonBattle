package sample.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.pokemon.Teams;

import java.util.ArrayList;

public class BattlePokemon extends Application {
    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";

    Teams teamsBattle = new Teams();

    @Override
    public void start(Stage window) {
        Score score = new Score();
        BorderPane secondScreen = new BorderPane();
        Button secondButton = new Button("Scores");
        secondButton.setStyle(Button_Style);
        secondButton.setOnMouseEntered(e -> secondButton.setStyle(Button_Style_Hover));
        secondButton.setOnMouseExited(e -> secondButton.setStyle(Button_Style));

        TextField historialAtaques = new TextField("Jugador 1: Uso garra de fuego");
        secondScreen.setCenter(secondButton);
        //BOTONES A-D-C-AF

        GridPane jugador1 = new GridPane();
        Button ataque1 = new Button("Ataque");
        Button ataqueFinal1 = new Button("Ataque Final");
        Button defensa1 = new Button("Defensa");
        Button curar1 = new Button("Curar");

        ataque1.setPrefSize(110, 25);
        curar1.setPrefSize(110, 25);
        defensa1.setPrefSize(110, 25);
        ataqueFinal1.setPrefSize(110, 25);

        jugador1.add(ataque1, 0, 0);
        jugador1.add(ataqueFinal1, 1, 0);
        jugador1.add(defensa1, 0, 1);
        jugador1.add(curar1, 1, 1);

        jugador1.setVgap(0);
        jugador1.setHgap(0);
        jugador1.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane jugador2 = new GridPane();


        Button ataque2 = new Button("Ataque");
        Button ataqueFinal2 = new Button("Ataque Final");
        Button defensa2 = new Button("Defensa");
        Button curar2 = new Button("Curar");

        ataque2.setPrefSize(110, 25);
        curar2.setPrefSize(110, 25);
        defensa2.setPrefSize(110, 25);
        ataqueFinal2.setPrefSize(110, 25);

        ArrayList<Integer> value2 = teamsBattle.getValue2();
        Label nombreJugador2 = new Label(teamsBattle.getTeam2().get(0));
        Label personajeJugador2 = new Label(teamsBattle.getTeam2().get(1));
        Label sVida = new Label("Vida:");
        Label sEstamina = new Label("Estamina:");
        TextField vida2 = new TextField(value2.get(0)+" / "+teamsBattle.getValue2().get(0));
        TextField estamina2 = new TextField(value2.get(1)+" / "+teamsBattle.getValue2().get(1));

        nombreJugador2.setFont(Font.font("Arial", 19));
        personajeJugador2.setFont(Font.font("Arial", 18));

//********************************************************************************
        GridPane gamer2 = new GridPane();
        gamer2.add(nombreJugador2, 0, 0);
        gamer2.add(personajeJugador2, 0, 1);
        gamer2.add(sVida, 0, 2);
        gamer2.add(vida2, 1, 2);
        gamer2.add(sEstamina, 0, 3);
        gamer2.add(estamina2, 1, 3);

        gamer2.setAlignment(Pos.CENTER_RIGHT);

        GridPane botones2 = new GridPane();
        botones2.add(ataque2, 0, 0);
        botones2.add(ataqueFinal2, 1, 0);
        botones2.add(defensa2, 0, 1);
        botones2.add(curar2, 1, 1);

        botones2.setPadding(new Insets(25, 5, 0, 120));

        jugador2.add(gamer2, 0, 0);
        jugador2.add(botones2, 0, 1);

        jugador2.setVgap(0);
        jugador2.setHgap(0);
        jugador2.setAlignment(Pos.BOTTOM_RIGHT);

        historialAtaques.setAlignment(Pos.BOTTOM_LEFT);

        secondScreen.setRight(jugador2);
        secondScreen.setLeft(jugador1);

        jugador1.setPadding(new Insets(5, 1, 10, 1));
        jugador2.setPadding(new Insets(5, 1, 10, 1));

        historialAtaques.setPadding(new Insets(1, 1, 30, 1));

        secondScreen.setPadding(new Insets(5, 5, 5, 5));
        secondScreen.setBottom(historialAtaques);
//----------------------------------------------------------------------------------
        //Jugadores - Vida - Estamina
        ArrayList<Integer> value1 = teamsBattle.getValue1();
        Label nombreJugador1 = new Label(teamsBattle.getTeam1().get(0));
        Label personajeJugador1 = new Label(teamsBattle.getTeam1().get(1));
        Label xVida = new Label("Vida");
        Label xEstamina = new Label("Estamina");
        TextField vida1 = new TextField(value1.get(0)+" / "+ teamsBattle.getValue1().get(0));
        TextField estamina1 = new TextField(value1.get(1)+" / "+ teamsBattle.getValue1().get(1));

        nombreJugador1.setFont(Font.font("Arial", 19));
        personajeJugador1.setFont(Font.font("Arial", 18));

        GridPane gamer1 = new GridPane();
        gamer1.add(nombreJugador1, 0, 0);
        gamer1.add(personajeJugador1, 0, 1);
        gamer1.add(xVida, 0, 2);
        gamer1.add(vida1, 1, 2);
        gamer1.add(xEstamina, 0, 3);
        gamer1.add(estamina1, 1, 3);

        secondScreen.setTop(gamer1);
//--------------------------------------------------------------------------------

        secondScreen.setPrefSize(900, 580);
        secondScreen.setStyle(BorderPane_Style);
        Scene secondScene = new Scene(secondScreen, 900, 700);
        secondScene.setFill(Color.TRANSPARENT);

        secondButton.setOnAction((ActionEvent event) -> score.start(window));

        window.setScene(secondScene);
        window.show();
    }

    public void setTeamsBattle(String player1, String pokemon1, String player2, String pokemon2){
        //this.teamsBattle = new Teams();
        this.teamsBattle.setTeam1(player1, pokemon1);
        this.teamsBattle.setTeam2(player2, pokemon2);
    }
}
