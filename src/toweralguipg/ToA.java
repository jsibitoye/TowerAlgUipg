/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toweralguipg;

/**
 *
 * @author j
 */
public class ToA {
   
    
    public static void main (String []args){
    
      int n = 10;
        TowerOfHanoi(n, "A", "B", "C");
    }

    public static void TowerOfHanoi(int n, String source, String destination, String auxiliary) {
        
        if (n == 1)
        // print ("Move disk 1 from source",source,"to destination",destination)
         TowerOfHanoi(n - 1, source, auxiliary, destination);
    // print ("Move disk",n,"from source",source,"to destination",destination)
         TowerOfHanoi(n - 1, auxiliary, destination,source);
        // TowerOfHanoi(n - 1, auxiliary, destination, source);

    }
    
}
