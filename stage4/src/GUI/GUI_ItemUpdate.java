/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import stage4.FoodRelated.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ivans
 */
public class GUI_ItemUpdate extends javax.swing.JFrame {
    private GUI_ConcessionElements guiConcessionElements;
    private int selectedRow;

    /**
     * Creates new form GUI_ItemUpdate
     */
    public GUI_ItemUpdate() {
        initComponents();
    }
    
    public GUI_ItemUpdate(GUI_ConcessionElements guiConcessionElements, int selectedRow) {
        initComponents();
        
        this.guiConcessionElements = guiConcessionElements;
        
        this.selectedRow = selectedRow;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnBtn = new javax.swing.JButton();
        itemIdField = new javax.swing.JTextField();
        itemIdLabel = new javax.swing.JLabel();
        buyingCostLabel = new javax.swing.JLabel();
        itemNameLabel = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        buyingCostField = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        qtyField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        itemIdLabel.setText("Item ID");

        buyingCostLabel.setText("Buying cost");

        itemNameLabel.setText("Item name");

        qtyLabel.setText("Quantity");

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(updateBtn)
                        .addGap(18, 18, 18)
                        .addComponent(returnBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(qtyLabel)
                            .addComponent(itemNameLabel)
                            .addComponent(itemIdLabel)
                            .addComponent(buyingCostLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buyingCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemIdLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyingCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyingCostLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBtn)
                    .addComponent(updateBtn))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        String name = this.itemNameField.getText();

        byte id = 0;

        try {
            id = Byte.parseByte(this.itemIdField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID should be a number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        short qty = 0;

        try {
            qty = Short.parseShort(this.qtyField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity should be a number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        short buyingCost = 0;

        try {
            buyingCost = Short.parseShort(this.buyingCostField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Buying cost should be a number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        if(Inventory.contains(id)) {
            Inventory.updateItem((byte) this.selectedRow, new Item(id, name, qty, buyingCost));
        }

        this.dispose();

        this.guiConcessionElements.resetRowsItem();
        this.guiConcessionElements.populateTableItem();
        this.guiConcessionElements.setVisible(true);

    }//GEN-LAST:event_updateBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.guiConcessionElements.setVisible(true);
    }//GEN-LAST:event_returnBtnActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_ItemUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ItemUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ItemUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ItemUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ItemUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buyingCostField;
    private javax.swing.JLabel buyingCostLabel;
    private javax.swing.JTextField itemIdField;
    private javax.swing.JLabel itemIdLabel;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTextField qtyField;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
