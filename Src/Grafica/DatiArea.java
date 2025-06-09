package Grafica;

import Interfacce.InterfacciaArea;
import Interfacce.InterfacciaRilevazione;
import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.rmi.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;

/**
* Questa classe grafica consente di vedere i vari paramentri delle rilevazioni
*/
public class DatiArea extends javax.swing.JFrame 
{
     /**
     * Tabella vento.
     */
    public DefaultTableModel model_vento; 
    /**
     * Tabella umidità.
     */
    public DefaultTableModel model_umidita;
    /**
     * Tabella pressione.
     */
    public DefaultTableModel model_pressione; 
    /**
     * Tabella temperatura.
     */
    public DefaultTableModel model_temperatura; 
    /**
     * Tabella precipitazioni.
     */
    public DefaultTableModel model_precipitazioni; 
    /**
     * Tabella altitudine ghiacciai.
     */
    public DefaultTableModel model_alt_ghiacciai; 
    /**
     * Tabella massa ghiacciai.
     */
    public DefaultTableModel model_m_ghiacciai; 
    /**
     * Tabella media.
     */
    public DefaultTableModel model_media;
    /**
     * Tabella massimi.
     */
    public DefaultTableModel model_massimi;
    /**
     * Tabella minimi.
     */
    public DefaultTableModel model_minimi;
    /**
     * Tabella moda.
     */
    public DefaultTableModel model_moda;   
    /**
     * Interfaccia classe che serve a modellare la classe area
     */
    private InterfacciaArea int_area;
    /**
     * Interfaccia classe che serve a modellare la classe rilevazione
     */
    private InterfacciaRilevazione int_rilevazione;
    /**
     * Riferimento registro
     */
    private Registry reg;
    
    /**
     * Costruttore vuoto
     */
    public DatiArea() {
        initComponents();
    }
    /**
     * Costruttore della classe per l'avvio della pagina con la sua inizializzazione grafica della tabella e ottenimento oggetti remoti
     * @param citta_selezionata nome dell'area su cui è fatta la rilevazione
     * @param stato stato dell'area su cui è fatta la rilevazione
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @throws NotBoundException eccezione per oggetti remoti
     */
    public DatiArea(String citta_selezionata, String stato) throws SQLException, RemoteException, NotBoundException
    {
        initComponents();

        ImageIcon imageIcon = new ImageIcon("./Icon/Indietro.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_back_home.getWidth(), lb_back_home.getHeight(), SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        lb_back_home.setIcon(imageIcon);

        model_vento = (DefaultTableModel) tabella_vento.getModel();
        model_umidita = (DefaultTableModel) tabella_umidita.getModel();
        model_pressione = (DefaultTableModel) tabella_pressione.getModel();
        model_temperatura = (DefaultTableModel) tabella_temperatura.getModel();
        model_precipitazioni = (DefaultTableModel) tabella_precipitazioni.getModel();
        model_alt_ghiacciai = (DefaultTableModel) tabella_alt_ghiacciai.getModel();
        model_m_ghiacciai = (DefaultTableModel) tabella_m_ghiacciai.getModel();
        model_media = (DefaultTableModel) tabella_medie.getModel();
        model_massimi = (DefaultTableModel) tabella_massimi.getModel();
        model_minimi = (DefaultTableModel) tabella_minimi.getModel();
        model_moda = (DefaultTableModel) tabella_moda.getModel();
        
        reg = LocateRegistry.getRegistry();
        int_rilevazione = (InterfacciaRilevazione) reg.lookup("rilevazione");
        int_area = (InterfacciaArea) reg.lookup("area");
        
        int geocode = int_area.recuperaGeocode(stato, citta_selezionata);
        this.inizializza_tabella(geocode, citta_selezionata + "-" + stato);

        int massimi[] = int_rilevazione.trovaMassimo(geocode);
        int minimi[] = int_rilevazione.trovaMinimo(geocode);
        double medie[] = int_rilevazione.trovaMedie(geocode);
        int mode[] = int_rilevazione.trovaMode(geocode);
        
        model_media.insertRow(model_media.getRowCount(), new Object[]{medie[0], medie[1], medie[2], medie[3], medie[4], medie[5], medie[6]});
        model_massimi.insertRow(model_massimi.getRowCount(), new Object[]{massimi[0], massimi[1], massimi[2], massimi[3], massimi[4], massimi[5], massimi[6]});
        model_minimi.insertRow(model_minimi.getRowCount(), new Object[]{minimi[0], minimi[1], minimi[2], minimi[3], minimi[4], minimi[5], minimi[6]});
        model_moda.insertRow(model_moda.getRowCount(), new Object[]{mode[0], mode[1], mode[2], mode[3], mode[4], mode[5], mode[6]});
    }
    
    /**
     * Metodo che inserisce i risultati in tabella
     * @param geocode codice dell'area
     * @param area stringa dell'area
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    private void inizializza_tabella(int geocode, String area) throws SQLException, RemoteException
    {
        StringTokenizer str1;
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 0), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_vento.insertRow(model_vento.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }
        
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 1), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_umidita.insertRow(model_umidita.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }
        
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 2), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_pressione.insertRow(model_pressione.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }
        
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 3), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_temperatura.insertRow(model_temperatura.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }
        
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 4), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_precipitazioni.insertRow(model_precipitazioni.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }
        
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 5), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_alt_ghiacciai.insertRow(model_alt_ghiacciai.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }
        
        str1 = new StringTokenizer(int_rilevazione.dati_tabella(geocode, 6), "!");
        while(str1.hasMoreTokens())
        {
            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
            model_m_ghiacciai.insertRow(model_m_ghiacciai.getRowCount(), new Object[]{str2.nextToken(), area, str2.nextToken(), str2.nextToken(), str2.nextToken()});
        }    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new javax.swing.JPanel();
        Titolo3 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        lb_back_home = new javax.swing.JLabel();
        pn_tabella = new javax.swing.JPanel();
        rivelazione_stampa = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabella_vento = new javax.swing.JTable();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabella_umidita = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabella_pressione = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabella_temperatura = new javax.swing.JTable();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabella_precipitazioni = new javax.swing.JTable();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabella_alt_ghiacciai = new javax.swing.JTable();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabella_m_ghiacciai = new javax.swing.JTable();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabella_medie = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabella_massimi = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabella_minimi = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabella_moda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        Titolo3.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo3.setForeground(new java.awt.Color(0, 153, 255));
        Titolo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo3.setText("Risultato rilevazioni");

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

        pn2.setBackground(new java.awt.Color(0, 0, 0));

        lb_back_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_back_home.setOpaque(true);
        lb_back_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_back_homeMouseClicked(evt);
            }
        });

        tabella_vento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO ", "PAESE ", "PUNTEGGIO ", "COMMENTO ", "DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabella_vento);

        jTabbedPane2.addTab("Velocità del vento in km/h", jScrollPane1);

        rivelazione_stampa.addTab("Vento", jTabbedPane2);

        tabella_umidita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO ", "PAESE", "PUNTEGGIO", "COMMENTO", "DATA "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tabella_umidita);

        jTabbedPane3.addTab("% di Umidità, suddivisa in fasce ", jScrollPane6);

        rivelazione_stampa.addTab("Umidità", jTabbedPane3);

        tabella_pressione.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO", "PAESE", "PUNTEGGIO ", "COMMENTO ", "DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabella_pressione);

        jTabbedPane4.addTab("In hPa, suddivisa in fasce", jScrollPane5);

        rivelazione_stampa.addTab("Pressione", jTabbedPane4);

        tabella_temperatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO ", "PAESE", "PUNTEGGIO", "COMMENTO", "DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabella_temperatura);

        jTabbedPane5.addTab("In C°, suddivisa in fasce", jScrollPane4);

        rivelazione_stampa.addTab("Temperatura", jTabbedPane5);

        tabella_precipitazioni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO", "PAESE", "PUNTEGGIO", "COMMENTO", "DATA "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabella_precipitazioni);

        jTabbedPane6.addTab("In mm di pioggia, suddivisa in fasce", jScrollPane3);

        rivelazione_stampa.addTab("Precipitazioni", jTabbedPane6);

        tabella_alt_ghiacciai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO", "PAESE", "PUNTEGGIO", "COMMENTO", "DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabella_alt_ghiacciai);

        jTabbedPane7.addTab("In m, suddivisa in piogge", jScrollPane2);

        rivelazione_stampa.addTab("Altitudine ghiacciai", jTabbedPane7);

        tabella_m_ghiacciai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CENTRO", "PAESE", "PUNTEGGIO ", "COMMENTO", "DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tabella_m_ghiacciai);

        jTabbedPane8.addTab("In kg, suddivisa in fasce", jScrollPane7);

        rivelazione_stampa.addTab("Massa dei ghiacciai", jTabbedPane8);

        tabella_medie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VENTO", "UMIDITA'", "PRESSIONE ", "TEMPERATURA", "PRECIPITAZIONI", "ALT. GHIACCIAI ", "M. GHIACCIAI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tabella_medie);

        jTabbedPane9.addTab("Medie rivelazioni ", jScrollPane8);

        tabella_massimi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VENTO", "UMIDITA", "PRESSIONE", "TEMPERATURA", "PRECIPITAZIONI", "ALT. GHIACCIAI", "M. GHIACCIAI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tabella_massimi);

        jTabbedPane9.addTab("Massimi", jScrollPane9);

        tabella_minimi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VENTO", "UMIDITA", "PRESSIONE", "TEMPERATURA", "PRECIPITAZIONI", "ALT. GHIACCIAI", "M. GHIACCIAI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tabella_minimi);

        jTabbedPane9.addTab("Minimi", jScrollPane10);

        tabella_moda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VENTO", "UMIDITA", "PRESSIONE", "TEMPERATURA", "PRECIPITAZIONI", "ALT. GHIACCIAI", "M.GHIACCIAI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tabella_moda);

        jTabbedPane9.addTab("Moda", jScrollPane11);

        rivelazione_stampa.addTab("Medie ", jTabbedPane9);

        javax.swing.GroupLayout pn_tabellaLayout = new javax.swing.GroupLayout(pn_tabella);
        pn_tabella.setLayout(pn_tabellaLayout);
        pn_tabellaLayout.setHorizontalGroup(
            pn_tabellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tabellaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rivelazione_stampa, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_tabellaLayout.setVerticalGroup(
            pn_tabellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tabellaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rivelazione_stampa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_tabella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lb_back_home, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_tabella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_back_home, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Questo metodo è utilizzato per andare alla pagina precedente.
     * @param evt evento scatenato
     */
    private void lb_back_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_back_homeMouseClicked
        try 
        {
            AccediCittadino cittadino = new AccediCittadino();
            cittadino.setVisible(true);
            this.setVisible(false);
        } 
        catch (SQLException | RemoteException | NotBoundException ex) {Logger.getLogger(DatiArea.class.getName()).log(Level.SEVERE, null, ex); } 
    }//GEN-LAST:event_lb_back_homeMouseClicked

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
            java.util.logging.Logger.getLogger(DatiArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatiArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatiArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatiArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatiArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titolo3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JLabel lb_back_home;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn_tabella;
    private javax.swing.JTabbedPane rivelazione_stampa;
    private javax.swing.JTable tabella_alt_ghiacciai;
    private javax.swing.JTable tabella_m_ghiacciai;
    private javax.swing.JTable tabella_massimi;
    private javax.swing.JTable tabella_medie;
    private javax.swing.JTable tabella_minimi;
    private javax.swing.JTable tabella_moda;
    private javax.swing.JTable tabella_precipitazioni;
    private javax.swing.JTable tabella_pressione;
    private javax.swing.JTable tabella_temperatura;
    private javax.swing.JTable tabella_umidita;
    private javax.swing.JTable tabella_vento;
    // End of variables declaration//GEN-END:variables
}
