CREATE TABLE CoordinateMonitoraggio
(
	id_area INTEGER PRIMARY KEY,
	nome_area VARCHAR (100) NOT NULL,
	sigla_stato VARCHAR (2) NOT NULL, 
	latitudine FLOAT NOT NULL, 
	longitudine FLOAT NOT NULL
);

CREATE TABLE CentriMonitoriaggio
(
	nome_centro VARCHAR (80) PRIMARY KEY,
	via_piazza VARCHAR (30) NOT NULL,
	numero_civico INTEGER NOT NULL,
	cap NUMERIC (5) NOT NULL,
	comune VARCHAR (40) NOT NULL,
	provincia VARCHAR (20) NOT NULL
);

CREATE TABLE Memorizza
(
	centro varchar(80) REFERENCES CentriMonitoriaggio (nome_centro) ON UPDATE CASCADE ON DELETE RESTRICT, 
	area INTEGER REFERENCES CoordinateMonitoraggio (id_area) ON UPDATE CASCADE ON DELETE RESTRICT, 
	PRIMARY KEY (centro, area)
);

CREATE TABLE OperatoriRegistrati
(
	nome VARCHAR (40) NOT NULL,
	cognome VARCHAR (40) NOT NULL,
	codice_fiscale VARCHAR (16) NOT NULL,
	email VARCHAR (40)NOT NULL, 
	user_id NUMERIC (5) PRIMARY KEY,
	password VARCHAR(8) NOT NULL,
	centro VARCHAR(80) NULL,
	FOREIGN KEY (centro) REFERENCES CentriMonitoriaggio (nome_centro) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE ParametriClimatici
(
	centro VARCHAR(80) REFERENCES CentriMonitoriaggio (nome_centro) ON UPDATE CASCADE ON DELETE RESTRICT, 
  	area INTEGER REFERENCES CoordinateMonitoraggio (id_area) ON UPDATE CASCADE ON DELETE RESTRICT, 
	data_ora TIMESTAMP NOT NULL, 
	vento SMALLINT NOT NULL, 
	note_vento VARCHAR (256) DEFAULT ' ', 
	umidita SMALLINT NOT NULL, 
	note_umidita VARCHAR (256) DEFAULT ' ', 
	pressione SMALLINT NOT NULL, 
	note_pressione VARCHAR (256) DEFAULT ' ', 
	temperatura SMALLINT NOT NULL, 
	note_temperatura VARCHAR (256) DEFAULT ' ', 
	precipitazioni SMALLINT NOT NULL, 
	note_precipitazioni VARCHAR (256) DEFAULT ' ', 
	altitudine_ghiacciai SMALLINT NOT NULL, 
	note_altitudine VARCHAR (256) DEFAULT ' ', 
	massa_ghiacciai SMALLINT NOT NULL, 
	note_massa VARCHAR (256) DEFAULT ' ',
	PRIMARY KEY (area, data_ora)
);