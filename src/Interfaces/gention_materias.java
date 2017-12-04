package Interfaces;

import Resources.ConnectionDB;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

public class gention_materias extends javax.swing.JInternalFrame {

    Statement st;
    ResultSet rs;
    ConnectionDB BS;
    DefaultTableModel modelo;
    public gention_materias() {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceAquaTheme");
        initComponents();
        BS = new ConnectionDB();
        txt_cod_mat.setEditable(false);
        this.setSize(515, 543);
        this.btn_crea.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        loadAchievement();
        loadTable2();
        if (Login.lenguaje == 1) {
            jLabel1.setText("MANAGEMENT OF SUBJECTS");
            jLabel2.setText("CODE OF MATTER");
            jLabel3.setText("NAME OF MATTER");
            jLabel4.setText("DESCRIPTION");
            btn_crea.setText("CREATE");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_crea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mat = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txt_cod_mat = new javax.swing.JTextField();
        txt_nom_mat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_des = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 156));

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE MATERIAS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 533, 89);

        btn_crea.setText("CREAR");
        btn_crea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_crea);
        btn_crea.setBounds(90, 460, 330, 47);

        tbl_mat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_mat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 300, 480, 150);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        txt_cod_mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_matActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cod_mat);
        txt_cod_mat.setBounds(180, 10, 210, 30);
        jPanel2.add(txt_nom_mat);
        txt_nom_mat.setBounds(180, 60, 210, 30);

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("CODIGO DE MATERIA");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 160, 14);

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("NOMBRE DE MATERIA");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 60, 170, 14);

        txa_des.setColumns(5);
        txa_des.setRows(5);
        txa_des.setSelectedTextColor(new java.awt.Color(140, 217, 238));
        jScrollPane2.setViewportView(txa_des);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(180, 100, 210, 64);

        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("DESCRIPCION");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 100, 110, 14);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 100, 400, 190);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondoDaza.jpg"))); // NOI18N
        jLabel5.setText("jLabel2");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-10, 80, 520, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public class CustomPanel extends JPanel {

        private URL url = getClass().getResource("fondo.jpg");
        Image image = new ImageIcon(url).getImage();

        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            super.paint(g);
        }
    }
    static int num=0;
    private void btn_creaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creaActionPerformed
        int contador = 0;
        int cont = txt_nom_mat.getText().length();
        if (cont != 0) {
            contador += 1;
        } else {
            JOptionPane.showMessageDialog(this, "INGRESA UNA MATERIA");
        }
        cont = txa_des.getText().length();
        if (cont != 0) {
            contador += 1;
        } else {
            JOptionPane.showMessageDialog(this, "INGRESA UNA DESCRIPCION");
        }

        if (contador == 2) {
            int totalCampo = 0;
            try {
                rs = BS.queryDB("SELECT COUNT(ID_SUBJECT) FROM subject");
                while (rs.next()) {
                    totalCampo = Integer.parseInt(rs.getString("COUNT(ID_SUBJECT)"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(gention_materias.class.getName()).log(Level.SEVERE, null, ex);
            }
            int codigo;
            codigo = Integer.parseInt(txt_cod_mat.getText());
            String materia = txt_nom_mat.getText();
            String descripcion = txa_des.getText();
            BS.updateDB("INSERT INTO `subject`(`ID_SUBJECT`, `NAME_SUBJECT`, `DESCRIPTION`) VALUES (" + codigo + ",'" + materia + "','" + descripcion + "')");

            int totalCampo2 = 0;

            try {
                rs = BS.queryDB("SELECT COUNT(ID_SUBJECT) FROM subject");
                while (rs.next()) {
                    totalCampo2 = Integer.parseInt(rs.getString("COUNT(ID_SUBJECT)"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(gention_materias.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (totalCampo2 > totalCampo) {
                JOptionPane.showMessageDialog(this, "creado correctamente");
                num+=1;
                reiniciar();
            } else {
                JOptionPane.showMessageDialog(this, "creado incorrectamente");
            }

        }
       loadTable2();        
    }//GEN-LAST:event_btn_creaActionPerformed

    private void txt_cod_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_matActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_matActionPerformed

    public void loadAchievement() {
        try {
            rs = BS.queryDB("SELECT MAX(ID_SUBJECT) FROM subject");
            if (rs.next()) {
                txt_cod_mat.setText((rs.getInt("MAX(ID_SUBJECT)") + 1) + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gention_materias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadTable2(){
    String titulos[] = new String[3];
    if (Login.lenguaje == 1) {
            titulos[0] = "CODE";
            titulos[1] = "MATTER";
            titulos[2] = "DESCRIPTION";
         }else{
            titulos[0]= "CODIGO";
            titulos[1]= "MATERIA";
            titulos[2]= "DESCRIPCION";
        }
    modelo = new DefaultTableModel(null, titulos);


    
    String fila[] = new String[3];
        try {
            rs= BS.queryDB("SELECT * FROM subject");
            while (rs.next()){
                fila[0]= rs.getString("ID_SUBJECT");
                fila[1]= rs.getString("NAME_SUBJECT");
                fila[2]= rs.getString("DESCRIPTION");
                modelo.addRow(fila);
            }
            
            tbl_mat.setModel(modelo);
        } catch (Exception ex) {
            System.out.println("ERROR"+ex);
        }
    }

    public void reiniciar() {
        loadAchievement();
        txt_nom_mat.setText("");
        txa_des.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_mat;
    private javax.swing.JTextArea txa_des;
    private javax.swing.JTextField txt_cod_mat;
    private javax.swing.JTextField txt_nom_mat;
    // End of variables declaration//GEN-END:variables
}
