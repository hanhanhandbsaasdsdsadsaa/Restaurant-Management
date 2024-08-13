package Customer.View.Dialog;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Model.ModelMonAn;
//import RTDRestaurant.View.Form.Customer_Form.AccountC_Form;
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
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MS_ConfirmOrderFood extends javax.swing.JDialog {
    
    private final Animator animator;
    private boolean show = true;
    private Frame frame;
    private ServiceCustomer service;

    public MS_ConfirmOrderFood(java.awt.Frame parent, boolean modal) {
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
        
    }
    
    public void ConfirmOrder(ModelMonAn monan, int soluong,int ID_HoaDon) {
        setLocationRelativeTo(frame);
        lbMessage.setText("Bạn có chắc muốn đặt món ("+monan.getTitle()+") với số lượng "+soluong+" không?");
        lbTotal.setText("Tổng tiền: "+(monan.getValue()*soluong));
        animator.start();
        cmdOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    service.InsertCTHD(ID_HoaDon, monan.getId(), soluong);
                } catch (SQLException ex) {
//                    Logger.getLogger(AccountC_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Customer.View.Swing.PanelRound();
        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        cmdOK = new Customer.View.Swing.ButtonOutLine();
        cmdCancel = new Customer.View.Swing.ButtonOutLine();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 215, 215));
        setUndecorated(true);

        panelRound1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 5));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ask (1).png"))); // NOI18N
        lbIcon.setToolTipText("");

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Xác Nhận Đặt Món");

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("Total");

        cmdOK.setBackground(new java.awt.Color(51, 204, 0));
        cmdOK.setText("Xác nhận");
        cmdOK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        cmdCancel.setBackground(new java.awt.Color(255, 51, 51));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        lbMessage.setBackground(new java.awt.Color(204, 255, 255));
        lbMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Message");
        lbMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMessage.setOpaque(true);
        jScrollPane1.setViewportView(lbMessage);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTitle)
                    .addComponent(lbIcon)
                    .addComponent(lbTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lbTotal)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel lbTotal;
    private Customer.View.Swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
