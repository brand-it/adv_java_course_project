/***********************************************************************
Program Name: Routes.java
Programmer's Name: Brandt Lareau
Program Description: Application routes information
***********************************************************************/

package app;

import app.Initilization;

public class Routes {
  public static String data_path = Initilization.JAVA_ROOT + "/data";
  
  public static String images_path = Initilization.JAVA_ROOT + "/images";
  public static String icons_path = images_path + "/icons";
  public static String calculator_icon_path = icons_path + "/calculator.png";
  public static String audit_icon_path = icons_path + "/audit_trail.png";
  public static String door_out_icon_path = icons_path + "/door_out.png";
  
  public static String audits_path = data_path + "/audits.txt";
  
  public Routes() {
    
  }

}