package climatemonitoring;

import java.io.*;

/**
 * Questa classe rappresenta un oggetto di "Operatore" 
 */
public class Operatore implements Serializable
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
     * Costruttore vuoto con parametri inzializzati di default
     */
    public Operatore() {
        this.nome = "";
        this.cognome = "";
        this.codice_fiscale = "";
        this.email = "";
        this.userid = 0;
        this.password = "";
        this.centro = "";
    }
    
    /**
     * Costruttore oggetto operatore
     * @param nome nome dell'operatore
     * @param cognome cognome dell'operatore
     * @param codice_fiscale codice fiscale dell'operatore
     * @param email e-mail dell'operatore
     * @param userid id assegnato all'operatore
     * @param password password con cui l'operatore accede
     * @param centro nome del centro di monitoraggio in cui l'operatore viene registrato
     */
    public Operatore(String nome, String cognome, String codice_fiscale, String email, int userid, String password, String centro) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale.toUpperCase();
        this.email = email;
        this.userid = userid;
        this.password = password;
        this.centro = centro;
    }
    
    /**
     * Secondo costruttore oggetto operatore per effetuare accesso
     * @param userid id assegnato all'operatore
     * @param password password con cui l'operatore accede
     */
    public Operatore(int userid, String password) {  
        this.userid = userid;
        this.password = password;
    }
    
    /**
     * Ritorna il nome dell'operatore
     *
     * @return nome dell'operatore 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Ritorna il cognome dell'operatore
     *
     * @return cognome dell'operatore 
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * Ritorna il codice fiscale dell'operatore
     *
     * @return codice fiscale dell'operatore
     */
    public String getCodice_fiscale() {
        return codice_fiscale;
    }
    
    /**
     * Ritorna l'e-mail dell'operatore 
     *
     * @return e-mail dell'operatore 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Ritorna l'Id assegnato all'operatore 
     *
     * @return id assegnato all'operatore
     */
    public int getUserid() {
        return userid;
    }
    
    /**
     * Ritorna la password utilizzata dall'operatore per effettuare l'accesso 
     *
     * @return password utilizzata dall'operatore per effettuare l'accesso 
     */
    public String getPassword() {
        return password;
    }
    
     /**
     * Ritorna il nome del centro in cui è registrato l'operatore 
     *
     * @return nome del centro in cui è registrato l'operatore  
     */
    public String getCentro() {
        return centro;
    }
    
    /**
     * Metodo utilizzato per registrare un operatore in un centro di monitoraggio in caso non sia stato inserito all'inizio
     * @param centro centro monitoraggio assegnato all'operatore
     */
    public void setCentro(String centro) {
        this.centro = centro;
    }
}
