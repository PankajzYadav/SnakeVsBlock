package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet extends Rectangle {
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    boolean dead=false;
    Bullet(int x, int y){
        super(5,20,Color.GREENYELLOW);
        setTranslateX(x);
        setTranslateY(y);
    }
    void moveUp(){
        setTranslateY(getTranslateY() -10);
    }

}
