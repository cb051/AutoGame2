/*
  Author: Carter Buckner
  project: Assignment3 - for panes/GUI
  Course: CSCE 3193H | Programming Paradigms - L. Streeter
  Last Modified: 1 October 2019 10:34
*/

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Assignment3{

  public static void main(String[] args){

    String var1 = "0";
    String var2 = "0";
    String var3 = "0";
    String autoName = "";
    int fuelCapacity = 0;
    String engineName = "";
    int MPG = 0;
    int maxSpeed = 0;
    //prompt user for info
    try{

        // set auto name
        autoName = JOptionPane.showInputDialog("Plese enter the auto's description");
        // set fuel capacity
        while(Integer.parseInt(var1) <= 0){
          var1 = JOptionPane.showInputDialog("Please enter the fuel tank capacity");
        }
        fuelCapacity = Integer.parseInt(var1);
        // set engine name
        engineName = JOptionPane.showInputDialog("Please enter engine description");
        // set MPG
        while(Integer.parseInt(var2) <= 0){
          var2 = JOptionPane.showInputDialog("Please enter miles per gallon");
        }
        MPG = Integer.parseInt(var2);
        // set max speed
        while(Integer.parseInt(var3) <= 0){
          var3 = JOptionPane.showInputDialog("Please enter the max speed");
        }
        maxSpeed = Integer.parseInt(var3);

        // set fields
        Engine engine = new Engine(engineName, MPG, maxSpeed);
        Auto auto = new Auto(autoName, fuelCapacity, engine);
        String message = auto.getDescription();
        // show details entered
        JOptionPane.showMessageDialog(null, message);

        // ask for the number of legs in the trip
        int tripLegs = 0;
        var1 = JOptionPane.showInputDialog("Please enter the number of legs on the trip");
        tripLegs = Integer.parseInt(var1);
        int distance = 0;
        double xRatio = 0.0;
        double yRatio = 0.0;

        int[] distanceArr = new int[tripLegs];
        int[] xArr = new int[tripLegs];
        int[] yArr = new int[tripLegs];

         for(int i = 0; i < tripLegs; i++){
           int currentLeg = i+1;
           String message1 = String.format("Please enter the distance for leg %d", currentLeg);
           var1 = JOptionPane.showInputDialog(message1);
           distance = Integer.parseInt(var1);
           String message2 = String.format("Please enter the x ratio for leg %d", currentLeg);
           var2 = JOptionPane.showInputDialog(message2);
           xRatio = Double.parseDouble(var2);
           String message3 = String.format("Please enter the y ratio for leg %d", currentLeg);
           var3 = JOptionPane.showInputDialog(message3);
           yRatio = Double.parseDouble(var3);


           // fill tank at beginning
           if(i == 0){
             auto.fillUp();
           }
           auto.drive(distance, xRatio, yRatio);
           // System.out.println(auto.getX() + " " + auto.getY());
           distanceArr[i] = distance;
           xArr[i] = auto.getX();
           yArr[i] = auto.getY();
           // System.out.println(distanceArr[i] + " " + xArr[i] + " " + yArr[i]);
         }

         // show window
         //create panel
         DrivePanel panel = new DrivePanel(auto, distanceArr, xArr, yArr);
         JFrame tripWindow = new JFrame();
         tripWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         tripWindow.add(panel);
         tripWindow.setSize(600, 600);
         tripWindow.setVisible(true);
         // close window when finished

   }catch(Exception e){
     JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.");
     System.exit(1);
   }
  }
}
