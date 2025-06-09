package climatemonitoring;

import java.io.Serializable;

/**
 * Questa classe rappresenta un oggetto di "area di interesse" su cui verrà effettuata una rilevazione 
 */
public class AreaInteresse implements Serializable
{
    /**
     * Nome dell'area di interesse.
     */
    private String nome;
    /**
     * Sigla dello stato dell'area di interesse.
     */
    private String id_stato;
    /**
     * Latitudine dell'area di interesse.
     */
    private float latitudine;
    /**
     * Longitudine dell'area di interesse.
     */
    private float longitudine;
    
    /**
     * Costruttore vuoto con parametri inzializzati di default
     */
    public AreaInteresse()
    {
        nome="";
        id_stato="";
        latitudine=0;
        longitudine=0;
    }
    
    /**
     * Costruttore per costruzione del paese con parametri di area e stato
     * @param area nome dell'area
     * @param stato sigla dello stato dell'area
     */
    public AreaInteresse(String area, String stato)
    {
        this.nome=area;
        this.id_stato=stato;
    }
    
     /**
     * Costruttore per costruzione del paese con parametri di latitudine e longitudine
     * @param lat latitudine
     * @param lon longitudine
     */
    public AreaInteresse(float lat, float lon)
    {
        this.latitudine=lat;
        this.longitudine=lon;
    }
    
    /**
     * Costruttore oggetto area di interesse
     * @param nome nome dell'area
     * @param id_stato sigla dello stato dell'area
     * @param latitudine latitudine area 
     * @param longitudine longitudine area 
     */
    public AreaInteresse(String nome, String id_stato ,float latitudine, float longitudine)
    {
        this.nome=nome;
        this.id_stato=id_stato;
        this.latitudine=latitudine;
        this.longitudine=longitudine;
    }

    /**
    * Ritorna il nome dell'area
    * @return nome dell'area
     */
    public String getNome() {
        return nome;
    }

    /**
    * Ritorna la sigla dello stato dell'area
    * @return sigla dello stato dell'area
     */
    public String getId_stato() {
        return id_stato;
    }

    /**
    * Ritorna la latituine dell'area
    * @return latituine dell'area
     */
    public float getLatitudine() {
        return latitudine;
    }

    /**
    * Ritorna longitudine dell'area
    * @return longitudine dell'area
     */
    public float getLongitudine() {
        return longitudine;
    }
}
