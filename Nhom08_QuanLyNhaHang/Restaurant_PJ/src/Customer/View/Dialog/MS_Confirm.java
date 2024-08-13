package Customer.View.Dialog;

import Customer.Controller.Service.ServiceCustomer;
//import RTDRestaurant.Controller.Service.ServiceStaff;
import Customer.Model.ModelKhachHang;
import Customer.Model.ModelBan;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelVoucher;

//import RTDRestaurant.Model.ModelNguyenLieu;
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
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MS_Confirm extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;
    private Frame frame;
    private ServiceCustomer service;
//    private ServiceStaff serviceS;
    boolean delete;

    public MS_Confirm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        service = new ServiceCustomer();
//        serviceS = new ServiceStaff();
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
    }

    //Xác nhận đặt bàn ở Khách Hàng
    public void Cus_ConfirmBook(ModelBan table, ModelKhachHang customer) {
        setLocationRelativeTo(frame);
        lbTitle.setText("XÁC NHẬN ĐẶT BÀN");
        lbMessage.setText("Bạn có chắc đặt bàn " + table.getName() + " không?");
        animator.start();
        cmdOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    service.InsertHoaDon(table, customer);
                } catch (SQLException ex) {
                    Logger.getLogger(MS_Confirm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        setVisible(true);
    }

    //Xác nhận đổi voucher của khách hàng
    public void ConfirmExchange(ModelHoaDon hoadon, ModelVoucher voucher, int Vpoint, ModelKhachHang customer) {
        setLocationRelativeTo(frame);
        lbMessage.setText("Bạn có chắc đổi Voucher (Code:" + voucher.getCode() + ") vào Hóa Đơn (ID_HD:" + hoadon.getIdHoaDon() + ") không?");
        animator.start();
        cmdOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    service.exchangeVoucher(hoadon.getIdHoaDon(), voucher.getCode(), Vpoint, customer.getID_KH());
                } catch (SQLException ex) {
                    Logger.getLogger(MS_Confirm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        setVisible(true);
    }

    //Xác nhận đổi tên khách hàng
    public void ConfirmReName(String newName, ModelKhachHang customer) {
        setLocationRelativeTo(frame);
        lbIcon.setIcon(new ImageIcon(getClass().getResource("/Icons/rename.png")));
        lbTitle.setText("Xác nhận đổi tên");
        lbMessage.setText("Bạn có chắc đổi tên thành " + newName + " không?");
        animator.start();
        cmdOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    customer.setName(newName);
                    service.reNameCustomer(customer);
                } catch (SQLException ex) {
                    Logger.getLogger(MS_Confirm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        setVisible(true);
    }

    //Xác nhận xóa nguyên liệu ở nhân viên kho
//    public boolean Staff_ConfirmDelete(ModelNguyenLieu data ){
//        setLocationRelativeTo(frame);
//        delete=false;
//        lbIcon.setIcon(new ImageIcon(getClass().getResource("/Icons/remove.png")));
//        lbTitle.setText("XÁC NHẬN XÓA NGUYÊN LIỆU");
//        lbMessage.setText("Bạn có chắc xóa nguyên liệu " + data.getTenNL() + " không ?");
//        animator.start();
//        cmdOK.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    delete=true;
//                    serviceS.DeleteNL(data);
//                } catch (SQLException ex) {
//                    Logger.getLogger(MS_Confirm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        setVisible(true);
//        return delete;
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Customer.View.Swing.PanelRound();
        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        cmdCancel = new Customer.View.Swing.ButtonOutLine();
        cmdOK = new Customer.View.Swing.ButtonOutLine();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 215, 215));
        setUndecorated(true);

        panelRound1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/warning (1).png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("BẠN ĐÃ CHẮC CHƯA ?\n");

        cmdCancel.setBackground(new java.awt.Color(255, 0, 0));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdOK.setBackground(new java.awt.Color(0, 255, 0));
        cmdOK.setText("Xác nhận");
        cmdOK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        lbMessage.setBackground(new java.awt.Color(255, 255, 255));
        lbMessage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(108, 91, 123));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Message");
        lbMessage.setOpaque(true);
        jScrollPane1.setViewportView(lbMessage);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGap(0, 291, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(lbIcon)
                                .addGap(286, 286, 286))))))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGap(23, 23, 23)))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                    .addContainerGap(219, Short.MAX_VALUE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        closeMenu();
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        closeMenu();
    }//GEN-LAST:event_cmdCancelActionPerformed

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
    private Customer.View.Swing.ButtonOutLine cmdOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbTitle;
    private Customer.View.Swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
