package Garage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class ControllerPagamento {

    @FXML private ComboBox<Automobile> comboBoxSeleziona;
    @FXML private Text textPagamentoAvvenuto;
    @FXML private TextField textFieldMinutiPermanenza;

    public static double ricavoTotale;
    public static int conteggioMacchineTotali;

    public void initialize()
    {
       comboBoxSeleziona.setItems(ControllerAggiungiMacchina.macchine);
    }

    public void visualizzaMenu(ActionEvent event) throws IOException
    {
        Parent schermataGenitore = FXMLLoader.load(getClass().getResource("MaskMenu.fxml"));
        Scene scene1 = new Scene(schermataGenitore);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    public void paga(ActionEvent event)
    {
       try {//per arrotorndare il double

           DecimalFormat df = new DecimalFormat("#.##");

           Integer minuti = Integer.parseInt(textFieldMinutiPermanenza.getText());

           textPagamentoAvvenuto.setText("Costo ticket parcheggio : " + df.format(comboBoxSeleziona.getValue().getPrezzo() * minuti) + "€");
           //memorizzo il prezzo del ticket per avere un prezzo totale
           double prezzoTicket = (comboBoxSeleziona.getValue().getPrezzo()) * (minuti);
           ricavoTotale = ricavoTotale + prezzoTicket;
           conteggioMacchineTotali++;

           //rimuove la macchina e lo spazio aumenta di 1
           ControllerAggiungiMacchina.macchine.remove(comboBoxSeleziona.getValue());
           ControllerAggiungiMacchina.contatore--;
       }
       catch(NullPointerException e)
       {
           textPagamentoAvvenuto.setText("Non hai selezionato nessuna macchina");
       }
       catch (NumberFormatException e) {
           textPagamentoAvvenuto.setText("Inserisci i minuti!");
       }
    }
}
