package Garage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.*;
import javafx.scene.text.Text;

public class ControllerMenu 
{
	@FXML private Button buttonAggiungiMacchina;
	@FXML private Button buttonVisualizzaGarage;
	@FXML private Button buttonPagamento;
	@FXML private Button buttonResoconto;
	@FXML private Text textDatiSalvati;

	public void initialize() {}

	public void scenaAggiungiMacchina(ActionEvent event) throws IOException
	{
		Parent schermataGenitore = FXMLLoader.load(getClass().getResource("MaskAggiungiMacchina.fxml"));
		Scene scene1 = new Scene(schermataGenitore);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene1);
		window.show();

	}

	public void scenaVisualizzaGarage(ActionEvent event) throws IOException
	{

		Parent schermataGenitore = FXMLLoader.load(getClass().getResource("MaskVisualizzaGarage.fxml"));
		Scene scene2 = new Scene(schermataGenitore);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
	}

	public void scenaPagamento(ActionEvent event) throws IOException
	{
		Parent schermataGenitore = FXMLLoader.load(getClass().getResource("MaskPagamento.fxml"));
		Scene scene1 = new Scene(schermataGenitore);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene1);
		window.show();

	}

	public void stampaResoconto(ActionEvent event)
	{
		try
		{
			FileWriter wr = new FileWriter("File Resoconto.txt", true);
			PrintWriter pw = new PrintWriter(wr);

			//per arrotorndare il double
			DecimalFormat df = new DecimalFormat("#.##");

			pw.println("Macchine uscite : "+ControllerPagamento.conteggioMacchineTotali);
			pw.println("Ricavo totale : "+df.format(ControllerPagamento.ricavoTotale) + " €");
			pw.println();

			pw.close();

			textDatiSalvati.setText("Dati salvati su file!");
		}

		catch(Exception e)
		{
			System.out.println("Impossibile creare il file");
		}
	}



}
