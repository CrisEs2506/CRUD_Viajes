package Controlador;

import Modelo.Planeta;
import Modelo.PlanetaDAO;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener
{
    PlanetaDAO dao = new PlanetaDAO();
    Planeta planeta = new Planeta();
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(Vista vista)
    {
        this.vista = vista;
        this.vista.jButtonMostrar.addActionListener(this);
        this.vista.jButtonCrear.addActionListener(this);
        this.vista.jButtonActualizar.addActionListener(this);
        this.vista.jButtonBorrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==vista.jButtonMostrar)
        {
            limpiarTabla();
            mostrar(vista.jTablePlaneta);
        }
        
        if(e.getSource()==vista.jButtonCrear)
        {
            crear();
            limpiarTabla();
            mostrar(vista.jTablePlaneta);
        }
        
        if(e.getSource()==vista.jButtonActualizar)
        {   
            actualizar();
            limpiarTabla();
            mostrar(vista.jTablePlaneta);
        }
        
        if(e.getSource()==vista.jButtonBorrar)
        {
            borrar();
            limpiarTabla();
            mostrar(vista.jTablePlaneta);
        }
    }
    
    public void mostrar(JTable tabla)
    {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Planeta> lista = dao.mostrar();
        Object[] object = new Object[5];
        
        for(int i=0; i<lista.size(); i++)
        {
            object[0] = lista.get(i).getCod_planeta();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getPoblacion();
            object[3] = lista.get(i).getNivel_oxigeno();
            object[4] = lista.get(i).getHabitable();
            modelo.addRow(object);
        }
        
        vista.jTablePlaneta.setModel(modelo);
    }
    
    public void crear()
    {
        String nombre = vista.jTextNombre.getText();
        String poblacion = vista.jTextPoblacion.getText();
        String oxigeno = vista.jTextOxigeno.getText();
        String habitable = vista.jTextHabitable.getText();
        
        planeta.setNombre(nombre);
        planeta.setPoblacion(Integer.parseInt(poblacion));
        planeta.setNivel_oxigeno(Double.parseDouble(oxigeno));
        planeta.setHabitable(Integer.parseInt(habitable));
        
        int r = dao.crear(planeta);
        
        if(r == 1)
        {
            JOptionPane.showMessageDialog(vista, "Planeta Agregado con Éxito");
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "Algo se Ingreso Erroneamente, por favor Vuelve a Intentarlo");
        }
        
        limpiarTabla();
    }
    
    public void actualizar()
    {
        String nombre = vista.jTextNombre.getText();
        String poblacion = vista.jTextPoblacion.getText();
        String oxigeno = vista.jTextOxigeno.getText();
        String habitable = vista.jTextHabitable.getText();
        
        planeta.setNombre(nombre);
        planeta.setPoblacion(Integer.parseInt(poblacion));
        planeta.setNivel_oxigeno(Double.parseDouble(oxigeno));
        planeta.setHabitable(Integer.parseInt(habitable));
        
        int r = dao.actualizar(planeta);
        
        if(r == 1)
        {
            JOptionPane.showMessageDialog(vista, "Planeta Actualizado con Éxito");
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "Algo se Ingreso Erroneamente, por favor Vuelve a Intentarlo");
        }
        
        limpiarTabla();
    }
    
    public void borrar()
    {
        int fila = vista.jTablePlaneta.getSelectedRow();
        
        if (fila == -1) 
        {
            JOptionPane.showMessageDialog(vista, "Debe Seleccionar una Fila");
        } 
        else 
        {
            int cod_planeta = Integer.parseInt((String) vista.jTablePlaneta.getValueAt(fila, 0).toString());
            dao.eliminar(cod_planeta);
            System.out.println("El ID tomado es: " + cod_planeta);
            JOptionPane.showMessageDialog(vista, "Planeta Eliminado con Éxito");
        }
        
        limpiarTabla();
    }
    
    public void limpiarTabla()
    {
        for(int i=0; i<vista.jTablePlaneta.getRowCount(); i++)
        {
            modelo.removeRow(i);
            i = i-1;
        }
    }
}
