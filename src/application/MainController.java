package application;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
	public void startnewgame(ActionEvent event) throws Exception {
		GameScreen G = new GameScreen();
		Stage primaryStage= new Stage();
		G.start(primaryStage);
	}
	public void viewleaderboard(ActionEvent event) throws IOException {
		Leaderboard L = new Leaderboard();
		L.showScores();
	}
	public void exit(ActionEvent event) {
		System.exit(0);
	}
}
