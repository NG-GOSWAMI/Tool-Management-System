package tool.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddTool extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2;
    JComboBox comboBox;
        
    public static void main(String[] args) {
	new AddTool().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
	t1.setText("" + rd.nextInt(1000 + 1));
    }

    public AddTool() {
        super("Add Tool");
        setBounds(600, 200, 450, 442);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        setResizable(false);

	JLabel l1 = new JLabel("Tool Name");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(73, 84, 90, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("ISI Number");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 117, 90, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Seller");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 150, 90, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(73, 216, 90, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Tool_id");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(73, 51, 90, 22);
	contentPane.add(l5);


	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(169, 54, 198, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(169, 87, 198, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(169, 120, 198, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(169, 153, 198, 20);
	contentPane.add(t4);

        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(169, 219, 198, 20);
	contentPane.add(t5);


        b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Tools", TitledBorder.LEADING,
			TitledBorder.TOP, null, new Color(0, 0, 255)));
	panel.setBounds(10, 29, 398, 344);
	contentPane.add(panel);
        
        panel.setBackground(new Color(240, 248, 255));
        contentPane.setBackground(new Color(255, 229, 180));
	random();

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                Statement stmt =con.s;
                String select ="select tool_id, name, isi, seller, price from tool";
                ResultSet rs = stmt.executeQuery(select);
                
                int flag =0;
                while(rs.next()){
                    if(rs.getString("isi").equals(t3.getText())){
                        flag=flag+1;
                        JOptionPane.showMessageDialog(null, "Tool already exist");
                        break;
                    }
                }
                if(flag == 0){
                String sql = "insert into tool(tool_id, name, isi, seller, price) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, t1.getText());
		st.setString(2, t2.getText());
		st.setString(3, t3.getText());
		st.setString(4, t4.getText());
		st.setString(5, t5.getText());
		
                int k = st.executeUpdate();
		if (k > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
		else
                    JOptionPane.showMessageDialog(null, "Error");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                
		st.close();
                }
            }
         
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){
            
        }
    }
}
