package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    Connection con;
    Statement st;

    
    public ConnectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sian", "root", "usbw");
            st = con.createStatement();
        } catch (Exception g) {
            System.out.println("Error" + g);
        }
    }

    public void updateDB(String sql) {
        try {
            st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet queryDB(String sql) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
        } catch (Exception ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
