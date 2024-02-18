/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;


import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.dto.ClienteDTO;
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
public class ClienteDAO implements IClienteDAO{
    
    IConexion conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre,apellidoPaterno,apellidoMaterno) VALUES(?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            Cliente clienteGuardado = new Cliente(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));

            return clienteGuardado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente");
            throw new PersistenciaException("No se pudo agregar el cliente");
        }
    }


    @Override
    public Cliente comprobarSesionCliente(String nombreUsuario,String contrasena) throws PersistenciaException {
        String sentencia = "SELECT * FROM CLIENTES WHERE nombreUsuario= ? and contrasena=?; ";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setString(1, nombreUsuario);
            comandoSQL.setString(2, contrasena);
            ResultSet res = comandoSQL.executeQuery();
            res.next();

            Cliente cliente = new Cliente(
                        res.getInt("idcliente"),
                        res.getString("nombre"),
                        res.getString("apellidoPaterno"),
                        res.getString("apellidoMaterno"),
                        res.getString("nombreUsuario"),
                        res.getString("contrasena"),
                        res.getString("fechaNacimiento")
                );
            return cliente;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("El nombre de usuario o contraseña son incorrectos.");

        }
    }
}



    
    

