import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.animation.*;
import javafx.util.Duration;
import java.security.SecureRandom;
import javafx.event.*;
public class BeanGame extends Application{//U10416038 °¨¹Å¨}
	int count;
	@Override  // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Pane pane = new Pane();		    //Create a pane
		Polyline side = new Polyline(); //Create polyline
		side.getPoints().addAll(210.0,50.0,210.0,90.0,110.0,300.0,110.0,360.0,350.0,360.0,350.0,300.0,250.0,90.0,250.0,50.0);//draw the polyline
		side.setFill(Color.WHITE);		//paint white the shape of polyline
		pane.getChildren().add(side);	//add polyline to pane
	
		Line line[] = new Line[7];		//Create the lines
		for(int i = 0;i<7;i++){//add lines to pane
			line[i] = new Line(140.0+(i*30.0),300.0,140.0+(i*30.0),360.0);
			pane.getChildren().add(line[i]);
		}
	
		Circle circle[]=new Circle[28];//Create the circles
		for(int i = 0;i<28;i++){//Add circles to pane
			if(i>=0&&i<=6){
				circle[i]=new Circle(140.0+(i*30.0),290.0,5.0);
			}if(i>=7&&i<=12){
				circle[i]=new Circle(155.0+((i-7)*30.0),260.0,5.0);
			}if(i>=13&&i<=17){
				circle[i]=new Circle(170.0+((i-13)*30.0),230.0,5.0);
			}if(i>=18&&i<=21){
				circle[i]=new Circle(185.0+((i-18)*30.0),200.0,5.0);
			}if(i>=22&&i<=24){
				circle[i]=new Circle(200.0+((i-22)*30.0),170.0,5.0);
			}if(i>=25&&i<=26){
				circle[i]=new Circle(215.0+((i-25)*30.0),140.0,5.0);
			}if(i==27){
				circle[i]=new Circle(230.,110.0,5.0);
			}
			pane.getChildren().add(circle[i]);
		}
	
		Button btPlay = new Button("Play");//Button to allow user to start the Game
        	btPlay.setLayoutX(180d);
		btPlay.setLayoutY(360d);
        	btPlay.setPrefSize(100, 20);
        	pane.getChildren().add(btPlay);
        
        	Label counter = new Label("You have thrown "+count+" beans");//Label to show How many bean you have thrown
        	counter.setLayoutX(0);
        	counter.setLayoutY(0);
        	pane.getChildren().add(counter);
		
		Label eachCounter[] = new Label[8];//Labels to show How many balls in each part of the bottom
        	int[] eachCount = new int[8];
        	for(int i = 0;i<8;i++) {
			eachCount[i] = 0;
			eachCounter[i] = new Label(String.valueOf(eachCount[i]));
			eachCounter[i].setLayoutX(120 + i*30);
			eachCounter[i].setLayoutY(330);
			pane.getChildren().add(eachCounter[i]);
        	}
		
		btPlay.setOnAction(new EventHandler<ActionEvent>() {//Button Function
		@Override // Override the handle method
		public void handle(ActionEvent e) {
			Timeline timeline = new Timeline();
                	SecureRandom srand = new SecureRandom();
                	int[] change=new int[7];
                	for(int i = 0;i<7;++i) {
				change[i] = (srand.nextInt(2)==0) ? 1 : -1 ;
                	}
                	Circle circle = new Circle(230d,50d,5);             
                	circle.setFill(Color.rgb(srand.nextInt(256), srand.nextInt(256), srand.nextInt(256)));
                	pane.getChildren().add(circle);
                	timeline.getKeyFrames().addAll(
                        	new KeyFrame(new Duration(300),
                        	  new KeyValue(circle.translateXProperty(), 0),
                        	  new KeyValue(circle.translateYProperty(), 55)),
                		new KeyFrame(new Duration(450),
                        	  new KeyValue(circle.translateXProperty(), change[0]*9),
                        	  new KeyValue(circle.translateYProperty(), 85)),
                        	new KeyFrame(new Duration(600),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15),
                        	  new KeyValue(circle.translateYProperty(), 85)),
                        	new KeyFrame(new Duration(750),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*9),
                        	  new KeyValue(circle.translateYProperty(), 85)),
                		new KeyFrame(new Duration(900),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*9),
                        	  new KeyValue(circle.translateYProperty(), 115)),
                        	new KeyFrame(new Duration(1050),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*9),
                        	  new KeyValue(circle.translateYProperty(), 115)),
                        	new KeyFrame(new Duration(1200),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15),
                        	  new KeyValue(circle.translateYProperty(), 145)),
                        	new KeyFrame(new Duration(1350),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*9),
                        	  new KeyValue(circle.translateYProperty(), 145)),
                        	new KeyFrame(new Duration(1500),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15),
                        	  new KeyValue(circle.translateYProperty(), 175)),
                        	new KeyFrame(new Duration(1650),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*9),
                        	  new KeyValue(circle.translateYProperty(), 175)),
                        	new KeyFrame(new Duration(1800),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*15),
                        	  new KeyValue(circle.translateYProperty(), 205)),
                        	new KeyFrame(new Duration(1950),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*15+change[5]*9),
                        	  new KeyValue(circle.translateYProperty(), 205)), 
                        	new KeyFrame(new Duration(2100),
                        	 new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*15+change[5]*15),
                        	 new KeyValue(circle.translateYProperty(), 235)),
                        	new KeyFrame(new Duration(2250),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15
                                  +change[4]*15+change[5]*15+change[6]*9),
                        	  new KeyValue(circle.translateYProperty(), 235)),
                        	new KeyFrame(new Duration(2400),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*15+change[5]*15+change[6]*15),
                        	  new KeyValue(circle.translateYProperty(), 270)),
                        	new KeyFrame(new Duration(2600),
                        	  new KeyValue(circle.translateXProperty(), change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*15+change[5]*15+change[6]*15),
                        	  new KeyValue(circle.translateYProperty(), 300))
                	);
                	
                switch(change[0]*15+change[1]*15+change[2]*15+change[3]*15+change[4]*15+change[5]*15+change[6]*15) {
                    case -105:
                        eachCounter[0].setText(String.valueOf(++eachCount[0]));
                        break;
                    case -75:
                        eachCounter[1].setText(String.valueOf(++eachCount[1]));
                        break;
                    case -45:
                        eachCounter[2].setText(String.valueOf(++eachCount[2]));
                        break;
                    case -15:
                        eachCounter[3].setText(String.valueOf(++eachCount[3]));
                        break;
                    case 15:
                        eachCounter[4].setText(String.valueOf(++eachCount[4]));
                        break;
                    case 45:
                        eachCounter[5].setText(String.valueOf(++eachCount[5]));
                        break;
                    case 75:
                        eachCounter[6].setText(String.valueOf(++eachCount[6]));
                        break;
                    case 105:
                        eachCounter[7].setText(String.valueOf(++eachCount[7]));
                        break;
                }
                
                count++;
                counter.setText("You have thrown "+count+" beans");
                timeline.play();
            }
        });
        
	Scene scene = new Scene(pane, 460, 380 , Color.GREY);//Set for stage and scene
    	primaryStage.setResizable(false);
    	primaryStage.setTitle("U10416038   BeanGame");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	public static void main(String[] args) {//Main method
		launch(args);
	}
}
