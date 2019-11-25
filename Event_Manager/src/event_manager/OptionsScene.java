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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author abhishhh1
 */

public class OptionsScene {
    public Stage stage;
    public Scene scene;
    public VBox vBox;
    public Button addPerformanceButton;
    public Button editPerformanceButton;
    public Button updateMarksButton;
    public Button showAllPerformanceButton;
    public Button logOutButton;
    public Label messageLabel;

    OptionsScene(Stage stage) {
        this.stage = stage;
        vBox = new VBox();

        addPerformanceButton = getAddPerformanceButton();
        vBox.getChildren().add(addPerformanceButton);

        editPerformanceButton = getEditPerformanceButton();
        vBox.getChildren().add(editPerformanceButton);

        updateMarksButton = getUpdateMarksButton();
        vBox.getChildren().add(updateMarksButton);

        showAllPerformanceButton = getShowAllPerformanceButton();
        vBox.getChildren().add(showAllPerformanceButton);

        logOutButton = getLogOutButton();
        vBox.getChildren().add(logOutButton);

        messageLabel = getMessageLabel();
        vBox.getChildren().add(messageLabel);

        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox, 400, 400);
    }

    public Button getAddPerformanceButton() {
        Button btn = new Button("Add performance");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddPerformanceScene addPerformanceScene = new AddPerformanceScene(stage);
                stage.setScene(addPerformanceScene.scene);
            }
        });
        return btn;
    }

    public Button getEditPerformanceButton() {
        Button btn = new Button("Edit performance");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditPerformanceScene editPerformanceScene;
                try {
                    editPerformanceScene = new EditPerformanceScene(stage);
                    stage.setScene(editPerformanceScene.scene);
                    stage.setResizable(!stage.isResizable());
                } catch (SQLException e) {
                    messageLabel.setText("Server down. Please try again later.");
                    messageLabel.setTextFill(Color.RED);
                }
            }
        });
        return btn;
    }

    public Button getUpdateMarksButton() {
        Button btn = new Button("Update marks");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    UpdateMarksScene updateMarksScene = new UpdateMarksScene(stage);
                    stage.setScene(updateMarksScene.scene);
                } catch (SQLException e) {
                    messageLabel.setText("Server down. Please try again later.");
                    messageLabel.setTextFill(Color.RED);
                }

            }
        });
        return btn;
    }

    public Button getShowAllPerformanceButton() {
        Button btn = new Button("Show all performance");
        btn.setMinWidth(100);
        btn.setMaxWidth(300);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.hide();
                try {
                    ShowAllPerformanceScene showAllPerformanceScene = new ShowAllPerformanceScene(stage);
                    stage.setScene(showAllPerformanceScene.scene);
                    stage.setResizable(!stage.isResizable());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stage.show();
            }
        });
        return btn;
    }

    public Button getLogOutButton() {
        Button btn = new Button("Logout");
        btn.setMinWidth(100);
        btn.setMaxWidth(100);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginScene loginScene = new LoginScene(stage);
                stage.setScene(loginScene.scene);
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
