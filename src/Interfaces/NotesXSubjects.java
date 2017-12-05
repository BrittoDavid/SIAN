
package Interfaces;

import Interfaces.Resources.ConexionBD;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */


public class NotesXSubjects extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
ConexionBD cone;
int flag=0;

static int id_user=5;   

public NotesXSubjects() {
        initComponents();
        cone=new ConexionBD();
        ComboBoxCourse();
        ComboBoxPeriod();
        lbName();
        JlbTeacherCode.setText(id_user+"");
          
       
    }   
    public void lbName(){
          
    ResultSet rs = cone.consultaBD("SELECT person.NAME ,teacher.ID_TEACHER FROM  teacher INNER "
            + "JOIN person ON person.ID_PERSON = teacher.ID_PERSON WHERE teacher.ID_teacher="+id_user+""); 
         try{
             if(rs.next()){
                  jLabName.setText(rs.getString("person.NAME"));

             }
      } catch (SQLException ex) {
            Logger.getLogger(NotesXSubjects.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
    public void ComboBoxCourse(){    
        
     ConexionBD cone2=new ConexionBD();    
     ResultSet rs = cone2.consultaBD("SELECT courses.NAME_COURSES ,courses.ID_COURSES FROM"
             + " courses INNER JOIN teachersxsubjectsxcourses on courses.ID_COURSES=teachersxsubjectsxcourses.ID_COURSES WHERE teachersxsubjectsxcourses.ID_TEACHERS="+id_user);
             
             
        try {
            while (rs.next()) {           
                cboCodeCourse.addItem(rs.getString("ID_COURSES")+ " - "+ rs.getString("NAME_COURSES"));           
            }          
        } catch (Exception ex) {
         Logger.getLogger(NotesXSubjects.class.getName()).log(Level.SEVERE,null, ex);
        }       
    }
     public void ComboBoxMateri(){
     flag=0;  
     cboCodeSubjects.removeAllItems();
     cboCodeSubjects.addItem("<Seleccione>");
     ConexionBD cone2=new ConexionBD();
     
     String dato=cboCodeCourse.getSelectedItem().toString();
        String dividido[]=dato.split(" - ");
        String idCourse=dividido[0];
     
     ResultSet rs = cone2.consultaBD("SELECT subject.NAME_SUBJECT FROM teachersxsubjectsxcourses INNER JOIN "
             + "subject on  teachersxsubjectsxcourses.ID_SUBJECT = subject.ID_SUBJECT WHERE "
             + "teachersxsubjectsxcourses.ID_TEACHERS="+id_user
             + " AND teachersxsubjectsxcourses.ID_COURSES="+idCourse);
     
        try {
            while (rs.next()) {            
                cboCodeSubjects.addItem(rs.getString("NAME_SUBJECT"));         
            }
            flag=1;
            
        } catch (Exception ex) {
         Logger.getLogger(NotesXSubjects.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
     
    public void ComboBoxPeriod(){    
  
    ConexionBD cone3=new ConexionBD();
     ResultSet rs = cone3.consultaBD("SELECT * FROM period");
     
        try {
            while (rs.next()) {
            
                cboNamePeriod.addItem(rs.getString("name_period"));          
            }
            
        } catch (Exception ex) {
         Logger.getLogger(NotesXSubjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public void buscar(String valor){
            ResultSet rs = cone.consultaBD("SELECT name FROM person WHERE ID_PERSON LIKE '%"+valor+"%'");
            
        }
  
       public void consultar(String valor) {
           
        String id_logros[]=new String[200] ;
        String name_logros[]=new String[200] ;
        String type_achievement[]=new String[200] ;
        int porc_logros[]=new int[200] ;
        int cantLogros=0;
           try {
             ConexionBD cone4= new ConexionBD();
        
            ResultSet rs = cone4.consultaBD("select a.ID_ACHIEVEMENT, a.PORCENTAGE,a.DESCRIPTION ,a.TYPE_ACHIEVEMENTS  from achievement as a WHERE  ID_SUBJECT=(select ID_SUBJECT from subject "
                    + "where NAME_SUBJECT='"+cboCodeSubjects.getSelectedItem()+"')"+
             "AND ID_PERIOD=(select ID_PERIOD from period WHERE NAME_PERIOD='"+cboNamePeriod.getSelectedItem()+"')");
            //
            while (rs.next()) {
                
                id_logros[cantLogros]=rs.getString("a.ID_ACHIEVEMENT");
                name_logros[cantLogros]=rs.getString("a.DESCRIPTION");
                porc_logros[cantLogros]=rs.getInt("a.PORCENTAGE");
                type_achievement[cantLogros]=rs.getString("a.TYPE_ACHIEVEMENTS");
                
                cantLogros++;
            }
        } catch (SQLException ex) {
            System.out.println("Error 1 "+ex);
        }
           
        int column=cantLogros+3;
           
        String titulos[]= new String[column];
        titulos[0]="Nombre Estudiante";
           for (int i = 1; i <= cantLogros; i++) {
               String name[]=name_logros[i-1].split(" ");
               titulos[i] = name[0]+" "+porc_logros[i-1]+"%" +" - "+type_achievement[i-1];
               
           }
        
        titulos[column-2]="Definitiva";
        titulos[column-1]="Descripción";
        
        
        modelo = new DefaultTableModel(null,titulos);
        String fila[] = new String[column];
        ConexionBD cone2= new ConexionBD();
        
        String dato=cboCodeCourse.getSelectedItem().toString();
        String dividido[]=dato.split(" - ");
        String idCourse=dividido[0];
   
       
        try {
            ResultSet rs = cone2.consultaBD("select * from student inner join person ON "
                    + "student.ID_PERSON=person.ID_PERSON where student.ID_COURSE="+idCourse+" AND CONCAT(NAME) LIKE '%"+valor+"%'");
            while (rs.next()) {
                
                int student=rs.getInt("ID_STUDENT");
                fila[0] = rs.getString("NAME");
                double prom=0;
                for (int i = 0; i < cantLogros; i++) {
                    
            ConexionBD cone3= new ConexionBD();
        
            ResultSet rs1 = cone3.consultaBD("select GRADE FROM gradesxachievements where ID_STUDENT="+student
                    + " AND ID_ACHIEVEMENT="+id_logros[i]);
                    if(rs1.next()){
                        fila[i+1] = rs1.getString("GRADE");
                        double suma=Double.parseDouble(fila[i+1]);
                        prom+=suma*porc_logros[i]/100;
                    }
                    
                    else
                      fila[i+1]="";  
                        
                }
                
              fila[column-2] =""+prom;
              fila[column-1] = "";
                
                
               
                modelo.addRow(fila);
             
            }
           jTable_subjec.setModel(modelo);
                
               
            
        } catch (SQLException ex) {
            System.out.println("Error 2 "+ex);
        }
        
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        JlbTeacherCode = new javax.swing.JLabel();
        cboCodeCourse = new javax.swing.JComboBox();
        cboNamePeriod = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        cboCodeSubjects = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_subjec = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Notes X Subjects");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NOTAS X MATERIAS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 810, 50));

        jPanel6.setBackground(new java.awt.Color(235, 235, 235));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel17.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 153));
        jLabel17.setText("Codigo Curso");

        jLabel22.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("Codigo del Docente");

        JlbTeacherCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbTeacherCode.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JlbTeacherCodeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cboCodeCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCodeCourseItemStateChanged(evt);
            }
        });
        cboCodeCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCodeCourseActionPerformed(evt);
            }
        });

        cboNamePeriod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione>" }));
        cboNamePeriod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamePeriodItemStateChanged(evt);
            }
        });
        cboNamePeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamePeriodActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("Periodo");

        cboCodeSubjects.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione>" }));
        cboCodeSubjects.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCodeSubjectsItemStateChanged(evt);
            }
        });
        cboCodeSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCodeSubjectsActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 153));
        jLabel21.setText("Materia");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(JlbTeacherCode, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboNamePeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(61, 61, 61)
                        .addComponent(cboCodeCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboCodeSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlbTeacherCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17))
                    .addComponent(cboCodeCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cboNamePeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(cboCodeSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 210));

        jPanel3.setBackground(new java.awt.Color(235, 235, 235));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel8.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Buscar Estudiante");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 360, -1));

        jTable_subjec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_subjec);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 770, 110));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 22, 16));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cboCodeCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCodeCourseItemStateChanged
      ComboBoxMateri();
       
 
    }//GEN-LAST:event_cboCodeCourseItemStateChanged

    private void cboNamePeriodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamePeriodItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
          
            if (this.cboNamePeriod.getSelectedIndex()>0) {
                 cboCodeSubjects.setSelectedIndex(0);
            }
 
        }
     
          
    }//GEN-LAST:event_cboNamePeriodItemStateChanged

    private void cboCodeSubjectsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCodeSubjectsItemStateChanged
        if(flag==1)
        consultar("");
       
        
       
    }//GEN-LAST:event_cboCodeSubjectsItemStateChanged

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
       consultar(txtSearch.getText());
       
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cboNamePeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamePeriodActionPerformed
       String posicion= (String)cboNamePeriod.getSelectedItem();
       
       if (posicion.equals("<Selecione>")) {
            cboCodeSubjects.setEnabled(false);   
        }else{
            cboCodeSubjects.setEnabled(true);  
       }
         
    }//GEN-LAST:event_cboNamePeriodActionPerformed

    private void cboCodeSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCodeSubjectsActionPerformed
    cboCodeSubjects.setEnabled(false);
    }//GEN-LAST:event_cboCodeSubjectsActionPerformed

    private void cboCodeCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCodeCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCodeCourseActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void JlbTeacherCodeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JlbTeacherCodeAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_JlbTeacherCodeAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlbTeacherCode;
    private javax.swing.JComboBox cboCodeCourse;
    private javax.swing.JComboBox cboCodeSubjects;
    private javax.swing.JComboBox cboNamePeriod;
    private javax.swing.JLabel jLabName;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_subjec;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
