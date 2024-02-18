/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.dto.ClienteDTO;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IClienteDAO {
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
    public Cliente comprobarSesionCliente(String nombreUsuario,String contrasena) throws PersistenciaException;
    //public List<Cliente> consultarTodos() throws PersistenciaException; 
}
