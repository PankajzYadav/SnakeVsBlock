package application;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Wall extends Rectangle {
	private int wallLength;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    private boolean dead=false;
	Wall(int x,int y,int height){
        super(x,y-80,2,200);
        Random rand = new Random();
        int r = rand.nextInt(200) + 100;
        setLayoutX(r);
        setFill(Color.WHITE);
	}
    void moveDown(int i){
        setTranslateY(getTranslateY() +i);
        if(getTranslateY()>600){
            setDead(true);
        }
    }
	public int getWallLength() {
		return wallLength;
	}

	public void setWallLength(int wallLength) {
		this.wallLength = wallLength;
	}
	public void initializeWall() {
		
	}
	public void collideWall() {
		
	}
}
