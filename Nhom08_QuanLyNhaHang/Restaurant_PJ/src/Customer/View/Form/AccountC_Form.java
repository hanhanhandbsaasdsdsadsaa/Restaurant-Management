package Customer.View.Form;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Model.ModelKhachHang;
import Customer.Model.ModelNguoiDung;
import Customer.View.Dialog.MS_ChangePassword;
import Customer.View.Dialog.MS_Confirm;
import Customer.View.Main.Main_Customer_Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AccountC_Form extends javax.swing.JPanel {
    
    private ModelNguoiDung user;
    private ModelKhachHang customer;
    private ServiceCustomer service;
    private Icon hide;
    private Icon show;
    private char def;
    private MS_ChangePassword changepass;
    
    public AccountC_Form() {
        service = new ServiceCustomer();
        initComponents();
        
    }
    
    public AccountC_Form(ModelNguoiDung user) {
        this.user = user;
        initComponents();
        init();
    }
    
    public void init() {
        service = new ServiceCustomer();
        hide = new ImageIcon(getClass().getResource("/Icons/hide.png"));
        show = new ImageIcon(getClass().getResource("/Icons/view.png"));
        def = txtmatkhau.getEchoChar();
        initUser_information();
        initCustomer_information();
        txtmatkhau.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtmatkhau.getSuffixIcon().equals(hide)) {
                    txtmatkhau.setSuffixIcon(show);
                    txtmatkhau.setEchoChar((char) 0);
                    
                } else {
                    txtmatkhau.setSuffixIcon(hide);
                    txtmatkhau.setEchoChar(def);
                }
            }
            
        });
    }
    
    public void initUser_information() {
        txtemail.setText(user.getEmail());
        txtmatkhau.setText(user.getPassword());
        txtrole.setText(user.getRole());
        txtmatkhau.setSuffixIcon(hide);
        txtemail.setEnabled(false);
        txtmatkhau.setEnabled(false);
        txtrole.setEnabled(false);
    }
    
    public void initCustomer_information() {
        try {
            customer = service.getCustomer(user.getUserID());
            txtmaKH.setText(customer.getID_KH() + "");
            txttenKH.setText(customer.getName());
            txtngayTG.setText(customer.getDateJoin());
            txtdso.setText(customer.getSales() + "đ");
            txtdiemtl.setText(customer.getPoints() + " xu");
            txtmaKH.setEnabled(false);
            txtngayTG.setEnabled(false);
            txtdso.setEnabled(false);
            txtdiemtl.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(AccountC_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void confirmRename(String message) {
        MS_Confirm obj = new MS_Confirm(Main_Customer_Frame.getFrames()[0], true);
        obj.ConfirmReName(message, customer);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Customer.View.Swing.PanelRound();
        pic = new Customer.View.Swing.ImageAvatar();
        titleKH = new javax.swing.JLabel();
        lbmaKH = new javax.swing.JLabel();
        lbtenKH = new javax.swing.JLabel();
        lbngayTG = new javax.swing.JLabel();
        lbdso = new javax.swing.JLabel();
        lbdTL = new javax.swing.JLabel();
        titleND = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbmk = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtmaKH = new Customer.View.Swing.MyTextField();
        txttenKH = new Customer.View.Swing.MyTextField();
        txtdso = new Customer.View.Swing.MyTextField();
        txtngayTG = new Customer.View.Swing.MyTextField();
        txtdiemtl = new Customer.View.Swing.MyTextField();
        txtemail = new Customer.View.Swing.MyTextField();
        txtrole = new Customer.View.Swing.MyTextField();
        cmdCapNhatTen = new Customer.View.Swing.Button();
        txtmatkhau = new RTDRestaurant.View.Swing.MyPasswordField();
        cmdDMK = new Customer.View.Swing.Button();

        setBackground(new java.awt.Color(222, 222, 222));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/avatarProfile.jpg"))); // NOI18N

        titleKH.setBackground(new java.awt.Color(255, 255, 255));
        titleKH.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        titleKH.setForeground(new java.awt.Color(108, 91, 123));
        titleKH.setText("Thông tin KHÁCH HÀNG");

        lbmaKH.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmaKH.setForeground(new java.awt.Color(89, 89, 89));
        lbmaKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmaKH.setText("Mã Khách hàng");

        lbtenKH.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbtenKH.setForeground(new java.awt.Color(89, 89, 89));
        lbtenKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtenKH.setText("Tên Khách Hàng");

        lbngayTG.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbngayTG.setForeground(new java.awt.Color(89, 89, 89));
        lbngayTG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbngayTG.setText("Ngày tham gia");

        lbdso.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbdso.setForeground(new java.awt.Color(89, 89, 89));
        lbdso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbdso.setText("Doanh số");

        lbdTL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbdTL.setForeground(new java.awt.Color(89, 89, 89));
        lbdTL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbdTL.setText("Điểm tích lũy");

        titleND.setBackground(new java.awt.Color(255, 255, 255));
        titleND.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        titleND.setForeground(new java.awt.Color(108, 91, 123));
        titleND.setText("Thông tin TÀI KHOẢN");

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(89, 89, 89));
        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmail.setText("Email");

        lbmk.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbmk.setForeground(new java.awt.Color(89, 89, 89));
        lbmk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmk.setText("Mật Khẩu");

        lbRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbRole.setForeground(new java.awt.Color(89, 89, 89));
        lbRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRole.setText("Vai trò");

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        txtmaKH.setBackground(new java.awt.Color(204, 204, 204));

        txttenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenKHActionPerformed(evt);
            }
        });

        txtdso.setBackground(new java.awt.Color(204, 204, 204));

        txtngayTG.setBackground(new java.awt.Color(204, 204, 204));

        txtdiemtl.setBackground(new java.awt.Color(204, 204, 204));

        txtemail.setBackground(new java.awt.Color(204, 204, 204));

        txtrole.setBackground(new java.awt.Color(204, 204, 204));

        cmdCapNhatTen.setBackground(new java.awt.Color(51, 255, 255));
        cmdCapNhatTen.setText("Cập nhật");
        cmdCapNhatTen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdCapNhatTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCapNhatTenActionPerformed(evt);
            }
        });

        txtmatkhau.setBackground(new java.awt.Color(204, 204, 204));
        txtmatkhau.setText("myPasswordField1");

        cmdDMK.setBackground(new java.awt.Color(51, 255, 255));
        cmdDMK.setText("Đổi mật khẩu");
        cmdDMK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdDMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(titleND)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdCapNhatTen, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbtenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbngayTG, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbdso, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbdTL))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtngayTG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdiemtl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(titleKH)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(lbmk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtrole, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(cmdDMK, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titleKH)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(titleND))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbtenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbngayTG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtngayTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbdso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbdTL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiemtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdCapNhatTen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmk, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdDMK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txttenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenKHActionPerformed
        confirmRename(txttenKH.getText().trim());
    }//GEN-LAST:event_txttenKHActionPerformed

    private void cmdCapNhatTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCapNhatTenActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn chứ?", "Cẩn thận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {
            if (ServiceCustomer.updateNameCustomer(Integer.parseInt(txtmaKH.getText()), txttenKH.getText()) > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        }
    }//GEN-LAST:event_cmdCapNhatTenActionPerformed

    private void cmdDMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDMKActionPerformed
        // TODO add your handling code here:
        changepass = new MS_ChangePassword(Main_Customer_Frame.getFrames()[0], true);
        changepass.ChangePassword(user);
        txtmatkhau.setText(user.getPassword());
    }//GEN-LAST:event_cmdDMKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Customer.View.Swing.Button cmdCapNhatTen;
    private Customer.View.Swing.Button cmdDMK;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbdTL;
    private javax.swing.JLabel lbdso;
    private javax.swing.JLabel lbmaKH;
    private javax.swing.JLabel lbmk;
    private javax.swing.JLabel lbngayTG;
    private javax.swing.JLabel lbtenKH;
    private Customer.View.Swing.PanelRound panelRound1;
    private Customer.View.Swing.ImageAvatar pic;
    private javax.swing.JLabel titleKH;
    private javax.swing.JLabel titleND;
    private Customer.View.Swing.MyTextField txtdiemtl;
    private Customer.View.Swing.MyTextField txtdso;
    private Customer.View.Swing.MyTextField txtemail;
    private Customer.View.Swing.MyTextField txtmaKH;
    private RTDRestaurant.View.Swing.MyPasswordField txtmatkhau;
    private Customer.View.Swing.MyTextField txtngayTG;
    private Customer.View.Swing.MyTextField txtrole;
    private Customer.View.Swing.MyTextField txttenKH;
    // End of variables declaration//GEN-END:variables
}
