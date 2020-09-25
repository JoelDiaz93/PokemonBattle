/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.playerRegister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.GUI.SelectPlayer;

import java.awt.event.ActionEvent;

/**
 *
 * @author Ismael
 */
public class InputView{


    private PlayerRegister playerRegister;

    public InputView(PlayerRegister playerRegister) {
        this.playerRegister = playerRegister;
    }

    public Parent getView() {
        SelectPlayer selectPlayer = new SelectPlayer();
        GridPane layout = new GridPane();

        Button remove = new Button("Eliminar");
        remove.setFont(Font.font("Arial", 19));
        remove.setMinSize(105, 40);
        Button create = new Button("Crear");
        create.setFont(Font.font("Arial", 19));
        create.setMinSize(105, 40);
        Button modify = new Button("Modificar");
        modify.setFont(Font.font("Arial", 19));
        modify.setMinSize(105, 40);
        Button anteriorView = new Button("Ir a seleccionar personajes");
        anteriorView.setFont(Font.font("Arial", 15));
        anteriorView.setMinSize(100, 35);

        Label name = new Label("Nombre: ");
        name.setFont(Font.font(15));
        Label lastName = new Label("Apellido: ");
        lastName.setFont(Font.font(15));
        Label id = new Label("Cédula: ");
        id.setFont(Font.font(15));
        Label nickname = new Label("Usuario: ");
        nickname.setFont(Font.font(15));

        TextField nameField = new TextField();
        nameField.setFont(Font.font(15));
        TextField lastNameField = new TextField();
        lastNameField.setFont(Font.font(15));
        TextField idField = new TextField();
        idField.setFont(Font.font(15));
        TextField nicknameField = new TextField();
        nicknameField.setFont(Font.font(15));


        ComboBox userIDs = new ComboBox();
        userIDs.setMinSize(255, 30);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);

        GridPane subLayout = new GridPane();
        subLayout.setVgap(5);
        subLayout.setHgap(5);
        subLayout.add(name, 0, 1);
        subLayout.add(nameField, 1, 1);
        subLayout.add(lastName, 0, 2);
        subLayout.add(lastNameField, 1, 2);
        subLayout.add(id, 0, 3);
        subLayout.add(idField, 1, 3);
        subLayout.add(nickname, 0, 4);
        subLayout.add(nicknameField, 1, 4);

        VBox subLayout1 = new VBox();
        subLayout1.setSpacing(9);
        subLayout1.getChildren().addAll(create, modify, remove);
        subLayout.add(subLayout1, 2, 1, 2, 4);

        TableView<PlayerInformation> information = new TableView<>();

        //information.setEditable(true);
        TableColumn gameIDColumn = new TableColumn("id:");
        gameIDColumn.setMinWidth(20);
        gameIDColumn.setMaxWidth(26);
        gameIDColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn nameColumn = new TableColumn("Nombre:");
        nameColumn.setMinWidth(78);
        nameColumn.setMaxWidth(85);
        nameColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn lastNameColumn = new TableColumn("Apellido:");
        lastNameColumn.setMinWidth(78);
        lastNameColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn idColumn = new TableColumn("Cédula:");
        idColumn.setMinWidth(90);
        idColumn.setMaxWidth(100);
        idColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn nicknameColumn = new TableColumn("Usuario:");
        nicknameColumn.setMinWidth(85);
        nicknameColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn victoriesColumn = new TableColumn("Victorias:");
        victoriesColumn.setMinWidth(49);
        victoriesColumn.setStyle("-fx-alignment: CENTER;");

        ObservableList<PlayerInformation> data = FXCollections.observableArrayList();
        information.setItems(data);

        lastNameColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("lastName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("name"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("nickName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("userID"));
        gameIDColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("gameID"));
        victoriesColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("victories"));

        information.getColumns().addAll(gameIDColumn, nameColumn,
                lastNameColumn, idColumn, nicknameColumn, victoriesColumn);

        layout.add(subLayout, 0, 1);
        layout.add(information, 0, 2);

        Label fieldComprobation = new Label("");
        fieldComprobation.setMinSize(50, 30);
        fieldComprobation.setFont(Font.font("Arial", 14));
        HBox fieldAndComboBox = new HBox();
        fieldAndComboBox.setSpacing(10);
        fieldAndComboBox.getChildren().addAll(userIDs, fieldComprobation);

        layout.add(fieldAndComboBox, 0, 0);

        //anteriorView.setOnAction((ActionEvent) -> selectPlayer.start(window));

        BorderPane subButton = new BorderPane();
        subButton.setCenter(anteriorView);
        layout.add(subButton, 0, 3);

        InputView.createButton(create, this.playerRegister, nameField, lastNameField, idField, nicknameField, fieldComprobation, userIDs, data);
        InputView.userIDBox(userIDs, this.playerRegister, nameField, lastNameField, idField, nicknameField);
        return layout;

    }

    public static void createButton(Button create, PlayerRegister playerRegister, TextField nameField,
            TextField lastNameField, TextField idField, TextField nicknameField, Label fieldComprobation, ComboBox userIDs, ObservableList<PlayerInformation> data) {
        create.setOnAction((event) -> {

            if (nameField.getText().equals("") || lastNameField.getText().equals("") || idField.getText().equals("")
                    || nicknameField.getText().equals("")) {
                fieldComprobation.setText("Algún campo vacío");
            } else if (playerRegister.containsPlayer(idField.getText())) {
                fieldComprobation.setText("Cédula ya ingresada!");
            } else {
                PlayerInformation newPlayer = new PlayerInformation(idField.getText(), nameField.getText(),
                        lastNameField.getText(), nicknameField.getText());

                playerRegister.addPlayer(newPlayer.getUserID(), newPlayer);

                userIDs.getItems().add(newPlayer.getUserID());
                userIDs.setValue(newPlayer.getUserID());
                data.add(newPlayer);

                nameField.clear();
                lastNameField.clear();
                nicknameField.clear();
                idField.clear();
                fieldComprobation.setText("     Éxito!");
            }
        });
    }

    public static void userIDBox(ComboBox userIDs, PlayerRegister playerRegister, TextField nameField,
            TextField lastNameField, TextField idField, TextField nicknameField) {
        userIDs.setOnAction((event) -> {
            nameField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getName());
            lastNameField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getLastName());
            idField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getUserID());
            nicknameField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getNickName());
        });
    }

//    public static void modifyButton(Button modify) {
//
//    }
//
//    public static void removeButton(Button remove) {
//
//    }
}
