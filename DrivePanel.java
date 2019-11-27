/*  Author: Carter Buckner
    project: Assignment3 - DrivePanel Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 1 October 2019 10:34 AM
*/

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrivePanel extends JPanel{
  private Auto auto;
  private int[] arr1;
  private int[] arr2;
  private int[] arr3;
  public  DrivePanel(Auto auto, int[] arr1, int[] arr2, int[] arr3){
      this.auto = auto;
      this.arr1 = arr1;
      this.arr2 = arr2;
      this.arr3 = arr3;
    }

  public void paintComponent(Graphics g){
    int[] x1_coord = new int[arr1.length];
    int[] y1_coord = new int[arr2.length];
    int[] x2_coord = new int[arr1.length];
    int[] y2_coord = new int[arr2.length];
    int newXCoord = 0;
    int newYCoord = 0;
    super.paintComponent(g);
    for(int i = 0; i < arr1.length; i++){
      if(i == 0){
      //   for first trip
        x1_coord[i] = 0;
        y1_coord[i] = getHeight();
        x2_coord[i] = arr2[i];
        y2_coord[i] = arr3[i];
      }else{
        // all other trips
        x1_coord[i] = newXCoord;
        y1_coord[i] = newYCoord;
        x2_coord[i] = arr2[i];
        y2_coord[i] = arr3[i];
      }
      // System.out.println(x1_coord[i] + " " + y1_coord[i] + " " + x2_coord[i] + " " + (getHeight() - y2_coord[i]));
      g.drawLine(x1_coord[i], y1_coord[i], x2_coord[i], (getHeight() - y2_coord[i]));
      String message = String.format("(%d,%d)", x2_coord[i], y2_coord[i]);
      g.drawString(message, x2_coord[i], (getHeight() - y2_coord[i]));

      newXCoord = x2_coord[i];
      newYCoord = (getHeight() - y2_coord[i]);
    }
    // int i = 0;
    // while(i < 10){
    //   g.drawLine(0, getHeight(), 200+(i*10), 200+(i*10));
    //   g.drawString("coordinate", 200+(i*10), 200+(i*10));
    //   i++;
    // }

  }

}
