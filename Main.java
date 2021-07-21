package application;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	Stage window;
	
	public static Integer cash = 0;
	
	private Status lemonBought = new Status();
	private Status lawnBought = new Status();
	private Status carBought = new Status();
	private Status chocolateBought = new Status();
	private Status stocksBought = new Status();
	private Status factoryBought = new Status();
	private Status goldBought = new Status();
	private Status oilBought = new Status();
	private Status starsBought = new Status();

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
		GridPane.setConstraints(titleLabel, 0, 0);

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
		
		//Initializing lemon worker button
		Button lemonWorker = new Button("Buy Worker");
		lemonWorker.setOnAction(e -> {
			if (lemonBought.workerCheck() == true)
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (cash < 30)
				CompleteAlertBox.display("Broke", "You need at least 30 dollars to purchase a lemonade worker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 30;
					cashLabel.setText("Cash: " + cash.toString());
					lemonBought.setWorker();
					workTimer(1, 0.05, cashLabel);
				}
			}
		});
		
		//Initializing HBox of lemon buttons
		HBox lemonBox = new HBox(lemonSell, lemonWorker);
		GridPane.setConstraints(lemonBox, 0, 3);

		//Initializing lawnmower image
		ImageView lawnmower = new ImageView("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9gJn8LaZUskzjbZq5cPseX3mj-pia9UDY6A&usqp=CAU");
		lawnmower.setFitHeight(150);
		lawnmower.setFitWidth(150);
		GridPane.setConstraints(lawnmower, 0, 4);
		
		//Initializing lawnmower button
		Button lawnmowerSell = new Button("Mow Lawn");
		lawnmowerSell.setOnAction(e -> {
			if (lawnBought.taskCheck() == true) {
			cash += 5;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 200) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 200;
					cashLabel.setText("Cash: " + cash.toString());
					lawnBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 200 dollars to unlock this task");
		});
		
		//Initializing lawnmower worker button
		Button lawnmowerWorker = new Button("Buy Worker");
		lawnmowerWorker.setOnAction(e -> {
			if (lawnBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (lawnBought.workerCheck() == false && lawnBought.taskCheck() == false)
					CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 500)
				CompleteAlertBox.display("Broke", "You need at least 500 dollars to purchase a lawnmower worker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 500;
					cashLabel.setText("Cash: " + cash.toString());
					lawnBought.setWorker();
					workTimer(5, 0.1, cashLabel);
				}
			}
		});
		
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
			if (carBought.taskCheck() == true) {
			cash += 30;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 1500) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 1500;
					cashLabel.setText("Cash: " + cash.toString());
					carBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 1500 dollars to unlock this task");
		});
		
		//Initializing carwash worker button
		Button carwashWorker = new Button("Buy Worker");
		carwashWorker.setOnAction(e -> {
			if (carBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (carBought.workerCheck() == false && carBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 4000)
				CompleteAlertBox.display("Broke", "You need at least 4000 dollars to purchase a carwash worker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 4000;
					cashLabel.setText("Cash: " + cash.toString());
					carBought.setWorker();
					workTimer(30, 0.2, cashLabel);
				}
			}
		});
		
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
			if (chocolateBought.taskCheck() == true) {
			cash += 100;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 4000) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 4000;
					cashLabel.setText("Cash: " + cash.toString());
					chocolateBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 4000 dollars to unlock this task");
		});
		
		//Initializing chocolate worker button
		Button chocolateWorker = new Button("Buy Worker");
		chocolateWorker.setOnAction(e -> {
			if (chocolateBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (chocolateBought.workerCheck() == false && chocolateBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 12000)
				CompleteAlertBox.display("Broke", "You need at least 12000 dollars to purchase a chocolate salesman");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 12000;
					cashLabel.setText("Cash: " + cash.toString());
					chocolateBought.setWorker();
					workTimer(100, 0.4, cashLabel);
				}
			}
		});
		
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
			if (stocksBought.taskCheck() == true) {
			cash += 1250;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 20000) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 20000;
					cashLabel.setText("Cash: " + cash.toString());
					stocksBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 20000 dollars to unlock this task");
		});
		
		//Initializing stocks worker button
		Button stocksWorker = new Button("Buy Worker");
		stocksWorker.setOnAction(e -> {
			if (stocksBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (stocksBought.workerCheck() == false && stocksBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 60000)
				CompleteAlertBox.display("Broke", "You need at least 60000 dollars to purchase a stockbroker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 60000;
					cashLabel.setText("Cash: " + cash.toString());
					stocksBought.setWorker();
					workTimer(1250, 0.6, cashLabel);
				}
			}
		});
		
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
			if (factoryBought.taskCheck() == true) {
			cash += 10000;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 125000) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 125000;
					cashLabel.setText("Cash: " + cash.toString());
					factoryBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 125000 dollars to unlock this task");
		});
		
		//Initializing factory worker button
		Button factoryWorker = new Button("Buy Worker");
		factoryWorker.setOnAction(e -> {
			if (factoryBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (factoryBought.workerCheck() == false && factoryBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 250000)
				CompleteAlertBox.display("Broke", "You need at least 250000 dollars to purchase a factory worker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 250000;
					cashLabel.setText("Cash: " + cash.toString());
					factoryBought.setWorker();;
					workTimer(10000, 0.8, cashLabel);
				}
			}
		});
		
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
			if (goldBought.taskCheck() == true) {
			cash += 150000;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 150000) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 150000;
					cashLabel.setText("Cash: " + cash.toString());
					goldBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 150000 dollars to unlock this task");
		});
		
		//Initializing gold worker button
		Button goldWorker = new Button("Buy Worker");
		goldWorker.setOnAction(e -> {
			if (goldBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (goldBought.workerCheck() == false && goldBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 1000000)
				CompleteAlertBox.display("Broke", "You need at least 1000000 dollars to purchase a gold miner");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 1000000;
					cashLabel.setText("Cash: " + cash.toString());
					goldBought.setWorker();
					workTimer(150000, 1.0, cashLabel);
				}
			}
		});
		
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
			if (oilBought.taskCheck() == true) {
			cash += 1250000;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 3000000) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 3000000;
					cashLabel.setText("Cash: " + cash.toString());
					oilBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 3000000 dollars to unlock this task");
		});
		
		//Initializing oil worker button
		Button oilWorker = new Button("Buy Worker");
		oilWorker.setOnAction(e -> {
			if (oilBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (oilBought.workerCheck() == false && oilBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 10000000)
				CompleteAlertBox.display("Broke", "You need at least 10000000 dollars to purchase an oil worker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 10000000;
					cashLabel.setText("Cash: " + cash.toString());
					oilBought.setWorker();;
					workTimer(1250000, 1.0, cashLabel);
				}
			}
		});
		
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
			if (starsBought.taskCheck() == true) {
			cash += 8000000;
			cashLabel.setText("Cash: " + cash.toString());
			}
			else if (cash > 7000000) {
				boolean answer = Unlock.display("Unlock", "You have enough cash to unlock this task. Would you like to buy it?");
				if (answer == true) {
					cash -= 7000000;
					cashLabel.setText("Cash: " + cash.toString());
					starsBought.setTask();
				}
			}
			else 
				CompleteAlertBox.display("Broke",  "You need at least 7000000 dollars to unlock this task");
		});
		
		//Initializing star worker button
		Button starWorker = new Button("Buy Worker");
		starWorker.setOnAction(e -> {
			if (starsBought.workerCheck() == true) 
				CompleteAlertBox.display("Bought", "You have already purchased this worker");
			else if (starsBought.workerCheck() == false && starsBought.taskCheck() == false)
				CompleteAlertBox.display("Error", "Unlock the task before you buy the worker!");
			else if (cash < 200000000)
				CompleteAlertBox.display("Broke", "You need at least 200000000 dollars to purchase a star worker");
			else {
				boolean answer = Unlock.display("Hiring", "You have enough cash to purchase a worker. Would you like to buy one?");
				if (answer == true) {
					cash -= 200000000;
					cashLabel.setText("Cash: " + cash.toString());
					starsBought.setWorker();;
					workTimer(8000000, 1.0, cashLabel);
				}
			}
		});
		
		//Initializing HBox of star buttons
		HBox starBox = new HBox(starSell, starWorker);
		GridPane.setConstraints(starBox, 24, 7);
		
		//Initializing complete button
		Button complete = new Button("Complete");
		GridPane.setConstraints(complete, 26, 8);
		complete.setOnAction(e -> {
			if (cash < 1000000000) {
				Integer temp = (1000000000 - cash);
				String cashString = temp.toString();
				CompleteAlertBox.display("Broke", "You don't have enough money. You are " + cashString + " dollars off from one billion.");
			}
			else
				CompleteAlertBox.display("Mogul", "Congratulations! You are the richest!");
		});
		
		grid.getChildren().addAll(lemon, titleLabel, cashLabel, lemonBox, lawnmower, lawnmowerBox, carwash, carwashBox, chocolate, chocolateBox,
				stocks, stocksBox, factory, factoryBox, gold, goldBox, oil, oilBox, star, starBox, complete);
		
		Scene scene = new Scene(grid, 800, 650);
		
		//Makes title scene and initializes it with some instruction text and a button that takes you to the main game
		Text instructText = new Text(20.0, 125.0, "Welcome to the game. Your goal is to make 1 billion dollars by clicking on various different jobs that net you more money as "
				+ "you unlock them. You will also be able to hire workers to help you along your journey of becoming a billionare. When you have finally reached 1 billion "
				+ "dollars, click on the complete button on the bottom right side of the screen.");
		instructText.setWrappingWidth(490);
		Button startButton = new Button("Begin");
		startButton.setTextAlignment(TextAlignment.CENTER);
		startButton.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		VBox menuAlign = new VBox(20, instructText, startButton);
		Scene titleScene = new Scene (menuAlign, 500, 110);
		
		
		
		
		primaryStage.setTitle("Get Rich!");
		primaryStage.setScene(titleScene);
		primaryStage.show();
	}
	
	//Private helper method that sets the timers of each worker for each specific task
	private static void workTimer(int money, double time, Label cashLabel) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time), ev -> {
			cash += money;
			cashLabel.setText("Cash: " + cash.toString());
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
