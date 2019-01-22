package application;

public class Player {
	private String playerName="Player1";
	private PlayerScore playerScore[];
	private PlayerScore playerHighestScore;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public PlayerScore[] getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(PlayerScore[] playerScore) {
		this.playerScore = playerScore;
	}
	public PlayerScore getPlayerHighestScore() {
		return playerHighestScore;
	}
	public void setPlayerHighestScore(PlayerScore playerHighestScore) {
		this.playerHighestScore = playerHighestScore;
	}
	
	
	
}
