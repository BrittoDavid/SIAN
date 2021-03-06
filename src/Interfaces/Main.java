package Interfaces;

import Interfaces.Background;
import static Interfaces.Login.main;
import static Interfaces.Main.main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    static int idUser;
    static int opcion = 5;
    static boolean abrir = true;
    
    
    
        
        

        // Llamamos la imagen de fondo 
        public InputStream foto = this.getClass().getResourceAsStream("/Img/principal_foto.png");

    public Main() {
        initComponents();
        cerrar();
        
        /*Linea de codigo para que la aplicacion aparezca en toda la pantalla*/
        this.setExtendedState(MAXIMIZED_BOTH);
        
        /*llamasmo la imagen de la clase Fondo*/
        cargarImagen(escritorioAdmin, foto);

        /*Condiciones de las ventanas que pueden ver los usuarios segun su rol*/
        if (opcion == 5) {
            JOptionPane.showMessageDialog(null, "Usted no tiene autorizacion para entrar");
            System.exit(0);
        } else {
            if (opcion == 0) {
                gestActi.setVisible(false);
                gestAsignatura.setVisible(true);
                gestCurso.setVisible(true);
                gestLogro.setVisible(true);
                gestNota.setVisible(true);
                gestReporte.setVisible(true);
                gestRoles.setVisible(true);
                NxM_Docente.setVisible(false);
                NxM_docente.setVisible(false);
            }

            if (opcion == 1) {
                gestActi.setVisible(true);
                gestAsignatura.setVisible(true);
                gestCurso.setVisible(true);
                gestLogro.setVisible(true);
                gestNota.setVisible(true);
                gestReporte.setVisible(true);
                gestRoles.setVisible(false);
                NxM_Docente.setVisible(true);
                NxM_docente.setVisible(true);
            }

            if (opcion == 2) {
                gestActi.setVisible(false);
                gestAsignatura.setVisible(true);
                gestCurso.setVisible(false);
                gestLogro.setVisible(true);
                gestNota.setVisible(true);
                gestReporte.setVisible(false);
                gestRoles.setVisible(false);
                NxM_Docente.setVisible(false);
                NxM_docente.setVisible(false);
            }

            if (opcion == 3) {
                gestActi.setVisible(false);
                gestAsignatura.setVisible(true);
                gestCurso.setVisible(false);
                gestLogro.setVisible(true);
                gestNota.setVisible(true);
                gestReporte.setVisible(false);
                gestRoles.setVisible(false);
                NxM_Docente.setVisible(false);
                NxM_docente.setVisible(false);
            }
        }
    }

    /*Metodo para llamar la clase Fondo*/
    public void cargarImagen(javax.swing.JDesktopPane jDeskp, InputStream fileImagen) {
        try {
            BufferedImage image = ImageIO.read(fileImagen);
            jDeskp.setBorder(new Background(image));
        } catch (Exception e) {
            System.out.println("Imagen no disponible");
        }
    }
    
    /*Metodo para cerrar la interfaces principal*/
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
        } catch (Exception e) {
        }
    }
    
    /*Metodo de mensaje de despedida al momento de cerrar*/
    public void confirmarSalida(){
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Seguro que desea salir?");
        if (confirm == 0) {
            JOptionPane.showMessageDialog(null, "Gracias por su visita,lo esperamos pronto","Gracias",JOptionPane.INFORMATION_MESSAGE);
            Login salir = new Login();
            salir.setVisible(true);
            dispose();
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioAdmin = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        IngresarUsuarios = new javax.swing.JMenu();
        gestActi = new javax.swing.JMenuItem();
        gestNota = new javax.swing.JMenuItem();
        gestCurso = new javax.swing.JMenuItem();
        gestRoles = new javax.swing.JMenuItem();
        NxM_Docente = new javax.swing.JMenuItem();
        gestAsignatura = new javax.swing.JMenuItem();
        gestLogro = new javax.swing.JMenuItem();
        gestReporte = new javax.swing.JMenuItem();
        NxM_docente = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout escritorioAdminLayout = new javax.swing.GroupLayout(escritorioAdmin);
        escritorioAdmin.setLayout(escritorioAdminLayout);
        escritorioAdminLayout.setHorizontalGroup(
            escritorioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        escritorioAdminLayout.setVerticalGroup(
            escritorioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        IngresarUsuarios.setText("Gestion");

        gestActi.setText("Actividades");
        IngresarUsuarios.add(gestActi);

        gestNota.setText("Notas");
        gestNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestNotaActionPerformed(evt);
            }
        });
        IngresarUsuarios.add(gestNota);

        gestCurso.setText("Curso");
        IngresarUsuarios.add(gestCurso);

        gestRoles.setText("Roles");
        IngresarUsuarios.add(gestRoles);

        NxM_Docente.setText("Notas*Materia_Docente");
        NxM_Docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NxM_DocenteActionPerformed(evt);
            }
        });
        IngresarUsuarios.add(NxM_Docente);

        gestAsignatura.setText("Asignatura");
        IngresarUsuarios.add(gestAsignatura);

        gestLogro.setText("Logros");
        IngresarUsuarios.add(gestLogro);

        gestReporte.setText("Reporte");
        IngresarUsuarios.add(gestReporte);

        NxM_docente.setText("Notas*Materia_estudiante");
        IngresarUsuarios.add(NxM_docente);

        jMenuBar1.add(IngresarUsuarios);

        jMenu1.setText("Eventos");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioAdmin, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioAdmin, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gestNotaActionPerformed

    private void NxM_DocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NxM_DocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NxM_DocenteActionPerformed

    private void NxM_docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NxM_docenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NxM_docenteActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        
       
    }//GEN-LAST:event_jMenu1MousePressed
@SuppressWarnings("unchecked")
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
             
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu IngresarUsuarios;
    private javax.swing.JMenuItem NxM_Docente;
    private javax.swing.JMenuItem NxM_docente;
    public static javax.swing.JDesktopPane escritorioAdmin;
    private javax.swing.JMenuItem gestActi;
    private javax.swing.JMenuItem gestAsignatura;
    private javax.swing.JMenuItem gestCurso;
    private javax.swing.JMenuItem gestLogro;
    private javax.swing.JMenuItem gestNota;
    private javax.swing.JMenuItem gestReporte;
    private javax.swing.JMenuItem gestRoles;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
