/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ICuentaDAO {
    
    public List<Cuenta> consultarCuentasCliente(int id) throws PersistenciaException;
    public Cuenta consultarCuentaPorID(int id) throws PersistenciaException;
    public Cuenta consultarCuentaPorIDCuenta(int id) throws PersistenciaException ;
    public Cuenta consultarCuentaPorNumCuenta(int id) throws PersistenciaException;
    
}
