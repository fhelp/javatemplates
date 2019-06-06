package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	
	@FXML
	Text resultLabel;
	@FXML
	Text saldoLabel;
	
	boolean isTypingNumber = false;
	String eingabePin = "";
	String pin = "123";
	double betrag = 0;
	double saldo = 0;
	
	Model model = new Model();
	
	public void numberTapped(ActionEvent event) {
		
		String value = ((Button)event.getSource()).getText();
		
		if (isTypingNumber) {
			resultLabel.setText(resultLabel.getText() + value);
		} else {
			resultLabel.setText(value);
			isTypingNumber = true;
		}
		
	}
	
	public void AbbruchTapped(ActionEvent event) {
		System.exit(0);

	}
	


	public void BestaetigenTapped(ActionEvent event) {
		isTypingNumber = false;
		eingabePin = resultLabel.getText();
		
		model.check(pin, eingabePin);
	
		
	}
	
	public void KorrekturTapped(ActionEvent event) {
		resultLabel.setText("");
		eingabePin = "";
	}
	
	public void Auszahlungtapped(ActionEvent event) {
		
//		saldo = Double.parseDouble(saldoLabel.getText());
//		betrag = Double.parseDouble(resultLabel.getText());
//		model.Auszahlung(betrag, saldo);
		
	}
	
	public void EinzahlungTapped(ActionEvent event) {
		
	}
	
	public void PinAendernTapped(ActionEvent event) {
		model.PinAendernGui();
	}


	public void AendernTapped(ActionEvent event) {
		isTypingNumber = false;
		eingabePin = resultLabel.getText();
		pin = eingabePin;
		System.out.println(pin);
		
	}

}
