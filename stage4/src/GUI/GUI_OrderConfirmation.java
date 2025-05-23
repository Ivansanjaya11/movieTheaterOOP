/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import stage4.TicketRelated.*;
import stage4.OrdersAndPayment.*;
import stage4.AnalyticsAndFiles.*;
import stage4.FoodRelated.Food;
import stage4.FoodRelated.Inventory;
import stage4.util.DateAndPaymentTracker;

/**
 *
 * @author hmreg
 */
public class GUI_OrderConfirmation extends javax.swing.JFrame {
    
    private DetailTicketBought detailTicket;
    
    private DetailFoodBought detailFood;
    
    private GUI_OrderFood guiOrderFood;
    
    private GUI_OrderSeating guiOrderSeating;

    private GUI_MainMenuTicket guiMainMenuTicket;
    
    private GUI_MainMenuFood guiMainMenuFood;
    
    /**
     * Creates new form GUI_OrderConfirmation
     */
    public GUI_OrderConfirmation() {
        initComponents();
    }

    public GUI_OrderConfirmation(GUI_MainMenuTicket guiMainMenuTicket, GUI_OrderSeating guiOrderSeating, DetailTicketBought detail) {
        initComponents();
        
        this.guiMainMenuTicket = guiMainMenuTicket;
        
        this.guiOrderSeating = guiOrderSeating;
        
        this.detailTicket = detail;
        
        printTicketOrderConfirmation();
        
    }
    
    public GUI_OrderConfirmation(GUI_MainMenuFood guiMainMenuFood, GUI_OrderFood guiOrderFood, DetailFoodBought detail) {
        initComponents();
        
        this.guiOrderFood = guiOrderFood;
        
        this.guiMainMenuFood = guiMainMenuFood;
        
        this.detailFood = detail;
        
        printFoodOrderConfirmation();
        
    }
    
    public void printFoodOrderConfirmation() {
        String str = "";
        
        TreeMap<Food, Byte> orderedFood = this.detailFood.getOrderedFood();

        // print out the ordered food one by one
        for (Food aFood : orderedFood.keySet()) {
            str += (aFood.getMenuName() + ": ");
            str += (orderedFood.get(aFood) + "\n");
        }
        
        str += ("Total price is $" + this.detailFood.getPaymentAmount());
        
        this.orderTextArea.setText(str);
    }
    
    public void printTicketOrderConfirmation() {
        String str = "";
        
        Showtime showtime = this.detailTicket.getShowtime();
        ArrayList<byte[]> chosenSeats = detailTicket.getChosenSeats();
        byte normalPrice = detailTicket.getNormalPrice();
        byte imaxPrice = detailTicket.getImaxPrice();
        byte quantity = (byte) (detailTicket.getImaxNum() + detailTicket.getNormalNum());

        Movie aMovie = showtime.getMovie();
        Screen aScreen = showtime.getScreen();
        
        str += (quantity + " Movie '" + aMovie.getTitle() + "'.\n");
        str += ("Screen room #" + aScreen.getScreenID() + "; type: " + aScreen.getScreenType() + "\n");
        str += ("The price for each ticket is $");
        
        if (aScreen.getScreenType() == "normal") {
            str += (normalPrice);
        } else {
            str += (imaxPrice);
        }
        
        str += "\n";
        
        str += ("The following is the seats you ordered:\n");
        
        for (byte[] aSeat : chosenSeats) {
            str += ("\t- Seat at (" + (aSeat[0] + 1) + ", " + (aSeat[1] + 1) + ")\n");
        }
        
        this.orderTextArea.setText(str);
    }
    
    public String generateFoodPaymentId() {
        // check the date
        LocalDate date = checkDate();

        //Increment the customer count for the day
        DateAndPaymentTracker.foodCustomerNumOfTheDay++;

        // sets the payment ID
        String paymentId = createPaymentID(date, DateAndPaymentTracker.foodCustomerNumOfTheDay);

        return paymentId;
    }   
    
    public String generateTicketPaymentId() {
        // check the date
        LocalDate date = checkDate();

        //Increment the customer count for the day
        DateAndPaymentTracker.ticketCustomerNumOfTheDay++;

        // sets the payment ID
        String paymentId = createPaymentID(date, DateAndPaymentTracker.ticketCustomerNumOfTheDay);

        return paymentId;
    }   
    
    /**
     * creates the payment ID
     * @param date current date
     * @param customerCount customer count
     * @return payment ID
     */
    private static String createPaymentID(LocalDate date, short customerCount) {

        // uses four digits to display the customer count in the payment ID
        byte numOfZeroes = (byte) (4-String.valueOf(customerCount).length());
        String zeroes = "";

        for (int i=0; i<numOfZeroes; i++) {
            zeroes += "0";
        }

        // set and return the payment ID
        return date + "-" + zeroes + customerCount;
    }
    
    /**
     * checks the date and update the customer counter if needed
     * @return current date
     */
    private static LocalDate checkDate() {

        // check the date (and update if needed)
        LocalDate date = LocalDate.now();

        if (DateAndPaymentTracker.currentDate.isBefore(date)) {
            DateAndPaymentTracker.currentDate = date;
            DateAndPaymentTracker.foodCustomerNumOfTheDay = 0;
            DateAndPaymentTracker.ticketCustomerNumOfTheDay = 0;
        }

        return date;
    }
    
    private short calculateTicketPrice() {
        return (short) (this.detailTicket.getImaxNum()*this.detailTicket.getImaxPrice() + this.detailTicket.getNormalNum()*this.detailTicket.getNormalPrice());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Correctlbl = new javax.swing.JLabel();
        YesBtn = new javax.swing.JButton();
        NoBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Correctlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Correctlbl.setText("Is everything correct?");

        YesBtn.setText("Yes");
        YesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesBtnActionPerformed(evt);
            }
        });

        NoBtn.setText("No");
        NoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoBtnActionPerformed(evt);
            }
        });

        orderTextArea.setEditable(false);
        orderTextArea.setColumns(20);
        orderTextArea.setRows(5);
        jScrollPane1.setViewportView(orderTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(153, 153, 153)
                            .addComponent(Correctlbl))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(NoBtn)
                        .addGap(118, 118, 118)
                        .addComponent(YesBtn)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Correctlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YesBtn)
                    .addComponent(NoBtn))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void YesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesBtnActionPerformed
        // TODO add your handling code here:
        
        if (this.detailTicket != null) {
            this.detailTicket.setPaymentAmount(calculateTicketPrice());

            String paymentId = generateTicketPaymentId();

            FilesUpdateManager.updateTicketSalesFile(paymentId, this.detailTicket);

            FilesUpdateManager.updateCustomerCounterDataFile();

            GUI_Receipt guiReceipt = new GUI_Receipt(this.guiMainMenuTicket, paymentId, this.detailTicket);

            this.dispose();

            guiReceipt.setVisible(true);
        } else if (this.detailFood != null) {
            
            String paymentId = generateFoodPaymentId();
            
            Inventory.updateInventory(this.detailFood.getOrderedFood());
            
            FilesUpdateManager.updateFoodSalesFile(paymentId, this.detailFood);
            
            FilesUpdateManager.updateCustomerCounterDataFile();
            
            GUI_Receipt guiReceipt = new GUI_Receipt(this.guiMainMenuFood, paymentId, this.detailFood);
            
            this.dispose();
            
            guiReceipt.setVisible(true);
        }
    }//GEN-LAST:event_YesBtnActionPerformed

    private void NoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoBtnActionPerformed
        // TODO add your handling code here:
        if (this.detailTicket != null) {
            this.dispose();
            this.guiOrderSeating.setVisible(true);
        } else if (this.detailFood != null) {
            this.dispose();
            this.guiOrderFood.setVisible(true);
        }
    }//GEN-LAST:event_NoBtnActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_OrderConfirmation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Correctlbl;
    private javax.swing.JButton NoBtn;
    private javax.swing.JButton YesBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea orderTextArea;
    // End of variables declaration//GEN-END:variables
}
