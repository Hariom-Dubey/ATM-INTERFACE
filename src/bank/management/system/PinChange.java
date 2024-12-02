
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    
     PinChange(String pinnumber){
         this.pinnumber = pinnumber;
         setLayout(null);
      ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = il.getImage().getScaledInstance(800, 780, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,800,780);
      add(image);
      
      JLabel text = new JLabel("CHANGE YOUR PIN");
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      text.setBounds(210,220,700,35);
       image.add(text);
       
       
        JLabel pintext = new JLabel("New PIN:");
      pintext.setForeground(Color.WHITE);
      pintext.setFont(new Font("System",Font.BOLD,14));
      pintext.setBounds(140,260,100,35);
       image.add(pintext);
       
        pin = new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(285,265,160,20);
         image.add(pin);
       
        JLabel repintext = new JLabel("Re-enter New PIN:");
      repintext.setForeground(Color.WHITE);
      repintext.setFont(new Font("System",Font.BOLD,14));
      repintext.setBounds(140,290,160,35);
       image.add(repintext);
       
         repin = new JPasswordField();
       repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(285,295,160,20);
         image.add(repin);
         
          change = new JButton("Change");
         change.setBounds(315,400,130,25);
         change.addActionListener(this);
         image.add(change);
         
          back = new JButton("Back");
         back.setBounds(315,430,130,25);
         back.addActionListener(this);
         image.add(back);
      
      
      
      
       setSize(800,780);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
      
     }
     
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == change){
       try{
         String npin = pin.getText();
         String rpin = repin.getText();
         
        if(!npin.equals(rpin)){
          JOptionPane.showMessageDialog(null,"Entered PIN does not match");
          return;
        }
         if(npin.equals("")){
          JOptionPane.showMessageDialog(null,"Please enter PIN");
          return;
        }
         if(rpin.equals("")){
          JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
          return;
        }
         
         conn c = new conn();
         String query1 = "update bank set pin ='"+rpin+"' where pin = '"+pinnumber+"'";
         String query2 = "update login set pin ='"+rpin+"' where pin = '"+pinnumber+"'";
         String query3 = "update signupthree set pin ='"+rpin+"' where pin = '"+pinnumber+"'";
         
         c.s.executeUpdate(query1);
         c.s.executeUpdate(query2);
         c.s.executeUpdate(query3);
         
         JOptionPane.showMessageDialog(null,"PIN changed successfully");
         
         setVisible(false);
         new Transactions(rpin).setVisible(true);
         

       
       }catch(Exception e){
         System.out.println(e);
       }
         }else {
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
         }
       
       
     
     }
    
    public static void main (String args[]) {
        new PinChange("").setVisible(true);
    }
}
