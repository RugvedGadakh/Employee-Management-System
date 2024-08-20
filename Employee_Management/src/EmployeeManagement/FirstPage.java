package EmployeeManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener {
    FirstPage(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif", Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);


        JButton clickHere = new JButton("Click Here To Continue");
        clickHere.setBounds(400,400,300,70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this);
        image.add(clickHere);


        setSize(1170,650);
        setLocation(100,50);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }


    public static void main(String[] args) {
        new FirstPage();
        System.out.println("Hello");
    }
}
