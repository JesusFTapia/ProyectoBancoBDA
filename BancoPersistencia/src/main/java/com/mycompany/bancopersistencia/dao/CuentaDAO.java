/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CuentaDAO implements ICuentaDAO{
    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public CuentaDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    @Override
    public List<Cuenta> consultarCuentasCliente(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM CUENTAS WHERE IDCLIENTE=?;";
        List<Cuenta> lista = new ArrayList<>();
        
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            
            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            while (res.next()) {
                int idcliente = res.getInt("idcliente");
                int idcuenta = res.getInt("idcuenta");
                int numerocuenta = res.getInt("numeroCuenta");
                String fechaApertura = res.getString("fechaApertura");
                float saldo = res.getFloat("saldo");
                String estado = res.getString("estado");
                Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                lista.add(c);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());

            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);
            throw new PersistenciaException("No se pudieron las cuentas");
        }
    }
    @Override
    public Cuenta consultarCuentaPorID(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE idcliente= ?";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            int idcliente = res.getInt("idcliente");
            int idcuenta = res.getInt("idcuenta");
            int numerocuenta = res.getInt("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            float saldo = res.getFloat("saldo");
            String estado = res.getString("estado");
            Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                

            return c;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }
    
    @Override
    public Cuenta consultarCuentaPorIDCuenta(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE idcuenta= ?;";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            int idcliente = res.getInt("idcliente");
            int idcuenta = res.getInt("idcuenta");
            int numerocuenta = res.getInt("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            float saldo = res.getFloat("saldo");
            String estado = res.getString("estado");
            Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                

            return c;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }
    
    @Override
    public Cuenta consultarCuentaPorNumCuenta(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE numeroCuenta= ?;";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            int idcliente = res.getInt("idcliente");
            int idcuenta = res.getInt("idcuenta");
            int numerocuenta = res.getInt("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            float saldo = res.getFloat("saldo");
            String estado = res.getString("estado");
            Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                

            return c;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }
    
}
