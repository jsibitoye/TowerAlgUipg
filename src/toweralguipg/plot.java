/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toweralguipg;

import static java.lang.System.in;
import java.util.Scanner;
import java.util.Vector;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static javax.management.Query.*;
/**
 *
 * @author j
 */
public class plot extends Application{

    static long startTime;
    static long endTime;
    static long totalTime;
    static Vector<Integer> NDisk = new Vector<Integer>();
    static Vector<Double> RT = new Vector<Double>();

//    plot(Vector<Integer> NDisk, Vector<Double> RT) throws Exception {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//       this.NDisk = NDisk;
//       this.RT = RT;
//       start(new Stage());
//    }

    @Override
    public void start(Stage stage) throws Exception {
       init(stage);

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init(Stage stage) {
        
        HBox root = new HBox();
        Scene scene = new Scene(root,450,330);
        
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("N = number of Disks");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Runtime (millieconds");
        
        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis,yAxis);
        lineChart.setTitle("Tower of Hanoi Chart");
        
        XYChart.Series<Number, Number> data = new XYChart.Series<>(); 
        long h = 8;
        for (int i = RT.size()-1; i>=0; i--){
            Number NDiskNum = (Number)NDisk.get(i);
            Number RTNum = (Number)RT.get(i);
            data.getData().add(new XYChart.Data<Number, Number> (NDiskNum,RTNum));
        }
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        
        stage.setTitle("LineChart By Group 31");
        stage.setScene(scene);
        stage.show();
        
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner s = new Scanner(in);
        System.out.print("Enter number of Iteration:");
         int ite = s.nextInt();
         if(ite !=0)
          for(int i= ite; i>0 ; i--){
        //Get intput for how many disks to use
        System.out.print("Enter number of disks:");
        //Output instructions to solve the problem
        int n = s.nextByte();
        startTime = System.nanoTime();
        moveTower(n, 1, 3);
        endTime   = System.nanoTime();
        System.out.println("rTime :" + startTime +" and "+ endTime + " is " + (double)(endTime-startTime)/1000000000);
        NDisk.add(n);
        RT.add((double)(endTime-startTime)/1000000000);
          }
         System.out.println(RT);
         launch  (args);
         
        }

    public static void moveTower(int n, int start, int finish) {
        //The helper peg
        int intermediate;
        //n of the disk is 1
        if (n == 1) {
            //Output the instruction
            System.out.println("Move disk " + n + " from " + retrieveNode(start) + " to " + retrieveNode(finish) + ".");
        } 
        //n of the disk is greater than 1
        else {
            //Determine the helper peg
            intermediate = 6 - (start + finish);
            //Move all but one disk from start to intermediate
            moveTower(n - 1, start, intermediate);
            //Output the instruction
            System.out.println("Move disk " + n + " from " + retrieveNode(start) + " to " + retrieveNode(finish) + ".");
            //Move the remaining disks from intermediate to finish
            moveTower(n - 1, intermediate, finish);
        }
    }
    
    private static String retrieveNode(Integer get) {
        
                String Node ="";
        switch(get) {
                                        case 1:Node = "A";
                                          break;
                                        case 2: Node ="B";
                                        break;
                                        case 3: Node ="C";
                                        break;
                                        case 4: Node ="D";
                                        break;
                                        case 5: Node ="E";
                                        break;
                                        case 6: Node ="F";
                                        break;
                                        case 7: Node ="G";
                                        break;
                                        case 8: Node ="H";
                                        break;
                                        case 9: Node ="I";
                                        break;
                            }
        return Node;
    }
    
}
