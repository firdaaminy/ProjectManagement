/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.gui;

import id.kelompok2.projectmanagement.view.View;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Iwan Ma'ruf
 */
public class CobaCobaLogin extends javax.swing.JFrame implements View {

    /**
     * Creates new form CobaCobaLogin
     */
    public CobaCobaLogin() {
        initComponents();
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnSignUp() {
        return btnSignUp;
    }
    public String getUser(){
        return usernameLogin.getText();
    }
    public String getPass(){
        return passwordLogin.getText();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblMotto = new javax.swing.JLabel();
        usernameLogin = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblSignUp = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        mailField = new javax.swing.JTextField();
        usernameSignUp = new javax.swing.JTextField();
        passwordLogin = new javax.swing.JPasswordField();
        passwordSignUp = new javax.swing.JPasswordField();
        fmlCheckBox = new javax.swing.JCheckBox();
        mlCheckBox = new javax.swing.JCheckBox();
        lblTerms = new javax.swing.JLabel();
        lblPolicy = new javax.swing.JLabel();
        monthField = new javax.swing.JTextField();
        btnSignUp = new javax.swing.JButton();
        yearField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 687));
        setPreferredSize(new java.awt.Dimension(1015, 728));
        setSize(new java.awt.Dimension(1000, 687));
        getContentPane().setLayout(null);

        lblTitle.setBackground(new java.awt.Color(255, 255, 153));
        lblTitle.setFont(new java.awt.Font("Sitka Text", 0, 45)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("ON-BOARD");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(160, 0, 247, 70);

        lblMotto.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        lblMotto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotto.setText("Nobody's left behind with ON-BOARD");
        getContentPane().add(lblMotto);
        lblMotto.setBounds(530, 0, 444, 34);

        usernameLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameLogin.setText("Username");
        usernameLogin.setToolTipText("Username");
        usernameLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameLoginFocusLost(evt);
            }
        });
        usernameLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameLoginActionPerformed(evt);
            }
        });
        getContentPane().add(usernameLogin);
        usernameLogin.setBounds(540, 40, 110, 30);

        btnLogin.setText("Log In");
        getContentPane().add(btnLogin);
        btnLogin.setBounds(850, 40, 113, 30);

        lblSignUp.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        lblSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSignUp.setText("OR SIGN UP FOR FREE");
        getContentPane().add(lblSignUp);
        lblSignUp.setBounds(620, 110, 320, 30);

        firstName.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        firstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstName.setText("First name");
        firstName.setToolTipText("First name");
        firstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameFocusLost(evt);
            }
        });
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });
        getContentPane().add(firstName);
        firstName.setBounds(570, 150, 200, 30);

        lastName.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        lastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastName.setText("Last name");
        lastName.setToolTipText("Last name");
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFocusLost(evt);
            }
        });
        getContentPane().add(lastName);
        lastName.setBounds(780, 150, 190, 30);

        mailField.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        mailField.setText("Email");
        mailField.setToolTipText("Email");
        mailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mailFieldFocusLost(evt);
            }
        });
        getContentPane().add(mailField);
        mailField.setBounds(570, 210, 400, 30);

        usernameSignUp.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        usernameSignUp.setText("Username");
        usernameSignUp.setToolTipText("Desired username");
        usernameSignUp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameSignUpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameSignUpFocusLost(evt);
            }
        });
        getContentPane().add(usernameSignUp);
        usernameSignUp.setBounds(570, 270, 400, 30);

        passwordLogin.setText("Password");
        passwordLogin.setToolTipText("Password");
        passwordLogin.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        passwordLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordLoginFocusLost(evt);
            }
        });
        getContentPane().add(passwordLogin);
        passwordLogin.setBounds(701, 40, 100, 30);

        passwordSignUp.setText("Password");
        passwordSignUp.setToolTipText("Desired password");
        passwordSignUp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordSignUpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordSignUpFocusLost(evt);
            }
        });
        getContentPane().add(passwordSignUp);
        passwordSignUp.setBounds(570, 330, 400, 30);

        buttonGroup1.add(fmlCheckBox);
        fmlCheckBox.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        fmlCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        fmlCheckBox.setText("Female");
        getContentPane().add(fmlCheckBox);
        fmlCheckBox.setBounds(640, 470, 110, 31);

        buttonGroup1.add(mlCheckBox);
        mlCheckBox.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        mlCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        mlCheckBox.setText("Male");
        getContentPane().add(mlCheckBox);
        mlCheckBox.setBounds(820, 470, 110, 31);

        lblTerms.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        lblTerms.setForeground(new java.awt.Color(255, 255, 255));
        lblTerms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTerms.setText("By clicking Sign In, you agree to our Terms");
        getContentPane().add(lblTerms);
        lblTerms.setBounds(620, 540, 320, 20);

        lblPolicy.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        lblPolicy.setForeground(new java.awt.Color(255, 255, 255));
        lblPolicy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPolicy.setText(" and that you have read our Data Policy");
        getContentPane().add(lblPolicy);
        lblPolicy.setBounds(640, 560, 280, 30);

        monthField.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        monthField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monthField.setText("Month");
        monthField.setToolTipText("Month of birth");
        getContentPane().add(monthField);
        monthField.setBounds(730, 400, 90, 30);

        btnSignUp.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        btnSignUp.setText("Sign Up");
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(680, 590, 210, 70);

        yearField.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText("Year");
        yearField.setToolTipText("Year of birth");
        getContentPane().add(yearField);
        yearField.setBounds(880, 400, 90, 30);

        dayField.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        dayField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dayField.setText("Day");
        dayField.setToolTipText("Date of birth");
        getContentPane().add(dayField);
        dayField.setBounds(570, 400, 90, 30);

        background.setText("jLabel1");
        background.setMaximumSize(new java.awt.Dimension(1010, 680));
        background.setMinimumSize(new java.awt.Dimension(1010, 680));
        background.setPreferredSize(new java.awt.Dimension(1010, 680));
        getContentPane().add(background);
        background.setBounds(-6, 0, 1010, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameLoginFocusGained
        if(usernameLogin.getText().equals("Username")) usernameLogin.setText("");
    }//GEN-LAST:event_usernameLoginFocusGained

    private void usernameLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameLoginFocusLost
        if(usernameLogin.getText().equals("")) usernameLogin.setText("Username");
    }//GEN-LAST:event_usernameLoginFocusLost

    private void usernameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameLoginActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void passwordLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordLoginFocusGained
        if(passwordLogin.getText().equals("Password")) passwordLogin.setText("");
    }//GEN-LAST:event_passwordLoginFocusGained

    private void passwordLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordLoginFocusLost
        if(passwordLogin.getText().equals("")) passwordLogin.setText("Password");
    }//GEN-LAST:event_passwordLoginFocusLost

    private void firstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFocusGained
        if(firstName.getText().equals("First name")) firstName.setText("");
    }//GEN-LAST:event_firstNameFocusGained

    private void firstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFocusLost
        if(firstName.getText().equals("")) firstName.setText("First name");
    }//GEN-LAST:event_firstNameFocusLost

    private void lastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusGained
        if(lastName.getText().equals("Last name")) lastName.setText("");
    }//GEN-LAST:event_lastNameFocusGained

    private void lastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusLost
        if(lastName.getText().equals("")) lastName.setText("Last name");
    }//GEN-LAST:event_lastNameFocusLost

    private void mailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailFieldFocusGained
        if(mailField.getText().equals("Email")) mailField.setText("");
    }//GEN-LAST:event_mailFieldFocusGained

    private void mailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailFieldFocusLost
        if(mailField.getText().equals("")) mailField.setText("Email");
    }//GEN-LAST:event_mailFieldFocusLost

    private void usernameSignUpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameSignUpFocusGained
        if(usernameSignUp.getText().equals("Username")) usernameSignUp.setText("");
    }//GEN-LAST:event_usernameSignUpFocusGained

    private void usernameSignUpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameSignUpFocusLost
        if(usernameSignUp.getText().equals("")) usernameSignUp.setText("Username");
    }//GEN-LAST:event_usernameSignUpFocusLost

    private void passwordSignUpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordSignUpFocusGained
        if(passwordSignUp.getText().equals("Password")) passwordSignUp.setText("");
    }//GEN-LAST:event_passwordSignUpFocusGained

    private void passwordSignUpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordSignUpFocusLost
        if(passwordSignUp.getText().equals("")) passwordSignUp.setText("Password");
    }//GEN-LAST:event_passwordSignUpFocusLost

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobaCobaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CobaCobaLogin window = new CobaCobaLogin();
                window.setVisible(true);
                window.setSize(new java.awt.Dimension(1000, 687));
                window.setLocationRelativeTo(null);
                window.setTitle("ON-BOARD");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dayField;
    private javax.swing.JTextField firstName;
    private javax.swing.JCheckBox fmlCheckBox;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lblMotto;
    private javax.swing.JLabel lblPolicy;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblTerms;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField mailField;
    private javax.swing.JCheckBox mlCheckBox;
    private javax.swing.JTextField monthField;
    private javax.swing.JPasswordField passwordLogin;
    private javax.swing.JPasswordField passwordSignUp;
    private javax.swing.JTextField usernameLogin;
    private javax.swing.JTextField usernameSignUp;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        btnLogin.addActionListener(e);
        btnSignUp.addActionListener(e);
        
    }

}
