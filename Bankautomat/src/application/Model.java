package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Model {
	
	public boolean check(String pin, String eingabePin) {

		if (eingabePin.equals(pin)) {
			
			try {
				Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("GUI_Main.fxml"));
				
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return true;
		}
		else {
			Label label1 = new Label("Pin falsch!");

			Stage stage = new Stage();
			HBox root = new HBox();
			root.getChildren().add(label1);

			Scene loginBereich = new Scene(root, 400, 400);

			stage.setScene(loginBereich);
			stage.show();
		}
		return false;
	}
	
//	public double AuszahlungGui(double betrag, double saldo) {
//		
//		try {
//			Stage stage = new Stage();
//			Parent root = FXMLLoader.load(getClass().getResource("GUI_Option.fxml"));
//			
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		saldo = saldo - betrag;
//		return saldo;
//		
//	}
	
	public void PinAendernGui() {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("GUI_Option.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
}
