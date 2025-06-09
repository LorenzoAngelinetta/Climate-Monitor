package Gestione_classi;

import Interfacce.InterfacciaCentro;
import Server.*;
import climatemonitoring.CentroMonitoraggio;
import java.rmi.RemoteException;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * Questa classe gestisce ed effettua le operazioni sull'oggetto di tipo centro di monitoraggio
 */
public class GestioneCentro extends UnicastRemoteObject implements InterfacciaCentro 
{
    /**
     * Oggetto di tipo centro monitoraggio.
     */
    private CentroMonitoraggio ct;
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
     * Costruttore oggetto centro
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public GestioneCentro() throws SQLException, RemoteException
    {
        c = ConnessioneDatabase.getConnection();
        statement = ConnessioneDatabase.getStatement();
    }
    
    /**
     * Registrazione centro di monitoraggio nel db
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized void registra_centroMonitoraggio() throws SQLException, RemoteException
    { 
        p = c.prepareStatement(CodiceSQL.insert_query[1]);
        p.setString(1, ct.getNome_centro());
        p.setString(2, ct.getVia_piazza());
        p.setInt(3, ct.getNumero_civico());
        p.setString(4, ct.getCap());
        p.setString(5, ct.getComune());
        p.setString(6, ct.getProvincia());
        p.executeUpdate();
    }
    
    /**
     * Questo metodo è utilizzato per effettuare dei controlli sui valori inseriti dall'utente, in caso di errore viene ritornato il numero dell'errore.
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     * @return viene ritornato l'errore
     */
    @Override
    public synchronized String ritorna_errore() throws SQLException , RemoteException
    {
        if (ct.getNome_centro().length() <= 2) 
        {
            return "Nome centro troppo corto, reinseriscilo";
        }
        if (ct.getVia_piazza().length() <= 2) 
        {
            return "Via/piazza troppo corta, reinseriscila";
        }
        if (ct.getNumero_civico() <= 0) 
        {
            return "Numero civico errato (maggiore di zero), reinseriscilo";
        }
        for (int i = 0; i < ct.getCap().length(); i++)
        {
            if(ct.getCap().charAt(i) > 47 && ct.getCap().charAt(i) < 58 && ct.getCap().length() == 5)
            {}
            else
            {
                return "CAP errato deve essere di 5 cifre, reinseriscilo";
            }
        }
        if (ct.getComune().length() <= 2) 
        {
            return "Comune troppo corto, reinseriscilo";
        }
        if (ct.getProvincia().length() <= 2) 
        {
            return "Provincia troppo corta, reinseriscila";
        }
        if (this.centro_gia_presente(ct.getNome_centro()) == true) 
        {
            return "Nome del centro già presente, reinseriscine uno nuovo";
        }
        if (this.indirizzo_gia_presente(ct.getNumero_civico(), ct.getCap(), ct.getComune(), ct.getProvincia(), ct.getVia_piazza()) == true) 
        {
            return "Indirizzo già associato a un centro di monitoraggio";
        }

        return "";
    }

    /**
     *  Questo metodo è utilizzato per controllare che il nome del centro di monitoraggio che si sta registrando non sia già esistente.
     * @param nome nome centro
     * @return valore booleano che indica se il nome del centro che si sta registrandro esista già
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    private synchronized boolean centro_gia_presente(String nome) throws SQLException
    {
        r = statement.executeQuery(CodiceSQL.control_query_centri[0]);
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
     * Questo metodo è utilizzato per controllare che nel indirizzo (via/piazza, numero civico, comune, provincia, cap) scelta dall'utente non sia già presente un altro centro.
     * @param numero numero
     * @param cap cap
     * @param comune comune
     * @param provincia provincia
     * @param via via
     * @return valore booleano che indica la presenza o meno di un centro creato in precedenza in quel indirizzo (via/piazza, numero civico, comune, provincia, cap)
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    private synchronized boolean indirizzo_gia_presente(int numero, String cap, String comune, String provincia, String via) throws SQLException 
    {
        r = statement.executeQuery(CodiceSQL.control_query_centri[1]);
        while(r.next())
        {
            if(r.getString("comune").equals(comune) && r.getString("provincia").equals(provincia) && r.getString("via_piazza").equals(via) && r.getInt("numero_civico") == numero && r.getString("cap").equals(cap))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Questo metodo è utilizzato per assegnare un operatore a un determinato centro di monitoraggio.
     * @param nome_centro nome del centro
     * @param id id
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized void aggiungi_centro_a_operatore(String nome_centro, int id) throws SQLException , RemoteException
    {
        p = c.prepareStatement(CodiceSQL.update_query[0]);
        p.setString(1, nome_centro);
        p.setInt(2, id);
        p.executeUpdate();  
    }
    
    /**
     * Recupera dal db tutte le aree associate a quel centro
     * @param nome_centro nome centro
     * @return stringa contenente tutte le aree associate a un centro
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized String aree_centro(String nome_centro) throws SQLException, RemoteException
    {
        String aree_centro = "";
        p = c.prepareStatement(CodiceSQL.select_query[3]);
        p.setString(1, nome_centro);
        r = p.executeQuery();  
        while(r.next())
        {
            String nome = r.getString("nome_area");
            String sigla = r.getString("sigla_stato");
            aree_centro = aree_centro + sigla + "-" + nome + ",";
        }
        return aree_centro;
    }
    
    
    /**
     * Metodo che setta oggetto di tipo centro
     * @param c oggetto di tipo centro
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized void setCentro(CentroMonitoraggio c) throws RemoteException
    {
        this.ct = c;
    }
}
