/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclel_IT13044664;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import mysql_conn.Mysqlconn;

/**
 *
 * @author Krishanth
 */
public class DriverDetails extends javax.swing.JFrame {

    /**
     * Creates new form DriverDetails
     */
    String name;
    String address;
    int age;
    String NIC;
    int phonenumber;
    String DLN;
    String sqlquery;
    String searchkey;
    
    private boolean chNIC = false;
    private boolean chphonenumber = false;
    private boolean dln = false;
    
    
    public DriverDetails() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Design1.png")));
        buttonDisable();
        loadTable();
    }
public void buttonDisable()
{
    updateDrives.setEnabled(false);
    jButton4.setEnabled(false);
}

public void searchbutton()
{
    String key=jTextField1.getText();
 if(key.length()!=0) 
 {
    if(searchkey==null)
    {
        JOptionPane.showMessageDialog(null, "Select the NIC,Name or PhoneNumber To Search");
        return;
    }
    else
    {
        String selectionQuery  = "";
        if(searchkey=="name")
        {
             selectionQuery += " DR_Name like '" + key + "%' ";
             
        }
        else if(searchkey=="nic")
        {
            selectionQuery += " NIC = '" + key + "' ";
        }
        else if(searchkey=="phonenumber")
         {
               selectionQuery += " phonenumber = " + key + " ";     
         }
        else
        {
            JOptionPane.showMessageDialog(null, "can't find ");
        }
       String searchQuery = "select DR_Name,DR_address,age,NIC,DLN,Phonenumber from drivers where " + selectionQuery + ";";
       Mysqlconn mysqlc=new Mysqlconn();
       ResultSet rs=mysqlc.getDataa(searchQuery);
       DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
       df.setRowCount(0);
       searchkey=null;
        try {
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(6));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                
                df.addRow(v);
                
                
                
            }   } catch (SQLException ex) {
            //Logger.getLogger(DriverDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }
 else{
     JOptionPane.showMessageDialog(null, "search key is Empty");
     return;
 }
}

public static boolean isNIC(String NIC){  
boolean isValid = false;  
  
/*Number: A numeric value will have following format: 
         ^[-+]?: Starts with an optional "+" or "-" sign. 
     [0-9]*: May have one or more digits. 
    \\.? : May contain an optional "." (decimal point) character. 
    [0-9]+$ : ends with numeric digit. 
*/  
  
//Initialize reg ex for numeric data.   
String expression = "^\\(?(\\d{9})\\)?+[Vv](\\d{0})$";   
CharSequence inputStr = NIC;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
if(matcher.matches()){  
isValid = true;  
}  
return isValid;  
}

public static boolean DrivingLicenceNumber(String DLN){  
boolean isValid = false;    
String expression = "^[B]?(\\d{7})$";  
CharSequence inputStr = DLN;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
if(matcher.matches()){  
isValid = true;  
}  
return isValid;  
}


public static boolean isPhoneNumberValid(String phoneNumber){  
boolean isValid = false;  
/* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn 
       Examples: Matches following phone numbers: 
         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890 
 
*/  
//Initialize reg ex for phone number.   
String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";  
CharSequence inputStr = phoneNumber;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
if(matcher.matches()){  
isValid = true;  
}  
return isValid;  
}


 private void loadTable() {
        try{
       Mysqlconn mysql=new Mysqlconn();
       ResultSet rs=mysql.getDataa("select DR_Name,DR_address,age,NIC,DLN,Phonenumber from drivers");
       DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
       df.setRowCount(0);
       
       while(rs.next()){
        Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(6));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                
                df.addRow(v);
       }
            } catch(Exception e){
        }
    }
private void filltheTextfields() {
            try{
                jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
                jTextPane2.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
                jTextField7.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
                jTextField9.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
                jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
                jTextField10.setText(jTable1.getValueAt(jTable1.getSelectedRow(),5).toString());
                       
            }
            catch(Exception e){}
    }

 private void vehicleloadTable() {
        try{
       Mysqlconn mysql=new Mysqlconn();
       ResultSet rs=mysql.getDataa("select DR_Name,NIC,DLN,vehicle_number from drivers");
       DefaultTableModel df=(DefaultTableModel)jTable2.getModel();
       df.setRowCount(0);
       
       
       
       
       while(rs.next()){
        Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                
                
                
                df.addRow(v);
       }
       //for vehicle number table
         rs=mysql.getDataa("select vehicle_No,ve_Type from vehicle");
       df=(DefaultTableModel)jTable3.getModel();
       df.setRowCount(0);
       
       while(rs.next()){
        Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                df.addRow(v);
       }
       
            } catch(Exception e){
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateDrives = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        AddDrivers = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Driving Licence Number");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Phone Number");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("NIC Number");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Age");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Address");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Name");

        jScrollPane2.setViewportView(jTextPane2);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Age", "PhoneNumber", "NIC", "Driving Licence Number"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Address");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Age");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("PhoneNumber");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Driving Licence Number");
        }

        updateDrives.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0007_Tick.png"))); // NOI18N
        updateDrives.setText("Update");
        updateDrives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDrivesActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0005_Delete.png"))); // NOI18N
        jButton4.setText("Remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0050_Clear.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Script MT Bold", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText(" Drivers Details");

        AddDrivers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0007_Tick.png"))); // NOI18N
        AddDrivers.setText("Add");
        AddDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDriversActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/d-icon.jpg.pagespeed.ce.bAKg1ubPuL.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(82, 82, 82)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374)
                .addComponent(jLabel11)
                .addGap(175, 175, 175)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(AddDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(updateDrives)
                .addGap(74, 74, 74)
                .addComponent(jButton4)
                .addGap(99, 99, 99)
                .addComponent(jButton5)
                .addGap(43, 43, 43)
                .addComponent(jLabel4))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9))
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateDrives, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Drive's Details", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "NIC", "Driving Licence Number", "Vehicle Number"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Driving Licence Number");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Vehicle Number");
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Vehicle Number", "Type"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Drive Name");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Drive Driving Licence Number");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Vehicle Number");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0007_Tick.png"))); // NOI18N
        jButton7.setText("Assining");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0005_Delete.png"))); // NOI18N
        jButton8.setText("Remove");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0050_Clear.png"))); // NOI18N
        jButton9.setText("Clear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel2)
                            .addComponent(jLabel16))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(227, 227, 227)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton7)
                .addGap(37, 37, 37)
                .addComponent(jButton8)
                .addGap(36, 36, 36)
                .addComponent(jButton9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assining To Vehicle", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Search");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 11, 66, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 14, 119, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_0030_Search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 11, 48, 28));

        jButton2.setText("NIC");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 59, 80, -1));

        jButton3.setText("Name");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 59, 80, -1));

        jButton6.setText("PhoneNumber");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 59, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/824_p.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Manuvehicle().setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void AddDriversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDriversActionPerformed
        // TODO add your handling code here:
        name=jTextField2.getText();
        address=jTextPane2.getText();
        
        NIC=jTextField8.getText();
        
        
        DLN=jTextField10.getText();
        
        if(name.length()!=0||address.length()!=0||NIC.length()!=0||DLN.length()!=0)
        {
            chNIC=isNIC(NIC);
            if(chNIC == true)
            {
                        try{
                            age=Integer.parseInt(jTextField7.getText());
                            phonenumber=Integer.parseInt(jTextField9.getText());
                            String ph_nu=jTextField9.getText();
                            chphonenumber=isPhoneNumberValid(ph_nu);
                                if(chphonenumber==true)
                                {
                                    dln=DrivingLicenceNumber(DLN);
                                    
                                   if(dln==true)
                                   {
                                  sqlquery="insert into drivers (DR_ID,DR_Name,DR_address,age,NIC,DLN,Phonenumber) values(default,'"+name+"','"+address+"',"+age+",'"+NIC+"','"+DLN+"',"+phonenumber+");";
                                  Mysqlconn sql=new Mysqlconn();
                                  sql.addDrivers(sqlquery);
                                  JOptionPane.showMessageDialog(null,"New Driver added to system ");
                                  //LoadTable();
                                  loadTable();
                                   }
                                   else{
                                      JOptionPane.showMessageDialog(null, " Driving Licence Number is invalide use B1757177",  "Invalide Driving Licence Number ", 2);
                                    return; 
                                   }

                                    //sql query 
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, " PhoneNumber is invalide use 0755421202",  "Invalide NIC", 2);
                                    return;
                                }
                        }
                        catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Enter the valide number for Age and PhoneNumber",  "NumberFormatException", 3);
                            return;

                        }
            //System.out.println("hello");
            }
            else 
            {
            JOptionPane.showMessageDialog(null, " NICNumber is invalide use 931258364V",  "Invalide NIC", 2);
            return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Fill in the details.",  "Incomplete Form", 2);
            return;
        }
        
        
    }//GEN-LAST:event_AddDriversActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("");
        jTextPane2.setText("");
        jTextField8.setText("");
        jTextField10.setText("");
        jTextField7.setText("");
        jTextField9.setText("");
        jTextField1.setText("");
        buttonDisable();
        loadTable();
        AddDrivers.setEnabled(true);
        jTextField8.setEditable(true);
        jButton3.setEnabled(true);
        jButton6.setEnabled(true);
        jButton2.setEnabled(true);
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void updateDrivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDrivesActionPerformed
        // TODO add your handling code here:
        name=jTextField2.getText();
        address=jTextPane2.getText();
        
        NIC=jTextField8.getText();
        
        
        DLN=jTextField10.getText();
        
        if(name.length()!=0||address.length()!=0||NIC.length()!=0||DLN.length()!=0)
        {
            chNIC=isNIC(NIC);
            if(chNIC == true)
            {
                        try{
                            age=Integer.parseInt(jTextField7.getText());
                            phonenumber=Integer.parseInt(jTextField9.getText());
                            String ph_nu=jTextField9.getText();
                            chphonenumber=isPhoneNumberValid(ph_nu);
                                if(chphonenumber==true)
                                {
                                    dln=DrivingLicenceNumber(DLN);
                                    
                                   if(dln==true)
                                   {
                                  sqlquery="update drivers set DR_Name='"+name+"',DR_address='"+address+"',age="+age+",NIC='"+NIC+"',DLN='"+DLN+"',Phonenumber="+phonenumber+" where NIC='"+NIC+"';";
                                  Mysqlconn sql=new Mysqlconn();
                                  sql.update(sqlquery);
                                  
                                  JOptionPane.showMessageDialog(null,"Update Successfull ");
                                  //LoadTable();
                                  loadTable();
                                   }
                                   else
                                   {
                                    JOptionPane.showMessageDialog(null, " Driving Licence Number is invalide use B1757177",  "Invalide Driving Licence Number ", 2);
                                    return; 
                                   }

                                    //sql query 
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, " PhoneNumber is invalide use 0755421202",  "Invalide NIC", 2);
                                    return;
                                }
                        }
                        catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Enter the valide number for Age and PhoneNumber",  "NumberFormatException", 3);
                            return;

                        }
            //System.out.println("hello");
            }
            else 
            {
            JOptionPane.showMessageDialog(null, " NICNumber is invalide use 931258364V",  "Invalide NIC", 2);
            return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Fill in the details.",  "Incomplete Form", 2);
            return;
        }
    }//GEN-LAST:event_updateDrivesActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
       // System.out.println(id);
        filltheTextfields();
        updateDrives.setEnabled(true);
        jButton4.setEnabled(true);
        AddDrivers.setEnabled(false);
        jTextField8.setEditable(false);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        NIC=jTextField8.getText();
        String removeQuery = "delete from drivers where NIC='"+NIC+"';";
        int p=JOptionPane.showConfirmDialog(null, "Do You really want to Remove ", "Remove the Drivers",JOptionPane.YES_NO_OPTION );
        if(p==0){
        new Mysqlconn().update(removeQuery);
        JOptionPane.showMessageDialog(null,"delete Successfull");
        loadTable();
        jButton5ActionPerformed(evt);  
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jButton2.setEnabled(false);
        jButton6.setEnabled(false);
        searchkey="name";
        //System.out.println(searchkey);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        searchkey="phonenumber";
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        searchkey="nic";
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        searchbutton();
        AddDrivers.setEnabled(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jTable2.getValueAt(jTable2.getSelectedRow(),0).toString();
        try{
                jTextField5.setText(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());
                jTextField3.setText(jTable2.getValueAt(jTable2.getSelectedRow(),2).toString());
                jTextField4.setText(jTable2.getValueAt(jTable2.getSelectedRow(),3).toString());
                       
            }
            catch(Exception e){}
        
            jTextField3.setEditable(false);
            jTextField4.setEditable(false);
            jTextField5.setEditable(false);
        
       
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        vehicleloadTable();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
      if(jTextField3.getText().trim().length()!=0||jTextField5.getText().trim().length()!=0)
      { 
         if(jTextField4.getText().trim().length()==0)
         {
        jTable3.getValueAt(jTable3.getSelectedRow(),0).toString();
        try{
                jTextField4.setText(jTable3.getValueAt(jTable3.getSelectedRow(),0).toString());
                 
            }
            catch(Exception e){}
        
         }
         else
         {
             
         }
      }
      else
      {
          JOptionPane.showMessageDialog(null,"First Select The Driver Details ");
      }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String ve_number=jTextField4.getText().trim();
        String D_nu=jTextField3.getText();
        
        if(ve_number.length()==0||jTextField3.getText().length()==0||jTextField5.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null,"Text Field Is Empty", "Empty",2);
        }
        else
        {
            String checkuserQuery = "select COUNT(*) from drivers where vehicle_number='" +ve_number + "';";

       boolean  vehiclenumberState = new Mysqlconn().validatevehiclenumber(checkuserQuery);
        if(vehiclenumberState)
        {
            JOptionPane.showMessageDialog(null, " This vehicle Assining For Another Driver  ", "  Failed", 0);
            jButton9ActionPerformed(evt);
            return;
            
        }
        else{
            sqlquery="update drivers set vehicle_number='"+ve_number+"'where DLN='"+D_nu+"';";
            Mysqlconn sql=new Mysqlconn();
            sql.update(sqlquery);
            JOptionPane.showMessageDialog(null,"Vehicle Assining to Driver is success", "Success",1);
            vehicleloadTable();
            jTextField3.setText(" ");
            jTextField4.setText(" ");
            jTextField5.setText(" ");
            jButton9ActionPerformed(evt);
        }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        if(jTextField4.getText().length()==0||jTextField3.getText().length()==0||jTextField5.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null,"Text Field Is Empty", "Empty",2);
        }
        else
        {
            sqlquery="update drivers set vehicle_number='' where DLN='"+jTextField3.getText()+"';";
            Mysqlconn sql=new Mysqlconn();
            sql.update(sqlquery);
            JOptionPane.showMessageDialog(null,"Vehicle Is Remove successfull", "Success",1);
            vehicleloadTable();
            jButton9ActionPerformed(evt);
            
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTextField3.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField3.setText(" ");
        jTextField4.setText(" ");
        jTextField5.setText(" ");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        jTextField2.setText("jp");
        jTextPane2.setText("colombo-10");
        jTextField8.setText("8918649327");
        jTextField10.setText("B59183486");
        jTextField7.setText("25");
        jTextField9.setText("0755849075");
        
        
        
        
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(DriverDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriverDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriverDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriverDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DriverDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDrivers;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton updateDrives;
    // End of variables declaration//GEN-END:variables
}
