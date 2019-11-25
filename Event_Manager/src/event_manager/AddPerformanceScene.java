/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author abhishhh1
 */

public class AddPerformanceScene {
    public Stage stage;
    public Scene scene;
    public VBox vBox;
    public Label performanceIdLabel, noOfMembersLabel, batchYearLabel, performanceTypeLabel, messageLabel;
    public TextField performanceIdTextField, noOfMembersTextField, batchYearTextField, performanceTypeTextField;
    public Button addButton, goBackButton;


    public AddPerformanceScene(Stage stage) {
        this.stage = stage;
        vBox = new VBox();

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

        addButton = getAddButton();
        goBackButton = getGoBackButton();
        messageLabel = getMessageLabel();
        vBox.getChildren().addAll(addButton, goBackButton, messageLabel);

        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox, 400, 600);
    }

    public Label getPerformanceIdLabel() {
        Label lbl = new Label("Performance id :");
        return lbl;
    }

    public Label getNoOfMembersLabel() {
        Label lbl = new Label("Number of members :");
        return lbl;
    }

    public Label getBatchYearLabel() {
        Label lbl = new Label("Batch year :");
        return lbl;
    }

    public Label getPerformanceTypeLabel() {
        Label lbl = new Label("Performance type :");
        return lbl;
    }

    public Label getMessageLabel() {
        Label lbl = new Label("");
        return lbl;
    }

    public TextField getPerformanceIdTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public TextField getNoOfMembersTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public TextField getBatchYearTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public TextField getPerformanceTypeTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public Button getAddButton() {
        Button btn = new Button("Add");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String performanceId = performanceIdTextField.getText();
                int noOfMembers = Integer.parseInt(noOfMembersTextField.getText());
                int batchYear = Integer.parseInt(batchYearTextField.getText());
                String performanceType = performanceTypeTextField.getText();
                try {
                    if (FoundationDayDatabase.PerformanceTable.getPerformance(performanceId) == null) {
                        FoundationDayDatabase.PerformanceTable.addPerformance(performanceId, noOfMembers, batchYear, performanceType);
                        clearAll();
                        messageLabel.setText("Performance successfully added.");
                        messageLabel.setTextFill(Color.BLUE);
                    } else {
                        messageLabel.setText("Failed. Performance id already exists.");
                        messageLabel.setTextFill(Color.RED);
                    }
                } catch (SQLException e) {
                    messageLabel.setText("Invalid entries. Please try again.");
                    messageLabel.setTextFill(Color.RED);
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
                stage.setScene(new OptionsScene(stage).scene);
            }
        });
        return btn;
    }


    public void clearAll() {
        performanceIdTextField.clear();
        noOfMembersTextField.clear();
        batchYearTextField.clear();
        performanceTypeTextField.clear();
        messageLabel.setText("");
    }

}
