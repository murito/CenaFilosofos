
package cenafilosofos;

import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Francisco Javier Alcalá Olivares
 */
public final class Escenario extends javax.swing.JPanel {
    private Image background;
    private final int numeroFilosofos;
    private final Semaphore[] tenedores;
    private JLabel[] iconoscomensales;
    private JLabel[] iconosHambre;
    private JLabel[] iconosComiendo;
    private JLabel[] iconosPensando;
    
    /**
     * Creamos el escenario de la aplicacion
     */
    public Escenario() {
        // Lainterfaz grafica esta diseñada para 5 pero para fines de modularidad
        //definimos desde aqui la cantidad de filosofos
        this.numeroFilosofos = 5;
        
        // Creamos los semaforos para cada tenedor
        this.tenedores = new Semaphore[this.numeroFilosofos];
    }
    
    /**
     * Inicia con toda la carga de componentes y creacion de los filosofos
     */
    public void iniciar(){
        // Creamos la maqueta del escenario esto fue con la interfaz 
        // WSWG para no durar mil años acomodando todo xD
        initComponents();
        
        // Inicia las matrices que contienen los componentes de la maqueta
        this.iniciaMatricesComponentes();
        
        // Ocultamos los elementos de interaccion con los filosofos
        this.ocultarAlIncio();
        
        // Creamos los tenedores y asigamos el permiso de acceso
        for(int i=0;i<this.numeroFilosofos; i++){
            // Creamos un semaforo con un solo permiso por que solo un 
            // filosofo lo puede tener a la vez
            this.tenedores[i] = new Semaphore(1);
        }
        
        // creamos los filosofos y les asignamos sus tenedores
        for(int i=0;i<this.numeroFilosofos; i++){  
            // contabilizamos los tenedores para que al ultimo comenzal le toque
            // el tenedor 5 y el 1 
            int tenedorAdjunto = (i<4)?i+1:0;
            new Filosofo(this.iconoscomensales[i], 
                         this.iconosPensando[i],
                         this.iconosComiendo[i],
                         this.iconosHambre[i]
            ).tenedorIzquierdo(this.tenedores[i])
             .tenedorDerecho(this.tenedores[tenedorAdjunto])
             .start();
        }
    }

    /**
     * Oculta los elementos de interaccion con los filosofos que no 
     * tiene sentido mostrar al inicio
     */
    private void ocultarAlIncio(){
        // Ocultamos los dialogos de hambre
        this.hambre1.setVisible(false);
        this.hambre2.setVisible(false);
        this.hambre3.setVisible(false);
        this.hambre4.setVisible(false);
        this.hambre5.setVisible(false);
        
        // Ocultamos los dialogos de comiendo
        this.comiendo1.setVisible(false);
        this.comiendo2.setVisible(false);
        this.comiendo3.setVisible(false);
        this.comiendo4.setVisible(false);
        this.comiendo5.setVisible(false);
        
        // Ocultamos los dialogos de pensando
        this.pensando1.setVisible(false);
        this.pensando2.setVisible(false);
        this.pensando3.setVisible(false);
        this.pensando4.setVisible(false);
        this.pensando5.setVisible(false);
    }
    
    /**
     * Crea las matrices de componentes de la maqueta para poder asignarlos
     * a un filosofo de manera dinamica mediante sentencias for
     */
    private void iniciaMatricesComponentes(){
        // Creamos un arreglo de iconos para asignarlos mas adelante
        this.iconoscomensales = new JLabel[this.numeroFilosofos];
        this.iconosComiendo = new JLabel[this.numeroFilosofos];
        this.iconosPensando = new JLabel[this.numeroFilosofos];
        this.iconosHambre = new JLabel[this.numeroFilosofos];
        
        // Llenamos arreglo de comensales para poder asignarlos dinamicamente con un for
        this.iconoscomensales[0] = this.comenzal1;
        this.iconoscomensales[1] = this.comenzal2;
        this.iconoscomensales[2] = this.comenzal3;
        this.iconoscomensales[3] = this.comenzal4;
        this.iconoscomensales[4] = this.comenzal5;
        
        // Llenamos arreglo de iconosComiendo para poder asignarlos dinamicamente con un for
        this.iconosComiendo[0] = this.comiendo1;
        this.iconosComiendo[1] = this.comiendo2;
        this.iconosComiendo[2] = this.comiendo3;
        this.iconosComiendo[3] = this.comiendo4;
        this.iconosComiendo[4] = this.comiendo5;
        
        // Llenamos arreglo de icocnosPensando para poder asignarlos dinamicamente con un for
        this.iconosPensando[0] = this.pensando1;
        this.iconosPensando[1] = this.pensando2;
        this.iconosPensando[2] = this.pensando3;
        this.iconosPensando[3] = this.pensando4;
        this.iconosPensando[4] = this.pensando5;
        
        // Llenamos arreglo de iconosHambre para poder asignarlos dinamicamente con un for
        this.iconosHambre[0] = this.hambre1;
        this.iconosHambre[1] = this.hambre2;
        this.iconosHambre[2] = this.hambre3;
        this.iconosHambre[3] = this.hambre4;
        this.iconosHambre[4] = this.hambre5;
    }
    
    @Override
    public void paintComponent(Graphics g){
        // dibujamos el fondo de la maqueta para que se vea bonito xD
        this.background = new ImageIcon(Escenario.class.getResource("/images/bg.jpeg")).getImage();
        g.drawImage(this.background, 0, 0, null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        comenzal1 = new javax.swing.JLabel();
        comenzal2 = new javax.swing.JLabel();
        comenzal3 = new javax.swing.JLabel();
        comenzal4 = new javax.swing.JLabel();
        comenzal5 = new javax.swing.JLabel();
        hambre1 = new javax.swing.JLabel();
        hambre2 = new javax.swing.JLabel();
        hambre3 = new javax.swing.JLabel();
        hambre4 = new javax.swing.JLabel();
        hambre5 = new javax.swing.JLabel();
        tenedor1 = new javax.swing.JLabel();
        tenedor2 = new javax.swing.JLabel();
        tenedor3 = new javax.swing.JLabel();
        tenedor4 = new javax.swing.JLabel();
        tenedor5 = new javax.swing.JLabel();
        comida1 = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        comida3 = new javax.swing.JLabel();
        comida4 = new javax.swing.JLabel();
        comida5 = new javax.swing.JLabel();
        mesa = new javax.swing.JLabel();
        comiendo5 = new javax.swing.JLabel();
        comiendo4 = new javax.swing.JLabel();
        comiendo1 = new javax.swing.JLabel();
        comiendo2 = new javax.swing.JLabel();
        pensando1 = new javax.swing.JLabel();
        pensando2 = new javax.swing.JLabel();
        pensando3 = new javax.swing.JLabel();
        comiendo3 = new javax.swing.JLabel();
        pensando5 = new javax.swing.JLabel();
        pensando4 = new javax.swing.JLabel();

        comenzal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comenzal1.png"))); // NOI18N
        jLayeredPane1.add(comenzal1);
        comenzal1.setBounds(280, 180, 92, 90);

        comenzal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comenzal2.png"))); // NOI18N
        jLayeredPane1.add(comenzal2);
        comenzal2.setBounds(340, 320, 80, 110);

        comenzal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comenzal3.png"))); // NOI18N
        jLayeredPane1.add(comenzal3);
        comenzal3.setBounds(530, 320, 79, 110);

        comenzal4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comenzal4.png"))); // NOI18N
        jLayeredPane1.add(comenzal4);
        comenzal4.setBounds(570, 170, 108, 90);

        comenzal5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comenzal5.png"))); // NOI18N
        jLayeredPane1.add(comenzal5);
        comenzal5.setBounds(440, 50, 88, 120);

        hambre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hambre1.png"))); // NOI18N
        jLayeredPane1.add(hambre1);
        hambre1.setBounds(250, 140, 52, 50);

        hambre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hambre2.png"))); // NOI18N
        jLayeredPane1.add(hambre2);
        hambre2.setBounds(280, 370, 60, 60);

        hambre3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hambre3.png"))); // NOI18N
        jLayeredPane1.add(hambre3);
        hambre3.setBounds(610, 360, 63, 50);

        hambre4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hambre4.png"))); // NOI18N
        jLayeredPane1.add(hambre4);
        hambre4.setBounds(640, 120, 57, 70);

        hambre5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hambre5.png"))); // NOI18N
        jLayeredPane1.add(hambre5);
        hambre5.setBounds(500, 20, 64, 60);

        tenedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tenedor1.png"))); // NOI18N
        jLayeredPane1.add(tenedor1);
        tenedor1.setBounds(380, 140, 47, 60);

        tenedor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tenedor2.png"))); // NOI18N
        jLayeredPane1.add(tenedor2);
        tenedor2.setBounds(520, 150, 45, 60);

        tenedor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tenedor3.png"))); // NOI18N
        jLayeredPane1.add(tenedor3);
        tenedor3.setBounds(550, 260, 65, 50);

        tenedor4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tenedor4.png"))); // NOI18N
        jLayeredPane1.add(tenedor4);
        tenedor4.setBounds(460, 340, 27, 70);

        tenedor5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tenedor5.png"))); // NOI18N
        jLayeredPane1.add(tenedor5);
        tenedor5.setBounds(330, 270, 68, 40);

        comida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comida.png"))); // NOI18N
        jLayeredPane1.add(comida1);
        comida1.setBounds(380, 210, 52, 60);

        comida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comida.png"))); // NOI18N
        jLayeredPane1.add(comida2);
        comida2.setBounds(400, 300, 52, 60);

        comida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comida.png"))); // NOI18N
        jLayeredPane1.add(comida3);
        comida3.setBounds(510, 300, 52, 60);

        comida4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comida.png"))); // NOI18N
        jLayeredPane1.add(comida4);
        comida4.setBounds(530, 200, 52, 70);

        comida5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comida.png"))); // NOI18N
        jLayeredPane1.add(comida5);
        comida5.setBounds(450, 140, 52, 60);

        mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mesa.png"))); // NOI18N
        jLayeredPane1.add(mesa);
        mesa.setBounds(250, 60, 440, 380);

        comiendo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comiendo.png"))); // NOI18N
        jLayeredPane1.add(comiendo5);
        comiendo5.setBounds(510, 40, 110, 28);

        comiendo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comiendo.png"))); // NOI18N
        jLayeredPane1.add(comiendo4);
        comiendo4.setBounds(640, 150, 110, 28);

        comiendo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comiendo.png"))); // NOI18N
        jLayeredPane1.add(comiendo1);
        comiendo1.setBounds(200, 160, 115, 28);

        comiendo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comiendo.png"))); // NOI18N
        jLayeredPane1.add(comiendo2);
        comiendo2.setBounds(230, 390, 110, 28);

        pensando1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pensando.png"))); // NOI18N
        jLayeredPane1.add(pensando1);
        pensando1.setBounds(190, 220, 100, 34);

        pensando2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pensando.png"))); // NOI18N
        jLayeredPane1.add(pensando2);
        pensando2.setBounds(350, 440, 110, 34);

        pensando3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pensando.png"))); // NOI18N
        jLayeredPane1.add(pensando3);
        pensando3.setBounds(540, 430, 110, 34);

        comiendo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comiendo.png"))); // NOI18N
        jLayeredPane1.add(comiendo3);
        comiendo3.setBounds(610, 380, 110, 28);

        pensando5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pensando.png"))); // NOI18N
        jLayeredPane1.add(pensando5);
        pensando5.setBounds(360, 40, 106, 34);

        pensando4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pensando.png"))); // NOI18N
        jLayeredPane1.add(pensando4);
        pensando4.setBounds(650, 220, 100, 34);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comenzal1;
    private javax.swing.JLabel comenzal2;
    private javax.swing.JLabel comenzal3;
    private javax.swing.JLabel comenzal4;
    private javax.swing.JLabel comenzal5;
    private javax.swing.JLabel comida1;
    private javax.swing.JLabel comida2;
    private javax.swing.JLabel comida3;
    private javax.swing.JLabel comida4;
    private javax.swing.JLabel comida5;
    private javax.swing.JLabel comiendo1;
    private javax.swing.JLabel comiendo2;
    private javax.swing.JLabel comiendo3;
    private javax.swing.JLabel comiendo4;
    private javax.swing.JLabel comiendo5;
    private javax.swing.JLabel hambre1;
    private javax.swing.JLabel hambre2;
    private javax.swing.JLabel hambre3;
    private javax.swing.JLabel hambre4;
    private javax.swing.JLabel hambre5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel mesa;
    private javax.swing.JLabel pensando1;
    private javax.swing.JLabel pensando2;
    private javax.swing.JLabel pensando3;
    private javax.swing.JLabel pensando4;
    private javax.swing.JLabel pensando5;
    private javax.swing.JLabel tenedor1;
    private javax.swing.JLabel tenedor2;
    private javax.swing.JLabel tenedor3;
    private javax.swing.JLabel tenedor4;
    private javax.swing.JLabel tenedor5;
    // End of variables declaration//GEN-END:variables
}
