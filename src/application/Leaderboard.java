package application;
import java.io.*;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Leaderboard implements Serializable {
	private static ArrayList <PlayerScore> A= new ArrayList <PlayerScore>();
	public Leaderboard() throws IOException {
	    /*
	    ObjectInputStream in = null;
	    try{
	        in =new ObjectInputStream((new FileInputStream("out.txt")));
	        A.add((PlayerScore) in.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
	        in.close();
        }
*/
        if(A.size()==0){
            PlayerScore P=new PlayerScore("Wolverine",300,"2/11/18");
            addScore(P);
            P=new PlayerScore("Arion",250,"2/11/18");
            addScore(P);
            P=new PlayerScore("Whiplash",200,"2/11/18");
            addScore(P);
            P=new PlayerScore("Izaya",150,"2/11/18");
            addScore(P);
            P=new PlayerScore("Avisionx",100,"2/11/18");
            addScore(P);
            P=new PlayerScore("Predator",5,"2/11/18");
            addScore(P);
        }
	}
	public static void addScore(PlayerScore P) {
		A.add(P);
	}
	public void showScores() throws IOException {
		Stage primaryStage= new Stage();
		Pane root = new Pane();
		root.setStyle("-fx-background-color: #" + "000000");
		
		Label top1 = new Label();
		top1.setText("Name");
		top1.setLayoutX(30);
		top1.setLayoutY(0);
		top1.setStyle("-fx-text-fill: #" + "00FF00;" +" -fx-font-size: " + "30");
		
		Label top2 = new Label();
		top2.setText("Score");
		top2.setLayoutX(175);
		top2.setLayoutY(0);
		top2.setStyle("-fx-text-fill: #" + "00FF00;" +" -fx-font-size: " + "30");
		
		
		Label top3 = new Label();
		top3.setLayoutX(300);
		top3.setLayoutY(0);
		top3.setText("Date");
		top3.setStyle("-fx-text-fill: #" + "00FF00;" + " -fx-font-size: " + "30");
		
		root.getChildren().addAll(top1,top2,top3);
        PlayerScore temp = new PlayerScore("1",0,"1");
		int n= A.size();

		for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (A.get(j).getScore() < A.get(j+1).getScore()){
                    temp.setPlayerName(A.get(j+1).getPlayerName());
                    temp.setScore(A.get(j+1).getScore());
                    temp.setDate(A.get(j+1).getDate());
                    A.get(j+1).setPlayerName(A.get(j).getPlayerName());
                    A.get(j+1).setScore(A.get(j).getScore());
                    A.get(j+1).setDate(A.get(j).getDate());
                    A.get(j).setPlayerName(temp.getPlayerName());
                    A.get(j).setScore(temp.getScore());
                    A.get(j).setDate(temp.getDate());
                }
        for(int i=0;i<A.size();i++) {
			Label temp1 = new Label(A.get(i).getPlayerName());
			Label temp2 = new Label(String.valueOf(A.get(i).getScore()));
			Label temp3 = new Label(A.get(i).getDate());
			temp1.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
			temp2.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
			temp3.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
			temp1.setLayoutX(30);
			temp1.setLayoutY(50*(i+1));
			temp2.setLayoutX(175);
			temp2.setLayoutY(50*(i+1));
			temp3.setLayoutX(280);
			temp3.setLayoutY(50*(i+1));
			root.getChildren().addAll(temp1,temp2,temp3);
		}
/*
        ObjectOutputStream out=null;
        try{
            out=new ObjectOutputStream((new FileOutputStream(("out.txt"))));
            out.writeObject(A);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            out.close();
        }
 */
        Scene scene = new Scene(root,420,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Transition");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
