package toweralguipg;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import static java.lang.System.in;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TowerAlgUipg {
    
static long startTime;
static long endTime;
static long totalTime;
static Vector<Integer> NDisk = new Vector<Integer>();
static Vector<Double> RT = new Vector<Double>();
    /**
     * @param args the command line arguments
     */
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
         new plot(NDisk, RT);
         
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