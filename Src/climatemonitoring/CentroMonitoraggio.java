package climatemonitoring;

import java.io.Serializable;

/**
 * Questa classe rappresenta un oggetto di "Centro di monitoraggio" che verrà utilizzata per inserire un nuovo centro di monitoraggio
 */
public class CentroMonitoraggio implements Serializable
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
    private String aree;
    /**
     * Numero civico della via in cui è situato il centro di monitoraggio.
     */
    private int numero_civico;
    /**
     * Cap del paese in cui è situato il centro di monitoraggio.
     */
    private String cap;

    /**
     * Costruttore vuoto con parametri inzializzati di default
     */
    public CentroMonitoraggio() {
        this.nome_centro = "";
        this.via_piazza = "";
        this.comune = "";
        this.provincia = "";
        this.aree = "";
        this.numero_civico = 0;
        this.cap = "";
    }

    /**
     * Costruttore oggetto centro di monitoraggio
     * @param nome_centro nome del centro di monitoraggio
     * @param via_piazza via o piazza in cui è situato il centro di monitoraggio
     * @param numero_civico numero civico della via in cui è situato il centro di monitoraggio
     * @param cap cap del paese in cui è situato il centro
     * @param comune comune in cui è situato il centro di monitoraggio
     * @param provincia provincia in cui è situato il centro di monitoraggio
     */
    public CentroMonitoraggio(String nome_centro, String via_piazza, int numero_civico, String cap, String comune, String provincia) {
        this.nome_centro = nome_centro;
        this.via_piazza = via_piazza;
        this.comune = comune;
        this.provincia = provincia;
        this.numero_civico = numero_civico;
        this.cap = cap;
    }
    
    public CentroMonitoraggio(String nome_centro, String via_piazza, int numero_civico, String cap, String comune, String provincia, String aree) {
        this.nome_centro = nome_centro;
        this.via_piazza = via_piazza;
        this.comune = comune;
        this.provincia = provincia;
        this.numero_civico = numero_civico;
        this.cap = cap;
        this.aree = aree;
    }

    /**
     * Ritorna il nome del centro di monitoraggio
     *
     * @return nome del centro di monitoraggio
     */
    public String getNome_centro() {
        return nome_centro;
    }

    /**
     * Ritorna la via o la piazza in cui è situato il centro di monitoraggio
     *
     * @return via o piazza in cui è situato il centro di monitoraggio
     */
    public String getVia_piazza() {
        return via_piazza;
    }

    /**
     * Ritorna il comune in cui è situato il centro di monitoraggio
     *
     * @return comune in cui è situato il centro di monitoraggio
     */
    public String getComune() {
        return comune;
    }

    /**
     * Ritorna la provincia in cui è situato il centro di monitoraggio
     *
     * @return provincia in cui è situato il centro di monitoraggio
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Ritorna le aree di interesse di cui si occupa il centro di monitoraggio
     *
     * @return le aree di interesse di cui si occupa il centro di monitoraggio
     */
    public String getAree() {
        return aree;
    }

    /**
     * Ritorna il numero civico della via in cui è situato il centro di monitoraggio
     *
     * @return il numero civico della via in cui è situato il centro di monitoraggio
     */
    public int getNumero_civico() {
        return numero_civico;
    }

    /**
     * Ritorna il cap del paese in cui è situato il centro di monitoraggio
     *
     * @return il cap del paese in cui è situato il centro di monitoraggio
     */
    public String getCap() {
        return cap;
    }
}