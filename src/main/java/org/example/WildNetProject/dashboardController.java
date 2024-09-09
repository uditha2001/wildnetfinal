package org.example.WildNetProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class dashboardController  implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button community;
    private Parent newRoot;
    @FXML
    private Label username;

    public static String name;
    // Navigate to Learning Center
    public void goToLearningCenter(ActionEvent event) throws IOException {
        switchScene(event, "learningHome.fxml");
    }

    // Navigate to Game Home
    public void goToGameHome(ActionEvent event) throws IOException {
        switchScene(event, "gameHome.fxml");
    }

    // Navigate to Community Home
    public void goToCommunityHome(ActionEvent event) throws IOException {
        switchScene(event, "communityHome.fxml");
    }
    //navigate to the setting
    public void goToTheme(ActionEvent event) throws  IOException{
        switchScene(event,"theme.fxml");
    }
    // Common method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        newRoot = FXMLLoader.load(getClass().getResource(fxmlFile));
        scene = new Scene(newRoot);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
    }
    public void user(String name){
        username.setText(name);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        databaseConnection Instance=databaseConnection.getInstance();
        Connection conn=Instance.getConnection();
        community.setDisable(true);
        user(name);

    }
}
