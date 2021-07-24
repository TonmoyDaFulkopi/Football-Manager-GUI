package Controllers;

import Mains.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class mainMenuController {

    private Main main;

    @FXML
    private Button loginButton;

    @FXML
    private Button searchPlayerButton;

    @FXML
    private Button searchClubButton;

    @FXML
    private Button exitButton;

    @FXML
    void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void searchClubAction(ActionEvent event) {

    }

    @FXML
    void searchPlayerAction(ActionEvent event) throws IOException {
        main.showPlayerMenu();
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
