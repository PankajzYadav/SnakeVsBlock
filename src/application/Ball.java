package application;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class Ball extends Circle {
	private int ballValue;
	private int ballRadius;
	private String type;

	public boolean isDead() {
		return dead;
	}

	private boolean dead=false;
	private Label l= new Label();


	Ball(int ballValue, int ballRadius, int x, int y, String type, Color red){
		super(x,y,ballRadius,red);
		this.ballValue=ballValue;
		l= new Label(Integer.toString(10));
		l.setTranslateX(x);
		l.setTranslateY(y-25+80);
		l.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20");
		setTranslateX(x-187);
		setTranslateY(y+5+80);
	}
	void moveDown(int i){
		setTranslateY(getTranslateY() +i);
		l.setTranslateY(l.getTranslateY()+i);
		if(getTranslateY()>600){
			setDead(true);
		}
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
	public void setL(Label l) {		this.l = l;	}
	public String getType() {		return type;	}
	public void setType(String type) {		this.type = type;	}
	public Label getL() {		return l;	}

	public void initializeBall() {

	}
	public void collideBall() {

	}
}