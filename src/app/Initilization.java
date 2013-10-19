/***********************************************************************
Program Name: Init.java
Programmer's Name: Brandt Lareau
Program Description: initilize
***********************************************************************/
package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import panels.*;



public class Initilization extends JFrame implements ActionListener {
  
  public static String JAVA_ROOT     = new java.io.File("").getAbsolutePath();
  private JTabbedPane tabs           = new JTabbedPane();
  public Routes routes               = new Routes();
  public Audit audit_panel           = new Audit();
  public Calculator calculator_panel = new Calculator(audit_panel);
  private JMenuBar menuBar           = new JMenuBar();  
  private JMenu menu                 = new JMenu("File");
  private JMenuItem exitItem         = new JMenuItem("Exit", new ImageIcon(Routes.door_out_icon_path));
  
  public static void main(String args[]) {
    new Initilization();
  }
  
  public void addTabs(){
    ImageIcon calculator_icon = new ImageIcon(Routes.calculator_icon_path);
    ImageIcon audit_icon      = new ImageIcon(Routes.audit_icon_path);
    
    tabs.addTab("Calculate pool", calculator_icon, calculator_panel, "Calculate the total area of the pool");
    tabs.addTab("Audits", audit_icon, audit_panel, "Does nothing");
    
    add(tabs);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Exit") {
      System.exit(0);
    }
  }
  
  public void addMenuItems(){
    exitItem.setMnemonic(KeyEvent.VK_E);
    exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
    menuBar.add(menu);
    menu.add(exitItem);
    setJMenuBar(menuBar);
    
    exitItem.addActionListener(this);
  }
  
  public void setup(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(450, 300, 400, 300);
    setResizable(false);
  }
  
  public Initilization() {
    setup();
    addMenuItems();
    addTabs();
    setVisible(true);
    
  }
}