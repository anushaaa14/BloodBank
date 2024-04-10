import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDonor {

    static JFrame frame;
    static JTextField idinp;


    static public void create() {
        frame = new JFrame();
        frame.setSize(600, 500);

        JLabel main = new JLabel("Delete Donor");
        main.setBounds(207, 5, 250, 40);

        JLabel id = new JLabel("Enter ID");
        id.setBounds(120, 55, 400, 20);
        idinp = new JTextField();
        idinp.setBounds(120, 75, 370, 30);

        JButton delete = new JButton("Delete");
        delete.setBounds(120, 120, 100, 30);
        delete.addActionListener(e -> {
            String did = idinp.getText();

            if(did.equals("")){
                JOptionPane.showMessageDialog(frame, "Please fill all the fields");

            } else {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                    Statement stat = conn.createStatement();
                    stat.executeUpdate("delete from donors where id = " + did);
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
        frame.add(id);
        frame.add(idinp);
        frame.add(delete);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
