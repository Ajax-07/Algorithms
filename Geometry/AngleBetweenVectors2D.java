/**
 * This file shows you how to find the smaller of the two
 * angles between two vectors in R2
 *
 * Time Complexity: O(1)
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 **/

import static java.lang.Math.*;

public class AngleBetweenVectors2D {
  
  // Return the smaller of the two angles between two 2D vectors in radians
  static double angleBetweenVectors(double v1x, double v1y,
                                    double v2x, double v2y) {
    
    // To determine the angle between two vectors v1 and v2 we can use
    // the following formula: dot(v1,v2) = len(v1)*len(v2)*cosθ and solve
    // for θ where dot(a,b) is the dot product and len(c) is the length of c.
    double dotproduct = (v1x*v2x) + (v1y*v2y);
    double v1Length = sqrt(v1x*v1x + v1y*v1y);
    double v2Length = sqrt(v2x*v2x + v2y*v2y);

    double value = dotproduct/(v1Length*v2Length);
    
    // Double value rounding precision may lead to the value we're about to pass into 
    // the arccos function to be slightly outside its domain, so do a safety check.
    if (value <= -1.0) return PI;
    if (value >= +1.0) return 0;
    return acos(value); 

  }

  public static void main(String[] args) {
    
    System.out.println("Angle between   (0,1),   (1,0): " + angleBetweenVectors(0,1,1,0));
    System.out.println("Angle between   (0,1),  (0,-1): " + angleBetweenVectors(0,1,0,-1));
    System.out.println("Angle between   (2,0), (-1,-1): " + angleBetweenVectors(2,0,-1,-1));
    System.out.println("Angle between (-1,-1),   (2,0): " + angleBetweenVectors(-1,-1,2,0));
    System.out.println("Angle between   (5,0),   (5,0): " + angleBetweenVectors(5,0,5,0));
    System.out.println("Angle between (-1,-1),  (1,-1): " + angleBetweenVectors(-1,-1,1,-1));
    System.out.println("Angle between  (1,-1), (-1,-1): " + angleBetweenVectors(1,-1,-1,-1));
    System.out.println("Angle between  (0,-1),   (1,1): " + angleBetweenVectors(0,-1,1,1));
    System.out.println("Angle between  (-6,6),   (3,0): " + angleBetweenVectors(-6,6,3,0));
    System.out.println("Angle between  (0,-1),  (1,-1): " + angleBetweenVectors(0,-1,1,-1));
    
    int loops = 100000;
    while(loops-- > 0) {

      double v = Math.random() * 1e11;
      double angle = angleBetweenVectors(v,v,-v,-v);
      if (Double.isNaN(angle)) System.out.printf("Error: (%f,%f), (%f,%f) angle is not a number\n", v,v,-v,-v);
      angle = angleBetweenVectors(v,v,v,v);
      if (Double.isNaN(angle)) System.out.printf("Error: (%f,%f), (%f,%f) angle is not a number\n", v,v,v,v);
      
    }

  }

}












