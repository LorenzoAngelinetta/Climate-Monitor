package Server;
 
import java.sql.*;

/**
 * Questa è la classe che gestisce la connessione al database.
 */
public class ConnessioneDatabase
{
    /**
     * URL che indica dove è situato il database.
     */  
    private static String URL;
    /**
     * Credenziale dell'username per effettuare la connessione al database.
     */
    private static String USERNAME;
    /**
     * Credenziale password per effettuare la connessione al database.
     */
    private static String PASSWORD;
    /**
     * Oggetto di tipo connessione (Connection)
     */
    private static Connection connection = null;
     /**
     * Oggetto di tipo Statement
     */
    private static Statement statement = null;
    /**
     * Costruttore, vuoto, della classe per effettuare una connessione al database
     */
    public ConnessioneDatabase(){}
    /**
     * Metodo utilizzato per inizializzare i dati con cui si effettuerà la connessione al database
     * @param ip ip della macchina server dove è situato il database
     * @param port port dove è sulla quale è situato il database
     * @param nome nome del database
     * @param username username con il quale si effettuerà la connessione al database
     * @param password password con la quale si effetuerà la connessione al database
     */
    public void inizializza_dati(String ip, String port, String nome, String username, String password)
    {
        URL = "jdbc:postgresql://" + ip + ":" + port + "/";
        USERNAME = username;
        PASSWORD = password;
    }        
   
    /**
     * Metodo che ritorna un oggetto di tipo connessione (Connection) utilizzando il pattern singleton per ritornare una singola istanza
     * @return connection oggetto di tipo connessione (Connection) ritornato utilizzando il pattern singleton
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public static Connection getConnection() throws SQLException
    {
        if(connection == null)
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
 
    /**
     * Metodo che chiude la connesione al database e lo statement, creando un altro oggetto di tipo (Connection) per una nuova connessione al database e altri due statemnt nuovi per utilizzare la nuova connessione che viene ritornata
     * @return connection Nuovo oggetto di tipo connessione (Connection) ritornato
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public static Connection modificaConnessione() throws SQLException
    {
        connection.close();
        connection = null;
        statement.close();
        statement = null;
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
        return connection;
    }  
 
    /**
     * Metodo che ritorna un oggetto di tipo Statement che serve per effettuare le interrogazioni/query al database
     * @return statement oggetto di tipo statement utilizzatto per effettuare le interrogazioni/query al database
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public static Statement getStatement() throws SQLException
    {
    if (statement == null)
        {
            connection = getConnection();
            statement = connection.createStatement();
    }
    return statement;
    }
 
    /**
     * Metodo Che serve per creare un nuovo URL per effettuare la connessione al database aggiungendone il nome del DB
     * @param s nome del database che verrà aggiunto alla Stringa contenente il precedente URL
     */
    public void setURL(String s)
    {
        URL = URL + s;
    }
 
    /**
     * Metodo che controlla se il database esiste già su postgres (vuol dire che è già stato creato in precedenza) ritornando un booleano
     * @param nome nome del database del quale si controlla l'esistenza o meno
     * @return ritorna true true se il database esiste già in caso contrario verrà ritornato false
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public boolean esiste_db(String nome) throws SQLException
    {
        String sql = "SELECT datname FROM pg_database WHERE datname = '" + nome + "'";
        ResultSet rs = statement.executeQuery(sql);
       
        while(rs.next())
        {
            return true;
        }
        return false;
    }
   
     /**
     * Metodo che serve per creare il database su postgres tramite l'apposita query
     * @param nome nome del database da creare
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public void crea_db(String nome) throws SQLException
    {
        statement.executeUpdate(CodiceSQL.creazione_db + nome);
    }
     
    /**
     * Metodo che sere alla creazione delle tabelle da inserire nel database su postgres tramite le apposite query
     * @throws SQLException eccezione che riguardano operazioni errate sul database
     */
    public void crea_tabelle() throws SQLException
    {
        statement.executeUpdate(CodiceSQL.query_creazione);
 
        String importa = "copy coordinatemonitoraggio (geocode, nome_area, sigla_stato, latitudine, longitudine) FROM 'C:\\Temp\\aree.txt' DELIMITER ';'";
        statement.execute(importa);
       
        importa = "copy centrimonitoraggio (nome_centro, via_piazza, numero_civico, cap, comune, provincia) FROM 'C:\\Temp\\centriM.txt' DELIMITER ';'";
        statement.execute(importa);
       
        importa = "copy operatoriregistrati (nome, cognome, codice_fiscale, email, user_id, password, centro)  FROM 'C:\\Temp\\op.txt' DELIMITER ';'";
        statement.execute(importa);
               
        importa = "copy memorizza (centro, area) FROM 'C:\\Temp\\memorizza.txt' DELIMITER ';'";
        statement.execute(importa);      
       
        importa = "copy parametriclimatici (centro, area, data_ora, vento, note_vento, umidita, note_umidita, pressione, note_pressione, temperatura, note_temperatura, precipitazioni, note_precipitazioni, altitudine_ghiacciai, note_altitudine, massa_ghiacciai, note_massa) FROM 'C:\\Temp\\parametri.txt' DELIMITER ';'";
        statement.execute(importa);
    }
}
 