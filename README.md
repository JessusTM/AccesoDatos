### Nombres: Benjamin Fernandez, Jesus Tapia

# scriptSQL

## BASE DE DATOS

DROP DATABASE IF EXISTS musica;
CREATE DATABASE musica;

## TABLAS

CREATE TABLE Casetes (
    idcasete SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL,
    anio_publicacion INTEGER,
    minutos BIGINT,
    material VARCHAR(255),
    tamanio BIGINT,
    precio BIGINT,
    stock INTEGER,
    fecha_registro DATE
);


CREATE TABLE Cds (
    idcd SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL,
    anio_publicacion INTEGER,
    minutos BIGINT,
    precio BIGINT,
    stock INTEGER,
    fecha_registro DATE
);

CREATE TABLE Vinilos (
    idvinilo SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL,
    peso BIGINT,
    tamanio BIGINT,
    descripcion TEXT,
    color VARCHAR(50),
    precio BIGINT,
    stock INTEGER,
    fecha_registro DATE
);

CREATE TABLE Ventas (
    idVenta SERIAL PRIMARY KEY,
    idProducto BIGINT NOT NULL,
    tipoProducto VARCHAR(255) NOT NULL,
    cantidad INTEGER NOT NULL,
    fechaVenta DATE NOT NULL
);

## INSERCION DE DATOS

INSERT INTO Casetes (nombre, artista, anio_publicacion, minutos, material, tamanio, precio, stock, fecha_registro)
VALUES 
('The College Dropout', 'Kanye West', 2004, 76, 'Plastic', 120, 2000, 5, '2024-06-24'),
('Blackwater Park', 'Opeth', 2001, 67, 'Plastic', 110, 1800, 7, '2024-06-24'),
('Mutter', 'Rammstein', 2001, 45, 'Plastic', 100, 1500, 10, '2024-06-24'),
('The Rise and Fall of Ziggy Stardust and the Spiders from Mars', 'David Bowie', 1972, 38, 'Plastic', 95, 1700, 6, '2024-06-24'),
('Blonde', 'Frank Ocean', 2016, 60, 'Plastic', 115, 2200, 8, '2024-06-24');

INSERT INTO Cds (nombre, artista, anio_publicacion, minutos, precio, stock, fecha_registro)
VALUES 
('My Beautiful Dark Twisted Fantasy', 'Kanye West', 2010, 68, 2500, 5, '2024-06-24'),
('Ghost Reveries', 'Opeth', 2005, 66, 2300, 4, '2024-06-24'),
('Sehnsucht', 'Rammstein', 1997, 49, 2000, 7, '2024-06-24'),
('Heroes', 'David Bowie', 1977, 40, 1900, 6, '2024-06-24'),
('Channel Orange', 'Frank Ocean', 2012, 62, 2400, 5, '2024-06-24');

INSERT INTO Vinilos (nombre, artista, peso, tamanio, descripcion, color, precio, stock, fecha_registro)
VALUES 
('808s & Heartbreak', 'Kanye West', 500, 12, 'Experimental album', 'Black', 3000, 3, '2024-06-24'),
('Still Life', 'Opeth', 450, 12, 'Progressive death metal album', 'Red', 3200, 4, '2024-06-24'),
('Liebe ist für alle da', 'Rammstein', 550, 12, 'Industrial metal album', 'White', 3500, 5, '2024-06-24'),
('Hunky Dory', 'David Bowie', 500, 12, 'Glam rock album', 'Blue', 2800, 6, '2024-06-24'),
('Endless', 'Frank Ocean', 450, 12, 'Visual album', 'Yellow', 3400, 4, '2024-06-24');
