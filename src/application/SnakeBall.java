package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SnakeBall extends Circle {
    private int ballValue;
    private int ballRadius;
    private String type;
    public boolean isDead() {
        return dead;
    }

    private boolean dead=false;
    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    private boolean moveLeft;

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    private boolean moveRight;

    SnakeBall(int ballValue,int ballRadius,int x,int y,String type,Color c){
        super(x,y,ballRadius, c);
        this.ballValue=ballValue;
        moveLeft=false;
        moveRight=false;
        setTranslateX(x);
        setTranslateY(y);
    }
    void moveLeft(){
        setTranslateX(getTranslateX()-10);
    }
    void moveRight(){
        setTranslateX(getTranslateX()+10);
    }
    public int getBallValue() {
        return ballValue;
    }
    public void setBallValue(int ballValue) {
        this.ballValue = ballValue;
    }
    public int getBallRadius() {
        return ballRadius;
    }
    public void setBallRadius(int ballRadius) {
        this.ballRadius = ballRadius;
    }
    public boolean getDead(){return dead;}
    public void setDead(boolean dead){this.dead=dead;}
    public void initializeBall() {

    }
    public void collideBall() {

    }
}
