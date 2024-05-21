drop database if exists TallerMecanico;
create database  TallerMecanico;
use TallerMecanico;

create table usuario(
nombre varchar(50),
contrasenya varchar(50)
);

  CREATE TABLE Componentes (
    ID_Componente INT PRIMARY KEY,
    nombre VARCHAR(255),
modelo VARCHAR(255),
stock int,
    numero int
);



  CREATE TABLE Usuarios (
    ID_Usuarios INT PRIMARY KEY,
    Contraseña VARCHAR(50),
    Nombre VARCHAR(20),
    rol boolean
    );
    -- drop table Usuarios;
   
  CREATE TABLE Almacen (
    ID_Almacen INT PRIMARY KEY,
    comoponente VARCHAR(255),
    stock int
);
-- drop table Almacen;

 create table pertenecen (
ID_Componente int,
 ID_Almacen int,
 FOREIGN KEY (`ID_Componente`) REFERENCES `Componentes` (`ID_Componente`),
 FOREIGN KEY (`ID_Almacen`) REFERENCES `Almacen` (`ID_Almacen`),
  PRIMARY KEY (`ID_Componente`,`ID_Almacen`)
 );
 -- drop table pertenecen;
 
 CREATE TABLE Pedidos (
    IdPedido INT AUTO_INCREMENT PRIMARY KEY,
    nombreComponente VARCHAR(50),
    numero int
);

CREATE TABLE Averias (
  IdPedido INT PRIMARY KEY,
  NombreUsuario VARCHAR(50),
  Descripcion TEXT,
  Precio DECIMAL(10, 2)
);
CREATE TABLE componentes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    precio DECIMAL(10, 2),
    stock INT
);
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    averia_id INT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (averia_id) REFERENCES averias(id)
);
CREATE TABLE detalle_pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    componente_id INT,
    cantidad INT,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    FOREIGN KEY (componente_id) REFERENCES componentes(id)
);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (1, 'Batería', 'ACDelco 48AGM', 10, 150);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (2, 'Filtro de aceite', 'Bosch 3330', 20, 10);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (3, 'Bujías', 'NGK Iridium IX', 5, 25);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (4, 'Frenos delanteros', 'Brembo GT', 3, 300);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (5, 'Amortiguadores', 'KYB Excel-G', 8, 75);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (6, 'Correa de distribución', 'Contitech 4PK1395', 2, 120);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (7, 'Limpiaparabrisas', 'Bosch Aerotwin', 15, 20);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (8, 'Aceite de motor', 'Mobil 1 5W-30', 25, 40);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (9, 'Filtro de aire', 'K&N 33-2260', 12, 35);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (11, 'Filtro de combustible', 'Bosch 3322', 15, 20);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (12, 'Correa serpentina', 'Contitech 4PK1725', 7, 80);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (13, 'Sensor de oxígeno', 'Bosch 13970', 8, 70);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (14, 'Bomba de agua', 'Gates 42291', 4, 120);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (15, 'Filtro de aceite', 'Mann-Filter HU 816 X', 20, 15);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (16, 'Filtro de aire', 'K&N 33-2261', 10, 40);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (17, 'Bujías', 'Denso SK20R11', 12, 30);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (18, 'Frenos traseros', 'Brembo GT-R', 2, 350);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (19, 'Amortiguadores traseros', 'KYB Excel-G', 6, 80);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (20, 'Batería', 'Optima RedTop', 5, 200);

INSERT INTO Componentes (ID_Componente, nombre, modelo, stock, numero)
VALUES (10, 'Embrague', 'LUK 62009', 1, 500);

INSERT INTO Pedidos VALUES (69,'pedales',60);
INSERT INTO pedidos VALUES (70,'pedales','60');
INSERT INTO pedidos VALUES (71,'pedales','60');
INSERT INTO pedidos VALUES (72,'pedales','60');
INSERT INTO pedidos VALUES (73,'pedales','60');
INSERT INTO pedidos VALUES (74,'pedales','60');
INSERT INTO pedidos VALUES (75,'pedales','60');
INSERT INTO pedidos VALUES (76,'pedales','60');
INSERT INTO pedidos VALUES (77,'pedales','60');
INSERT INTO pedidos VALUES (78,'pedales','60');
INSERT INTO pedidos VALUES (79,'pedales','60');
INSERT INTO pedidos VALUES (80,'pedales','60');

INSERT INTO `Usuarios` VALUES (1,'Bujías','Paco',TRUE);
INSERT INTO `Usuarios` VALUES (2,'volante','Ester',TRUE);
INSERT INTO `Usuarios` VALUES (3,'pedales','Alberto',TRUE);
INSERT INTO `Usuarios` VALUES (4,'batería','Luis',TRUE);
INSERT INTO `Usuarios` VALUES (5,'embrague','Miguel',TRUE);
INSERT INTO `Usuarios` VALUES (6,'bomba de agua','Samanta',TRUE);

INSERT INTO `Almacen` VALUES (1,'volante',0);
INSERT INTO `Almacen` VALUES (2,'volante',0);
INSERT INTO `Almacen` VALUES (3,'volante',0);
INSERT INTO `Almacen` VALUES (4,'volante',0);
INSERT INTO `Almacen` VALUES (5,'volante',0);
INSERT INTO `Almacen` VALUES (6,'volante',0);
INSERT INTO `Almacen` VALUES (7,'volante',0);


INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (1, 'Juan Pérez', 'Cambio de aceite y filtro', 50.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (2, 'Ana Gómez', 'Reparación de frenos delanteros', 250.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (3, 'Carlos Rodríguez', 'Cambio de batería', 120.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (4, 'María Sánchez', 'Reparación de escape', 300.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (5, 'Pedro González', 'Cambio de neumáticos', 400.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (6, 'Laura Martínez', 'Reparación de embrague', 600.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (7, 'José Fernández', 'Cambio de correa de distribución', 200.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (8, 'Sara López', 'Reparación de parabrisas', 250.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (9, 'Luis Rodríguez', 'Cambio de filtro de aire', 30.00);

INSERT INTO Averias (IdPedido, NombreUsuario, Descripcion, Precio)
VALUES (10, 'Ana Martínez', 'Revisión general del vehículo', 100.00);

INSERT INTO pedidos (averia_id) VALUES (1);
INSERT INTO detalle_pedido (pedido_id, componente_id, cantidad) VALUES (1, 1, 5);






select *
from Pedidos
-- where ID_Componente = 1;
