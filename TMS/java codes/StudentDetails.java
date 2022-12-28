package tool.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    
    public static void main(String[] args) {
	new StudentDetails().setVisible(true);
    }

    public void student() {
        try {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public StudentDetails() {
        
        super("Student Details");
        setBounds(350, 200, 910, 485);
        contentPane = new JPanel();
	contentPane.setBackground(new Color(220, 220, 220));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 229, 180));
	contentPane.setLayout(null);
        setResizable(false);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 288);
	contentPane.add(scrollPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 0).toString());
            }
	});
	table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);


	JLabel l1 = new JLabel("Student Details");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
	l1.setBounds(250, 20, 400, 47);
	contentPane.add(l1);


	search = new JTextField();
	search.setBackground(new Color(255, 240, 245));
	search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	search.setForeground(new Color(47, 79, 79));
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(97, 89, 500, 33);
	contentPane.add(search);
	search.setColumns(10);

	JLabel l2 = new JLabel("Close");
	l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                
            }
	});
	l2.setForeground(Color.GRAY);
	l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("tool\\management\\system\\icons\\close.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l2.setIcon(i9);
	l2.setBounds(752, 89, 138, 33);
	contentPane.add(l2);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student-Deatails",
		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
	panel.setBounds(68, 59, 790, 370);
        panel.setBackground(new Color(240, 248, 255));
	contentPane.add(panel);
        
	student();
    }
    
}
