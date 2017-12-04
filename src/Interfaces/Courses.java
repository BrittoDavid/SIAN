
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robert Ramos :v .....;
 */
public class Courses extends javax.swing.JInternalFrame {
    DefaultListModel modeloLista1,modeloLista2;
    DefaultTableModel modelo;
    ConnectionDB cone;
    
    public Courses() {
        initComponents();
        cone= new ConnectionDB();
        ToShow("");
        
        ComboBox();
        ComboBoxDoc();
        ComboBoxStudent();
        JpAssign.setVisible(false);
        btnUpdate.setEnabled(false);
    }
    
    public void CargarId (){
    
       
        try {
            ResultSet rs = cone.queryDB("SELECT max(ID_COURSES) FROM courses");
            if (rs.next()) {

                JlbCourseCode.setText((rs.getInt("max(ID_COURSES)")+1)+"");
               
            }
        
            
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void ComboBox(){
                 cboCodeJourney.removeAllItems();
     ConnectionDB cone2=new ConnectionDB();
     ResultSet rs = cone2.queryDB("SELECT * FROM journeys");
     
        try {
            while (rs.next()) {
            
                cboCodeJourney.addItem(rs.getString("id_journey"));
            
            }
            
        } catch (Exception ex) {
         Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void ComboBoxDoc(){
                 cboCodeTeacher.removeAllItems();
                 
                 
      
                 
     ConnectionDB cone3=new ConnectionDB();
     ResultSet rs = cone3.queryDB("SELECT t.id_teacher,p.name FROM person as p INNER JOIN teacher as t ON p.id_person = t.id_person WHERE id_role = 2;");
     
        try {
            while (rs.next()) {
            
                cboCodeTeacher.addItem(rs.getString("id_teacher")+ " - "+ rs.getString("name"));
                
                
               
            }
            
            
            
        } catch (Exception ex) {
         Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void ComboBoxStudent(){
                 cboCodeJourney2.removeAllItems();
     ConnectionDB cone4=new ConnectionDB();
     ResultSet rs = cone4.queryDB("SELECT s.id_student,p.name FROM person as p INNER JOIN student as s ON p.id_person = s.id_person WHERE id_role = 3;");
     
        try {
            while (rs.next()) {
            
                cboCodeJourney2.addItem(rs.getString("id_student")+ " - "+ rs.getString("name"));
            
            }
            
        } catch (Exception ex) {
         Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void ToShow(String valor) {
         
        String titulos[] = {"CODIGO CURSO","NOMBRE DEL CURSO", "JORNADA", "DIRECTOR DE GRUPO","CODIGO ESTUDIANTE"};

        modelo = new DefaultTableModel(null,titulos);
        String fila[] = new String[5];

        try {
            

        ResultSet rs=cone.queryDB("SELECT * FROM courses WHERE CONCAT(ID_COURSES,' ',NAME_COURSES,' ',JOURNEYS) LIKE '%"+valor+"%'");
            while (rs.next()) {
             
                fila[0] = rs.getString("ID_COURSES");
                fila[1] = rs.getString("NAME_COURSES");
                fila[2] = rs.getString("JOURNEYS");
                fila[3] = rs.getString("ID_TEA_DIRECTOR");
                fila[4] = rs.getString("ID_STUD_LEADER"); 
                
                modelo.addRow(fila);
               
            }
        
             jTable1.setModel(modelo);
             CargarId();
             ComboBox();
             
        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }
  
        
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Remove = new javax.swing.JMenuItem();
        Modify = new javax.swing.JMenu();
        CreateCourses = new javax.swing.JMenuItem();
        AssignCourses = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtNameCourse = new javax.swing.JTextField();
        JlbCourseCode = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboCodeJourney = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        JlbNameJourney = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        JpAssign = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAssignar = new javax.swing.JButton();
        cboCodeTeacher = new javax.swing.JComboBox();
        cboCodeJourney2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        Remove.setText("Eliminar");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Remove);

        Modify.setText("Modificar");

        CreateCourses.setText("Creacion Curso");
        CreateCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateCoursesActionPerformed(evt);
            }
        });
        Modify.add(CreateCourses);

        AssignCourses.setText("Asignacion Curso");
        AssignCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignCoursesActionPerformed(evt);
            }
        });
        Modify.add(AssignCourses);

        jPopupMenu1.add(Modify);

        setClosable(true);
        setIconifiable(true);
        setTitle("Courses");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CURSOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, -1));

        jPanel6.setBackground(new java.awt.Color(235, 235, 235));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel17.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 153));
        jLabel17.setText("Nombre Curso");

        jLabel22.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("ID Curso");

        btnUpdate.setBackground(new java.awt.Color(0, 102, 153));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.setToolTipText("");
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 102, 153));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("AGREGAR");
        btnAdd.setToolTipText("");
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtNameCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameCourseKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("Codigo Jornada");

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CREAR CURSO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cboCodeJourney.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCodeJourneyItemStateChanged(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 153));
        jLabel21.setText("Nombre Jornada");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addGap(18, 18, 18))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addGap(23, 23, 23)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel22))
                                        .addGap(30, 30, 30)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JlbCourseCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNameCourse)
                                    .addComponent(cboCodeJourney, 0, 131, Short.MAX_VALUE)
                                    .addComponent(JlbNameJourney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlbCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(txtNameCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(cboCodeJourney, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel21))
                    .addComponent(JlbNameJourney, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 75, 360, 320));

        jPanel3.setBackground(new java.awt.Color(235, 235, 235));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel8.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Buscar Curso");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 370, 60));

        JpAssign.setBackground(new java.awt.Color(235, 235, 235));
        JpAssign.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel20.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("Codigo Docente");

        jLabel19.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 153));
        jLabel19.setText("Codigo Estudiante");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASIGNAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAssignar.setBackground(new java.awt.Color(0, 102, 153));
        btnAssignar.setForeground(new java.awt.Color(255, 255, 255));
        btnAssignar.setText("ASIGNAR");
        btnAssignar.setToolTipText("");
        btnAssignar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));
        btnAssignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignarActionPerformed(evt);
            }
        });

        cboCodeTeacher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCodeTeacherItemStateChanged(evt);
            }
        });

        cboCodeJourney2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCodeJourney2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout JpAssignLayout = new javax.swing.GroupLayout(JpAssign);
        JpAssign.setLayout(JpAssignLayout);
        JpAssignLayout.setHorizontalGroup(
            JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAssignLayout.createSequentialGroup()
                .addGroup(JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAssignLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpAssignLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(26, 26, 26)
                        .addGroup(JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboCodeTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCodeJourney2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpAssignLayout.createSequentialGroup()
                .addComponent(btnAssignar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        JpAssignLayout.setVerticalGroup(
            JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAssignLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cboCodeTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(JpAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cboCodeJourney2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAssignar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(JpAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 75, 370, 220));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 741, 125));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 20, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

         
        String NameCourse = txtNameCourse.getText();
        String CodeJourney =cboCodeJourney.getSelectedItem()+"";

        if (jTable1.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una fila");

            } else {
                int confirm = JOptionPane.showConfirmDialog(rootPane, "Desea modificar el registro?");
                if (confirm == 0) {
                    String CourseCode = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);
                    
         if (txtNameCourse.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Por favor, debe llenar este campo");
        }else{
                    
                    cone.updateDB("UPDATE courses SET NAME_COURSES='" + NameCourse + "', JOURNEYS='"+ CodeJourney +"' WHERE ID_COURSES=" + CourseCode);
                    

                    txtNameCourse.setText("");
                    btnAdd.setEnabled(true);
                    btnUpdate.setEnabled(false); 
                    ToShow("");
                    
              }
                }
            }  
        
       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (txtNameCourse.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Por favor, debe llenar este campo");
        }else{
        
        String CourseCode = JlbCourseCode.getText();
        String NameCourse = txtNameCourse.getText();
        String CodeJourney =cboCodeJourney.getSelectedItem()+"";
        
        cone.updateDB("INSERT INTO courses VALUES(" + CourseCode + ", " + null +", " + CodeJourney +", "+null+", '"+NameCourse+"')");
    
        txtNameCourse.setText("");
        
        ToShow("");
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameCourseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameCourseKeyTyped

        char c=evt.getKeyChar();

         if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47 ||
            (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64 ||
            (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96 ||
            (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
         {
        
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane,"Caracter no valido");
            
             
        }
    }//GEN-LAST:event_txtNameCourseKeyTyped

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
    
        ToShow(txtSearch.getText());
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cboCodeJourneyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCodeJourneyItemStateChanged
    
                 String cod = cboCodeJourney.getSelectedItem() + "";
         ResultSet rs = cone.queryDB("SELECT name_journey FROM journeys WHERE id_journey = " + cod);
         
         try{
             if(rs.next()){
                 JlbNameJourney.setText(rs.getString("name_journey"));
             }
         } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_cboCodeJourneyItemStateChanged

    private void btnAssignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignarActionPerformed
     
        String DatoTeacher = cboCodeTeacher.getSelectedItem() + "";
        String Dividido[]=DatoTeacher.split(" - ");
        String IdTeacher=Dividido[0];
        
        String StudentLeader = cboCodeJourney2.getSelectedItem() + "";
        String Dividido2[]=StudentLeader.split(" - ");
        String IdStudent=Dividido2[0];
        
        String CourseCode = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);
        
        
        cone.updateDB("UPDATE courses SET ID_TEA_DIRECTOR="+IdTeacher+", ID_STUD_LEADER=+"+IdStudent+" WHERE ID_COURSES="+CourseCode);
        
        JpAssign.setVisible(false);
        ToShow("");

       
    }//GEN-LAST:event_btnAssignarActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
    
        if (jTable1.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar una fila");

            } else {
                int confirm = JOptionPane.showConfirmDialog(rootPane, "Desea eliminar el registro?");
                if (confirm == 0) {
                    String CourseCode = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);

                    cone.updateDB("DELETE FROM courses WHERE ID_COURSES="+CourseCode );
                    ToShow("");
                }

            }
 
        
    }//GEN-LAST:event_RemoveActionPerformed

    private void CreateCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateCoursesActionPerformed
    
                   try {
            String codeCourse = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);
            ResultSet rs = cone.queryDB("SELECT * FROM courses WHERE ID_COURSES = " + codeCourse);
            
            if (rs.next()) {
         
                JlbCourseCode.setText(rs.getString("ID_COURSES"));
                txtNameCourse.setText(rs.getString("NAME_COURSES"));
                cboCodeJourney.setSelectedItem(rs.getString("JOURNEYS"));
                
                btnAdd.setEnabled(false); 
                btnUpdate.setEnabled(true);

       
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ese Codigo no existe");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CreateCoursesActionPerformed

    private void AssignCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignCoursesActionPerformed
    
        JpAssign.setVisible(true);
        
        try {
            String codeCourse = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);
            ResultSet rs = cone.queryDB("SELECT * FROM courses WHERE iD_COURSES = " + codeCourse);
            
            if (rs.next()) {
         
                cboCodeTeacher.setSelectedItem(rs.getString("ID_TEA_DIRECTOR"));
                cboCodeJourney2.setSelectedItem(rs.getString("ID_STUD_LEADER"));
                

       
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ese Codigo no existe");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_AssignCoursesActionPerformed

    private void cboCodeTeacherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCodeTeacherItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCodeTeacherItemStateChanged

    private void cboCodeJourney2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCodeJourney2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCodeJourney2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AssignCourses;
    private javax.swing.JMenuItem CreateCourses;
    private javax.swing.JLabel JlbCourseCode;
    private javax.swing.JLabel JlbNameJourney;
    private javax.swing.JPanel JpAssign;
    private javax.swing.JMenu Modify;
    private javax.swing.JMenuItem Remove;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAssignar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboCodeJourney;
    private javax.swing.JComboBox cboCodeJourney2;
    private javax.swing.JComboBox cboCodeTeacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNameCourse;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
