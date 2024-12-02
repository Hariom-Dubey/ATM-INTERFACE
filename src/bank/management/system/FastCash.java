
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;




public class FastCash extends JFrame implements ActionListener{
    
    JButton r1,r2,r3,r4,r5,r6,exit;
    String pinnumber;
  FastCash(String pinnumber){
      this.pinnumber = pinnumber;
      setLayout(null);
      
      ImageIcon il= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2=il.getImage().getScaledInstance(800, 780, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image =new JLabel(i3);
      image.setBounds(0,0,800,780);
      add(image);
      
      JLabel text =new JLabel("SELECT WITHDRAWL AMOUNT");
      text.setBounds(185,250,700,35);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
      
       r1 = new JButton("Rs 100");
      r1.setBounds(150,360,130,25);
      r1.addActionListener(this);
      image.add(r1);
      
       r2 = new JButton("Rs 500");
      r2.setBounds(315,360,130,25);
      r2.addActionListener(this);
      image.add(r2);
      
       r3 = new JButton("Rs 1000");
       r3.setBounds(150,390,130,25);
       r3.addActionListener(this);
      image.add(r3);
      
       r4 = new JButton("Rs 2000");
      r4.setBounds(315,390,130,25);
      r4.addActionListener(this);
      image.add(r4);
      
        r5 = new JButton("Rs 5000");
       r5.setBounds(150,420,130,25);
       r5.addActionListener(this);
      image.add(r5);
      
       r6 = new JButton("Rs 10000");
      r6.setBounds(315,420,130,25);
      r6.addActionListener(this);
      image.add(r6);
      
         exit = new JButton("Back");
      exit.setBounds(315,450,130,25);
      exit.addActionListener(this);
      image.add(exit);
      
      getContentPane().setBackground(Color.WHITE);
        
      setSize(800,780);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
      
  }
  
  public void actionPerformed(ActionEvent ae){
try{
  
    String amount = ((JButton)ae.getSource()).getText().substring(3);  //Rs 100
    conn c  =  new  conn();
    
       ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
       int balance = 0;
       while(rs.next()){
         if(rs.getString("type").equals("Deposit")){
           balance +=  Integer.parseInt( rs.getString("amount"));
            
         }else{
           balance -= Integer.parseInt( rs.getString("amount"));
         
         }
       
       }
       
     if(ae.getSource() != exit  &&  balance < Integer.parseInt(amount)){
         JOptionPane.showMessageDialog(null,"Insufficient Balance");
         return;
     }

    if(ae.getSource() == exit){
     setVisible(false);
     new Transactions(pinnumber).setVisible(true); 
  
     } 
     else{
     Date date = new Date();
     String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrwal','"+amount+"')";
     c.s.executeUpdate(query);
     JOptionPane.showMessageDialog(null, "Rs"+" "+ amount +" "+ "Debited Successfully");
     
      setVisible(false);
     new Transactions(pinnumber).setVisible(true);
    
     }
   
    
    }catch(Exception  e){
     System.out.println(e);
    
    }
    
    
  
  
  
  
  }

      public static void main(String args[]) {
        new FastCash("").setVisible(true);
    }
}

