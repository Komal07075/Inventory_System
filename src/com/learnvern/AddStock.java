package com.learnvern;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddStock implements ActionListener{
    JTextField t1,t2,t3;
    JButton b1;
    JFrame frame;
     
    public AddStock(){
        frame = new JFrame("AddStock Form");
        frame.setLayout(null);
        frame.setBounds(150,150,450,450);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //free memory after exit
        JLabel l1,l2,l3;
        l1 = new JLabel("Enter StockName ");
       // l1.setFont(new Font("Tohoma",Font.BOLD,14));
        //l1.setForeground(Color.WHITE);
        l2 = new JLabel("Enter Quantity ");
        l3 = new JLabel("Enter Price ");
        
        t1= new JTextField();
        t2 = new JTextField();
        t3= new JTextField();
        
        b1 = new JButton("Add Stock");
        b1.setBounds(160,230,120,25);
        b1.addActionListener(this);
        l1.setBounds(100,100,120,25);
        l2.setBounds(100,140,120,25);
        l3.setBounds(100,180,120,25);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
       Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT); //scaled image
       ImageIcon i3 = new ImageIcon(i2); //convert it into imageicon
       JLabel image = new JLabel(i3); //can't place image directly
       image.setBounds(0,270,450,450); //work when setlayout function will be run
       frame.add(image); //add image on frame
       
        
        t1.setBounds(220,100,120,25);
        t2.setBounds(220,140,120,25);
        t3.setBounds(220,180,120,25);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(b1);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        
        
       
        
        
        
        
       
       
        frame.setVisible(true);
    
}
    public static void main(String[] args){
        new AddStock();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String stockname = t1.getText().toString();
            int qty = Integer.parseInt(t2.getText().toString());
            int price = Integer.parseInt(t3.getText().toString());
            
            String query = "insert into stock values('"+stockname+"','"+qty+"','"+price+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Stock added successfully");
                frame.setVisible(false);
                new HomePage();
            }catch(Exception ae){
                ae.printStackTrace();
                
            }
            
            
            
        }
        
    }
}