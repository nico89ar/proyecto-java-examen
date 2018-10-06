----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.

select tipodoc, documento, nombre, apellido, legajo
from alumno
inner join persona
on alumno.idpersona = persona.identificador;

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente

select legajo, persona.nombre as nombre_alumno, apellido, carrera.nombre as nombre_carrera, fechainscripcion
from alumno inner join persona
on alumno.idpersona = persona.identificador
inner join inscripciones_carrera
on alumno.identificador = inscripciones_carrera.idalumno
inner join carrera
on carrera.identificador = inscripciones_carrera.idcarrera
order by legajo desc;

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso

select nombre_curso, carrera.nombre as nombre_carrera, cantidad_inscriptos, cupomaximo
from (
	select curso.idcarrera, curso.nombre as nombre_curso, cupomaximo, count(*) as cantidad_inscriptos
	from curso inner join inscripciones_curso
	on curso.identificador = inscripciones_curso.idcurso
	group by curso.identificador
) as temp
inner join carrera
on temp.idcarrera = carrera.identificador;


--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo

select nombre_curso, carrera.nombre as nombre_carrera, cantidad_inscriptos, cupomaximo
from (
	select curso.idcarrera, curso.nombre as nombre_curso, cupomaximo, count(*) as cantidad_inscriptos
	from curso inner join inscripciones_curso
	on curso.identificador = inscripciones_curso.idcurso
	group by curso.identificador
) as temp
inner join carrera
on temp.idcarrera = carrera.identificador
where cantidad_inscriptos > cupomaximo;

--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.

update curso
set cupomaximo = 10
where anio = 2018
and cupomaximo < 5;

--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual

update inscripciones_curso
set fechainscripcion = now()
from (
	select inscripciones_carrera.fechainscripcion as fecha_carrera
	from inscripciones_curso inner join inscripciones_carrera
	on inscripciones_curso.idalumno = inscripciones_carrera.idalumno
) as temp
where inscripciones_curso.fechainscripcion < fecha_carrera;

-- (Lo anterior no es SQL estándard. Sólo es válido para postgreSQL)

--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)

insert into persona
values (6,'DNI', 34795529, 'Nicolas', 'Balbuena', '1989-12-17');
 
insert into alumno
values (6,6, 17249);

--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.

alter table persona
add column
direccion varchar(200);
