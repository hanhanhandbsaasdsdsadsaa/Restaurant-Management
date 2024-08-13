package Customer.View.Main.Login_Form;

import Customer.Controller.Connection.DatabaseConnection;
import Customer.Controller.Service.LoginBL;
import Customer.Model.ModelNguoiDung;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Customer.View.Form.Admin_Form.FrmManageFood;
import Customer.View.Form.Admin_Form.FrmPersonalInfor;
import Customer.View.Form.Staff_Form.FrmStaffTable;
import Customer.View.Main.Main_Customer_Frame;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // add placeholder style
        addPlaceholderStyle(txtEmail);
        addPlaceholderStyle(txtPassword);
    }

    public static void addPlaceholderStyle(JTextField txt) {
        Font font = txt.getFont();
        font = font.deriveFont(Font.ITALIC);
        txt.setFont(font);
        txt.setForeground(Color.GRAY);
    }

    public static void removePlaceholderStyle(JTextField txt) {
        Font font = txt.getFont();
        font = font.deriveFont(Font.BOLD);
        txt.setFont(font);
        txt.setForeground(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblForgetPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        pnlInfor = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cây Khế Restaurant");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtEmail.setText("Email");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        lblForgetPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblForgetPassword.setText("Quên mật khẩu ?");
        lblForgetPassword.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseMoved(evt);
            }
        });
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseExited(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        pnlInfor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Bạn chưa có tài khoản tại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("RESTAURANT CÂY KHẾ ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Đừng lo lắng, hãy đăng ký tài khoản");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("tham gia cùng hội cây khế chúng tôi");

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInforLayout = new javax.swing.GroupLayout(pnlInfor);
        pnlInfor.setLayout(pnlInforLayout);
        pnlInforLayout.setHorizontalGroup(
            pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInforLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInforLayout.createSequentialGroup()
                        .addGroup(pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInforLayout.createSequentialGroup()
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        pnlInforLayout.setVerticalGroup(
            pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInforLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setText("Password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(266, 266, 266)
                            .addComponent(lblForgetPassword))
                        .addComponent(txtPassword)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(pnlInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblForgetPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        File f = new File("src/Icons/logo_restaurant.png");
        if (f.exists()) {
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            icon.setImage(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
            lblImage.setIcon(icon);
        }
    }//GEN-LAST:event_formWindowOpened

    private void lblForgetPasswordMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseMoved
        // TODO add your handling code here:
        lblForgetPassword.setForeground(Color.red);
    }//GEN-LAST:event_lblForgetPasswordMouseMoved

    private void lblForgetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseExited
        // TODO add your handling code here:
        lblForgetPassword.setForeground(Color.black);
    }//GEN-LAST:event_lblForgetPasswordMouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (LoginBL.checkLogin(txtEmail.getText(), new String(txtPassword.getPassword())) != null) {
            String vaiTro = LoginBL.checkLogin(txtEmail.getText(), new String(txtPassword.getPassword()));
            ModelNguoiDung user = LoginBL.getUser(txtEmail.getText(), new String(txtPassword.getPassword()));
            if (vaiTro.equals("Quan Ly")) {
                FrmPersonalInfor frm = new FrmPersonalInfor(user);
                frm.setVisible(true);
                this.setVisible(false);
            } else if (vaiTro.equals("Khach Hang")) {
                Main_Customer_Frame frm = new Main_Customer_Frame(user);
                frm.setVisible(true);
                this.setVisible(false);
            } else {
                FrmStaffTable frm = new FrmStaffTable(user);
                frm.setVisible(true);
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email hoặc mật khẩu không chính xác!");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        FrmRegister frm = new FrmRegister();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void lblForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseClicked
        // TODO add your handling code here:
        FrmForgetPassword frm = new FrmForgetPassword();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblForgetPasswordMouseClicked

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if (txtEmail.getText().equals("Email")) {
            txtEmail.setText("");
            txtEmail.requestFocus();
            removePlaceholderStyle(txtEmail);
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        if (new String(txtPassword.getPassword()).equals("Password")) {
            txtPassword.setText("");
            txtPassword.requestFocus();
            removePlaceholderStyle(txtPassword);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().length() == 0) {
            addPlaceholderStyle(txtEmail);
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
        String text = new String(txtPassword.getPassword());
        if (text.length() == 0) {
            addPlaceholderStyle(txtPassword);
            txtPassword.setText("Password");
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_txtPasswordFocusLost

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblForgetPassword;
    private javax.swing.JLabel lblImage;
    private javax.swing.JPanel pnlInfor;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
