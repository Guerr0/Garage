package Garage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAggiungiMacchina {

    //Contenitore per tutte le macchine , che vengono aggiungte con gli eventi del bottone
    public static ObservableList<Automobile> macchine =  FXCollections.observableArrayList();
    public static int contatore=0;
    @FXML private Text textContatore;

    @FXML private Button buttonAuto;

    @FXML private Button buttonFurgone;

    @FXML private TextField textFieldInserisciTarga;

    @FXML private TextField textFieldInserisciPatente;

    @FXML private Text textStampa;

    @FXML private Button buttonRitorna;

    @FXML private Text textErrore;



    public void initialize() {
        //visualizza subito quanti posti liberi ci sono
        textContatore.setText("Posti rimanenti: " +(15-contatore));
    }

    public void visualizzaMenu(ActionEvent event) throws IOException
    {
        Parent schermataGenitore = FXMLLoader.load(getClass().getResource("MaskMenu.fxml"));
        Scene scene1 = new Scene(schermataGenitore);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    public void aggiungiAuto(ActionEvent event)
    {

            if (contatore < 15) {

                String targa;
                String numeroPatente;

                targa = textFieldInserisciTarga.getText();
                numeroPatente = textFieldInserisciPatente.getText();


                if (targa.equals("") || numeroPatente.equals("") || targa.length()!=7) {
                    textStampa.setText("Controlla targa e numero patente!");
                } else {
                    Automobile a1 = new Auto(targa, numeroPatente);
                    macchine.add(a1);

                    textStampa.setText(a1.toString());
                    contatore++;
                    textContatore.setText("Posti rimanenti: " + (15 - contatore));
                }
            } else {
                textErrore.setText("Il garage è pieno");
            }

    }


    public void aggiungiFurgone (ActionEvent event)
    {
        if (contatore < 15) {

            String targa;
            String numeroPatente;

            targa = textFieldInserisciTarga.getText();
            numeroPatente = textFieldInserisciPatente.getText();

            if (targa.equals("") || numeroPatente.equals("") || targa.length()!=7) {
                textStampa.setText("Controlla targa e numero patente!");
            } else {
                Automobile f1 = new Furgone(targa, numeroPatente);
                macchine.add(f1);

                textStampa.setText(f1.toString());
                contatore++;
                textContatore.setText("Posti rimanenti: " + (15 - contatore));
            }
        } else {
            textErrore.setText("Il garage è pieno");
        }

    }


}
