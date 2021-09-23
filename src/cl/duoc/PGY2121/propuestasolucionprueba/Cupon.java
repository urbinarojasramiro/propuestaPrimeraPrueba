/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.propuestasolucionprueba;

import java.util.Date;

/**
 *
 * @author sabur
 */
public class Cupon {
    private String codigoCupon;
    private double descuento;
    private Date fechaDesde;
    private Date fechaHasta;
    private String marca;
    private int maximoUnidades;
    private long ean;

    public Cupon(String codigoCupon, double descuento, Date fechaDesde, Date fechaHasta, String marca, int maximoUnidades, long ean) {
        this.codigoCupon = codigoCupon;
        this.descuento = descuento;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.marca = marca;
        this.maximoUnidades = maximoUnidades;
        this.ean = ean;
    }

    public Cupon() {
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMaximoUnidades() {
        return maximoUnidades;
    }

    public void setMaximoUnidades(int maximoUnidades) {
        this.maximoUnidades = maximoUnidades;
    }

    public long getEan() {
        return ean;
    }

    public void setEan(long ean) {
        this.ean = ean;
    }

    
    
    
}
