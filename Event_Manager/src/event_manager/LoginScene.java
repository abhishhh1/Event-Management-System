/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

import event_manager.FoundationDayDatabase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 *
 * @author abhishhh1
 */
public class LoginScene {
    public Stage stage;
    public Scene scene;
    public VBox vBox;
    public Label loginIdLabel, passwordLabel, messageLabel;
    public TextField loginIdTextField;
    public PasswordField passwordPasswordField;
    public Button loginButton, registerButton;

    public LoginScene(Stage stage) {
        this.stage = stage;
        vBox = new VBox();

        loginIdLabel = getLoginIdLabel();
        loginIdTextField = getLoginIdTextField();
        vBox.getChildren().addAll(loginIdLabel, loginIdTextField);


        passwordLabel = getPasswordLabel();
        passwordPasswordField = getPasswordPasswordField();
        vBox.getChildren().addAll(passwordLabel, passwordPasswordField);

        loginButton = getLoginButton();
        registerButton = getRegisterButton();
        vBox.getChildren().addAll(loginButton, registerButton);

        messageLabel = getMessageLabel();
        vBox.getChildren().addAll(messageLabel);

        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox, 800, 800);
    }

    public Label getLoginIdLabel() {
        Label lbl = new Label("Enter login id :");
        lbl.setAlignment(Pos.CENTER_LEFT);
        return lbl;
    }

    public Label getPasswordLabel() {
        Label lbl = new Label("Enter password :");
        lbl.setAlignment(Pos.CENTER_LEFT);
        return lbl;
    }

    public Label getMessageLabel() {
        Label lbl = new Label("");
        lbl.setAlignment(Pos.CENTER_LEFT);
        return lbl;
    }

    public TextField getLoginIdTextField() {
        TextField tf = new TextField();
        tf.setMinWidth(100);
        tf.setMaxWidth(200);
        return tf;
    }

    public PasswordField getPasswordPasswordField() {
        PasswordField pf = new PasswordField();
        pf.setMinWidth(100);
        pf.setMaxWidth(200);
        return pf;
    }

    public Button getLoginButton() {
        Button btn = new Button("Login");
        btn.setMinWidth(100);
        btn.setMaxWidth(200);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!isValidLoginId(loginIdTextField.getText())) {
                    messageLabel.setText("Invalid login id format.");
                    messageLabel.setTextFill(Color.RED);
                    return;
                } else if (!isValidPassword(passwordPasswordField.getText())) {
                    messageLabel.setText("Invalid password format");
                    messageLabel.setTextFill(Color.RED);
                    return;
                }
                try {
                    if (checkDetails()) {
                        OptionsScene optionsScene = new OptionsScene(stage);
                        optionsScene.messageLabel.setText("Login successful.");
                        optionsScene.messageLabel.setTextFill(Color.BLUE);
                        stage.setScene(optionsScene.scene);
                    } else {
                        messageLabel.setText("Login id/password wrong. Please try again.");
                        messageLabel.setTextFill(Color.RED);
                    }
                } catch (SQLException e) {
                    messageLabel.setText("Server down. Please try again later.");
                    messageLabel.setTextFill(Color.RED);
                } finally {
                    clearAll();
                }
            }

            public boolean checkDetails() throws SQLException {
                String loginId = loginIdTextField.getText();
                String password = passwordPasswordField.getText();
                return FoundationDayDatabase.JudgeTable.checkJudge(loginId, password);
            }
        });
        return btn;
    }

    public Button getRegisterButton() {
        Button btn = new Button("Register");
        btn.setMinWidth(100);
        btn.setMaxWidth(200);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!isValidLoginId(loginIdTextField.getText())) {
                    messageLabel.setText("Invalid email format.");
                    messageLabel.setTextFill(Color.RED);
                    return;
                } else if (!isValidPassword(passwordPasswordField.getText())) {
                    messageLabel.setText("Invalid password format");
                    messageLabel.setTextFill(Color.RED);
                    return;
                }
                String loginId = loginIdTextField.getText();
                String password = passwordPasswordField.getText();
                try {
                    if (FoundationDayDatabase.JudgeTable.getJudge(loginId) == null) {
                        FoundationDayDatabase.JudgeTable.addJudge(loginId, password);
                        messageLabel.setText("Successfully registered.");
                        messageLabel.setTextFill(Color.BLUE);
                    } else {
                        messageLabel.setText("Registration failed. User already exists.");
                        messageLabel.setTextFill(Color.RED);
                    }
                } catch (SQLException e) {
                    messageLabel.setText("Server down. Please try again later.");
                    messageLabel.setTextFill(Color.RED);
                } finally {
                    clearAll();
                }
            }

        });
        return btn;
    }

    public void clearAll() {
        loginIdTextField.clear();
        passwordPasswordField.clear();
    }

    public boolean isValidLoginId(String email) {
        return Pattern.matches("^(.+)@(.+)$", email);
    }

    public boolean isValidPassword(String password) {
        return Pattern.matches("(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{7,}", password);
    }
}

