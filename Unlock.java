package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Unlock {
	
	static boolean answer;
	
	public static boolean display (String title, String message) {
		//Creates the stage and make sure the user can't click out the window
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(100);
		stage.setMinHeight(100);;
		
		//Initializes the label with whatever title is passed into the constructor
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Arial", 20));
		
		//Initializes the yes button and changes the value of answer to true
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e -> {
			answer = true;
			stage.close();
		});
		
		//Initializes the no button and changes the value of answer to false
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {
			answer = false;
			stage.close();
		});
		
		//Vertically aligns the buttons and label
		VBox align = new VBox();
		align.getChildren().addAll(label, yesButton, noButton);
		align.setAlignment(Pos.CENTER);
		
		//Assigns the scene to the stage
		Scene scene = new Scene(align);
		stage.setScene(scene);
		stage.showAndWait();
		return answer;
	}
	
}
