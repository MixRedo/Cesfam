/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cesfam;

import dbDriver.OracleDriver;
import java.sql.*;

/**
 *
 * @author Daniel
 */
public class Cesfam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = OracleDriver.getConnection();
            if (conn != null) {
                System.out.println("Éxcito");
                String query = "SELECT * FROM USUARIO";
                Statement stmnt = conn.createStatement();
                ResultSet rs = stmnt.executeQuery(query);
                while(rs.next()){
                    System.out.println(rs.getString("NOMBRES"));
                }
                conn.close();
            }else{
                System.out.println("Ayy lamo");
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
