/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semaphore2;

/**
 *
 * @author mac
 */
class Temporizador {
    public void semaforoprendido(int velocidad) throws InterruptedException{
        ColorAmarillo a = new ColorAmarillo();
        
        ColorRojo r = new ColorRojo();
        
        ColorVerde v = new ColorVerde();
        
        while (true){
            System.out.println(r.getLuz());
            Thread.sleep(velocidad);
            
            System.out.println(a.getLuz());
            Thread.sleep(velocidad/2);
            
            System.out.println(v.getLuz());
            Thread.sleep(velocidad);
            Thread.sleep(velocidad/2);
        }
    }    
}
