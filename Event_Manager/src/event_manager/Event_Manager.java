/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author abhishhh1
 */ 
public class Event_Manager extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Foundation Day");
        LoginScene loginScene = new LoginScene(primaryStage);
        primaryStage.setScene(loginScene.scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
