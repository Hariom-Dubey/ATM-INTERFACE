
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
  Transactions(String pinnumber){
      this.pinnumber = pinnumber;
      setLayout(null);
      
      ImageIcon il= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2=il.getImage().getScaledInstance(800, 780, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image =new JLabel(i3);
      image.setBounds(0,0,800,780);
      add(image);
      
      JLabel text =new JLabel("Please Select Your Transaction");
      text.setBounds(185,250,700,35);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
      
       deposit = new JButton("Deposit");
      deposit.setBounds(150,360,130,25);
      deposit.addActionListener(this);
      image.add(deposit);
      
       withdrawl = new JButton("Cash Withdrawl");
      withdrawl.setBounds(315,360,130,25);
      withdrawl.addActionListener(this);
      image.add(withdrawl);
      
       fastcash = new JButton("Fast Cash");
       fastcash.setBounds(150,390,130,25);
       fastcash.addActionListener(this);
      image.add(fastcash);
      
       ministatement = new JButton("Mini Statement");
      ministatement.setBounds(315,390,130,25);
      ministatement.addActionListener(this);
      image.add(ministatement);
      
        pinchange = new JButton("Pin Change");
       pinchange.setBounds(150,420,130,25);
       pinchange.addActionListener(this);
      image.add(pinchange);
      
       balanceenquiry = new JButton("Balance Enquiry");
      balanceenquiry.setBounds(315,420,130,25);
      balanceenquiry.addActionListener(this);
      image.add(balanceenquiry);
      
         exit = new JButton("Exit");
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
  if(ae.getSource() == exit){
     System.exit(0);
  }else if(ae.getSource() == deposit){
    setVisible(false);
    new Deposit(pinnumber).setVisible(true);
  }else if(ae.getSource()== withdrawl){
    setVisible(false);
    new Withdrawl(pinnumber).setVisible(true);
  }else if(ae.getSource()== fastcash){
    setVisible(false);
    new FastCash(pinnumber).setVisible(true); 
  }  else if(ae.getSource()== pinchange){
    setVisible(false);
    new PinChange(pinnumber).setVisible(true); 
  }  else if(ae.getSource()== balanceenquiry){
    setVisible(false);
    new BalanceEnquiry(pinnumber).setVisible(true); 
  } else if(ae.getSource()== ministatement){
    new MiniStatement(pinnumber).setVisible(true); 
  } 
  }
   
    public static void main(String args[]) {
        new Transactions("");
    }
}
