import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp {

    static JFrame frame;
    static JTextField username;
    static JPasswordField password;
    static JTextField nameimp;
    static JTextField phone;

    static String duser;
    static String dpass;
    static String dname;
    static String dph;

    public static void create() {
        frame = new JFrame();
        frame.setSize(600, 500);

        JLabel main = new JLabel("Sign Up");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial", Font.TRUETYPE_FONT, 35));

        JLabel user = new JLabel("Enter Username");
        user.setBounds(120, 55, 400, 20);
        username = new JTextField();
        username.setBounds(120, 75, 370, 30);

        JLabel pass = new JLabel("Enter Password");
        pass.setBounds(120, 120, 400, 20);
        password = new JPasswordField();
        password.setBounds(120, 140, 370, 30);

        JLabel name = new JLabel("Enter Name");
        name.setBounds(120, 185, 400, 20); // Corrected from user.setBounds
        nameimp = new JTextField();
        nameimp.setBounds(120, 205, 370, 30);

        JLabel ph = new JLabel("Enter Phone number");
        ph.setBounds(120, 250, 400, 20); // Corrected from user.setBounds
        phone = new JTextField();
        phone.setBounds(120, 270, 370, 30);

        JButton signup = new JButton("Sign Up");
        signup.setBounds(120, 315, 100, 30);
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUpAction();
            }
        });

        frame.add(main);
        frame.add(user);
        frame.add(username);
        frame.add(pass);
        frame.add(password);
        frame.add(name);
        frame.add(nameimp);
        frame.add(ph);
        frame.add(phone);
        frame.add(signup);

        frame.setLayout(null);
        frame.setVisible(true);
    }



    public static void signUpAction() {
        duser = username.getText();
        dpass = password.getText();
        dname = nameimp.getText();
        dph = phone.getText();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
            Statement stat=conn.createStatement();

            String query = "INSERT INTO user1 (id,username, password, name, phone) VALUES (userSeq.NextVAL,'" + duser + "', '" + dpass + "', '" + dname + "', '" + dph + "')";
            System.out.println(query);
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(frame, "User added successfully");
            frame.dispose();
            Login.create();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        create();
    }
}
