/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclel_IT13044664;

import gui.DatePicker;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import mysql_conn.Mysqlconn;

/**
 *
 * @author Homepc
 */
public class Addvehicle extends javax.swing.JFrame {

    /**
     * Creates new form Addvechil
     */
    String vehiclno;
    int model;
    String vehicletype;
    String query;
    String in_ex_date,in_date;
    boolean vehicleState = false;
    public Addvehicle() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Design1.png")));
        this.setLocationRelativeTo(null);
        
    }
public static boolean isvehiclenumber(String vehiclenumber){  
boolean isValid = false;  
String expression = "^[A-Z]{2,3}+[-](\\d{4})$"; 
String expression1="^(\\d{3}+[-])(\\d{4})$";
CharSequence inputStr = vehiclenumber;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
Pattern pattern1 = Pattern.compile(expression1);
if(matcher.matches()){  
isValid = true;  
}
else{
    matcher = pattern1.matcher(inputStr);
    if(matcher.matches())
    {
        isValid = true;
    }
   
}
return isValid;  
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Vehicle");
        setBackground(new java.awt.Color(135, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(135, 204, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 139, 98, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Vehicle No");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 141, 74, 25));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Add Vehicle Details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 62, 200, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle Type");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 190, -1, 25));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VAN", "Truck" , "lorry", "Heary motor lorry" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 191, 98, 25));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Vehicle Model ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 240, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 234, 98, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0007_Tick.png"))); // NOI18N
        jButton1.setText("ADD ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 414, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Insurance Date  ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 285, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Insurance Expected Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 342, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 279, 98, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 336, 98, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0038_Calender.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 270, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0038_Calender.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 327, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0050_Clear.png"))); // NOI18N
        jButton2.setText("clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 414, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Designer2.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        vehiclno = jTextField1.getText();
        vehicletype =jComboBox1.getSelectedItem().toString();
        in_date=jTextField3.getText();
        in_ex_date=jTextField4.getText();
        String mod=jTextField2.getText();

        if(vehiclno.length()==0||vehicletype.length()==0||in_date.length()==0||in_ex_date.length()==0||mod.length()==0)
        {
            JOptionPane.showMessageDialog(null,"Enter the text Fileds ");
       System.out.println("Enter the text Fileds");
        }    
        else{
                vehicleState=isvehiclenumber(vehiclno);
                if(vehicleState==true)
                {
                    try {
                    model = Integer.parseInt(jTextField2.getText());
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, " Enter valid Number for vehicle model. ", " Invalid Inputs", 2);
                    return;
                }
                    String string =jTextField3.getText();
                    String[] parts = string.split("-");
                    String part1 = parts[0];
                    String part2 = parts[1]; 


                    Calendar cal=new GregorianCalendar();
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
                    month=month+1;
                    String calmon=0+Integer.toString(month);

                    int ye=Integer.parseInt(part1);
                            if(ye<=year)
                            {
                                String calyer=Integer.toString(year)+calmon;
                                int chmonth=Integer.parseInt(calyer);
                                String uschmonth=part1+part2;
                                int usdate=Integer.parseInt(uschmonth);
                                if(usdate<=chmonth)
                                {
                                    String string1 =jTextField4.getText();
                                    String[] parts1 = string1.split("-");
                                    String part10 = parts1[0];
                                    int us_in_ex_date=Integer.parseInt(part10);
                                    if(us_in_ex_date>year)
                                    {
                                        String checkuserQuery = "select COUNT(*) from vehicle where vehicle_No='" +vehiclno+ "';";

                                        boolean  chvehiclenumberState = new Mysqlconn().validatevehiclenumber(checkuserQuery);
                                        if(chvehiclenumberState)
                                        {
                                        JOptionPane.showMessageDialog(null, " This vehicle Number Is Already In The System ", "  Failed", 0);
                                        }
                                        else{
                                    Mysqlconn sql=new Mysqlconn();
                                    query="insert into vehicle values(default,'"+vehiclno+"','"+vehicletype+"',"+model+",1,'"+in_date+"','"+in_ex_date+"');";
                                    sql.addvehicle(query);
                                    JOptionPane.showMessageDialog(null,"NEW Vehicle added to system ");
                                    System.out.println("New Vechil added To system");
                                    System.out.println(vehicletype);
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, " Invalid Insurance Expected Date Is Entered. ", " Invalid Inputs", 2);
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, " Invalid Month Is Entered. ", " Invalid Inputs", 2);
                                return;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, " Invalid Date Is Entered. ", " Invalid Inputs", 2);
                                return;
                            }
                }
                else{
                     JOptionPane.showMessageDialog(null, " Invalid Vehicle Number Is Entered."
                             + " Use Vehicle Number Like This BBC-1239,BB-1236 or 596-1569 ", " Invalid Inputs", 2);
                     return;
                }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(" ");
        jTextField2.setText(" ");
        jTextField3.setText(" ");
        jTextField4.setText(" ");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        DatePicker datePicker = new DatePicker(this);
        jTextField4.setText(datePicker.setPickedDate());
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        DatePicker datePicker = new DatePicker(this);
        jTextField3.setText(datePicker.setPickedDate());
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Manuvehicle().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Addvehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addvehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addvehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addvehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addvehicle().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
