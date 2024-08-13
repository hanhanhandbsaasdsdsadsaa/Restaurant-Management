
package Customer.View.Form.Staff_Form;

import Customer.View.Form.Staff_Form.FrmStaffCustomer;
import Customer.View.Main.Login_Form.FrmLogin;
import Customer.Controller.Service.ServiceCustomer;
import Customer.Controller.Service.ServiceStaff;
import Customer.Model.ModelBan;
import Customer.Model.ModelCTHD;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelNguoiDung;
import Customer.Model.ModelNhanVien;
import Customer.View.Dialog.MS_PaymentSuccess;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmStaffBill extends javax.swing.JFrame {

    private ServiceStaff serviceS;
    private ServiceCustomer serviceC;
    private ModelNguoiDung user;
    private ModelNhanVien staff;
    private ModelBan table;
    private ModelHoaDon bill;
    private ArrayList<ModelCTHD> cthd;
    private DecimalFormat df;
    private DefaultTableModel dtm = null;
    private MS_PaymentSuccess conf;
 
    public FrmStaffBill() {
        initComponents();
    }
    
     public FrmStaffBill(ModelNguoiDung user, ModelNhanVien staff, ModelBan table, ModelHoaDon bill) {
        this.user = user;
        this.staff = staff;
        this.table = table;
        this.bill = bill;
        initComponents();
        init();
    }
     
     public void init() {
        serviceS = new ServiceStaff();
        serviceC = new ServiceCustomer();
        df = new DecimalFormat("##,###,###");
        conf = new MS_PaymentSuccess(FrmStaffBill.getFrames()[0], true);
        initTable();
        initCash();

        txtidHD.setText(bill.getIdHoaDon() + "");
        txtidKH.setText(bill.getIdKH() + "");
    }

    public void initTable() {
        try {
            cthd = serviceC.getCTHD(bill.getIdHoaDon());
            dtm = (DefaultTableModel) tableCTHD.getModel();
            for (ModelCTHD data : cthd) {
                dtm.addRow(new Object[]{data.getTenMonAn(), data.getSoluong(), df.format(data.getThanhTien()) + "đ"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmStaffBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initCash() {
        txtTienmonan.setText(df.format(bill.getTienMonAn()) + "d");
        txtTiengiam.setText(df.format(bill.getTienGiam()) + "d");
        txtTongtien.setText(df.format(bill.getTongtien()) + "d");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblQuanLyThucDon = new javax.swing.JLabel();
        lblQuanLyTang1 = new javax.swing.JLabel();
        lblQuanLyTang2 = new javax.swing.JLabel();
        lblQuanLyTang3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblThongTinKhachHang = new javax.swing.JLabel();
        lblThongTinCaNhan = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidKH = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCTHD = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienmonan = new javax.swing.JTextField();
        txtTiengiam = new javax.swing.JTextField();
        txtTongtien = new javax.swing.JTextField();
        txtTienKH = new javax.swing.JTextField();
        txtTientra = new javax.swing.JTextField();
        cmdOK = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information-desk.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Cây Khế Restaurant");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Staff");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/MenuBar/table.png"))); // NOI18N

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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customer (1).png"))); // NOI18N

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (2).png"))); // NOI18N

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTaiKhoan.setText("Tài khoản");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/10.png"))); // NOI18N

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
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuanLyThucDon)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(lblQuanLyTang1)
                            .addComponent(lblQuanLyTang2)
                            .addComponent(lblQuanLyTang3)
                            .addComponent(lblThongTinKhachHang)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
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
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
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
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addComponent(lblThongTinCaNhan)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTaiKhoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDangXuat)))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        jPanel2.setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mã Hóa Đơn");

        txtidHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtidHD.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Mã Khách Hàng");

        txtidKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtidKH.setEnabled(false);

        tableCTHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Món ăn", "Số lượng", "Thành tiền"
            }
        ));
        tableCTHD.setRowHeight(30);
        jScrollPane1.setViewportView(tableCTHD);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Tiền Món Ăn");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tiền Giảm Giá");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Tổng Tiền");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Tiền Khách Đưa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Tiền Trả Lại");

        txtTienmonan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTienmonan.setEnabled(false);

        txtTiengiam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTiengiam.setEnabled(false);

        txtTongtien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTongtien.setEnabled(false);

        txtTienKH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTienKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKHActionPerformed(evt);
            }
        });
        txtTienKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKHKeyPressed(evt);
            }
        });

        txtTientra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTientra.setEnabled(false);

        cmdOK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdOK.setText("Xác Nhận Thanh Toán");
        cmdOK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 51), 2, true));
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        cmdCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdCancel.setText("Hủy");
        cmdCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        jLabel8.setText("Thông Tin Hóa Đơn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTienmonan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtidHD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtidKH, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(171, 171, 171)
                                    .addComponent(txtTiengiam, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTongtien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTienKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTientra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(87, 87, 87))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtidHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtidKH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienmonan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiengiam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTientra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtTienKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKHActionPerformed
        // TODO add your handling code here:
        txtTientra.setText(df.format(Integer.parseInt(txtTienKH.getText()) - bill.getTongtien()) + "d");
    }//GEN-LAST:event_txtTienKHActionPerformed

    private void txtTienKHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_ENTER)
                || (c == KeyEvent.VK_BACK_SPACE))) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
            evt.consume();
        }
    }//GEN-LAST:event_txtTienKHKeyPressed

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        // TODO add your handling code here:
        try {
            //Khi NV bấm xác nhận thanh toán, thay đổi trạng thái hóa đơn từ Chưa thanh toán thành đã thanh toán
            serviceS.UpdateHoaDonStatus(bill.getIdHoaDon());
            conf.ConfirmPaymentSuccess(bill.getIdHoaDon());
            FrmStaffTable frm = new FrmStaffTable("Tang 1", user);
            frm.setVisible(true);
            this.setVisible(false);
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmStaffBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
        FrmStaffOrderFood frm = new FrmStaffOrderFood(user, staff, table);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cmdCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmStaffBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmStaffBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmStaffBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmStaffBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmStaffBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblQuanLyTang1;
    private javax.swing.JLabel lblQuanLyTang2;
    private javax.swing.JLabel lblQuanLyTang3;
    private javax.swing.JLabel lblQuanLyThucDon;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JLabel lblThongTinKhachHang;
    private javax.swing.JTable tableCTHD;
    private javax.swing.JTextField txtTienKH;
    private javax.swing.JTextField txtTiengiam;
    private javax.swing.JTextField txtTienmonan;
    private javax.swing.JTextField txtTientra;
    private javax.swing.JTextField txtTongtien;
    private javax.swing.JTextField txtidHD;
    private javax.swing.JTextField txtidKH;
    // End of variables declaration//GEN-END:variables
}
