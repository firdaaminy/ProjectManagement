/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Adam
 */
public class Settings extends javax.swing.JPanel implements View {

    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
    }

    public JButton getBtnSavePass() {
        return btnSavePass;
    }

    public JButton getBtnSaveSalary() {
        return btnSaveSalary;
    }

    public JButton getBtnSaveUser() {
        return btnSaveUser;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JTextField getTxPassword() {
        return txPassword;
    }

    public JTextField getTxSalary() {
        return txSalary;
    }

    public JTextField getTxSearch() {
        return txSearch;
    }

    public JTextField getTxUsername() {
        return txUsername;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txSearch = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txSalary = new javax.swing.JTextField();
        btnSavePass = new javax.swing.JButton();
        btnSaveUser = new javax.swing.JButton();
        btnSaveSalary = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Settings");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Search:");

        txSearch.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        txSearch.setText("(By ID/Username)");
        txSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txSearchFocusLost(evt);
            }
        });

        btnSubmit.setText("Submit");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Salary");

        btnSavePass.setText("Save");

        btnSaveUser.setText("Save");

        btnSaveSalary.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txSalary)
                    .addComponent(txPassword)
                    .addComponent(txUsername)
                    .addComponent(txSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit)
                            .addComponent(btnSaveUser, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(btnSaveSalary, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnSavePass, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSavePass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveSalary))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txSearchFocusGained
        if(txSearch.getText().equals("(By ID/Username)"))
            txSearch.setText("");
    }//GEN-LAST:event_txSearchFocusGained

    private void txSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txSearchFocusLost
        if(txSearch.getText().equals(""))
            txSearch.setText("(By ID/Username)");
    }//GEN-LAST:event_txSearchFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSavePass;
    private javax.swing.JButton btnSaveSalary;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txPassword;
    private javax.swing.JTextField txSalary;
    private javax.swing.JTextField txSearch;
    private javax.swing.JTextField txUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        btnSavePass.addActionListener(e);
        btnSaveUser.addActionListener(e);
        btnSaveSalary.addActionListener(e);
        btnSubmit.addActionListener(e);
    }
}
