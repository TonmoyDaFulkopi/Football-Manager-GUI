package Mains;

import Controllers.mainMenuController;
import Controllers.newPlayerNameController;
import Controllers.searchPlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Main extends Application {

    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "players.txt";

    private Stage stage;

    public Main() throws Exception {
    }

    public static List<Player> readFromFile() throws Exception {

        List<Club> clubList = new ArrayList();
        List<Country> countryList = new ArrayList();
        List<Player> playerList = new ArrayList(); //Create List   DONE

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME)); //Open File

        int count = 0;

        while (true) {
            String line = br.readLine();    //Read Line

            if (line == null) break;

            String[] tokens = line.split(","); //Splitting

            Player player = new Player();  //A Player Object to store its data

            //Insert Data
            player.name = tokens[0];
            player.country = tokens[1];
            player.age = Integer.parseInt(tokens[2]);
            player.height = Double.parseDouble(tokens[3]);
            player.clubName = tokens[4];                //CLUB NAME SOLVE IT!!!!
            player.pos = tokens[5];
            player.number = Integer.parseInt(tokens[6]);
            player.weeklySalary = Double.parseDouble(tokens[7]);

            playerList.add(player);
        }
        br.close();

        return playerList;
    }

    public static void writeToFile(List<Player> playerList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        // var bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Player player : playerList) {
            bw.write(player.name + "," + player.country + "," + player.age + "," + player.height + "," + player.clubName + "," + player.pos + "," + player.number + "," + player.weeklySalary);
            bw.write("\n");
        }
        bw.close();
    }

    public static List<Club> readClubList(List<Player> playerList) throws Exception {
        List<Club> clubList = new ArrayList();

        //CLUB LIST
        int clubCount = 0;
        Club[] c = new Club[100];

        for (int i = 0; i < playerList.size() - 1; i++) {
            if (!(playerList.get(i).clubName).equals(playerList.get(i + 1).clubName)) {
                c[clubCount] = new Club();
                c[clubCount].name = playerList.get(i).clubName;
                c[clubCount].id = i;
                clubCount++;
            }
        }

        for (int i = 0; i < clubCount; i++) {
            clubList.add(c[i]);         //Club Insert
        }

//        Club checker
//        for(int i=0; i<clubCount; i++)
//        {
//            System.out.println(clubList.get(i).name);
//        }

        return clubList;
    }

    //COUNTRY LIST
    public static List<Country> readCountryList(List<Player> playerList) throws Exception {
        List<Country> countryList = new ArrayList();
        //COUNTRY LIST
        int countryCount = 0;
        String str = playerList.get(0).country;
        Country[] cnt = new Country[100];

        for (int i = 0; i < playerList.size() - 1; i++) {
            if (!(playerList.get(i).country).equals(playerList.get(i + 1).country)) {
                cnt[countryCount] = new Country();
                cnt[countryCount].name = playerList.get(i).country;
                cnt[countryCount].id = i;
                countryCount++;
            }
        }

        for (int i = 0; i < countryCount; i++) {
            countryList.add(cnt[i]);         //Club Insert
        }

        //Country checker
//        for(int i=0; i<countryCount; i++)
//        {
//            System.out.println(countryList.get(i).name);
//        }

        return countryList;
    }


    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showMainMenu();
    }


    List<Player> playerList = readFromFile(); //PLAYER LIST
    List<Club> clubList = readClubList(playerList); //Club List
    List<Country> countryList = readCountryList(playerList); // Country List

    public void showMainMenu() throws Exception {
        // XML Loading using FXMLLoader

        //This loader has the controller attached to it
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxmls/mainmenu.fxml"));
        Parent root = loader.load();

        // Loading the controller               (vvvv) from here the controller is called
        mainMenuController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage

        //This is the
        //Primary Stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 406, 538));
        stage.show();
    }
                                                            ////Main Menu DONE/////

    public void showPlayerMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxmls/searchplayer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchPlayerController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Menu");
        stage.setScene(new Scene(root, 406, 538));
        stage.show();
    }

                                                        ////Search Player Menu////

                                                        ////Search By PLayer Name////

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Input");
        alert.setHeaderText("Incorrect Input");
        alert.setContentText("Please Recheck your input!");
        alert.showAndWait();
    }

    public void searchByNameMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxmls/playername.fxml"));
        Parent root = loader.load();

        // Loading the controller
//        playerNameController controller = loader.getController();
        newPlayerNameController controller = loader.getController();
        controller.setMain(this);
//        controller.initializeColumns();

        // Set the primary stage
        stage.setTitle("Search By Player");
        stage.setScene(new Scene(root, 860, 600));
        stage.show();
    }

    public void searchByCc() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxmls/club&country.fxml"));
        Parent root = loader.load();

        // Loading the controller
//        playerNameController controller = loader.getController();
        clubCountryController controller = loader.getController();
        controller.setMain(this);
//        controller.initializeColumns();

        // Set the primary stage
        stage.setTitle("Search By Player");
        stage.setScene(new Scene(root, 860, 600));
        stage.show();
    }



                                                            ////METHODS!!!!!/////
    public List<Player> searchByNameMethod(String playerName) throws Exception {
        /////THE THREE LIST////
        List<Player> playerList = readFromFile(); //PLAYER LIST

        List<Player> tempList= new ArrayList<>();

        boolean found = false;
        for (Player p : playerList) {
            if (playerName.equals(p.name)) {
                tempList.add(p);
                found = true;
                break;
            }
        }
        return tempList;
    }

    public List<Player> searchByCC(String club, String country) throws Exception {
        /////THE THREE LIST////
        List<Player> playerList = readFromFile(); //PLAYER LIST
        List<Club> clubList = readClubList(playerList); //Club List
        List<Country> countryList = readCountryList(playerList); // Country List

        List<Player> tempList= new ArrayList<>();

        boolean found = false;

        for (Country c : countryList) //Country
        {
            if (country.equalsIgnoreCase(c.name))
            {
                if (club.equalsIgnoreCase("ANY"))
                {
                    for (Player p : playerList)
                    {
                        if (country.equalsIgnoreCase(p.country))
                        {
                            found = true;
                            tempList.add(p);
                            return tempList;
                        }
                    }

                } else if (!(club.equalsIgnoreCase("ANY"))) {
                    for (Player p : playerList) {
                        if (country.equalsIgnoreCase(p.country) && club.equalsIgnoreCase(p.clubName)) {
                            found = true;
                            tempList.add(p);
                            return tempList;
                        }
                    }
                }
            }

        }
        if(!found) showAlert();
//        for (Player p : playerList) {
//            if (playerName.equals(p.name)) {
//                tempList.add(p);
//                found = true;
//                break;
//            }
//        }

        return tempList;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
