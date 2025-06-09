package Interfacce;
 
import climatemonitoring.AreaInteresse;
import java.rmi.*;
import java.sql.SQLException;
 
/**
 * Questa interfaccia riferita all'oggetto di tipo GestioneArea di interesse
 */
public interface InterfacciaArea extends Remote
{
    /**
     * Questo metodo inserisce le aree nel db associate a un centro
     * @param centro centro
     * @param lista_aree lista aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void inserisci_area(String centro, String lista_aree)throws SQLException, RemoteException;
    /**
     * Metodo che ritorna gli eventuali errori nel caso ci siano dati inseriti sulla registrazione dell'area che non sono corretti.
     * @param numero_aree numero aree
     * @return errore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */  
    public String ritorna_errore(int numero_aree)throws SQLException, RemoteException;
    /**
     * Questo metodo controlla se nel centro è già stata inserita l'area di interesse
     * @param geocode geocode
     * @return valore booleano che dice se area già stata inserita o no
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public boolean area_gia_inserita(int geocode)throws SQLException, RemoteException;
    /**
     * Questo metodo è utilizzato per effettuare dei controlli sui valori inseriti dall'utente, in caso di errore viene ritornato il numero dell'errore.
     * @throws RemoteException eccezione per oggetti remoti
     * @return viene ritornato l'errore
     */
    public String ritorna_errore_lat_long()throws RemoteException;
    /**
     * Ricerca per coodinate vicine se non esiste la cordinata precisa
     * @return stringa con le aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public String ricerca_coordinate_avanzata()throws SQLException, RemoteException;
    /**
     * Questo metodo ritorna l'area con la coordinata è precisa.
     * @return stringa con le aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public String ricerca_coordinate() throws SQLException, RemoteException;
    /**
     * Questo metodo ritorna le aree che le aree che contengono quella stringa dello stato scelto.
     * @param str stringa da cercare
     * @param stato stato
     * @return stringa con le aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public String ricerca_nome(String str, String stato)throws SQLException, RemoteException;
    /**
     * Metodo che crea una lista con gli stati senza duplicati
     * @return Ritorno il result set della query di selezione degli stati
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public String lista_stati() throws SQLException, RemoteException;
    /**
     * Data un'area di interesse ritorna il geocode
     * @param sigla sigla stato
     * @param nome nome area
     * @return geocode area
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public int recuperaGeocode(String sigla, String nome) throws SQLException, RemoteException;
    /**
     * Metodo che setta oggetto di tipo area
     * @param a oggetto di tipo area
     * @throws RemoteException eccezione per oggetti remoti
     */    
    public void setArea(AreaInteresse a) throws RemoteException;
   
}
