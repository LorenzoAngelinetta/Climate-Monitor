package Interfacce;
 
import climatemonitoring.Rilevazione;
import java.rmi.*;
import java.sql.SQLException;
/**
 * Questa interfaccia riferita all'oggetto di tipo GestioneRilevazione
 */
 
public interface InterfacciaRilevazione extends Remote
{
     /**
     * Metodo che inserisce nel db le rilevazioni
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void registra_rilevazione() throws SQLException, RemoteException;
     /**
     * Ritorna il result set delle rilevazioni
     * @param geocode geocode
     * @param i posizione
     * @return stringa che contiene i dati
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public String dati_tabella(int geocode, int i) throws SQLException, RemoteException;
     /**
     * Questo metodo mette nell'array dei massimi la massima rilevazione di quell'area.
     * @param geocode geocode
     * @return array valori massimi
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public int[] trovaMassimo(int geocode) throws SQLException, RemoteException;
     /**
     * Questo metodo mette nell'array dei minimi la minima rilevazione di quell'area.
     * @param geocode geocode
     * @return array valori minimi
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public int[] trovaMinimo(int geocode) throws SQLException, RemoteException;
    /**
     * Questo metodo mette nell'array la media di tutti i paramentri delle rilevazioni di quell'area.
     * @param geocode geocode
     * @return valori medi
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public double[] trovaMedie(int geocode) throws SQLException, RemoteException;
     /**
     * Questo metodo mette nell'array la moda di tutti i paramentri delle rilevazioni di quell'area.
     * @param geocode geocode
     * @return moda valori
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public int[] trovaMode(int geocode) throws SQLException, RemoteException  ;
      /**
     * Questo metodo controlla se la nota inseritta è troppo lunga.
     * @param note[] vettore da reinizzializzare
     * @throws RemoteException eccezione per oggetti remoti
     * @return errore
     */
    public String controlli_note(String[] note)throws RemoteException;
     /**
     * Metodo che setta oggetto di tipo rilevazione
     * @param r oggetto di tipo rilevazione
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void setRilevazione(Rilevazione r) throws RemoteException;
}
