package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.Duration;
import java.util.Random;

public class BlockDestroyer extends ImageView {
    private Duration time;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    private boolean dead=false;

    BlockDestroyer(int x,int y){
        super(new Image("images/star.jpg", 30, 30, false, true));
        Random rand = new Random();
        int r = rand.nextInt(200) + 100;
        setLayoutX(r);
        setLayoutY(45);
    }
    public Duration getTime() {
        return time;
    }
    void moveDown(int i){
        setTranslateY(getTranslateY() +i);
        if(getTranslateY()>600){
            setDead(true);
        }
    }
    public void setTime(Duration time) {
        this.time = time;
    }
    public void initializeDestroyerBlock() {

    }
    public void collideDestroyerBlock() {

    }
}
