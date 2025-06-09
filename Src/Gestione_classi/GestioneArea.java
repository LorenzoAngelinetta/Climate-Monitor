package Gestione_classi;

import Interfacce.InterfacciaArea;
import Server.*;
import climatemonitoring.AreaInteresse;
import java.math.*;
import java.sql.*;
import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Questa classe gestisce ed effettua le operazioni sull'oggetto di tipo area
 */
public class GestioneArea extends UnicastRemoteObject implements InterfacciaArea
{
     /**
     * Oggetto di tipo area.
     */
    private AreaInteresse area;
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
     * Geocode per identificare l'area
     */
    private int geocode;
 
    /**
     * Costruttore gestione area
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    public GestioneArea() throws SQLException, RemoteException 
    {
        c = ConnessioneDatabase.getConnection();
        statement = ConnessioneDatabase.getStatement();
    }
    
    /**
     * Questo metodo inserisce le aree nel db associate a un centro
     * @param centro centro
     * @param lista_aree lista aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized void inserisci_area(String centro, String lista_aree) throws SQLException, RemoteException 
    { 
        StringTokenizer st1 = new StringTokenizer(lista_aree,",");  
        while (st1.hasMoreTokens())
        {
            String localita = st1.nextToken();
            StringTokenizer st2 = new StringTokenizer(localita,"-");
            while (st2.hasMoreTokens())
            {
                String nome = st2.nextToken();
                String sigla = st2.nextToken();
                p = c.prepareStatement(CodiceSQL.select_query[2]);
                p.setString(1, sigla);
                p.setString(2, nome);
                r = p.executeQuery();
                while(r.next())
                {
                    geocode = r.getInt("geocode");
                }
                p = c.prepareStatement(CodiceSQL.insert_query[2]);
                p.setString(1, centro);
                p.setInt(2, geocode);
                p.executeUpdate();
            }
        }            
    }
    
    /**
     * Metodo che ritorna gli eventuali errori nel caso ci siano dati inseriti sulla registrazione dell'area che non sono corretti.
     * @param numero_aree numero aree
     * @return errore
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */  
    @Override
    public synchronized String ritorna_errore(int numero_aree) throws SQLException, RemoteException
    {
        if(numero_aree < 1)
        {
            return "Il numero di aree deve essere un numero maggiore di 1, reinseriscilo";
        }
        if(area.getId_stato().length() != 2)
        {
            return "La sigla di tutti gli stati è di 2 lettere, reinseriscila";
        }
         if(this.stato_presente(area.getId_stato()) == false)
        {
            return "La sigla di questo stato è inesistente o non è presente, reinseriscile una nuova";
        }
        if(area.getNome().length() <= 2)
        {
            return "Nome dell'area troppo corto, reinseriscila";
        }
        if(this.area_trovata(area.getNome(), area.getId_stato()) == false)
        {
            return "Area non trovata, reinseriscila";
        }
        return "";
    }
    
    /**
     * Questo metodo controlla se nel centro è già stata inserita l'area di interesse
     * @param geocode geocode
     * @return valore booleano che dice se area già stata inserita o no
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized boolean area_gia_inserita(int geocode) throws SQLException, RemoteException
    { 
        r = statement.executeQuery(CodiceSQL.control_query_area[2]);
        while(r.next())
        {
            if(r.getInt("area") == geocode)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo che ritorna vero se viene trovata l'area di interesse inserita in quel determinato stato.
     * @param paese nome dell'area
     * @param sigla sigla dello stato
     * @return valore booleano che dice se area trovata o no
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    private synchronized boolean area_trovata(String paese, String sigla) throws SQLException
    {      
        String siglaMaiuscola = sigla.toUpperCase();
        r = statement.executeQuery(CodiceSQL.control_query_area[1]);
        while(r.next())
        {
            if(r.getString("nome_area").equals(paese) && r.getString("sigla_stato").equals(siglaMaiuscola))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo che ritorna vero se viene trovata la sigla dello stato inserito.
     * @param sigla sigla dello stato
     * @return valore booleano che dice se stato trovato o no
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    private synchronized boolean stato_presente(String sigla) throws SQLException
    {
        String siglaMaiuscola = sigla.toUpperCase();
        r = statement.executeQuery(CodiceSQL.control_query_area[0]);
        while(r.next())
        {
            if(r.getString("sigla_stato").equals(siglaMaiuscola))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Questo metodo è utilizzato per effettuare dei controlli sui valori inseriti dall'utente, in caso di errore viene ritornato il numero dell'errore.
     * @throws RemoteException eccezione per oggetti remoti
     * @return viene ritornato l'errore
     */
    @Override
    public synchronized String ritorna_errore_lat_long() throws RemoteException 
    {
        if(area.getLatitudine() < -90 ||  area.getLatitudine() > 90)
        {
            return "La latitudine che hai inserito non è corretta.\nDeve essere compresa tra -90 e 90, reinseriscila";
        }
        if(area.getLongitudine() < -180 || area.getLongitudine() > 180)
        {
            return "La longitudine che hai inserito non è corretta.\nDeve essere compresa tra -180 e 180, reinseriscila";
        }
        return "";
    }
    
    /**
     * Ricerca per coodinate vicine se non esiste la cordinata precisa
     * @return stringa con le aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized String ricerca_coordinate_avanzata()throws SQLException, RemoteException
    {
        String stringa="";
        double lim_lat1 = area.getLatitudine() - 0.15;
        double lim_lat2= area.getLatitudine() + 0.15; 
        double lim_long1 = area.getLongitudine() - 0.15;
        double lim_long2 =area.getLongitudine() + 0.15; 
        
        p = c.prepareStatement(CodiceSQL.select_query[6]);
        p.setDouble(1, lim_lat1);
        p.setDouble(2, lim_lat2);
        p.setDouble(3, lim_long1);
        p.setDouble(4, lim_long2);
        r = p.executeQuery();
        while(r.next())
        {
            stringa = stringa + r.getString("nome_area") + "%" + r.getString("sigla_stato") + "%" + r.getDouble("latitudine") + "%" + r.getDouble("longitudine") + "!";
        }
        return stringa;
        
    }
    
    /**
     * Questo metodo ritorna l'area con la coordinata è precisa.
     * @return stringa con le aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized String ricerca_coordinate() throws SQLException, RemoteException
    {
        String stringa = "";
        BigDecimal latitudine = new BigDecimal(area.getLatitudine()).setScale(5, RoundingMode.HALF_UP);
        BigDecimal longitudine = new BigDecimal(area.getLongitudine()).setScale(5, RoundingMode.HALF_UP);
        
        p = c.prepareStatement(CodiceSQL.select_query[5]);
        p.setBigDecimal(1, latitudine);
        p.setBigDecimal(2, longitudine);
        r = p.executeQuery();
        while(r.next())
        {
            stringa = stringa + r.getString("nome_area") + "%" + r.getString("sigla_stato") + "%" + r.getDouble("latitudine") + "%" + r.getDouble("longitudine") + "!";
        }
        return stringa;
    }
    
    /**
     * Questo metodo ritorna le aree che le aree che contengono quella stringa dello stato scelto.
     * @param str stringa da cercare
     * @param stato stato
     * @return stringa con le aree
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized String ricerca_nome(String str, String stato) throws SQLException, RemoteException
    {   
        String stringa="";
        p = c.prepareStatement(CodiceSQL.select_query[4]);
        p.setString(1, stato);
        p.setString(2, str);
        r = p.executeQuery();
        while(r.next())
        {
            stringa = stringa + r.getString("nome_area") + "%" + r.getString("sigla_stato") + "%" + r.getDouble("latitudine") + "%" + r.getDouble("longitudine") + "!";
        }
        return stringa;
    }  
    
    /**
     * Metodo che crea una lista con gli stati senza duplicati
     * @return Ritorno il result set della query di selezione degli stati
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public String lista_stati() throws SQLException, RemoteException
    { 
        String str="";
        r = statement.executeQuery(CodiceSQL.select_query[1]);
        while(r.next())
        {
            str = str + r.getString("sigla_stato") + "-" ;
        }
        return str;
    }
    
    /**
     * Data un'area di interesse ritorna il geocode
     * @param sigla sigla stato
     * @param nome nome area
     * @return geocode area
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti 
     */
    @Override
    public synchronized int recuperaGeocode(String sigla, String nome) throws SQLException, RemoteException
    {
        p = c.prepareStatement(CodiceSQL.select_query[2]);
        p.setString(1, sigla);
        p.setString(2, nome);
        r = p.executeQuery();
        while(r.next())
        {
            geocode = r.getInt("geocode");
        }
        return geocode;
    }

    /**
     * Metodo che setta oggetto di tipo area
     * @param a oggetto di tipo area
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public void setArea(AreaInteresse a) throws RemoteException{
        this.area = a;
    }
}
