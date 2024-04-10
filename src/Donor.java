import javax.swing.*;

public class Donor {

    static JFrame frame;
    static JButton add;
    static JButton delete;
    static JButton update;
    static JButton view;

    public static void create(){
        frame = new JFrame();
        frame.setSize(600, 500);

        JLabel main = new JLabel("Donor Options");
        main.setBounds(207, 5, 250, 40);
        add = new JButton("Add");
        add.setBounds(200, 100, 100, 30);
        add.addActionListener(e-> {
            AddDonor.create();
        });

        view = new JButton("View");
        view.setBounds(200, 145, 100, 30);
        view.addActionListener(e-> {
            ViewDonors.create();
        });

        delete = new JButton("Delete");
        delete.setBounds(200, 190, 100, 30);
        delete.addActionListener(e-> {
            DeleteDonor.create();
        });

        update = new JButton("Update");
        update.setBounds(200, 235, 100, 30);
        update.addActionListener(e-> {
            UpdateDonor.create();
        });

        frame.add(add);
        frame.add(view);
        frame.add(delete);
        frame.add(update);
        frame.add(main);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
