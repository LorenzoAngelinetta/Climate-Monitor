package Grafica;

import Interfacce.InterfacciaOperatore;
import climatemonitoring.*;
import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.rmi.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 * Questa classe grafica consente di effettuare registrare l'operatore
 */
public class RegistraOperatore extends javax.swing.JFrame 
{
     /**
     * Nome dell'operatore.
     */
    private String nome;
    /**
     * Cognome dell'operatore.
     */ 
    private String cognome;
    /**
     * Codice fiscale dell'operatore.
     */ 
    private String codice_fiscale;
    /**
     * E-mail dell'operatore.
     */ 
    private String email;
    /**
     * Password con cui l'operatore accede.
     */ 
    private String password;
    /**
     * Nome del centro di monitoraggio in cui l'operatore viene registrato.
     */
    private String  centro;
    /**
     * Id assegnato all'operatore.
     */
    private int userid;
    /**
     * Oggetto di tipo operatore
     */
    private Operatore operatore;
    /**
    * Interfaccia dell'oggetto gestione operatore 
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
    public RegistraOperatore() throws RemoteException, NotBoundException 
    {
        initComponents();
        
        ImageIcon imageIcon = new ImageIcon("./Icon/Indietro.png"); 
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_back_accedi.getWidth(), lb_back_accedi.getHeight(), SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        lb_back_accedi.setIcon(imageIcon);
        
        txt_centro.setEnabled(false);
        
        reg = LocateRegistry.getRegistry();
        int_op = (InterfacciaOperatore) reg.lookup("operatore");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        pn1 = new javax.swing.JPanel();
        Titolo3 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        txt_nome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_codicefiscale = new javax.swing.JTextField();
        txt_centro = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_userid = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CheckBoxCentro = new javax.swing.JCheckBox();
        txt_cognome = new javax.swing.JTextField();
        registrati = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lb_back_accedi = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        Titolo3.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo3.setForeground(new java.awt.Color(0, 153, 255));
        Titolo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo3.setText("Registra operatore");

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

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nome");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Registrati come operatore");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cognome");

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Password");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Codice fiscale");

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("User ID");

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("E-mail");

        CheckBoxCentro.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        CheckBoxCentro.setForeground(new java.awt.Color(255, 255, 255));
        CheckBoxCentro.setText("Centro");
        CheckBoxCentro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CheckBoxCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxCentroActionPerformed(evt);
            }
        });

        registrati.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        registrati.setText("Registrati");
        registrati.setFocusPainted(false);
        registrati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registratiActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("(5 cifre)");

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("(8 car)");

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
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckBoxCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_codicefiscale, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_userid, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_centro, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_cognome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_password))
                .addGap(15, 15, 15))
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(registrati, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_back_accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addGap(28, 28, 28)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_cognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel16))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txt_codicefiscale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel20))
                    .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(24, 24, 24)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckBoxCentro)
                    .addComponent(txt_centro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(registrati)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lb_back_accedi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo che vede se la ChecBox è selezionata.
     * Abilita o disbabilita la casella di testo del nome del centro.
     * @param evt evento scatenato
     */
    private void CheckBoxCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxCentroActionPerformed
        if(CheckBoxCentro.isSelected() == true)
        {
            txt_centro.setEnabled(true);
        }
        if(CheckBoxCentro.isSelected() == false)
        {
            txt_centro.setEnabled(false);
        }
    }//GEN-LAST:event_CheckBoxCentroActionPerformed
    /**
     * Metodo che procede con la registrazione prendendo in input i dati.
     * Se vengono superati i controlli di correttezza viene salvato nel db.
     * @param evt evento scatenato
     */
    private void registratiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registratiActionPerformed
        nome = txt_nome.getText();
        cognome = txt_cognome.getText();
        codice_fiscale = txt_codicefiscale.getText();
        email = txt_email.getText();
        password = String.valueOf(txt_password.getPassword());
        centro = txt_centro.getText();
        try
        {
            userid =Integer.parseInt(txt_userid.getText());
        }
        catch(NumberFormatException ex){}
        
        try 
        {          
            if(CheckBoxCentro.isSelected() == true)
            {
                operatore = new Operatore(nome, cognome, codice_fiscale, email, userid, password, centro);
                int_op.setOperatore(operatore);
                if(int_op.ritorna_errore(this.CheckBoxCentro.isSelected()).equals(""))
                {
                    int_op.registra_operatore();
                    JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo", "Procedi", JOptionPane.INFORMATION_MESSAGE);
                    AccediOperatore loggati = new AccediOperatore();
                    loggati.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, int_op.ritorna_errore(this.CheckBoxCentro.isSelected()), "Errore", JOptionPane.ERROR_MESSAGE);
                }  
            }
            else
            {
                operatore = new Operatore(nome, cognome, codice_fiscale, email, userid, password, null);
                int_op.setOperatore(operatore);
                if(int_op.ritorna_errore(this.CheckBoxCentro.isSelected()).equals(""))
                {
                    int_op.registra_operatore();
                    JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo", "Procedi", JOptionPane.INFORMATION_MESSAGE);
                    AccediOperatore loggati = new AccediOperatore();
                    loggati.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, int_op.ritorna_errore(this.CheckBoxCentro.isSelected()), "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
        catch (SQLException | RemoteException | NotBoundException ex) { Logger.getLogger(RegistraOperatore.class.getName()).log(Level.SEVERE, null, ex); }  
    }//GEN-LAST:event_registratiActionPerformed
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
        } 
        catch (RemoteException | NotBoundException ex) {Logger.getLogger(RegistraOperatore.class.getName()).log(Level.SEVERE, null, ex);} 
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
            java.util.logging.Logger.getLogger(RegistraOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistraOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistraOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistraOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RegistraOperatore().setVisible(true);
                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(RegistraOperatore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxCentro;
    private javax.swing.JLabel Titolo3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lb_back_accedi;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JButton registrati;
    public javax.swing.JTextField txt_centro;
    public javax.swing.JTextField txt_codicefiscale;
    public javax.swing.JTextField txt_cognome;
    public javax.swing.JTextField txt_email;
    public javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_userid;
    // End of variables declaration//GEN-END:variables
}
