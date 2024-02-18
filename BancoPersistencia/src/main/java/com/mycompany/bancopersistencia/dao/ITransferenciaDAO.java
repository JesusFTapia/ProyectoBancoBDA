/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.Transferencia;
import com.mycompany.bancopersistencia.dto.ClienteDTO;
import com.mycompany.ecoactivistaspersistencia.excepciones.PersistenciaException;

/**
 *
 * @author USER
 */
public interface ITransferenciaDAO {
    public Transferencia agregarTransferencia(int idEnvia,int idRecibe,float monto) throws PersistenciaException;
}
