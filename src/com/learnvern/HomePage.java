package com.learnvern;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage implements ActionListener{
    JFrame frame;
    JMenuBar bar;
    JMenu stock;
    JMenuItem addstock;
    
    public HomePage(){
        frame = new JFrame("Home Page");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setBounds(150,150,450,450);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //free memory after exit
        
        addstock = new JMenuItem("AddStock");
        
        stock = new JMenu("Stock");
        stock.add(addstock);
        
        bar = new JMenuBar ();
        bar.add(stock);
        addstock.addActionListener(this);
        frame.add(bar);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT); //scaled image
        ImageIcon i3 = new ImageIcon(i2); //convert it into imageicon
        JLabel image = new JLabel(i3); //can't place image directly
        image.setBounds(0,0,450,450); //work when setlayout function will be run
        frame.add(image); //add image on frame
       
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addstock){
            frame.dispose();
            new AddStock();
        }
    }
}