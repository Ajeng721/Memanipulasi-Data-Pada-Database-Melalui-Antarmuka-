 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan.Manager;

import Perpustakaan.Helper.CheckConnection;
import static Perpustakaan.Helper.CheckConnection.showBook;
import Perpustakaan.Helper.ConnectionHelper;
import Perpustakaan.Model.Buku;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ajengnur
 */
public class BukuManager {
     public static void main(String[] args){
          
         
     }
      public static List<Buku> showAllBook(){
       List<Buku> bukulist = new ArrayList();
       
           try{  
           Connection conn = (Connection) ConnectionHelper.getConnection();
           Statement stmn = conn.createStatement();
           ResultSet rs = stmn.executeQuery("Select * from buku");
           
           //perulangan untuk menampilkan isi tabel buku sesuai database di mySQL  
           //yang dieksekusi pada system out println dibawah
           while (rs.next()){
              Buku buku = new Buku();
              buku.setId_buku(Integer.parseInt(rs.getString("id_buku")));
              buku.setJudul_buku(rs.getString("judul_buku"));
              buku.setPenerbit(rs.getString("penerbit"));
              buku.setPengarang(rs.getString("pengarang"));
              buku.setTahun_terbit(Integer.valueOf(rs.getString("tahun_terbit")));
              
              bukulist.add(buku);
           }
    }catch (SQLException ex){
        Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        
       }
           return bukulist;  
      }
           
    public static Buku showBook (int id) throws SQLException {
         Connection conn = ConnectionHelper.getConnection();
         Buku buku = new Buku ();
         
         var pstmn = conn.prepareStatement("Select * from buke Where id_buku = ?");
         pstmn.setInt(1, id);
         ResultSet rs = pstmn.executeQuery();
         
         while (rs.next()) {
             buku.setId_buku(Integer.parseInt(rs.getString("id+buku")));
             buku.setPenerbit(rs.getString("judul_buku"));
             buku.setPenerbit(rs.getString("penerbit"));
             buku.setPengarang(rs.getString("pengarang"));
             buku.setTahun_terbit(Integer.valueOf(rs.getString("tahun_terbit")));
         }
        return buku;
               
           }

         
public static void updateBook(Buku buku) throws SQLException {
    Connection conn = ConnectionHelper.getConnection();
    var pstmn = conn.prepareStatement("UPDATE buku SET judul_buku = ?, "
             + "pengarang = ?, penerbit = ?, tahun_terbit = ? WHERE id_buku = ?");
    pstmn.setString(1, buku.getJudul_buku());
    pstmn.setString(2, buku.getPengarang());
    pstmn.setString(3, buku.getPenerbit());
    pstmn.setInt(4, buku.getTahun_terbit());
    pstmn.setInt(5, buku.getId_buku());
    pstmn.execute();

    }

 
public static void insertBook(Buku buku) throws SQLException {
    Connection conn = ConnectionHelper.getConnection();
    var pstmn = conn.prepareStatement("insert into buku (judul_buku, "
             + "pengarang, penerbit, tahun_terbit) values (?, ?, ?, ?)");
    pstmn.setString(1, buku.getJudul_buku());
    pstmn.setString(2, buku.getPengarang());
    pstmn.setString(3, buku.getPenerbit());
    pstmn.setInt(4, buku.getTahun_terbit());
    pstmn.execute();
}
}

    
     
 
         
         


    
    
          
          
           
        


