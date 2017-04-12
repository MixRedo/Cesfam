/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.PropertyReader;

/**
 *
 * @author Daniel
 */
public final class OracleDriver {
    
    public static Connection getConnection() throws SQLException, IOException{
        Connection connection = null;
        
        PropertyReader reader = new PropertyReader();
        String host     = reader.getPropValuesByName("host");
        String port     = reader.getPropValuesByName("port");
        String sid      = reader.getPropValuesByName("sid");
        String username = reader.getPropValuesByName("username");
        String password = reader.getPropValuesByName("password");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String connectionString = String.format("jdbc:oracle:thin:@%1$s:%2$s:%3$s", host, port, sid);
            connection = DriverManager.getConnection(connectionString,username,password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connection;
    }
}
