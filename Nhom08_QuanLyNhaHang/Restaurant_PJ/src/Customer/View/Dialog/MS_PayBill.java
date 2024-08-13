package Customer.View.Dialog;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Model.ModelCTHD;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelVoucher;
import Customer.View.Swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MS_PayBill extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;
    private Frame frame;
    private ServiceCustomer service;

    public MS_PayBill(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        service = new ServiceCustomer();
        this.frame = parent;
        setOpacity(0f);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
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

    public void showBill(ModelHoaDon hoadon) {
        try {
            setLocationRelativeTo(frame);
            DecimalFormat df = new DecimalFormat("##,###,###");
            lbDate.setText("Ngày: " + hoadon.getNgayHD());
            txtTienMonAn.setText(df.format(hoadon.getTienMonAn()) + "đ");
            txtTienGiam.setText(df.format(hoadon.getTienGiam()) + "đ");
            txtTotal.setText(df.format(hoadon.getTongtien()) + "đ");
            if (hoadon.getCode_voucher() != null) {
                ArrayList<ModelVoucher> listVoucher = service.MenuVoucher();
                for (ModelVoucher data : listVoucher) {
                    if (hoadon.getCode_voucher().compareTo(data.getCode()) == 0) {
                        txtVoucher.setText("Giảm: " + data.getDescription());
                    }
                }
            }
            else{
                txtVoucher.setText("Bạn chưa sử dụng mã giảm giá");
            }
            //Lấy danh sách CTHD từ hóa đơn tham số
            ArrayList<ModelCTHD> listCTHD = service.getCTHD(hoadon.getIdHoaDon());
            for (ModelCTHD data : listCTHD) {
                cthd.addRow(new Object[]{data.getTenMonAn(), data.getSoluong(), df.format(data.getThanhTien()) + "đ"});
            }

            animator.start();

            setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MS_PayBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Customer.View.Swing.PanelRound();
        cmdExit = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cthd = new Customer.View.Swing.Table();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lbTienMonAn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbThank = new javax.swing.JLabel();
        txtTienMonAn = new Customer.View.Swing.MyTextField();
        txtTienGiam = new Customer.View.Swing.MyTextField();
        txtTotal = new Customer.View.Swing.MyTextField();
        txtVoucher = new Customer.View.Swing.MyTextField();
        lbTienMonAn1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 215, 215));
        setUndecorated(true);

        panelRound1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 3));

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close (4).png"))); // NOI18N
        cmdExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdExitMouseClicked(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Restaurant Anh Em Cây Khế");

        jSeparator1.setBackground(new java.awt.Color(76, 76, 76));

        lbDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDate.setForeground(new java.awt.Color(108, 91, 123));
        lbDate.setText("Ngày");

        cthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Món ăn", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(cthd);

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(108, 91, 123));
        jLabel2.setText("Tiền Giảm Giá");

        lbTienMonAn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbTienMonAn.setForeground(new java.awt.Color(108, 91, 123));
        lbTienMonAn.setText("Tiền Món Ăn");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(108, 91, 123));
        jLabel3.setText("Tổng Tiền");

        lbThank.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        lbThank.setForeground(new java.awt.Color(108, 91, 123));
        lbThank.setText("THANK YOU FOR YOUR PURCHASE");

        lbTienMonAn1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbTienMonAn1.setForeground(new java.awt.Color(108, 91, 123));
        lbTienMonAn1.setText("Voucher Sử Dụng");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(lbTitle))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbDate)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmdExit))
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbTienMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addComponent(lbTienMonAn1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVoucher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(txtTienMonAn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTienGiam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(lbThank)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdExit)
                .addGap(2, 2, 2)
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTienMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTienMonAn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lbThank)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdExitMouseClicked
        closeMenu();
    }//GEN-LAST:event_cmdExitMouseClicked

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
    private javax.swing.JLabel cmdExit;
    private Customer.View.Swing.Table cthd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbThank;
    private javax.swing.JLabel lbTienMonAn;
    private javax.swing.JLabel lbTienMonAn1;
    private javax.swing.JLabel lbTitle;
    private Customer.View.Swing.PanelRound panelRound1;
    private Customer.View.Swing.MyTextField txtTienGiam;
    private Customer.View.Swing.MyTextField txtTienMonAn;
    private Customer.View.Swing.MyTextField txtTotal;
    private Customer.View.Swing.MyTextField txtVoucher;
    // End of variables declaration//GEN-END:variables
}
