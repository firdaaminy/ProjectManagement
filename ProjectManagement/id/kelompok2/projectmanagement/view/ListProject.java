/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 *
 * @author Adam
 */
public class ListProject extends javax.swing.JPanel implements View {

    /**
     * Creates new form ListProject
     */
    public ListProject() {
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

        jPanel5 = new javax.swing.JPanel();
        txSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProjects = new javax.swing.JTable();
        btnSearchYP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        txSearch.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        txSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txSearch.setText("You can search your project by its client or name");
        txSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txSearchFocusLost(evt);
            }
        });

        tableProjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Project Name", "Project Client", "Done/Undone"
            }
        ) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        jScrollPane1.setViewportView(tableProjects);

        btnSearchYP.setText("Search");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 2, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Double click on a row to assign tasks");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchYP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnSearchYP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txSearchFocusGained
        if(txSearch.getText().equals("You can search your project by its id, client or name..."))
            txSearch.setText("");
    }//GEN-LAST:event_txSearchFocusGained

    private void txSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txSearchFocusLost
        if(txSearch.getText().equals(""))
            txSearch.setText("You can search your project by its id, client or name...");
    }//GEN-LAST:event_txSearchFocusLost

    public void resetText() {
        txSearch.setText("You can search your project by its id, client or name...");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchYP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProjects;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables

    public String getSearchText() {
        return txSearch.getText();
    }
    
    public Object getBtnSearchYP() {
        return btnSearchYP;
    }
    
    public JTable getTableYourProject() {
        return tableProjects;
    }
    
    @Override
    public void addListener(ActionListener e) {
        btnSearchYP.addActionListener(e);
    }

}
