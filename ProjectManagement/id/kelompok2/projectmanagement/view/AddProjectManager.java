/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Adam
 */
public class AddProjectManager extends javax.swing.JPanel implements View {

    /**
     * Creates new form AddProgrammer
     */
    public AddProjectManager() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jxProgrammerName = new javax.swing.JTextField();
        jxProgrammerSalary = new javax.swing.JTextField();
        jxProgrammerPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbCancel = new javax.swing.JButton();
        jbCreate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));

        jxProgrammerName.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jxProgrammerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jxProgrammerName.setText("Enter name");
        jxProgrammerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jxProgrammerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jxProgrammerNameFocusLost(evt);
            }
        });

        jxProgrammerSalary.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jxProgrammerSalary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jxProgrammerSalary.setText("Enter salary");
        jxProgrammerSalary.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jxProgrammerSalaryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jxProgrammerSalaryFocusLost(evt);
            }
        });

        jxProgrammerPassword.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jxProgrammerPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jxProgrammerPassword.setText("Enter default password");
        jxProgrammerPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jxProgrammerPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jxProgrammerPasswordFocusLost(evt);
            }
        });
        jxProgrammerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxProgrammerPasswordActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Sitka Text", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("\"Coming together is a beginning. Keeping together is progress. Working together is success.\"");

        jbCancel.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jbCancel.setText("Cancel");

        jbCreate.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jbCreate.setText("Create");

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" Henry Ford");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create an account for a project manager");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jbCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCreate)
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                            .addComponent(jxProgrammerPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jxProgrammerSalary, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jxProgrammerName))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jxProgrammerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jxProgrammerSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jxProgrammerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancel)
                    .addComponent(jbCreate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jxProgrammerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxProgrammerPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jxProgrammerPasswordActionPerformed

    private void jxProgrammerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxProgrammerNameFocusGained
        if(jxProgrammerName.getText().equals("Enter name"))
            jxProgrammerName.setText("");
    }//GEN-LAST:event_jxProgrammerNameFocusGained

    private void jxProgrammerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxProgrammerNameFocusLost
        if(jxProgrammerName.getText().equals(""))
            jxProgrammerName.setText("Enter name");
    }//GEN-LAST:event_jxProgrammerNameFocusLost

    private void jxProgrammerSalaryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxProgrammerSalaryFocusGained
        if(jxProgrammerSalary.getText().equals("Enter salary"))
            jxProgrammerSalary.setText("");
    }//GEN-LAST:event_jxProgrammerSalaryFocusGained

    private void jxProgrammerSalaryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxProgrammerSalaryFocusLost
        if(jxProgrammerSalary.getText().equals(""))
            jxProgrammerSalary.setText("Enter salary");
    }//GEN-LAST:event_jxProgrammerSalaryFocusLost

    private void jxProgrammerPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxProgrammerPasswordFocusGained
        if(jxProgrammerPassword.getText().equals("Enter default password"))
            jxProgrammerPassword.setText("");
    }//GEN-LAST:event_jxProgrammerPasswordFocusGained

    private void jxProgrammerPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxProgrammerPasswordFocusLost
        if(jxProgrammerPassword.getText().equals(""))
            jxProgrammerPassword.setText("Enter default password");
    }//GEN-LAST:event_jxProgrammerPasswordFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbCreate;
    private javax.swing.JTextField jxProgrammerName;
    private javax.swing.JTextField jxProgrammerPassword;
    private javax.swing.JTextField jxProgrammerSalary;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        jbCancel.addActionListener(e);
        jbCreate.addActionListener(e);
    }

    public JButton getJbCancel() {
        return jbCancel;
    }

    public JButton getJbCreate() {
        return jbCreate;
    }
    
    public String getProgrammerName() {
        return jxProgrammerName.getText();
    }
    
    public String getProgrammerSalary() {
        return jxProgrammerSalary.getText();
    }
    
    public String getProgrammerPassword() {
        return jxProgrammerPassword.getText();
    }

    public void clearFields() {
        jxProgrammerName.setText("Enter your programmer's name");
        jxProgrammerPassword.setText("Enter your programmer's default password");
        jxProgrammerSalary.setText("Enter your programmer's salary");
    }
}
