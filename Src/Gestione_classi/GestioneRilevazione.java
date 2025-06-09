package Gestione_classi;

import Interfacce.InterfacciaRilevazione;
import Server.*;
import climatemonitoring.Rilevazione;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/**
 * Questa classe gestisce ed effettua le operazioni sull'oggetto di tipo rilevazione
 */
public class GestioneRilevazione extends UnicastRemoteObject implements InterfacciaRilevazione
{
    /**
     * Oggetto di tipo rilevazione.
     */
    private Rilevazione ril;
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
     * Array delle medie delle rilevazioni.
     */
    public double[] medie = new double[]{0, 0, 0, 0, 0, 0, 0};
    /**
     * Array dei massimi delle rilevazioni.
     */
    public int[] massimi = new int[]{0, 0, 0, 0, 0, 0, 0};
    /**
     * Array dei minimi delle rilevazioni.
     */
    public int[] minimi = new int[]{6, 6, 6, 6, 6, 6, 6};
    /**
     * Array delle mode delle rilevazioni.
     */
    public int[] mode = new int[]{0, 0, 0, 0, 0, 0, 0};
    /**
     * Array di nomi dei parametri climatici
     */
    public String[] parametro = new String[]{"vento","umidita","pressione","temperatura","precipitazioni","altitudine_ghiacciai", "massa_ghiacciai"};
    /**
     * Array di note dei nomi dei parametri climatici
     */
    public String[] note_parametro = new String[]{"note_vento","note_umidita","note_pressione","note_temperatura","note_precipitazioni","note_altitudine", "note_massa"};

    /**
     * Costruttore oggetto rilevazione
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti 
     */
    public GestioneRilevazione() throws SQLException, RemoteException
    {
        c = ConnessioneDatabase.getConnection();
        statement = ConnessioneDatabase.getStatement();
    }
    
    /**
     * Metodo che inserisce nel db le rilevazioni
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized void registra_rilevazione() throws SQLException, RemoteException
    {  
        p = c.prepareStatement(CodiceSQL.insert_query[3]);
        p.setString(1, ril.getCentro());
        p.setInt(2, ril.getArea());
        p.setTimestamp(3, ril.getData());
        p.setInt(4, ril.getVento());
        p.setString(5, ril.getNote()[0]);
        p.setInt(6, ril.getUmidita());
        p.setString(7, ril.getNote()[1]);
        p.setInt(8, ril.getPressione());
        p.setString(9, ril.getNote()[2]);
        p.setInt(10, ril.getTemperatura());
        p.setString(11, ril.getNote()[3]);
        p.setInt(12, ril.getPrecipitazioni());
        p.setString(13, ril.getNote()[4]);
        p.setInt(14, ril.getAltitudine_ghiacciai());
        p.setString(15, ril.getNote()[5]);
        p.setInt(16, ril.getMassa_ghiacciai());
        p.setString(17, ril.getNote()[6]);
        p.executeUpdate();
    }
    
    /**
     * Ritorna stringa delle rilevazioni
     * @param geocode geocode
     * @param i posizione
     * @return stringa che contiene i dati
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized String dati_tabella(int geocode, int i) throws SQLException, RemoteException
    {
        String str="";
        p = c.prepareStatement(CodiceSQL.parameters_query[4]);
        p.setString(1, parametro[i]);
        p.setString(2, note_parametro[i]);
        p.setInt(3, geocode);
        String tmp = p.toString();
        tmp = tmp.replace("'", "");
        r = statement.executeQuery(tmp);
        while(r.next())
        {
            str = str + r.getString("centro") + "%" + r.getString(parametro[i]) + "%" + r.getString(note_parametro[i]) + "%" + r.getTimestamp("data_ora") + "!";
        }
        return str;
    }
    
    /**
     * Questo metodo mette nell'array dei massimi la massima rilevazione di quell'area.
     * @param geocode geocode
     * @return array valori massimi
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized int[] trovaMassimo(int geocode) throws SQLException, RemoteException 
    {
        for(int i = 0; i < 7; i++)
        {
            p = c.prepareStatement(CodiceSQL.parameters_query[0]);
            p.setString(1, parametro[i]);
            p.setInt(2, geocode);
            String tmp = p.toString();
            tmp = tmp.replace("'", "");
            r = statement.executeQuery(tmp);
            while(r.next())
            {
                massimi[i] = r.getInt(1);
            }
        }
        return massimi;
    }
    
    /**
     * Questo metodo mette nell'array dei minimi la minima rilevazione di quell'area.
     * @param geocode geocode
     * @return array valori minimi
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized int[] trovaMinimo(int geocode) throws SQLException, RemoteException
    {
       for(int i = 0; i < 7; i++)
        {
            p = c.prepareStatement(CodiceSQL.parameters_query[1]);
            p.setString(1, parametro[i]);
            p.setInt(2, geocode);
            String tmp = p.toString();
            tmp = tmp.replace("'", "");
            r = statement.executeQuery(tmp);
            while(r.next())
            {
                minimi[i] = r.getInt(1);
            }
        }
        return minimi;
    }
    
    /**
     * Questo metodo mette nell'array la media di tutti i paramentri delle rilevazioni di quell'area.
     * @param geocode geocode
     * @return valori medi
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized double[] trovaMedie(int geocode) throws SQLException, RemoteException
    {
        for(int i = 0; i < 7; i++)
        {
            p = c.prepareStatement(CodiceSQL.parameters_query[2]);
            p.setString(1, parametro[i]);
            p.setInt(2, geocode);
            String tmp = p.toString();
            tmp = tmp.replace("'", "");
            r = statement.executeQuery(tmp);
            while(r.next())
            {
                medie[i] = r.getDouble(1);
            }
        }
        return medie;
    }
    
    /**
     * Questo metodo mette nell'array la moda di tutti i paramentri delle rilevazioni di quell'area.
     * @param geocode geocode
     * @return moda valori
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized int[] trovaMode(int geocode) throws SQLException, RemoteException
    {
        for(int i = 0; i < 7; i++)
        {
            p = c.prepareStatement(CodiceSQL.parameters_query[3]);
            p.setString(1, parametro[i]);
            p.setInt(2, geocode);
            p.setString(3, parametro[i]);
            String tmp = p.toString();
            tmp = tmp.replace("'", "");
            r = statement.executeQuery(tmp);
            while(r.next())
            {
                mode[i] = r.getInt(1);
            }
        }
        return mode;
    }
    
    /**
     * Questo metodo controlla se la nota inseritta è troppo lunga.
     * @param note[] vettore da reinizzializzare
     * @throws RemoteException eccezione per oggetti remoti
     * @return errore
     */
    @Override
    public synchronized String controlli_note(String[] note) throws  RemoteException
    {
        for(int i = 0; i < 7; i++)
        {
            if(note[i].length() > 256)
            {
                return parametro[i];
            }
        }
        return "";
    }
    
    /**
     * Metodo che setta oggetto di tipo rilevazione
     * @param r oggetto di tipo rilevazione
     * @throws RemoteException eccezione per oggetti remoti
     */
    @Override
    public synchronized void setRilevazione(Rilevazione r) throws RemoteException
    {
        this.ril=r;
    }
}
