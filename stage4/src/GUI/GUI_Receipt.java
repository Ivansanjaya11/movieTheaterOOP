package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.FoodRelated.Food;
import stage4.FoodRelated.Inventory;
import stage4.OrdersAndPayment.*;
import stage4.TicketRelated.*;
import stage4.util.DateAndPaymentTracker;
import stage4.util.PrettyPrinter;

/**
 *
 * @author ivans
 */
public class GUI_Receipt extends javax.swing.JFrame {

    private String paymentId;
    private DetailTicketBought detailTicket;
    private DetailFoodBought detailFood;

    private GUI_MainMenuTicket guiMainMenuTicket;
    
    private GUI_MainMenuFood guiMainMenuFood;
    
    
    /**
     * Creates new form GUI_Receipt
     */
    public GUI_Receipt() {
        initComponents();
    }

    public GUI_Receipt(GUI_MainMenuTicket guiMainMenuTicket, String paymentId, DetailTicketBought detail) {
        initComponents();
        this.paymentId = paymentId;
        this.detailTicket = detail;
        
        FilesUpdateManager.updateShowtimeDataFile(ShowtimeManager.getShowtimes());
        
        this.guiMainMenuTicket = guiMainMenuTicket;
        
        String receiptContent = generateTicketReceipt();
        
        this.receiptTextArea.setText(receiptContent);
    }
    
    public GUI_Receipt(GUI_MainMenuFood guiMainMenuFood, String paymentId, DetailFoodBought detail) {
        initComponents();
        this.paymentId = paymentId;
        this.detailFood = detail;
        
        this.guiMainMenuFood = guiMainMenuFood;
        
        String receiptContent = generateFoodReceipt();
        
        this.receiptTextArea.setText(receiptContent);
    }
    
    public String generateFoodReceipt() {
        String str = "";
        
        // get all the necessary data to create the receipt
        TreeMap<Food, Byte> orderedFood = detailFood.getOrderedFood();
        String customerName = detailFood.getCustomer().getName();
        String paymentType = detailFood.getPaymentType();
        short paymentAmount = detailFood.getPaymentAmount();
        
        // prints out the detail of the transaction on screen
        str += ("Order #" + paymentId + "\n");
        str += ("This order is for " + customerName + "\n");

        // prints out the header of the table
        str += ("Food\t\tQty\t\tprice per qty\n");

        // display all the food ordered
        for (Food aFood : orderedFood.keySet()) {
            str += (aFood.getMenuName() + "\t\t");
            str += (orderedFood.get(aFood) + "\t\t");
            str += ("$" + aFood.getPrice());
            str += "\n";
        }

        // prints out the price and payment type
        str += ("Total price is $" + paymentAmount);
        str += (", paid with " + paymentType);
        str += ("\nThank you for eating with us!");

        
        
        return str;
    }
    
    public String generateTicketReceipt() {
        String str = "";
        
        // get all the necessary data to create the receipt
        byte normalNum = detailTicket.getNormalNum();
        byte imaxNum = detailTicket.getImaxNum();

        byte normalPrice = detailTicket.getNormalPrice();
        byte imaxPrice = detailTicket.getImaxPrice();

        ArrayList<byte[]> chosenSeats = detailTicket.getChosenSeats();
        String customerName = detailTicket.getCustomer().getName();
        String paymentType = detailTicket.getPaymentType();
        short paymentAmount = detailTicket.getPaymentAmount();
        

        //Print the receipt
        str += ("Order #" + paymentId + "\n");
        str += ("This order is for: " + customerName + "\n");


        // prints the detail of the showtime
        str += ("Movie: '" + detailTicket.getShowtime().getMovie().getTitle() + "'\n");
        str += ("Start time: " + detailTicket.getShowtime().getStartTime().toString() + "\n");
        str += ("Screen room #" + detailTicket.getShowtime().getScreen().getScreenID() + "\n");


        str += ("Ticket type\t\tQty\tTotal price\n");


        // print the ticket bought

        if (normalNum > 0) {
            str += ("Normal ticket\t " + normalNum + "\t$" + (normalNum * normalPrice));
        }

        if (imaxNum > 0) {
            str += ("IMAX ticket\t\t" + imaxNum + "\t$" + (imaxNum * imaxPrice));
        }
        
        str += "\n";


        // prints the seats ordered
        str += ("Seats ordered:\n");

        for (byte[] aSeat : chosenSeats) {
            str += ("\t- Seat at (" + (aSeat[0]+1) + ", " + (aSeat[1]) + ")\n");
        }


        // prints the total price and payment type
        str += ("Total price is $" + paymentAmount);
        str += (", paid with " + paymentType + "\n");
        str += ("Thank you for watching with us!");
        
        
        return str;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        receiptTextArea = new javax.swing.JTextArea();
        okayButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        receiptTextArea.setColumns(20);
        receiptTextArea.setRows(5);
        jScrollPane1.setViewportView(receiptTextArea);

        okayButton.setText("Ok");
        okayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okayButton)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(okayButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayButtonActionPerformed
        // TODO add your handling code here:
        
        if (this.guiMainMenuTicket != null) {
            this.dispose();
            this.guiMainMenuTicket.setVisible(true);
        } else if (this.guiMainMenuFood != null) {
            this.dispose();
            this.guiMainMenuFood.setVisible(true);
        }
    }//GEN-LAST:event_okayButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okayButton;
    private javax.swing.JTextArea receiptTextArea;
    // End of variables declaration//GEN-END:variables
}
