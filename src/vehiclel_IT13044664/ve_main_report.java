/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclel_IT13044664;

import gui.DatePicker;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import mysql_conn.DB;
import mysql_conn.Mysqlconn;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Krishanth
 */
public class ve_main_report extends javax.swing.JFrame {

    /**
     * Creates new form ve_main_report
     */
    Connection conn=null;
    String vehicleNumber;
    String date;
    
    public ve_main_report() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillvehiclenumber();
          jTextField1.setVisible(false);
        jLabel7.setVisible(false);
        jButton2.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("Vehicle Maintenance Report");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 176, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle No");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 242, 74, 25));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {""}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 242, 102, 25));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Customize");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 299, 74, -1));

        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseReleased(evt);
            }
        });
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyReleased(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 299, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 355, 102, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0038_Calender.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 338, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 356, -1, -1));

        jButton1.setText("View Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 441, -1, -1));

        jButton2.setText("Print Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 441, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/824_p.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Manuvehicle().setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
        jTextField1.setVisible(true);
        jLabel7.setVisible(true);
        jButton2.setVisible(true);
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        DatePicker datePicker = new DatePicker(this);
        jTextField1.setText(datePicker.setPickedDate());
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jCheckBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyReleased
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jCheckBox1KeyReleased

    private void jCheckBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCheckBox1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       vehicleNumber= jComboBox1.getSelectedItem().toString();

       
       if(vehicleNumber.length()!=0 )
       {
       
             try{

           //String iReport="C:\\Users\\Krishanth\\Documents\\NetBeansProjects\\ITP_Project\\reports\\report20.jrxml";
            //String iReport="././reports/Book.jrxml";
                 
                 
                 JasperDesign jd=JRXmlLoader.load("././reports/vehicl_main_re.jrxml");
            String Sql="SELECT\n" +
"     vehiclemaintains.`ve_Maintains_ID` AS vehiclemaintains_ve_Maintains_ID,\n" +
"     vehiclemaintains.`Amount` AS vehiclemaintains_Amount,\n" +
"     vehiclemaintains.`Description` AS vehiclemaintains_Description,\n" +
"     vehiclemaintains.`Date` AS vehiclemaintains_Date,\n" +
"     vehiclemaintains.`vehiclenumber` AS vehiclemaintains_vehiclenumber\n" +
"FROM\n" +
"     `vehiclemaintains` where vehiclenumber='"+vehicleNumber+"'";
                 JRDesignQuery newqurey=new JRDesignQuery();
                 newqurey.setText(Sql);
                 jd.setQuery(newqurey);
                 JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp);
         
            
            
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
       }
       else{
           JOptionPane.showMessageDialog(null, "Select the Vehicle Number");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        conn=DB.connectionDB();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       vehicleNumber= jComboBox1.getSelectedItem().toString();
       date=jTextField1.getText();
       
       if(vehicleNumber.length()!=0 && date.length()!=0)
       {
       String[] parts = date.split("-");
       String sp="-";
       String usdate =parts[0]+sp+parts[1];
       
             try{

           //String iReport="C:\\Users\\Krishanth\\Documents\\NetBeansProjects\\ITP_Project\\reports\\report20.jrxml";
            //String iReport="././reports/Book.jrxml";
                 
                 
                 JasperDesign jd=JRXmlLoader.load("././reports/vehicl_main_re.jrxml");
            String Sql="SELECT\n" +
"     vehiclemaintains.`ve_Maintains_ID` AS vehiclemaintains_ve_Maintains_ID,\n" +
"     vehiclemaintains.`Amount` AS vehiclemaintains_Amount,\n" +
"     vehiclemaintains.`Description` AS vehiclemaintains_Description,\n" +
"     vehiclemaintains.`Date` AS vehiclemaintains_Date,\n" +
"     vehiclemaintains.`vehiclenumber` AS vehiclemaintains_vehiclenumber\n" +
"FROM\n" +
"     `vehiclemaintains` where vehiclenumber='"+vehicleNumber+"' and Date like '"+usdate+"%'";
                 JRDesignQuery newqurey=new JRDesignQuery();
                 newqurey.setText(Sql);
                 jd.setQuery(newqurey);
                 JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp);
            JasperPrintManager.printReport(jp, true);
            
            
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
       }
       else{
           JOptionPane.showMessageDialog(null, "Select the Vehicle Number and Date");
       }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ve_main_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ve_main_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ve_main_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ve_main_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ve_main_report().setVisible(true);
            }
        });
    }
            private void fillvehiclenumber() {
        Mysqlconn dao = new Mysqlconn();
        ArrayList CatList = dao.getvehiclenumber();

        Iterator i = CatList.iterator();

        while (i.hasNext()) {
            jComboBox1.addItem(i.next());
        }
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
