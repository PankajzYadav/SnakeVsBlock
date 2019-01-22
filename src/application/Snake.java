package application;
import java.util.ArrayList;


import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Snake{
	private Coordinates snakeHeadPosition=new Coordinates();
	private ArrayList<SnakeBall> snake=new ArrayList<SnakeBall>();
	private int chainSize=10;
	private Color color;

    public boolean isHasPoision() {
        return hasPoision;
    }

    public void setHasPoision(boolean hasPoision) {
        this.hasPoision = hasPoision;
    }

    private boolean hasPoision=false;
    public Label getL() {
        return l;
    }

    public void setL(Label l) {
        this.l = l;
    }

    private Label l;

    public boolean isMoveForward() {
        return MoveForward;
    }

    public void setMoveForward(boolean moveForward) {
        MoveForward = moveForward;
    }

    private boolean MoveForward;
	private int snakeSpeed;
	private boolean hasShield;

    void moveLeft(){
        l.setTranslateX(l.getTranslateX()-10);
	}
    void moveRight(){
        l.setTranslateX(l.getTranslateX()+10);
	}
	public Snake(Color color, int x,int y,int chain) {
		this.color=color;
		chainSize=chain;
		snakeSpeed=2;
		snakeHeadPosition.setX(x);
		snakeHeadPosition.setY(y);
        l= new Label(Integer.toString(chain));
        l.setLayoutX(x*2-8);
        l.setLayoutY(y*2-33);
        l.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20");
        MoveForward=true;
		/*
		Label L= new Label(String.valueOf(chainSize));
		L.setStyle("-fx-text-fill: #" + "FFFFFF;" +" -fx-font-size: " + "20");
		snake.add(L);
		L.setLayoutX(snakeHeadPosition.getX()-15);
		L.setLayoutY(snakeHeadPosition.getY()-40);
		*/


		for(int i=0;i<chainSize;i++) {
			SnakeBall cir = new SnakeBall(10,10, snakeHeadPosition.getX(),snakeHeadPosition.getY()+i*10, "snake",Color.RED);
            snake.add(cir);
		}
	}
	public Coordinates getSnakeHeadPosition() {
		return snakeHeadPosition;
	}
	public void setSnakeHeadPosition(Coordinates snakeHeadPosition) {
		this.snakeHeadPosition = snakeHeadPosition;
	}
	public ArrayList<SnakeBall> getSnake() {
		return snake;
	}
	public void setSnake(ArrayList<SnakeBall> snake) {
		this.snake = snake;
	}
	public Coordinates getSnakeHeadPostition() {
		return snakeHeadPosition;
	}
	public void setSnakeHeadPostition(Coordinates snakeHeadPosition) {
		this.snakeHeadPosition = snakeHeadPosition;
	}
	public int getChainSize() {
		return chainSize;
	}
	public void setChainSize(int chainSize) {
		this.chainSize = chainSize;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSnakeSpeed() {
		return snakeSpeed;
	}
	public void setSnakeSpeed(int snakeSpeed) {
		this.snakeSpeed = snakeSpeed;
	}
	public boolean isHasShield() {
		return hasShield;
	}
	public void setHasShield(boolean hasShield) {
		this.hasShield = hasShield;
	}

	public void collide(GameObjects G) {
		
	}
	public static void move() {


	}
}