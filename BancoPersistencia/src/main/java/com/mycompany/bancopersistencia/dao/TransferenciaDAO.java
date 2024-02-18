/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Transferencia;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    CuentaDAO cdao;
    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public TransferenciaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
        cdao=new CuentaDAO(conexionBD);
    }

    @Override
    public Transferencia agregarTransferencia(int numEnvia, int numRecibe, float monto) throws PersistenciaException {
        String sentenciaSQL = "{CALL transferenciaTransaccion(?, ?, ?, ?, ?)}";
        
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            int idce=cdao.consultarCuentaPorNumCuenta(numEnvia).getIdcuenta();
            int idcr=cdao.consultarCuentaPorNumCuenta(numRecibe).getIdcuenta();
            System.out.println("paput");
            
            comandoSQL.setInt(1,idce );
            comandoSQL.setInt(2, idcr);
            comandoSQL.setFloat(3, monto);
            comandoSQL.setInt(4, numEnvia);
            comandoSQL.setInt(5, numRecibe);
            
            System.out.println("papu3");
            int resultado = comandoSQL.executeUpdate();
            System.out.println("papu4");
            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

           Transferencia transferenciaGuardada = new Transferencia(idce, idcr, monto, LocalDate.now().toString());
        

            return transferenciaGuardada;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo transferir");
            throw new PersistenciaException("No se pudo transferir");
        }
        
    }

}
