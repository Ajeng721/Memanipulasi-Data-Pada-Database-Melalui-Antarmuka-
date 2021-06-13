/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan.ui;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import Perpustakaan.Model.Buku;
import Perpustakaan.Helper.ConnectionHelper;
import Perpustakaan.Manager.BukuManager;
import Perpustakaan.Model.Buku;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ajengnur
 */
public class AddBookJFrame extends javax.swing.JFrame {

    String penerbit = "";
    String formTitle = "";
    int bukuId = 0;
    Buku bukuGlobal;
    
    
    public AddBookJFrame() {
        initComponents();
        
    }
    public AddBookJFrame(String title, int id) {
       
        initComponents();
        setLocationRelativeTo (null);
        addBookLable.setText("Update buku");
        formTitle = title;
        bukuId = id;
        try {
            Connection con = ConnectionHelper.getConnection();
            Statement stm = con.createStatement();
            
            String query = "SELECT *FROM buku";
            
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                bookTitleField.setText(rs.getString("id_buku"));
                bookAuthorField.setText(rs.getString("pengarang"));
                switch(rs.getString("penerbit")) {
                    case "Jember Pustaka":
                        jbrPustakaRadBtn.setSelected(true);
                        break;
                    case "Gramedia":
                         gramediaRadBtn.setSelected(true);
                        break;  
                    case "Polije Press":
                        polijePressRadBtn.setSelected(true);
                        break;   
                    case "RRI Library":
                        rriLibRadBtn.setSelected(true);
                        break; 
                    default:
                        System.out.println("Tidak Terpilih");                        
                }
            }
        } catch (Exception e){
            System.out.println("Error"+e.getMessage());
                                                   
        }        
    }
    public void addBook() {
        try
        {
            Connection con = ConnectionHelper.getConnection();
            Statement stm = con.createStatement();
            
            getPenerbitRadBtn();
            
            String query = "INSERT INTO buku (judul_buku, pengarang, penerbit, tahun_terbit)" 
                + "VALUES ('"+ bookTitleField.getText() + "', '"+ bookAuthorField.getText()
                +"', '"+ penerbit +"', '"+ thnTerbitComboBox.getSelectedItem()+"')";
            
            
            
            
            stm.executeUpdate(query);
            
            JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);
            AddBookJFrame.this.setVisible(false);
            new ShowBookJframe().setVisible(true);
                                    
        } catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public void updateBook(int id) {
        try
        {
            Connection con = ConnectionHelper.getConnection();
            Statement stm = con.createStatement();
            
            getPenerbitRadBtn();
            
            String query = "UPDATE buku SET judul_buku = '"+ bookTitleField.getText() +"', pengarang = '" + bookAuthorField.getText() +"'," 
                    + " penerbit = '"+ penerbit +"', tahun_terbit = '"+ thnTerbitComboBox.getSelectedItem() + "' WHERE id_buku = " + id;
            
            stm.executeUpdate(query);
            
            JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate", "Sucsess!", JOptionPane. INFORMATION_MESSAGE); 
            AddBookJFrame.this.setVisible(false);
            new ShowBookJframe().setVisible(true);            
                    
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            
        }
    }
    
    public void getPenerbitRadBtn(){
        if (jbrPustakaRadBtn.isSelected()){
            penerbit = "Jember Pustaka";
            jbrPustakaRadBtn.setSelected(true);
        }else if (gramediaRadBtn.isSelected()){
            penerbit = "Gramedia";
            gramediaRadBtn.setSelected(true);
        }else if (polijePressRadBtn.isSelected()){
            penerbit = "Polije Press";
            polijePressRadBtn.setSelected(true);
        }else if (rriLibRadBtn.isSelected()) {
            penerbit = "RRI Library";
            rriLibRadBtn.setSelected(true);
                                            
        }
    }
    
    //untuk memberikan validasi input
private boolean validateInput() throws SQLException {
    boolean isCompleted = false;
    
    Buku buku = new Buku();
    
    if (bookTitleField.getText().isEmpty()) {
        isCompleted = false;
        bookTitleField.requestFocus();
    } else {
        buku.setJudul_buku(bookTitleField.getText());
        isCompleted = true ;
    }
    if (bookAuthorField.getText().isEmpty()) {
        isCompleted = false;
        bookAuthorField.requestFocus();
    }else {
        buku.setPengarang(bookAuthorField.getText());
        isCompleted = true;
    }
    
    //untuk memberi validasi input di radio button
    if (jbrPustakaRadBtn.isSelected()) {
        buku.setPenerbit(jbrPustakaRadBtn.getText());
        isCompleted = true;
    } else if (gramediaRadBtn.isSelected()) {
        buku.setPenerbit(gramediaRadBtn.getText());
        isCompleted = true;    
    } else if (polijePressRadBtn.isSelected()) {
        buku.setPenerbit(polijePressRadBtn.getText());
        isCompleted = true;
    } else if (rriLibRadBtn.isSelected()) {
        buku.setPenerbit(rriLibRadBtn.getText());
        isCompleted = true;
    } else {
        isCompleted = false;
    }
    buku.setTahun_terbit(Integer.parseInt(thnTerbitComboBox.getSelectedItem().toString()));
    
    if (formTitle.equalsIgnoreCase("Update Buku")) {
        buku.setId_buku(bukuId);
    }    
    bukuGlobal = buku;
    
    
    return false;

}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rootPanel = new javax.swing.JPanel();
        addBookLable = new javax.swing.JLabel();
        bookTitleField = new javax.swing.JTextField();
        bookAuthorField = new javax.swing.JTextField();
        jbrPustakaRadBtn = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gramediaRadBtn = new javax.swing.JRadioButton();
        polijePressRadBtn = new javax.swing.JRadioButton();
        rriLibRadBtn = new javax.swing.JRadioButton();
        thnTerbitComboBox = new javax.swing.JComboBox<>();
        cancelBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();

        addBookLable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addBookLable.setText("Tambah Buku");

        bookAuthorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAuthorFieldActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbrPustakaRadBtn);
        jbrPustakaRadBtn.setText("Jember Pustaka");

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Pengarang");

        label.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        buttonGroup1.add(gramediaRadBtn);
        gramediaRadBtn.setText("Gramedia");
        gramediaRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gramediaRadBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(polijePressRadBtn);
        polijePressRadBtn.setText("Polije Press");

        buttonGroup1.add(rriLibRadBtn);
        rriLibRadBtn.setText("RRI Library");
        rriLibRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rriLibRadBtnActionPerformed(evt);
            }
        });

        thnTerbitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013" }));
        thnTerbitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thnTerbitComboBoxActionPerformed(evt);
            }
        });

        cancelBtn.setText("Batal");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        submitBtn.setText("Simpan");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addBookLable)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addComponent(label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thnTerbitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bookTitleField)
                                .addComponent(bookAuthorField)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                                    .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(rootPanelLayout.createSequentialGroup()
                                            .addComponent(gramediaRadBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rriLibRadBtn))
                                        .addGroup(rootPanelLayout.createSequentialGroup()
                                            .addComponent(jbrPustakaRadBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                            .addComponent(polijePressRadBtn)))
                                    .addGap(26, 26, 26))))
                        .addGap(0, 55, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn)
                .addGap(41, 41, 41)
                .addComponent(submitBtn)
                .addGap(37, 37, 37))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBookLable, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookAuthorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(jbrPustakaRadBtn)
                    .addComponent(polijePressRadBtn))
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gramediaRadBtn)
                    .addComponent(rriLibRadBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(thnTerbitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(submitBtn))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bookAuthorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAuthorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookAuthorFieldActionPerformed

    private void rriLibRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rriLibRadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rriLibRadBtnActionPerformed

    private void thnTerbitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thnTerbitComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thnTerbitComboBoxActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        
      if (bukuId == 0){
            addBook();
        }else {
            updateBook(bukuId);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        dispose();
        
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void gramediaRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gramediaRadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gramediaRadBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AddBookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AddBookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AddBookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AddBookJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBookJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBookLable;
    private javax.swing.JTextField bookAuthorField;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JRadioButton gramediaRadBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jbrPustakaRadBtn;
    private javax.swing.JLabel label;
    private javax.swing.JRadioButton polijePressRadBtn;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JRadioButton rriLibRadBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JComboBox<String> thnTerbitComboBox;
    // End of variables declaration//GEN-END:variables
}
