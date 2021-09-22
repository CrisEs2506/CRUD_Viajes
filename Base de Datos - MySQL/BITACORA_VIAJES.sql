CREATE SCHEMA BITACORA_VIAJES;

USE BITACORA_VIAJES;

-- Creación de Tablas e Insercion de Datos

CREATE TABLE comandante
(
	cod_comandante int NOT NULL,
	nombre varchar(40) NOT NULL, 
	apellidos varchar(40) NOT NULL, 
	anio_servicio int NOT NULL, 
	escuela varchar(20) NOT NULL,
	fecha_ingreso date NOT NULL, 
	PRIMARY KEY(cod_comandante)
);

INSERT INTO comandante(cod_comandante, nombre, apellidos, anio_servicio, escuela, fecha_ingreso) 
VALUES (232, 'Jaime', 'Kirko', 20, 'Terrestre', '2001-12-12');
INSERT INTO comandante(cod_comandante, nombre, apellidos, anio_servicio, escuela, fecha_ingreso)
VALUES (9865, 'Espoc', 'Greison', 13, 'Crateriana', '2008-02-28');
INSERT INTO comandante(cod_comandante, nombre, apellidos, anio_servicio, escuela, fecha_ingreso) 
VALUES (22682, 'Leonardo', 'Macoy', 10, 'Terrestre', '2011-06-21');

CREATE TABLE expedicion
(
	cod_expedicion int NOT NULL,
    nombre varchar(30) NOT NULL,
    millas_recorridas decimal(8,2) DEFAULT 0,
    combustible_usado int,
    cod_comandante int NOT NULL,
    PRIMARY KEY(cod_expedicion),
    FOREIGN KEY(cod_comandante) REFERENCES comandante(cod_comandante)
);

INSERT INTO expedicion(cod_expedicion, nombre, millas_recorridas, combustible_usado, cod_comandante)
VALUES (12, 'Borde Exterior', 278323.8, 280982827, 232);

CREATE TABLE planeta
(
	cod_planeta int AUTO_INCREMENT,
    nombre varchar(30) NOT NULL,
    poblacion int DEFAULT 0,
    nivel_oxigeno decimal(3,1) DEFAULT 0.0,
    habitable int DEFAULT 0,
    PRIMARY KEY(cod_planeta)
);

INSERT INTO planeta(nombre, poblacion, habitable, nivel_oxigeno)
VALUES ("Tatuin", 1239494, 1, 88.9);

CREATE TABLE visita
(
	cod_visita int AUTO_INCREMENT,
    fecha_hora timestamp NOT NULL,
    cod_expedicion int NOT NULL,
    cod_planeta int NOT NULL,
    PRIMARY KEY(cod_visita),
    FOREIGN KEY(cod_expedicion) REFERENCES expedicion(cod_expedicion),
    FOREIGN KEY(cod_planeta) REFERENCES planeta(cod_planeta)
);

INSERT INTO visita(fecha_hora, cod_expedicion, cod_planeta)
VALUES ('2019-02-12 18:56:45', 12, 1);

INSERT INTO planeta(nombre, poblacion, habitable, nivel_oxigeno)
VALUES ('Croasant', 3942, 1, 74.3);

INSERT INTO visita(fecha_hora, cod_expedicion, cod_planeta)
VALUES (NOW(), 12, 2);

INSERT INTO expedicion(nombre, cod_expedicion, millas_recorridas, combustible_usado, cod_comandante)
VALUES ('Más allá del borde exterior', 872, 0, 0, 9865);

INSERT INTO planeta(nombre, nivel_oxigeno)
VALUES ('Mustafari', 0.1);

-- Actualizaciones

DELETE FROM comandante WHERE cod_comandante = 22682;

INSERT INTO visita(fecha_hora, cod_expedicion, cod_planeta)
VALUES (NOW(), 872, 3);

UPDATE expedicion SET millas_recorridas = 1240.2, combustible_usado = 2334
WHERE cod_expedicion = 872;

UPDATE planeta SET nivel_oxigeno = 0.01
WHERE cod_planeta = 3;

-- Consulta

SELECT 'Consulta 1';
SELECT * FROM comandante;

SELECT 'Consulta 2';
SELECT expedicion.cod_expedicion, expedicion.nombre, expedicion.millas_recorridas, expedicion.combustible_usado,
comandante.nombre, comandante.apellidos FROM expedicion
INNER JOIN comandante ON expedicion.cod_comandante = comandante.cod_comandante;

SELECT 'Consulta 3';
SELECT planeta.nombre, planeta.habitable, planeta.nivel_oxigeno,
expedicion.nombre FROM planeta INNER JOIN visita ON planeta.cod_planeta = visita.cod_planeta
INNER JOIN expedicion ON expedicion.cod_expedicion = visita.cod_expedicion
INNER JOIN comandante ON comandante.cod_comandante = expedicion.cod_comandante
WHERE comandante.nombre = 'Jaime' AND comandante.apellidos = 'Kirko'
ORDER BY planeta.nombre ASC;

SELECT 'Consulta 3';
SELECT planeta.nombre, planeta.habitable, planeta.nivel_oxigeno,
expedicion.nombre FROM planeta, visita, expedicion, comandante WHERE planeta.cod_planeta = visita.cod_planeta
AND expedicion.cod_expedicion = visita.cod_expedicion
AND comandante.cod_comandante = expedicion.cod_comandante
AND comandante.nombre = 'Jaime' AND comandante.apellidos = 'Kirko'
ORDER BY planeta.nombre ASC;