package Vista;

import Controlador.Controlador;
import java.awt.Image;
import java.awt.Toolkit;

public class Vista extends javax.swing.JFrame 
{
    public Vista() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        
        transparenciaTextLabel();
        transparenciaButton();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextNombre = new javax.swing.JTextField();
        jTextPoblacion = new javax.swing.JTextField();
        jTextHabitable = new javax.swing.JTextField();
        jTextOxigeno = new javax.swing.JTextField();
        jButtonMostrar = new javax.swing.JButton();
        jButtonCrear = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTablePlaneta = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Viajes | Cristian Espitia");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextNombre.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jTextNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombre.setBorder(null);
        getContentPane().add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, 150, 30));

        jTextPoblacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextPoblacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextPoblacion.setBorder(null);
        getContentPane().add(jTextPoblacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 750, 90, 30));

        jTextHabitable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextHabitable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextHabitable.setBorder(null);
        getContentPane().add(jTextHabitable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 840, 90, 30));

        jTextOxigeno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextOxigeno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextOxigeno.setBorder(null);
        getContentPane().add(jTextOxigeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 770, 70, 70));
        getContentPane().add(jButtonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 136, 80, 25));
        getContentPane().add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 933, 70, 30));
        getContentPane().add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 933, 80, 30));
        getContentPane().add(jButtonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 933, 80, 30));

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTablePlaneta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Población", "O2", "Habitable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePlaneta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlanetaMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTablePlaneta);
        if (jTablePlaneta.getColumnModel().getColumnCount() > 0) {
            jTablePlaneta.getColumnModel().getColumn(0).setMaxWidth(30);
            jTablePlaneta.getColumnModel().getColumn(1).setMaxWidth(80);
            jTablePlaneta.getColumnModel().getColumn(3).setMaxWidth(40);
            jTablePlaneta.getColumnModel().getColumn(4).setMaxWidth(75);
        }

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 181, 256, 249));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GUI.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePlanetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlanetaMouseClicked
        int fila = this.jTablePlaneta.rowAtPoint(evt.getPoint());
        
        this.jTextNombre.setText(this.jTablePlaneta.getValueAt(fila, 1).toString());
        this.jTextPoblacion.setText(this.jTablePlaneta.getValueAt(fila, 2).toString());
        this.jTextOxigeno.setText(this.jTablePlaneta.getValueAt(fila, 3).toString());
        this.jTextHabitable.setText(this.jTablePlaneta.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_jTablePlanetaMouseClicked

    //Poner los Cuadros de Texto Transparentes
    public void transparenciaTextLabel()
    {
        jTextNombre.setOpaque(false);
        jTextPoblacion.setOpaque(false);
        jTextHabitable.setOpaque(false);
        jTextOxigeno.setOpaque(false);
    }
    
    //Poner los Botones Transparentes
    public void transparenciaButton()
    {
        jButtonMostrar.setOpaque(false);
        jButtonMostrar.setContentAreaFilled(false);
        jButtonMostrar.setBorderPainted(false);
        
        jButtonCrear.setOpaque(false);
        jButtonCrear.setContentAreaFilled(false);
        jButtonCrear.setBorderPainted(false);
        
        jButtonActualizar.setOpaque(false);
        jButtonActualizar.setContentAreaFilled(false);
        jButtonActualizar.setBorderPainted(false);
        
        jButtonBorrar.setOpaque(false);
        jButtonBorrar.setContentAreaFilled(false);
        jButtonBorrar.setBorderPainted(false);
    }
    
    //Icono
    public Image getIconImage()
    {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Logo.png"));
        return retValue;
    }
    
    public static void main(String args[]) 
    {    
        Vista vista = new Vista();
        Controlador c = new Controlador(vista);
        vista.setVisible(true);
        vista.setLocationRelativeTo(vista);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonActualizar;
    public javax.swing.JButton jButtonBorrar;
    public javax.swing.JButton jButtonCrear;
    public javax.swing.JButton jButtonMostrar;
    public javax.swing.JLabel jLabelFondo;
    public javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTablePlaneta;
    public javax.swing.JTextField jTextHabitable;
    public javax.swing.JTextField jTextNombre;
    public javax.swing.JTextField jTextOxigeno;
    public javax.swing.JTextField jTextPoblacion;
    // End of variables declaration//GEN-END:variables
}
