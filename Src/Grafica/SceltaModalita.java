package Grafica;

import javax.swing.*;
import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 * Questa classe grafica consente di scegliere la modalità da utilizzare tra quella operatore e quella cittadino
 */
public class SceltaModalita extends javax.swing.JFrame
{
    /**
     * Costruttore vuoto della classe per l'avvio della pagina con la sua inizializzazione grafica
     */
    public SceltaModalita() 
    {
        initComponents();
        
        ImageIcon imageIcon = new ImageIcon("./Icon/logo.jpg"); 
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lb_logo.getWidth(), lb_logo.getHeight(), SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        lb_logo.setIcon(imageIcon);

        selezione_modalita.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        pn2 = new javax.swing.JPanel();
        selezione_modalita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        RadioButtonOperatore = new javax.swing.JRadioButton();
        RadioButtonCittadino = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        pn1 = new javax.swing.JPanel();
        lb_logo = new javax.swing.JLabel();
        Titolo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn2.setBackground(new java.awt.Color(0, 0, 0));

        selezione_modalita.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        selezione_modalita.setText("Procedi");
        selezione_modalita.setFocusPainted(false);
        selezione_modalita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selezione_modalitaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scegli la modalità operativa ");

        buttonGroup.add(RadioButtonOperatore);
        RadioButtonOperatore.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        RadioButtonOperatore.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonOperatore.setText("Modalità operatore");
        RadioButtonOperatore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RadioButtonOperatore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonOperatoreActionPerformed(evt);
            }
        });

        buttonGroup.add(RadioButtonCittadino);
        RadioButtonCittadino.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        RadioButtonCittadino.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonCittadino.setText("Modalità cittadino");
        RadioButtonCittadino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RadioButtonCittadino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonCittadinoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("di esecuzione dell'applicazione");

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RadioButtonCittadino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RadioButtonOperatore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(selezione_modalita, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(RadioButtonCittadino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonOperatore)
                .addGap(45, 45, 45)
                .addComponent(selezione_modalita)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        lb_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_logo.setOpaque(true);

        Titolo1.setFont(new java.awt.Font("Segoe UI Light", 3, 36)); // NOI18N
        Titolo1.setForeground(new java.awt.Color(0, 153, 255));
        Titolo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo1.setText("Climate monitor");

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titolo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lb_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Titolo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
     * Questo metodo è usato per selezionare la modalità tramite la quale operare.
     * @param evt evento scatenato
     */
    private void selezione_modalitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selezione_modalitaActionPerformed
        try
        {
            Registry registry = LocateRegistry.getRegistry(1099);
            System.out.println(registry.list().length);
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null, "Nessun server attivo. Avvialo per proseguire", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        
        try 
        {
            if(RadioButtonOperatore.isSelected()) 
            {
                AccediOperatore operatore = new AccediOperatore();
                operatore.setVisible(true);
                this.setVisible(false); 
            }
            else
            {
                AccediCittadino cittadino;
                cittadino = new AccediCittadino();
                cittadino.setVisible(true);
                this.setVisible(false); 
            }
        } 
        catch (SQLException | RemoteException | NotBoundException ex) {Logger.getLogger(SceltaModalita.class.getName()).log(Level.SEVERE, null, ex);} 
        
        
    }//GEN-LAST:event_selezione_modalitaActionPerformed
    /**
     * Se viene selezionata questa modalità viene abilitato il bottone per accedere alla modalità scelta.
     * @param evt evento scatenato
     */
    private void RadioButtonCittadinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonCittadinoActionPerformed
        selezione_modalita.setEnabled(true);
    }//GEN-LAST:event_RadioButtonCittadinoActionPerformed
    /**
     * Se viene selezionata questa modalità viene abilitato il bottone per accedere alla modalità scelta.
     * @param evt evento scatenato
     */
    private void RadioButtonOperatoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonOperatoreActionPerformed
        selezione_modalita.setEnabled(true);
    }//GEN-LAST:event_RadioButtonOperatoreActionPerformed

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
            java.util.logging.Logger.getLogger(SceltaModalita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SceltaModalita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SceltaModalita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SceltaModalita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SceltaModalita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioButtonCittadino;
    private javax.swing.JRadioButton RadioButtonOperatore;
    private javax.swing.JLabel Titolo1;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JButton selezione_modalita;
    // End of variables declaration//GEN-END:variables
}
