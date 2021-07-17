import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Registration extends JApplet implements ActionListener,MouseListener
{
      JLabel en,fn,ln,gn,bn,y,ad,cn,em;
      JTextField ten,tfn,tln,tad,tcn,tem;
      JComboBox cbn,cy;
      JRadioButton r1,r2;
      JButton a,ed,d,s,cl;
      ButtonGroup bg = new ButtonGroup();
      String[] branch={"B.sc","M.sc","B.C.A","B.E","M.E","B.tech"};
      String[] year={"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
      public void init()
      {
           en = new JLabel("Enrollment No : ");
           en.setFont(new Font("arial",Font.BOLD,14));
           en.setBounds(180,20,170,25);
           fn = new JLabel("First Name : ");
           fn.setFont(new Font("arial",Font.BOLD,14));
           fn.setBounds(180,45,170,25);
           ln = new JLabel("Last Name : ");
           ln.setFont(new Font("arial",Font.BOLD,14));
           ln.setBounds(180,70,170,25);
           gn = new JLabel("Gender : ");
           gn.setFont(new Font("arial",Font.BOLD,14));
           gn.setBounds(180,95,170,25);
           bn = new JLabel("Branch Name : ");
           bn.setFont(new Font("arial",Font.BOLD,14));
           bn.setBounds(180,145,170,25);
           y = new JLabel("Year : ");
           y.setFont(new Font("arial",Font.BOLD,14));
           y.setBounds(180,170,170,25);
           ad = new JLabel("Address : ");
           ad.setFont(new Font("arial",Font.BOLD,14));
           ad.setBounds(180,195,170,25);
           cn = new JLabel("Cell No : ");
           cn.setFont(new Font("arial",Font.BOLD,14));
           cn.setBounds(180,220,170,25);
           em = new JLabel("Email Id : ");
           em.setFont(new Font("arial",Font.BOLD,14));
           em.setBounds(180,245,170,25);
         
           
         
           ten = new JTextField();
           ten.setFont(new Font("arial",Font.PLAIN,14));
           ten.setBounds(350,20,190,25);
           tfn = new JTextField();
           tfn.setFont(new Font("arial",Font.PLAIN,14));
           tfn.setBounds(350,45,190,25);
           tln = new JTextField();
           tln.setFont(new Font("arial",Font.PLAIN,14));
           tln.setBounds(350,70,190,25);
           tad = new JTextField();
           tad.setFont(new Font("arial",Font.PLAIN,14));
           tad.setBounds(350,195,190,25);
           tcn = new JTextField();
           tcn.setFont(new Font("arial",Font.PLAIN,14));
           tcn.setBounds(350,220,190,25);
           tem = new JTextField();
           tem.setFont(new Font("arial",Font.PLAIN,14));
           tem.setBounds(350,245,190,25);
           
           r1 = new JRadioButton("Male");
           r1.setFont(new Font("arial",Font.BOLD,14));
           r1.setBounds(350,95,190,25);   
           r2 = new JRadioButton("Female");
           r2.setFont(new Font("arial",Font.BOLD,14));
           r2.setBounds(350,120,190,25);
           
           cbn = new JComboBox(branch);
           cbn.setBounds(350,145,190,25);
           cy = new JComboBox(year);
           cy.setBounds(350,170,190,25); 
          
           bg.add(r1);
           bg.add(r2);
           
           a = new JButton("Add");
           a.setBounds(150,280,90,30);
           ed = new JButton("Edit");
           ed.setBounds(240,280,90,30);
           d = new JButton("Delete");
           d.setBounds(330,280,90,30);
           s = new JButton("Search");
           s.setBounds(420,280,90,30);
           cl = new JButton("Clear");
           cl.setBounds(510,280,90,30);
          
            
           add(en);
           
           add(ten);
           add(fn);
           add(tfn);
           add(ln);
           add(tln);
           add(gn);
           add(r1);
           add(r2);
           add(bn);
           add(y);
           add(cbn);
           add(cy);
           add(ad);
           add(cn);
           add(em);
           add(tad);
           add(tcn);
           add(tem);
           add(a);
           add(ed);
           add(d);
           add(s);
           add(cl);
           
           
           
           a.addActionListener(this);
           ed.addActionListener(this);
           d.addActionListener(this);
           s.addActionListener(this);
           cl.addActionListener(this);
           ten.addActionListener(this);
           
           addMouseListener(this);
           
           setSize(700,350);
           setVisible(true);
           setLayout(null);
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==cl)
        {
            
                    ten.setText("");
                    tfn.setText("");
                    tln.setText("");
                    tad.setText("");
                    tcn.setText("");
                    tem.setText("");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    cbn.setSelectedIndex(0);
                    cy.setSelectedIndex(0);
                    ten.requestFocus();
        }
        if(e.getSource()==a)
        {
            Long n = Long.parseLong(ten.getText());
            String fn = tfn.getText();
            String ln = tln.getText();
            String g =" ";
            if(r1.isSelected())
            {
                g="Male";
                
            }
            if(r2.isSelected())
            {
                g="Female";
                
            }
            String bnm = cbn.getSelectedItem().toString();
            String ye = cy.getSelectedItem().toString();
            String adr = tad.getText();
            String cno = tcn.getText();
            String eid = tem.getText();
            
            try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
                   
                   PreparedStatement pt = con.prepareStatement("insert into details values(?,?,?,?,?,?,?,?,?) ");
                   pt.setLong(1, n);
                   pt.setString(2, fn);
                   pt.setString(3, ln);
                   pt.setString(4, g);
                   pt.setString(5, bnm);
                   pt.setString(6, ye);
                   pt.setString(7, adr);
                   pt.setString(8, cno);
                   pt.setString(9, eid);
                   pt.executeUpdate();
                   JOptionPane.showMessageDialog(this,"ADD SUCCESSFULLY...");
                   con.close();   
                   
                    ten.setText("");
                    tfn.setText("");
                    tln.setText("");
                    tad.setText("");
                    tcn.setText("");
                    tem.setText("");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    cbn.setSelectedIndex(0);
                    cy.setSelectedIndex(0);
                    ten.requestFocus();
              
            }catch(Exception ae)
            {
                System.out.println(ae);
            }
            
            
            
        }
        if(e.getSource()==ed)
        {
            Long no = Long.parseLong(ten.getText());
            String fn = tfn.getText();
            String ln = tln.getText();
            String g =" ";
            if(r1.isSelected())
            {
                g="Male";
                
            }
            if(r2.isSelected())
            {
                g="Female";
                
            }
            String bnm = cbn.getSelectedItem().toString();
            String ye = cy.getSelectedItem().toString();
            String adr = tad.getText();
            String cno = tcn.getText();
            String eid = tem.getText();
            
            try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
                   
                   PreparedStatement pt = con.prepareStatement("update details set f_nm=?, l_nm=? , gen=?, b_nm=?, year=?, address=?, c_no=?, email=? where e_no=? ");
                  
                   pt.setString(1, fn);
                   pt.setString(2, ln);
                   pt.setString(3, g);
                   pt.setString(4, bnm);
                   pt.setString(5, ye);
                   pt.setString(6, adr);
                   pt.setString(7, cno);
                   pt.setString(8, eid);
                   pt.setLong(9, no);
                   pt.executeUpdate();
                   JOptionPane.showMessageDialog(this,"UPDATE SUCCESSFULLY...");
                   con.close();   
                   
                    ten.setText("");
                    tfn.setText("");
                    tln.setText("");
                    tad.setText("");
                    tcn.setText("");
                    tem.setText("");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    cbn.setSelectedIndex(0);
                    cy.setSelectedIndex(0);
                    ten.requestFocus();
       
              
            }catch(Exception ae)
            {
                System.out.println(ae);
            }
            
 
        }
        
        if(e.getSource()==d)
        {
            Long n = Long.parseLong(ten.getText());
            
            try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
                   
                   PreparedStatement pt = con.prepareStatement("delete from details where e_no=?");
                   pt.setLong(1, n);
                  
                   pt.executeUpdate();
                   JOptionPane.showMessageDialog(this,"Recored Deleted..");
                   con.close();   
                   
                    ten.setText("");
                    tfn.setText("");
                    tln.setText("");
                    tad.setText("");
                    tcn.setText("");
                    tem.setText("");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    cbn.setSelectedIndex(0);
                    cy.setSelectedIndex(0);
                    ten.requestFocus();
       
              
            }catch(Exception ae)
            {
                System.out.println(ae);
            }
            
        }
       if(e.getSource()==s)
       {
           String no = ten.getText();
           if(no.equals(""))
           {
                   JOptionPane.showMessageDialog(this,"Please Enter Enrollment Number");
                 
           }
           else
           {
            Long no2= Long.parseLong(ten.getText());
            String gen="";
            String b="";
            String yer="";
             try{
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("select * from details where e_no="+no2+"");
                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"NO RECORED FOUND..");
                    
                    tfn.setText("");
                    tln.setText("");
                    tad.setText("");
                    tcn.setText("");
                    tem.setText("");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    cbn.setSelectedIndex(0);
                    cy.setSelectedIndex(0);
                    ten.requestFocus();
       
                }
                else
                {
                        tfn.setText(rs.getString(2));
                        tln.setText(rs.getString(3));
                        gen=rs.getString(4);
                        b=rs.getString(5);
                        yer=rs.getString(6);
                        tad.setText(rs.getString(7));
                        tcn.setText(rs.getString(8));
                        tem.setText(rs.getString(9));
                    
                }
                if(gen.equals("Male"))
                {
                    r1.setSelected(true);
                }
                if(gen.equals("Female"))
                {
                    r2.setSelected(true);
                }
                int j=0,k=0;
                for(int i=0;i<6;i++)
                {
                    if(branch[i].equals(b))
                    {
                        j=i;
                    }
                }
                cbn.setSelectedIndex(j);
                for(int i=0;i<11;i++)
                {
                    if(year[i].equals(yer))
                    {
                        k=i;
                    }
                }
                cy.setSelectedIndex(k);
                
                
            
             }catch(Exception ae)
             {
                System.out.println(ae);
             } 
           }
       }
        
    
    }
    

    @Override
    public void mouseClicked(MouseEvent me) {
            Long no2= Long.parseLong(ten.getText());
            String gen="";
            String b="";
            String yer="";
             try{
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("select * from details where e_no="+no2+"");
                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"NO RECORED FOUND..");
                    ten.setText("");
                    tfn.setText("");
                    tln.setText("");
                    tad.setText("");
                    tcn.setText("");
                    tem.setText("");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    cbn.setSelectedIndex(0);
                    cy.setSelectedIndex(0);
                    ten.requestFocus();
                }
                else
                {
                        tfn.setText(rs.getString(2));
                        tln.setText(rs.getString(3));
                        gen=rs.getString(4);
                        b=rs.getString(5);
                        yer=rs.getString(6);
                        tad.setText(rs.getString(7));
                        tcn.setText(rs.getString(8));
                        tem.setText(rs.getString(9));
                    
                }
                if(gen.equals("Male"))
                {
                    r1.setSelected(true);
                }
                if(gen.equals("Female"))
                {
                    r2.setSelected(true);
                }
                int j=0,k=0;
                for(int i=0;i<6;i++)
                {
                    if(branch[i].equals(b))
                    {
                        j=i;
                    }
                }
                cbn.setSelectedIndex(j);
                for(int i=0;i<11;i++)
                {
                    if(year[i].equals(yer))
                    {
                        k=i;
                    }
                }
                cy.setSelectedIndex(k);
                
                
            
             }catch(Exception ae)
             {
                System.out.println(ae);
             }
       }
    

    @Override
    public void mousePressed(MouseEvent me) {
         }

    @Override
    public void mouseReleased(MouseEvent me) {
      }

    @Override
    public void mouseEntered(MouseEvent me) {
      
     }

    @Override
    public void mouseExited(MouseEvent me) {
       }

    
}
