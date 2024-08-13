package Customer.View.Component;

import Customer.Model.ModelKhachHang;
import Customer.Model.ModelBan;
import Customer.Model.ModelHoaDon;
import Customer.View.Dialog.MS_Confirm;
import Customer.View.Main.Main_Customer_Frame;
import Customer.Controller.Service.ServiceCustomer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CardBan extends javax.swing.JPanel {

    private final ModelBan data;
    private final ModelKhachHang customer;
    private MS_Confirm obj;
    private ServiceCustomer service;

    public CardBan(ModelBan data, ModelKhachHang customer) throws SQLException {

        this.data = data;
        this.customer = customer;
        initComponents();
        init();
        setOpaque(false);
    }

    public void init() throws SQLException {
//      setPreferredSize(new Dimension(300, 325));
        lbTitle.setText("Mã bàn: " + data.getID() + " - " + data.getName());
        lbValue.setText(data.getStatus());
        switch (data.getStatus()) {
            case "Con trong": {
                img.setBackground(Color.decode("#00ff3a"));
                //Nếu bàn trống thì thêm event xử lý đặt bàn

                cmdBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        obj = new MS_Confirm(Main_Customer_Frame.getFrames()[0], true);
                        obj.Cus_ConfirmBook(data, customer);
                    }
                });
                break;
            }
            case "Dang dung bua": {
                img.setBackground(Color.decode("#Ff1600"));
                cmdBook.setText("KHÔNG THỂ ĐẶT");
                cmdBook.setBackground(Color.decode("#232526"));
                cmdBook.setEnabled(false);
                break;
            }
            case "Da dat truoc": {
                img.setBackground(Color.decode("#FFE000"));
                cmdBook.setText("KHÔNG THỂ ĐẶT");
                cmdBook.setBackground(Color.decode("#232526"));
                cmdBook.setEnabled(false);
                break;
            }
            default: {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new Customer.View.Swing.PanelRound();
        img = new javax.swing.JLabel();
        cmdBook = new Customer.View.Swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbValue = new javax.swing.JLabel();

        panelRound2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 2));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/table2.png"))); // NOI18N
        img.setOpaque(true);

        cmdBook.setBackground(new java.awt.Color(0, 255, 255));
        cmdBook.setText("Đặt bàn");
        cmdBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBookActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        lbTitle.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");
        lbTitle.setOpaque(true);
        jScrollPane1.setViewportView(lbTitle);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        lbValue.setBackground(new java.awt.Color(255, 255, 255));
        lbValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValue.setText("Value");
        lbValue.setOpaque(true);
        jScrollPane2.setViewportView(lbValue);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(img)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(cmdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdBookActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Customer.View.Swing.Button cmdBook;
    private javax.swing.JLabel img;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    private Customer.View.Swing.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
