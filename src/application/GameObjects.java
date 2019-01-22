package application;
import javafx.scene.paint.Color;

public class GameObjects {
	private Coordinates GameObjects;
	private Color objectColor;
	public Coordinates getGameObjects() {
		return GameObjects;
	}
	public void setGameObjects(Coordinates gameObjects) {
		GameObjects = gameObjects;
	}
	public Color getObjectColor() {
		return objectColor;
	}
	public void setObjectColor(Color objectColor) {
		this.objectColor = objectColor;
	}
	
}
