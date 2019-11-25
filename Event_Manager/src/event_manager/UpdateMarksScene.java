/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

import event_manager.FoundationDayDatabase;
import event_manager.Performance;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author abhishhh1
 */
public class UpdateMarksScene {
    public Stage stage;
    public Scene scene;
    public VBox vBox;
    public TableView<Performance> performanceTableView;
    public Label performanceIdLabel, noOfMembersLabel, batchYearLabel, performanceTypeLabel, messageLabel, marks1Label, marks2Label, marks3Label;
    public TextField performanceIdTextField, noOfMembersTextField, batchYearTextField, performanceTypeTextField, marks1TextField, marks2TextField, marks3TextField;
    public Button updateButton, goBackButton;


    public UpdateMarksScene(Stage stage) throws SQLException {
        this.stage = stage;
        vBox = new VBox();

        performanceTableView = getPerformanceTableView();
        vBox.getChildren().addAll(performanceTableView);

        performanceIdLabel = getPerformanceIdLabel();
        performanceIdTextField = getPerformanceIdTextField();
        vBox.getChildren().addAll(performanceIdLabel, performanceIdTextField);

        noOfMembersLabel = getNoOfMembersLabel();
        noOfMembersTextField = getNoOfMembersTextField();
        vBox.getChildren().addAll(noOfMembersLabel, noOfMembersTextField);

        batchYearLabel = getBatchYearLabel();
        batchYearTextField = getBatchYearTextField();
        vBox.getChildren().addAll(batchYearLabel, batchYearTextField);

        performanceTypeLabel = getPerformanceTypeLabel();
        performanceTypeTextField = getPerformanceTypeTextField();
        vBox.getChildren().addAll(performanceTypeLabel, performanceTypeTextField);

        marks1Label = getMarks1Label();
        marks1TextField = getMarks1TextField();
        vBox.getChildren().addAll(marks1Label, marks1TextField);

        marks2Label = getMarks2Label();
        marks2TextField = getMarks2TextField();
        vBox.getChildren().addAll(marks2Label, marks2TextField);

        marks3Label = getMarks3Label();
        marks3TextField = getMarks3TextField();
        vBox.getChildren().addAll(marks3Label, marks3TextField);

        updateButton = getUpdateButton();
        vBox.getChildren().addAll(updateButton);

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
        tableView.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Performance p = tableView.getSelectionModel().getSelectedItem();
                performanceIdTextField.setText(p.getPerformanceId());
                noOfMembersTextField.setText(String.valueOf(p.getNoOfMembers()));
                batchYearTextField.setText(String.valueOf(p.getBatchYear()));
                performanceTypeTextField.setText(p.getPerformanceType());
                marks1TextField.setText(String.valueOf(p.getMarks1()));
                marks2TextField.setText(String.valueOf(p.getMarks2()));
                marks3TextField.setText(String.valueOf(p.getMarks3()));
                updateButton.setDisable(false);
            }
        });

        return tableView;
    }

    public Label getPerformanceIdLabel() {
        Label lbl = new Label("Performance id :");
        return lbl;
    }

    public TextField getPerformanceIdTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        tf.setDisable(true);
        return tf;
    }

    public Label getNoOfMembersLabel() {
        Label lbl = new Label("Number of members :");
        return lbl;
    }

    public TextField getNoOfMembersTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Label getBatchYearLabel() {
        Label lbl = new Label("Batch year :");
        return lbl;
    }

    public TextField getBatchYearTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Label getPerformanceTypeLabel() {
        Label lbl = new Label("Performance type :");
        return lbl;
    }

    public TextField getPerformanceTypeTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Label getMarks1Label() {
        Label lbl = new Label("Marks 1:");
        return lbl;
    }

    public TextField getMarks1TextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Label getMarks2Label() {
        Label lbl = new Label("Marks 2:");
        return lbl;
    }

    public TextField getMarks2TextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Label getMarks3Label() {
        Label lbl = new Label("Marks 3:");
        return lbl;
    }

    public TextField getMarks3TextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Button getUpdateButton() {
        Button btn = new Button("Update");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setDisable(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String performanceId = performanceIdTextField.getText();
                int marks1 = Integer.parseInt(marks1TextField.getText());
                int marks2 = Integer.parseInt(marks2TextField.getText());
                int marks3 = Integer.parseInt(marks3TextField.getText());
                try {
                    FoundationDayDatabase.PerformanceTable.updateMarks(performanceId, marks1, marks2, marks3);
                    UpdateMarksScene updateMarksScene = new UpdateMarksScene(stage);
                    updateMarksScene.messageLabel.setText("Successfully updated.");
                    stage.setScene(updateMarksScene.scene);

                } catch (SQLException e) {
                    messageLabel.setText("Server down. Please try again later.");
                }
            }
        });
        return btn;
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
        performanceIdTextField.clear();
        noOfMembersTextField.clear();
        batchYearTextField.clear();
        performanceTypeTextField.clear();
        messageLabel.setText("");
    }

}
