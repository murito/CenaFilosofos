
package cenafilosofos;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Francisco Javier Alcalá Olivares
 */
public class Ventana extends JFrame{
    public Ventana(){
        this.configurar();
    }
      
    /**
     * Configuramos la ventana para que se muestre en el tamaño y con las
     * condiciones deseadas
     */
    private void configurar(){
        // Creamos una instancia del escenario
        Escenario escena = new Escenario();
        
        // Iniciamos la creación de los filosofos y los traemos a la vida
        escena.iniciar();
        
        // Agregamos la escena a la ventana ocupando todo el espacio disponible
        this.add(escena, BorderLayout.CENTER);
        
        // Bueno pues esta linea no necesita el comentario xD
        this.setTitle("Cena Filosofos");
        
        this.setSize(960, 540);
        this.setResizable(false);
        
        // Definimos que termine la aplicacion al hacer click en el icono de salir
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
