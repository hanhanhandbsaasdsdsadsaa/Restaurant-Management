package Customer.View.Component.Staff_Component;

import Customer.Model.ModelBan;
import Customer.Model.ModelNguoiDung;
import Customer.Model.ModelNhanVien;
import Customer.View.Form.Staff_Form.FrmStaffOrderFood;
import Customer.View.Form.Staff_Form.FrmStaffTable;
//import RTDRestaurant.View.Dialog.MS_CancelReserve;
//import RTDRestaurant.View.Dialog.MS_ConfirmReserve;
//import RTDRestaurant.View.Form.Staff_Form.Staff.OrderFood_Form;
//import RTDRestaurant.View.Main_Frame.Main_Staff_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CardBanS extends javax.swing.JPanel {
    
    private final ModelBan table;
    private ModelNhanVien staff;
    private ModelNguoiDung user;
//    private MS_ConfirmReserve book;
//    private MS_CancelReserve cancel;
    private JFrame frame;
    
    public CardBanS(ModelNguoiDung user,ModelNhanVien staff,ModelBan table, JFrame frame) {
        this.user=user;
        this.staff=staff;
        this.table = table;
        this.frame = frame;
        initComponents();
        init();
    }
    
    public void init(){
//        book = new MS_ConfirmReserve(Main_Staff_Frame.getFrames()[0], true);
//        cancel = new MS_CancelReserve(Main_Staff_Frame.getFrames()[0], true);
        setPreferredSize(new Dimension(300, 325));
        lbTitle.setText("Mã bàn: "+table.getID()+" - "+table.getName());
        lbValue.setText(table.getStatus());
        switch (table.getStatus()) {
            case "Con trong" : {
                img.setBackground(Color.decode("#E9E4F0"));
                cmdAdj.setBackground(Color.decode("#355C7D"));
                cmdAdj.setText("ĐẶT TRƯỚC");
                //Nếu bàn trống thì thêm event xử lý đặt bàn
                cmdAdj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                       book.ConfirmReserve(table);
                    }
                });
                break;
            }
            case "Dang dung bua" : {
                img.setBackground(Color.decode("#605C3C"));
                cmdAdj.setText("GỌI MÓN");
                cmdAdj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FrmStaffOrderFood frm = new FrmStaffOrderFood(user, staff, table);
                        frm.setVisible(true);
                        frame.setVisible(false);
                    }
                });
                break;
            }
            case "Da dat truoc" : {
                img.setBackground(Color.decode("#FFE000"));
                cmdAdj.setText("HỦY ĐẶT TRƯỚC");
                cmdAdj.setBackground(Color.decode("#c94b4b"));
                cmdAdj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                       cancel.CancelReserve(table);
                    }
                });
                break;
            }
            default : {
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbValue = new javax.swing.JLabel();
        cmdAdj = new javax.swing.JButton();

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/table2.png"))); // NOI18N
        img.setOpaque(true);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTitle.setText("Title");

        lbValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbValue.setText("Value");

        cmdAdj.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdAdj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/levels.png"))); // NOI18N
        cmdAdj.setText("Tùy chỉnh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmdAdj)
                    .addComponent(lbValue)
                    .addComponent(lbTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdAdj)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdj;
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    // End of variables declaration//GEN-END:variables
}
