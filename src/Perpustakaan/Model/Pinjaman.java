/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan.Model;

/**
 *
 * @author ajengnur
 */
public class Pinjaman {
        private int id_pinjaman;
        private String buku_id_buku;
        private String nim;
        private String tanggal_pinjam;

    public int getId_pinjaman() {
        return id_pinjaman;
    }

    public void setId_pinjaman(int id_pinjaman) {
        this.id_pinjaman = id_pinjaman;
    }

    public String getBuku_id_buku() {
        return buku_id_buku;
    }

    public void setBuku_id_buku(String buku_id_buku) {
        this.buku_id_buku = buku_id_buku;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(String tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }
}
    
    
    

