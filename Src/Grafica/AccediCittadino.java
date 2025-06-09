package Grafica;

import Interfacce.InterfacciaArea;
import climatemonitoring.*;
import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.rmi.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;

/**
 * Questa classe grafica consente di ricercare un area di interesse tramite coordinate o nome
 */
public class AccediCittadino extends javax.swing.JFrame
{
    /**
     * Latitudine.
     */
    public float latitudine;
    /**
     * Longitudine.
     */
    public float longitudine;
    /**
     * Tabella ricerca per nome.
     */
    public DefaultTableModel model1;
    /**
     * Tabella ricerca per coordinate.
     */
    public DefaultTableModel model2 ;
    /**
     * Oggetto di tipo area di interesse.
     */
    private AreaInteresse area;
    /**
     * Interfaccia oggetto di tipo gestione area di interesse.
     */
    private InterfacciaArea int_area;
    /**
     * Riferimento registro
     */
    private Registry reg;

    /**
     * Costruttore vuoto della classe per l'avvio della pagina con la sua inizializzazione grafica e ottenimento oggetti remoti
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @throws NotBoundException eccezione per oggetti remoti
     */
    public AccediCittadino() throws SQLException, RemoteException, NotBoundException
    {
        initComponents();
        
        ImageIcon imageIcon = new ImageIcon("./Icon/Indietro.png"); 
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_back_home.getWidth(), lb_back_home.getHeight(), SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        lb_back_home.setIcon(imageIcon);
        
        model1=(DefaultTableModel)tabella_ricerca_nome.getModel();
        model2=(DefaultTableModel)tabella_ricerca_coordinate.getModel();
        
        this.pn_ricerca_nome.setVisible(true);
        this.pn_ricerca_coordinate.setVisible(false);
        
        reg = LocateRegistry.getRegistry();
        int_area = (InterfacciaArea) reg.lookup("area");
        
        this.inizializza_combo_stati();
    }
    
    /**
     * Metodo che inizializza la combobox con gli stati
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
    */
    private void inizializza_combo_stati() throws SQLException, RemoteException
    { 
        StringTokenizer lista = new StringTokenizer(int_area.lista_stati(), "-");
        while(lista.hasMoreTokens())
        {
            combo_stati.addItem(lista.nextToken());
        }
    }
    
    /**
     * Metodo che contolla formato latitudine longitudine se è float.
     */
    private String formato_lat_long()
    {
        try
        {
            latitudine = Float.parseFloat(txt_latitudine.getText());
        }catch(NumberFormatException ex) {  return "latitudine"; }
        try
        {
            longitudine = Float.parseFloat(txt_longitudine.getText());
        }catch(NumberFormatException ex) {  return "longitudine"; }
        return "";
    }
    
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pn1 = new javax.swing.JPanel();
        Titolo3 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RadioButtonNome = new javax.swing.JRadioButton();
        RadioButtonCoordinate = new javax.swing.JRadioButton();
        contenitore = new javax.swing.JPanel();
        pn_ricerca_nome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_citta_ricercare = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cerca_citta_nome = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tab_nome = new javax.swing.JScrollPane();
        tabella_ricerca_nome = new javax.swing.JTable();
        combo_stati = new javax.swing.JComboBox<>();
        visualizza_dati_nome = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        pn_ricerca_coordinate = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cerca_cittacoordinate = new javax.swing.JButton();
        txt_latitudine = new javax.swing.JTextField();
        txt_longitudine = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tab_coordinate = new javax.swing.JScrollPane();
        tabella_ricerca_coordinate = new javax.swing.JTable();
        visualizza_dati_coordinate = new javax.swing.JButton();
        lb_back_home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        Titolo3.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo3.setForeground(new java.awt.Color(0, 153, 255));
        Titolo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo3.setText("Ricerca area interesse");

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

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scegli la modalità di ricerca");

        buttonGroup1.add(RadioButtonNome);
        RadioButtonNome.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        RadioButtonNome.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonNome.setText("Ricerca per nome");
        RadioButtonNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RadioButtonNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonNomeActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioButtonCoordinate);
        RadioButtonCoordinate.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        RadioButtonCoordinate.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonCoordinate.setText("Ricerca coordinate");
        RadioButtonCoordinate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RadioButtonCoordinate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonCoordinateActionPerformed(evt);
            }
        });

        contenitore.setBackground(new java.awt.Color(0, 0, 0));
        contenitore.setPreferredSize(new java.awt.Dimension(582, 340));

        pn_ricerca_nome.setBackground(new java.awt.Color(51, 51, 51));
        pn_ricerca_nome.setPreferredSize(new java.awt.Dimension(570, 330));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Scegli stato");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nome");

        cerca_citta_nome.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        cerca_citta_nome.setText("Cerca città");
        cerca_citta_nome.setFocusPainted(false);
        cerca_citta_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerca_citta_nomeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("(nel caso non fosse un paese vengono stampati i paesi con la stringa inserita)");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Inserisci una stringa per trovare il paese ");

        tabella_ricerca_nome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "ID STATO", "LATITUDINE ", "LONGITUDINE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_nome.setViewportView(tabella_ricerca_nome);

        visualizza_dati_nome.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        visualizza_dati_nome.setText("Visualizza dati");
        visualizza_dati_nome.setFocusPainted(false);
        visualizza_dati_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizza_dati_nomeActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("(eventuale iniziale maiusc)");

        javax.swing.GroupLayout pn_ricerca_nomeLayout = new javax.swing.GroupLayout(pn_ricerca_nome);
        pn_ricerca_nome.setLayout(pn_ricerca_nomeLayout);
        pn_ricerca_nomeLayout.setHorizontalGroup(
            pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ricerca_nomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_ricerca_nomeLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_ricerca_nomeLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_stati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cerca_citta_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(visualizza_dati_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addGroup(pn_ricerca_nomeLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_citta_ricercare, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_ricerca_nomeLayout.setVerticalGroup(
            pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ricerca_nomeLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ricerca_nomeLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_stati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(pn_ricerca_nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_citta_ricercare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(cerca_citta_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizza_dati_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tab_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        pn_ricerca_coordinate.setBackground(new java.awt.Color(51, 51, 51));
        pn_ricerca_coordinate.setPreferredSize(new java.awt.Dimension(570, 330));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inserisci le coordinate del paese ");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Longitudine");

        cerca_cittacoordinate.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        cerca_cittacoordinate.setText("Cerca città");
        cerca_cittacoordinate.setFocusPainted(false);
        cerca_cittacoordinate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerca_cittacoordinateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Latitudine");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("(nel caso in cui non ci fossero le coordinate precise si stampano quelle vicine)");

        tabella_ricerca_coordinate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "ID STATO", "LATITUDINE ", "LONGITUDINE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_coordinate.setViewportView(tabella_ricerca_coordinate);

        visualizza_dati_coordinate.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        visualizza_dati_coordinate.setText("Visualizza dati");
        visualizza_dati_coordinate.setFocusPainted(false);
        visualizza_dati_coordinate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizza_dati_coordinateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ricerca_coordinateLayout = new javax.swing.GroupLayout(pn_ricerca_coordinate);
        pn_ricerca_coordinate.setLayout(pn_ricerca_coordinateLayout);
        pn_ricerca_coordinateLayout.setHorizontalGroup(
            pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ricerca_coordinateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ricerca_coordinateLayout.createSequentialGroup()
                        .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cerca_cittacoordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_ricerca_coordinateLayout.createSequentialGroup()
                                .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_longitudine, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_latitudine, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(visualizza_dati_coordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tab_coordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ricerca_coordinateLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(59, 59, 59))))
            .addGroup(pn_ricerca_coordinateLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_ricerca_coordinateLayout.setVerticalGroup(
            pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ricerca_coordinateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ricerca_coordinateLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_latitudine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(pn_ricerca_coordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_longitudine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(cerca_cittacoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizza_dati_coordinate))
                    .addGroup(pn_ricerca_coordinateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab_coordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenitoreLayout = new javax.swing.GroupLayout(contenitore);
        contenitore.setLayout(contenitoreLayout);
        contenitoreLayout.setHorizontalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenitoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_ricerca_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenitoreLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_ricerca_coordinate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        contenitoreLayout.setVerticalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenitoreLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(pn_ricerca_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenitoreLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_ricerca_coordinate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lb_back_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_back_home.setOpaque(true);
        lb_back_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_back_homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addComponent(contenitore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                                .addComponent(RadioButtonNome)
                                .addGap(59, 59, 59)
                                .addComponent(RadioButtonCoordinate)
                                .addGap(119, 119, 119))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                                .addComponent(lb_back_home, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonCoordinate)
                    .addComponent(RadioButtonNome))
                .addGap(18, 18, 18)
                .addComponent(contenitore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_back_home, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Se viene selezionata questa modalità viene mostrato il pannello ricarca per nome.
     * @param evt evento scatenato
     */
    private void RadioButtonNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonNomeActionPerformed
        this.pn_ricerca_nome.setVisible(true);
        this.pn_ricerca_coordinate.setVisible(false);
    }//GEN-LAST:event_RadioButtonNomeActionPerformed
    /**
     * Se viene selezionata questa modalità viene mostrato il pannello ricerca per coordinate.
     * @param evt evento scatenato
     */
    private void RadioButtonCoordinateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonCoordinateActionPerformed
        this.pn_ricerca_coordinate.setVisible(true);
        this.pn_ricerca_nome.setVisible(false);
    }//GEN-LAST:event_RadioButtonCoordinateActionPerformed
    /**
     * Questo metodo inserisce nella tabella le aree che contengono quella stringa dello stato selezionato.
     * @param evt evento scatenato
     */
    private void cerca_citta_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca_citta_nomeActionPerformed
        model1.setRowCount(0);
        String stato = combo_stati.getSelectedItem().toString().toUpperCase();
        String stringa = "%" + txt_citta_ricercare.getText()+ "%";
        try 
        {
            StringTokenizer str1 = new StringTokenizer(int_area.ricerca_nome(stringa, stato), "!");
            while(str1.hasMoreTokens())
            {
                StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
                model1.insertRow(model1.getRowCount(), new Object[]{str2.nextToken(), str2.nextToken(), str2.nextToken(), str2.nextToken()});
            }
            if(model1.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null, "Nessun dato trovato, riprova", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException | RemoteException ex) { Logger.getLogger(AccediCittadino.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_cerca_citta_nomeActionPerformed
    /**
     * Questo metodo inserisce nella tabella le aree che hanno circa quelle coordinate.
     * Se viene trovata l'area con le coordinate precise giuste è stampata la singola area.
     * @param evt evento scatenato
     */
    private void cerca_cittacoordinateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca_cittacoordinateActionPerformed
        model2.setRowCount(0);
        StringTokenizer str1;
        try 
        {
            if(this.formato_lat_long().equals(""))
            {
                area = new AreaInteresse(latitudine, longitudine);
                int_area.setArea(area);
                if(int_area.ritorna_errore_lat_long().equals(""))
                {  
                    str1 = new StringTokenizer(int_area.ricerca_coordinate(), "!");
                    if(str1.hasMoreTokens() == true)
                    {
                        while(str1.hasMoreTokens())
                        {
                            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
                            model2.insertRow(model2.getRowCount(), new Object[]{str2.nextToken(), str2.nextToken(), str2.nextToken(), str2.nextToken()});
                        }
                    }
                    else
                    {
                        str1 = new StringTokenizer(int_area.ricerca_coordinate_avanzata(), "!");
                        while(str1.hasMoreTokens())
                        {
                            StringTokenizer str2 = new StringTokenizer(str1.nextToken(), "%");
                            model2.insertRow(model2.getRowCount(), new Object[]{str2.nextToken(), str2.nextToken(), str2.nextToken(), str2.nextToken()});
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,int_area.ritorna_errore_lat_long() , "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Il formato di " + this.formato_lat_long() + " non è corretto (deve essere un numero e non deve contenere caratteri)", "Errore", JOptionPane.ERROR_MESSAGE);
            }
            if(model2.getRowCount()==0 && this.formato_lat_long().equals("") && int_area.ritorna_errore_lat_long().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Non è stato trovato nessun dato, riprova", "Errore", JOptionPane.ERROR_MESSAGE);
            }   
        }catch (SQLException | RemoteException ex){Logger.getLogger(AccediCittadino.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_cerca_cittacoordinateActionPerformed
    /**
     * Questo metodo è utilizzato per andare alla pagina precedente.
     * @param evt evento scatenato
     */
    private void lb_back_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_back_homeMouseClicked
        SceltaModalita climate_monitoring = new SceltaModalita();
        climate_monitoring.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lb_back_homeMouseClicked
    /**
     * Questo metodo prevede che una volta stampati i dati in tabella venga selezionata la riga e cliccando sul bottone si apre la pagina con le corrispondenti rilevazioni.
     * @param evt evento scatenato
     */
    private void visualizza_dati_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizza_dati_nomeActionPerformed
        if(tabella_ricerca_nome.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleziona una riga della tabella prima di procedere con la visualizzazione dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String citta_selezionata = model1.getValueAt(tabella_ricerca_nome.getSelectedRow(), 0).toString();
            String sigla_stato_selezionato = model1.getValueAt(tabella_ricerca_nome.getSelectedRow(), 1).toString();
            try 
            {
                DatiArea dati = new DatiArea(citta_selezionata, sigla_stato_selezionato);
                dati.setVisible(true);
                this.setVisible(false);
            } 
            catch (SQLException ex) { Logger.getLogger(DatiArea.class.getName()).log(Level.SEVERE, null, ex);} catch (RemoteException | NotBoundException ex) { Logger.getLogger(AccediCittadino.class.getName()).log(Level.SEVERE, null, ex);}     
        }
    }//GEN-LAST:event_visualizza_dati_nomeActionPerformed
    /**
     * Questo metodo prevede che una volta stampati i dati in tabella venga selezionata la riga e cliccando sul bottone si apre la pagina con le corrispondenti rilevazioni.
     * @param evt evento scatenato
     */
    private void visualizza_dati_coordinateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizza_dati_coordinateActionPerformed
        if(tabella_ricerca_coordinate.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleziona una riga della tabella prima di procedere con la visualizzazione dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String citta_selezionata = model2.getValueAt(tabella_ricerca_coordinate.getSelectedRow(), 0).toString();
            String sigla_stato_selezionato = model2.getValueAt(tabella_ricerca_coordinate.getSelectedRow(), 1).toString();
            try 
            {
                DatiArea dati = new DatiArea(citta_selezionata, sigla_stato_selezionato);
                dati.setVisible(true);
                this.setVisible(false);
            }
            catch (SQLException | RemoteException | NotBoundException ex) {Logger.getLogger(AccediCittadino.class.getName()).log(Level.SEVERE, null, ex);} 
        }
    }//GEN-LAST:event_visualizza_dati_coordinateActionPerformed

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
            java.util.logging.Logger.getLogger(AccediCittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccediCittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccediCittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccediCittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AccediCittadino().setVisible(true);
                }  catch (SQLException | RemoteException | NotBoundException ex) {
                    Logger.getLogger(AccediCittadino.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioButtonCoordinate;
    private javax.swing.JRadioButton RadioButtonNome;
    private javax.swing.JLabel Titolo3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cerca_citta_nome;
    private javax.swing.JButton cerca_cittacoordinate;
    private javax.swing.JComboBox<String> combo_stati;
    private javax.swing.JPanel contenitore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_back_home;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn_ricerca_coordinate;
    private javax.swing.JPanel pn_ricerca_nome;
    private javax.swing.JScrollPane tab_coordinate;
    private javax.swing.JScrollPane tab_nome;
    private javax.swing.JTable tabella_ricerca_coordinate;
    private javax.swing.JTable tabella_ricerca_nome;
    public javax.swing.JTextField txt_citta_ricercare;
    public javax.swing.JTextField txt_latitudine;
    public javax.swing.JTextField txt_longitudine;
    private javax.swing.JButton visualizza_dati_coordinate;
    private javax.swing.JButton visualizza_dati_nome;
    // End of variables declaration//GEN-END:variables
}
