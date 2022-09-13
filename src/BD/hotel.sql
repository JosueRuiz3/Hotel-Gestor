create database hotel;
use hotel;

CREATE TABLE IF NOT EXISTS cliente(
	id_cliente varchar(30),
	nombre varchar(80), 
	telefono varchar(30), 
	fecha_entrada varchar(30), 
	fecha_salida varchar(30), 
	numero_habitacion varchar(30),
	tarifa_estadia varchar(30),
	primary key (id_cliente)
);

 
CREATE TABLE IF NOT EXISTS habitacion(
	numero_habitacion varchar(30) ,
	numero_personas varchar(30),
	tarifa_estadia varchar(30), 
	disponible varchar(30),
	PRIMARY KEY (numero_habitacion)
);
 
CREATE TABLE IF NOT EXISTS reservaciones(
	numero_reservacion INT UNSIGNED AUTO_INCREMENT,
	id_cliente varchar(30),
	nombre varchar(80), 
	telefono varchar(30), 
	fecha_entrada varchar(30), 
	fecha_salida varchar(30),
	numero_habitacion varchar(30), 
	tarifa_estadia varchar(30),
	total_otroservicios varchar(30), 
	total_a_pagar varchar(30),
	PRIMARY KEY (numero_reservacion)
);

CREATE TABLE IF NOT EXISTS persona(
	id_cliente varchar(30),
	nombre varchar(80),
	telefono varchar(30),
	PRIMARY KEY(id_cliente)
);

insert into cliente VALUES ("5-0432-0608", "Andy Josue Ruiz Diaz", "6406-0470", "12/03/21", "14/03/21", 1, 200000);

insert into reservaciones VALUES (1,"5-0432-0608", "Andy Josue Ruiz Diaz", "6406-0470", "12/03/21", "14/03/21", 1, 200000,10000,210000);

insert into habitacion VALUES (1, 3, 200000, "NO DISPONIBLE");
insert into habitacion VALUES (2, 2, 150000, "DISPONIBLE");
insert into habitacion VALUES (3, 3, 200000, "DISPONIBLE");
insert into habitacion VALUES (4, 2, 150000, "DISPONIBLE");
insert into habitacion VALUES (5, 2, 150000, "DISPONIBLE");

insert into persona values("5-0432-0608", "Andy Josue Ruiz Diaz","64060470");




