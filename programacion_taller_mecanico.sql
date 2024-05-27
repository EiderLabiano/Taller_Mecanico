create database if not exists TallerMecanico;
use TallerMecanico;

CREATE TABLE Componentes (
                             ID_Componente INT AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(255),
                             modelo VARCHAR(255),
                             stock int,
                             precio int
);



CREATE TABLE Usuarios (
                          ID_Usuarios INT PRIMARY KEY,
                          Contraseña VARCHAR(50),
                          Nombre VARCHAR(20),
                          rol enum('Mecanico', 'Cliente', 'Recepcionista')
);

CREATE TABLE Almacen (
                         ID_Almacen INT PRIMARY KEY,
                         comoponente VARCHAR(255),
                         stock int
);

create table pertenecen (
                            ID_Componente int,
                            ID_Almacen int,
                            FOREIGN KEY (`ID_Componente`) REFERENCES `Componentes` (`ID_Componente`),
                            FOREIGN KEY (`ID_Almacen`) REFERENCES `Almacen` (`ID_Almacen`),
                            PRIMARY KEY (`ID_Componente`,`ID_Almacen`)
);

CREATE TABLE Pedidos (
                         IdPedido INT AUTO_INCREMENT PRIMARY KEY,
                         nombreComponente VARCHAR(50),numero int,
                         numeroComponentesPedidos int,
                         estadoPedidos enum('Entregado', 'Preparacion', 'Entregando')
);

CREATE TABLE Averias (
                         IdPedido INT PRIMARY KEY auto_increment,
                         NombreUsuario VARCHAR(50),
                         apellido varchar(50),
                         direccion varchar(200),
                         componente varchar(100),
                         Precio int
);
drop table pe;
create Table pe(
	id INT primary key auto_increment,
    NombreC Varchar(50),
    Cantidad int,
    Precio int
);
INSERT INTO Componentes (nombre, modelo, stock, precio) VALUES
                                                            ('Alternador', 'ALT1234', 15, 120),
                                                            ('Batería', 'BAT5678', 25, 80),
                                                            ('Pastillas de Freno', 'PFR91011', 50, 40),
                                                            ('Bujía', 'BUJ11213', 75, 15),
                                                            ('Filtro de Aceite', 'FIA1415', 100, 10),
                                                            ('Filtro de Aire', 'FIA1617', 80, 20),
                                                            ('Bomba de Combustible', 'BDC1819', 10, 200),
                                                            ('Radiador', 'RAD2021', 5, 150),
                                                            ('Correa de Distribución', 'CDD2223', 40, 60),
                                                            ('Faro', 'FAR2425', 30, 70),
                                                            ('Limpiaparabrisas', 'LMP2627', 90, 12),
                                                            ('Kit de Embrague', 'KDE2829', 20, 250),
                                                            ('Motor de Arranque', 'MDA3031', 8, 180),
                                                            ('Correa del Alternador', 'CDA3233', 35, 25),
                                                            ('Disco de Freno', 'DDF3435', 45, 100),
                                                            ('Turbo', 'TUR3637', 7, 300),
                                                            ('Tubo de Escape', 'TDE3839', 12, 90),
                                                            ('Rodamiento de Rueda', 'RRR4041', 25, 70),
                                                            ('Amortiguador', 'AMT4243', 20, 110),
                                                            ('Silenciador', 'SIL4445', 15, 130);

-- Inserts para Usuarios
INSERT INTO Usuarios (ID_Usuarios, Contraseña, Nombre, rol) VALUES
                                                                (1, 'pass123', 'Alicia', 'Mecanico'),
                                                                (2, 'pass124', 'Roberto', 'Cliente'),
                                                                (3, 'pass125', 'Carlos', 'Recepcionista'),
                                                                (4, 'pass126', 'David', 'Mecanico'),
                                                                (5, 'pass127', 'Eva', 'Cliente'),
                                                                (6, 'pass128', 'Francisco', 'Recepcionista'),
                                                                (7, 'pass129', 'Graciela', 'Mecanico'),
                                                                (8, 'pass130', 'Hilda', 'Cliente'),
                                                                (9, 'pass131', 'Iván', 'Recepcionista'),
                                                                (10, 'pass132', 'Judit', 'Mecanico'),
                                                                (11, 'pass133', 'Karl', 'Cliente'),
                                                                (12, 'pass134', 'Laura', 'Recepcionista'),
                                                                (13, 'pass135', 'Malena', 'Mecanico'),
                                                                (14, 'pass136', 'Ned', 'Cliente'),
                                                                (15, 'pass137', 'Oscar', 'Recepcionista'),
                                                                (16, 'pass138', 'Peggy', 'Mecanico'),
                                                                (17, 'pass139', 'Quinn', 'Cliente'),
                                                                (18, 'pass140', 'Ruperto', 'Recepcionista'),
                                                                (19, 'pass141', 'Sibila', 'Mecanico'),
                                                                (20, 'pass142', 'Trent', 'Cliente');

-- Inserts para Almacen
INSERT INTO Almacen (ID_Almacen, comoponente, stock) VALUES
                                                         (1, 'Alternador', 15),
                                                         (2, 'Batería', 25),
                                                         (3, 'Pastillas de Freno', 50),
                                                         (4, 'Bujía', 75),
                                                         (5, 'Filtro de Aceite', 100),
                                                         (6, 'Filtro de Aire', 80),
                                                         (7, 'Bomba de Combustible', 10),
                                                         (8, 'Radiador', 5),
                                                         (9, 'Correa de Distribución', 40),
                                                         (10, 'Faro', 30),
                                                         (11, 'Limpiaparabrisas', 90),
                                                         (12, 'Kit de Embrague', 20),
                                                         (13, 'Motor de Arranque', 8),
                                                         (14, 'Correa del Alternador', 35),
                                                         (15, 'Disco de Freno', 45),
                                                         (16, 'Turbo', 7),
                                                         (17, 'Tubo de Escape', 12),
                                                         (18, 'Rodamiento de Rueda', 25),
                                                         (19, 'Amortiguador', 20),
                                                         (20, 'Silenciador', 15);

-- Inserts para pertenecen
INSERT INTO pertenecen (ID_Componente, ID_Almacen) VALUES
                                                       (1, 1),
                                                       (2, 2),
                                                       (3, 3),
                                                       (4, 4),
                                                       (5, 5),
                                                       (6, 6),
                                                       (7, 7),
                                                       (8, 8),
                                                       (9, 9),
                                                       (10, 10),
                                                       (11, 11),
                                                       (12, 12),
                                                       (13, 13),
                                                       (14, 14),
                                                       (15, 15),
                                                       (16, 16),
                                                       (17, 17),
                                                       (18, 18),
                                                       (19, 19),
                                                       (20, 20);

-- Inserts para Pedidos
INSERT INTO Pedidos (nombreComponente, numero, numeroComponentesPedidos, estadoPedidos) VALUES
                                                                                            ('Alternador', 1, 5, 'Preparacion'),
                                                                                            ('Batería', 2, 10, 'Entregado'),
                                                                                            ('Pastillas de Freno', 3, 20, 'Entregando'),
                                                                                            ('Bujía', 4, 30, 'Entregado'),
                                                                                            ('Filtro de Aceite', 5, 50, 'Preparacion'),
                                                                                            ('Filtro de Aire', 6, 40, 'Entregando'),
                                                                                            ('Bomba de Combustible', 7, 3, 'Preparacion'),
                                                                                            ('Radiador', 8, 2, 'Entregado'),
                                                                                            ('Correa de Distribución', 9, 10, 'Entregando'),
                                                                                            ('Faro', 10, 8, 'Preparacion'),
                                                                                            ('Limpiaparabrisas', 11, 25, 'Entregado'),
                                                                                            ('Kit de Embrague', 12, 7, 'Entregando'),
                                                                                            ('Motor de Arranque', 13, 2, 'Preparacion'),
                                                                                            ('Correa del Alternador', 14, 12, 'Entregado'),
                                                                                            ('Disco de Freno', 15, 15, 'Entregando'),
                                                                                            ('Turbo', 16, 1, 'Preparacion'),
                                                                                            ('Tubo de Escape', 17, 5, 'Entregado'),
                                                                                            ('Rodamiento de Rueda', 18, 10, 'Entregando'),
                                                                                            ('Amortiguador', 19, 8, 'Preparacion'),
                                                                                            ('Silenciador', 20, 5, 'Entregado');
-- Inserts para Averias
INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio) VALUES
                                                                       (1, 'Alicia', 'Reemplazo de alternador', 150.00),
                                                                       (2, 'Roberto', 'Reemplazo de batería', 100.00),
                                                                       (3, 'Carlos', 'Reemplazo de pastillas de freno', 60.00),
                                                                       (4, 'David', 'Reemplazo de bujía', 25.00),
                                                                       (5, 'Eva', 'Cambio de filtro de aceite', 20.00),
                                                                       (6, 'Francisco', 'Cambio de filtro de aire', 25.00),
                                                                       (7, 'Graciela', 'Reparación de bomba de combustible', 250.00),
                                                                       (8, 'Hilda', 'Reemplazo de radiador', 180.00),
                                                                       (9, 'Iván', 'Cambio de correa de distribución', 100.00),
                                                                       (10, 'Judit', 'Reemplazo de faro', 90.00),
                                                                       (11, 'Karl', 'Reemplazo de limpiaparabrisas', 20.00),
                                                                       (12, 'Laura', 'Instalación de kit de embrague', 300.00),
                                                                       (13, 'Malena', 'Reparación de motor de arranque', 200.00),
                                                                       (14, 'Ned', 'Reemplazo de correa del alternador', 35.00),
                                                                       (15, 'Oscar', 'Reemplazo de disco de freno', 120.00),
                                                                       (16, 'Peggy', 'Instalación de turbo', 350.00),
                                                                       (17, 'Quinn', 'Reparación de tubo de escape', 100.00),
                                                                       (18, 'Ruperto', 'Reemplazo de rodamiento de rueda', 80.00),
                                                                       (19, 'Sibila', 'Reemplazo de amortiguador', 150.00),
                                                                       (20, 'Trent', 'Reparación de silenciador', 160.00);
