package application;
import java.io.Serializable;
import java.sql.Date;

public class PlayerScore implements Serializable {
	private int score;
	private String PlayerName;
	private String date;
	public PlayerScore(String string, int i, String date) {
		PlayerName=string;
		score=i;
		this.date=date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
