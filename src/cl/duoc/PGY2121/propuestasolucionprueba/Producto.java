/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.propuestasolucionprueba;

/**
 *
 * @author sabur
 */
public class Producto {
    private long ean;
    private String marca;
    private int stock;
    private double precio;

    public Producto(long ean, String marca, int stock, double precio) {
        this.ean = ean;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
    }

    public Producto() {
    }

    public long getEan() {
        return ean;
    }

    public void setEan(long ean) {
        this.ean = ean;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
