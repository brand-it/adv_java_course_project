/***********************************************************************
Program Name: PanelOne.java
Programmer's Name: Brandt Lareau
Program Description: Calculator for the pool
***********************************************************************/
package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.io.*;

public class Calculator extends JPanel implements ActionListener {
  
  private Audit audit;
  
  // Buttons
  private JButton buttonOne = new JButton("Calculate");
  private JButton buttonTwo = new JButton("Reset");
  
  // Layout
  private GridLayout gridLayout     = new GridLayout(6,2);

  // Lables
  private JLabel labelOne   = new JLabel();
  private JLabel labelTwo   = new JLabel();
  private JLabel labelThree = new JLabel();
  private JLabel labelFour  = new JLabel();
  private JLabel labelFive  = new JLabel();
  
  
  // Text Fields
  private JTextField textFieldOne   = new JTextField();
  private JTextField textFieldTwo   = new JTextField();
  private JTextField textFieldThree = new JTextField();
  private JTextField textFieldFour  = new JTextField();
  private JTextField textFieldFive  = new JTextField();
  
  DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
  
  private Double length     = 0.0;
  private Double width      = 0.0;
  private Double depth      = 0.0;
  private Double cost       = 0.0; // cost per volume
  private Double total_cost = 0.0;
  private Double volume     = 0.0;


  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand() == "Calculate"){
      calculatePoolCost();
    }
    
    if (e.getActionCommand() == "Reset"){
      resetAllFields();
      textFieldOne.requestFocus();
    }
  }
  
  public void calculatePoolCost(){
    try {
      length = Double.parseDouble(textFieldOne.getText());
      width  = Double.parseDouble(textFieldTwo.getText());
      depth  = Double.parseDouble(textFieldThree.getText());
      cost   = Double.parseDouble(textFieldFour.getText());
      
    } catch (NumberFormatException exception) {
      System.out.println(exception);
      textFieldFive.setText("One of fields are not in a number format");
    }
    
    volume = (length * width * depth);
    
    total_cost = volume * cost;
    
    textFieldFive.setText(decimalFormat.format(total_cost));
    audit.saveCalculation(length, width, depth, cost, total_cost);
  }
  
  public void resetAllFields(){
    length     = 0.0;
    width      = 0.0;
    depth      = 0.0;
    cost       = 0.0;
    total_cost = 0.0;

    textFieldOne.setText(decimalFormat.format(length));
    
    textFieldTwo.setText(decimalFormat.format(width));
    
    textFieldThree.setText(decimalFormat.format(depth));
    
    textFieldFour.setText(decimalFormat.format(cost));
    
    textFieldFive.setText(decimalFormat.format(total_cost));
    
  }
  
  public void setupButtons(){
    buttonOne.addActionListener(this);
    buttonTwo.addActionListener(this);
  }
  
  public void setupLabels(){
    labelOne.setText("Pool Length: ");
    
    labelTwo.setText("Pool Width: ");
    
    labelThree.setText("Pool Depth: ");
    
    labelFour.setText("Cost Per Volume: ");
    
    labelFive.setText("Pool Total Cost: ");
    
  }
  
  
  public void setupTextFields(){
    textFieldOne.requestFocus();
    
    textFieldOne.setText(decimalFormat.format(length));
    
    textFieldTwo.setText(decimalFormat.format(width));
    
    textFieldThree.setText(decimalFormat.format(depth));
    
    textFieldFour.setText(decimalFormat.format(cost));
    
    textFieldFive.setText(decimalFormat.format(total_cost));
    
    Color bgColor = UIManager.getColor("gray");  
    textFieldFive.setBackground(bgColor); 
    Color fgColor = UIManager.getColor("TextField.foreground");  
    textFieldFive.setDisabledTextColor(fgColor); 
    textFieldFive.setEnabled(false);
    
    
  }
  
  public void addObjects(){
    add(labelOne);
    add(textFieldOne);
    
    add(labelTwo);
    add(textFieldTwo);
    
    add(labelThree);
    add(textFieldThree);
    
    add(labelFour);
    add(textFieldFour);
    
    add(labelFive);
    add(textFieldFive);
    
    add(buttonOne);
    add(buttonTwo);
  }
  
  public void setupObjects(){
    setupLabels();
    setupTextFields();
    setupButtons();
  }
  
  public Calculator(Audit a){
    audit = a;
    
    setLayout(gridLayout);
    
    setupObjects();
    
    addObjects();
    
    setVisible(true);
    
  }
}