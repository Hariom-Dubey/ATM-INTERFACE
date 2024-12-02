
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

      public class SignupTwo extends JFrame implements ActionListener{
          
         
  JTextField pan,aadhar; 
  JButton next;
  JRadioButton syes,sno,eyes,eno;
  JComboBox religion,category,occupation,education,income;
  String formno;
        
        
        SignupTwo(String formno){
      this.formno=formno;
       setLayout(null);
   
      setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
   
      
       JLabel additionalDetails=new JLabel("Page 2: Additional Details");
      additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
      additionalDetails.setBounds(250,80,400,30);
      add(additionalDetails);
      
       JLabel rel=new JLabel("Religion:");
      rel.setFont(new Font("Raleway",Font.BOLD,20));
      rel.setBounds(100,140,100,30);
      add(rel);
      
      String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
      religion = new JComboBox(valReligion);
     religion.setBounds(300,140,400,30);
     religion.setBackground(Color.WHITE);
      add(religion);
  
      JLabel cate=new JLabel("Category:");
       cate.setFont(new Font("Raleway",Font.BOLD,20));
      cate.setBounds(100,190,200,30);
      add(cate);
      
    String valCategory[]={"General","OBC","SC","ST"};
        category= new JComboBox(valCategory);
     category.setBounds(300,190,400,30);
     category.setBackground(Color.WHITE);
      add(category);
      
       JLabel ic=new JLabel("Income:");
      ic.setFont(new Font("Raleway",Font.BOLD,20));
      ic.setBounds(100,240,200,30);
      add(ic);
      
         String incomeCategory[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income= new JComboBox(incomeCategory);
     income.setBounds(300,240,400,30);
    income.setBackground(Color.WHITE);
      add(income);
      
      
 
      
       JLabel edu=new JLabel("Educational");
      edu.setFont(new Font("Raleway",Font.BOLD,20));
      edu.setBounds(100,300,200,30);
      add(edu);
      
       JLabel quali=new JLabel("Qualification:");
      quali.setFont(new Font("Raleway",Font.BOLD,20));
      quali.setBounds(100,325,200,30);
      add(quali);
      
            String educationValues[]={"Non-Graduation","Under-Graduation","Post-Graduation","Doctrate","Others"};
        education= new JComboBox(educationValues);
     education.setBounds(300,315,400,30);
    education.setBackground(Color.WHITE);
      add(education);
      
     
      
       JLabel occup=new JLabel("Occupation:");
      occup.setFont(new Font("Raleway",Font.BOLD,20));
      occup.setBounds(100,390,200,30);
      add(occup);
      
         String occupationalValues[]={"Salaried","Self-Employeed","Bussiness","Student","Retired","Others"};
        occupation= new JComboBox(occupationalValues);
     occupation.setBounds(300,390,400,30);
     occupation.setBackground(Color.WHITE);
      add(occupation);
      
      
       JLabel pannumber=new JLabel("PAN Number:");
      pannumber.setFont(new Font("Raleway",Font.BOLD,20));
      pannumber.setBounds(100,440,200,30);
      add(pannumber);
      
       pan =new JTextField();
       pan.setFont(new Font("Raleway",Font.BOLD,14));
       pan.setBounds(300,440,400,30);
      add(pan);
      
        JLabel aadharnumber=new JLabel("Aadhar Number:");
      aadharnumber.setFont(new Font("Raleway",Font.BOLD,20));
      aadharnumber.setBounds(100,490,200,30);
      add(aadharnumber);
      
       aadhar =new JTextField();
      aadhar.setFont(new Font("Raleway",Font.BOLD,14));
      aadhar.setBounds(300,490,400,30);
      add(aadhar);
      
         JLabel state=new JLabel("Senior Citizen:");
      state.setFont(new Font("Raleway",Font.BOLD,20));
      state.setBounds(100,540,200,30);
      add(state);
      
       syes  =new JRadioButton("Yes");
         syes.setBounds(320,540,100,30);
      syes.setBackground(Color.WHITE);
      add(syes);
      
        sno =new JRadioButton("No");
         sno.setBounds(440,540,100,30);
      sno.setBackground(Color.WHITE);
      add(sno);
      
            ButtonGroup csgroup = new ButtonGroup();
      csgroup.add(syes);
      csgroup.add(sno);
      
         JLabel account=new JLabel("Existing Account:");
      account.setFont(new Font("Raleway",Font.BOLD,20));
      account.setBounds(100,590,200,30);
      add(account);
      
      eyes  =new JRadioButton("Yes");
         eyes.setBounds(320,590,100,30);
      eyes.setBackground(Color.WHITE);
      add(eyes);
      
        eno =new JRadioButton("No");
         eno.setBounds(440,590,100,30);
      eno.setBackground(Color.WHITE);
      add(eno);
      
            ButtonGroup egroup = new ButtonGroup();
      egroup.add(eyes);
      egroup.add(eno);
      
       next=new JButton("Next");
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway",Font.BOLD,14));
      next.setBounds(620,660,80,30);
      next.addActionListener(this);
      add(next);
      
      getContentPane().setBackground(Color.WHITE);
      
      setLayout(null);
      setSize(850,800);
      setLocation(350,10);
      setVisible(true);
  }
  public void actionPerformed(ActionEvent ae){
      String sreligion  =(String) religion.getSelectedItem();
       String scategory  =(String) category.getSelectedItem();
       String sincome  =(String) income.getSelectedItem();
       String seducation  =(String) education.getSelectedItem();
       String soccupation  =(String) occupation.getSelectedItem();
       
       String seniorcitizen= null;
       if (syes.isSelected()){
        seniorcitizen = "Yes";    
       }else if(sno.isSelected())   {
       seniorcitizen = "No";
       }    
       
       
       String existingaccount = null;
       if (eyes.isSelected()){
       existingaccount="Yes";
       }
       else if(eno.isSelected()){
       existingaccount="No";
       }
      
       
       String span= pan.getText();
       String saadhar= aadhar.getText();
       
       
       try{
       
           conn c = new conn();
           String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
           c.s.executeUpdate(query);
    
       setVisible(false);
       new Signup(formno).setVisible(true);
           
       }catch(Exception e){
       System.out.println(e);
       }
  }
  
      public static void main(String args[]) {
        new SignupTwo("");    }
}
