/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.propuestasolucionprueba;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author escor
 */
public class PropuestaSolucionPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        Cliente cliente = new Cliente("109-9","Hugo","Perez","Santiago centro 22","123;456");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2021-09-11";
        Date desde = sdf.parse(dateString);
        dateString = "2021-12-11";
        Date hasta = sdf.parse(dateString);
        Cupon cuponA = new Cupon("123",0.3,desde,hasta,"Coca Cola",10, 321654);
        Cupon cuponB = new Cupon("456",1500,desde,hasta,"Lomo Vetado",5, 654987);
        
        Producto productoA = new Producto(321654, "Coca Cola", 100, 1000);
        Producto productoB = new Producto(654987, "Lomo Vetado", 50, 10000);
        Producto productoC = new Producto(321987, "Agua Mineral", 2, 500);

        int opcion = 0;
        Boleta boleta = new Boleta();
        boleta.setNumeroBoleta(12345);
        while(opcion != 5){
            System.out.println("Bienvenido al supermercado");
            System.out.println("1.-Agregar productos");
            System.out.println("2.-Consultar total Compra");
            System.out.println("5.-Salir");
            opcion = s.nextInt();
            
            if(opcion == 5){
                System.out.println("Gracias por comprar!");
            }
            if(opcion == 1){
                System.out.println("Seleccione el producto que desea agregar");
                System.out.println("1.-Coca cola\n2.-Lomo Vetado\n3.-Agua Mineral");
                int menuProducto = s.nextInt();
                if(menuProducto == 1){
                    boleta.agregarVenta(cuponA, productoA, cliente, boleta, s, 0);
                }
                if(menuProducto == 2){
                    boleta.agregarVenta(cuponB, productoB, cliente, boleta, s, 1);
                }
                if(menuProducto == 3){
                    Cupon cuponC = new Cupon();
                    cuponC.setEan(0);
                    boleta.agregarVenta(cuponC, productoC, cliente, boleta, s, -1);
                }
            }
            
            if(opcion == 2){
                System.out.println("Su total de compra es: " + boleta.getTotalCompra());
            }
            
        }
            
    }
    
}
