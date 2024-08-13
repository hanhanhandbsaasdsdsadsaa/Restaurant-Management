package Customer.View.Dialog;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Model.ModelNguoiDung;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MS_ChangePassword extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;
    private Frame frame;
    private ServiceCustomer service;
    private Icon ihide;
    private Icon ishow;
    private char def;

    public MS_ChangePassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        service = new ServiceCustomer();
        this.frame = parent;
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }

        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        ihide = new ImageIcon(getClass().getResource("/Icons/hide.png"));
        ishow = new ImageIcon(getClass().getResource("/Icons/view.png"));
        def = txtnewPass.getEchoChar();
        txtnewPass.setSuffixIcon(ihide);
        txtconfirm.setSuffixIcon(ihide);
    }

    public void ChangePassword(ModelNguoiDung user) {
        setLocationRelativeTo(frame);
        lbMessage.setVisible(false);
        animator.start();
        cmdOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String newPass = String.valueOf(txtnewPass.getPassword());
                    String confmPass = String.valueOf(txtconfirm.getPassword());
                    //Nếu mật khẩu mới và xác nhận mật khẩu giống nhau thực 
                    //hiện đổi mật khẩu và hiển thị thông báo đổi thành công
                    if (newPass.equals(confmPass)) {
                        lbMessage.setBackground(new Color(186, 225, 186));
                        lbMessage.setForeground(new Color(60, 117, 60));
                        lbMessage.setText("Mật khẩu của bạn đã được đổi thành công");
                        lbMessage.setVisible(true);
                        service.changePassword(user.getUserID(), newPass);
                        user.setPassword(newPass);
                    } //Nếu mật khẩu mới và xác nhận mật khẩu không giống nhau thì thông báo xác nhận mật khẩu không đúng
                    else {
                        lbMessage.setBackground(new Color(249, 181, 181));
                        lbMessage.setForeground(new Color(130, 38, 38));
                        lbMessage.setText("Xác nhận Mật Khẩu không khớp");
                        lbMessage.setVisible(true);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MS_ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new Customer.View.Swing.PanelRound();
        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbMessage = new javax.swing.JLabel();
        lbnewPass = new javax.swing.JLabel();
        lbConfirmPass = new javax.swing.JLabel();
        txtnewPass = new RTDRestaurant.View.Swing.MyPasswordField();
        txtconfirm = new RTDRestaurant.View.Swing.MyPasswordField();
        cmdOK = new Customer.View.Swing.ButtonOutLine();
        cmdCancel = new Customer.View.Swing.ButtonOutLine();
        cmdClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 215, 215));
        setUndecorated(true);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/reset-password (1).png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("ĐỔI MẬT KHẨU TÀI KHOẢN");

        lbMessage.setBackground(new java.awt.Color(249, 181, 181));
        lbMessage.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(130, 38, 38));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Xác nhận Mật Khẩu không khớp");
        lbMessage.setOpaque(true);

        lbnewPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbnewPass.setForeground(new java.awt.Color(89, 89, 89));
        lbnewPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbnewPass.setText("Mật Khẩu mới ");

        lbConfirmPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbConfirmPass.setForeground(new java.awt.Color(89, 89, 89));
        lbConfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbConfirmPass.setText("Xác nhận Mật Khẩu mới");

        txtnewPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnewPassMouseClicked(evt);
            }
        });

        txtconfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtconfirmMouseClicked(evt);
            }
        });

        cmdOK.setBackground(new java.awt.Color(0, 255, 102));
        cmdOK.setBorder(null);
        cmdOK.setText("Xác nhận");
        cmdOK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        cmdCancel.setBackground(new java.awt.Color(255, 51, 51));
        cmdCancel.setBorder(null);
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close (2).png"))); // NOI18N
        cmdClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(lbIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbConfirmPass)
                    .addComponent(lbnewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txtconfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed

    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        closeMenu();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCloseMouseClicked
        closeMenu();
    }//GEN-LAST:event_cmdCloseMouseClicked

    private void txtnewPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnewPassMouseClicked
        // TODO add your handling code here:
        if (txtnewPass.getSuffixIcon().equals(ihide)) {
            txtnewPass.setSuffixIcon(ishow);
            txtnewPass.setEchoChar((char) 0);

        } else {
            txtnewPass.setSuffixIcon(ihide);
            txtnewPass.setEchoChar(def);
        }
    }//GEN-LAST:event_txtnewPassMouseClicked

    private void txtconfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtconfirmMouseClicked
        // TODO add your handling code here:
        if (txtconfirm.getSuffixIcon().equals(ihide)) {
            txtconfirm.setSuffixIcon(ishow);
            txtconfirm.setEchoChar((char) 0);

        } else {
            txtconfirm.setSuffixIcon(ihide);
            txtconfirm.setEchoChar(def);
        }
    }//GEN-LAST:event_txtconfirmMouseClicked

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#516395"), 0, getHeight(), Color.decode("#614385"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Customer.View.Swing.ButtonOutLine cmdCancel;
    private javax.swing.JLabel cmdClose;
    private Customer.View.Swing.ButtonOutLine cmdOK;
    private javax.swing.JLabel lbConfirmPass;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbnewPass;
    private Customer.View.Swing.PanelRound panelRound2;
    private RTDRestaurant.View.Swing.MyPasswordField txtconfirm;
    private RTDRestaurant.View.Swing.MyPasswordField txtnewPass;
    // End of variables declaration//GEN-END:variables
}
