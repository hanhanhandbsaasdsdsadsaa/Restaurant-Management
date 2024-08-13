
package Customer.View.Form;

import Customer.Controller.Service.ServiceCustomer;
import Customer.Model.ModelKhachHang;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelNguoiDung;
import Customer.View.Swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bill_Form extends javax.swing.JPanel {

    private ModelNguoiDung user;
    private ModelKhachHang customer;
    private ServiceCustomer service;
    private ArrayList<ModelHoaDon> list;
    DecimalFormat df;

    public Bill_Form(ModelNguoiDung user) {
        this.user=user;
        service=new ServiceCustomer();
        initComponents();
        init();
    }

    public void init(){
        txtSearch.setHint("Tìm kiếm Hóa Đơn . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        df = new DecimalFormat("##,###,###");
        getUserSales();
        //Thêm data cho Menu
        initTable();
        
    }
    public void getUserSales(){
        try {
            customer=service.getCustomer(user.getUserID());
            txtPoint.setText(df.format(customer.getSales())+"đ");
        } catch (SQLException ex) {
            Logger.getLogger(Bill_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initTable(){
        try {
            list = service.getListHD(customer.getID_KH());
            for(ModelHoaDon data:list){  
                tableHD.addRow(new Object[]{data.getIdHoaDon(),data.getNgayHD(),df.format(data.getTienMonAn())+"đ"
                               ,df.format(data.getTienGiam())+"đ"
                               ,df.format(data.getTongtien())+"đ"});
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void searchTable(String txt){
        tableHD.removeAllRow();
        for(ModelHoaDon data:list){
            if((data.getIdHoaDon()+"").toLowerCase().contains(txt.toLowerCase())){
                tableHD.addRow(new Object[]{data.getIdHoaDon(),data.getNgayHD(),df.format(data.getTienMonAn())+"đ"
                               ,df.format(data.getTienGiam())+"đ"
                               ,df.format(data.getTongtien())+"đ"});
            }
        }
        tableHD.repaint();
        tableHD.revalidate();
    }
    public void initTableHDbyTotal(String byTotal){
        try {
            list=service.getListHDOrder(customer.getID_KH(),byTotal);
            tableHD.removeAllRow();
            for(ModelHoaDon data:list){  
                tableHD.addRow(new Object[]{data.getIdHoaDon(),data.getNgayHD(),df.format(data.getTienMonAn())+"đ"
                               ,df.format(data.getTienGiam())+"đ"
                               ,df.format(data.getTongtien())+"đ"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bill_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        cbbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbDso = new javax.swing.JLabel();
        lbBill = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtPoint = new Customer.View.Swing.MyTextField();
        txtSearch = new Customer.View.Swing.MyTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHD = new Customer.View.Swing.Table();

        setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clock.png"))); // NOI18N
        lbTitle.setText("Lịch sử hóa đơn");
        lbTitle.setIconTextGap(10);

        cbbox.setEditable(true);
        cbbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbox.setForeground(new java.awt.Color(108, 91, 123));
        cbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Dưới 1.000.000đ", "Từ 1.000.000đ đến 5.000.000đ", "Trên 5.000.000đ" }));
        cbbox.setToolTipText("Sắp xếp");
        cbbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 145, 145), 2));
        cbbox.setFocusable(false);
        cbbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 91, 123));
        jLabel1.setText("Hiển thị theo");

        lbDso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDso.setForeground(new java.awt.Color(89, 89, 89));
        lbDso.setText("Doanh số của bạn");

        lbBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBill.setForeground(new java.awt.Color(89, 89, 89));
        lbBill.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbBill.setText("Danh sách Hóa Đơn");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

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

        tableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày HĐ", "Tiền Món Ăn", "Tiền Giảm", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tableHD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBill)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDso, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
       
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered

    private void cbboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbboxActionPerformed
        initTableHDbyTotal(cbbox.getSelectedItem().toString());
    }//GEN-LAST:event_cbboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbDso;
    private javax.swing.JLabel lbTitle;
    private Customer.View.Swing.Table tableHD;
    private Customer.View.Swing.MyTextField txtPoint;
    private Customer.View.Swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
