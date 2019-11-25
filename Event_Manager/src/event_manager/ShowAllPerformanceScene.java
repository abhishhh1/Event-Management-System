/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

import event_manager.FoundationDayDatabase;
import event_manager.Performance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author abhishhh1
 */
public class ShowAllPerformanceScene {
    public Stage stage;
    public Scene scene;
    public VBox vBox;
    public TableView<Performance> performanceTableView;
    public Label messageLabel;
    public Button goBackButton;

    public ShowAllPerformanceScene(Stage stage) throws SQLException {
        this.stage = stage;
        vBox = new VBox();

        performanceTableView = getPerformanceTableView();
        vBox.getChildren().addAll(performanceTableView);

        goBackButton = getGoBackButton();
        vBox.getChildren().addAll(goBackButton);

        messageLabel = getMessageLabel();
        vBox.getChildren().addAll(messageLabel);

        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox, 800, 800);
    }

    public TableView<Performance> getPerformanceTableView() throws SQLException {
        TableView<Performance> tableView = new TableView<>();

        TableColumn<Performance, String> performanceId = new TableColumn<>("Performance id");
        performanceId.setCellValueFactory(new PropertyValueFactory<>("performanceId"));
        tableView.getColumns().add(performanceId);

        TableColumn<Performance, Integer> noOfMembers = new TableColumn<>("No. of members");
        noOfMembers.setCellValueFactory(new PropertyValueFactory<>("noOfMembers"));
        tableView.getColumns().add(noOfMembers);

        TableColumn<Performance, Integer> batchYear = new TableColumn<>("Batch year");
        batchYear.setCellValueFactory(new PropertyValueFactory<>("batchYear"));
        tableView.getColumns().add(batchYear);

        TableColumn<Performance, String> performanceType = new TableColumn<>("Performance type");
        performanceType.setCellValueFactory(new PropertyValueFactory<>("performanceType"));
        tableView.getColumns().add(performanceType);

        TableColumn<Performance, Integer> marks1 = new TableColumn<>("Marks 1");
        marks1.setCellValueFactory(new PropertyValueFactory<>("marks1"));
        tableView.getColumns().add(marks1);

        TableColumn<Performance, Integer> marks2 = new TableColumn<>("Marks 2");
        marks2.setCellValueFactory(new PropertyValueFactory<>("marks2"));
        tableView.getColumns().add(marks2);

        TableColumn<Performance, Integer> marks3 = new TableColumn<>("Marks 3");
        marks3.setCellValueFactory(new PropertyValueFactory<>("marks3"));
        tableView.getColumns().add(marks3);
        
        tableView.setItems(FXCollections.observableArrayList(FoundationDayDatabase.PerformanceTable.getAllPerformance()));
        tableView.setMaxSize(800, 400);

        return tableView;
    }

    public Button getGoBackButton() {
        Button btn = new Button("Go Back");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OptionsScene optionsScene = new OptionsScene(stage);
                stage.setScene(optionsScene.scene);
            }
        });
        return btn;
    }

    public Label getMessageLabel() {
        Label lbl = new Label("");
        lbl.setTextAlignment(TextAlignment.CENTER);
        return lbl;
    }

    public void clearAll() {
        messageLabel.setText("");
    }
}

