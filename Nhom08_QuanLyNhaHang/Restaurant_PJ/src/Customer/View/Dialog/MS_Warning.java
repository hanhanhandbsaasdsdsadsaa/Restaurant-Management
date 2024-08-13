package Customer.View.Dialog;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MS_Warning extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;
    private Frame frame;
    

    public MS_Warning(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
    //Hiện cảnh báo khách hàng chưa đặt bàn
    public void WarningBook() {
        setLocationRelativeTo(frame);
        lbTitle.setText("QUÝ KHÁCH CHƯA ĐẶT BÀN!!!");
        lbMessage.setText("Quý khách vui lòng đặt bàn trước khi gọi món.");
        animator.start();
        setVisible(true);
    }
    //Hiện cảnh báo chưa đủ điểm tích lũy để đổi Voucher
    public void WarningExchange(int need) {
        setLocationRelativeTo(frame);
        lbTitle.setText("QUÝ KHÁCH CHƯA ĐỦ XU!!!");
        lbMessage.setText("Quý khách còn thiếu "+need+" xu để đổi Voucher này.");
        animator.start();
        setVisible(true);
    }
    
    //Hiện cảnh báo khách hàng chưa đặt bàn
    public void WarningExchange() {
        setLocationRelativeTo(frame);
        lbTitle.setText("QUÝ KHÁCH CHƯA ĐẶT BÀN!!!");
        lbMessage.setText("Quý khách vui lòng đặt bàn trước khi đổi voucher");
        animator.start();
        setVisible(true);
    }
    
    //Thông báo nhập thiếu thông tin
    public void WarningLackofInfo() {
        setLocationRelativeTo(frame);
        lbTitle.setText("THIẾU THÔNG TIN !!!");
        lbMessage.setText("Vui lòng nhập đủ thông tin trước khi thực hiện.");
        animator.start();
        setVisible(true);
    }
    //Thông báo không thể sa thải Quản lý
    public void WarningFireAdmin() {
        setLocationRelativeTo(frame);
        lbTitle.setText("KHÔNG ĐỦ QUYỀN HẠN !!!");
        lbMessage.setText("Bạn không đủ quyền hạn để sa thải Quản Lý.");
        animator.start();
        setVisible(true);
    }
    
    //Hiện cảnh báo khách hàng phải thanh toán hóa đơn trước khi đặt bàn khác
    public void WarningBookTable() {
        setLocationRelativeTo(frame);
        lbTitle.setText("QUÝ KHÁCH CHƯA THANH TOÁN HÓA ĐƠN!!!");
        lbMessage.setText("Quý khách vui lòng thanh toán hóa đơn trước khi đặt bàn khác.");
        animator.start();
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new Customer.View.Swing.PanelRound();
        lbIcon = new javax.swing.JLabel();
        cmdClose = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbMessage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 215, 215));
        setUndecorated(true);

        panelRound2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/warning (2).png"))); // NOI18N

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close (2).png"))); // NOI18N
        cmdClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdCloseMouseClicked(evt);
            }
        });

        jScrollPane1.setBorder(null);

        lbMessage.setBackground(new java.awt.Color(255, 255, 255));
        lbMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(108, 91, 123));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Quý khách vui lòng đặt bàn trước khi gọi món.");
        lbMessage.setOpaque(true);
        jScrollPane1.setViewportView(lbMessage);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        lbTitle.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("QUÝ KHÁCH CHƯA ĐẶT BÀN !!!");
        lbTitle.setOpaque(true);
        jScrollPane2.setViewportView(lbTitle);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(cmdClose)
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane1)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdClose)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(lbIcon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCloseMouseClicked
        closeMenu();
    }//GEN-LAST:event_cmdCloseMouseClicked

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
    private javax.swing.JLabel cmdClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbTitle;
    private Customer.View.Swing.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
