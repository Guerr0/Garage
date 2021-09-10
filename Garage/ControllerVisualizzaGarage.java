package Garage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerVisualizzaGarage {

    @FXML private TableView<Automobile> tableView;
    @FXML private TableColumn<Automobile,String> colonnaTarga;
    @FXML private TableColumn<Automobile,String> colonnaPatente;
    @FXML private TableColumn<Automobile,String> colonnaTipo;
    @FXML private TableColumn<Automobile,Integer> colonnaPosto;

    public void initialize()
    {
        colonnaTarga.setCellValueFactory(new PropertyValueFactory<Automobile,String>("targa"));
        colonnaPatente.setCellValueFactory(new PropertyValueFactory<Automobile,String>("numeroPatente"));
        colonnaTipo.setCellValueFactory(new PropertyValueFactory<Automobile,String>("tipo"));
        colonnaPosto.setCellValueFactory(new PropertyValueFactory<Automobile,Integer>("posto"));

        tableView.setItems(ControllerAggiungiMacchina.macchine);
    }

    public void visualizzaMenu(ActionEvent event) throws IOException
    {
        Parent schermataGenitore = FXMLLoader.load(getClass().getResource("MaskMenu.fxml"));
        Scene scene1 = new Scene(schermataGenitore);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


}
