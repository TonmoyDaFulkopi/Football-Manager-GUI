package Mains;

import Mains.Main;
import Mains.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class clubCountryController {

    Main main;

    @FXML
    private TextField clubText;

    @FXML
    private TextField countryText;

    @FXML
    private Button enterButton;

    @FXML
    private TableView<Player> table;

    @FXML
    private TableColumn<Player, String> name;

    @FXML
    private TableColumn<Player, String > country;

    @FXML
    private TableColumn<Player, Integer> age;

    @FXML
    private TableColumn<Player, Double> height;

    @FXML
    private TableColumn<Player, String> clubName;

    @FXML
    private TableColumn<Player, String> position;

    @FXML
    private TableColumn<Player, Integer> number;

    @FXML
    private TableColumn<Player, Double> salary;

    List<Player> list = new ArrayList<>();
    ObservableList<Player> oList = FXCollections.observableList(list);

    @FXML
    void enterAction(ActionEvent event) throws Exception {
        list.clear();
        String club = clubText.getText();
        String country = countryText.getText();

        list.addAll(main.searchByCC(club, country));
//        System.out.println(list.size());

        oList.removeAll();
        oList = FXCollections.observableList(list);
        System.out.println(oList.size());

        showTable();
    }

    public void showTable()
    {
        InitializeColumns();
        table.setEditable(true);
        table.setItems(oList);
        table.refresh();
    }

    public void InitializeColumns(){
        name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        clubName.setCellValueFactory(new PropertyValueFactory<Player, String>("clubName"));
        country.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
        position.setCellValueFactory(new PropertyValueFactory<Player, String>("pos"));
        height.setCellValueFactory(new PropertyValueFactory<Player, Double>("height"));
        salary.setCellValueFactory(new PropertyValueFactory<Player, Double>("weeklySalary"));
        number.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
        age.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));


    }

    public void setMain(Main main) {
        this.main = main;
    }


}
