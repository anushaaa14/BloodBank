import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    static JFrame frame;
    static JTextField username;
    static JPasswordField password;

    static String duser;
    static String dpass;


    public static void create(){
        frame = new JFrame();
        frame.setSize(620,500);
        frame.setLocationRelativeTo(null);

        JLabel main = new JLabel("Login");
        main.setBounds(250, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        JLabel user = new JLabel("Enter Username");
        user.setBounds(120, 55, 400,20);
        username = new JTextField();
        username.setBounds(120, 75, 370,30);


        JLabel pass = new JLabel("Enter Password");
        pass.setBounds(120, 120, 400,20);
        password = new JPasswordField();
        password.setBounds(120, 140, 370,30);

        JButton login = new JButton("Login");
        login.setBounds(120, 205, 370, 30);

        JButton signup = new JButton("Sign Up");
        signup.setBounds(120, 250, 370, 30);

        JButton forgot = new JButton("Forgot Password");
        forgot.setBounds(120, 295, 370, 30);



        frame.add(main);
        frame.add(user);
        frame.add(username);
        frame.add(pass);
        frame.add(password);
        frame.add(login);
        frame.add(signup);
        frame.add(forgot);

        frame.setLayout(null);
        frame.setVisible(true);

        login.addActionListener(e-> {
            if( username.getText().isEmpty()
                    || (password.getText().isEmpty()) ){
                JOptionPane.showMessageDialog(frame, "Please fill all fields");
            }
            else{
                duser = username.getText();
                dpass = password.getText();
                username.setText("");
                password.setText("");

                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    String query = "select * from user1 where username = '"+duser+"' and password = '"+dpass+"'";
                    java.sql.ResultSet rs = stat.executeQuery(query);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(frame, "Login Successful");
                        frame.dispose();
                        Home.create();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Login Failed");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        signup.addActionListener(e-> {
            frame.dispose();
            SignUp.create();
        });

        forgot.addActionListener(e-> {
            frame.dispose();
            //ForgotPassword.create();
        });


    }

    public static void main(String[] args) {
        create();
    }
}
