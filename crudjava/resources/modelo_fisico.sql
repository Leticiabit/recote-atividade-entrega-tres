/*Físico*/

CREATE database crud_atividade;

CREATE TABLE Cliente (
	nome varchar(50) NOT NULL,
    celular varchar(13),
    email varchar(30) NOT NULL,
    id_cliente int NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Destino (
	pais varchar(30) NOT NULL,
    cidade varchar(30) NOT NULL,
    valor float NOT NULL,
    id_destino int NOT NULL AUTO_INCREMENT PRIMARY KEY
);
   
CREATE TABLE Viagem (
	id_cliente int NOT NULL,
    id_destino int NOT NULL,
    datavoo varchar(10),
    datacompra varchar(10),
    id_viagem int NOT NULL AUTO_INCREMENT PRIMARY KEY
);

ALTER TABLE Viagem ADD CONSTRAINT FK_Viagem_1
	FOREIGN KEY(id_cliente)
    REFERENCES Cliente(id_cliente);
    
ALTER TABLE Viagem ADD CONSTRAINT FK_Viagem_2
	FOREIGN KEY(id_destino)
    REFERENCES Destino(id_destino);
