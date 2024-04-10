import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddDonor {

    static JFrame frame;
    static JTextField nameimp;
    static JTextField phoneimp;
    static JTextField ageimp;
    static JTextField bloodgrpimp;
    static JTextField dateimp;

    static String dname;
    static String dph;
    static String dage;
    static String dbg;
    static String ddate;

    public static void create(){

        frame = new JFrame();
        frame.setSize(600, 500);

        JLabel main = new JLabel("Add Donor");
        main.setBounds(207, 5, 250, 40);

        JLabel name = new JLabel("Enter Name");
        name.setBounds(120, 55, 400, 20);
        nameimp = new JTextField();
        nameimp.setBounds(120, 75, 370, 30);

        JLabel ph = new JLabel("Enter Phone number");
        ph.setBounds(120, 120, 400, 20);
        phoneimp = new JTextField();
        phoneimp.setBounds(120, 140, 370, 30);

        JLabel age = new JLabel("Enter Age");
        age.setBounds(120, 185, 400, 20);
        ageimp = new JTextField();
        ageimp.setBounds(120, 205, 370, 30);

        JLabel bg = new JLabel("Enter Blood Group");
        bg.setBounds(120, 250, 400, 20);
        bloodgrpimp = new JTextField();
        bloodgrpimp.setBounds(120, 270, 370, 30);

        JLabel date = new JLabel("Enter Date");
        date.setBounds(120, 315, 400, 20);
        dateimp = new JTextField();
        dateimp.setBounds(120, 335, 370, 30);

        JButton add = new JButton("Add");
        add.setBounds(120, 380, 100, 30);
        add.addActionListener(e -> {
            dname = nameimp.getText();
            dph = phoneimp.getText();
            dage = ageimp.getText();
            dbg = bloodgrpimp.getText();
            ddate = dateimp.getText();

            if(dname.equals("") || dph.equals("") || dage.equals("") || dbg.equals("") || ddate.equals("")){
                JOptionPane.showMessageDialog(frame, "Please fill all the fields");
            } else {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                    Statement stat = conn.createStatement();
                    stat.executeUpdate("insert into donors values(donSeq.NEXTVAL,'" + dname + "', '" + dph + "', " + dage + ", '" + dbg + "', '" + ddate + "')");
                    JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.add(main);
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
        frame.add(add);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        create();
    }



}
