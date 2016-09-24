
package cenafilosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author Francisco Javier Alcalá Olivares
 */
public class Filosofo extends Thread{
    private final JLabel icono, iconoPensando, iconoComiendo, iconoHambriento;
    private int pensando, comiendo, hambriento, muerto;
    private final Semaphore[] tenedores;
    private final Random tiempoAleatorio = new Random();
    private int intentosComerFallidos;
    
    public Filosofo(JLabel icono, JLabel iconoPensando, JLabel iconoComiendo, JLabel iconoHambriento) { 
        // inicializa los tenedores
        this.tenedores = new Semaphore[2];
        
        // Por defecto inicia vivo
        this.muerto = 0;
        
        // Iniciamos en ceros con los intentos de comer
        this.intentosComerFallidos = 0;
        
        // carga los elementos graficos del Filosofo
        this.icono = icono;
        this.iconoPensando = iconoPensando;
        this.iconoComiendo = iconoComiendo;
        this.iconoHambriento = iconoHambriento;
    }
    
    /**
     * Cargamos el semaforo para el tenedor izquierdo
     * @param tenedor Semaforo 
     * @return una referencia a la instancia misma
     */
    public Filosofo tenedorIzquierdo(Semaphore tenedor){
        this.tenedores[0] = tenedor;
        return this;
    }
    
    /**
     * Cargamos el semaforo para el tenedor derecho
     * @param tenedor Semaforo 
     * @return una referencia a la instancia misma
     */
    public Filosofo tenedorDerecho(Semaphore tenedor){
        this.tenedores[1] = tenedor;
        return this;
    }
    
    
    public Filosofo comer(){
        // revisa si tenemos acceso al tenedor izquierdo
        if ( this.tenedores[0].tryAcquire() ){
            // Revisa si tenemos acceso al tenedor derecho
            if ( this.tenedores[1].tryAcquire() ){
                // Si ya te toco comer reiniciamos la cuenta de intentos de comer
                this.intentosComerFallidos = 0;
                
                // apagamos el dialogo de hambriento
                this.setHambriento(0);
                
                // prendemos el dialogo de comiendo
                this.setComiendo(1);
                
                try {
                    // Simular el tiempo que tarda el filósofo en comer,
                    // entre 0.5 y 1 segundos:
                    Filosofo.sleep(tiempoAleatorio.nextInt(1000) + 500);
                } catch (InterruptedException ex) {
                    System.out.println("Error : " + ex.toString());
                }
                // Quitamos el dialogo de comiendo
                this.setComiendo(0);
                
                // Despues de comer liberamos los tenedores
                this.tenedores[0].release();
                this.tenedores[1].release();
            }else{
                // liberamos para que lo tome otro que si tenga accesos
                // con esto evitamos deadlocks por resolucion de conflictos
                this.tenedores[0].release();
                this.setHambriento(1);
                
                // Incrementamos la cuenta de intentos de comer
                this.intentosComerFallidos++;
            }
        }else{
            // encendemos el dialogo de hambriento
            this.setHambriento(1);
            
            // Incrementamos la cuenta de intentos de comer
            this.intentosComerFallidos++;
        }
        
        return this;
    }
    
    public Filosofo pensar(){
        // Prendemos el dialogo de pensando
        this.setPensando(1);
        
        try {
            // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
            Filosofo.sleep(tiempoAleatorio.nextInt(1000) + 100);
        } catch (InterruptedException ex) {
            System.out.println("Error en el método pensar(): " + ex.toString());
        }
        
        // Apagamos el dialogo de pensando
        this.setPensando(0);
        
        return this;
    }

    public void setPensando(int pensando) {
        this.iconoPensando.setVisible(pensando==1);
        this.pensando = pensando;
    }

    public void setComiendo(int comiendo) {
        this.iconoComiendo.setVisible(comiendo==1);
        this.comiendo = comiendo;
    }

    public void setHambriento(int hambriento) {
        this.iconoHambriento.setVisible(hambriento==1);
        this.hambriento = hambriento;
    }

    public void setMuerto(int muerto) {
        this.icono.setEnabled(muerto!=1);
        this.muerto = muerto;
    }
    
    @Override
    public void run(){
        while( this.muerto == 0 ){
            this.comer()
                .pensar();
            
            if ( this.intentosComerFallidos >= 10 ){
                this.setMuerto(1);
            }
        }
    }
    
}
