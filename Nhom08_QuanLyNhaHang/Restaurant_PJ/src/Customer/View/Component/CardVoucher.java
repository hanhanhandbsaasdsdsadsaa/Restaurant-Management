package Customer.View.Component;

import Customer.Model.ModelKhachHang;
import Customer.Model.ModelHoaDon;
import Customer.Model.ModelVoucher;
import Customer.View.Dialog.MS_Confirm;
import Customer.View.Dialog.MS_Warning;
import Customer.View.Main.Main_Customer_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class CardVoucher extends javax.swing.JPanel {

    private final ModelVoucher data;
    private final ModelKhachHang customer;
    private final ModelHoaDon hoadon;
    private MS_Warning warning;
    private MS_Confirm exchange;

    public ModelVoucher getData() {
        return data;
    }

    public CardVoucher(ModelVoucher data, ModelKhachHang customer, ModelHoaDon hoadon) {
        this.data = data;
        this.customer = customer;
        this.hoadon = hoadon;
        initComponents();
        init();
        cmdExchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warning = new MS_Warning(Main_Customer_Frame.getFrames()[0], true);
                exchange = new MS_Confirm(Main_Customer_Frame.getFrames()[0], true);
                int Vpoint = data.getPoint();
                if (hoadon == null) {
                    warning.WarningExchange();
                } else {
                    if (customer.getPoints() < Vpoint) {
                        warning.WarningExchange(Vpoint - customer.getPoints());
                    } else {
                        exchange.ConfirmExchange(hoadon, data, Vpoint, customer);
                    }
                }
            }
        });
        setOpaque(false);
    }

    public void init() {

        setPreferredSize(new Dimension(300, 325));
        ibDescription.setText(data.getDescription());
        lbQuantity.setText("Số lượng: " + data.getQuantity());
        lbPoint.setText(data.getPoint() + " xu");
        switch (data.getPercent()) {
            case 20: {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/20off.jpg")));
                break;
            }
            case 30: {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/30off.jpg")));
                break;
            }
            case 50: {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/50off.jpg")));
                break;
            }
            case 60: {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/60off.jpg")));
                break;
            }
            case 100: {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/100off.jpg")));
                break;
            }
            default: {
                break;
            }
        }
        if (data.getQuantity() == 0) {
            cmdExchange.setText("ĐÃ HẾT");
            cmdExchange.setBackground(Color.decode("#232526"));
            cmdExchange.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new Customer.View.Swing.PanelRound();
        img = new javax.swing.JLabel();
        ibDescription = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JLabel();
        lbPoint = new javax.swing.JLabel();
        cmdExchange = new Customer.View.Swing.Button();

        img.setBackground(new java.awt.Color(233, 228, 240));
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Voucher/20off.jpg"))); // NOI18N
        img.setOpaque(true);

        ibDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ibDescription.setForeground(new java.awt.Color(108, 91, 123));
        ibDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ibDescription.setText("Title");

        lbQuantity.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbQuantity.setForeground(new java.awt.Color(108, 91, 123));
        lbQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuantity.setText("Quantity");

        lbPoint.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbPoint.setForeground(new java.awt.Color(108, 91, 123));
        lbPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPoint.setText("Point");

        cmdExchange.setBackground(new java.awt.Color(0, 255, 255));
        cmdExchange.setText("Đổi Voucher");
        cmdExchange.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(cmdExchange, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ibDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ibDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuantity)
                .addGap(12, 12, 12)
                .addComponent(lbPoint)
                .addGap(13, 13, 13)
                .addComponent(cmdExchange, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Customer.View.Swing.Button cmdExchange;
    private javax.swing.JLabel ibDescription;
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbPoint;
    private javax.swing.JLabel lbQuantity;
    private Customer.View.Swing.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
