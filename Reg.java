import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Reg extends JFrame implements ActionListener
{
   
       JLabel tit,no,nm,ag,pn,ad;
       JTextField tno,tnm,tag,tpn;
       JTextArea tad,dt;
       JButton bt,bt1;
       public Reg()
       {
             
           tit = new JLabel("Registration Form");
           tit.setFont(new Font("Serif", Font.BOLD, 24));
           tit.setBounds(100, 50, 200, 30);
           no = new JLabel("NO :");
           no.setFont(new Font("Arial", Font.BOLD, 14));
           no.setBounds(50, 120, 100, 30);
           tno = new JTextField();
           tno.setFont(new Font("Arial", Font.PLAIN, 14));
           tno.setBounds(160, 120, 140, 25);
           nm = new JLabel("Name :");
           nm.setFont(new Font("Arial", Font.BOLD, 14));
           nm.setBounds(50, 170, 100, 30);
           tnm = new JTextField();
           tnm.setFont(new Font("Arial", Font.PLAIN, 14));
           tnm.setBounds(160, 170, 140, 25);
           ag = new JLabel("Age :");
           ag.setFont(new Font("Arial", Font.BOLD, 14));
           ag.setBounds(50, 220, 100, 30);
           tag = new JTextField();
           tag.setFont(new Font("Arial", Font.PLAIN, 14));
           tag.setBounds(160, 220, 140, 25);
           pn = new JLabel("PhoneNo :");
           pn.setFont(new Font("Arial", Font.BOLD, 14));
           pn.setBounds(50, 270, 100, 30);
           tpn = new JTextField();
           tpn.setFont(new Font("Arial", Font.PLAIN, 14));
           tpn.setBounds(160, 270, 140, 25);
           ad = new JLabel("Address :");
           ad.setFont(new Font("Arial", Font.BOLD, 14));
           ad.setBounds(50, 320, 100, 30);
           tad = new JTextArea();
           tad.setFont(new Font("Arial", Font.PLAIN, 14));
           tad.setBounds(160, 320, 140, 100);
           bt = new JButton("Submit");
           bt.setFont(new Font("Arial", Font.BOLD, 14));
           bt.setBounds(50, 450, 100, 30);
           bt1 = new JButton("Reset");
           bt1.setFont(new Font("Arial", Font.BOLD, 14));
           bt1.setBounds(180, 450, 100, 30);
           dt = new JTextArea();
           dt.setFont(new Font("Arial", Font.PLAIN, 14));
           dt.setBounds(420,150, 300, 200);
           
           add(tit);
           add(no);
           add(tno);
           add(nm);
           add(tnm);
           add(ag);
           add(tag);
           add(pn);
           add(tpn);
           add(ad);
           add(tad);
           add(bt);
           add(bt1);
           add(dt);
           setLayout(null);
           setSize(800,600);
           setVisible(true);
       }
       public void actionPerformed(ActionEvent ae) 
       {
            if(ae.getSource()==bt)
            {
                String s1="",s2="",s3="",s4="",s5="";
                s1=tno.getText();
                s2=tnm.getText();
                s3=tag.getText();
                s4=tpn.getText();
                s5=tad.getText();
                dt.setText(s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5);
                tno.setText(" ");
                tnm.setText(" ");
                tag.setText(" ");
                tpn.setText(" ");
                tad.setText(" ");
                tno.requestFocus();
            }
            if(ae.getSource()==bt1)
            {
                 tno.setText(" ");
                tnm.setText(" ");
                tag.setText(" ");
                tpn.setText(" ");
                tad.setText(" ");
                tno.requestFocus();
            }
       }
    
       public static void main(String[] args) 
       {
           new Reg();
           
       }

    
    
    
}