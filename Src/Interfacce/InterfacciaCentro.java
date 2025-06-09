package Interfacce;
 
import climatemonitoring.CentroMonitoraggio;
import java.rmi.*;
import java.sql.SQLException;
/**
 * Questa interfaccia riferita all'oggetto di tipo GestioneCentro di monitoraggio
 */
public interface InterfacciaCentro extends Remote  
{
     /**
     * Registrazione centro di monitoraggio nel db
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void registra_centroMonitoraggio() throws SQLException, RemoteException;
     /**
     * Questo metodo è utilizzato per effettuare dei controlli sui valori inseriti dall'utente, in caso di errore viene ritornato il numero dell'errore.
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @return viene ritornato l'errore
     */
    public String ritorna_errore() throws SQLException , RemoteException;
     /**
     * Questo metodo è utilizzato per assegnare un operatore a un determinato centro di monitoraggio.
     * @param nome_centro nome del centro
     * @param id id
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void aggiungi_centro_a_operatore(String nome_centro, int id) throws SQLException , RemoteException;
    /**
     * Recupera dal db tutte le aree associate a quel centro
     * @param nome_centro nome centro
     * @return stringa contenente tutte le aree associate a un centro
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public String aree_centro(String nome_centro) throws SQLException, RemoteException;
    /**
     * Metodo che setta oggetto di tipo centro
     * @param c oggetto di tipo centro
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void setCentro(CentroMonitoraggio c) throws RemoteException;
}