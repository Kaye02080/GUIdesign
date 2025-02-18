/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author milan
 */
public class db {
    private Connection connect;

       // constructor to connect to our database
        public db(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/moneyremittance_db", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
        
        public ResultSet getData(String sql) throws SQLException{
            java.sql.Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
}
