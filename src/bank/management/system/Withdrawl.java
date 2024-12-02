package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton Withdraw,back;
    
    String pinnumber;
   Withdrawl(String pinnumber){
       
       this.pinnumber = pinnumber;
       setLayout(null);
   
       ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 =il.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,720);
       add(image);
       
       JLabel text = new JLabel("Enter the amount you want to Withdraw");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       text.setBounds(190,235,400,20);
       image.add(text);
       
        amount = new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,22));
       amount.setBounds(190,280,300,20);
       image.add(amount);
       
        Withdraw = new JButton("Withdraw");
       Withdraw.setBounds(350,390,150,22);
       Withdraw.addActionListener(this);
       image.add(Withdraw);
       
          back = new JButton("Back");
       back.setBounds(350,415,150,22);
       back.addActionListener(this);
       image.add(back);
       
      setSize(900,720);
      setLocation(300,0);
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
try{
        String number = amount.getText();
        if(ae.getSource()== Withdraw){
         
          Date date = new Date();
          if(number.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
          }else{
              
            conn c = new conn();
            String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs"+ " "+number+" "+"Withdraw Successfully");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
              }
              
              }
        else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
}catch(Exception e){
              System.out.println(e);
              }
   }
   
    public static void main(String args[]) {
        new Withdrawl("");
    }
}

