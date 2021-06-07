/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan.Helper;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajengnur
 */
//mendeklarasikan class mengecek koneski dengan database perpustakaan
//pada mysl
public class CheckConnection {
    public static void main(String[] args){
        isConnection();
        showBook();
        
    }
               
    private static boolean isConnection(){
        try {
            //untuk membantu mengoneksikan pada database
           ConnectionHelper.getConnection();
           //mencetak atau menampilkan output ketika berhasil mengoneksikan
            System.out.println("Database Connected!");
            //mengembalikan pernyataan benar/true
            return true;
        } catch (SQLException ex) {
            //untuk membuang eror pada program
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
            //menceta atau menampikan output ketika java belum terkoneksi dengan mysql
             System.out.println("Failed to connect database");
             //mengembalikan pernyataan false
               return false;
        } 
    }
    public static void showBook(){
            try{  
           Connection conn = (Connection) ConnectionHelper.getConnection();
           Statement stmn = conn.createStatement();
           ResultSet rs = stmn.executeQuery("Select * from buku");
           
           //perulangan untuk menampilkan isi tabel atu output 
           //yang dieksekusi pada system out prtinln dibawah
           while (rs.next()){
               //mencetak atau menampilkan output 
               System.out.println("ID Buku:"
                       +rs.getString("id_buku")
                       + "judul Buku: "
                       +rs.getString("judul_buku")
                       +",Pengarang: "
                       +rs.getString("pengarang")
                       +"Penerbit :"
                       +rs.getString("penerbit")       
                       +",Tahun terbit:"
                       +rs.getString("tahun_terbit"));
           }
    }catch (SQLException ex){
        Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
           
           
       }
}
}


    
    

