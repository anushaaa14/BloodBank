import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDonor {

    static JFrame frame;
    static JTextField idinp;
    static JTextField nameimp;
    static JTextField phoneimp;
    static JTextField ageimp;
    static JTextField bloodgrpimp;
    static JTextField dateimp;

    static Integer did;
    static String dname;
    static String dph;
    static String dage;
    static String dbg;
    static String ddate;

    public static void create(){

            frame = new JFrame();
            frame.setSize(600, 500);

            JLabel main = new JLabel("Update Donor");
            main.setBounds(207, 5, 250, 40);

            JLabel id = new JLabel("Enter ID");
            id.setBounds(120, 55, 400, 20);
            idinp = new JTextField();
            idinp.setBounds(120, 75, 370, 30);

            JLabel name = new JLabel("Enter Name");
            name.setBounds(120, 120, 400, 20);
            nameimp = new JTextField();
            nameimp.setBounds(120, 140, 370, 30);

            JLabel ph = new JLabel("Enter Phone number");
            ph.setBounds(120, 185, 400, 20);
            phoneimp = new JTextField();
            phoneimp.setBounds(120, 205, 370, 30);

            JLabel age = new JLabel("Enter Age");
            age.setBounds(120, 250, 400, 20);
            ageimp = new JTextField();
            ageimp.setBounds(120, 270, 370, 30);

            JLabel bg = new JLabel("Enter Blood Group");
            bg.setBounds(120, 315, 400, 20);
            bloodgrpimp = new JTextField();
            bloodgrpimp.setBounds(120, 335, 370, 30);

            JLabel date = new JLabel("Enter Date");
            date.setBounds(120, 380, 400, 20);
            dateimp = new JTextField();
            dateimp.setBounds(120, 400, 370, 30);

            JButton update = new JButton("Update");
            update.setBounds(120, 445, 100, 30);
            update.addActionListener(e -> {
                did = Integer.parseInt(idinp.getText());
                dname = nameimp.getText();
                dph = phoneimp.getText();
                dage = ageimp.getText();
                dbg = bloodgrpimp.getText();
                ddate = dateimp.getText();

                if(did.equals("") || dname.equals("") || dph.equals("") || dage.equals("") || dbg.equals("") || ddate.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please fill all the fields");
                }else {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                        Statement stat = conn.createStatement();
                        stat.executeUpdate("update donors set name = '" + dname + "', phoneNo = '" + dph + "', age = '" + dage + "', bldgrp = '" + dbg + "', prevDonation = '" + ddate + "' where id = " + did);
                        JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, "Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            frame.add(main);
            frame.add(id);
            frame.add(idinp);
            frame.add(name);
            frame.add(nameimp);
            frame.add(ph);
            frame.add(phoneimp);
            frame.add(age);
            frame.add(ageimp);
            frame.add(bg);
            frame.add(bloodgrpimp);
            frame.add(date);
            frame.add(dateimp);
            frame.add(update);

            frame.setLayout(null);
            frame.setVisible(true);

    }


}
