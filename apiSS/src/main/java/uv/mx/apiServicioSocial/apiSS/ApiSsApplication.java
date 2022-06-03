package uv.mx.apiServicioSocial.apiSS;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uv.mx.apiServicioSocial.apiSS.DB.Alumno;
import uv.mx.apiServicioSocial.apiSS.DB.Coordinador;
import uv.mx.apiServicioSocial.apiSS.DB.Dependencia;

@RestController
@SpringBootApplication
public class ApiSsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiSsApplication.class, args);
	}
	@RequestMapping(value="/coordinador/{token}", method=RequestMethod.GET)
	public String verCoordinador(@PathVariable String token){
		String response="Token no válido.";
		Coordinador c=Coordinador.getCoordinadorByToken(token);
		if(c!=null){
			response=c.toString();
		}
		return response;
	}
	//REST ALUMNOS
	//Get lista de alumnos
	@RequestMapping(value="/alumnos", method=RequestMethod.GET)
	public List<Alumno> verAlumnos(@RequestHeader String Authorization){
		List<Alumno>alumnos=null;
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		if(c!=null){
			alumnos=Alumno.getAlumnosByCoordinador(c.getIdCoordinador());
		}
		return alumnos;
	}
	/* Ejemplo de Body de las solicitudes PUT y POST
		{
			"idAlumno": 0,
			"nombres":"Omar Alejandro",
			"apellidoPaterno":"Alonso",
			"apellidoMaterno":"Lizardi",
			"matricula":"1234567890",
			"correo":"correo@correo.com",
			"token":"123456",
			"promedio": 6.5,
			"idCoordinador": 1,
			"idDependencia": 1,
			"telefono":"2288990088"
		}
	*/
	//Agregar alumno
	@PostMapping("/alumnos")
	public String registrarAlumnoPost(@RequestBody Alumno alumno, @RequestHeader String Authorization){
		String respuesta="Alumno "+alumno.getNombres()+" no registrado.";
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		if(c!=null){
			System.out.println("Token válido. Bienvenido coordinador "+c.getNombres());
			if(Alumno.registrarAlumno(alumno)){
				respuesta="Alumno "+alumno.getNombres()+" registrado.";
			}
		}else{
			respuesta="Token no válido.";
		}
		return respuesta;
	}
	//Actualizar token de alumno
	@PutMapping("/alumnos/{idAlumno}/actualizarToken")
	public String actualizarTokenPostAlumno(@PathVariable int idAlumno, @RequestHeader String Authorization){
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		String respuesta = "Token no actualizado";
		if(c!=null){
			if(Alumno.actualizarToken(idAlumno)){
				respuesta = "Token actualizado";
			}	
		}else{
			respuesta="Token no válido.";
		}
		return respuesta;
	}
	//Actualizar alumno
	@PutMapping("/alumnos/{idAlumno}/actualizar")
	public String actualizarAlumno(@RequestBody Alumno alumno, @PathVariable int idAlumno, @RequestHeader String Authorization){
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		String respuesta = "Alumno no actualizado";
		if(c!=null){
			alumno.setIdAlumno(idAlumno);
			if(Alumno.actualizarAlumno(alumno)){
				//Alumno.actualizarToken(idAlumno);
				respuesta="Alumno actualizado"; 
			}else{
				respuesta="Error en actualizar alumno";
			}	
		}else{
			respuesta="Token no válido";
		}
		return respuesta;
	}
	//Eliminar Alumno
	@DeleteMapping("/alumnos/{idAlumno}/eliminar")
	public String eliminarAlumno(@PathVariable int idAlumno, @RequestHeader String Authorization){
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		String respuesta = "Alumno no eliminado";
		if(c!=null){
			if(Alumno.eliminarAlumno(idAlumno)){
				respuesta="Alumno elminado"; 
			}else{
				respuesta="Error en eliminar alumno";
			}	
		}else{
			respuesta="Token no válido";
		}
		return respuesta;
	}
	//REST DEPENDENCIAS
	/* Ejemplo de Body de las solicitudes PUT y POST
		{
			"idDependencia": 2,
			"nombre": "Dependencia 100",
			"colonia": "Colonia 10",
			"calle": "Calle 10",
			"numero": 1,
			"nombreEncargado": "Nadia I.",
			"apellidoPaternoEncargado": "Bravo",
			"apellidoMaternoEncargado": "Guevara",
			"correoEncargado": "nadia@correos.com",
			"telefono": "22887766655",
			"idCoordinador": 1
		}
	*/
	//Agregar dependencia
	@PostMapping("/dependencias")
	public String registrarDependenciaPost(@RequestBody Dependencia dependencia, @RequestHeader String Authorization){
		String respuesta="Dependencia "+dependencia.getNombre()+" no registrado.";
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		if(c!=null){
			System.out.println("Token válido. Bienvenido coordinador "+c.getNombres());
			if(Dependencia.registrarDependencia(dependencia)){
				respuesta="Dependencia "+dependencia.getNombre()+" registrada.";
				System.out.println(dependencia.toString());
			}
		}else{
			respuesta="Token no válido.";
		}
		return respuesta;
	}
	
	//Eliminar dependencia
	@DeleteMapping("/dependencias/{idDependencia}/eliminar")
	public String eliminarDependencia(@PathVariable int idDependencia, @RequestHeader String Authorization){
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		String respuesta = "Dependencia no eliminada";
		if(c!=null){
			if(Dependencia.eliminarDependencia(idDependencia)){
				respuesta="Dependencia eliminada"; 
			}else{
				respuesta="Error en eliminar dependencia";
			}	
		}else{
			respuesta="Token no válido";
		}
		return respuesta;
	}
	
	//Actualizar dependencia
	@PutMapping("/dependencias/{idDependencia}/actualizar")
	public String actualizarDependencia(@RequestBody Dependencia dependencia, @PathVariable int idDependencia, @RequestHeader String Authorization){
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		String respuesta = "Dependencia no actualizada";
		if(c!=null){
			dependencia.setIdDependencia(idDependencia);
			if(Dependencia.actualizarDependencia(dependencia)){
				respuesta="Dependencia actualizada."; 
			}else{
				respuesta="Error al actualizar dependencia.";
			}	
		}else{
			respuesta="Token no válido";
		}
		return respuesta;
	}

	@RequestMapping(value="/dependencias", method=RequestMethod.GET)
	public List<Dependencia> verDependencias(@RequestHeader String Authorization){
		List<Dependencia>dependencias=null;
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		if(c!=null){
			dependencias=Dependencia.visualizarDependencias();
		}
		return dependencias;
	}

}
