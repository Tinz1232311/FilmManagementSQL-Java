/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import Modify.loginmodify;
import Module.Login;
import Other.SecureRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author This PC
 */
public class SignUpFrame extends javax.swing.JFrame {

    /**
     * Creates new form SignUpFrame
     */
    public SignUpFrame() {
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

        txtAccount = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        Verify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAccount.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txtAccount.setForeground(new java.awt.Color(255, 255, 255));
        txtAccount.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), null));
        txtAccount.setOpaque(false);
        getContentPane().add(txtAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 352, 260, 30));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), null));
        txtPassword.setOpaque(false);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 462, 260, 30));

        Verify.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Verify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/File-complete-icon.png"))); // NOI18N
        Verify.setText("Tiếp tục");
        Verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyActionPerformed(evt);
            }
        });
        getContentPane().add(Verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/SignUpBGR.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyActionPerformed
        // TODO add your handling code here:
        String account = txtAccount.getText();
        String password = txtPassword.getText();
        if(password.length()==0 || account.length()==0)
        {
            JOptionPane.showMessageDialog(null,"Can't be empty","Input Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(SecureRandom.Pass(password)==true)
            {
                JOptionPane.showMessageDialog(null,"Your password is definitely good","",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Your password should be improved","",JOptionPane.WARNING_MESSAGE);
                int option = JOptionPane.showConfirmDialog(null,"Make another stronger?","",JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                {
                    String input = JOptionPane.showInputDialog(this,"Enter the length of password you want to generate");
                    if(input != null && input.length() > 0)
                    {
                        int length = Integer.parseInt(input);
                        String s = SecureRandom.generateRandomID(length);
                        JOptionPane.showMessageDialog(null,"The password is "+s,"",JOptionPane.INFORMATION_MESSAGE);
                        password = s;
                    } 
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Your must enter something","",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            Login tmp = new Login(account,password);
            loginmodify.insert(tmp);
            JOptionPane.showMessageDialog(null,"Create Successfully","Task Complete",JOptionPane.INFORMATION_MESSAGE);
            dispose();
            LoginFrame b = new LoginFrame();
            b.setVisible(true);
        }
    }//GEN-LAST:event_VerifyActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Verify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
