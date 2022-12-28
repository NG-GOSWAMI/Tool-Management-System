package tool.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ToolManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public ToolManagementSystem() {
		
            
            super("Tool Management System");
                setSize(1366,390);
                setLayout(null);
                setLocation(300,300);
                

		l1 = new JLabel("");
                
                
                b1 = new JButton("Next");
                b1.setForeground(Color.white);
                b1.setBackground(new Color(137, 76, 22));
                b1.setFont(new Font("Tahoma", Font.PLAIN, 15));

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("tool\\management\\system\\icons\\first.jpeg"));
                Image i3 = i1.getImage().getScaledInstance(1280, 567,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                b1.setBounds(1050,250,100,30);
		l1.setBounds(0, 0, 1366, 390);
                setResizable(false);
                
                l1.add(b1);
		add(l1);
                
                b1.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login_user().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                ToolManagementSystem window = new ToolManagementSystem();
                window.setVisible(true);			
	}
}
