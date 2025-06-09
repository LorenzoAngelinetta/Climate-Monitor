package Grafica;

import Interfacce.*;
import Gestione_classi.*;
import Server.ConnessioneDatabase;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Questa classe grafica consente di connettersi al database
 */
public class AvvioServer extends javax.swing.JFrame
{
    /**
     * indirizzo ip
     */ 
    private String ip;
    /**
     * nome database
     */ 
    private String nome_db;
    /**
     * porta di interconnesione al database
     */ 
    private String porta;
    /**
     * username del database
     */ 
    private String username;
    /**
     * password del database
     */ 
    private String password;
    /**
     * Ogetto di tipo connessione database
     */ 
    private ConnessioneDatabase connection;
    
    /**
     * Costruttore vuoto della classe per l'avvio della pagina con la sua inizializzazione grafica e creazione oggetto connesione
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public AvvioServer() throws SQLException
    {
        initComponents();
        connection = new ConnessioneDatabase();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titolo3 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        txt_ip = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_porta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_nomedb = new javax.swing.JTextField();
        conferma = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titolo3.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo3.setForeground(new java.awt.Color(0, 153, 255));
        Titolo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo3.setText("Connessione server");

        pn2.setBackground(new java.awt.Color(0, 0, 0));

        txt_ip.setEditable(false);
        txt_ip.setText("localhost");

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Indirizzo IP server");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Credenziali per la connessione al database");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nome database");

        txt_porta.setEditable(false);
        txt_porta.setText("5432");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Porta postgreSQL");

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Password postgreSQL");

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Username postgreSQL");

        txt_nomedb.setEditable(false);
        txt_nomedb.setText("db_climatemonitoring");

        conferma.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        conferma.setText("Connettiti");
        conferma.setFocusPainted(false);
        conferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaActionPerformed(evt);
            }
        });

        txt_username.setEditable(false);
        txt_username.setText("postgres");

        txt_password.setEditable(true);
        txt_password.setText("root");

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addGap(122, 123, Short.MAX_VALUE)
                .addComponent(conferma, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel18))
                            .addComponent(jLabel11)
                            .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)))
                        .addGap(18, 18, 18)
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nomedb)
                            .addComponent(txt_porta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addGap(40, 40, 40)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_nomedb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(28, 28, 28)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(36, 36, 36)
                .addComponent(conferma)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titolo3)
                .addGap(18, 18, 18)
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Cliccando consente di connetersi al db (in caso errato restituisce errori) e inserisce nel Registry riferimento a oggetti remoti
     * @param evt evento scatenato
     */
    private void confermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaActionPerformed
        ip = txt_ip.getText();
        nome_db = txt_nomedb.getText();
        porta = txt_porta.getText();
        username = txt_username.getText();
        password = txt_password.getText();
        connection.inizializza_dati(ip, porta, nome_db, username, password); 
        
        try
        {
            ConnessioneDatabase.getConnection();
            ConnessioneDatabase.getStatement();
            if(connection.esiste_db(nome_db) == true)
            {
                connection.setURL(nome_db);
                ConnessioneDatabase.modificaConnessione();
            }
            else
            {
                connection.crea_db(nome_db);
                connection.setURL(nome_db);
                ConnessioneDatabase.modificaConnessione();
                connection.crea_tabelle();
            }
                
            InterfacciaArea a = new GestioneArea(); 
            InterfacciaCentro c = new GestioneCentro();
            InterfacciaOperatore o = new GestioneOperatore();
            InterfacciaRilevazione r = new GestioneRilevazione();
                
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("area", a);
            reg.rebind("centro", c);
            reg.rebind("operatore", o);
            reg.rebind("rilevazione", r);
                
            JOptionPane.showMessageDialog(null, "Connessione al database effettuata con successo", "Procedi", JOptionPane.INFORMATION_MESSAGE);
            
            this.conferma.setEnabled(false);
            /*SceltaModalita climate_monitoring = new SceltaModalita();
            climate_monitoring.setVisible(true);
            this.setVisible(false);*/
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Riprova", JOptionPane.ERROR_MESSAGE);
        } 
        catch (RemoteException ex) {Logger.getLogger(AvvioServer.class.getName()).log(Level.SEVERE, null, ex);}   
    }//GEN-LAST:event_confermaActionPerformed

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
            java.util.logging.Logger.getLogger(AvvioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvvioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvvioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvvioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try 
                {
                    new AvvioServer().setVisible(true);      
                } catch (SQLException ex) {
                    Logger.getLogger(AvvioServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titolo3;
    private javax.swing.JButton conferma;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel pn2;
    public javax.swing.JTextField txt_ip;
    public javax.swing.JTextField txt_nomedb;
    public javax.swing.JTextField txt_password;
    public javax.swing.JTextField txt_porta;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
