package com.learnvern;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login implements ActionListener{
    JFrame frame;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1;
    public Login(){
        frame = new JFrame("Login Form");
        frame.setLayout(null);
        frame.setBounds(150,150,450,450);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //free memory after exit
        
        l1 = new JLabel("Enter UserName: ");
        l1.setBounds(40,35,100,10);
        l2 = new JLabel("Enter Password: ");
        l2.setBounds(40,80,100,10);
        t1 = new JTextField();
        t1.setBounds(150,35,160,20);
        p1 = new JPasswordField();
        p1.setBounds(150,80,160,20);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
       Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //scaled image
       ImageIcon i3 = new ImageIcon(i2); //convert it into imageicon
       JLabel image = new JLabel(i3); //can't place image directly
       image.setBounds(320,50,100,100); //work when setlayout function will be run
       frame.add(image); //add image on frame
       
        b1 = new JButton("Login");
        b1.setBounds(140,130,100,20);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        frame.setVisible(true);
        frame.add(l1);
        frame.add(l2);
        frame.add(p1);
        frame.add(t1);
        frame.add(b1);
        
        
    }
    
    public static void main(String[] args){
        new Login();
        
    }
 

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String username = t1.getText().toString();
            String password = p1.getText().toString();
            if(username.equals("admin")&& password.equals("admin123"))
            {
                new HomePage();
                frame.dispose();
            }
            else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                    t1.setText("");
                    p1.setText("");
                    }
            
        }
    }
}