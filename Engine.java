/*  Author: Carter Buckner
    project: Assignment3 - Engine Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 1 October 2019 10:34 AM
*/
public class Engine{
  //private ---------------------------------------
  private String engineName;
  private int MPG;
  private int maxSpeed;
  //public ----------------------------------------
  public Engine(String engineType, int miles, int speedMax){
    this.setMaxSpeed(speedMax);
    this.setMPG(miles);
    this.setEngineName(engineType);
  }
  public int getMaxSpeed(){
    // shows Max speed of engine/auto
    return this.maxSpeed;
  }
  public int getMPG(){
    // shows MPG
    return this.MPG;
  }
  public String getEngineName(){
    // shows name of engine i.e. V6
    return this.engineName;
  }
  public String getDescription(){
    // print method
    String description = " " + this.engineName +
                        " (MPG: " + this.MPG +
                        ", Max speed: " + this.maxSpeed + ")";
    return description;
  }
  public void setMaxSpeed(int speed){
    if(speed < 0){
      this.maxSpeed = 0;
    }else{
        this.maxSpeed = speed;
    }
  }
  public void setMPG(int mpg){
    if(mpg < 0){
      this.MPG = 0;
    }else{
      this.MPG = mpg;
    }
  }
  public void setEngineName(String name){
    if(name.length() == 0){
      this.engineName = " Generic Engine ";
    }else{
      this.engineName = name;
    }
  }
}
