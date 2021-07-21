package application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class CompleteAlertBox {
	
	public static void display (String title, String message) {
		//Creates the stage and makes sure the user can't click out the window
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(100);
		stage.setMinHeight(50);;
		
		//Initializing the label text for the message the window is displaying
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Arial", 20));
		
		//Initializing the close window button
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> stage.close());
		
		//Vertically aligns the label text and button
		VBox align = new VBox();
		align.getChildren().addAll(label, closeButton);
		align.setAlignment(Pos.CENTER);
		
		//Adds scene to the stage
		Scene scene = new Scene(align);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
