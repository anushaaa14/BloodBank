import javax.swing.*;
import java.awt.*;

public class Home {

    static JFrame frame;
    static JLabel main;
    static JButton logout;
    static JButton add;
    static JButton view;
    static JButton delete;
    static JButton update;

    public static void create() {
        frame = new JFrame();
        frame.setSize(600, 500);

        main = new JLabel("Blood Donation Management System");
        main.setBounds(40, 5, 600, 40);
        main.setFont(new Font("Arial", Font.TRUETYPE_FONT, 35));

        logout = new JButton("Logout");
        logout.setBounds(200, 245, 100, 30);
        logout.addActionListener(e-> {
            frame.dispose();
            Login.create();
        });

        add = new JButton("Add");
        add.setBounds(200, 100, 100, 30);
        add.addActionListener(e-> {
            //frame.dispose();
            Add.create();
        });

        view = new JButton("View");
        view.setBounds(200, 145, 100, 30);
        view.addActionListener(e-> {
            //frame.dispose();
            View.create();
        });

        delete = new JButton("Delete");
        delete.setBounds(200, 190, 100, 30);
        delete.addActionListener(e-> {
            //frame.dispose();
            Delete.create();
        });

        JButton donor = new JButton("Donor");
        donor.setBounds(200, 290, 100, 30);
        donor.addActionListener(e-> {
            //frame.dispose();
            Donor.create();
        });




        frame.add(main);
        frame.add(logout);
        frame.add(add);
        frame.add(view);
        frame.add(delete);
        //frame.add(update);
        frame.add(donor);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        create();
    }
}
