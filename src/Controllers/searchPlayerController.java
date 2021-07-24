package Controllers;

import Mains.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class searchPlayerController {

    private Main main;

    @FXML
    private Button playerButton;

    @FXML
    private Button ccButton;

    @FXML
    private Button positionButton;

    @FXML
    private Button salaryButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    void ccAction(ActionEvent event) throws Exception {
        main.searchByCc();
    }

    @FXML
    void mainMenuAction(ActionEvent event) throws Exception {
        main.showMainMenu();
    }

    @FXML
    void playerAction(ActionEvent event) throws Exception {
        main.searchByNameMenu();
    }

    @FXML
    void positionAction(ActionEvent event) {

    }

    @FXML
    void salaryAction(ActionEvent event) {

    }
    public void setMain(Main main) {
        this.main = main;
    }

}
