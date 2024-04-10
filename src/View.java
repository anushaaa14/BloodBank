
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class View
{
    public static void create()
    {
        JFrame frame = new JFrame();
        String[] columns = {"Blood Group", "Quantity"};
        Object[][] data = new Object[8][2];

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
            Statement stat=conn.createStatement();
            ResultSet res=stat.executeQuery("select * from blood");

            int i = 0;
            while( res.next() )
            {
                data[i][0] = res.getString("bloodgrp");
                data[i][1] = res.getInt("quantity");

                i++;
                //System.out.println(res.getInt("customer_id")+" "+res.getString("name")+" "+res.getString("address")+" "+res.getInt("age")+" " + res.getInt("phone_no"));
            }

            res=stat.executeQuery("select * from membership order by customer");
            i = 0;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JTable table = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setBounds(30, 75, 200, 300);

        JLabel lblHeading = new JLabel("Display All Blood Info");
        lblHeading.setBounds(207, 5, 250, 40);
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,40));
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
	
	public static void main( String[] args )
	{
		create();
	}
}


/*
 * REFERECNES :-
 * http://www.zentut.com/java-swing/how-to-use-jtable-to-display-data/
 *
 *
 */