package climatemonitoring;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * Questa classe rappresenta un oggetto di "Rilevazione" che verrà utilizzata per effettuare delle rilevazioni di una determinata area di interesse
 */
public class Rilevazione implements Serializable
{
    /**
     * Array contenente le note sui vari attributi delle rilevazioni.
     */
    private String[] note = new String[]{"","","","","","", ""};
    /**
     * Nome del centro che effettua la rilevazione.
     */
    private String centro;
    /**
     * Area di interesse su cui si effettua la rilevazione.
     */
    private int area;
     /**
     *Data e ora in cui viene effettuata la rilevazione.
     */
    public Timestamp data;
    /**
     *Velocità del vento(km/h),suddivisa in fasce
     */
    private int vento;
    /**
     * Umidità % di umidità,suddivisa in fasce
     */
    private int umidita;
    /**
     *Pressione in hPa,suddivisa in fasce
     */
    private int  pressione; 
    /**
     *Temperatura in C°,suddivisa in fasce
     */
    private int temperatura;
     /**
     *Precipitazioni in mm di pioggia,suddivisa in fasce
     */
    private int precipitazioni; 
    /**
     *Altitudine dei ghiacciai in m,suddivisa in piogge
     */
    private int altitudine_ghiacciai;
    /**
     *Massa dei ghiacciai in kg,suddivisa in fasce
     */
    private int massa_ghiacciai;

    /**
     * Costruttore oggetto operatore
     *
     * @param centro nome del centro di interesse che effettua la rilevazione 
     * @param area area di interesse su cui si effettua la rilevazione 
     * @param data data e ora in cui viene effettuata la rilevazione
     * @param vento velocità del vento(km/h),suddivisa in fasce
     * @param umidita umidità % di umidità,suddivisa in fasce
     * @param pressione pressione in hPa,suddivisa in fasce
     * @param temperatura temperatura in C°,suddivisa in fasce
     * @param precipitazioni precipitazioni in mm di pioggia,suddivisa in fasce
     * @param altitudine_ghiacciai altitudine dei ghiacciai in m,suddivisa in piogge
     * @param massa_ghiacciai massa dei ghiacciai in kg,suddivisa in fasce
     * @param note[]  array contenente le note sui vari attributi delle rilevazioni
     */
    public Rilevazione(String centro, int area, Timestamp data, int vento, int umidita, int pressione, int temperatura, int precipitazioni, int altitudine_ghiacciai, int massa_ghiacciai, String[] note) {
        this.centro = centro;
        this.area = area;
        this.data = data;
        this.vento = vento;
        this.umidita = umidita;
        this.pressione = pressione;
        this.temperatura = temperatura;
        this.precipitazioni = precipitazioni;
        this.altitudine_ghiacciai = altitudine_ghiacciai;
        this.massa_ghiacciai = massa_ghiacciai;
        this.note = note;
    }
    /**
     * Costruttore vuoto con parametri inzializzati di default
     */
    public Rilevazione() {
        this.centro = "";
        this.area = 0;
        this.data = null;
        this.vento = 0;
        this.umidita = 0;
        this.pressione = 0;
        this.temperatura = 0;
        this.precipitazioni = 0;
        this.altitudine_ghiacciai = 0;
        this.massa_ghiacciai = 0;
        this.note = null;
    }
   
    /**
     * Ritorna l'array contenente le note sui vari attributi delle rilevazioni
     *
     * @return array contenente le note sui vari attributi delle rilevazioni
     */
    public String[] getNote() {
        return note;
    }
    
    /**
     * Ritorna il nome del centro che effettua la rilevazione
     *
     * @return nome del centro che effettua la rilevazione
     */
    public String getCentro() {
        return centro;
    }
    
    /**
     * Ritorna la data e l'ora in cui vieni effettuata la rilevazione
     *
     * @return data e ora in cui vieni effettuata la rilevazione
     */
    public Timestamp getData() {
        return data;
    }
    
    /**
     * Ritorna l'area di interesse in cui viene effettuata la rilevazione
     *
     * @return area di interesse in cui viene effettuata la rilevazione
     */
    public int getArea() {
        return area;
    }
    
    /**
     * Ritorna la velocità delvento(km/h),suddivisa in fasce
     *
     * @return  velocità delvento(km/h),suddivisa in fasce
     */
    public int getVento() {
        return vento;
    }
    
    /**
     * Ritorna l'umidità % di umidità,suddivisa in fasce
     *
     * @return  umidità % di umidità,suddivisa in fasce
     */
    public int getUmidita() {
        return umidita;
    }
    
    /**
     * Ritorna la pressione in hPa,suddivisa in fasce  
     *
     * @return  pressione in hPa,suddivisa in fasce
     */
    public int getPressione() {
        return pressione;
    }
    
    /**
     * Ritorna la temperatura in C°,suddivisa in fasce
     *
     * @return temperatura in C°,suddivisa in fasce  
     */
    public int getTemperatura() {
        return temperatura;
    }
    
     /**
     * Ritorna le precipitazioni in mm di pioggia,suddivisa in fasce
     *
     * @return precipitazioni in mm di pioggia,suddivisa in fasce 
     */
    public int getPrecipitazioni() {
        return precipitazioni;
    }
    
    /**
     * Ritorna l'altitudine dei ghiacciai in m,suddivisa in piogge 
     *
     * @return altitudine dei ghiacciai in m,suddivisa in piogge
     */
    public int getAltitudine_ghiacciai() {
        return altitudine_ghiacciai;
    }
    
    /**
     * Ritorna la massa dei ghiacciai in kg,suddivisa in fasce
     *
     * @return massa dei ghiacciai in kg,suddivisa in fasce
     */
    public int getMassa_ghiacciai() {
        return massa_ghiacciai;
    }
}