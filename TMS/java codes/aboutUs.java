package tool.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class aboutUs extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b1;
        
        public static void main(String[] args) {
            new aboutUs().setVisible(true);
            
	}
    
        public aboutUs() {

        super("About Us - Team-10");
        setBounds(500,200,810,500);
        contentPane =new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(180, 248, 255));
        contentPane.setLayout(null);
        setResizable(false);
        
        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(180, 248, 255)));
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("tool\\management\\system\\icons\\tenth.png"));
        Image img2 =img1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        b1.setIcon(img3);
        b1.setForeground(new Color(204, 0, 102));
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b1.setBounds(690, 13, 96, 27);
        b1.setBackground(new Color(180, 248, 255));
	contentPane.add(b1);
        
        
        JLabel l2 = new JLabel("New label");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("tool\\management\\system\\icons\\logo.png"));
            Image i5 = i4.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l2 = new JLabel(i6);
            l2.setBounds(500, 40, 100, 100);
            contentPane.add(l2);


            JLabel l3 = new JLabel("Tool");
            l3.setForeground(new Color(0, 250, 154));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(160, 40, 150, 55);
            contentPane.add(l3);

            JLabel l4 = new JLabel("Mangement System");
            l4.setForeground(new Color(127, 255, 0));
            l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l4.setBounds(70, 90, 405, 40);
            contentPane.add(l4);

            JLabel l5 = new JLabel("v1.0");
            l5.setForeground(new Color(30, 144, 255));
            l5.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            l5.setBounds(185, 140, 100, 21);
            contentPane.add(l5);


            JLabel l6 = new JLabel("Developed By : Nirmal, Raghav, Ravi");
            l6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            l6.setBounds(70, 198, 600, 35);
            contentPane.add(l6);

            JLabel l7 = new JLabel("Contact Us : 04nirmalgiri@gmail.com");
            l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l7.setBounds(70, 260, 600, 34);
            contentPane.add(l7);
            
        
    
        }
        
        public void actionPerformed(ActionEvent ae){
            try{

                
                if(ae.getSource() == b1){
                this.setVisible(false);
		new Home().setVisible(true);

            }
            }catch(Exception e){
                
            }
        }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}

