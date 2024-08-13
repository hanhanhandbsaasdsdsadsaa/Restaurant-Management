package Customer.View.Component;

import Customer.Model.ModelHoaDon;
import Customer.Model.ModelMonAn;
import Customer.View.Dialog.MS_ConfirmOrderFood;
import Customer.View.Main.Main_Customer_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CardMonAn extends javax.swing.JPanel {

    private  ModelMonAn data;
    private MS_ConfirmOrderFood obj;
    private ModelHoaDon HoaDon;
   
    public CardMonAn(ModelMonAn data,ModelHoaDon HoaDon) {
        this.HoaDon=HoaDon;
        this.data = data;
        initComponents();
        init();
        setOpaque(false);
    }

    public void init() {
        setPreferredSize(new Dimension(300, 350));
        img.setIcon(data.getIcon());
        lbTitle.setText(data.getTitle());
        DecimalFormat df = new DecimalFormat("#,###,###");
        lbValue.setText(df.format(data.getValue()) + "đ");
        cmdOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                obj = new MS_ConfirmOrderFood(Main_Customer_Frame.getFrames()[0], true);
                obj.ConfirmOrder(data, Integer.parseInt(txtNum.getText()),HoaDon.getIdHoaDon());
                txtNum.setText("0");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbValue = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        cmdAdd = new Customer.View.Swing.ButtonOutLine();
        cmdMinus = new Customer.View.Swing.ButtonOutLine();
        txtNum = new Customer.View.Swing.MyTextField();
        cmdOrder = new Customer.View.Swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");

        lbValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbValue.setForeground(new java.awt.Color(108, 91, 123));
        lbValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValue.setText("Value");

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        cmdAdd.setToolTipText("");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/minus.png"))); // NOI18N
        cmdMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMinusActionPerformed(evt);
            }
        });

        txtNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum.setText("0");
        txtNum.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        cmdOrder.setBackground(new java.awt.Color(0, 255, 255));
        cmdOrder.setText("THÊM");
        cmdOrder.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(cmdOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValue, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinusActionPerformed
        int num = Integer.parseInt(txtNum.getText());
        if (num > 0) {
            txtNum.setText((num - 1) + "");
        } else {
            txtNum.setText("0");
        }
    }//GEN-LAST:event_cmdMinusActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        int num = Integer.parseInt(txtNum.getText());
        txtNum.setText((num + 1) + "");
    }//GEN-LAST:event_cmdAddActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20,20);

        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Customer.View.Swing.ButtonOutLine cmdAdd;
    private Customer.View.Swing.ButtonOutLine cmdMinus;
    private Customer.View.Swing.Button cmdOrder;
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    private Customer.View.Swing.MyTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
