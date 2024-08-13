package Customer.View.Form;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Model.ModelMonAn;
import Customer.Model.ModelKhachHang;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelNguoiDung;
import Customer.View.Component.CardMonAn;
import Customer.View.Dialog.MS_PayBill;
import Customer.View.Dialog.MS_Warning;
import Customer.View.Main.Main_Customer_Frame;
import Customer.View.Swing.scrollbar.ScrollBarCustom;
import Customer.View.Swing.WrapLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class FoodMenu_Form extends javax.swing.JPanel {

    private String type;
    private ServiceCustomer service;
    private ArrayList<ModelMonAn> list;
    private ModelNguoiDung user = new ModelNguoiDung();
    private ModelKhachHang customer ;
    private ModelHoaDon HoaDon;
    private MS_Warning warning;
    private MS_PayBill obj;

    public FoodMenu_Form(String type, ModelNguoiDung user) {
        this.type = type;
        this.user = user;
        service = new ServiceCustomer();
        warning = new MS_Warning(Main_Customer_Frame.getFrames()[0], true);
        initComponents();
        init();
        //Kiểm tra Khách hàng đã đặt bàn trước khi gọi món hay chưa
        if (HoaDon == null) {
            warning.WarningBook();
            cmdShowBill.setEnabled(false);
            cmdShowBill.setBackground(Color.decode("#232526"));
            txtSearch.setEnabled(false);
            orderby.setEnabled(false);
        } else {
            txtTableName.setText(HoaDon.getIdBan() + "");
        }
    }

    public void init() {
        try {
            panel.setLayout(new WrapLayout(WrapLayout.LEADING, 10, 10));
            txtSearch.setHint("Tìm kiếm món ăn...");
            jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
            customer = service.getCustomer(user.getUserID());
            //Tìm thông tin Hóa Đơn mà Khách Hàng vừa tạo
            HoaDon = service.FindHoaDon(customer);
            //Thêm data cho Menu
            initMenuFood();
            //Set Data cho Tiêu đề Menu
            switch (type) {
                case "Aries": {
                    lbTitle.setText("Menu/" + type + " - Bạch Dương");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/aries.png")));
                    break;
                }
                case "Taurus": {
                    lbTitle.setText("Menu/" + type + " - Kim Ngưu");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/taurus.png")));
                    break;
                }
                case "Gemini": {
                    lbTitle.setText("Menu/" + type + " - Song tử");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/gemini.png")));
                    break;
                }
                case "Cancer": {
                    lbTitle.setText("Menu/" + type + " - Cự Giải");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/cancer.png")));
                    break;
                }
                case "Leo": {
                    lbTitle.setText("Menu/" + type + " - Sư tử");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/leo.png")));
                    break;
                }
                case "Virgo": {
                    lbTitle.setText("Menu/" + type + " - Xử Nữ");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/virgo.png")));
                    break;
                }
                case "Libra": {
                    lbTitle.setText("Menu/" + type + " - Thiên Bình");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/libra.png")));
                    break;
                }
                case "Scorpio": {
                    lbTitle.setText("Menu/" + type + " - Bọ Cạp");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/scorpio.png")));
                    break;
                }
                case "Sagittarius": {
                    lbTitle.setText("Menu/" + type + " - Nhân Mã");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/sagittarius.png")));
                    break;
                }
                case "Capricorn": {
                    lbTitle.setText("Menu/" + type + " - Ma Kết");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/capricorn.png")));
                    break;
                }
                case "Aquarius": {
                    lbTitle.setText("Menu/" + type + " - Bảo Bình");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/aquarius.png")));
                    break;
                }
                case "Pisces": {
                    lbTitle.setText("Menu/" + type + " - Song Ngư");
                    lbTitle.setIcon(new ImageIcon(getClass().getResource("/Icons/MenuBar/pisces.png")));
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodMenu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initMenuFood() {
        try {
            if (HoaDon != null) {
                list = service.MenuFood(type);
                for (ModelMonAn data : list) {
                    panel.add(new CardMonAn(data, HoaDon));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void searchFood(String txt) {
        if (HoaDon != null) {
            panel.removeAll();
            for (ModelMonAn data : list) {
                if (data.getTitle().toLowerCase().contains(txt.toLowerCase())) {
                    panel.add(new CardMonAn(data, HoaDon));
                }
            }
            panel.repaint();
            panel.revalidate();
        }
    }

    public void initMenuFoodOrderby(String txt) {
        try {
            list = service.MenuFoodOrder(type, txt);
            panel.removeAll();
            for (ModelMonAn data : list) {
                panel.add(new CardMonAn(data, HoaDon));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FoodMenu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.repaint();
        panel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        orderby = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbTable = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTableName = new Customer.View.Swing.MyTextField();
        txtSearch = new Customer.View.Swing.MyTextField();
        cmdShowBill = new Customer.View.Swing.Button();

        setBackground(new java.awt.Color(247, 247, 247));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/MenuBar/aries.png"))); // NOI18N
        lbTitle.setText("Menu/Arias - Bạch Dương");
        lbTitle.setIconTextGap(10);
        lbTitle.setInheritsPopupMenu(false);

        orderby.setEditable(true);
        orderby.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderby.setForeground(new java.awt.Color(108, 91, 123));
        orderby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên A->Z", "Giá tăng dần", "Giá giảm dần" }));
        orderby.setToolTipText("Sắp xếp");
        orderby.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        orderby.setFocusable(false);
        orderby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderbyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 91, 123));
        jLabel1.setText("Sắp xếp theo");

        lbTable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTable.setForeground(new java.awt.Color(89, 89, 89));
        lbTable.setText("MÃ BÀN CỦA BẠN");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        txtTableName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTableName.setText("Chưa đặt bàn");
        txtTableName.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
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

        cmdShowBill.setBackground(new java.awt.Color(0, 255, 255));
        cmdShowBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboard.png"))); // NOI18N
        cmdShowBill.setText("Xem hóa đơn");
        cmdShowBill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdShowBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShowBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addGap(559, 559, 559)))
                        .addComponent(orderby, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTable)
                        .addGap(35, 35, 35)
                        .addComponent(txtTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(orderby))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        searchFood(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchFood(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void orderbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbyActionPerformed
        initMenuFoodOrderby(orderby.getSelectedItem().toString());
    }//GEN-LAST:event_orderbyActionPerformed

    private void cmdShowBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShowBillActionPerformed
        try {
            obj = new MS_PayBill(Main_Customer_Frame.getFrames()[0], true);
            
            HoaDon = service.FindHoaDon(customer);
            obj.showBill(HoaDon);
        } catch (SQLException ex) {
            Logger.getLogger(FoodMenu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdShowBillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Customer.View.Swing.Button cmdShowBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbTable;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JComboBox<String> orderby;
    private javax.swing.JPanel panel;
    private Customer.View.Swing.MyTextField txtSearch;
    private Customer.View.Swing.MyTextField txtTableName;
    // End of variables declaration//GEN-END:variables
}
