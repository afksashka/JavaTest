import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.Statement;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        String query = "select id, Name from Status";
        String queryCount = "select Count(*) from Status";
        String url ="jdbc:sqlserver://LAPTOP-3BK0QRNH\\SQLEXPRESS;database=Workers;trustServerCertificate=true";
        String user="sa";
        String password="sa";
        String db="Workers";
        Connection connection;
        Statement statement;
        ResultSet rs;


        String[] col = {"Id", "Name"};
        String[][] data = new String[10][col.length];
        try {
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("id");
                data[i][1]=rs.getString("Name");
                i++;

            }
        } catch (SQLException e) {
            System.out.printf("error!!!");
            System.out.printf(e.getMessage().toString());
        }


        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500,500,500,300);
        jFrame.setTitle("Тестовое");
        JTable table = new JTable(data, col);
        JScrollPane scrollPane = new JScrollPane(table);
        jFrame.getContentPane().add(scrollPane);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}