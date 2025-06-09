package Server;
/**
 * Questa classe contiene tutte le query che verranno effettuate per creare il db, le tabelle, inserire dati e interrogarlo
 */
public class CodiceSQL 
{
    /**
    * Query creazione del database
    */
    public static final String creazione_db = "CREATE DATABASE ";
    
    /**
    * Query creazione tabelle
    */
    public static final String query_creazione = "CREATE TABLE CoordinateMonitoraggio\n" +
                                "(\n" +
                                "	geocode INTEGER PRIMARY KEY,\n" +
                                "	nome_area VARCHAR (100) NOT NULL,\n" +
                                "	sigla_stato VARCHAR (2) NOT NULL, \n" +
                                "	latitudine DECIMAL(10,5) NOT NULL, \n" +
                                "	longitudine DECIMAL(10,5) NOT NULL\n" +
                                ");\n" +
                                "\n" +
                                "CREATE TABLE CentriMonitoraggio\n" +
                                "(\n" +
                                "	nome_centro VARCHAR (80) PRIMARY KEY,\n" +
                                "	via_piazza VARCHAR (30) NOT NULL,\n" +
                                "	numero_civico INTEGER NOT NULL,\n" +
                                "	cap VARCHAR (5) NOT NULL,\n" +
                                "	comune VARCHAR (40) NOT NULL,\n" +
                                "	provincia VARCHAR (20) NOT NULL\n" +
                                ");\n" +
                                "\n" +
                                "CREATE TABLE Memorizza\n" +
                                "(\n" +
                                "	centro varchar(80) REFERENCES CentriMonitoraggio (nome_centro) ON UPDATE CASCADE ON DELETE RESTRICT, \n" +
                                "	area INTEGER REFERENCES CoordinateMonitoraggio (geocode) ON UPDATE CASCADE ON DELETE RESTRICT, \n" +
                                "	PRIMARY KEY (centro, area)\n" +
                                ");\n" +
                                "\n" +
                                "CREATE TABLE OperatoriRegistrati\n" +
                                "(\n" +
                                "	nome VARCHAR (40) NOT NULL,\n" +
                                "	cognome VARCHAR (40) NOT NULL,\n" +
                                "	codice_fiscale VARCHAR (16) NOT NULL,\n" +
                                "	email VARCHAR (40)NOT NULL, \n" +
                                "	user_id NUMERIC (5) PRIMARY KEY,\n" +
                                "	password VARCHAR(8) NOT NULL,\n" +
                                "	centro VARCHAR(80) NULL,\n" +
                                "	FOREIGN KEY (centro) REFERENCES CentriMonitoraggio (nome_centro) ON UPDATE CASCADE ON DELETE RESTRICT\n" +
                                ");\n" +
                                "\n" +
                                "CREATE TABLE ParametriClimatici\n" +
                                "(\n" +
                                "	centro VARCHAR(80) REFERENCES CentriMonitoraggio (nome_centro) ON UPDATE CASCADE ON DELETE RESTRICT, \n" +
                                "  	area INTEGER REFERENCES CoordinateMonitoraggio (geocode) ON UPDATE CASCADE ON DELETE RESTRICT, \n" +
                                "	data_ora TIMESTAMP NOT NULL, \n" +
                                "	vento SMALLINT NOT NULL, \n" +
                                "	note_vento VARCHAR (256) DEFAULT ' ', \n" +
                                "	umidita SMALLINT NOT NULL, \n" +
                                "	note_umidita VARCHAR (256) DEFAULT ' ', \n" +
                                "	pressione SMALLINT NOT NULL, \n" +
                                "	note_pressione VARCHAR (256) DEFAULT ' ', \n" +
                                "	temperatura SMALLINT NOT NULL, \n" +
                                "	note_temperatura VARCHAR (256) DEFAULT ' ', \n" +
                                "	precipitazioni SMALLINT NOT NULL, \n" +
                                "	note_precipitazioni VARCHAR (256) DEFAULT ' ', \n" +
                                "	altitudine_ghiacciai SMALLINT NOT NULL, \n" +
                                "	note_altitudine VARCHAR (256) DEFAULT ' ', \n" +
                                "	massa_ghiacciai SMALLINT NOT NULL, \n" +
                                "	note_massa VARCHAR (256) DEFAULT ' ',\n" +
                                "	PRIMARY KEY (area, data_ora)\n" +
                                ");";
    
    /**
    * Array query di interrogazione
    */
    public static final String select_query[]=
    {
	"SELECT * FROM OperatoriRegistrati WHERE user_id = ? AND password = ?",
        "SELECT DISTINCT sigla_stato FROM CoordinateMonitoraggio ORDER BY sigla_stato ASC",
        "SELECT geocode FROM CoordinateMonitoraggio WHERE sigla_stato = ? AND nome_area = ?",
        "SELECT nome_area, sigla_stato FROM CoordinateMonitoraggio JOIN Memorizza ON geocode = area WHERE centro = ?",  
        "SELECT geocode, nome_area, sigla_stato, latitudine, longitudine FROM CoordinateMonitoraggio WHERE sigla_stato = ? AND nome_area LIKE ?", 
        "SELECT geocode, nome_area, sigla_stato, latitudine, longitudine FROM CoordinateMonitoraggio WHERE latitudine = ? AND longitudine = ?",
        "SELECT geocode, nome_area, sigla_stato, latitudine, longitudine FROM CoordinateMonitoraggio WHERE (latitudine >= ? AND latitudine <= ?) AND (longitudine >= ? AND longitudine <= ?)"
    };

    /**
    * Array query di inserimento
    */
    public static final String insert_query[]=
    {
	"INSERT INTO OperatoriRegistrati (nome, cognome, codice_fiscale, email, user_id, password, centro) VALUES (?,?,?,?,?,?,?)",
        "INSERT INTO CentriMonitoraggio (nome_centro, via_piazza, numero_civico, cap, comune, provincia) VALUES (?,?,?,?,?,?)",
        "INSERT INTO Memorizza (centro, area) VALUES (?,?)",
        "INSERT INTO ParametriClimatici (centro, area, data_ora, vento, note_vento, umidita, note_umidita, pressione, note_pressione, temperatura, note_temperatura, precipitazioni, note_precipitazioni, altitudine_ghiacciai, note_altitudine, massa_ghiacciai, note_massa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
    };
    
    /**
    * Array query su parametri climatici
    */
    public static final String parameters_query[]=
    {
	"SELECT MAX(?) FROM ParametriClimatici WHERE area = ?",
        "SELECT MIN(?) FROM ParametriClimatici WHERE area = ?",
        "SELECT ROUND(AVG(?), 2) FROM ParametriClimatici WHERE area = ?",
        "SELECT ? FROM ParametriClimatici WHERE area = ? GROUP BY ? ORDER BY COUNT(*) DESC LIMIT 1",
        "SELECT centro, ?, ?, data_ora FROM ParametriClimatici WHERE area = ?"
    };
    
    /**
    * Query di aggiornamento
    */
    public static final String update_query[]=
    {
	"UPDATE OperatoriRegistrati SET centro = ? WHERE user_id = ?"
    };
    
    /**
    * Array query su operatori
    */
    public static final String control_query_operatori[]=
    {
	"SELECT user_id FROM OperatoriRegistrati",
        "SELECT email FROM OperatoriRegistrati",
        "SELECT codice_fiscale FROM OperatoriRegistrati",
        "SELECT nome_centro FROM CentriMonitoraggio"
    };
    
    /**
    * Array query su centri 
    */
    public static final String control_query_centri[]=
    {
        "SELECT nome_centro FROM CentriMonitoraggio",
        "SELECT comune, provincia, via_piazza, numero_civico, cap FROM CentriMonitoraggio"
    };
    
    /**
    * Array query su aree di interesse
    */
    public static final String control_query_area[]=
    {
        "SELECT sigla_stato FROM CoordinateMonitoraggio",
        "SELECT nome_area, sigla_stato FROM CoordinateMonitoraggio",
        "SELECT area FROM Memorizza"
    };
}
