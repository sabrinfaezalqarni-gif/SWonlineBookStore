/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class shoppingCart extends javax.swing.JFrame {

    private java.util.ArrayList<Object[]> localCart;

 public shoppingCart(java.util.ArrayList<Object[]> passedCart) {
    initComponents();
    this.localCart = passedCart;
    displayCartItems(); 

    // انقل الكود إلى هنا ليعمل بشكل صحيح
    jTableCart.getModel().addTableModelListener(e -> {
    if (e.getType() == javax.swing.event.TableModelEvent.UPDATE && e.getColumn() == 4) {
        int row = e.getFirstRow();
        updateRowTotal(row); // استدعاء دالة تحديث السعر والمجموع
    }
});
}
  
    private void displayCartItems() {
    DefaultTableModel model = (DefaultTableModel) jTableCart.getModel();
    model.setRowCount(0); 
    for (Object[] row : localCart) {
        // إذا لم تكن هناك كمية محددة، اجعليها 1 افتراضياً
        if (row[4] == null || row[4].toString().isEmpty()) {
            row[4] = 1; 
        }
        model.addRow(row);
    }
    calculateTotal(); // حساب المجموع فور العرض
}
private void updateRowTotal(int row) {
    try {
        // جلب السعر من عمود 3 والكمية من عمود 4
        double price = Double.parseDouble(jTableCart.getValueAt(row, 3).toString());
        int qty = Integer.parseInt(jTableCart.getValueAt(row, 4).toString());
        
        // منع المستخدم من وضع رقم أقل من 1
        if (qty < 1) {
            qty = 1;
            jTableCart.setValueAt(1, row, 4);
        }

        double rowTotal = price * qty;
        jTableCart.setValueAt(rowTotal, row, 5); // وضع المجموع في عمود 5
        
        calculateTotal(); 
    } catch (NumberFormatException e) {
        // إذا أدخل المستخدم حروفاً بالخطأ، أرجعي الكمية لـ 1
        jTableCart.setValueAt(1, row, 4);
    }
}
private void calculateTotal() {
    double grandTotal = 0;
    for (int i = 0; i < jTableCart.getRowCount(); i++) {
        try {
            Object value = jTableCart.getValueAt(i, 4);
            if (value != null) {
                grandTotal += Double.parseDouble(value.toString());
            }
        } catch (Exception e) {
            // تجاهل أي قيم غير رقمية لضمان استقرار التطبيق
        }
    }
    // تأكدي أن لديكِ Label باسم lblGrandTotal في التصميم، أو غيري الاسم هنا لما هو موجود عندك
    // إذا لم يكن موجوداً، يمكنك إظهاره في رسالة أو تعريفه في initComponents
    if (lblGrandTotal != null) {
        lblGrandTotal.setText("Total: SAR " + grandTotal);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCart = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jpanal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblGrandTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 234, 216));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 24, 4), 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 550));

        jPanel2.setBackground(new java.awt.Color(101, 67, 30));
        jPanel2.setForeground(new java.awt.Color(101, 67, 30));
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(184, 27));

        jLabel4.setText(" ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(209, 182, 102));
        jLabel5.setText(" اِقْرَأْ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 234, 216));
        jLabel6.setText(" Shopping Cart");
        jLabel6.setToolTipText("");

        jButton6.setBackground(new java.awt.Color(143, 111, 51));
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jButton6))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(236, 221, 197));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Author", "Date", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCart);
        if (jTableCart.getColumnModel().getColumnCount() > 0) {
            jTableCart.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTableCart.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableCart.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTableCart.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableCart.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jButton2.setBackground(new java.awt.Color(101, 67, 30));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(245, 234, 216));
        jButton2.setText("Checkout →");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jpanal.setBackground(new java.awt.Color(236, 221, 197));
        jpanal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(188, 143, 95), 1, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 24, 4));
        jLabel3.setText("Selected Book: ");

        jButton5.setBackground(new java.awt.Color(165, 42, 42));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText(" Remove");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(165, 42, 42), 4, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(245, 234, 216));
        jButton1.setForeground(new java.awt.Color(165, 42, 42));
        jButton1.setText("Clear Cart");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(165, 42, 42)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblGrandTotal.setBackground(new java.awt.Color(172, 151, 97));
        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGrandTotal.setText("Total : 0 SAR");
        lblGrandTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpanalLayout = new javax.swing.GroupLayout(jpanal);
        jpanal.setLayout(jpanalLayout);
        jpanalLayout.setHorizontalGroup(
            jpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanalLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addGroup(jpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jpanalLayout.setVerticalGroup(
            jpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanalLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanalLayout.createSequentialGroup()
                        .addGroup(jpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanalLayout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanalLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanalLayout.createSequentialGroup()
                        .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int selectedRow = jTableCart.getSelectedRow();
    
    if (selectedRow != -1) {
        // 1. Remove from the underlying ArrayList (Encapsulation)
        localCart.remove(selectedRow);
        
        // 2. Update the table display
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTableCart.getModel();
        model.removeRow(selectedRow);
        
        // 3. Recalculate the grand total
        calculateTotal();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Item removed from cart.");
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select an item to remove.");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    localCart.clear();
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTableCart.getModel();
    model.setRowCount(0);
    calculateTotal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        java.sql.Connection conn = DatabaseConnection.connect(); // تأكدي من اسم كلاس الاتصال عندك
        java.sql.Statement st = conn.createStatement();

        for (int i = 0; i < jTableCart.getRowCount(); i++) {
            String bookID = jTableCart.getValueAt(i, 0).toString(); // عمود الـ ID
            int qtyBought = Integer.parseInt(jTableCart.getValueAt(i, 5).toString()); // عمود الكمية

            // أمر SQL لنقص الكمية من جدول الكتب (تأكدي من اسم الجدول والعمود)
            String query = "UPDATE books SET stock = stock - " + qtyBought + " WHERE id = '" + bookID + "'";
            st.executeUpdate(query);
        }
        
        JOptionPane.showMessageDialog(this, "Purchase successful! Database updated.");
        localCart.clear();
        displayCartItems();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error updating database: " + e.getMessage());
    }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

mainpage main = new mainpage();
main.setVisible(true);
this.dispose();
        
            }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
    // ... (كود الـ Look and Feel يظل كما هو)
    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // أضيفي قائمة فارغة هنا لإصلاح خطأ الـ Build
            new shoppingCart(new java.util.ArrayList<Object[]>()).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCart;
    private javax.swing.JPanel jpanal;
    private javax.swing.JLabel lblGrandTotal;
    // End of variables declaration//GEN-END:variables
}
