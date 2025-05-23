package GUI;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import javax.swing.JRadioButton;

import java.util.Enumeration;

import stage4.OrdersAndPayment.*;
import stage4.TicketRelated.*;
import stage4.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/** 
 *
 * @author lccra
 */
public class GUI_OrderMovieTicket extends javax.swing.JFrame {
    
    private ArrayList<Movie> movieList;
    
    private GUI_MainMenuTicket guiMainMenuTicket;
    
    private DetailTicketBought detail;
            
    /**
     * Creates new form GUI_OrderMovieTicket
     */
    public GUI_OrderMovieTicket() {
        
        initComponents();
        this.detail = new DetailTicketBought((byte) 10, (byte) 15);
        populateTable();        
    }
    
    /**
     * Creates new form GUI_OrderMovieTicket
     */
    public GUI_OrderMovieTicket(GUI_MainMenuTicket guiMainMenuTicket) {
        this.guiMainMenuTicket = guiMainMenuTicket;
        
        initComponents();
        this.detail = new DetailTicketBought((byte) 10, (byte) 15);
        populateTable();        
    }
    
    public void populateTable() {
        this.movieList = MovieManager.getMovies();
        DefaultTableModel movieModel = (DefaultTableModel) this.tblMovies.getModel();
        
        Object[][] movieRows = new Object[movieList.size()][4];
        for (int i = 0; i < movieList.size(); i++) {
            movieRows[i][0] = movieList.get(i).getMovieID();
            movieRows[i][1] = movieList.get(i).getTitle();
            movieRows[i][2] = movieList.get(i).getGenre();
            movieRows[i][3] = movieList.get(i).getDurationMinutes();
            
            movieModel.addRow(movieRows[i]);
            }
    }
    
    public GUI_OrderMovieTicket(GUI_LogIn guiLogin) {
        this.movieList = MovieManager.getMovies();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGPayment = new javax.swing.ButtonGroup();
        lblCustomerNameTicket = new javax.swing.JLabel();
        lblPaymentTypeTicket = new javax.swing.JLabel();
        txtCustomerNameTicket = new javax.swing.JTextField();
        RbtnCash = new javax.swing.JRadioButton();
        RbtnCredit = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMovies = new javax.swing.JTable();
        nextButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order Movie Ticket");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomerNameTicket.setText("Order For:");
        getContentPane().add(lblCustomerNameTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, -1, -1));

        lblPaymentTypeTicket.setText("Payment Type:");
        getContentPane().add(lblPaymentTypeTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 59, -1, -1));

        txtCustomerNameTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameTicketActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerNameTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 20, 120, -1));

        btnGPayment.add(RbtnCash);
        RbtnCash.setSelected(true);
        RbtnCash.setText("Cash");
        RbtnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnCashActionPerformed(evt);
            }
        });
        getContentPane().add(RbtnCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        btnGPayment.add(RbtnCredit);
        RbtnCredit.setText("Credit Card");
        getContentPane().add(RbtnCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        tblMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movie ID", "Title ", "Genre", "Duration (Min)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMovies);
        if (tblMovies.getColumnModel().getColumnCount() > 0) {
            tblMovies.getColumnModel().getColumn(1).setHeaderValue("Genre");
            tblMovies.getColumnModel().getColumn(2).setHeaderValue("Duration");
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 400, 210));

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        setSize(new java.awt.Dimension(414, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerNameTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameTicketActionPerformed

    private void RbtnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbtnCashActionPerformed

    private void tblMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMoviesMouseClicked

//        DefaultTableModel model = (DefaultTableModel)tblMovies.getModel();
//        int selectedRowIndex = tblMovies.getSelectedRow();
     
//        jTextFieldTitle.setText(model.getValueAt(selectedRowIndex, 0).toString());
 
    }//GEN-LAST:event_tblMoviesMouseClicked

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.guiMainMenuTicket.setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.tblMovies.getSelectedRow();
        
        if (selectedRow != -1) {
            this.detail.setCustomer(new Customer(this.txtCustomerNameTicket.getText()));
            
            Enumeration<AbstractButton> buttons = this.btnGPayment.getElements();
            
            while (buttons.hasMoreElements()) {
                JRadioButton aButton = (JRadioButton) buttons.nextElement();
                
                if (aButton.isSelected()) {
                    this.detail.setPaymentType(aButton.getText());
                }
            }
            
            byte id = (byte) this.tblMovies.getValueAt(selectedRow, 0);
            Movie movie = MovieManager.searchMovie(id);
            this.setVisible(false);
            GUI_OrderShowtime guiOrderShowtime = new GUI_OrderShowtime(this.guiMainMenuTicket, this, movie, this.detail);
            guiOrderShowtime.setVisible(true);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderMovieTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderMovieTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderMovieTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderMovieTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_OrderMovieTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbtnCash;
    private javax.swing.JRadioButton RbtnCredit;
    private javax.swing.ButtonGroup btnGPayment;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustomerNameTicket;
    private javax.swing.JLabel lblPaymentTypeTicket;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JTable tblMovies;
    private javax.swing.JTextField txtCustomerNameTicket;
    // End of variables declaration//GEN-END:variables
}
