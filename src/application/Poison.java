package application;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Poison extends ImageView {
    public boolean isDead() {
        return dead;
    }
    Poison(int x,int y){
        super(new Image("images/Poison.jpg", 40, 40, false, true));
        Random rand = new Random();
        int r = rand.nextInt(200) + 100;
        setLayoutX(r);
        setLayoutY(y+80);
    }
    void moveDown(int i){
        setTranslateY(getTranslateY() +i);
        if(getTranslateY()>600){
            setDead(true);
        }
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    private boolean dead=false;

}
