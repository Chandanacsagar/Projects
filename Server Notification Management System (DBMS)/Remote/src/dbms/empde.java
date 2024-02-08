/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * empde.java
 *
 * Created on Dec 27, 2022, 8:58:36 AM
 */
package dbms;
/*import  java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;*/

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.ObjectInputFilter.Status;
import java.lang.System.Logger;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class empde extends javax.swing.JFrame {
    Connection con;
    PreparedStatement pst;
    /** Creates new form empde */
    
    String Type_Emp;
    //QueryProcessor qp;
    public empde() {
        initComponents();
         Dimension sz=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(sz.width,sz.height);
        
        //Connection();
        Connect();
        table_update();
        Orgid();
        Sid();
        groupradio();
             jPanel2.setVisible(false);
        
    }
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "oracle");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(orgde.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(orgde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Orgid(){
        try {
            
            pst = con.prepareStatement("select Org_ID from organization ");
             ResultSet rs=pst.executeQuery();
             
             rs=pst.executeQuery();
             
             while(rs.next()){

                 int Org_ID=rs.getInt("Org_ID");
                 e2.addItem(Org_ID);
             }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e);
        }
       
    }
    public void Sid(){
        try {
            pst = con.prepareStatement("select SID from server");
             ResultSet rs=pst.executeQuery();
             //e7.removeAllItems();
             rs=pst.executeQuery();
             
             while(rs.next()){
                 //e7.addItem(new SidItem (rs.getInt(2),rs.getInt(1)));
                 int SID=rs.getInt("SID");
                 e7.addItem(SID);
             }
            
        } catch (Exception e) {
           // java.util.logging.Logger.getLogger(empde.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,e);
        }
       
    }
    public void groupradio()
    {
        buttonGroup1.add(admin);
        buttonGroup1.add(employ);
    }
    public void table_update()
    {
        int cc;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","oracle");
            pst=con.prepareStatement("SELECT * FROM employee");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            cc=rsmd.getColumnCount();
            DefaultTableModel DFT=(DefaultTableModel) empde.getModel();
            DFT.setRowCount(0);
            while (rs.next()) 
            {
                Vector v2=new Vector();
                for(int i=1;i<=cc;i++)
                {
                    v2.add(rs.getString("Emp_ID"));
                    v2.add(rs.getString("Org_ID"));
                    v2.add(rs.getString("FName"));
                    v2.add(rs.getString("LName"));
                    v2.add(rs.getString("Email"));
                    v2.add(rs.getString("Phn_No"));
                    v2.add(rs.getString("Type_Emp"));
                    v2.add(rs.getString("SID"));
                    v2.add(rs.getString("Status"));
                    v2.add(rs.getString("password"));
                }
                DFT.addRow(v2);
            }
        }
        catch(Exception e) {
           
         }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // </editor-fold>
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        e1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        e2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        e3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        e4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        e5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        e6 = new javax.swing.JTextField();
        type = new javax.swing.JLabel();
        admin = new javax.swing.JRadioButton();
        employ = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        e7 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        e8 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        e9 = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        view = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        empde = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        jLabel2.setText("EMPLOYEE DETAILS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 10, 500, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Emp_ID :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 70, 30);

        e1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.add(e1);
        e1.setBounds(100, 70, 200, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Org_ID :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 110, 70, 20);

        e2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        e2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e2ActionPerformed(evt);
            }
        });
        jPanel1.add(e2);
        e2.setBounds(100, 104, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("FName :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 140, 60, 30);

        e3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        e3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e3ActionPerformed(evt);
            }
        });
        jPanel1.add(e3);
        e3.setBounds(100, 140, 200, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("LName :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 180, 70, 30);

        e4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        e4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e4ActionPerformed(evt);
            }
        });
        jPanel1.add(e4);
        e4.setBounds(100, 180, 200, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Email  :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 220, 70, 30);

        e5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        e5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e5ActionPerformed(evt);
            }
        });
        jPanel1.add(e5);
        e5.setBounds(100, 220, 200, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Phn_no:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 270, 60, 20);

        e6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.add(e6);
        e6.setBounds(100, 270, 200, 30);

        type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        type.setText("Type of emp:");
        jPanel1.add(type);
        type.setBounds(0, 310, 100, 16);

        admin.setBackground(new java.awt.Color(0, 0, 0));
        admin.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("Admin");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        jPanel1.add(admin);
        admin.setBounds(120, 310, 60, 21);

        employ.setBackground(new java.awt.Color(0, 0, 0));
        employ.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        employ.setForeground(new java.awt.Color(255, 255, 255));
        employ.setText("Employee");
        employ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employActionPerformed(evt);
            }
        });
        jPanel1.add(employ);
        employ.setBounds(210, 310, 80, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("SID :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 340, 50, 30);

        e7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        e7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e7ActionPerformed(evt);
            }
        });
        jPanel1.add(e7);
        e7.setBounds(100, 340, 200, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Status :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 380, 60, 30);

        e8.setEditable(true);
        e8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Inactive" }));
        e8.setSelectedIndex(-1);
        e8.setToolTipText("");
        e8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        e8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e8ActionPerformed(evt);
            }
        });
        jPanel1.add(e8);
        e8.setBounds(100, 380, 200, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Password:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 420, 80, 30);

        e9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.add(e9);
        e9.setBounds(100, 420, 200, 30);

        logout.setBackground(new java.awt.Color(0, 0, 0));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(0, 204, 204));
        logout.setText("LOGOUT");
        logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255)));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(630, 490, 190, 30);

        edit.setBackground(new java.awt.Color(0, 0, 0));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(0, 204, 204));
        edit.setText("EDIT");
        edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255)));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit);
        edit.setBounds(60, 560, 110, 30);

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 204, 204));
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255)));
        delete.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                deleteAncestorResized(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(200, 500, 110, 30);

        insert.setBackground(new java.awt.Color(0, 0, 0));
        insert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insert.setForeground(new java.awt.Color(0, 204, 204));
        insert.setText("INSERT");
        insert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255)));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel1.add(insert);
        insert.setBounds(60, 500, 110, 30);

        view.setBackground(new java.awt.Color(0, 0, 0));
        view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view.setForeground(new java.awt.Color(0, 204, 204));
        view.setText("VIEW");
        view.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255)));
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel1.add(view);
        view.setBounds(200, 560, 110, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 102));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        empde.setBackground(new java.awt.Color(0, 0, 0));
        empde.setForeground(new java.awt.Color(0, 204, 204));
        empde.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Emp_ID", "Org_ID", "FName", "LName", "Email", "Phn_No", "Type_Emp", "SID", "Status", "Password"
            }
        ));
        empde.setGridColor(new java.awt.Color(204, 204, 204));
        empde.setSelectionForeground(new java.awt.Color(255, 255, 255));
        empde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empdeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(empde);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(360, 60, 880, 420);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emlolo.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-250, 0, 1550, 830);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void e8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e8ActionPerformed
//DELETE BUTTON
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        try {
            DefaultTableModel DFT=(DefaultTableModel) empde.getModel();
            int selectedIndex=empde.getSelectedRow();
            int Emp_ID=Integer.parseInt(DFT.getValueAt(selectedIndex,1).toString());

            pst=con.prepareStatement("delete from employee where Emp_ID=?");
           pst.setInt(1,Integer.parseInt(e1.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Deleted");
            table_update();
            
            e1.setText("");
            e2.setSelectedItem("");
            e3.setText("");
            e4.setText("");
            e5.setText("");
            e6.setText("");
            e7.setSelectedItem("");
            e8.setSelectedItem("");
            e9.setText("");
            e1.requestFocus();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_deleteActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        
        dispose();
       orgde a=new orgde();
       a.setVisible(true);
       logout.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed
//update buton
    
    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        jPanel2.setVisible(true);
        try {
            String Org_ID,FName,LName,Email,Phn_No,SID,Status,password;
            
            
            Org_ID=e2.getSelectedItem().toString();
            FName=e3.getText();
            LName=e4.getText();
            Email=e5.getText();
            Phn_No=e6.getText();
            SID=e7.getSelectedItem().toString();
            Status=e8.getSelectedItem().toString();
            password=e9.getText();
            if(Type_Emp.equals("Admin"))
            {
                pst=con.prepareStatement("update `employee` set Type_Emp='Employee' where Org_ID='"+Org_ID+"'");
                pst.executeUpdate();
            }
            pst=con.prepareStatement("insert into `employee` (Emp_ID,Org_ID,FName,LName,Email,Phn_no,Type_Emp,SID,Status,password)values (?,?,?,?,?,?,?,?,?,?)");
            
            
           pst.setInt(1, Integer.parseInt(e1.getText()));
            pst.setString(2,Org_ID);
            pst.setString(3,FName);
            pst.setString(4,LName);
            pst.setString(5,Email);
            pst.setString(6,Phn_No);
            pst.setString(7,Type_Emp);
            pst.setString(8,SID);
            pst.setString(9,Status);
            pst.setString(10,password);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Saved");
          table_update();
            
          
            e2.setSelectedItem("");
            e3.setText("");
            e4.setText("");
            e5.setText("");
            e6.setText("");
            if(admin.isSelected())
            {
                Type_Emp="Admin";
            }
            if(employ.isSelected())
            {
                Type_Emp="Employee";
            }
            
            e7.setSelectedItem("");        
            e8.setSelectedItem("");
            e9.setText("");
            e1.requestFocus();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }

    }//GEN-LAST:event_insertActionPerformed

   
    private void empdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empdeMouseClicked
        // TODO add your handling code here:
        DefaultTableModel DFT=(DefaultTableModel) empde.getModel();
        int selectedIndex=empde.getSelectedRow();
        
        String Emp_ID=DFT.getValueAt(selectedIndex,0).toString();
       String  Org_ID=DFT.getValueAt(selectedIndex,1).toString();
       System.out.println(Org_ID);
       String  FName=DFT.getValueAt(selectedIndex,2).toString();
       String  LName=DFT.getValueAt(selectedIndex,3).toString();
       String  Email=DFT.getValueAt(selectedIndex,4).toString();
       String  Phn_no=DFT.getValueAt(selectedIndex,5).toString();
        String Type_Emp=DFT.getValueAt(selectedIndex,6).toString();
        if(!Type_Emp.equals("Employee"))
        {
            admin.setSelected(true);
        }
        else
        {
            employ.setSelected(true);
        }
        //System.out.println(Type_Emp);
       String  SID=DFT.getValueAt(selectedIndex,7).toString();
       String Status= DFT.getValueAt(selectedIndex,8).toString();
       String  password=DFT.getValueAt(selectedIndex,9).toString();
        
       e1.setText(Emp_ID);
       for(int i=0;i<e2.getItemCount();i++)
        {
            //System.out.println(e2.getItemAt(i)+","+Org_ID);
            if(e2.getItemAt(i).toString().equals(Org_ID))
            {
                e2.setSelectedIndex(i);
                break;
            }
        }
       
       e3.setText(FName);
       e4.setText(LName);
       e5.setText(Email);
       e6.setText(Phn_no);
       for(int i=0;i<e7.getItemCount();i++)
        {
            //System.out.println(e7.getItemAt(i)+","+SID);
            if(e7.getItemAt(i).toString().equals(SID))
            {
                e7.setSelectedIndex(i);
                break;
            }
        }
       
       e8.setSelectedItem(Status);
       e9.setText(password);
    }//GEN-LAST:event_empdeMouseClicked

    private void deleteAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_deleteAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteAncestorResized

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
       
        try {
            String Org_ID ,FName,LName,Email,Phn_no,Type_Emp = null,SID ,Status ,password ;
  
            int row=empde.getSelectedRow();
            String value=(empde.getModel().getValueAt(row,0).toString());
           String query="update `employee` set Org_ID=?,FName=?,LName=?,Email=?,Phn_no=?,Type_Emp=?,SID=?,Status=?,password=? where Emp_ID=?";
            pst=con.prepareStatement(query);
            
            Org_ID=e2.getSelectedItem().toString();
            FName=e3.getText();
            LName=e4.getText();
            Email=e5.getText();
            Phn_no=e6.getText();
            SID=e7.getSelectedItem().toString();
            Status=e8.getSelectedItem().toString();
            password=e9.getText();
            
      
            pst=con.prepareStatement("update `employee` set Org_ID=?,FName=?,LName=?,Email=?,Phn_no=?,Type_Emp=?,SID=?,Status=?,password=? where Emp_ID=?");
             
            pst.setInt(10, Integer.parseInt(e1.getText()));
            pst.setString(1, Org_ID);
            pst.setString(2,FName);
            pst.setString(3,LName);
            pst.setString(4,Email);
            pst.setString(5,Phn_no);
            if(admin.isSelected()){
                Type_Emp="Admin";
            }
            if(employ.isSelected()){
                Type_Emp="Employee";
            }
            
             if(Type_Emp.equals("Admin"))
            {
                PreparedStatement pst1=con.prepareStatement("update `employee` set Type_Emp='Employee' where Org_ID='"+Org_ID+"'");
                pst1.executeUpdate();
            }
            pst.setString(6,Type_Emp);
            pst.setString(7,SID);
            pst.setString(8,Status);
            pst.setString(9,password);
            pst.executeUpdate();

             table_update();
             JOptionPane.showMessageDialog(this,"Record Updated");
             e1.setText("");
             e2.setSelectedItem("");
             e3.setText("");
             e4.setText("");
             e5.setText("");
             e6.setText("");
             e7.setSelectedItem("");
             e8.setSelectedItem("");
             e9.setText("");
             e1.requestFocus();
             
           
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        } 
    
    }//GEN-LAST:event_editActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
         jPanel2.setVisible(true);
        table_update();      
    }//GEN-LAST:event_viewActionPerformed

    private void e7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e7ActionPerformed

    private void e5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e5ActionPerformed

    private void e4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e4ActionPerformed

    private void e3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e3ActionPerformed

    private void e2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e2ActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        // TODO add your handling code here:
        Type_Emp=admin.getText();
    }//GEN-LAST:event_adminActionPerformed

    private void employActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employActionPerformed
        // TODO add your handling code here:
        Type_Emp=employ.getText();
    }//GEN-LAST:event_employActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Connection con;
        //PreparedStatement pst;
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //catch(Exception e) {}

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
//java.util.Logging.Logger.getLogger(orgde.class .getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } catch (IllegalAccessException ex) {
//java.util.Logging.Logger.getLogger(orgde.class .getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } catch (InstantiationException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        empde obj1 = new empde();
        obj1.show();
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton admin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton delete;
    private javax.swing.JTextField e1;
    public static javax.swing.JComboBox e2;
    private javax.swing.JTextField e3;
    private javax.swing.JTextField e4;
    private javax.swing.JTextField e5;
    private javax.swing.JTextField e6;
    private javax.swing.JComboBox e7;
    private javax.swing.JComboBox e8;
    private javax.swing.JTextField e9;
    private javax.swing.JButton edit;
    private javax.swing.JTable empde;
    private javax.swing.JRadioButton employ;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JLabel type;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables

   // private void initComponents() {
        //throw new UnsupportedOperationException("Not supported yet."); 
 //Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  
                                                  

 //}
}