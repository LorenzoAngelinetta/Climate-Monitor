# 🌍 Climate Monitor

**Climate Monitor** è un software per il monitoraggio delle temperature globali. Raccoglie e analizza dati provenienti da stazioni meteorologiche per supportare la ricerca scientifica e informare i cittadini sui cambiamenti climatici. L’applicazione è progettata per due tipi di utenti:

- Cittadini: possono accedere liberamente e consultare i dati climatici inserendo parametri di ricerca.
- Operatori: tramite registrazione e login, possono aggiornare il registro dati (oltre 141.000 località) inserendo nuove rilevazioni.

Una volta effettuato l’accesso, il sistema consente di visualizzare le temperature relative a un’area specifica tramite una semplice ricerca localizzata.

## 📁 CONTENUTO:

- `Server.jar` – File eseguibile per il server
- `Client.jar` – File eseguibile per il client
- `src/` – Codice sorgente suddiviso in:
  - `climateMonitoring/` – Main, classi Operatore, Centro, Area, 	Rilevazione
  - `Gestione_classi/` – Gestione delle istanze del programma
  - `Grafica/` – Componenti grafici con Java Swing
  - `Interfacce/` – Interfacce per implementazione RMI
  - `Server/` – Avvio server, connessione e query al DB
- `Temp/` – File `.txt` per l’inizializzazione del database
- `Doc/` – Manuale utente, manuale tecnico, UML ed ER
- `Icon/` – Immagini per l’interfaccia grafica

## ⚙️ STRUTTURA TECNICA

Il progetto adotta un’architettura **Client-Server**:
- I Client (operatori o cittadini) inviano richieste.
- Il Server elabora le richieste e restituisce i dati.

La comunicazione tra client e server è gestita tramite **Java RMI (Remote Method Invocation)**, che consente a oggetti Java su macchine diverse di interagire come se fossero locali.

## 🛠️ Tecnologie 

- **Linguaggi**: Java, SQL
- **Database**: PostgreSQL
- **Librerie**:  
  - `javax.swing` – Interfaccia grafica  
  - `java.io`, `java.util`, `java.sql` – Funzionalità di base  
  - `postgresql-42.7.1.jar` – Driver JDBC PostgreSQ per la connessione al database

## ✅ REQUISITI:

- Java JDK 17
- PostgreSQL v16
- Ambiente Windows (cartella `Temp` deve trovarsi in `C:\Temp\`)
- Libreria PostgreSQL  `postgresql-42.7.1.jar`

## ⚠️ LIMITAZIONI

- macOS: possibile disallineamento grafico (icone e bottoni).
- L'avvio tramite doppio clic su .jar può causare problemi nel trovare i file. Preferibile avviare da terminale.
- Simulazione client-server avviene sulla stessa macchina (non distribuito in rete).

## 🚀 Avvio del 

### 🔧 Avvio rapido (Windows)

1. Scarica il progetto.
2. Copia la cartella `Temp` in `C:\Temp\` (necessaria per l'inizializzazione del database).
3. Avvia il **server**, poi il **client** tramite terminale:
   java -jar Server.jar
   java -jar Client.jar

### 🍎 Avvio su macOS (procedura manuale)

Su macOS, il caricamento automatico del database potrebbe non funzionare (percorso file Temp è diverso da Windows). Esegui manualmente l'importazione dei dati tramite pgAdmin:

1. Aprire pgAdmin e seguire il percorso Server > localhost e inserire la password;
2. Aprire il percorso Database > db_climatemonitoring > Schemas > public > Tables;
3. Tasto destro sulla tabella da compilare (attenzione bisogna eseguire questa procedura su tutte le tabelle), selezionare Import/Export Data;
4. Selezionare Import, In File Name selezionare il percorso del file .txt relativo alla tabella che si sta compilando. Come format selezionare text e come encoding selezionare utf 8;
5. Una volta dato l’ok, se il programma risponde correttamente, procedere
con le tabelle mancanti fino a completare la compilazione.

NB. Ricordarsi di importare le tabelle nell'ordine corretto per non riscontrare problemi di integrità e vincoli. L’ordine corretto è il seguente: AreaInteresse , Operatore, CentroMonitoraggio, Parametri, Memorizza.
