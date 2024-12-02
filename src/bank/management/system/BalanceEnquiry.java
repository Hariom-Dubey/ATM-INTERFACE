
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;



public class BalanceEnquiry extends JFrame implements ActionListener{
       
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
        
        
      ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = il.getImage().getScaledInstance(800, 780, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,800,780);
      add(image);
      
       back = new JButton("Back");
       back.setBounds(315,450,130,25);
       back.addActionListener(this);
       image.add(back);
       
        conn c  =  new  conn();
        int balance = 0;
    try{
         
       ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
      
       while(rs.next()){
         if(rs.getString("type").equals("Deposit")){
           balance = balance + Integer.parseInt( rs.getString("amount"));
         }else{
           balance = balance - Integer.parseInt( rs.getString("amount"));
         
          }
         }
       }catch(Exception e){
               System.out.println(e);
               }
    
    
    JLabel text = new JLabel("Your Current Account Balance is Rs"+" "+ balance);
    text.setForeground(Color.WHITE);
    text.setBounds(180,240,700,35);
    image.add(text);
       
       
    
      
        
      setSize(800,780);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      setVisible(false);
      new Transactions(pinnumber).setVisible(true);
    
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
