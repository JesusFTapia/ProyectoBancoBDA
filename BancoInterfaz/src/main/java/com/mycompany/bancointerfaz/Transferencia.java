/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancointerfaz;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.Conexion;
import com.mycompany.bancopersistencia.dao.CuentaDAO;
import com.mycompany.bancopersistencia.dao.TransferenciaDAO;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Transferencia extends javax.swing.JFrame {
    Conexion conexion;
    int id;
    TransferenciaDAO t;
    CuentaDAO cuentaDAO;
    /**
     * Creates new form Transaccion
     */
    public Transferencia(int id, Conexion c) {
        this.id=id;
        conexion=c;
        t=new TransferenciaDAO(conexion);
        cuentaDAO=new CuentaDAO(conexion);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MontoTextField = new javax.swing.JTextField();
        ideCuentaDestinoTextField = new javax.swing.JTextField();
        TransferirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Datos de la transacción:");

        jLabel2.setText("Monto:");

        jLabel3.setText("Destinatario:");

        TransferirButton.setText("Transferir");
        TransferirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MontoTextField)
                                    .addComponent(ideCuentaDestinoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(TransferirButton)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MontoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ideCuentaDestinoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TransferirButton)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TransferirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferirButtonActionPerformed
        try {
            Cuenta cuenta=cuentaDAO.consultarCuentaPorIDCuenta(id);
            t.agregarTransferencia(cuenta.getNumeroCuenta(),Integer.parseInt(ideCuentaDestinoTextField.getText()),Float.parseFloat(MontoTextField.getText()));
            PaginaPrincipal p=new PaginaPrincipal(id, conexion);
            p.show();
            dispose();
        } catch (PersistenciaException ex) {
            Logger.getLogger(Transferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TransferirButtonActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MontoTextField;
    private javax.swing.JButton TransferirButton;
    private javax.swing.JTextField ideCuentaDestinoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}