/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Create_User extends javax.swing.JInternalFrame {

   ConnectionBD cone,coneins,coneDoc,ConeCour;
   
    public Create_User() {
        initComponents();
        cone=new ConnectionBD();
        coneins = new ConnectionBD();
        coneDoc = new ConnectionBD();
        ConeCour = new ConnectionBD();
        Get_Id();
        Get_County();
        Role();
        Document_Type();
        State();
        lbl_Attendan.setVisible(false);
        cmb_Attendant.setVisible(false);
        lbl_Course.setVisible(false);
        cmb_Name_Course.setVisible(false);
        //lbl_Id_Country.setVisible(false);
        //lbl_Id_Depart.setVisible(false);
        
    }
    
    public void Get_Id (){
        
        try {
            ResultSet rs = cone.queryDB("SELECT max(ID_PERSON) FROM person");
            if (rs.next()) {

                lbl_Id_Person.setText((rs.getInt("max(ID_PERSON)")+1)+"");
               
            }
        
            
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Get_County(){
       
        ResultSet rs = cone.queryDB("SELECT * FROM country");
        
        try {
           
           while (rs.next()) {
                
                cmb_Name_Count.addItem(rs.getString("NAME_COUNTRY"));
 
                //Get_Departament();
                //
            }
            
                
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Get_Departament(){
        
        ConnectionBD cone2 = new ConnectionBD();
        cmb_Name_Depart.removeAllItems();
        String Id_contry = lbl_Id_Country.getText();
        ResultSet rs = cone2.queryDB("SELECT NAME_DEPARMENT FROM departament WHERE ID_COUNTRY=" + Id_contry);
        try {
            while (rs.next()) {
                
                cmb_Name_Depart.addItem(rs.getString("NAME_DEPARMENT"));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public void Get_City(){
        
        cmb_Name_City.removeAllItems();
        ConnectionBD cone7 = new ConnectionBD();
        String Id_Depart = lbl_Id_Depart.getText();
        ResultSet rs = cone7.queryDB("SELECT NAME_CITY FROM city WHERE ID_DEPARTAMENT=" + Id_Depart);
        try {
            while (rs.next()) {
                
                
                cmb_Name_City.addItem(rs.getString("NAME_CITY"));
               
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    public void Role(){
        
        ResultSet rs = cone.queryDB("SELECT * FROM  role");
        try {
            while (rs.next()) {                
                
                cmb_Rol_User.addItem(rs.getString("NAME_ROLE"));
                  
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Attendant(){
       
        ConnectionBD cone6 = new ConnectionBD();
        cmb_Attendant.removeAllItems();
        ResultSet rs = cone6.queryDB("SELECT NAME FROM person WHERE ID_ROLE= 4");
        try {
            while (rs.next()) {
                
                cmb_Attendant.addItem(rs.getString("NAME"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void State(){
        
        ConnectionBD coneState = new ConnectionBD();
        cmb_state_User.removeAllItems();
        ResultSet rs = coneState.queryDB("SELECT * FROM state");
        try {
            while (rs.next()) {                
                
                cmb_state_User.addItem(rs.getString("NAME_STATE"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Document_Type(){
        
        ResultSet rs = coneDoc.queryDB("SELECT * FROM type_document");
        try {
            while (rs.next()) {                
                
                cmb_Type_Docum.addItem(rs.getString("NAME_SHORT"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Course(){
        
        cmb_Name_Course.removeAllItems();
        ResultSet rs = ConeCour.queryDB("SELECT NAME_COURSES FROM courses");
        try {
            while (rs.next()) {                
                
                cmb_Name_Course.addItem(rs.getString("NAME_COURSES"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_Id_Person = new javax.swing.JLabel();
        txt_Name_person = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_Num_Document = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        cmb_Type_Docum = new javax.swing.JComboBox();
        lbl_Id_Docum = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cmb_Name_Count = new javax.swing.JComboBox();
        lbl_Id_Country = new javax.swing.JLabel();
        cmb_Name_Depart = new javax.swing.JComboBox();
        cmb_Name_City = new javax.swing.JComboBox();
        txt_Num_Phone = new javax.swing.JTextField();
        lbl_Attendan = new javax.swing.JLabel();
        cmb_Attendant = new javax.swing.JComboBox();
        lbl_Id_City = new javax.swing.JLabel();
        lbl_Id_Depart = new javax.swing.JLabel();
        jdc_Date_Birth = new com.toedter.calendar.JDateChooser();
        lbl_Course = new javax.swing.JLabel();
        cmb_Name_Course = new javax.swing.JComboBox();
        lbl_Id_Course = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txt_Name_User = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        cmb_Rol_User = new javax.swing.JComboBox();
        lbl_Cod_Role = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        cmb_state_User = new javax.swing.JComboBox();
        lbl_Id_State = new javax.swing.JLabel();
        btn_Create_User = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CREAR USUARIO");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(235, 235, 235));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel26.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 153));
        jLabel26.setText("Nombres    :");

        jLabel27.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 153));
        jLabel27.setText("ID persona :");

        lbl_Id_Person.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        lbl_Id_Person.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Id_Person.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txt_Name_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Name_personActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 153));
        jLabel35.setText("Numero Documento :");

        txt_Num_Document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Num_DocumentActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 153));
        jLabel44.setText("Tipo Documento :");

        cmb_Type_Docum.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Type_DocumItemStateChanged(evt);
            }
        });

        lbl_Id_Docum.setText("jLabel1");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbl_Id_Person, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 134, Short.MAX_VALUE))
                    .addComponent(txt_Name_person))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Num_Document)
                .addGap(12, 12, 12))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(cmb_Type_Docum, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Id_Docum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txt_Name_person, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_Id_Person, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(cmb_Type_Docum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_Docum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txt_Num_Document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(235, 235, 235));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel36.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 102, 153));
        jLabel36.setText("Departamento :");

        jLabel37.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 153));
        jLabel37.setText("Fecha de Nacimiento :");

        jLabel38.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 153));
        jLabel38.setText("Numero Telefonico :");

        jLabel39.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 102, 153));
        jLabel39.setText("Ciudad :");

        jLabel40.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 153));
        jLabel40.setText("Pais :");

        cmb_Name_Count.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Name_CountItemStateChanged(evt);
            }
        });
        cmb_Name_Count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Name_CountActionPerformed(evt);
            }
        });

        cmb_Name_Depart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Name_DepartItemStateChanged(evt);
            }
        });

        cmb_Name_City.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Name_CityItemStateChanged(evt);
            }
        });

        lbl_Attendan.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        lbl_Attendan.setForeground(new java.awt.Color(0, 102, 153));
        lbl_Attendan.setText("Seleccione Acudiente :");

        cmb_Attendant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_AttendantActionPerformed(evt);
            }
        });

        lbl_Id_City.setText("jLabel3");

        lbl_Course.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        lbl_Course.setForeground(new java.awt.Color(0, 102, 153));
        lbl_Course.setText("Seleccione Curso :");

        cmb_Name_Course.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Name_CourseItemStateChanged(evt);
            }
        });

        lbl_Id_Course.setText("jLabel1");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Name_City, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Name_Count, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lbl_Id_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Name_Depart, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Id_Depart)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdc_Date_Birth, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Num_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_Course)
                                    .addComponent(lbl_Attendan))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_Attendant, 0, 131, Short.MAX_VALUE)
                                    .addComponent(cmb_Name_Course, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_Id_Course))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lbl_Id_City)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_Id_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdc_Date_Birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(cmb_Name_Count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_Num_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb_Name_Depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_Id_Depart))
                            .addComponent(jLabel36)
                            .addComponent(jLabel38))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(cmb_Name_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Attendan)
                    .addComponent(cmb_Attendant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Id_City)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_Course)
                        .addComponent(cmb_Name_Course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Id_Course)))
                .addGap(25, 25, 25))
        );

        jPanel8.setBackground(new java.awt.Color(235, 235, 235));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel28.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 153));
        jLabel28.setText("Ususario :");

        txt_Name_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Name_UserActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 153));
        jLabel41.setText("Contraseña :");

        txt_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 153));
        jLabel42.setText("Rol :");

        cmb_Rol_User.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Rol_UserItemStateChanged(evt);
            }
        });
        cmb_Rol_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Rol_UserActionPerformed(evt);
            }
        });

        lbl_Cod_Role.setText("jLabel1");

        jLabel43.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 102, 153));
        jLabel43.setText("Estado :");

        cmb_state_User.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_state_UserItemStateChanged(evt);
            }
        });
        cmb_state_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_state_UserActionPerformed(evt);
            }
        });

        lbl_Id_State.setText("jLabel1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel41))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Name_User)
                            .addComponent(txt_Password)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(cmb_Rol_User, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Cod_Role))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(cmb_state_User, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_State)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_Name_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(cmb_Rol_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Cod_Role))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(cmb_state_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_State))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btn_Create_User.setText("CREAR USUARIO");
        btn_Create_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Create_UserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(btn_Create_User)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btn_Create_User)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Name_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Name_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Name_UserActionPerformed

    private void txt_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordActionPerformed

    private void txt_Num_DocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Num_DocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Num_DocumentActionPerformed

    private void txt_Name_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Name_personActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Name_personActionPerformed

    private void cmb_Rol_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Rol_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Rol_UserActionPerformed

    private void cmb_Name_CountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Name_CountActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cmb_Name_CountActionPerformed

    private void cmb_Name_CountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Name_CountItemStateChanged
        // TODO add your handling code here:
        
        ConnectionBD cone2 = new ConnectionBD();
        String Name_Country = cmb_Name_Count.getSelectedItem() + "";
        ResultSet rs = cone2.queryDB("SELECT ID_COUNTRY FROM country WHERE NAME_COUNTRY='" + Name_Country + "'");
        
            try {
                if (rs.next()) {
                    lbl_Id_Country.setText(rs.getString("ID_COUNTRY"));
                }
        } catch (SQLException ex) {
                Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Get_Departament();
    }//GEN-LAST:event_cmb_Name_CountItemStateChanged

    private void cmb_Rol_UserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Rol_UserItemStateChanged
        // TODO add your handling code here:
        
      ConnectionBD cone3 = new ConnectionBD(); 
      String Name_Role = cmb_Rol_User.getSelectedItem() + "";
      String Id_Role = lbl_Cod_Role.getText();
      
      if (Name_Role.equals("STUDENT")) {
                        
                        lbl_Attendan.setVisible(true);
                        cmb_Attendant.setVisible(true);
                        lbl_Course.setVisible(true);
                        cmb_Name_Course.setVisible(true);
        }else{
          
                    lbl_Attendan.setVisible(false);
                    cmb_Attendant.setVisible(false);
                    lbl_Course.setVisible(false);
                    cmb_Name_Course.setVisible(false);
      }
        ResultSet rs = cone3.queryDB("SELECT ID_ROLE FROM role WHERE NAME_ROLE='" + Name_Role + "'");
        
            try {
                if (rs.next()) {
                    lbl_Cod_Role.setText(rs.getString("ID_ROLE"));
                    
                }
        } catch (SQLException ex) {
                Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Attendant();
        Course();
    }//GEN-LAST:event_cmb_Rol_UserItemStateChanged

    private void cmb_Name_DepartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Name_DepartItemStateChanged
        // TODO add your handling code here:
        ConnectionBD cone4 = new ConnectionBD();
        String Name_Departament = cmb_Name_Depart.getSelectedItem() + "";
        ResultSet rs = cone4.queryDB("SELECT ID_DEPARTAMENT FROM departament WHERE NAME_DEPARMENT='" + Name_Departament+ "'");
        
            try {
                if (rs.next()) {
                    lbl_Id_Depart.setText(rs.getString("ID_DEPARTAMENT"));
                }
        } catch (SQLException ex) {
                Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }  
       Get_City();    
       
    }//GEN-LAST:event_cmb_Name_DepartItemStateChanged

    private void cmb_AttendantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_AttendantActionPerformed
        // TODO add your handling code here:
        
         
         
    }//GEN-LAST:event_cmb_AttendantActionPerformed

    private void btn_Create_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Create_UserActionPerformed
        // TODO add your handling code here:
       
        String User = txt_Name_User.getText();
        String Pass = txt_Password.getText();
        String Role = lbl_Cod_Role.getText();
        String State = lbl_Id_State.getText();
        String Name = txt_Name_person.getText();
        String Id_Person = lbl_Id_Person.getText();
        String Num_Docum = txt_Num_Document.getText();  
        String Curr_City = lbl_Id_City.getText();
        String Num_Phone = txt_Num_Phone.getText();
        String Cod_Curse = lbl_Course.getText();
        String Id_Attendant = lbl_Attendan.getText();
        
        Date date=jdc_Date_Birth.getDate();
        
        String Date_Birth = (date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
        
        
        String Id_Docum = lbl_Id_Docum.getText();
        coneins.updateDB("INSERT INTO person VALUES(null," + Id_Docum +", " + Num_Docum + ", '" + Name +
         "', " + Curr_City + ", " + Num_Phone + "," + Role + ", '" + Date_Birth + "')");
        
        ConnectionBD coneuser = new ConnectionBD();
        
        coneuser.updateDB("INSERT INTO users VALUES (null," + Id_Person + ", 'null' , 'null' ," + Role + "," + State + ")");

        
        ConnectionBD coneCourse = new ConnectionBD();
        coneCourse.updateDB("INSER INTO student VALUES (null," + Id_Person + "," + Cod_Curse + "," + Id_Attendant + ")");
        
              
    }//GEN-LAST:event_btn_Create_UserActionPerformed

    private void cmb_Name_CityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Name_CityItemStateChanged
        // TODO add your handling code here:
         ConnectionBD cone4 = new ConnectionBD();
        String Name_City = cmb_Name_City.getSelectedItem() + "";
        ResultSet rs = cone4.queryDB("SELECT ID_CITY FROM city WHERE NAME_CITY='" + Name_City+ "'");
        
            try {
                if (rs.next()) {
                    lbl_Id_City.setText(rs.getString("ID_CITY"));
                }
        } catch (SQLException ex) {
                Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_Name_CityItemStateChanged

    private void cmb_Type_DocumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Type_DocumItemStateChanged
        // TODO add your handling code here:
        ConnectionBD coneIdDoc = new ConnectionBD();
        String Shot_Name = cmb_Type_Docum.getSelectedItem() + "";
        ResultSet rs = coneIdDoc.queryDB("SELECT ID_TYPE_DOCUMENT FROM type_document WHERE NAME_SHORT='" + Shot_Name +"'");
        
        try {
            if (rs.next()) {
                lbl_Id_Docum.setText(rs.getString("ID_TYPE_DOCUMENT"));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_Type_DocumItemStateChanged

    private void cmb_state_UserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_state_UserItemStateChanged
        // TODO add your handling code here:
         
        ConnectionBD coneIdSta = new ConnectionBD();
        String Shot_Name = cmb_state_User.getSelectedItem() + "";
        ResultSet rs = coneIdSta.queryDB("SELECT ID_STATE FROM state WHERE NAME_STATE='" + Shot_Name +"'");
        
        try {
            if (rs.next()) {
                lbl_Id_State.setText(rs.getString("ID_STATE"));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_state_UserItemStateChanged

    private void cmb_state_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_state_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_state_UserActionPerformed

    private void cmb_Name_CourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Name_CourseItemStateChanged
        // TODO add your handling code here:
        ConnectionBD coneIdCour = new ConnectionBD();
        String Name_Courses = cmb_Name_Course.getSelectedItem() + "";
        ResultSet rs = coneIdCour.queryDB("SELECT ID_COURSES FROM courses WHERE NAME_COURSES='" + Name_Courses + "'");
        
        try {
            if (rs.next()) {
                lbl_Id_Course.setText(rs.getString("ID_COURSES"));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Create_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_Name_CourseItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Create_User;
    private javax.swing.JComboBox cmb_Attendant;
    private javax.swing.JComboBox cmb_Name_City;
    private javax.swing.JComboBox cmb_Name_Count;
    private javax.swing.JComboBox cmb_Name_Course;
    private javax.swing.JComboBox cmb_Name_Depart;
    private javax.swing.JComboBox cmb_Rol_User;
    private javax.swing.JComboBox cmb_Type_Docum;
    private javax.swing.JComboBox cmb_state_User;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private com.toedter.calendar.JDateChooser jdc_Date_Birth;
    private javax.swing.JLabel lbl_Attendan;
    private javax.swing.JLabel lbl_Cod_Role;
    private javax.swing.JLabel lbl_Course;
    private javax.swing.JLabel lbl_Id_City;
    private javax.swing.JLabel lbl_Id_Country;
    private javax.swing.JLabel lbl_Id_Course;
    private javax.swing.JLabel lbl_Id_Depart;
    private javax.swing.JLabel lbl_Id_Docum;
    public javax.swing.JLabel lbl_Id_Person;
    private javax.swing.JLabel lbl_Id_State;
    private javax.swing.JTextField txt_Name_User;
    private javax.swing.JTextField txt_Name_person;
    private javax.swing.JTextField txt_Num_Document;
    private javax.swing.JTextField txt_Num_Phone;
    private javax.swing.JTextField txt_Password;
    // End of variables declaration//GEN-END:variables
}
