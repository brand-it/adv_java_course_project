/***********************************************************************
Program Name: Audit.java
Programmer's Name: Brandt Lareau
Program Description: Audit History
***********************************************************************/
package panels;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

import app.Routes;

public class Audit extends JPanel {
  private JTextArea textAreaOne     = new JTextArea(6, 30);
  private JScrollPane scrollPaneOne = new JScrollPane(textAreaOne);
  private GridLayout gridLayout     = new GridLayout(0,1);
  
  
  public void saveCalculation(Double length, Double width, Double depth, Double cost, Double total_cost) {
    BufferedWriter writer = null;
    System.out.println("working");
    String string = "Length: " + length + "\n" + "Width: " + width + "\n" + "Depth: " + depth + "\n" + "Cost: " + cost + "\n" + "Total Cost: " + total_cost + "\n======================================\n";
    
     try {
       File file = new File(Routes.audits_path);
       writer = new BufferedWriter(new FileWriter(file, true));
       writer.write(string);
       writer.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
     setupTextAreas();
  }
  
  public void setupTextAreas(){
    String string = "";

    try {
      File file = new File(Routes.audits_path);
      final Scanner scanner = new Scanner( file );
      while ( scanner.hasNextLine() ) {
        String line = scanner.nextLine();
        string += line + "\n";
        
      }
    } catch ( FileNotFoundException e ) {
      e.printStackTrace();
    }
    
    textAreaOne.setText(string);
  }
  
  public void addObjects(){
    add(scrollPaneOne);
  }
  
  public Audit(){
    try {
      File file = new File(Routes.audits_path);
      file.createNewFile();
    } catch (Exception e) {
      e.printStackTrace();
    }
    setLayout(gridLayout);
    setupTextAreas();
    addObjects();
    setVisible(true);
  }
}