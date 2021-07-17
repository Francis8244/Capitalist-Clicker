package application;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Worker {
	
	static boolean answer;
	
	public static boolean display (String title, String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(100);
		stage.setMinHeight(100);;
		
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Arial", 20));
		
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e -> {
			answer = true;
			stage.close();
		});
		
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {
			answer = false;
			stage.close();
		});
		
		VBox align = new VBox();
		align.getChildren().addAll(label, yesButton, noButton);
		align.setAlignment(Pos.BASELINE_LEFT);

		Scene scene = new Scene(align);
		stage.setScene(scene);
		stage.showAndWait();
		return answer;
	}
	
}
