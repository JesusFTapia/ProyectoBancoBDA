/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancointerfaz;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.Conexion;
import com.mycompany.bancopersistencia.dao.CuentaDAO;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author USER
 */
public class SeleccionCuenta extends javax.swing.JFrame {
    Conexion conexion;
    int id;
    CuentaDAO c;
    /**
     * Creates new form SeleccionCuenta
     */
    public SeleccionCuenta(int idc,Conexion conexion) throws PersistenciaException {
        this.id=idc;
        this.conexion=conexion;
        c=new CuentaDAO(conexion);
        initComponents();     
        this.comboCuentas(idc);
        
        
    }
    
    public void comboCuentas(int id) throws PersistenciaException{
        DefaultComboBoxModel<Cuenta> comboBoxModel = new DefaultComboBoxModel<>();
        
        List<Cuenta> cuentas;
        
        cuentas=c.consultarCuentasCliente(id);
        
        for (Cuenta c : cuentas) {
            comboBoxModel.addElement(c);       
        }
        CuentasComboBox.setModel(comboBoxModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CerrarSesionButton = new javax.swing.JButton();
        CuentasComboBox = new javax.swing.JComboBox<>();
        SeleccionarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CerrarSesionButton.setText("Cerrar sesión");
        CerrarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionButtonActionPerformed(evt);
            }
        });

        SeleccionarButton.setText("Seleccionar");
        SeleccionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(CerrarSesionButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(CuentasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(SeleccionarButton)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(CuentasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeleccionarButton)
                .addGap(76, 76, 76)
                .addComponent(CerrarSesionButton)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionButtonActionPerformed
        // TODO add your handling code here:
        InicioSesion i=new InicioSesion();
        i.show();
        dispose();
    }//GEN-LAST:event_CerrarSesionButtonActionPerformed

    private void SeleccionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarButtonActionPerformed
        // TODO add your handling code here:
        Cuenta c=(Cuenta)CuentasComboBox.getSelectedItem();
        PaginaPrincipal p=new PaginaPrincipal(c.getIdcuenta(), conexion);
        p.show();
        dispose();
    }//GEN-LAST:event_SeleccionarButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesionButton;
    private javax.swing.JComboBox<Cuenta> CuentasComboBox;
    private javax.swing.JButton SeleccionarButton;
    // End of variables declaration//GEN-END:variables
}