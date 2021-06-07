/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan.Helper;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ajengnur
 */
//mendeklarasikan untuk membantu agar terkoneksi dengan mysql
public class ConnectionHelper {
  //untuk memanggil database dengan nama perpustakaan
    private static final String DB_NAME = "perpustakaan";
    //nama pengguna default
    private static final String USER = "root";
    //pasword dari data base mysql
    private static final String PASWORD = "";
    //untuk mengoneksikan pda url databse
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    
    public static Connection getConnection() throws SQLException{
        //agar terkoneksikan dengan driver manager
        //mengembalikan pernyataan connection
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL, USER, PASWORD);
        return connection;
        
        
    }
}

