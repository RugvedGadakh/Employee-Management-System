package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener{

    Choice cEmpId;
    JButton delete , back;

    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        JLabel tfname = new JLabel();
        tfname.setBounds(200, 100, 150, 30);
        add(tfname);

        // Phone
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        JLabel tfphone = new JLabel();
        tfphone.setBounds(200, 150, 150, 30);
        add(tfphone);

        // Email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        JLabel tfemail = new JLabel();
        tfemail.setBounds(200, 200, 150, 30);
        add(tfemail);

        // Populate details when employee ID is selected
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * FROM employee WHERE empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        tfname.setText(rs.getString("name"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Delete button
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.addActionListener(this);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        add(delete);

        // Back button
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);

        setSize(1000, 400);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == delete){
            try {
                Conn c = new Conn();
                String query = "DELETE FROM employee WHERE empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
