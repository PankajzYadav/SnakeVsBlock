package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Blocks extends Rectangle{
	private Label blockValue;
	private Rectangle block;
    private String type;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    private boolean dead=false;

    Blocks(int height,int width,int value, int x,int y,Color c ) {
        super(x,y,width,height);

        blockValue=new Label(Integer.toString(value));
		blockValue.setStyle("-fx-text-fill: #" + "000000;" + " -fx-font-size: " + "40");

		if(value>9) {
			blockValue.setLayoutX(x+20);
		}
		else {
			blockValue.setLayoutX(x+30);
		}
		
		blockValue.setLayoutY(y+10);

		setFill(c);
		setArcHeight(15);
		setArcWidth(15);
		setStyle("-fx-border-radius: 10 10 10 10;"+" -fx-background-radius: 10 10 10 10;");
	}

	public static ArrayList <Blocks> initializeBlock(int val) {
		ArrayList <Blocks> B= new ArrayList<Blocks>();
		for (int i=0;i<5;i++) {
			Random rand = new Random(); 
			int r = rand.nextInt(val)+1;
			Blocks b=new Blocks(80,80,r,i*80,80,Color.AQUA);
			B.add(b);
		}
		return B;
	}
    void moveDown(int i){
        setTranslateY(getTranslateY() +i);
        blockValue.setLayoutY(blockValue.getLayoutY()+i);
        if(getTranslateY()>550){
            setDead(true);
        }
    }
	public void collideBlock() {
		
	}
	public Label getBlockValue(){
        return blockValue;
    }
	public int getBlockValue2() {
		return Integer.parseInt(blockValue.getText());
	}
	public void setBlockValue(int value) {
		this.blockValue.setText(Integer.toString(value));

	}
	public Rectangle getBlock() {
		return block;
	}
	public void setBlock(Rectangle block) {
		this.block = block;
	}

}
