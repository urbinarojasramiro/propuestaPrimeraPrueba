/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.propuestasolucionprueba;

import java.util.Scanner;

/**
 *
 * @author sabur
 */
public class Boleta {
    private int numeroBoleta;
    private int cantidad;
    private double totalCompra;
    private String codigosCupones;
    private String rutCliente;

    public Boleta(int numeroBoleta, int cantidad, double totalCompra, String codigosCupones, String rutCliente) {
        this.numeroBoleta = numeroBoleta;
        this.cantidad = cantidad;
        this.totalCompra = totalCompra;
        this.codigosCupones = codigosCupones;
        this.rutCliente = rutCliente;
    }

    public Boleta() {
    }
    
    public void agregarCupon(String cupon){
        if(this.codigosCupones == null){
            this.codigosCupones = cupon;
        }else{
            this.codigosCupones = this.codigosCupones + ";" + cupon;
        }
    }
    
    public void actualizarVenta(double precio){
        this.totalCompra = this.totalCompra + precio;
    }
    
    public double getDiscount(double discount, double precio){
        double descuentoFinal = 0;
        if(discount > 1){
            descuentoFinal =  precio - discount;
        }else{
            double descuento = precio * discount;
            descuentoFinal = precio - descuento;
        }
        
        return descuentoFinal;
    }
    
    public void agregarVenta(Cupon cuponA, Producto productoA, Cliente cliente, Boleta boleta, Scanner s, int index){
        System.out.println("Ingrese Cantidad");
        int cantidadIn = s.nextInt();
        boolean tieneCupon = cuponA.getEan()== productoA.getEan();
        boolean cuponCorrecto = false;
        String cuponCliente = null;
        if(tieneCupon){
            cuponCliente = cliente.getCodigosCupones().split(";")[index];
            cuponCorrecto = tieneCupon && cuponCliente.equals(cuponA.getCodigoCupon());
        }

        double precioProducto = productoA.getPrecio();
        String[] cupones = null;
        if(boleta.getCodigosCupones()!=null){
            cupones = boleta.getCodigosCupones().split(";");
            for (int i = 0; i < cupones.length; i++) {
                String cuponBoleta = cupones[i];
                if(cuponBoleta.equals(cuponCliente)){
                    cuponCorrecto = false;
                }
            }
        }

        double totalCompra = 0L;
        int stock = 0;
        if(cuponA.getMaximoUnidades() > productoA.getStock()){
            stock = productoA.getStock();
        }else{
            stock = cuponA.getMaximoUnidades();
        }
        boolean validateCount = (cantidadIn > stock) && cuponCorrecto;
        while(validateCount){
            System.out.println("No puede llevar más unidades que " + stock);
            System.out.println("Ingrese la cantidad correcta");
            cantidadIn = s.nextInt();
            validateCount = (cantidadIn > stock) && cuponCorrecto;
        }

        while(!tieneCupon){
            if(cantidadIn > productoA.getStock()){
                System.out.println("No puede llevar más unidades que " + productoA.getStock());
                System.out.println("Ingrese la cantidad correcta");
                cantidadIn = s.nextInt();
                tieneCupon = (cantidadIn > stock);
            }else{
                tieneCupon = true;
            }
        }
        precioProducto = precioProducto * cantidadIn;
        if(cuponCorrecto){
            totalCompra = boleta.getDiscount(cuponA.getDescuento(), precioProducto);
        }else{
            totalCompra = precioProducto;
        }
        int cantidad = boleta.getCantidad();
        boleta.setCantidad(cantidad++);
        boleta.agregarCupon(cuponA.getCodigoCupon());
        boleta.actualizarVenta(totalCompra);
        System.out.println("El precio del producto es " + precioProducto);
        System.out.println("El precio agregado a la compra es " + totalCompra);
    }

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getCodigosCupones() {
        return codigosCupones;
    }

    public void setCodigosCupones(String codigosCupones) {
        this.codigosCupones = codigosCupones;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    

   
   
}
