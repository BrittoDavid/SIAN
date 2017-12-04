
package Interfaces;

import Interfaces.Grade;
import Interfaces.Main;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Resources.ConnectionDB;


public class Grade extends javax.swing.JInternalFrame {

    ConnectionDB cone,cone2,cone3,cone4,cone5,cone6,cone7,cone8,cone9,cone10, cone11;
    DefaultTableModel modelo;
    int idUser = 2;
    /**
     * Creates new form asd
     */
    public Grade() {
        initComponents();
        cone = new ConnectionDB();
        cone2 = new ConnectionDB();
        cone3 = new ConnectionDB();
        cone4 = new ConnectionDB();
        cone5 = new ConnectionDB();
        cone6 = new ConnectionDB();
        cone7 = new ConnectionDB();
        cone8 = new ConnectionDB();
        cone9 = new ConnectionDB();
        cone10 = new ConnectionDB();
        cone11 = new ConnectionDB();
        loadCourses();
        nameTeacher();
        cargarEstudiantes();
        cbm_act_sub.setVisible(false);
        lbl_act.setVisible(false);
    }

    @SuppressWarnings("unchecked")

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_tit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_nam_tea = new javax.swing.JLabel();
        cbm_id_cur = new javax.swing.JComboBox<>();
        lbl_act = new javax.swing.JLabel();
        cbm_id_sub = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbm_act_sub = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_gra = new javax.swing.JTable();
        cbm_ach = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbm_per = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        bnt_gra = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 37, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tit.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        lbl_tit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tit.setText("Grades");
        lbl_tit.setToolTipText("");
        jPanel1.add(lbl_tit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 50));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Docente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 87, 30));

        lbl_nam_tea.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        getContentPane().add(lbl_nam_tea, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 30));

        cbm_id_cur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbm_id_curItemStateChanged(evt);
            }
        });
        cbm_id_cur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_id_curActionPerformed(evt);
            }
        });
        getContentPane().add(cbm_id_cur, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 210, 30));

        lbl_act.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        lbl_act.setForeground(new java.awt.Color(0, 102, 153));
        lbl_act.setText("Actividades:");
        getContentPane().add(lbl_act, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 110, 30));

        cbm_id_sub.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbm_id_subItemStateChanged(evt);
            }
        });
        cbm_id_sub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbm_id_subMouseEntered(evt);
            }
        });
        getContentPane().add(cbm_id_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 210, 30));

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Periodo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 87, 30));

        cbm_act_sub.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbm_act_subItemStateChanged(evt);
            }
        });
        cbm_act_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_act_subActionPerformed(evt);
            }
        });
        getContentPane().add(cbm_act_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 210, 30));

        tbl_gra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_gra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 430, 130));

        cbm_ach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbm_achItemStateChanged(evt);
            }
        });
        cbm_ach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbm_achActionPerformed(evt);
            }
        });
        getContentPane().add(cbm_ach, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 210, 30));

        jLabel8.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Logro:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, 30));

        jLabel9.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Materias:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 87, 30));

        cbm_per.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbm_perItemStateChanged(evt);
            }
        });
        getContentPane().add(cbm_per, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 210, 30));

        jLabel10.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setText("Curso:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 87, 30));

        bnt_gra.setText("Guardar Notas");
        bnt_gra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_graActionPerformed(evt);
            }
        });
        getContentPane().add(bnt_gra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));

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
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 430, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cbm_id_curItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbm_id_curItemStateChanged

        String DatoCourses = cbm_id_cur.getSelectedItem() + "";
        String DividirC[]=DatoCourses.split(" - ");
        String IdCourses = DividirC[0];
        
       cbm_id_sub.removeAllItems();
        try {  
            ResultSet rs = cone.queryDB("SELECT tsc.ID_SUBJECT, s.NAME_SUBJECT FROM teachersxsubjectsxcourses as tsc "
                    + "INNER JOIN COURSES c ON c.ID_COURSES = tsc.ID_COURSES "
                    + "INNER JOIN subject s ON s.ID_SUBJECT = tsc.ID_SUBJECT WHERE tsc.ID_COURSES ="+IdCourses);
            while (rs.next()) {
                cbm_id_sub.addItem(rs.getString("tsc.ID_SUBJECT") + " - " + rs.getString("s.NAME_SUBJECT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbm_id_curItemStateChanged

    private void cbm_id_curActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_id_curActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_id_curActionPerformed

    private void cbm_perItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbm_perItemStateChanged

        String DatoPeriod = cbm_per.getSelectedItem() + "";
        String DividirP[]=DatoPeriod.split(" - ");
        String IdPeriod = DividirP[0];
        
        String DatoSubject = cbm_id_sub.getSelectedItem() + "";
        String DividirS[]=DatoSubject.split(" - ");
        String IdSubject = DividirS[0];
        
        cbm_ach.removeAllItems();
        try {  
            ResultSet rs = cone2.queryDB("SELECT ach.ID_ACHIEVEMENT, ach.TYPE_ACHIEVEMENTS FROM achievement as ach "
                    + "INNER JOIN period p ON p.ID_PERIOD = ach.ID_PERIOD "
                    + "INNER JOIN subject s ON s.ID_SUBJECT = ach.ID_SUBJECT WHERE ach.ID_PERIOD ="+IdPeriod
                    + " AND s.ID_SUBJECT =" + IdSubject);
            while (rs.next()) {
                cbm_ach.addItem(rs.getString("ach.ID_ACHIEVEMENT")+(" - ")+rs.getString("ach.TYPE_ACHIEVEMENTS"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbm_perItemStateChanged

    private void cbm_achItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbm_achItemStateChanged
             
        String DatoAchievement = cbm_ach.getSelectedItem() + "";
        String DividirA[]=DatoAchievement.split(" - ");
        String IdAchievement = DividirA[0];
        String TypeAchievement = DividirA[1];
        
            cbm_act_sub.removeAllItems();
            try{
                ResultSet rs2 = cone3.queryDB("SELECT a.ID_ACTIVITIES, a.DESCRIPTION FROM activities as a"
                    + " INNER JOIN achievement as ach ON a.ID_ACHIEVEMENT = ach.ID_ACHIEVEMENT"
                    + " WHERE ach.ID_ACHIEVEMENT = " + IdAchievement
                    + " AND ach.TYPE_ACHIEVEMENTS = 'academico'");

                if("academico".equals(TypeAchievement)){
                    cbm_act_sub.setVisible(true);
                    lbl_act.setVisible(true);
                }else{
                    cbm_act_sub.setVisible(false);
                    lbl_act.setVisible(false);
                }
                    

                while (rs2.next()) {
                    cbm_act_sub.addItem(rs2.getString("a.ID_ACTIVITIES")+(" - ")+rs2.getString("a.DESCRIPTION"));           
                }
            } catch (SQLException ex) {
                Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
            }
             
    }//GEN-LAST:event_cbm_achItemStateChanged

    private void cbm_act_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_act_subActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_act_subActionPerformed

    private void cbm_id_subItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbm_id_subItemStateChanged
        String DatoSubject = cbm_id_sub.getSelectedItem() + "";
        String DividirS[]=DatoSubject.split(" - ");
        String IdSubject = DividirS[0];
        
        cbm_per.removeAllItems(); 
        try{    
            ResultSet rs = cone4.queryDB("SELECT a.ID_PERIOD, p.NAME_PERIOD FROM period as p "
                    + "INNER JOIN achievement a ON p.ID_PERIOD = a.ID_PERIOD "
                    + "INNER JOIN subject s ON a.ID_SUBJECT = s.ID_SUBJECT "
                    + "WHERE s.ID_SUBJECT = "+ IdSubject);
            
                while (rs.next()) {
                    cbm_per.addItem(rs.getString("a.ID_PERIOD")+(" - ")+rs.getString("p.NAME_PERIOD"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_cbm_id_subItemStateChanged

    private void cbm_id_subMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbm_id_subMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_id_subMouseEntered

    private void cbm_act_subItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbm_act_subItemStateChanged
        
    }//GEN-LAST:event_cbm_act_subItemStateChanged

    private void cbm_achActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbm_achActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbm_achActionPerformed

    private void bnt_graActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_graActionPerformed
       
    }//GEN-LAST:event_bnt_graActionPerformed


    public void loadCourses() {
        cbm_id_cur.removeAllItems();
        try {
            ResultSet rs = cone5.queryDB("SELECT DISTINCT tsc.ID_COURSES, c.NAME_COURSES FROM teachersxsubjectsxcourses tsc "
                    + "INNER JOIN courses c ON c.ID_COURSES = tsc.ID_COURSES "
                    + "INNER JOIN teacher t ON t.ID_TEACHER = tsc.ID_TEACHERS INNER JOIN person p ON p.ID_PERSON = t.ID_PERSON "
                    + "INNER JOIN users u ON u.ID_PERSON = p.ID_PERSON WHERE u.ID_USER =" + Main.idUser);
            while (rs.next()) {
                cbm_id_cur.addItem(rs.getString("ID_COURSES")+(" - ")+rs.getString("c.NAME_COURSES"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void nameTeacher() {
        try {
            ResultSet rs = cone6.queryDB("SELECT NAME from person p ,users u "
                    + "WHERE u.ID_PERSON = p.ID_PERSON AND ID_USER = " + Main.idUser);
            if (rs.next()) {
                lbl_nam_tea.setText(rs.getString("NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     public void cargarEstudiantes(){
         
        String DatoCourses = cbm_id_cur.getSelectedItem() + "";
        String DividirC[]=DatoCourses.split(" - ");
        String IdCourses = DividirC[0];
        
         String titulos[] = {"LOGRO","CODIGO ESTUDIANTE", "NOMBRE ESTUDIANTE", "NOTA", "DESCRIPCION"};

        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];

        try {
            ResultSet rs = cone7.queryDB("SELECT s.ID_STUDENT, p.NAME, gxa.GRADE,"
                   + " gxa.ID_ACHIEVEMENT, a.DESCRIPTION FROM person as p"
                   + " INNER JOIN student as s ON p.ID_PERSON = s.ID_PERSON" 
                   + " INNER JOIN courses as c ON s.ID_COURSE = c.ID_COURSES" 
                   + " INNER JOIN gradesxachievements as gxa ON s.ID_STUDENT = gxa.ID_STUDENT"
                   + " INNER JOIN achievement as a ON gxa.ID_ACHIEVEMENT = a.ID_ACHIEVEMENT" 
                   + " WHERE c.ID_COURSES ="+IdCourses);

            while (rs.next()) {
                fila[0] = rs.getString("gxa.ID_ACHIEVEMENT");
                fila[1] = rs.getString("gxa.ID_STUDENT");
                fila[2] = rs.getString("p.NAME");
                fila[3] = rs.getString("gxa.GRADE");
                fila[4] = rs.getString("a.DESCRIPTION");
                modelo.addRow(fila);
                
            }
           tbl_gra.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_gra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbm_ach;
    private javax.swing.JComboBox<String> cbm_act_sub;
    private javax.swing.JComboBox<String> cbm_id_cur;
    private javax.swing.JComboBox<String> cbm_id_sub;
    private javax.swing.JComboBox<String> cbm_per;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_act;
    private javax.swing.JLabel lbl_nam_tea;
    private javax.swing.JLabel lbl_tit;
    private javax.swing.JTable tbl_gra;
    // End of variables declaration//GEN-END:variables
}
