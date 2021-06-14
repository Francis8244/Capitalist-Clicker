package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	Stage window;
	Button button;
	Button button2;
	
	Integer cash = 0;
	
	Integer seconds = 1;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		
		//Initializing gridpane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//Initializing title label
		Label titleLabel = new Label("Goal: 1 billion cash!");
		titleLabel.setFont(new Font("Arial", 17));
		GridPane.setConstraints(titleLabel, 12, 0);
		
		//Initiailizing energy label
		Label energyLabel = new Label("Energy: 100");
		energyLabel.setFont(new Font("Arial", 17));
		GridPane.setConstraints(energyLabel, 0, 0);

		//Initializing Cash Label
		Label cashLabel = new Label("Cash: 0");
		cashLabel.setFont(new Font("Arial", 17));
		GridPane.setConstraints(cashLabel, 24, 0);
		
		//Initializing lemonade image
		ImageView lemon = new ImageView("https://thumbs.dreamstime.com/b/fresh-lemonade-stand-vector-illustration-cartoon-198986802.jpg");
		lemon.setFitHeight(150);
		lemon.setFitWidth(150);
		GridPane.setConstraints(lemon, 0, 2);
		
		//Initializing lemon sell button
		Button lemonSell = new Button("Sell Lime");
		lemonSell.setOnAction(e -> {
			cash += 1;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing lemon worker button
		Button lemonWorker = new Button("Buy Worker");
		
		//Initializing HBox of lemon buttons
		HBox lemonBox = new HBox(lemonSell, lemonWorker);
		GridPane.setConstraints(lemonBox, 0, 3);

		//Initializing lawnmower image
		ImageView lawnmower = new ImageView("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9gJn8LaZUskzjbZq5cPseX3mj-pia9UDY6A&usqp=CAU");
		lawnmower.setFitHeight(150);
		lawnmower.setFitWidth(150);
		GridPane.setConstraints(lawnmower, 0, 4);
		
		//Initializing worker sell button
		Button lawnmowerSell = new Button("Mow Lawn");
		lawnmowerSell.setOnAction(e -> {
			cash += 5;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing lawnmower worker button
		Button lawnmowerWorker = new Button("Buy Worker");
		
		//Initializing HBox of lawnmower buttons
		HBox lawnmowerBox = new HBox(lawnmowerSell, lawnmowerWorker);
		GridPane.setConstraints(lawnmowerBox, 0, 5);
		
		//Initializing car wash image
		ImageView carwash = new ImageView("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTFo8-3AKTdBu9vlFssBudkgRCCxmRy_uTXw&usqp=CAU");
		carwash.setFitHeight(150);
		carwash.setFitWidth(150);
		GridPane.setConstraints(carwash, 0, 6);
		
		//Initializing carwash sell button
		Button carwashSell = new Button("Wash car");
		carwashSell.setOnAction(e -> {
			cash += 30;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing carwash worker button
		Button carwashWorker = new Button("Buy Worker");
		
		//Initializing HBox of carwash buttons
		HBox carwashBox = new HBox(carwashSell, carwashWorker);
		GridPane.setConstraints(carwashBox, 0, 7);
		
		//Initializing chocolate image
		ImageView chocolate = new ImageView("https://www.clipartkey.com/mpngs/m/30-303404_chocolate-bar-vector-png.png");
		chocolate.setFitHeight(150);
		chocolate.setFitWidth(150);
		GridPane.setConstraints(chocolate, 12, 2);
		
		//Initializing chocolate sell button
		Button chocolateSell = new Button("Sell Bars");
		chocolateSell.setOnAction(e -> {
			cash += 100;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing chocolate worker button
		Button chocolateWorker = new Button("Buy Worker");
		
		//Initializing HBox of chocolate buttons
		HBox chocolateBox = new HBox(chocolateSell, chocolateWorker);
		GridPane.setConstraints(chocolateBox, 12, 3);
		
		//Initializing stocks image
		ImageView stocks = new ImageView("https://www.pngitem.com/pimgs/m/219-2197208_transparent-profit-clipart-stocks-and-bonds-clipart-hd.png");
		stocks.setFitHeight(150);
		stocks.setFitWidth(150);
		GridPane.setConstraints(stocks, 12, 4);
		
		//Initializing stocks invest button
		Button stocksSell = new Button("Buy Stock");
		stocksSell.setOnAction(e -> {
			cash += 1250;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing stocks worker button
		Button stocksWorker = new Button("Buy Worker");
		
		//Initializing HBox of stocks buttons
		HBox stocksBox = new HBox(stocksSell, stocksWorker);
		GridPane.setConstraints(stocksBox, 12, 5);
		
		//Initializing factory image
		ImageView factory = new ImageView("https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/78144/factory-clipart-md.png");
		factory.setFitHeight(150);
		factory.setFitWidth(150);
		GridPane.setConstraints(factory, 12, 6);
		
		//Initializing factory invest button
		Button factorySell = new Button("Work Plant");
		factorySell.setOnAction(e -> {
			cash += 10000;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing factory worker button
		Button factoryWorker = new Button("Buy Worker");
		
		//Initializing HBox of factory buttons
		HBox factoryBox = new HBox(factorySell, factoryWorker);
		GridPane.setConstraints(factoryBox, 12, 7);
		
		//Initializing gold image
		ImageView gold = new ImageView("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYEeXM8xNhzsco1hwd105JoSeD0rZ5rBupoQ&usqp=CAU");
		gold.setFitHeight(150);
		gold.setFitWidth(150);
		GridPane.setConstraints(gold, 24, 2);
		
		//Initializing gold sell button
		Button goldSell = new Button("Mine Gold");
		goldSell.setOnAction(e -> {
			cash += 150000;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing gold worker button
		Button goldWorker = new Button("Buy Worker");
		
		//Initializing HBox of gold buttons
		HBox goldBox = new HBox(goldSell, goldWorker);
		GridPane.setConstraints(goldBox, 24, 3);
		
		//Initializing oil image
		ImageView oil = new ImageView("https://p.kindpng.com/picc/s/197-1970992_oil-rig-png-download-oil-rig-vector-png.png");
		oil.setFitHeight(150);
		oil.setFitWidth(150);
		GridPane.setConstraints(oil, 24, 4);
		
		//Initializing oil sell button
		Button oilSell = new Button("Extract Oil");
		oilSell.setOnAction(e -> {
			cash += 1250000;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing oil worker button
		Button oilWorker = new Button("Buy Worker");
		
		//Initializing HBox of oil buttons
		HBox oilBox = new HBox(oilSell, oilWorker);
		GridPane.setConstraints(oilBox, 24, 5);
		
		//Initializing star image
		ImageView star = new ImageView("https://www.innovationnewsnetwork.com/wp-content/uploads/2021/02/Primordial-galaxy-696x392.jpg");
		star.setFitHeight(150);
		star.setFitWidth(150);
		GridPane.setConstraints(star, 24, 6);
		
		//Initializing star sell button
		Button starSell = new Button("Mine Stars");
		starSell.setOnAction(e -> {
			cash += 8000000;
			cashLabel.setText("Cash: " + cash.toString());
		});
		
		//Intializing star worker button
		Button starWorker = new Button("Buy Worker");
		
		//Initializing HBox of star buttons
		HBox starBox = new HBox(starSell, starWorker);
		GridPane.setConstraints(starBox, 24, 7);
		
		Button complete = new Button("Complete");
		GridPane.setConstraints(complete, 26, 8);
		
		grid.getChildren().addAll(lemon, energyLabel, titleLabel, cashLabel, lemonBox, lawnmower, lawnmowerBox, carwash, carwashBox, chocolate, chocolateBox,
				stocks, stocksBox, factory, factoryBox, gold, goldBox, oil, oilBox, star, starBox, complete);
		
		Scene scene = new Scene(grid, 800, 650);
		
		primaryStage.setTitle("Get Rich!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
