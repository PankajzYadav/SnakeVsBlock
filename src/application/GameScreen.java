package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.stream.Collectors;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.Block;
import jdk.nashorn.internal.ir.Labels;

import static javafx.scene.input.KeyCode.E;
import static javafx.scene.input.KeyCode.P;

public class GameScreen extends Application{
    private Pane root = new Pane();
    private Stage primaryStage;
    private Pane temproot = new Pane();
    Boolean j=false;
	private Snake playerSnake;
	private double t=0;
    private double s=0;
    private double p=0;
    private boolean gameover=false;
	private ArrayList <GameObjects> A= new ArrayList <GameObjects>();
	private ArrayList <Blocks> B= new ArrayList <Blocks>();
	private Player player=new Player();
	private int Score=0;
	private int level=1;
	int x=10;
	int y=300;

    private Parent createContent(){

        root.setPrefSize(400,500);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now){
                try{
                    update();
                }
                catch(Exception e){
                    this.stop();
                }
            }
        };
        timer.start();
        initialize();
        return root;
    }
    private void initialize(){
        playerSnake=new Snake(Color.RED,100,150,10);

        for (int i=0;i<playerSnake.getSnake().size();i++) {
            root.getChildren().add(playerSnake.getSnake().get(i));
        }
        root.getChildren().add(playerSnake.getL());
        initializeBall();
        //initializeBlock(10);
        //initializeShield();
        //initializeWall();
        //initializePoison();

    }
    private void initializePoison(){
        Poison s= new Poison(200,-20);
        root.getChildren().addAll(s);
    }
    private void initializeBlockDestroyer(){
        BlockDestroyer s= new BlockDestroyer(200,-20);
        root.getChildren().addAll(s);
    }
    private void initializeBlock(int val){
        double f= Math.random();
        if(f<0.3) {
            for (int i = 0; i < 5; i++) {
                Random rand = new Random();
                int r = rand.nextInt(val) + 1;
                Color c;
                double ff = Math.random();
                if (ff < 0.3)
                    c = Color.AQUA;
                else if (ff < 0.6)
                    c = Color.LIGHTGOLDENRODYELLOW;
                else
                    c = Color.GREEN;
                //System.out.println(ff);
                Blocks b = new Blocks(80, 80, r, i * 80, -50, c);
                root.getChildren().addAll(b, b.getBlockValue());
            }
        }
        else if(f<0.7){
            for (int i = 0; i < 5; i++) {
                Random rand = new Random();
                int r = rand.nextInt(val) + 1;
                Color c;
                double ff = Math.random();
                if (ff < 0.3)
                    c = Color.AQUA;
                else if (ff < 0.6)
                    c = Color.LIGHTGOLDENRODYELLOW;
                else
                    c = Color.GREEN;
                //System.out.println(ff);
                Blocks b = new Blocks(80, 80, r, i * 80, -50, c);
                if(i!=3 && i!=5){
                    root.getChildren().addAll(b, b.getBlockValue());
                }
            }
        }
        else{
            for (int i = 0; i < 5; i++) {
                Random rand = new Random();
                int r = rand.nextInt(val) + 1;
                Color c;
                double ff = Math.random();
                if (ff < 0.3)
                    c = Color.AQUA;
                else if (ff < 0.6)
                    c = Color.LIGHTGOLDENRODYELLOW;
                else
                    c = Color.GREEN;
                //System.out.println(ff);
                Blocks b = new Blocks(80, 80, r, i * 80, -50, c);
                if(i!=0 && i!=3){
                    root.getChildren().addAll(b, b.getBlockValue());
                }
            }
        }
    }
    private void initializeWall(){
        Wall s= new Wall(100,50,100);
        root.getChildren().addAll(s);
    }
    private void initializeBall(){
        Random rand = new Random();
        int r = rand.nextInt(10) + 1;
        for(int i=0;i<1;i++){
            Ball s= new Ball( r,10,200,0,"food",Color.RED);
            Label l=s.getL();
            root.getChildren().addAll(s,l);
        }
    }
    private void initializeShield(){
        Shield s= new Shield(100,-20);
        root.getChildren().addAll(s);
    }
    private ArrayList<Poison> poisons(){
        ArrayList<Poison> B=new ArrayList<Poison>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Poison) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<Ball> balls(){
        ArrayList<Ball> B=new ArrayList<Ball>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Ball) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<SnakeBall> snakeballs(){
        ArrayList<SnakeBall> B=new ArrayList<SnakeBall>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((SnakeBall) root.getChildren().get(i));
            }
            catch (Exception e){
            }
        }
        return B;
    }
    private ArrayList<Blocks> blocks(){
        ArrayList<Blocks> B=new ArrayList<Blocks>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Blocks) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<Shield> shields(){
        ArrayList<Shield> B=new ArrayList<Shield>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Shield) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<Wall> walls(){
        ArrayList<Wall> B=new ArrayList<Wall>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Wall) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<Bullet> bullets(){
        ArrayList<Bullet> B=new ArrayList<Bullet>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Bullet) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<BlockDestroyer> BlockDestroyers(){
        ArrayList<BlockDestroyer> B=new ArrayList<BlockDestroyer>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((BlockDestroyer) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private ArrayList<Label> labels(){
        ArrayList<Label> B=new ArrayList<Label>();
        for(int i=0;i<root.getChildren().size();i++){
            try{
                B.add((Label) root.getChildren().get(i));
            }
            catch (Exception e){

            }
        }
        return B;
    }
    private void update(){
        if(playerSnake.isMoveForward()){
            t+=0.016;
            if(playerSnake.isHasShield()){
                s+=0.016;
                if(s>10){
                    s=0;
                    playerSnake.setHasShield(false);
                    snakeballs().get(0).setFill(Color.RED);
                }
            }
            if(playerSnake.isHasPoision()){
                p+=0.016;
                if(p>10){
                    p=0;
                    playerSnake.setHasPoision(false);
                    snakeballs().get(0).setFill(Color.RED);
                }
            }
            bullets().forEach(s->{
                for(int i=0;i<blocks().size();i++) {
                    if (s.getBoundsInParent().intersects(blocks().get(i).getBoundsInParent())) {
                        blocks().get(i).setDead(true);
                        Score += blocks().get(i).getBlockValue2();
                        s.setDead(true);
                    }
                }
                s.moveUp();
                    });
            labels().forEach(s->{
                if (s.getLayoutX()==350 && s.getLayoutY()==0 && s.getStyle()=="-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30"){
                    s.setText(Integer.toString(Score));
                }
                else if(s.getLayoutX()==200 && s.getStyle()=="-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30"){
                    s.setText(Integer.toString(level));
                }
            });
            walls().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                    if(j){
                        snakeballs().get(0).setMoveLeft(true);
                        playerSnake.getSnakeHeadPosition().setX(playerSnake.getSnakeHeadPosition().getX()-10);

                        j=true;
                    }
                    else{
                        snakeballs().get(0).setMoveRight(true);
                        playerSnake.getSnakeHeadPosition().setX(playerSnake.getSnakeHeadPosition().getX()+10);

                        j=true;
                    }
                }
                else{
                    s.moveDown(playerSnake.getSnakeSpeed());
                }
            });
            shields().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                    s.setDead(true);
                    snakeballs().get(0).setFill(Color.YELLOW);
                    playerSnake.setHasShield(true);
                }
                else{
                    s.moveDown(playerSnake.getSnakeSpeed());
                }
            });
            poisons().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                    s.setDead(true);
                    snakeballs().get(0).setFill(Color.DARKOLIVEGREEN);
                    playerSnake.setHasPoision(true);
                }
                else{
                    s.moveDown(playerSnake.getSnakeSpeed());
                }
            });
            balls().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                    s.setDead(true);
                    SnakeBall b=snakeballs().get(0);
                    int x=playerSnake.getSnakeHeadPosition().getX();
                    int y=playerSnake.getSnakeHeadPosition().getY();
                    int z=(playerSnake.getSnakeHeadPosition().getX()-100)/2;
                    //System.out.println(x+" "+b.getTranslateY());
                    playerSnake.getL().setText(Integer.toString(Integer.parseInt(playerSnake.getL().getText())+Integer.parseInt(s.getL().getText())));
                    for (int i=0;i<Integer.parseInt(s.getL().getText());i++) {
                        SnakeBall n =new SnakeBall(10,10,x-z,y+(i+Integer.parseInt(playerSnake.getL().getText())-10)*10,"snake",Color.AQUA);
                        root.getChildren().add(n);
                    }
                }
                else{
                    s.moveDown(playerSnake.getSnakeSpeed());
                }
            });
            BlockDestroyers().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                s.setDead(true);
                for(int i=0;i<blocks().size();i++){
                    blocks().get(i).setDead(true);
                    Score+=blocks().get(i).getBlockValue2();
                    }
                }
            else{
                s.moveDown(playerSnake.getSnakeSpeed());
            }


            });
            blocks().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())&&s.isDead()==false){
                    if(playerSnake.isHasShield()){
                        s.setDead(true);
                        Score+=s.getBlockValue2();
                    }
                    else{

                        try{
                            if (snakeballs().get(snakeballs().size()-1).getDead()==false){
                                snakeballs().get(snakeballs().size()-1).setDead(true);
                            }
                            else if(snakeballs().get(snakeballs().size()-2).getDead()==false){
                                snakeballs().get(snakeballs().size()-2).setDead(true);
                            }
                            else if(snakeballs().get(snakeballs().size()-3).getDead()==false){
                                snakeballs().get(snakeballs().size()-3).setDead(true);
                            }
                            else{
                                snakeballs().get(snakeballs().size()-4).setDead(true);
                            }
                        }
                        finally {

                        }
                        s.setBlockValue(s.getBlockValue2()-1);
                        playerSnake.getL().setText(Integer.toString(Integer.parseInt(playerSnake.getL().getText())-1));
                        Score+=1;
                        if(s.getBlockValue2()<=0){
                            s.setDead(true);
                            playerSnake.setMoveForward(true);
                        }
                    }
                }
                else{
                    s.moveDown(playerSnake.getSnakeSpeed());
                }
            });
            for(int i=snakeballs().size()-1;i>=0;i--){
                SnakeBall s=snakeballs().get(i);

                if(s.isMoveLeft()==true){
                    if(i==0){
                        playerSnake.moveLeft();
                        playerSnake.getSnakeHeadPosition().setX(playerSnake.getSnakeHeadPosition().getX()-10);
                    }
                    s.setMoveLeft(false);
                    s.moveLeft();
                    if(i<snakeballs().size()-1){
                        snakeballs().get(i+1).setMoveLeft(true);
                    }
                    for(int ii=0;ii<walls().size();ii++){

                        if(walls().get(ii).getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                            playerSnake.moveRight();
                            s.moveRight();
                            if(ii<snakeballs().size()-1){
                                snakeballs().get(i+1).setMoveLeft(false);
                            }
                        }
                    }
                }
                if(s.isMoveRight()==true){
                    if(i==0){
                        playerSnake.moveRight();
                        playerSnake.getSnakeHeadPosition().setX(playerSnake.getSnakeHeadPosition().getX()+10);
                    }
                    s.setMoveRight(false);
                    s.moveRight();
                    if(i<snakeballs().size()-1){
                        snakeballs().get(i+1).setMoveRight(true);
                    }
                    for(int ii=0;ii<walls().size();ii++){

                        if(walls().get(ii).getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                            playerSnake.moveLeft();
                            s.moveLeft();
                            if(ii<snakeballs().size()-1){
                                snakeballs().get(i+1).setMoveRight(false);
                            }
                        }
                    }
                }
            }
            //System.out.println(level+"#####");
            if(level==1 && t>3){
                //System.out.println(t);
                initializeBall();
                initializeBlock(10);
                t=0;
                if(Score>10){
                    level++;
                }
            }
            else if(level==2 && t>3){
                //System.out.println(t);
                initializeBlock(30);
                double r=Math.random();
                if(r<0.5 && !playerSnake.isHasPoision() && !playerSnake.isHasShield()){
                    initializeShield();
                }
                else{
                    initializeBall();
                }
                t=0;
                if(Score>50){
                    level++;
                    t=0;
                }
            }
            else if(level==3 && t>3){
//                System.out.println(t);
                initializeBlock(30);
                double r=Math.random();
                if(r<0.15 && !playerSnake.isHasPoision() && !playerSnake.isHasShield()){
                    initializePoison();
                }
                else if(r<0.4){
                    initializeBlockDestroyer();
                }
                else{
                    initializeBall();
                }
                t=0;
                if(Score>400){
                    level++;
                    playerSnake.setSnakeSpeed(playerSnake.getSnakeSpeed()+1);
                    t=0;
                }
            }
            else if(level==4){
                if(t>1.5){
                    double r=Math.random();
                    if(r<0.05 && !playerSnake.isHasPoision() && !playerSnake.isHasShield()){
                        initializePoison();
                    }
                    else if(r<0.1 && !playerSnake.isHasPoision() && !playerSnake.isHasShield()){
                        initializeShield();
                    }
                    else if(r<0.3){
                        initializeWall();
                    }
                    else{
                        Random rand = new Random();
                        int rr = rand.nextInt(70) + 1;
                        initializeBlock(rr);
                    }
                    t=0;
                }
//                System.out.println(t);


            }
        }
        else{
            blocks().forEach(s->{
                if(s.getBoundsInParent().intersects(snakeballs().get(0).getBoundsInParent())){
                    try{
                        if (snakeballs().get(snakeballs().size()-1).getDead()==false){
                            snakeballs().get(snakeballs().size()-1).setDead(true);
                        }
                        else if(snakeballs().get(snakeballs().size()-2).getDead()==false){
                            snakeballs().get(snakeballs().size()-2).setDead(true);
                        }
                        else if(snakeballs().get(snakeballs().size()-3).getDead()==false){
                            snakeballs().get(snakeballs().size()-3).setDead(true);
                        }
                        else{
                            snakeballs().get(snakeballs().size()-4).setDead(true);
                        }
                    }
                    catch (Exception e){

                    }
                    s.setBlockValue(s.getBlockValue2()-1);
                    playerSnake.getL().setText(Integer.toString(Integer.parseInt(playerSnake.getL().getText())-1));
                    Score+=1;
                    if(s.getBlockValue2()<=0){
                        s.setDead(true);
                        playerSnake.setMoveForward(true);
                    }
                }
            });
        }
        if((Integer.parseInt(playerSnake.getL().getText())<=0 || snakeballs().size()==0 )&& gameover==false){
            Label pause=new Label("Game Over");
            pause.setStyle("-fx-text-fill: #" + "FF0000;" + " -fx-font-size: " + "69");
            pause.setLayoutY(100);
            pause.setLayoutX(20);
            root.setOpacity(0.7);

            Label Q=new Label("♦ Press Q to quit");
            Q.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20");
            Q.setLayoutY(280);
            Q.setLayoutX(20);
            gameover=true;
            primaryStage.close();
            playerSnake.setMoveForward(false);
            root.setOpacity(0.7);
            root.getChildren().addAll(pause,Q);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText("Your Score:"+Score);
            alert.show();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
            LocalDate localDate = LocalDate.now();
            PlayerScore P=new PlayerScore(player.getPlayerName(),Score,dtf.format(localDate));
            Leaderboard.addScore(P);
        }
        removeGameObjects();
    }
	public void removeGameObjects() {
        for(int i=0;i<root.getChildren().size();i++){
            try{
                Bullet B = (Bullet) root.getChildren().get(i);
                if(B.isDead()){
                    root.getChildren().removeAll(B);
                }
            }
            catch(Exception e){

            }
            try{
                Blocks B = (Blocks) root.getChildren().get(i);
                if(B.isDead()){
                    root.getChildren().removeAll(B,B.getBlockValue());
                }
            }
            catch (Exception e){

            }
            try{
                Ball B = (Ball) root.getChildren().get(i);
                if(B.isDead()==true){
                    root.getChildren().removeAll(B,B.getL());
                }
            }
            catch (Exception e){

            }
            try{
                SnakeBall B = (SnakeBall) root.getChildren().get(i);
                if(B.isDead()){
                    root.getChildren().remove(B);
                }
            }
            catch (Exception e){

            }
            try{
                Shield B = (Shield) root.getChildren().get(i);
                if(B.isDead()){
                    root.getChildren().removeAll(B);
                }
            }
            catch (Exception e){

            }
            try{
                Poison B = (Poison) root.getChildren().get(i);
                if(B.isDead()){
                    root.getChildren().removeAll(B);
                }
            }
            catch (Exception e){

            }
            try{
                BlockDestroyer B = (BlockDestroyer) root.getChildren().get(i);
                if(B.isDead()){
                    root.getChildren().removeAll(B);
                }
            }
            catch (Exception e){

            }
        }
	}

	public Snake getPlayerSnake() {
		return playerSnake;
	}
	public void setPlayerSnake(Snake playerSnake) {
		this.playerSnake = playerSnake;
	}
	public ArrayList<GameObjects> getA() {
		return A;
	}
	public void setA(ArrayList<GameObjects> a) {
		A = a;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		try {
			primaryStage= new Stage();
            root.setStyle("-fx-background-color: #" + "000000");
            Label sc1=new Label("Score");
            sc1.setLayoutX(250);
            sc1.setLayoutY(0);
            sc1.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
            Label sc2=new Label(String.valueOf(Score));
            sc2.setLayoutX(350);
            sc2.setLayoutY(0);
            sc2.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
            Label sc3=new Label(player.getPlayerName());
            sc3.setLayoutX(0);
            sc3.setLayoutY(0);
            sc3.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
            Label sc4=new Label("Level");
            sc4.setLayoutX(120);
            sc4.setLayoutY(0);
            sc4.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
            Label sc5=new Label(Integer.toString(level));
            sc5.setLayoutX(200);
            sc5.setLayoutY(0);
            sc5.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "30");
            root.getChildren().addAll(sc1,sc2,sc3,sc4,sc5);
            Scene scene = new Scene(createContent());
            primaryStage.setScene(scene);
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	            	switch (event.getCode()) {
	                	case A: if(playerSnake.getSnakeHeadPosition().getX()>-90){

 //                           System.out.println(playerSnake.getSnakeHeadPosition().getX()+" "+playerSnake.getSnakeHeadPosition().getY());
                            playerSnake.getSnake().get(0).setMoveLeft(true);
                        }


				                break;
		                case D:
                            if(playerSnake.getSnakeHeadPosition().getX()<290){

 //                               System.out.println(playerSnake.getSnakeHeadPosition().getX()+" "+playerSnake.getSnakeHeadPosition().getY());
                                playerSnake.getSnake().get(0).setMoveRight(true);

                            }
		                    	break;
	                    case P: if(playerSnake.isMoveForward()==true) {
	                        playerSnake.setMoveForward(false);
                            Label pause=new Label("Paused");
                            pause.setStyle("-fx-text-fill: #" + "FF0000;" + " -fx-font-size: " + "80");
                            pause.setLayoutY(100);
                            pause.setLayoutX(80);
                            Label P=new Label("♦ Press P to Resume");
                            P.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20");
                            P.setLayoutY(200);
                            P.setLayoutX(20);
                            Label R=new Label("♦ Press R for New Game");
                            R.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20");
                            R.setLayoutY(240);
                            R.setLayoutX(20);
                            Label Q=new Label("♦ Press Q to quit");
                            Q.setStyle("-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20");
                            Q.setLayoutY(280);
                            Q.setLayoutX(20);
                            root.setOpacity(0.7);
                            root.getChildren().addAll(pause,P,R,Q);


                        }
                            else{
                                playerSnake.setMoveForward(true);
                                root.setOpacity(1);
                                labels().forEach(s->{
                                    if(s.getStyle()=="-fx-text-fill: #" + "FF0000;" + " -fx-font-size: " + "80"||s.getStyle()=="-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20"){
                                        root.getChildren().remove(s);
                                    }
                                });

                            }
                             break;
                        case SPACE:if(playerSnake.isHasPoision()){
                            Bullet b=new Bullet(playerSnake.getSnakeHeadPosition().getX()+100,playerSnake.getSnakeHeadPosition().getY()+100);
                            root.getChildren().add(b);
                        }
                        case R:if(playerSnake.isMoveForward()==false){
                            playerSnake.setMoveForward(true);
                            root.setOpacity(1);
                            labels().forEach(s->{
                                if(s.getStyle()=="-fx-text-fill: #" + "FF0000;" + " -fx-font-size: " + "80"||s.getStyle()=="-fx-text-fill: #" + "FFFFFF;" + " -fx-font-size: " + "20"){
                                    root.getChildren().remove(s);
                                }
                            });
                            t=0;
                            while(root.getChildren().size()>0){
                                root.getChildren().remove(0);
                            }

                            initialize();
                            gameover=false;

                        }

                            break;
                        case Q:if(playerSnake.isMoveForward()==false || gameover==true){
                            primaryStage.close();
                        }
                            break;
						default:
								break;	
	
	                }
	            	/*
	            	try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
	            	
	            }
	        });

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Snake Vs Block");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}