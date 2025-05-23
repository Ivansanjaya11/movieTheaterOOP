package GUI;

import stage4.*;
import java.util.Date;
import stage4.AnalyticsAndFiles.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDate;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ivans
 */
public class GUI_AnalyticsMenu extends javax.swing.JFrame {
    private GUI_MainMenuFood guiMainMenuFood;
    private GUI_MainMenuTicket guiMainMenuTicket;
    
    private GUI_AnalyticsMenu guiAnalyticsMenu;
    
    /**
     * Creates new form GUI_AnalyticsMenu
     */
    public GUI_AnalyticsMenu() {
        initComponents();
        //this.guiAnalyticsMenu = new GUI_AnalyticsMenu();
        //this.guiAnalyticsMenu.setVisible(true);

    }
    
    public GUI_AnalyticsMenu(GUI_MainMenuFood guiMainMenuFood) {
        initComponents();
        this.guiMainMenuFood = guiMainMenuFood;
        this.setVisible(true);


    }

    public GUI_AnalyticsMenu(GUI_MainMenuTicket guiMainMenuTicket) {
        initComponents();
        this.guiMainMenuTicket   = guiMainMenuTicket;
        this.setVisible(true);

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        returnTicket = new javax.swing.JButton();
        generateReportButtonTicket = new javax.swing.JButton();
        labelTicketStart = new javax.swing.JLabel();
        spinnerTimeTicketStart = new javax.swing.JSpinner();
        labelTicketEnd = new javax.swing.JLabel();
        spinnerTimeTicketEnd = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        returnItemOrder = new javax.swing.JButton();
        generateReportButtonItem = new javax.swing.JButton();
        labelStartItem = new javax.swing.JLabel();
        spinnerTimeItemStart = new javax.swing.JSpinner();
        labelEndItem = new javax.swing.JLabel();
        spinnerTimeItemEnd = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        returnInventory = new javax.swing.JButton();
        generateReportButtonInventory = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        returnFood = new javax.swing.JButton();
        generateReportButtonFood = new javax.swing.JButton();
        spinnerTimeFoodStart = new javax.swing.JSpinner();
        labelStartFood = new javax.swing.JLabel();
        labelEndFood = new javax.swing.JLabel();
        spinnerTimeFoodEnd = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returnTicket.setText("Return");
        returnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnTicketActionPerformed(evt);
            }
        });

        generateReportButtonTicket.setText("generate ticket sales report");
        generateReportButtonTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonTicketActionPerformed(evt);
            }
        });

        labelTicketStart.setText("Start time");

        spinnerTimeTicketStart.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1272594240000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        labelTicketEnd.setText("End time");

        spinnerTimeTicketEnd.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1272594240000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnTicket))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(generateReportButtonTicket)))
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelTicketStart, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTicketEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spinnerTimeTicketEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerTimeTicketStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(returnTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(generateReportButtonTicket)
                .addGap(48, 48, 48))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerTimeTicketStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTicketStart))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerTimeTicketEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTicketEnd))
                    .addContainerGap(98, Short.MAX_VALUE)))
        );

        jTabbedPane5.addTab("Ticket", jPanel2);

        returnItemOrder.setText("Return");
        returnItemOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnItemOrderActionPerformed(evt);
            }
        });

        generateReportButtonItem.setText("generate item order report");
        generateReportButtonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonItemActionPerformed(evt);
            }
        });

        labelStartItem.setText("Start time");

        spinnerTimeItemStart.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1272594240000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        labelEndItem.setText("End time");

        spinnerTimeItemEnd.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1272594240000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnItemOrder))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(generateReportButtonItem)))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelStartItem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelEndItem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spinnerTimeItemEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerTimeItemStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(returnItemOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(generateReportButtonItem)
                .addGap(46, 46, 46))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerTimeItemStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelStartItem))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerTimeItemEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelEndItem))
                    .addContainerGap(98, Short.MAX_VALUE)))
        );

        jTabbedPane5.addTab("Item Order", jPanel3);

        returnInventory.setText("Return");
        returnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnInventoryActionPerformed(evt);
            }
        });

        generateReportButtonInventory.setText("generate inventory report");
        generateReportButtonInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnInventory))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(generateReportButtonInventory)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(returnInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(generateReportButtonInventory)
                .addGap(49, 49, 49))
        );

        jTabbedPane5.addTab("Inventory", jPanel4);

        returnFood.setText("Return");
        returnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnFoodActionPerformed(evt);
            }
        });

        generateReportButtonFood.setText("generate food sales report");
        generateReportButtonFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonFoodActionPerformed(evt);
            }
        });

        spinnerTimeFoodStart.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1272594240000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        labelStartFood.setText("Start time");

        labelEndFood.setText("End time");

        spinnerTimeFoodEnd.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1272594240000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnFood))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(generateReportButtonFood)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelStartFood, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEndFood, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerTimeFoodEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerTimeFoodStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(returnFood)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTimeFoodStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStartFood))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTimeFoodEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEndFood))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(generateReportButtonFood)
                .addGap(38, 38, 38))
        );

        jTabbedPane5.addTab("Food", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnInventoryActionPerformed
        // TODO add your handling code here:
        if (this.guiMainMenuFood != null) {
            this.dispose();
            this.guiMainMenuFood.setVisible(true);
        } else if (this.guiMainMenuTicket != null) {
            this.dispose();
            this.guiMainMenuTicket.setVisible(true);
        }
    }//GEN-LAST:event_returnInventoryActionPerformed

    private void returnItemOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnItemOrderActionPerformed
        // TODO add your handling code here:
        if (this.guiMainMenuFood != null) {
            this.dispose();
            this.guiMainMenuFood.setVisible(true);
        } else if (this.guiMainMenuTicket != null) {
            this.dispose();
            this.guiMainMenuTicket.setVisible(true);
        }
    }//GEN-LAST:event_returnItemOrderActionPerformed

    private void returnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnTicketActionPerformed
        // TODO add your handling code here:
        
        if (this.guiMainMenuFood != null) {
            this.dispose();
            this.guiMainMenuFood.setVisible(true);
        } else if (this.guiMainMenuTicket != null) {
            this.dispose();
            this.guiMainMenuTicket.setVisible(true);
        }
    }//GEN-LAST:event_returnTicketActionPerformed

    private void returnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnFoodActionPerformed
        // TODO add your handling code here:
        if (this.guiMainMenuFood != null) {
            this.dispose();
            this.guiMainMenuFood.setVisible(true);
        } else if (this.guiMainMenuTicket != null) {
            this.dispose();
            this.guiMainMenuTicket.setVisible(true);
        }
    }//GEN-LAST:event_returnFoodActionPerformed

    private void generateReportButtonFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonFoodActionPerformed
        // TODO add your handling code here:
        ZoneId theZone = ZoneId.systemDefault();

        LocalDate foodTimeStart = LocalDate.ofInstant(((Date) this.spinnerTimeFoodStart.getValue()).toInstant(), theZone);
        LocalDate foodTimeEnd = LocalDate.ofInstant(((Date) this.spinnerTimeFoodEnd.getValue()).toInstant(), theZone);
        
        GUI_ReportFoodSales guiReportFoodSales = new GUI_ReportFoodSales(guiAnalyticsMenu, foodTimeStart, foodTimeEnd);
        
        guiReportFoodSales.setVisible(true);
        
    }//GEN-LAST:event_generateReportButtonFoodActionPerformed

    private void generateReportButtonTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonTicketActionPerformed
        // TODO add your handling code here:
        ZoneId theZone = ZoneId.systemDefault();

        LocalDate ticketTimeStart = LocalDate.ofInstant(((Date) this.spinnerTimeTicketStart.getValue()).toInstant(), theZone);
        LocalDate ticketTimeEnd = LocalDate.ofInstant(((Date) this.spinnerTimeTicketEnd.getValue()).toInstant(), theZone);
        
        GUI_ReportTicketSales guiReportTicketSales = new GUI_ReportTicketSales(guiAnalyticsMenu, ticketTimeStart, ticketTimeEnd);
        
        guiReportTicketSales.setVisible(true);
        
    }//GEN-LAST:event_generateReportButtonTicketActionPerformed

    private void generateReportButtonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonItemActionPerformed
        // TODO add your handling code here:
        
        ZoneId theZone = ZoneId.systemDefault();

        LocalDate itemTimeStart = LocalDate.ofInstant(((Date) this.spinnerTimeItemStart.getValue()).toInstant(), theZone);
        LocalDate itemTimeEnd = LocalDate.ofInstant(((Date) this.spinnerTimeItemEnd.getValue()).toInstant(), theZone);
        
        GUI_ReportItemOrder guiReportItem = new GUI_ReportItemOrder(guiAnalyticsMenu, itemTimeStart, itemTimeEnd);
        
        guiReportItem.setVisible(true); 
    }//GEN-LAST:event_generateReportButtonItemActionPerformed

    private void generateReportButtonInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonInventoryActionPerformed
        // TODO add your handling code here:
        
        GUI_ReportInventory guiReportInventory = new GUI_ReportInventory(guiAnalyticsMenu);
        
        guiReportInventory.setVisible(true);
        
    }//GEN-LAST:event_generateReportButtonInventoryActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_AnalyticsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_AnalyticsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_AnalyticsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_AnalyticsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_AnalyticsMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generateReportButtonFood;
    private javax.swing.JButton generateReportButtonInventory;
    private javax.swing.JButton generateReportButtonItem;
    private javax.swing.JButton generateReportButtonTicket;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel labelEndFood;
    private javax.swing.JLabel labelEndItem;
    private javax.swing.JLabel labelStartFood;
    private javax.swing.JLabel labelStartItem;
    private javax.swing.JLabel labelTicketEnd;
    private javax.swing.JLabel labelTicketStart;
    private javax.swing.JButton returnFood;
    private javax.swing.JButton returnInventory;
    private javax.swing.JButton returnItemOrder;
    private javax.swing.JButton returnTicket;
    private javax.swing.JSpinner spinnerTimeFoodEnd;
    private javax.swing.JSpinner spinnerTimeFoodStart;
    private javax.swing.JSpinner spinnerTimeItemEnd;
    private javax.swing.JSpinner spinnerTimeItemStart;
    private javax.swing.JSpinner spinnerTimeTicketEnd;
    private javax.swing.JSpinner spinnerTimeTicketStart;
    // End of variables declaration//GEN-END:variables
}
