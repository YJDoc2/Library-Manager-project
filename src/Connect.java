/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_management;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vatsal Soni
 */
public class Connect {

    private static final Connection con = null;
    private static int instances = 0;
    private static Connect db = null;

    public Connect() {
        if (instances == 0) {
            db = this;
        }
        instances++;
    }

    public static Connection dbConnect() {
        if (con != null) {
            return con;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "1234");
                return con;
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Connect to servers!");
                return null;
            }
        }
    }

    @Override
    public void finalize() {
        instances--;
        if (instances == 0) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
            }
        }
    }
}
