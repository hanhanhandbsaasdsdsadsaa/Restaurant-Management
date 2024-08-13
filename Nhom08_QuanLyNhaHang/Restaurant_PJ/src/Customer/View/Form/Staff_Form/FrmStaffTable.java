package Customer.View.Form.Staff_Form;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Customer.View.Main.Login_Form.FrmLogin;
import Customer.Controller.Service.ServiceCustomer;
import Customer.Controller.Service.ServiceStaff;
import Customer.Model.ModelBan;
import Customer.Model.ModelNguoiDung;
import Customer.Model.ModelNhanVien;
import Customer.View.Swing.WrapLayout;
import Customer.View.Component.Staff_Component.CardBanS;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmStaffTable extends javax.swing.JFrame {

    private String floor;
    private ServiceCustomer serviceC;
    private ServiceStaff serviceS;
    private ArrayList<ModelBan> list;
    private ModelNguoiDung user;
    private ModelNhanVien staff;
    private JFrame frame;

    public FrmStaffTable() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public FrmStaffTable(ModelNguoiDung user) {
        initComponents();
        this.user = user;
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public FrmStaffTable(String floor, ModelNguoiDung user) {
        initComponents();
        this.floor = floor;
        this.user = user;
        this.frame = this;
        serviceC = new ServiceCustomer();
        serviceS = new ServiceStaff();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        init();
    }

    public void init() {
        try {
            staff = serviceS.getStaff(user.getUserID());
            panel.setLayout(new WrapLayout(WrapLayout.LEADING, 10, 10));
            //Thêm data cho Menu
            initMenuTable();

        } catch (SQLException ex) {
            Logger.getLogger(FrmStaffTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initMenuTable() {
        try {
            list = serviceC.MenuTable(floor);
            for (ModelBan data : list) {
                panel.add(new CardBanS(user, staff,data, frame));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenuBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblQuanLyThucDon = new javax.swing.JLabel();
        lblQuanLyTang1 = new javax.swing.JLabel();
        lblQuanLyTang2 = new javax.swing.JLabel();
        lblQuanLyTang3 = new javax.swing.JLabel();
        lblThongTinKhachHang = new javax.swing.JLabel();
        lblThongTinCaNhan = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblInforFloor = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cây Khế Restaurant");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cây Khế Restaurant");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Staff");

        lblQuanLyThucDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuanLyThucDon.setText("Quản lý bàn");

        lblQuanLyTang1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuanLyTang1.setText("Tầng 1");
        lblQuanLyTang1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblQuanLyTang1MouseMoved(evt);
            }
        });
        lblQuanLyTang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLyTang1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLyTang1MouseExited(evt);
            }
        });

        lblQuanLyTang2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuanLyTang2.setText("Tầng 2");
        lblQuanLyTang2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblQuanLyTang2MouseMoved(evt);
            }
        });
        lblQuanLyTang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLyTang2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLyTang2MouseExited(evt);
            }
        });

        lblQuanLyTang3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuanLyTang3.setText("Tầng 3");
        lblQuanLyTang3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblQuanLyTang3MouseMoved(evt);
            }
        });
        lblQuanLyTang3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLyTang3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLyTang3MouseExited(evt);
            }
        });

        lblThongTinKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThongTinKhachHang.setText("Thông tin khách hàng");
        lblThongTinKhachHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblThongTinKhachHangMouseMoved(evt);
            }
        });
        lblThongTinKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongTinKhachHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThongTinKhachHangMouseExited(evt);
            }
        });

        lblThongTinCaNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThongTinCaNhan.setText("Thông tin cá nhân");

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTaiKhoan.setText("Tài khoản");

        lblDangXuat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDangXuat.setText("Đăng xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information-desk.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/MenuBar/table.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customer (1).png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (2).png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/10.png"))); // NOI18N

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuBarLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                                .addComponent(lblIcon)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuBarLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))
                        .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuanLyThucDon)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(lblQuanLyTang1)
                            .addComponent(lblQuanLyTang2)
                            .addComponent(lblQuanLyTang3)
                            .addComponent(lblThongTinKhachHang)))
                    .addGroup(pnlMenuBarLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(31, 31, 31)
                        .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTaiKhoan)
                            .addComponent(lblDangXuat)
                            .addComponent(lblThongTinCaNhan))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuBarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(lblQuanLyThucDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQuanLyTang1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQuanLyTang2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQuanLyTang3)
                        .addGap(53, 53, 53)
                        .addComponent(lblThongTinKhachHang))
                    .addGroup(pnlMenuBarLayout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addComponent(lblThongTinCaNhan)
                .addGap(78, 78, 78)
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMenuBarLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuBarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTaiKhoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDangXuat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/one.png"))); // NOI18N

        lblInforFloor.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblInforFloor.setText("Quản lý bàn/Tầng 1 ");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Hiển thị theo");

        state.setEditable(true);
        state.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        state.setForeground(new java.awt.Color(108, 91, 123));
        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn trống", "Đang dùng bữa", "Đã đặt trước" }));
        state.setToolTipText("Sắp xếp");
        state.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        state.setFocusable(false);
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(215, 221, 232));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panel);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tìm kiếm bàn");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)
                        .addComponent(lblInforFloor))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblInforFloor))
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(state, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        int approve = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn thoát?", "Đăng xuất", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (approve == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            FrmLogin frm = new FrmLogin();
            frm.setVisible(true);
        }
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblQuanLyTang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang1MouseClicked
        // TODO add your handling code here:
        FrmStaffTable frm = new FrmStaffTable("Tang 1", user);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblQuanLyTang1MouseClicked

    private void lblQuanLyTang3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang3MouseClicked
        // TODO add your handling code here:
        FrmStaffTable frm = new FrmStaffTable("Tang 3", user);
        frm.lblInforFloor.setText("Quản lý bàn/Tầng 3");
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblQuanLyTang3MouseClicked

    private void lblQuanLyTang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang2MouseClicked
        // TODO add your handling code here:
        FrmStaffTable frm = new FrmStaffTable("Tang 2", user);
        frm.lblInforFloor.setText("Quản lý bàn/Tầng 2");
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblQuanLyTang2MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lblThongTinKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinKhachHangMouseClicked
        // TODO add your handling code here:
        FrmStaffCustomer frm = new FrmStaffCustomer(user);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblThongTinKhachHangMouseClicked

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed

    }//GEN-LAST:event_stateActionPerformed

    private void lblQuanLyTang1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang1MouseMoved
        // TODO add your handling code here:
        lblQuanLyTang1.setForeground(Color.white);
        lblQuanLyTang1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblQuanLyTang1MouseMoved

    private void lblQuanLyTang1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang1MouseExited
        // TODO add your handling code here:
        lblQuanLyTang1.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyTang1MouseExited

    private void lblQuanLyTang2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang2MouseMoved
        // TODO add your handling code here:
        lblQuanLyTang2.setForeground(Color.white);
        lblQuanLyTang2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblQuanLyTang2MouseMoved

    private void lblQuanLyTang2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang2MouseExited
        // TODO add your handling code here:
        lblQuanLyTang2.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyTang2MouseExited

    private void lblQuanLyTang3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang3MouseMoved
        // TODO add your handling code here:
        lblQuanLyTang3.setForeground(Color.white);
        lblQuanLyTang3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblQuanLyTang3MouseMoved

    private void lblQuanLyTang3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang3MouseExited
        // TODO add your handling code here:
        lblQuanLyTang3.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyTang3MouseExited

    private void lblThongTinKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinKhachHangMouseExited
        // TODO add your handling code here:
        lblThongTinKhachHang.setForeground(Color.black);
    }//GEN-LAST:event_lblThongTinKhachHangMouseExited

    private void lblThongTinKhachHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinKhachHangMouseMoved
        // TODO add your handling code here:
        lblThongTinKhachHang.setForeground(Color.white);
        lblThongTinKhachHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblThongTinKhachHangMouseMoved

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
            java.util.logging.Logger.getLogger(FrmStaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmStaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmStaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmStaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmStaffTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblInforFloor;
    private javax.swing.JLabel lblQuanLyTang1;
    private javax.swing.JLabel lblQuanLyTang2;
    private javax.swing.JLabel lblQuanLyTang3;
    private javax.swing.JLabel lblQuanLyThucDon;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JLabel lblThongTinKhachHang;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
