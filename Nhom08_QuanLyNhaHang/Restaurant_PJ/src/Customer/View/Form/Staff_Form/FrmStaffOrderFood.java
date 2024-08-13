
package Customer.View.Form.Staff_Form;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Controller.Service.ServiceStaff;
import Customer.Model.ModelBan;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelMonAn;
import Customer.Model.ModelNguoiDung;
import Customer.Model.ModelNhanVien;
import Customer.View.Component.CardMonAn;
import Customer.View.Main.Login_Form.FrmLogin;
import Customer.View.Swing.WrapLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FrmStaffOrderFood extends javax.swing.JFrame {

    private ServiceStaff serviceS;
    private ServiceCustomer serviceC;
    private ArrayList<ModelMonAn> list;
    private ModelNhanVien staff;
    private ModelNguoiDung user;
    private ModelBan table;
    private ModelHoaDon HoaDon;
    private JFrame frame = this;
    
    public FrmStaffOrderFood() {
        initComponents();
    }
    
    public FrmStaffOrderFood(ModelNguoiDung user,ModelNhanVien staff,ModelBan table) {
        this.user=user;
        this.staff=staff;
        this.table=table;
        serviceS = new ServiceStaff();
        serviceC = new ServiceCustomer();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        init();
    }
    
    public void init() {

        panel.setLayout(new WrapLayout(WrapLayout.LEADING, 10, 10));
        //Tìm thông tin hóa đơn
        try {
            HoaDon=serviceS.FindHoaDonbyID_Ban(table);
        } catch (SQLException ex) {
            Logger.getLogger(FrmStaffOrderFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTableID.setText(table.getID()+"");
        txtKH.setText(HoaDon.getIdKH()+"");
        
        initMenuFood("Aries");
        
        cmdShowBill.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmStaffBill frm = new FrmStaffBill(user,staff,table,HoaDon);
                frm.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    public void initMenuFood(String type) {
        try {
            list = serviceC.MenuFood(type);
            panel.removeAll();
            for (ModelMonAn data : list) {
                panel.add(new CardMonAn(data, HoaDon));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        panel.repaint();
        panel.revalidate();
    }

    public void searchFood(String txt) {
        panel.removeAll();
        for (ModelMonAn data : list) {
            if (data.getTitle().toLowerCase().contains(txt.toLowerCase())) {
                panel.add(new CardMonAn(data, HoaDon));
            }
        }
        panel.repaint();
        panel.revalidate();
    }

    public void initMenuFoodOrderby(String txt) {
        try {
            list = serviceC.MenuFoodOrder((String) TypeMenu.getSelectedItem(), txt);
            panel.removeAll();
            for (ModelMonAn data : list) {
                panel.add(new CardMonAn(data, HoaDon));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrmStaffOrderFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.repaint();
        panel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblQuanLyThucDon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblQuanLyTang1 = new javax.swing.JLabel();
        lblQuanLyTang2 = new javax.swing.JLabel();
        lblQuanLyTang3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblThongTinKhachHang = new javax.swing.JLabel();
        lblThongTinCaNhan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTableID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtKH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TypeMenu = new javax.swing.JComboBox<>();
        orderby = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        cmdShowBill = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Cây Khế Restaurant");

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information-desk.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Staff");

        lblQuanLyThucDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuanLyThucDon.setText("Quản lý bàn");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/MenuBar/table.png"))); // NOI18N

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customer (1).png"))); // NOI18N

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (2).png"))); // NOI18N

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTaiKhoan.setText("Tài khoản");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/10.png"))); // NOI18N

        lblDangXuat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDangXuat.setText("Đăng xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIcon)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuanLyThucDon)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lblQuanLyTang1)
                            .addComponent(lblQuanLyTang2)
                            .addComponent(lblQuanLyTang3)
                            .addComponent(lblThongTinKhachHang)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTaiKhoan)
                            .addComponent(lblDangXuat)
                            .addComponent(lblThongTinCaNhan))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addComponent(lblThongTinCaNhan)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTaiKhoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDangXuat)))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jPanel2.setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mã Bàn");

        txtTableID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Mã Khách Hàng");

        txtKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N
        jLabel9.setText("  Danh Sách Thực Đơn");

        TypeMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TypeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces" }));
        TypeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeMenuActionPerformed(evt);
            }
        });

        orderby.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orderby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ A->Z", "Giá giảm dần", "Giá tăng dần" }));
        orderby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderbyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Sắp Xếp Theo");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSearchMouseEntered(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tìm kiếm món ăn");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        cmdShowBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdShowBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboard.png"))); // NOI18N
        cmdShowBill.setText("Xem hóa đơn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTableID, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TypeMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKH)
                    .addComponent(orderby, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdShowBill, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTableID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TypeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(orderby, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblQuanLyTang1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang1MouseMoved
        // TODO add your handling code here:
        lblQuanLyTang1.setForeground(Color.white);
        lblQuanLyTang1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblQuanLyTang1MouseMoved

    private void lblQuanLyTang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang1MouseClicked
        // TODO add your handling code here:
        FrmStaffTable frm = new FrmStaffTable("Tang 1", user);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblQuanLyTang1MouseClicked

    private void lblQuanLyTang1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang1MouseExited
        // TODO add your handling code here:
        lblQuanLyTang1.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyTang1MouseExited

    private void lblQuanLyTang2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang2MouseMoved
        // TODO add your handling code here:
        lblQuanLyTang2.setForeground(Color.white);
        lblQuanLyTang2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblQuanLyTang2MouseMoved

    private void lblQuanLyTang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang2MouseClicked
        // TODO add your handling code here:
        FrmStaffTable frm = new FrmStaffTable("Tang 2", user);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblQuanLyTang2MouseClicked

    private void lblQuanLyTang2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang2MouseExited
        // TODO add your handling code here:
        lblQuanLyTang2.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyTang2MouseExited

    private void lblQuanLyTang3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang3MouseMoved
        // TODO add your handling code here:
        lblQuanLyTang3.setForeground(Color.white);
        lblQuanLyTang3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblQuanLyTang3MouseMoved

    private void lblQuanLyTang3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang3MouseClicked
        // TODO add your handling code here:
        FrmStaffTable frm = new FrmStaffTable("Tang 3", user);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblQuanLyTang3MouseClicked

    private void lblQuanLyTang3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyTang3MouseExited
        // TODO add your handling code here:
        lblQuanLyTang3.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyTang3MouseExited

    private void lblThongTinKhachHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinKhachHangMouseMoved
        // TODO add your handling code here:
        lblThongTinKhachHang.setForeground(Color.white);
        lblThongTinKhachHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblThongTinKhachHangMouseMoved

    private void lblThongTinKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinKhachHangMouseClicked
        // TODO add your handling code here:
        FrmStaffCustomer frm = new FrmStaffCustomer(user);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblThongTinKhachHangMouseClicked

    private void lblThongTinKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinKhachHangMouseExited
        // TODO add your handling code here:
        lblThongTinKhachHang.setForeground(Color.black);
    }//GEN-LAST:event_lblThongTinKhachHangMouseExited

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        int approve = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn thoát?", "Đăng xuất", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (approve == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            FrmLogin frm = new FrmLogin();
            frm.setVisible(true);
        }
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void TypeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeMenuActionPerformed
        // TODO add your handling code here:
        initMenuFood(TypeMenu.getSelectedItem().toString());
    }//GEN-LAST:event_TypeMenuActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        searchFood(txtSearch.getText());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        // TODO add your handling code here:
        searchFood(txtSearch.getText()); 
    }//GEN-LAST:event_txtSearchMouseEntered

    private void orderbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbyActionPerformed
        // TODO add your handling code here:
        initMenuFoodOrderby(orderby.getSelectedItem().toString());
    }//GEN-LAST:event_orderbyActionPerformed

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
            java.util.logging.Logger.getLogger(FrmStaffOrderFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmStaffOrderFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmStaffOrderFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmStaffOrderFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmStaffOrderFood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TypeMenu;
    private javax.swing.JButton cmdShowBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblQuanLyTang1;
    private javax.swing.JLabel lblQuanLyTang2;
    private javax.swing.JLabel lblQuanLyTang3;
    private javax.swing.JLabel lblQuanLyThucDon;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JLabel lblThongTinKhachHang;
    private javax.swing.JComboBox<String> orderby;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTableID;
    // End of variables declaration//GEN-END:variables
}
