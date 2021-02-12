
import java.util.Random;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author vinay
 */

//Dice Class
class Dice{
    private String diceType= new String();
    private int numSides= 0;
    private int sideUp = 0;
    private Random randomGen = new Random();
    //Cunstuctors
    
    Dice(){
        this.diceType= "d6";
        this.numSides = 6;
        this.sideUp = randomGen.nextInt(this.numSides+1);
    }
    
    Dice(int numside){
        this.diceType= "d"+numside;
        this.numSides = numside;
        this.sideUp = randomGen.nextInt(this.numSides+1);
    
    }
    
    Dice(int numside, String dicetype){
        this.diceType= dicetype;
        this.numSides = numside;
        this.sideUp = randomGen.nextInt(this.numSides+1);
    
    }
    //Set and get methods for variables
    public void setSide(int side){
        this.sideUp=side;
    }
    
    public int getNumSide(){
        return this.numSides;
    }
    
    public void roll(){
        Random random = new Random(); 
        this.sideUp = random.nextInt(this.numSides+1);
        //System.out.println(this.sideUp);
    }
    
    public int getSide(){
        return this.sideUp;
    }
        
}

public class Lab3 {
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        //Create UI "    Side UP:   "+
        JFrame jf;
        jf = new JFrame("Dice Game");            
        JButton btnRoll = new JButton("Roll");
        JButton btnSetSide = new JButton("Set UP side");
        JTextField textSides = new JTextField("Enter UP side",12);
        JLabel lblSideUp = new JLabel();
        JButton btnRollTill = new JButton("Roll Consicutive Dice");
        
        //Empty text field when clicked
        textSides.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {}
            @Override
            public void mousePressed(MouseEvent me) {}
            @Override
            public void mouseReleased(MouseEvent me) {textSides.setText("");}
            @Override
            public void mouseEntered(MouseEvent me) {}
            @Override
            public void mouseExited(MouseEvent me) {}
            
        });
        
        //Set layout of JFrame
        
        jf.setLayout(new GridLayout(6, 2));  
        //Add componets to frame
        jf.add(textSides);
        jf.add(btnSetSide);
        jf.add(btnRoll);                            
        jf.add(lblSideUp);
        jf.add(btnRollTill);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);                   
        jf.setVisible(true);                    

        //Itinialize dice
        Dice dice = new Dice(20);
        lblSideUp.setText("    Side UP:   "+Integer.toString(dice.getSide()));
        // Cold yatzee roll
        
        btnRollTill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          
                Dice dice1 = new Dice();
                Dice dice2 = new Dice();
                Dice dice3 = new Dice();
                Dice dice4 = new Dice();
                Dice dice5 = new Dice();
                int rolls = 0;
                while(true){
                    rolls++;
                    dice1.roll();
                    dice2.roll();
                    dice3.roll();
                    dice4.roll();
                    dice5.roll();
                    
                if(dice1.getSide()==dice2.getSide() && dice3.getSide()==dice4.getSide()&&dice1.getSide()==dice5.getSide()){
                    JOptionPane.showMessageDialog(jf,"cold-Yatzee "+rolls+" Rolls");
                    break;
                    }
                
                }
            }
        });
        //Roll button code
        btnRoll.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {    
            dice.roll();
            lblSideUp.setText("    Side UP:   "+Integer.toString(dice.getSide()));
            
            
        }});
        
        //Set The Up Side
        btnSetSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text= new String();
                int sideUpText = 0;
                //check for int conversion exception
                try{    
                    text = textSides.getText();
                    sideUpText = Integer.parseInt(text);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(jf,"Enter Side value");
                }    
               
               if(sideUpText < dice.getNumSide()){
                dice.setSide(Integer.parseInt(textSides.getText()));
                lblSideUp.setText("    Side UP:   "+Integer.toString(dice.getSide()));
               }
               else{
                   JOptionPane.showMessageDialog(jf,"Side more than intialised");
               }
            }
        });

   
    }
    
  
    
}

