package Grafica;

import Interfacce.InterfacciaArea;
import Interfacce.InterfacciaCentro;
import Interfacce.InterfacciaRilevazione;
import climatemonitoring.*;
import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.rmi.*;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 * Questa classe grafica consente di effettuare la rilevazione su un area di interesse
 */
public class InserimentoRilevazione extends javax.swing.JFrame 
{
    /**
    * Array delle note di ogni rilevazione (vento, umidità, pressione, temperatura, precipitazione, altitudine, massa)
    */
    private String[] note = new String[]{"","","","","","", ""};
    /**
    * Nome del centro di rilevazione associato all'area
    */
    private String nome_centro;
     /**
     *Velocità delvento(km/h),suddivisa in fasce
     */
    private int score_vento;
    /**
     * Umidità % diUmidità,suddivisa in fasce
     */
    private int score_umidita;
    /**
     *Pressione in hPa,suddivisa in fasce
     */
    private int  score_pressione; 
    /**
     *Temperatura in C°,suddivisa in fasce
     */
    private int score_temperatura;
     /**
     *Precipitazioni in mm di pioggia,suddivisa in fasce
     */
    private int score_precipitazioni; 
    /**
     *Altitudine dei ghiacciai in m,suddivisa in piogge
     */
    private int score_altitudine_ghiacciai;
    /**
     *Massa dei ghiacciai in kg,suddivisa in fasce
     */
    private int score_massa_ghiacciai;
    /**
    * Oggetto di tipo timestamp
    */
    private Timestamp timestamp;
    /**
    * Oggetto di tipo rilevazione
    */
    private Rilevazione rilevazione;
    /**
    * Interfaccia dell'oggetto gestione centro 
    */  
    private InterfacciaCentro int_centro;
    /**
    * Interfaccia dell'oggetto gestione rilevazione 
    */  
    private InterfacciaRilevazione int_rilevazione;
    /**
    * Interfaccia dell'oggetto gestione area 
    */  
    private InterfacciaArea int_area;
    /**
     * Riferimento registro
     */
    private Registry reg;
    
    /**
     * Costruttore vuoto della classe
     */  
    public InserimentoRilevazione() {
        initComponents();
    }
    
    /**
     * Costruttore della classe per l'avvio della pagina con la sua inizializzazione grafica e ottenimento oggetti remoti
     * @param centro nome del centro di monitoraggio da cui si effettua la rilevazione
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public InserimentoRilevazione(String centro) throws SQLException, RemoteException, NotBoundException
    {
        initComponents();
        
        ImageIcon imageIcon = new ImageIcon("./Icon/Indietro.png"); 
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_back_accedi.getWidth(), lb_back_accedi.getHeight(), SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        lb_back_accedi.setIcon(imageIcon);
        
        this.nome_centro = centro;
        this.abilita_disabilita(false);
        this.inizializza_combo();
        
        reg = LocateRegistry.getRegistry();
        int_rilevazione = (InterfacciaRilevazione) reg.lookup("rilevazione");
        int_centro = (InterfacciaCentro) reg.lookup("centro");
        int_area = (InterfacciaArea) reg.lookup("area");
    }
    
    /**
     * Metodo per inizializzare la ComboBox con le aree di interesse scelte dal centro.
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    private void inizializza_combo() throws  RemoteException, SQLException
    {
        StringTokenizer st = new StringTokenizer(int_centro.aree_centro(nome_centro),",");  
        while (st.hasMoreTokens())
        {
            String tmp = st.nextToken();
            combo_aree_disponibili.addItem(tmp);
        }   
    }
    
    /**
     * Metodo per abilitare e disabilitare il pannello grafico
     * @param flag variabile booleana per scegliere se abilitare o disabilitare
     */
    private void abilita_disabilita(boolean flag)
    {
        Component[] componenti = pn_rilevazioni.getComponents();
        for (Component componenti1 : componenti) 
        {
            componenti1.setEnabled(flag);
        }
    }

    /**
     * Metodo che reinizzializza il form dopo aver effettuato la rilevazione
     */
    private void reinizzializza_form()
    {
        txt_vento.setText("");
        txt_umidita.setText("");
        txt_pressione.setText("");
        txt_temperatura.setText("");
        txt_precipitazioni.setText("");
        txt_altitudine_ghiacciai.setText("");
        txt_massa_ghiacciai.setText("");
        combo_vento.setSelectedIndex(0);
        combo_pressione.setSelectedIndex(0);
        combo_umidita.setSelectedIndex(0);
        combo_temperatura.setSelectedIndex(0);
        combo_precipitazioni.setSelectedIndex(0);
        combo_altitudine_ghiacciai.setSelectedIndex(0);
        combo_massa_ghiacciai.setSelectedIndex(0); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        procedi_rilevazione_area = new javax.swing.JButton();
        pn_rilevazioni = new javax.swing.JPanel();
        txt_vento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo_vento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_umidita = new javax.swing.JComboBox<>();
        txt_umidita = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combo_pressione = new javax.swing.JComboBox<>();
        combo_precipitazioni = new javax.swing.JComboBox<>();
        combo_temperatura = new javax.swing.JComboBox<>();
        combo_altitudine_ghiacciai = new javax.swing.JComboBox<>();
        combo_massa_ghiacciai = new javax.swing.JComboBox<>();
        txt_pressione = new javax.swing.JTextField();
        txt_precipitazioni = new javax.swing.JTextField();
        txt_temperatura = new javax.swing.JTextField();
        txt_altitudine_ghiacciai = new javax.swing.JTextField();
        txt_massa_ghiacciai = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        inserisci_rilevazione = new javax.swing.JButton();
        combo_aree_disponibili = new javax.swing.JComboBox<>();
        lb_back_accedi = new javax.swing.JLabel();
        pn1 = new javax.swing.JPanel();
        Titolo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Area:");

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scegli l'area su cui effettuare la rilevazione");

        procedi_rilevazione_area.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        procedi_rilevazione_area.setText("Procedi con la rilevazione");
        procedi_rilevazione_area.setFocusPainted(false);
        procedi_rilevazione_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procedi_rilevazione_areaActionPerformed(evt);
            }
        });

        pn_rilevazioni.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Score");

        combo_vento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Note (max 256 caratteri, opzionale)");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Vento (km/h)");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Umidità (%)");

        combo_umidita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pressione (hPa)");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Temperatura (°C)");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Precipitazioni (mm)");

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Altitudine ghiacciai (m)");

        combo_pressione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        combo_precipitazioni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        combo_temperatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        combo_altitudine_ghiacciai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        combo_massa_ghiacciai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Massa ghiacciai (m)");

        inserisci_rilevazione.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        inserisci_rilevazione.setText("Inserisci la rilevazione");
        inserisci_rilevazione.setFocusPainted(false);
        inserisci_rilevazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserisci_rilevazioneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_rilevazioniLayout = new javax.swing.GroupLayout(pn_rilevazioni);
        pn_rilevazioni.setLayout(pn_rilevazioniLayout);
        pn_rilevazioniLayout.setHorizontalGroup(
            pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_rilevazioniLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_pressione, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(24, 24, 24)
                                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(combo_vento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_umidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_pressione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_rilevazioniLayout.createSequentialGroup()
                                .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10))
                                .addGap(23, 23, 23)
                                .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_altitudine_ghiacciai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_precipitazioni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_vento)
                            .addComponent(txt_umidita)
                            .addComponent(txt_temperatura)
                            .addComponent(txt_precipitazioni)
                            .addComponent(txt_altitudine_ghiacciai)))
                    .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inserisci_rilevazione)
                            .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(combo_massa_ghiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_massa_ghiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        pn_rilevazioniLayout.setVerticalGroup(
            pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_rilevazioniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_rilevazioniLayout.createSequentialGroup()
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_vento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_vento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_umidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txt_umidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(combo_pressione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pressione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(combo_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(combo_precipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_precipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(combo_altitudine_ghiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_altitudine_ghiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_rilevazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_massa_ghiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_massa_ghiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(inserisci_rilevazione, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lb_back_accedi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_back_accedi.setOpaque(true);
        lb_back_accedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_back_accediMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addComponent(pn_rilevazioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(procedi_rilevazione_area)
                            .addGroup(pn2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(combo_aree_disponibili, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(193, 193, 193))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_back_accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_aree_disponibili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(procedi_rilevazione_area)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_rilevazioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lb_back_accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        Titolo3.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo3.setForeground(new java.awt.Color(0, 153, 255));
        Titolo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo3.setText("Rilevazione");

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titolo3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
     * Questo metodo viene eseguito una volgta che abbiamo scleto l'area su cui effettuare la rilevazione.
     * Premette di sbloccare il pannello delle rilezioni.
     * @param evt evento scatenato
     */
    private void procedi_rilevazione_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procedi_rilevazione_areaActionPerformed
        this.abilita_disabilita(true);
        JOptionPane.showMessageDialog(null, "Procedi inserendo i dati della rilevazione nell'area", "Procedi", JOptionPane.INFORMATION_MESSAGE);
        combo_aree_disponibili.setEnabled(false);
        procedi_rilevazione_area.setEnabled(false);
    }//GEN-LAST:event_procedi_rilevazione_areaActionPerformed
    
    /**
     * Questo metodo permette di registrare la rilevazione se corretta nel db
     * @param evt evento scatenato
     */
    private void inserisci_rilevazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserisci_rilevazioneActionPerformed
        score_vento = Integer.parseInt(String.valueOf(combo_vento.getSelectedItem()));
        score_umidita = Integer.parseInt(String.valueOf(combo_umidita.getSelectedItem()));
        score_pressione = Integer.parseInt(String.valueOf(combo_pressione.getSelectedItem()));
        score_temperatura = Integer.parseInt(String.valueOf(combo_temperatura.getSelectedItem()));
        score_precipitazioni = Integer.parseInt(String.valueOf(combo_precipitazioni.getSelectedItem()));
        score_altitudine_ghiacciai = Integer.parseInt(String.valueOf(combo_altitudine_ghiacciai.getSelectedItem()));
        score_massa_ghiacciai = Integer.parseInt(String.valueOf(combo_massa_ghiacciai.getSelectedItem()));
        
        note[0] = txt_vento.getText();
        note[1] = txt_umidita.getText();
        note[2] = txt_pressione.getText();
        note[3] = txt_temperatura.getText(); 
        note[4] = txt_precipitazioni.getText();
        note[5] = txt_altitudine_ghiacciai.getText();
        note[6] = txt_massa_ghiacciai.getText();
        
        Date date = new Date(); 
        timestamp = new Timestamp(date.getTime());
        
        rilevazione = new Rilevazione();
        try 
        {
            if(int_rilevazione.controlli_note(note).equals(""))
            {
                for(int i = 0; i < 7; i++)
                {
                    if(note[i].equals(""))
                    {
                        note[i] = " ";
                    }
                }
                 
                String sigla = "", area = "";
                StringTokenizer st = new StringTokenizer(String.valueOf(combo_aree_disponibili.getSelectedItem()),"-");  
                while (st.hasMoreTokens())
                {
                    sigla = st.nextToken();
                    area = st.nextToken();
                    int_area.setArea(new AreaInteresse (area, sigla));
                }  
                
                int codice_area = int_area.recuperaGeocode(sigla, area);
                rilevazione = new Rilevazione(nome_centro, codice_area, timestamp, score_vento, score_umidita, score_pressione, score_temperatura, score_precipitazioni, score_altitudine_ghiacciai, score_massa_ghiacciai, note);
                int_rilevazione.setRilevazione(rilevazione);
                int_rilevazione.registra_rilevazione();

                JOptionPane.showMessageDialog(null, "Rilevazione registrata con successo.\n Procedi a effettuare una nuova rilevazione", "Procedi", JOptionPane.INFORMATION_MESSAGE);
                combo_aree_disponibili.setEnabled(true);
                procedi_rilevazione_area.setEnabled(true);
                this.abilita_disabilita(false);
                this.reinizzializza_form();
            }  
            else
            {
                JOptionPane.showMessageDialog(null, "La nota su " + int_rilevazione.controlli_note(note)  + " che hai inserito è troppo lunga, reinseriscine una più corta", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | RemoteException ex) { Logger.getLogger(InserimentoRilevazione.class.getName()).log(Level.SEVERE, null, ex); }   
    }//GEN-LAST:event_inserisci_rilevazioneActionPerformed
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
        } catch (RemoteException | NotBoundException ex) { Logger.getLogger(InserimentoRilevazione.class.getName()).log(Level.SEVERE, null, ex);}       
    }//GEN-LAST:event_lb_back_accediMouseClicked

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
            java.util.logging.Logger.getLogger(InserimentoRilevazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserimentoRilevazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserimentoRilevazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserimentoRilevazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserimentoRilevazione().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titolo3;
    private javax.swing.JComboBox<String> combo_altitudine_ghiacciai;
    private javax.swing.JComboBox<String> combo_aree_disponibili;
    private javax.swing.JComboBox<String> combo_massa_ghiacciai;
    private javax.swing.JComboBox<String> combo_precipitazioni;
    private javax.swing.JComboBox<String> combo_pressione;
    private javax.swing.JComboBox<String> combo_temperatura;
    private javax.swing.JComboBox<String> combo_umidita;
    private javax.swing.JComboBox<String> combo_vento;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton inserisci_rilevazione;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_back_accedi;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn_rilevazioni;
    private javax.swing.JButton procedi_rilevazione_area;
    public javax.swing.JTextField txt_altitudine_ghiacciai;
    public javax.swing.JTextField txt_massa_ghiacciai;
    public javax.swing.JTextField txt_precipitazioni;
    public javax.swing.JTextField txt_pressione;
    public javax.swing.JTextField txt_temperatura;
    public javax.swing.JTextField txt_umidita;
    public javax.swing.JTextField txt_vento;
    // End of variables declaration//GEN-END:variables
}
