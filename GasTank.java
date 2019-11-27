/*  Author: Carter Buckner
    project: Assignment3 - GasTank Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 1 October 2019 10:34 AM
*/
public class GasTank{
  //private ---------------------------------------
  private int maxCapacity;
  // private double currentLevel;
  private double currentCapacity;

  //public ----------------------------------------
  public GasTank(int setMaxCapacity){
      currentCapacity = 0;
    if(setMaxCapacity < 0){
      maxCapacity = 0;
    } else {
      maxCapacity = setMaxCapacity;
    }
  }
  public int getCapacity(){
    //shows max capacity
    return maxCapacity;
  }
  public double getLevel(){
    //shows current level
    return currentCapacity;
  }
  // 9.29 - added case: if user fills above capacity then it sets to max capacity
  public void setLevel(double levelIn){
    if(levelIn < 0){
      currentCapacity = 0;
    }
    if(levelIn > maxCapacity){
        currentCapacity = maxCapacity;
    }else {
      currentCapacity = levelIn;
    }
  }

}
