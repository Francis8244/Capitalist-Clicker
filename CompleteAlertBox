package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(100);
		stage.setMinHeight(50);;
		
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Arial", 20));
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> stage.close());
		
		VBox align = new VBox();
		align.getChildren().addAll(label, closeButton);
		align.setAlignment(Pos.CENTER);

		Scene scene = new Scene(align);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
