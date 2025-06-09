package Gestione_classi;

import Interfacce.InterfacciaOperatore;
import Server.*;
import climatemonitoring.Operatore;
import java.rmi.RemoteException;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * Questa classe gestisce ed effettua le operazioni sull'oggetto di tipo operatore
 */
public class GestioneOperatore extends UnicastRemoteObject implements InterfacciaOperatore
{
    /**
     * Oggetto di tipo operatore.
     */
    private Operatore op;
    /**
     * Oggetto di tipo connessione.
     */
    private Connection c;
    /**
     * Oggetto di tipo statement.
     */
    private Statement statement;
    /**
     * Oggetto di tipo resultset.
     */
    private ResultSet r;
    /**
     * Oggetto di tipo preparedstatement.
     */
    private PreparedStatement p;
    
    /**
     * Costruttore oggetto gestione operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public GestioneOperatore() throws SQLException, RemoteException
    {
        c = ConnessioneDatabase.getConnection();
        statement = ConnessioneDatabase.getStatement();
    }

    /**
     * Questo metodo è utilizzato per registrare un nuovo operatore all'interno del programma
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */     
    @Override
    public synchronized void registra_operatore() throws SQLException, RemoteException
    { 
        p = c.prepareStatement(CodiceSQL.insert_query[0]);
        p.setString(1, op.getNome());
        p.setString(2, op.getCognome());
        p.setString(3, op.getCodice_fiscale());
        p.setString(4, op.getEmail());
        p.setInt(5, op.getUserid());
        p.setString(6, op.getPassword());
        p.setString(7, op.getCentro());
        p.executeUpdate();
    }
    
    /**
     * Questo metodo permette a un operatore di effetuare il login 
     * @param userid id assegnato all'operatore
     * @param password password dell'operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @return variabile di tipo operatore che indica la buona riuscita o meno dell'operazione di login
     */
    @Override
    public synchronized Operatore accesso(int userid, String password) throws SQLException, RemoteException
    {
        Operatore ope = null;
        
        p = c.prepareStatement(CodiceSQL.select_query[0]);
        p.setInt(1, userid);
        p.setString(2, password);
        r = p.executeQuery();
        
        while(r.next())
        {
            ope = new Operatore(r.getString("nome"), r.getString("cognome"), 
                    r.getString("codice_fiscale"), r.getString("email"),
                    r.getInt("user_id"), r.getString("password"), 
                    r.getString("centro"));
        }
        return ope;
    } 
    
     /**
     * Questo metodo è utilizzato per effettuare dei controlli sui valori inseriti dall'utente, in caso di errore viene ritornato l'errore.
     * @param flag variabile per la CheckBox del centro se attiva o no
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @return viene ritornato l'errore
     */
    @Override
    public synchronized String ritorna_errore(boolean flag) throws SQLException, RemoteException
    {
        if(op.getNome().length() <= 2)
        {
            return "Nome troppo corto, reinseriscilo";
        }
        if(op.getCognome().length() <= 2)
        {
            return "Cognome troppo corto, reinseriscilo";
        }
        if(op.getCodice_fiscale().length() != 16 || this.validita_cod_fiscale(op.getCodice_fiscale()) == false)
        {
            return "Codice fiscale errato. La lunghezza deve essere di 16 caratteri.\nDeve inoltre contenere 9 lettere e 7 cifre. Reinseriscilo";
        } 
        if(!op.getEmail().contains("@") || !op.getEmail().contains("."))
        {
            return "Email errata. Deve contenere '@' e '.' e non deve già essere in uso, reinseriscila";
        }
        if(op.getUserid() <= 9999 || op.getUserid() >=100000)
        {
            return "User ID errato. Deve essere di 5 cifre, reinseriscilo";
        }
        if(op.getPassword().length() != 8)
        {
            return "Password errata. Deve contenere 8 caratteri, reinseriscila";
        }
        if(this.codice_fiscale_gia_presente(op.getCodice_fiscale()) == true )
        {
            return "Codice fiscale già presente. Se sei gia registrato accedi";
        }
        if(this.email_gia_presente(op.getEmail()) == true)
        {
            return "Email già presente. Utilizzane una nuova";
        }
        if(this.userid_gia_presente(op.getUserid()) == true )
        {
            return "User ID già presente. Se sei gia registrato accedi";
        }
        if(flag == true)
        {
            if(this.centro_presente(op.getCentro()) == false)
            {
                return "Il nome del centro non è presente, reinseriscilo";
            }
        }
        return "";
    }
    
    /**
     * Questo metodo è utilizzato per controllare che l'id dell'operatore non sia già esistente.
     * @param id id assegnato all'operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @return valore booleano che indica se l'id dell'operatore è già stato utilizzato
     */
    private synchronized boolean userid_gia_presente(int id) throws SQLException 
    {
        r = statement.executeQuery(CodiceSQL.control_query_operatori[0]);
        while(r.next())
        {
            if(r.getInt("user_id") == id)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Questo metodo è utilizzato per controllare che l'email dell'operatore non sia già esistente.
     * @param email email dell'operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @return valore booleano che indica se l'email dell'operatore è già stato utilizzato
     */
    private synchronized boolean email_gia_presente(String email) throws SQLException
    {
        r = statement.executeQuery(CodiceSQL.control_query_operatori[1]);
        while(r.next())
        {
            if(r.getString("email").equals(email))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Questo metodo è utilizzato per controllare che il codice fiscale inserito sia valido.
     * @param cf codice fiscale assegnato all'operatore
     * @return valore booleano che indica se il codice fiscale inserito è valido o meno 
     */
    private synchronized boolean validita_cod_fiscale(String cf)
    {
         int lettere = 0, numeri = 0;
         for (int i = 0; i < cf.length(); i++)
         {
            if(cf.charAt(i) > 47 && cf.charAt(i) < 58)
            {
                numeri++;
            }
            else
            {
                lettere++;
            }
        }
        return lettere == 9 && numeri == 7;
     }
     
    /**
     * Questo metodo è utilizzato per controllare che l'operatore non sia già assegnato in un centro di monitoraggio
     * @param nome nome dell'operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @return valore booleano che indica se l'operatore è già assegnato a un centro di monitoraggio
     */
    private synchronized boolean centro_presente(String nome) throws SQLException
    {
        r = statement.executeQuery(CodiceSQL.control_query_operatori[3]);
        while(r.next())
        {
            if(r.getString("nome_centro").equals(nome))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Questo metodo è utilizzato per controllare che il codice fiscale dell'operatore che sta effettuando la registrazione non sia già stato usato
     * @param cf codice fiscale assegnato all'operatore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @return valore booleano che indica se il codice fiscale dell'operatore che sta effettuando la registrazione non sia già stato usato
     */
    private synchronized boolean codice_fiscale_gia_presente(String cf) throws SQLException
    {
        r = statement.executeQuery(CodiceSQL.control_query_operatori[2]);
        while(r.next())
        {
            if(r.getString("codice_fiscale").equals(cf))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo che setta oggetto di tipo operatore
     * @param operatore oggetto di tipo operatore
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public void setOperatore(Operatore operatore) throws RemoteException 
    {
        this.op = operatore;
    }
}
