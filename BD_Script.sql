/*
	BASE DE DATOS API HRS. Serv. Social
	Tabla 'Coordinadores'
*/
CREATE TABLE coordinadores (
	idCoordinador SERIAL NOT NULL,
	nombres TEXT NOT NULL,
	apellidoPaterno TEXT NOT NULL,
	apellidoMaterno TEXT NOT NULL,
	token TEXT NOT NULL,
	PRIMARY KEY (idCoordinador)
);
/*
	Tabla 'Dependecias'
*/
CREATE TABLE dependencias(
	idDependencia SERIAL NOT NULL,
	nombre TEXT NOT NULL,
	colonia TEXT NOT NULL,
	calle TEXT NOT NULL,
	numero INTEGER NOT NULL,
	nombreEncargado TEXT NOT NULL,
	apellidoPaternoEncargado TEXT NOT NULL,
	apellidoMaternoEncargado TEXT NOT NULL,
	correoEncargado TEXT NOT NULL,
	telefono TEXT NOT NULL,
	idCoordinador INTEGER NOT NULL,
	PRIMARY KEY (idDependencia)
);
/*
	Tabla 'Alumnos'
*/
CREATE TABLE alumnos (
	idAlumno SERIAL NOT NULL,
	nombres TEXT NOT NULL,
	apellidoPaterno TEXT NOT NULL,
	apellidoMaterno TEXT NOT NULL,
	matricula TEXT NOT NULL,
	correo TEXT NOT NULL,
	telefono TEXT NOT NULL,
	promedio DOUBLE NOT NULL,
	token TEXT NOT NULL,
	idDependencia INTEGER NOT NULL,
	idCoordinador NOT NULL,
	PRIMARY KEY (idAlumno)
);
/*
	Tabla 'Actividades'
*/
CREATE TABLE actividades (
	idActividad SERIAL NOT NULL,
	horas INTEGER NOT NULL,
	descripcion TEXT NOT NULL,
	fecha DATE NOT NULL,
	idAlumno NOT NULL,
	PRIMARY KEY (idActividad)
);
/*
	Relación: Coordinadores-Dependecias
*/
ALTER TABLE dependencias
ADD FOREIGN KEY (idCoordinador) REFERENCES coordinadores(idCoordinador);
/*
	Relación: Coordinadores-Alumnos
*/
ALTER TABLE alumnos
ADD FOREIGN KEY (idCoordinador) REFERENCES coordinadores(idCoordinador);
/*
	Relación: Dependencias-Alumnos
*/
ALTER TABLE alumnos
ADD FOREIGN KEY (idDependencia) REFERENCES dependencias(idDependencia);
/*
	Relación: Alumnos-Actividades
*/
ALTER TABLE actividades
ADD FOREIGN KEY (idAlumno) REFERENCES alumnos(idAlumno);