package Interfacce;
 
import climatemonitoring.Operatore;
import java.rmi.*;
import java.sql.SQLException;
/**
 * Questa interfaccia riferita all'oggetto di tipo  GestioneOperatore
 */
public interface InterfacciaOperatore extends Remote
{
     /**
     * Questo metodo è utilizzato per registrare un nuovo operatore all'interno del programma
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */  
    public void registra_operatore() throws SQLException, RemoteException;
    /**
     * Questo metodo permette a un operatore di effetuare il login
     * @param userid id assegnato all'operatore
     * @param password password dell'operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @return variabile di tipo operatore che indica la buona riuscita o meno dell'operazione di login
     */
    public Operatore accesso(int userid, String password) throws SQLException, RemoteException;
    /**
     * Questo metodo è utilizzato per effettuare dei controlli sui valori inseriti dall'utente, in caso di errore viene ritornato l'errore.
     * @param flag variabile per la CheckBox del centro se attiva o no
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @return viene ritornato l'errore
     */
    public String ritorna_errore(boolean flag) throws SQLException, RemoteException;
     /**
     * Metodo che setta oggetto di tipo operatore
     * @param operatore oggetto di tipo operatore
     * @throws RemoteException eccezione per oggetti remoti
     */
    public void setOperatore(Operatore operatore) throws RemoteException;
}