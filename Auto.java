/*  Author: Carter Buckner
    project: Assignment3 - Auto Class
    Course: CSCE 3193H | L. Streeter
    Last Modified: 1 October 2019 10:34 AM
*/


public class Auto{
  //private ---------------------------------------
  private String autoName;
  private int x_coordinate = 0;
  private int y_coordinate = 0;
  private GasTank gasObject;
  private Engine engineObject;
  // public ----------------------------------------
  public Auto(String autoName, int maxFuel, Engine engine){
    this.autoName = autoName;
    gasObject = new GasTank(maxFuel);
    // System.out.println("Auto constructor");
    if(engine == null){
      this.engineObject = new Engine("", 0, 0);
    }else {
      this.engineObject = engine;
    }
  }
  public String getDescription(){
    // print method
    // use &.2f to specify 2 decimal places

    String description = autoName + String.format("(Engine: %s (MPG: %d, Max speed: %d)), fuel: %.2f/%d, location: (%d,%d)"
                          , engineObject.getEngineName(), engineObject.getMPG(), engineObject.getMaxSpeed()
                          , this.getLevel(), gasObject.getCapacity(), this.getX(), this.getY()) ;
    return description;
  }
  public int getX(){
    // shows x coordinate
    return this.x_coordinate;
  }
  public int getY(){
    // shows y coodinate
    return this.y_coordinate;
  }
  public double getLevel(){
    // shows current gas level
    //format two decimal places using %.2f
    double gasLevel = gasObject.getLevel();
    return gasLevel;
  }
  public int getMPG(){
    //return Engine getMPG method
    return engineObject.getMPG();
  }
  public void fillUp(){
    /*
    fillUp() should
    cause the gas tank to be filled to its maximum capacity
    */
    int maxGasLevel = gasObject.getCapacity();
    gasObject.setLevel(maxGasLevel);
  }
  public int getMaxSpeed(){
    // return engine max speed method
    return engineObject.getMaxSpeed();
  }
  public double drive(int distance, double xRatio, double yRatio){
    // disable negative sign and factor back in later
    boolean xIsNegative = false;
    boolean yIsNegative = false;
    boolean isGasEmpty = false;
    int milesDriven = 0;

      if(xRatio < 0){
        xRatio = -(xRatio);
        xIsNegative = true;
      }
      if(yRatio < 0){
        // System.out.println("Y is negative");
        yRatio = -(yRatio);
        yIsNegative = true;
      }

      // check gas level - shorten distance traveled based on gas level
      double gasAmt = (this.getMPG()*this.getLevel());
      if(gasAmt < distance){
        System.out.printf("Ran out of gas after driving %.2f  miles\n", (gasAmt));
        distance = (int) gasAmt;
      }

      // calculate coordinates
      // true if a^2 + b^2 = c^2 and Law of Similar Triangles (xRatio/yRatio)=(xDistance/yDistance)
        int xDistance =  (int) (Math.sqrt(((xRatio*xRatio*distance*distance)/(yRatio*yRatio))/(1+((xRatio*xRatio)/(yRatio*yRatio))))) ;
        int yDistance = (int) ((yRatio*xDistance)/(xRatio));
        // handles cases where x or y is 0
        //    -the car drives full distance in direction of non-zero ratio
        if(xRatio == 0){
          xDistance = 0;
          yDistance = (int) (distance/yRatio);
        }
        if(yRatio == 0){
          xDistance = (int) (distance/xRatio);
          yDistance = 0;
        }
        // update coordinates - note: factor in negative direction
        if(yIsNegative){
          yDistance = -(yDistance);
        }
        if(xIsNegative){
          xDistance = -(xDistance);
        }
        // System.out.println(xDistance + " " + yDistance);
        this.x_coordinate = this.x_coordinate + xDistance;
        this.y_coordinate = this.y_coordinate + yDistance;

        // update gas level
        double newGasLevel = (double) (this.getLevel() - ((double) distance/this.getMPG()));
        gasObject.setLevel(newGasLevel);


      return distance;
  }
}
