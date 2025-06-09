package Grafica;

import Interfacce.InterfacciaOperatore;
import climatemonitoring.*;
import javax.swing.*;
import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.rmi.*;
import java.sql.SQLException;
import java.util.logging.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 * Questa classe grafica consente di effettuare l'accesso al programma come operatore o di registrarsi
 */
public class AccediOperatore extends javax.swing.JFrame 
{
    /**
     * UserId dell'utente
     */
    private int userid;
    /**
     * Password dell'utente
     */
    private String password;
    /**
     * Oggetto di tipo operatore
     */
    private Operatore operatore;
    /**
     * Interfaccia classe che serve a modellare la classe operatore
     */
    private InterfacciaOperatore int_op;
    /**
     * Riferimento registro
     */
    private Registry reg;
    
    /**
     * Costruttore vuoto della classe per l'avvio della pagina con la sua inizializzazione grafica e ottenimento oggetti remoti
     * @throws RemoteException eccezione per oggetti remoti
     * @throws NotBoundException eccezione per oggetti remoti
     */
    public AccediOperatore() throws RemoteException, NotBoundException
    {
        initComponents();
        
        ImageIcon imageIcon = new ImageIcon("./Icon/Indietro.png"); 
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_back_home.getWidth(), lb_back_home.getHeight(), SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        lb_back_home.setIcon(imageIcon);
        
        reg = LocateRegistry.getRegistry();
        int_op = (InterfacciaOperatore) reg.lookup("operatore");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new javax.swing.JPanel();
        Titolo2 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        txt_USERID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        accedi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lb_back_home = new javax.swing.JLabel();
        registrati = new javax.swing.JLabel();
        txt_PASSWORD = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        Titolo2.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo2.setForeground(new java.awt.Color(0, 153, 255));
        Titolo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo2.setText("Accedi");

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titolo2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pn2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("User ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Accedi come operatore");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        accedi.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        accedi.setText("Accedi");
        accedi.setFocusPainted(false);
        accedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accediActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Non hai un account? ");

        lb_back_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_back_home.setOpaque(true);
        lb_back_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_back_homeMouseClicked(evt);
            }
        });

        registrati.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        registrati.setForeground(new java.awt.Color(255, 0, 51));
        registrati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrati.setText("Registrati");
        registrati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registratiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn2Layout.createSequentialGroup()
                                .addComponent(txt_USERID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_PASSWORD)))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registrati)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                                .addComponent(accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addComponent(lb_back_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_USERID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(accedi)
                .addGap(41, 41, 41)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(registrati))
                .addGap(48, 48, 48)
                .addComponent(lb_back_home, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
     * Questo metodo è utilizzato per effettuare la funzione di accesso.
     * Preso in input l'userid e la password (se validi) va a verificare la loro presenza nel db.
     * Se viene trovato l'utente ci sono 2 possibili strade ossia che ha già un centro associato (quindi effettui rilevazione) o che lo deve creare.
     * @param evt evento scatenato
     */
    private void accediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accediActionPerformed
        try
        {
            userid = Integer.parseInt(txt_USERID.getText());
        }
        catch(NumberFormatException ex){}
        password = String.valueOf(txt_PASSWORD.getPassword());
        
        if(this.userid <= 9999 || this.userid >=100000)
        {
            JOptionPane.showMessageDialog(null, "User ID errato. Deve essere di 5 cifre, reinseriscilo", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(this.password.length() != 8)
            {
                JOptionPane.showMessageDialog(null, "Password errata. Deve contenere 8 caratteri, reinseriscila", "Errore", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                operatore = new Operatore(userid, password);
                try 
                {
                    operatore = int_op.accesso(userid, password);
                    if(operatore != null)
                    {
                        JOptionPane.showMessageDialog(null, "Bentornato utente " + userid , "Procedi", JOptionPane.INFORMATION_MESSAGE);
                        if(operatore.getCentro() == null)
                        {
                            RegistraCentro creazione_centro;
                            creazione_centro = new RegistraCentro(userid);
                            creazione_centro.setVisible(true);
                            this.setVisible(false);
                        }
                        else 
                        {
                            InserimentoRilevazione inserimento_parametri_area = new InserimentoRilevazione(operatore.getCentro());
                            inserimento_parametri_area.setVisible(true);
                            this.setVisible(false);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Id o password sbagliati, se non sei registrato clicca sulla scritta 'Registrati'", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (SQLException | RemoteException | NotBoundException ex) { Logger.getLogger(AccediOperatore.class.getName()).log(Level.SEVERE, null, ex); }  
            }
        }
    }//GEN-LAST:event_accediActionPerformed

    /**
     * Questo metodo è utilizzato per andare alla pagina di registrazione utente chiudendo la pagina attuale.
     * @param evt evento scatenato
     */
    private void registratiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registratiMouseClicked
        try 
        {
            RegistraOperatore registra_operatore = new RegistraOperatore();
            registra_operatore.setVisible(true);
            this.setVisible(false);
        } 
        catch (RemoteException | NotBoundException ex) {Logger.getLogger(AccediOperatore.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_registratiMouseClicked
    /**
     * Questo metodo è utilizzato per andare alla pagina precedente.
     * @param evt evento scatenato
     */
    private void lb_back_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_back_homeMouseClicked
        SceltaModalita climate_monitoring = new SceltaModalita();
        climate_monitoring.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(AccediOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccediOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccediOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccediOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AccediOperatore().setVisible(true);
                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(AccediOperatore.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titolo2;
    private javax.swing.JButton accedi;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb_back_home;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JLabel registrati;
    private javax.swing.JPasswordField txt_PASSWORD;
    public javax.swing.JTextField txt_USERID;
    // End of variables declaration//GEN-END:variables
}
