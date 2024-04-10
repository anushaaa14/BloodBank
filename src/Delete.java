import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    static JFrame frame;
    static JTextField bloodgroup;

    public static void create() {
        frame = new JFrame();
        frame.setSize(600, 500);

        JLabel main = new JLabel("Delete Blood");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial", Font.TRUETYPE_FONT, 35));

        JLabel bg = new JLabel("Enter Blood Group");
        bg.setBounds(120, 55, 400, 20);
        bloodgroup = new JTextField();
        bloodgroup.setBounds(120, 75, 370, 30);

        JLabel q = new JLabel("Enter Quantity");
        q.setBounds(120, 120, 400, 20);
        JTextField quantity = new JTextField();
        quantity.setBounds(120, 140, 370, 30);

        JButton delete = new JButton("Delete");
        delete.setBounds(120, 380, 100, 30);
        delete.addActionListener(e -> {
            String dbg = bloodgroup.getText();

            if(dbg.equals("")){
                JOptionPane.showMessageDialog(frame, "Please fill all the fields");}
            else{
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                    Statement stat = conn.createStatement();
                    stat.executeUpdate("update blood set quantity = quantity - " + quantity.getText() + " where bloodgrp = '" + dbg + "'");
                    JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        frame.add(main);
        frame.add(bg);
        frame.add(bloodgroup);
        frame.add(delete);
        frame.add(q);
        frame.add(quantity);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        create();
    }
}
