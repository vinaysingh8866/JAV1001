
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab01 {
    
   public static void main(String[] args) {
     createWindow();
   }
    
    
    //Create frame for GUI
   private static void createWindow() {    
      JFrame frame = new JFrame("Grading System");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createUI(frame);
      frame.setSize(560, 200);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }
   
   //Function shows message when called, takes string as input 
   public static void showDialog(String msg)
   {
       JOptionPane.showMessageDialog(null, msg);
   }
    
    
   //Create Elemnts of GUI
   private static void createUI(final JFrame frame){  
      JPanel panel = new JPanel();
      //Create Calculate Button
      JButton button = new JButton("Calculate Grade");
      
      //Create name lable
      final JLabel namelabel = new JLabel();
      namelabel.setText("Enter Name");
      
      //create grade lable
      final JLabel gradelabel = new JLabel();
      gradelabel.setText("Enter Grade");
      
      //Create Text filed for name and grade
      JTextField namefield = new JTextField("", 20);
      JTextField gradefield = new JTextField("", 20);
      
      //Set layput of planel for alignment
      panel.setLayout(new GridBagLayout());
      
      
      //Adding Elements to frame
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.gridy = 0;
      constraints.gridx = GridBagConstraints.RELATIVE;
      
      panel.add(namelabel , constraints);
      panel.add(namefield,constraints);
      
      constraints.gridy = 1;
      constraints.gridx = GridBagConstraints.RELATIVE;
      
      
      panel.add(gradelabel , constraints);
      panel.add(gradefield , constraints);
      
      constraints.gridy = 2;
      panel.add(button,constraints);
      //Button Action Listner 
      button.addActionListener(new ActionListener() {
         @Override
         //Calculation logic 
         public void actionPerformed(ActionEvent e) {
         
         String name = namefield.getText();

         if ("".equals(name)){
             showDialog("Enter Name");
             
         }
         try{
         
             Double grade = new Double(gradefield.getText());
             if(grade<0){
                 showDialog("Enter Grade from 0-100");
             }
             else if(grade>100){
                 showDialog("Enter Grade from 0-100");
             }
             else if(grade>=80){
                 showDialog(name.toUpperCase() +" your grade is " + "A");
             }
             else if(grade<80 && grade>=70){
                 showDialog(name.toUpperCase() +" your grade is " + "B");
             }
             else if(grade<70 && grade>=60){
                 showDialog(name.toUpperCase() +" your grade is " + "C");
             }
             else if(grade<60 && grade>=50){
                 showDialog(name.toUpperCase() +" your grade is " + "D");
             }
             
             else{
                 showDialog(name.toUpperCase() +" your grade is " + "F");
             }
             
         
         }
         //Handling exception that can occuring during conversion from string to double
         catch (NumberFormatException exception){
             
             showDialog(exception.toString());
             
         }
         
         
         
         }
      });

      
      
      
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }
    

}
