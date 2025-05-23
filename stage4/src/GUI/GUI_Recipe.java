/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import stage4.FoodRelated.*;
import java.util.TreeMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hmreg
 */
public class GUI_Recipe extends javax.swing.JFrame {

    private GUI_ConcessionElements guiConcessionElements;
    private Food food;
    
    /**
     * Creates new form GUI Recipe
     */
    public GUI_Recipe() {
        initComponents();
        
    }

    public GUI_Recipe(GUI_ConcessionElements guiConcessionElements, Food food) {
        initComponents();
        this.guiConcessionElements = guiConcessionElements;
        this.food = food;
        
        this.titleName.setText("Here is the recipe for " + this.food.getMenuName());
        
        populateTableRecipe();
    }
    
    public void populateTableRecipe() {

        DefaultTableModel tableRecipeModel = (DefaultTableModel) this.recipeTable.getModel();
        
        TreeMap<Item, Byte> recipe = this.food.getRecipe();
        
        for (Map.Entry<Item, Byte> entry : recipe.entrySet()) {
            Object[] aRow = new Object[3];
                        
            aRow[0] = entry.getKey().getItemId();
            aRow[1] = entry.getKey().getItemName();
            aRow[2] = entry.getValue();
            
            tableRecipeModel.addRow(aRow);
        }
        
    }
    
    public void resetRowsRecipe() {
        DefaultTableModel tableRecipeModel = (DefaultTableModel) this.recipeTable.getModel();

        tableRecipeModel.setRowCount(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        titleName = new javax.swing.JLabel();
        addRecipeButton = new javax.swing.JButton();
        removeRecipeButton = new javax.swing.JButton();
        updateRecipeButton = new javax.swing.JButton();
        spinnerUpdateQty = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item name", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(recipeTable);

        addRecipeButton.setText("Add");
        addRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeButtonActionPerformed(evt);
            }
        });

        removeRecipeButton.setText("Remove");
        removeRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRecipeButtonActionPerformed(evt);
            }
        });

        updateRecipeButton.setText("Update");
        updateRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecipeButtonActionPerformed(evt);
            }
        });

        spinnerUpdateQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 127, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeRecipeButton)
                                    .addComponent(addRecipeButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateRecipeButton)
                                    .addComponent(spinnerUpdateQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(addRecipeButton)
                        .addGap(34, 34, 34)
                        .addComponent(removeRecipeButton)
                        .addGap(72, 72, 72)
                        .addComponent(spinnerUpdateQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateRecipeButton)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeButtonActionPerformed
        // TODO add your handling code here:
        GUI_RecipeAdd guiRecipeAdd = new GUI_RecipeAdd(this, this.food);
        guiRecipeAdd.setVisible(true);
    }//GEN-LAST:event_addRecipeButtonActionPerformed

    private void removeRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRecipeButtonActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = this.recipeTable.getSelectedRow();
        
        if (selectedRow != -1) {
            byte id = (byte) this.recipeTable.getModel().getValueAt(selectedRow, 0);
            this.food.removeRecipe(id);
            
            resetRowsRecipe();
            populateTableRecipe();
        }
        
    }//GEN-LAST:event_removeRecipeButtonActionPerformed

    private void updateRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecipeButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.recipeTable.getSelectedRow();
        
        if (selectedRow != -1) {
            byte id = (byte) this.recipeTable.getValueAt(selectedRow, 0);
            int qty = (int) this.spinnerUpdateQty.getValue();
            
            Item item = Inventory.getItem(id);
            
            this.food.removeRecipe(id);
            this.food.addRecipe(item, (byte) qty);
            
            resetRowsRecipe();
            populateTableRecipe();
            
        }
        
    }//GEN-LAST:event_updateRecipeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Recipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton removeRecipeButton;
    private javax.swing.JSpinner spinnerUpdateQty;
    private javax.swing.JLabel titleName;
    private javax.swing.JButton updateRecipeButton;
    // End of variables declaration//GEN-END:variables
}
