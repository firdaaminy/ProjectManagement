/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Adam
 */
public class ListTeam extends javax.swing.JPanel implements View {

    /**
     * Creates new form ListTeam
     */
    public ListTeam() {
        initComponents();
    }

    public JButton getBtnSearchYT() {
        return BtnSearchYT;
    }

    public JTextField getJxSearchId() {
        return jxSearchId;
    }

    public JTable getTableMember() {
        return tableMember;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jxSearchId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMember = new javax.swing.JTable();
        BtnSearchYT = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Your team members");

        jxSearchId.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jxSearchId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jxSearchId.setText("Search your member by his/her ID or name...");
        jxSearchId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jxSearchIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jxSearchIdFocusLost(evt);
            }
        });

        tableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Programmer ID", "Programmer name", "Programmer salary"
            }
        ) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        jScrollPane1.setViewportView(tableMember);

        BtnSearchYT.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jxSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSearchYT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jxSearchId, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(BtnSearchYT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jxSearchIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxSearchIdFocusGained
        if(jxSearchId.getText().equals("Search your member by his/her ID or name..."))
            jxSearchId.setText("");
    }//GEN-LAST:event_jxSearchIdFocusGained

    private void jxSearchIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jxSearchIdFocusLost
        if(jxSearchId.getText().equals(""))
            jxSearchId.setText("Search your member by his/her ID or name...");
    }//GEN-LAST:event_jxSearchIdFocusLost

    public void resetText() {
        jxSearchId.setText("Search your member by his/her ID or name...");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearchYT;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jxSearchId;
    private javax.swing.JTable tableMember;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void addListener(ActionListener e) {
        BtnSearchYT.addActionListener(e);
    }
}
