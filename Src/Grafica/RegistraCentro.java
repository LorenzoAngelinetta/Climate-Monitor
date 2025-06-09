package Grafica;

import Interfacce.InterfacciaArea;
import Interfacce.InterfacciaCentro;
import climatemonitoring.*;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.rmi.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
* Questa classe grafica consente di effettuare registrare il centro di monitoraggio
*/
public class RegistraCentro extends javax.swing.JFrame 
{
   /**
     * Nome del centro di monitoraggio.
     */
    private String nome_centro;
    /**
     * Via o piazza in cui è situato il centro di monitoraggio.
     */
    private String via_piazza;
    /**
     * Comune in cui è situato il centro di monitoraggio.
     */
    private String comune;
    /**
     * Provincia in cui è situato il centro di monitoraggio.
     */
    private String provincia;
    /**
     * Aree di interesse di cui si occupa il centro di monitoraggio.
     */
    private String aree = "";
    /**
     * Numero civico della via in cui è situato il centro di monitoraggio.
     */
    private int numero_civico;
    /**
     * Cap del paese in cui è situato il centro di monitoraggio.
     */
    private String cap;
    /**
     * UserId dell'operatore associato al centro.
     */
    private int id;
    /**
    * Numero aree di interesse da registare per il centro di monitoraggio.
    */
    private int numero_aree;
    /**
    * Sigla stato area di interesse di cui si occupa il centro di monitoraggio.
    */
    private String stato;
    /**
    * Nome singola area di interesse di cui si occupa il centro di monitoraggio.
    */
    private String nome_area;
    /**
     * variabile count
     */
    private int count = 0;
    /**
    * Oggetto di tipo area di interesse
    */
    private AreaInteresse localita;
    /**
    * Oggetto di tipo centro monitoragio
    */
    private CentroMonitoraggio centro;
    /**
     * Riferimento registro
     */
    private Registry reg;
    /**
    * Interfaccia dell'oggetto gestione centro 
    */      
    private InterfacciaCentro int_centro;
    /**
    * Interfaccia dell'oggetto gestione area 
    */      
    private InterfacciaArea int_area;
    
    /**
    * Costruttore vuoto
     */
    public RegistraCentro() {
        initComponents();
    }
    
    /**
     * Costruttore della classe per l'avvio della pagina con la sua inizializzazione grafica e ottenimento oggetti remoti
     * @param id userid dell'operatore utilizzato per poterlo associare al centro
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @throws NotBoundException eccezione per oggetti remoti
     */
    public RegistraCentro(int id) throws SQLException, RemoteException, NotBoundException 
    {
        initComponents();
        
        ImageIcon imageIcon = new ImageIcon("./Icon/Indietro.png"); 
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_back_accedi.getWidth(), lb_back_accedi.getHeight(), SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        lb_back_accedi.setIcon(imageIcon);
        
        this.registra_centro.setEnabled(false);
        this.txt_nome_centro.setEnabled(false);
        this.txt_via_piazza.setEnabled(false);
        this.txt_cap.setEnabled(false);
        this.txt_numero_civico.setEnabled(false);
        this.txt_provincia.setEnabled(false);
        this.txt_comune.setEnabled(false);
        
        this.id = id;
        
        reg = LocateRegistry.getRegistry();
        int_area = (InterfacciaArea) reg.lookup("area");
        int_centro = (InterfacciaCentro) reg.lookup("centro");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new javax.swing.JPanel();
        Titolo3 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        registra_centro = new javax.swing.JButton();
        pn3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_stato = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_nomearea = new javax.swing.JTextField();
        registra_area = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_numeroaree = new javax.swing.JTextField();
        label_numero = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lb_back_accedi = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_provincia = new javax.swing.JTextField();
        txt_comune = new javax.swing.JTextField();
        txt_cap = new javax.swing.JTextField();
        txt_numero_civico = new javax.swing.JTextField();
        txt_via_piazza = new javax.swing.JTextField();
        txt_nome_centro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        Titolo3.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo3.setForeground(new java.awt.Color(0, 153, 255));
        Titolo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo3.setText("Registra centro");

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titolo3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Registra centro di monitoraggio");

        registra_centro.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        registra_centro.setText("Registra centro");
        registra_centro.setFocusPainted(false);
        registra_centro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registra_centroActionPerformed(evt);
            }
        });

        pn3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Numero aree");

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Sigla stato");

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Nome area");

        registra_area.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        registra_area.setText("Inserisci area");
        registra_area.setFocusPainted(false);
        registra_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registra_areaMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Aree rimanenti: ");

        label_numero.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_numero.setForeground(new java.awt.Color(255, 255, 255));
        label_numero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("(iniziale maiusc)");

        javax.swing.GroupLayout pn3Layout = new javax.swing.GroupLayout(pn3);
        pn3.setLayout(pn3Layout);
        pn3Layout.setHorizontalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_numeroaree, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pn3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addComponent(registra_area)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn3Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                    .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_stato, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addComponent(txt_nomearea, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                    .addGap(5, 5, 5)))
        );
        pn3Layout.setVerticalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_numeroaree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registra_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
            .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn3Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txt_stato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txt_nomearea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(71, Short.MAX_VALUE)))
        );

        lb_back_accedi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_back_accedi.setOpaque(true);
        lb_back_accedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_back_accediMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nome centro");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Via/Piazza");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Numero civico");

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CAP");

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Comune");

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Provincia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome_centro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_via_piazza, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numero_civico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_comune, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_nome_centro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_via_piazza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_numero_civico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_cap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_comune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_back_accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(registra_centro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(registra_centro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_back_accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Questo metodo è utilizzato per registrare il centro di monitoraggio.
     * @param evt evento scatenato
     */
    private void registra_centroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registra_centroActionPerformed
        nome_centro = txt_nome_centro.getText();
        via_piazza = txt_via_piazza.getText();
        try
        {
            numero_civico = Integer.parseInt(txt_numero_civico.getText());
            
        }
        catch(NumberFormatException ex){}
        cap =txt_cap.getText();
        comune = txt_comune.getText();
        provincia = txt_provincia.getText();
        
        centro = new CentroMonitoraggio(nome_centro, via_piazza, numero_civico, cap, comune, provincia); 
        try 
        {
            int_centro.setCentro(centro);
            if(int_centro.ritorna_errore().equals(""))
            {
                int_centro.registra_centroMonitoraggio();
                int_centro.aggiungi_centro_a_operatore(nome_centro, id);
                int_area.inserisci_area(nome_centro, aree);
                JOptionPane.showMessageDialog(null, "Centro di monitoraggio aggiunto", "Procedi", JOptionPane.INFORMATION_MESSAGE);
                InserimentoRilevazione inserimento_parametri_area = new InserimentoRilevazione(nome_centro);
                inserimento_parametri_area.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, int_centro.ritorna_errore(), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException | RemoteException | NotBoundException ex) { Logger.getLogger(RegistraCentro.class.getName()).log(Level.SEVERE, null, ex);} 
    }//GEN-LAST:event_registra_centroActionPerformed

   /**
     * Questo metodo è utilizzato per andare alla pagina precedente.
     * @param evt evento scatenato
     */
    private void lb_back_accediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_back_accediMouseClicked
        try 
        {
            AccediOperatore accedi = new AccediOperatore();
            accedi.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException | NotBoundException ex) { Logger.getLogger(RegistraCentro.class.getName()).log(Level.SEVERE, null, ex); }  
    }//GEN-LAST:event_lb_back_accediMouseClicked

    /**
     * Questo metodo è utilizzato per registrare la singola area di interesse.
     * Le aree vengono salvate in suna stringa che poi viene concatenanta con l'area successiva.
     * Una volta registrate tutte le aree viene bloccato il form.
     * @param evt evento scatenato
     */
    private void registra_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registra_areaMouseClicked
        try
        {
            numero_aree = Integer.parseInt(txt_numeroaree.getText());
        }
        catch(NumberFormatException ex){}
        nome_area = txt_nomearea.getText();
        stato = txt_stato.getText();
        
        
        localita = new AreaInteresse(nome_area, stato);
        try 
        {
            int_area.setArea(localita);
            if(int_area.ritorna_errore(numero_aree).equals(""))
            {
                this.txt_numeroaree.setEnabled(false);
                if(aree.contains(nome_area +"-"+txt_stato.getText().toUpperCase() ))
                {
                    JOptionPane.showMessageDialog(null, "Area di interesse già inserita, reinseriscine una nuova", "Errore", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Area di interesse inserita con successo", "Procedi", JOptionPane.INFORMATION_MESSAGE);
                    int tmp = numero_aree - count - 1;
                    this.label_numero.setText("" + tmp );
                    count++;
                    if(aree.equals(""))
                    {
                        aree = nome_area + "-" + txt_stato.getText().toUpperCase();
                    }
                    else
                    {
                        aree = aree + "," + nome_area + "-" + txt_stato.getText().toUpperCase();
                    }
                    
                    if((numero_aree - count) == 0)
                    {
                        this.registra_area.setEnabled(false);
                        this.registra_centro.setEnabled(true);
                        this.txt_nomearea.setEnabled(false);
                        this.txt_stato.setEnabled(false);
                        this.txt_nome_centro.setEnabled(true);
                        this.txt_via_piazza.setEnabled(true);
                        this.txt_cap.setEnabled(true);
                        this.txt_numero_civico.setEnabled(true);
                        this.txt_provincia.setEnabled(true);
                        this.txt_comune.setEnabled(true);
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, int_area.ritorna_errore(numero_aree), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException | RemoteException ex) {Logger.getLogger(RegistraCentro.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_registra_areaMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistraCentro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titolo3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_numero;
    private javax.swing.JLabel lb_back_accedi;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JButton registra_area;
    private javax.swing.JButton registra_centro;
    public javax.swing.JTextField txt_cap;
    public javax.swing.JTextField txt_comune;
    public javax.swing.JTextField txt_nome_centro;
    public javax.swing.JTextField txt_nomearea;
    public javax.swing.JTextField txt_numero_civico;
    public javax.swing.JTextField txt_numeroaree;
    public javax.swing.JTextField txt_provincia;
    public javax.swing.JTextField txt_stato;
    public javax.swing.JTextField txt_via_piazza;
    // End of variables declaration//GEN-END:variables
}
