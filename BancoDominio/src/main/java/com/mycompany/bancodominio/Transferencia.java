/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancodominio;

import java.util.Objects;

/**
 *
 * @author USER
 */
public class Transferencia {
    private int idTransferencia;
    private int idCuentaEnvia;
    private int idCuentaRecibe;
    private float cantidad;
    private String fecha;

    public Transferencia() {
    }

    public Transferencia(int idCuentaEnvia, int idCuentaRecibe, float cantidad, String fecha) {
        this.idCuentaEnvia = idCuentaEnvia;
        this.idCuentaRecibe = idCuentaRecibe;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Transferencia(int idTransferencia, int idCuentaEnvia, int idCuentaRecibe, float cantidad, String fecha) {
        this.idTransferencia = idTransferencia;
        this.idCuentaEnvia = idCuentaEnvia;
        this.idCuentaRecibe = idCuentaRecibe;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public void setIdCuentaEnvia(int idCuentaEnvia) {
        this.idCuentaEnvia = idCuentaEnvia;
    }

    public void setIdCuentaRecibe(int idCuentaRecibe) {
        this.idCuentaRecibe = idCuentaRecibe;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public int getIdCuentaEnvia() {
        return idCuentaEnvia;
    }

    public int getIdCuentaRecibe() {
        return idCuentaRecibe;
    }

    public float getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idTransferencia;
        hash = 71 * hash + this.idCuentaEnvia;
        hash = 71 * hash + this.idCuentaRecibe;
        hash = 71 * hash + Float.floatToIntBits(this.cantidad);
        hash = 71 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transferencia other = (Transferencia) obj;
        if (this.idTransferencia != other.idTransferencia) {
            return false;
        }
        if (this.idCuentaEnvia != other.idCuentaEnvia) {
            return false;
        }
        if (this.idCuentaRecibe != other.idCuentaRecibe) {
            return false;
        }
        if (Float.floatToIntBits(this.cantidad) != Float.floatToIntBits(other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", idCuentaEnvia=" + idCuentaEnvia + ", idCuentaRecibe=" + idCuentaRecibe + ", cantidad=" + cantidad + ", fecha=" + fecha + '}';
    }
    
}
